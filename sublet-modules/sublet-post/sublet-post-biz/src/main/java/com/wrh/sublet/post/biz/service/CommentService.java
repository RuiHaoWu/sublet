package com.wrh.sublet.post.biz.service;

import com.wrh.sublet.post.api.body.CommentBody;
import com.wrh.sublet.post.api.entity.Comment;

/**
 * @author wrh
 * @date 2021/10/25
 */
public interface CommentService {

    /**
     * 添加评论
     *
     * @param commentBody 评论实体
     * @return 评论
     */
    Comment addComment(CommentBody commentBody);

    /**
     * 删除评论
     *
     * @param id 评论id
     * @return 操作结果
     */
    Boolean delComment(Integer id);

    /**
     * 根据sublet_info_id获取评论列表
     *
     * @param subletInfoId 帖子id
     * @return tree
     */
    Object getCommentsBySubletInfoId(String subletInfoId);

    /**
     * 删除自己的评论
     *
     * @param id 评论id
     * @param userId 用户id
     * @return 操作结果
     */
    Boolean delMyselfComment(Integer id, String userId);
}
