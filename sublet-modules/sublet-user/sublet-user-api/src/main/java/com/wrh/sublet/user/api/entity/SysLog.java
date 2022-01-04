package com.wrh.sublet.user.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wrh.sublet.common.mybatis.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * 记录操作日志表
 *
 * @author wrh
 * @date 2021/10/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysLog extends BaseEntity {

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 日志标题
     */
    private String title;

    /**
     * 操作IP地址
     */
    private String remoteAddr;

    /**
     * 请求URI
     */
    private String requestUri;


    /**
     * 请求方式
     */
    private String method;


    /**
     * 操作提交的数据
     */
    private String params;

    /**
     * body参数
     */
    private String body;

    /**
     * 执行时间
     */
    private Long execTime;


    /**
     * 日志类型（0正常 1报错）
     */
    private Integer type;

    /**
     * 错误消息
     */
    private String errorMsg;

    /**
     * 客户端id
     */
    private String clientId;

}
