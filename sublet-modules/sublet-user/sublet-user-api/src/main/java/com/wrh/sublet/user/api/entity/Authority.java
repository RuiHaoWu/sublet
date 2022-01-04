package com.wrh.sublet.user.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.wrh.sublet.common.mybatis.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限
 *
 * @author wrh
 * @date 2021/11/12
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class Authority extends BaseEntity {

    /**
     * id
     */
    @TableId(value = "auth_id", type = IdType.AUTO)
    private Integer authId;

    /**
     * 权限名称
     */
    private String authName;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 菜单uri/路由地址
     */
    private String menuUri;

    /**
     * 父菜单id
     */
    private Integer pid;

    /**
     * 前端对应组件
     */
    private String component;

    /**
     * 排序值
     */
    private Integer sort;

    /**
     * 类型
     */
    private String type;

    /**
     * 删除标识（0-正常,1-删除）
     */
    @TableLogic
    private Integer delFlag;


}
