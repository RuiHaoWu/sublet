package com.wrh.sublet.post.biz.rest;

import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.log.annotation.SysLog;
import com.wrh.sublet.common.security.utils.SecurityUtils;
import com.wrh.sublet.common.web.base.BaseController;
import com.wrh.sublet.post.api.body.CommentBody;
import com.wrh.sublet.post.api.entity.Comment;
import com.wrh.sublet.post.biz.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;

/**
 * @author wrh
 * @date 2021/10/25
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
@Api(value = "comment", tags = "评论管理")
public class CommentRest implements BaseController {

    private final CommentService commentService;

    @GetMapping("/{subletInfoId}")
    @ApiOperation(value = "根据sublet_info_id获取评论列表")
    public R getCommentsBySubletInfoId(@PathVariable String subletInfoId){
        return R.ok(commentService.getCommentsBySubletInfoId(subletInfoId));
    }


    @PostMapping
    @ApiOperation(value = "提交评论")
    public R addComment(@RequestBody @Validated({Default.class,PostMapping.class}) CommentBody commentBody, BindingResult result){
        return validate(result,()->commentService.addComment(commentBody));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除自己的评论")
    public R delMyselfComment(@PathVariable Integer id){
        String userId = SecurityUtils.getUserId();
        return R.ok(commentService.delMyselfComment(id,userId));
    }


    @DeleteMapping("/middle/{id}")
    @ApiOperation(value = "管理端删除评论")
    @SysLog("管理端删除评论")
    @PreAuthorize("hasAuthority('comment_del')")
    public R deleteComment(@PathVariable Integer id){
        return R.ok(commentService.delComment(id));
    }
}
