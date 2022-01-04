package com.wrh.sublet.user.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wrh.sublet.user.api.body.AuthorityBody;
import com.wrh.sublet.user.api.entity.Authority;



/**
 * 菜单服务类
 *
 * @author wrh
 * @date 2021/11/15
 */
public interface AuthorityService extends IService<Authority> {

    /**
     * 删除菜单
     *
     * @param id authId
     * @return 操作结果
     */
    Boolean deleteAuthority(Integer id);

    /**
     * 编辑菜单
     *
     * @param id            menuId
     * @param authorityBody body
     * @return 操作结果
     */
    Authority editAuthority(Integer id, AuthorityBody authorityBody);

    /**
     * 获取所有权限以树状返回
     *
     * @return 树状权限
     */
    Object getAuthorityTree();

    /**
     * 新增权限
     *
     * @param authorityBody 权限body
     * @return 操作结果
     */
    Boolean addAuthority(AuthorityBody authorityBody);


    /**
     * 获取菜单
     *
     * @param userId 用户id
     * @return 树状菜单
     */
    Object getUserMenu(String userId);


}
