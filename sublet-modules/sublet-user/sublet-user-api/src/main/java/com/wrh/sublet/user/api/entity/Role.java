package com.wrh.sublet.user.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.wrh.sublet.common.mybatis.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * 角色实体类
 *
 * @author wrh
 * @date 2021/11/15
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity {

    /**
     * id
     */
    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;

    /**
     * 角色标识
     */
    private String roleCode;

    /**
     * 删除标识（0-正常,1-删除）
     */
    @TableLogic
    private Integer delFlag;
}
