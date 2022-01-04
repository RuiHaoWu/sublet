package com.wrh.sublet.post.api.vo;

import com.wrh.sublet.post.api.entity.Comment;
import com.wrh.sublet.post.api.entity.Label;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author wrh
 * @date 2021/10/22
 */
@Data
public class SubletInfoVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 转租信息id
     */
    private String id;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 月租 单位元
     */
    private Integer monthlyRent;

    /**
     * 地址
     */
    private String address;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 所在区
     */
    private String district;

    /**
     * 面积
     */
    private Double area;

    /**
     * 所在街道
     */
    private String street;

    /**
     * 发布人 用户id
     */
    private String userId;

    /**
     * 发布时间
     */
    private Long createTime;

    /**
     *  状态 转租/已转
     */
    private Integer status;

    /**
     * 图片
     */
    private String images;

    /**
     * 用户名
     */
    private String createBy;

    /**
     * 是否锁定不展示
     */
    private Integer lockFlag;

    /**
     * 标签列表
     */
    private List<Label> labelList;
}
