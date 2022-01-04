package com.wrh.sublet.user.api.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wrh
 * @date 2021/11/16
 */
@Data
public class UserVo {

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "角色id列 用逗号隔开")
    private Integer[] roleIds;
}
