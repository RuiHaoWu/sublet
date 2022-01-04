package com.wrh.sublet.post.api.body;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.constraints.NotBlank;

/**
 * @author wrh
 * @date 2021/12/12
 */
@Data
public class CommentBody {

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    @NotBlank(message = "评论不允许为空", groups = {PostMapping.class})
    private String content;

    /**
     * 转租信息id
     */
    @ApiModelProperty(value = "转租信息id")
    @NotBlank(message = "转租帖子id不允许为空", groups = {PostMapping.class})
    private String subletInfoId;

    /**
     * 父id
     */
    @ApiModelProperty(value = "父id")
    private Integer pid;

//    /**
//     * 作者id
//     */
//    @ApiModelProperty(value = "作者id")
//    @NotBlank(message = "作者id不允许为空", groups = {PostMapping.class})
//    private String userId;

    /**
     * 回复评论id
     */
    @ApiModelProperty(value = "回复评论id")
    private Integer replyCommentId;
}
