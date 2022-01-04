package com.wrh.sublet.user.api.entity;

import lombok.Data;

/**
 * 角色权限关联实体
 *
 * @author wrh
 * @date 2021/11/15
 */
@Data
public class RoleAuthorityRel {

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 权限id
     */
    private Integer authId;
}
