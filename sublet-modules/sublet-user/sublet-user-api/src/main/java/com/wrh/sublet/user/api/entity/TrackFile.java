package com.wrh.sublet.user.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.wrh.sublet.common.mybatis.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件记录
 *
 * @author wrh
 * @date 2021/11/10
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrackFile extends BaseEntity {

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 路径
     */
    private String url;

    /**
     * 容器名称
     */
    private String bucketName;

    /**
     * 文件类型
     */
    private String type;

    /**
     * 文件大小
     */
    private Long fileSize;

    /**
     * 删除标识：1-删除，0-正常
     */
    @TableLogic
    private Integer delFlag;
}
