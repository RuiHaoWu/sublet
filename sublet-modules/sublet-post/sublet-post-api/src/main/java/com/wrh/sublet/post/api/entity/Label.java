package com.wrh.sublet.post.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wrh.sublet.common.mybatis.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 标签
 * @author wrh
 * @date 2021/10/19
 */
@Data
public class Label extends BaseEntity {

    /**
     * id
     */
    @TableId(value = "label_id",type = IdType.AUTO)
    private Integer labelId;

    /**
     * 标签名称
     */
    private String labelName;

//    /**
//     * 标签状态
//     */
//    private Integer status;
}
