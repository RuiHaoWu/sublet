package com.wrh.sublet.user.api.body;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

/**
 * @author wrh
 * @date 2021/11/8
 */
@Data
public class SysLogBody {

    @ApiModelProperty(value = "日志类型 1错误日志 ")
    private Integer type;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "时间查询范围")
    private Long[] rangeTime;
}
