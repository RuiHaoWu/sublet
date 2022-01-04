package com.wrh.sublet.user.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wrh.sublet.user.api.entity.Authority;
import com.wrh.sublet.user.api.entity.RoleAuthorityRel;

import java.util.List;

/**
 * 角色权限关联服务类
 *
 * @author wrh
 * @date 2021/11/16
 */
public interface RoleAuthorityRelService extends IService<RoleAuthorityRel> {

    /**
     * 设置角色权限
     *
     * @param roleId       角色id
     * @param authorityIds 权限id列 逗号隔开
     */
    void setRoleAuthority(Integer roleId, Integer[] authorityIds);


    /**
     * 删除角色下绑定的权限
     *
     * @param roleId 角色id
     */
    void delRoleAuthority(Integer roleId);


    /**
     * 获取角色所拥有的角色
     *
     * @param roleId 角色id
     * @return 权限列表
     */
    List<Authority> getAuthorityListByRoleId(Integer roleId);
}
