package com.wrh.sublet.post.api.body;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import javax.validation.constraints.NotBlank;

/**
 * @author wrh
 * @date 2021/12/15
 */
@Data
public class LabelBody {

    @ApiModelProperty(value = "标签名称")
    @NotBlank(message = "标签名称不允许为空", groups = {PostMapping.class, PutMapping.class})
    private String labelName;


    @ApiModelProperty(value = "时间范围查询")
    private Long[] rangeTime;
}
