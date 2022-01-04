package com.wrh.sublet.auth.body;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotBlank;

/**
 * @author wrh
 * @date 2021/11/30
 */
@Data
public class AuthBody {

    @ApiModelProperty(value = "验证码id")
    private String vt;

    @ApiModelProperty(value = "验证码")
    private String vc;

    @ApiModelProperty(value = "用户名")
    private String ia;

    @ApiModelProperty(value = "密码")
    private String ip;

    @ApiModelProperty(value = "刷新token")
    private String refreshToken;

    @ApiModelProperty(value = "授权码")
    private String code;

    @ApiModelProperty(value = "重定向地址")
    private String redirectUri;
}
