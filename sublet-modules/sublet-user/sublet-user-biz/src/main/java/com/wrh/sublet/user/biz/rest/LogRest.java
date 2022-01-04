package com.wrh.sublet.user.biz.rest;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.security.annotation.Inner;
import com.wrh.sublet.user.api.body.SysLogBody;
import com.wrh.sublet.user.api.entity.SysLog;
import com.wrh.sublet.user.biz.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wrh
 * @date 2021/11/8
 */
@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
@Api(value = "log", tags = "日志管理")
public class LogRest {

    private final SysLogService sysLogService;

    @Inner
    @PostMapping
    @ApiOperation(value = "新增日志记录")
    public R save(@RequestBody SysLog sysLog) {
        return R.ok(sysLogService.save(sysLog));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取日志详情")
    @PreAuthorize("hasAuthority('log_detail')")
    public R getLogById(@PathVariable Integer id) {
        return R.ok(sysLogService.getById(id));
    }


    @GetMapping
    @ApiOperation(value = "分页查询")
    @PreAuthorize("hasAuthority('log_list')")
    public R getLogPage(Page page, SysLogBody sysLogBody) {
        return R.ok(sysLogService.getLogPage(page, sysLogBody));
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "批量删除日志")
    @PreAuthorize("hasAuthority('log_del')")
    public R deleteByIds(@PathVariable List<Integer> id) {
        return R.ok(sysLogService.deleteByIds(id));
    }
}
