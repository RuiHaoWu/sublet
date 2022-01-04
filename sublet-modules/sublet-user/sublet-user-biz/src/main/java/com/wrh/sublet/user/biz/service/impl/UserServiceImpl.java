package com.wrh.sublet.user.biz.service.impl;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrh.sublet.common.core.constants.CommonConstants;
import com.wrh.sublet.common.core.constants.enums.AuthTypeEnum;
import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.user.api.body.UserBody;
import com.wrh.sublet.user.api.dto.UserDTO;
import com.wrh.sublet.user.api.vo.UserInfo;
import com.wrh.sublet.user.api.entity.Authority;
import com.wrh.sublet.user.api.entity.Role;
import com.wrh.sublet.user.api.entity.User;
import com.wrh.sublet.user.biz.mapper.AuthorityMapper;
import com.wrh.sublet.user.biz.mapper.RoleMapper;
import com.wrh.sublet.user.biz.mapper.UserMapper;
import com.wrh.sublet.user.biz.service.AuthorityService;
import com.wrh.sublet.user.biz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author wrh
 * @date 2021/10/12
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private static final PasswordEncoder ENCODER = new BCryptPasswordEncoder();

    private final UserMapper userMapper;

    private final AuthorityService authorityService;

    private final RoleMapper roleMapper;

    private final AuthorityMapper authorityMapper;

    private final JavaMailSender javaMailSender;


    @Value("${sublet.mail.content}")
    private String mailContent;

    @Value("${spring.mail.username}")
    private String username;

    @Override
    public UserInfo getUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        if (Objects.isNull(user)) {
            throw new BizException("用户不存在！");
        }
        UserInfo userInfo = new UserInfo();
        UserDTO userDto = new UserDTO();
        BeanUtils.copyProperties(user, userDto);
        userInfo.setUserDto(userDto);
        userInfo.setUser(user);

        // 角色
        List<Role> roleList = roleMapper.listRolesByUserId(user.getUserId());
        List<Integer> roleIds = roleList.stream().map(Role::getRoleId).collect(Collectors.toList());
        Set<String> roleCode = roleList.stream().map(Role::getRoleCode).collect(Collectors.toSet());
        userInfo.setRoles(roleCode);

        // 权限
        if (roleIds.size() != 0) {
            Set<String> authorities = authorityMapper.listAuthoritiesByRoleId(CollUtil.join(roleIds, StrPool.COMMA)).stream()
                    .filter(authority -> AuthTypeEnum.BUTTON.getType().equals(authority.getType()))
                    .filter(authority -> StrUtil.isNotBlank(authority.getPermission()))
                    .map(Authority::getPermission)
                    .collect(Collectors.toSet());
            userInfo.setPermissions(authorities);
        } else {
            userInfo.setPermissions(new HashSet<>());
        }
        return userInfo;
    }

    @Override
    public UserInfo getUserInfo(String username) {
        UserInfo userInfo = this.getUserByUsername(username);
        userInfo.setUserDto(null);
        Object menu = authorityService.getUserMenu(userInfo.getUser().getUserId());
        userInfo.setMenus(menu);
        return userInfo;
    }

    @Override
    public User save(UserBody userBody) {

        User userByEmail = userMapper.findUserByEmail(userBody.getEmail());
        if (Objects.nonNull(userByEmail)) {
            throw new BizException("该邮箱已经被注册");
        }

        User userByUsername = userMapper.findUserByUsername(userBody.getUsername());
        if (Objects.nonNull(userByUsername)) {
            throw new BizException("该用户名已经存在");
        }

        User user = new User();
        BeanUtils.copyProperties(userBody, user);
        user.setCreateTime(System.currentTimeMillis());
        user.setPassword(ENCODER.encode(userBody.getPassword()));
        user.setDelFlag(CommonConstants.STATUS_NORMAL);
        user.setLockFlag(CommonConstants.STATUS_NORMAL);
        userMapper.insert(user);
        return user;
    }

    @Override
    public Boolean delete(String id) {
        User user = this.selectById(id);
        userMapper.deleteById(user);
        return Boolean.TRUE;
    }

    @Override
    public User editUserInfo(String id, UserBody userBody) {
        User userByEmail = userMapper.findUserByEmail(userBody.getEmail());
        if (Objects.nonNull(userByEmail) && !id.equals(userByEmail.getUserId())) {
            throw new BizException("该邮箱已经被注册");
        }

        User userByUsername = userMapper.findUserByUsername(userBody.getUsername());
        if (Objects.nonNull(userByUsername) && !id.equals(userByUsername.getUserId())) {
            throw new BizException("该用户名已经存在");
        }

        User user = this.selectById(id);
        BeanUtils.copyProperties(userBody, user);
        if (Objects.nonNull(userBody.getResetPass()) && userBody.getResetPass()) {
            if (!userBody.getDefaultPass()) {
                user.setPassword(ENCODER.encode(Base64.decodeStr(userBody.getPassword())));
            } else {
                user.setPassword(ENCODER.encode(CommonConstants.DEFAULT_PASSWORD));
            }
        }
        this.updateById(user);
        return user;
    }

    @Override
    public Boolean editLockStatus(String id) {
        User user = selectById(id);
        Integer lockFlag = user.getLockFlag().equals(CommonConstants.STATUS_NORMAL) ? CommonConstants.STATUS_LOCKED : CommonConstants.STATUS_NORMAL;
        user.setLockFlag(lockFlag);
        userMapper.updateById(user);
        return Boolean.TRUE;
    }

    @Override
    public void sendMail(String email) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setTo(email);
            mimeMessageHelper.setSubject("房转平台邮箱身份验证");
            String randomStr = RandomUtil.randomString(6);
            // todo 将验证码存到redis
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
            mimeMessageHelper.setText(String.format(mailContent, randomStr, timeFormatter.format(LocalDateTime.now())), true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            log.error("发送邮箱失败");
            throw new BizException("发送邮箱失败");
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object getUserPage(Page page, UserBody userBody) {

        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();

        wrapper.like(StrUtil.isNotBlank(userBody.getUsername()), User::getUsername, userBody.getUsername());

        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    public Boolean modifyPwd(String userId, UserBody userBody) {
        User user = this.selectById(userId);
        String originalPassword = Base64.decodeStr(userBody.getOriginalPassword());
        if (!ENCODER.matches(originalPassword, user.getPassword())) {
            throw new BizException("原始密码错误");
        }
        user.setPassword(ENCODER.encode(Base64.decodeStr(userBody.getPassword())));
        userMapper.updateById(user);
        return Boolean.TRUE;
    }


    @Override
    public User selectById(String userId) {
        User user = userMapper.selectById(userId);
        if (Objects.isNull(user)) {
            throw new BizException("用户不存在");
        }
        return user;
    }
}
