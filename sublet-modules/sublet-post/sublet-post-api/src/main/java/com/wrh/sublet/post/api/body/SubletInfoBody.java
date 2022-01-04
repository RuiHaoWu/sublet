package com.wrh.sublet.post.api.body;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author DM
 */
@Data
public class SubletInfoBody {

    /**
     * 描述信息
     */
    @ApiModelProperty(value = "描述信息")
    @NotBlank(message = "描述信息不允许为空", groups = {PostMapping.class})
    private String description;

    /**
     * 月租 单位元
     */
    @ApiModelProperty(value = "月租 单位元")
    @NotNull(message = "月租不允许为空", groups = {PostMapping.class})
    private BigDecimal monthlyRent;

    /**
     * 面积
     */
    @ApiModelProperty(value = "面积")
    @NotNull(message = "面积不允许为空", groups = {PostMapping.class})
    private Double area;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址")
    @NotBlank(message = "详细地址不允许为空", groups = {PostMapping.class})
    private String address;

    /**
     * 所在省份
     */
    @ApiModelProperty(value = "所在省份")
    @NotBlank(message = "所在省份不允许为空", groups = {PostMapping.class})
    private String province;

    /**
     * 所在城市
     */
    @ApiModelProperty(value = "所在城市")
    @NotBlank(message = "所在城市不允许为空", groups = {PostMapping.class})
    private String city;

    /**
     * 所在区
     */
    @ApiModelProperty(value = "所在区")
    @NotBlank(message = "所在区不允许为空", groups = {PostMapping.class})
    private String district;

    /**
     * 所在街道
     */
    @ApiModelProperty(value = "所在街道")
    @NotBlank(message = "所在街道不允许为空", groups = {PostMapping.class})
    private String street;

    /**
     * 图片地址
     */
    @ApiModelProperty(value = "图片地址")
    private String[] images;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签")
    private List<Integer> labels;

    /**
     * 查询条件 最低价
     */
    @ApiModelProperty(value = "最低价")
    private Integer priceMin;

    /**
     * 查询条件 最高价
     */
    @ApiModelProperty(value = "最高价")
    private Integer priceMax;

    /**
     * 查询条件 开始时间 - 结束时间
     */
    @ApiModelProperty(value = "开始时间")
    private Long[] rangeTime;



    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private String createBy;

}
