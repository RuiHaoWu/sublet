package com.wrh.sublet.user.api.body;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.constraints.NotBlank;

/**
 * @author wrh
 * @date 2021/11/17
 */
@Data
public class AuthorityBody {

    /**
     * 权限名称
     */
    @ApiModelProperty(value = "权限名称")
    @NotBlank(message = "权限名称不允许为空", groups = {PostMapping.class, PutMapping.class})
    private String authName;

    /**
     * 权限标识
     */
    @ApiModelProperty(value = "权限标识")
    @NotBlank(message = "权限标识不允许为空", groups = {PostMapping.class, PutMapping.class})
    private String permission;

    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    private String icon;

    /**
     * 菜单uri/路由地址
     */
    @ApiModelProperty(value = "菜单地址")
    private String menuUri;

    /**
     * 父权限id 根节点为-1
     */
    @ApiModelProperty(value = "父权限id 根节点为-1")
    private Integer pid;

    /**
     * 前端对应组件
     */
    @ApiModelProperty(value = "前端对应组件")
    private String component;

    /**
     * 排序值
     */
    @ApiModelProperty(value = "排序值")
    private Integer sort;

    /**
     * 类型
     */
    @ApiModelProperty(value = "权限类型 0菜单 1按钮")
    @NotBlank(message = "权限类型不允许为空", groups = {PostMapping.class, PutMapping.class})
    private String type;
}
