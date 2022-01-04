package com.wrh.sublet.post.biz.service.impl;

import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeUtil;
import cn.hutool.core.text.StrPool;
import com.wrh.sublet.common.core.constants.CacheConstants;
import com.wrh.sublet.common.core.constants.CommonConstants;
import com.wrh.sublet.common.core.exception.BizException;
import com.wrh.sublet.common.redis.service.RedisService;
import com.wrh.sublet.common.security.utils.SecurityUtils;
import com.wrh.sublet.post.api.body.CommentBody;
import com.wrh.sublet.post.api.entity.Comment;
import com.wrh.sublet.post.biz.mapper.CommentMapper;
import com.wrh.sublet.post.biz.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author wrh
 * @date 2021/10/25
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final RedisService redisService;

    @Override
    public Comment addComment(CommentBody commentBody) {
        String userId = SecurityUtils.getUser().getUserId();
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentBody, comment);
        comment.setUserId(userId);
        comment.setDelFlag(CommonConstants.STATUS_NORMAL);
        if (Objects.isNull(commentBody.getPid())) {
            comment.setPid(CommonConstants.COMMENT_ROOT);
        }
        commentMapper.insert(comment);
        // 删除缓存
        redisService.deleteObject(String.format("%s::%s",CacheConstants.COMMENT_BY_SUBLET_INFO_ID,comment.getSubletInfoId()));
        return comment;
    }

    @Override
    public Boolean delComment(Integer id) {
        Comment comment = this.getCommentById(id);
        commentMapper.deleteById(comment);
        // 删除缓存
        redisService.deleteObject(String.format("%s::%s",CacheConstants.COMMENT_BY_SUBLET_INFO_ID,comment.getSubletInfoId()));
        return Boolean.TRUE;
    }

    @Override
    @Cacheable(value = CacheConstants.COMMENT_BY_SUBLET_INFO_ID, key = "#subletInfoId")
    public Object getCommentsBySubletInfoId(String subletInfoId) {

        List<TreeNode<Integer>> collect = commentMapper.getCommentListBySubletInfoId(subletInfoId).stream()
                .map(comment -> {
                    TreeNode<Integer> node = new TreeNode<>();
                    node.setId(comment.getCommentId());
                    node.setName(comment.getContent());
                    node.setParentId(comment.getPid());
                    node.setWeight(comment.getCreateTime());
                    // 扩展属性
                    Map<String, Object> extra = new HashMap<>(16);
                    extra.put("commentId", comment.getCommentId());
                    extra.put("content", comment.getContent());
                    extra.put("subletInfoId", comment.getSubletInfoId());
                    extra.put("userId", comment.getUserId());
                    extra.put("replyCommentId", comment.getReplyCommentId());
                    extra.put("createTime", comment.getCreateTime());
                    extra.put("username", comment.getCreateBy());
                    extra.put("user", comment.getUser());
                    if (Objects.nonNull(comment.getReplyCommentId())) {
                        Comment commentById = this.getCommentById(comment.getReplyCommentId());
                        extra.put("replyUserId", commentById.getUserId());
                        extra.put("replyUsername", commentById.getCreateBy());
                    }
                    node.setExtra(extra);
                    return node;
                }).collect(Collectors.toList());
        return TreeUtil.build(collect, CommonConstants.COMMENT_ROOT);
    }

    @Override
    public Boolean delMyselfComment(Integer id, String userId) {
        Comment comment = this.getCommentById(id);
        if (!userId.equals(comment.getUserId())) {
            throw new BizException("仅允许删除自己的评论");
        }
        commentMapper.deleteById(comment);
        // 删除缓存
        redisService.deleteObject(String.format("%s::%s",CacheConstants.COMMENT_BY_SUBLET_INFO_ID,comment.getSubletInfoId()));
        return Boolean.TRUE;
    }

    private Comment getCommentById(Integer id) {
        Comment comment = commentMapper.selectById(id);
        if (Objects.isNull(comment)) {
            throw new BizException("请检查id是否有误");
        }
        return comment;
    }
}
