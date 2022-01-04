package com.wrh.sublet.user.biz.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wrh.sublet.user.api.entity.Role;
import com.wrh.sublet.user.api.entity.UserRoleRel;
import com.wrh.sublet.user.api.vo.UserVo;

import java.util.List;

/**
 * 用户角色关联服务类
 *
 * @author wrh
 * @date 2021/11/16
 */
public interface UserRoleRelService extends IService<UserRoleRel> {

    /**
     * 给用户分配角色
     *
     * @param userVo vo
     * @return 操作结果
     */
    Boolean assignRoleToUser(UserVo userVo);


    /**
     * 根据用户id查询拥有的权限
     *
     * @param userId 用户id
     * @return roleList
     */
    List<Role> getRoleListByUserId(String userId);
}
