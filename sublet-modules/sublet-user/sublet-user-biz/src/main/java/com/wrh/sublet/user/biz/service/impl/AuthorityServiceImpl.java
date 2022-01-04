package com.wrh.sublet.user.biz.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.text.StrPool;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrh.sublet.common.core.constants.CommonConstants;
import com.wrh.sublet.common.core.constants.enums.AuthTypeEnum;
import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.user.api.body.AuthorityBody;
import com.wrh.sublet.user.api.entity.Authority;
import com.wrh.sublet.user.api.entity.Role;
import com.wrh.sublet.user.api.entity.RoleAuthorityRel;
import com.wrh.sublet.user.biz.mapper.AuthorityMapper;
import com.wrh.sublet.user.biz.mapper.RoleAuthorityRelMapper;
import com.wrh.sublet.user.biz.mapper.RoleMapper;
import com.wrh.sublet.user.biz.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 权限服务实现类
 *
 * @author wrh
 * @date 2021/11/16
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements AuthorityService {

    private final AuthorityMapper authorityMapper;

    private final RoleAuthorityRelMapper roleAuthorityRelMapper;

    private final RoleMapper roleMapper;

    @Override
    public Object getAuthorityTree() {
        List<TreeNode<Integer>> collect = authorityMapper.selectList(Wrappers.<Authority>lambdaQuery().orderByAsc(Authority::getSort)).stream()
                .map(this.getTreeFunction()).collect(Collectors.toList());
        return TreeUtil.build(collect, CommonConstants.AUTHORITY_ROOT);
    }


    @Override
    public Boolean addAuthority(AuthorityBody authorityBody) {
        Authority authority = new Authority();
        BeanUtils.copyProperties(authorityBody, authority);
        authority.setDelFlag(CommonConstants.STATUS_NORMAL);
        return this.save(authority);
    }

    @Override
    public Object getUserMenu(String userId) {
        // 角色
        List<Integer> roleIds = roleMapper.listRolesByUserId(userId).stream().map(Role::getRoleId).collect(Collectors.toList());

        if (roleIds.size() == 0) {
            return null;
        }
        authorityMapper.listAuthoritiesByRoleId(CollUtil.join(roleIds, StrPool.COMMA)).forEach(System.out::println);

        // 菜单树
        List<TreeNode<Integer>> collect = authorityMapper.listAuthoritiesByRoleId(CollUtil.join(roleIds, StrPool.COMMA)).stream()
                .filter(authority -> AuthTypeEnum.LEFT_MENU.getType().equals(authority.getType()))
                .map(this.getTreeFunction())
                .collect(Collectors.toList());
        return TreeUtil.build(collect, CommonConstants.AUTHORITY_ROOT);
    }

    @Override
    public Boolean deleteAuthority(Integer id) {
        // 判断下是否有子权限
        List<Authority> authorityList = authorityMapper.selectList(Wrappers.<Authority>lambdaQuery().eq(Authority::getPid, id));
        if (CollUtil.isEmpty(authorityList)) {
            throw new BizException("该权限下有子权限,不允许删除");
        }
        // 删除角色关联该权限
        roleAuthorityRelMapper.delete(Wrappers.<RoleAuthorityRel>lambdaQuery().ge(RoleAuthorityRel::getAuthId, id));

        return this.removeById(id);
    }

    @Override
    public Authority editAuthority(Integer id, AuthorityBody authorityBody) {
        Authority authority = authorityMapper.selectById(id);
        if (Objects.isNull(authority)) {
            throw new BizException("该权限不存在");
        }
        BeanUtils.copyProperties(authorityBody, authority);
        this.updateById(authority);
        return authority;
    }

    private Function<Authority, TreeNode<Integer>> getTreeFunction() {
        return authority -> {
            TreeNode<Integer> node = new TreeNode<>();
            node.setId(authority.getAuthId());
            node.setName(authority.getAuthName());
            node.setParentId(authority.getPid());
            node.setWeight(authority.getSort());
            // 扩展属性
            Map<String, Object> extra = new HashMap<>();
            extra.put("icon", authority.getIcon());
            extra.put("menuUri", authority.getMenuUri());
            extra.put("type", authority.getType());
            extra.put("permission", authority.getPermission());
            extra.put("component", authority.getComponent());
            extra.put("sort", authority.getSort());
            extra.put("pid", authority.getPid());
            node.setExtra(extra);
            return node;
        };
    }
}
