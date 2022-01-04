package com.wrh.sublet.user.biz.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wrh.sublet.user.api.body.SysLogBody;
import com.wrh.sublet.user.api.entity.SysLog;

import java.util.List;


/**
 * @author wrh
 * @date 2021/11/8
 */
public interface SysLogService extends IService<SysLog> {

    /**
     * 分页查询
     *
     * @param page 分页参数
     * @param sysLogBody 查询条件
     * @return 日志列表
     */
    Object getLogPage(Page page, SysLogBody sysLogBody);

    /**
     * 批量删除
     *
     * @param ids ids
     * @return 操作结果
     */
    Boolean deleteByIds(List<Integer> ids);
}
