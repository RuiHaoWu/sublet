package com.wrh.sublet.user.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.wrh.sublet.common.mybatis.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * @author wrh
 * @date 2021/10/11
 * 前台用户
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class User extends BaseEntity {

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String username;

    /**
     * 用户头像
     */
    @ApiModelProperty(value = "用户头像")
    private String avatar;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @JsonIgnore
    private String password;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;


    /**
     * 最后一次登录时间
     */
    @ApiModelProperty(value = "最后一次登录时间")
    private Long lastLoginTime;


    /**
     * 锁定标志 0-正常 1-锁定
     */
    @ApiModelProperty(value = "锁定标志 0-正常 1-锁定")
    private Integer lockFlag;

    /**
     * 删除标记 0-正常 1-删除
     */
    @TableLogic(value = "0", delval = "1")
    @TableField(fill = FieldFill.INSERT)
    @ApiModelProperty(value = "删除标记 0-正常 1-删除")
    private Integer delFlag;

}
