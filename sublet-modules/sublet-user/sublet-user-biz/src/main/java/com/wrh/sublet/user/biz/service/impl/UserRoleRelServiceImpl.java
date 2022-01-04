package com.wrh.sublet.user.biz.service.impl;

import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.ArrayUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrh.sublet.user.api.entity.Role;
import com.wrh.sublet.user.api.entity.UserRoleRel;
import com.wrh.sublet.user.api.vo.UserVo;
import com.wrh.sublet.user.biz.mapper.RoleMapper;
import com.wrh.sublet.user.biz.mapper.UserRoleRelMapper;
import com.wrh.sublet.user.biz.service.UserRoleRelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户角色关联服务实现类
 *
 * @author wrh
 * @date 2021/11/16
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserRoleRelServiceImpl extends ServiceImpl<UserRoleRelMapper, UserRoleRel> implements UserRoleRelService {

    private final UserRoleRelMapper userRoleRelMapper;
    private final RoleMapper roleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean assignRoleToUser(UserVo userVo) {
        // 删除旧的
        userRoleRelMapper.delete(Wrappers.<UserRoleRel>update().lambda().ge(UserRoleRel::getUserId, userVo.getUserId()));
        // 保存新的
        List<UserRoleRel> collect = Arrays.stream(userVo.getRoleIds()).map(roleId -> {
            UserRoleRel userRoleRel = new UserRoleRel();
            userRoleRel.setRoleId(roleId);
            userRoleRel.setUserId(userVo.getUserId());
            return userRoleRel;
        }).collect(Collectors.toList());
        return this.saveBatch(collect);
    }

    @Override
    public List<Role> getRoleListByUserId(String userId) {

        List<Integer> roleIds = userRoleRelMapper.selectList(Wrappers.<UserRoleRel>query().lambda().eq(UserRoleRel::getUserId, userId)).stream()
                .map(UserRoleRel::getRoleId)
                .collect(Collectors.toList());

        return  roleIds.size() == 0 ? null : roleMapper.selectList(Wrappers.<Role>query().lambda().in(Role::getRoleId, roleIds));
    }
}
