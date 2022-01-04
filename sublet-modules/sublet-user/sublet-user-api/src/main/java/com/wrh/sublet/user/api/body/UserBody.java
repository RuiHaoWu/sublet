package com.wrh.sublet.user.api.body;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author wrh
 * @date 2021/10/12
 */
@Data
public class UserBody {

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不允许为空",groups = {PostMapping.class})
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
    @NotBlank(message = "密码不允许为空",groups = {PostMapping.class})
    @ApiModelProperty(value = "密码")
    private String password;


    /**
     * 邮箱
     */
    @Pattern(regexp = "^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+(cn|com)$",message = "请输入正确的邮箱")
    @ApiModelProperty(value = "邮箱")
    @NotBlank(message = "邮箱不允许为空",groups = {MailValid.class})
    private String email;


    /**
     * 旧密码
     */
    @ApiModelProperty(value = "旧密码")
    private String originalPassword;


    /**
     * 修改密码
     */
    @ApiModelProperty(value = "默认密码")
    private Boolean resetPass;

    /**
     * 默认密码
     */
    @ApiModelProperty(value = "默认密码")
    private Boolean defaultPass;


    public interface MailValid{}
}
