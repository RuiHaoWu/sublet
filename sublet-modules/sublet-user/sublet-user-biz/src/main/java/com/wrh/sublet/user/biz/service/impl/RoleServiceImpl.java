package com.wrh.sublet.user.biz.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wrh.sublet.common.core.constants.CommonConstants;
import com.wrh.sublet.user.api.body.RoleBody;
import com.wrh.sublet.user.api.entity.Role;
import com.wrh.sublet.user.biz.mapper.RoleMapper;
import com.wrh.sublet.user.biz.service.RoleAuthorityRelService;
import com.wrh.sublet.user.biz.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * 角色服务实现类
 *
 * @author wrh
 * @date 2021/11/16
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    private final RoleMapper roleMapper;

    private final RoleAuthorityRelService roleAuthorityRelService;

    @Override
    public Object getRolePage(Page page,RoleBody roleBody) {
        LambdaQueryWrapper<Role> wrapper = Wrappers.lambdaQuery();

        wrapper.like(StrUtil.isNotBlank(roleBody.getRoleCode()), Role::getRoleCode, roleBody.getRoleCode());
        wrapper.like(StrUtil.isNotBlank(roleBody.getRoleName()), Role::getRoleName, roleBody.getRoleName());
        return baseMapper.selectPage(page, wrapper);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addRole(RoleBody roleBody) {
        Role role = new Role();
        role.setRoleName(roleBody.getRoleName());
        role.setRoleDesc(roleBody.getRoleDesc());
        role.setRoleCode(roleBody.getRoleCode());
        role.setDelFlag(CommonConstants.STATUS_NORMAL);
        roleMapper.insert(role);

        // 设置角色权限
        roleAuthorityRelService.setRoleAuthority(role.getRoleId(), roleBody.getAuthorityIds());

        return Boolean.TRUE;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean editRole(Integer id, RoleBody roleBody) {
        Role role = new Role();
        role.setRoleId(id);
        role.setRoleName(roleBody.getRoleName());
        role.setRoleDesc(roleBody.getRoleDesc());
        role.setRoleCode(roleBody.getRoleCode());
        roleMapper.updateById(role);

        // 删除原来的权限
        roleAuthorityRelService.delRoleAuthority(id);

        // 设置新的角色权限
        roleAuthorityRelService.setRoleAuthority(id, roleBody.getAuthorityIds());

        return Boolean.TRUE;
    }

    @Override
    public Boolean deleteRole(Integer id) {
        roleAuthorityRelService.delRoleAuthority(id);
        return this.removeById(id);
    }
}
