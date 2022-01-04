package com.wrh.sublet.user.biz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wrh.sublet.user.api.body.RoleBody;
import com.wrh.sublet.user.api.entity.Role;


/**
 * @author wrh
 * @date 2021/11/15
 */
public interface RoleService extends IService<Role> {

    /**
     * 分页查询
     *
     * @param page 分页参数
     * @param roleBody 查询参数
     * @return 分页结果
     */
    Object getRolePage(Page page,RoleBody roleBody);


    /**
     * 新增角色
     *
     * @param roleBody body
     * @return 操作结果
     */
    Boolean addRole(RoleBody roleBody);


    /**
     * 编辑角色
     *
     * @param id       roleId
     * @param roleBody body
     * @return 操作结果
     */
    Boolean editRole(Integer id, RoleBody roleBody);

    /**
     * 删除角色
     *
     * @param id roleId
     * @return 操作结果
     */
    Boolean deleteRole(Integer id);
}
