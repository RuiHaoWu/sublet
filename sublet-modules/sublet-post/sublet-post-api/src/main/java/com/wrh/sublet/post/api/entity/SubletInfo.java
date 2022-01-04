package com.wrh.sublet.post.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wrh.sublet.common.mybatis.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * 转租信息
 *
 * @author wrh
 * @date 2021/10/19
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubletInfo extends BaseEntity {

    /**
     * 转租信息id
     */
    @TableId(value = "sublet_info_id", type = IdType.ASSIGN_UUID)
    private String subletInfoId;

    /**
     * 描述信息
     */
    private String description;

    /**
     * 月租 单位元
     */
    private BigDecimal monthlyRent;

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
     * 所在街道
     */
    private String street;

    /**
     * 面积
     */
    private Double area;

    /**
     * 用户id
     */
    private String userId;


    /**
     *  状态 转租/已转
     */
    private Integer status;

    /**
     * 是否锁定不展示
     */
    private Integer lockFlag;

    /**
     * 图片
     */
    private String images;



    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;
}
