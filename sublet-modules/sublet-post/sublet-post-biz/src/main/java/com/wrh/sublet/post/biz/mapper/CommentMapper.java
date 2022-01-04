package com.wrh.sublet.post.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wrh.sublet.post.api.dto.CommentUserDTO;
import com.wrh.sublet.post.api.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author wrh
 * @date 2021/10/25
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    /**
     * 获取某个帖子下的评论列表
     *
     * @param subletInfoId 帖子id
     * @return List<CommentUserDTO>
     */
    List<CommentUserDTO> getCommentListBySubletInfoId(String subletInfoId);
}
