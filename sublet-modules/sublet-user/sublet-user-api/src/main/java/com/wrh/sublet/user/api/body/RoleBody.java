package com.wrh.sublet.user.api.body;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.constraints.NotBlank;

/**
 * @author wrh
 * @date 2021/11/15
 */
@Data
public class RoleBody {

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不允许为空", groups = {PostMapping.class, PutMapping.class})
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 角色描述
     */
    @Length(max = 125, message = "角色描述过长")
    @ApiModelProperty(value = "角色描述")
    private String roleDesc;


    /**
     * 角色标识
     */
    @NotBlank(message = "角色标识不允许为空", groups = {PostMapping.class, PutMapping.class})
    @ApiModelProperty(name = "角色标识")
    private String roleCode;


    /**
     * 权限id
     */
    @ApiModelProperty(value = "权限id 用逗号隔开")
    private Integer[] authorityIds;
}
