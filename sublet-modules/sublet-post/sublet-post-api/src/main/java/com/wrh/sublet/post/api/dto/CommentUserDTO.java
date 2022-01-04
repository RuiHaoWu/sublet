package com.wrh.sublet.post.api.dto;

import com.wrh.sublet.user.api.entity.User;
import lombok.Data;

/**
 * 评论用户dto
 *
 * @author wrh
 * @date 2021/12/19
 */
@Data
public class CommentUserDTO {
    /**
     * id
     */
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
    private Integer delFlag;


    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 系统用户
     */
    private User user;
}
