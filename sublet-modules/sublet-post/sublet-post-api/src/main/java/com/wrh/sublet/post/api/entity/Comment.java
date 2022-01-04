package com.wrh.sublet.post.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.wrh.sublet.common.mybatis.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 评论表
 *
 * @author wrh
 * @date 2021/10/19
 */
@Data
public class Comment {

    /**
     * id
     */
    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 转租信息id
     */
    private String subletInfoId;

    /**
     * 作者id
     */
    private String userId;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 回复评论id
     */
    private Integer replyCommentId;


    /**
     * 删除标记 0-正常 1-删除
     */
    @TableLogic(value = "0", delval = "1")
    private Integer delFlag;


    /**
     * 创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Long createTime;

}
