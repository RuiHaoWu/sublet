package com.wrh.sublet.user.api.entity;

import lombok.Data;

/**
 * 用户角色关联实体
 *
 * @author wrh
 * @date 2021/11/15
 */
@Data
public class UserRoleRel {

    /**
     * 用户id
     */
    private String userId;

    /**
     * 角色id
     */
    private Integer roleId;

}
