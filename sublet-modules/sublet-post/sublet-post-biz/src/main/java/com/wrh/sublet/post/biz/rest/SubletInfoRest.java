package com.wrh.sublet.post.biz.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.log.annotation.SysLog;
import com.wrh.sublet.common.security.utils.SecurityUtils;
import com.wrh.sublet.common.web.base.BaseController;
import com.wrh.sublet.post.api.body.SubletInfoBody;
import com.wrh.sublet.post.biz.service.SubletInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;

/**
 * @author wrh
 * @date 2021/10/21
 */
@Slf4j
@RestController
@Api(value = "sublet-info", tags = "转租信息管理")
@RequestMapping("/sublet-info")
@RequiredArgsConstructor
public class SubletInfoRest implements BaseController {

    private final SubletInfoService subletInfoService;

    @GetMapping
    @ApiOperation(value = "用户获取自己的发布列表")
    public R getMyselfSubletInfo(Page page) {
        String userId = SecurityUtils.getUserId();
        return R.ok(subletInfoService.getSubletInfoByUserId(page, userId));
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询,只能看到合法的转租信息")
    public R pageSubletInfo(Page page, SubletInfoBody subletInfoBody) {
        return R.ok(subletInfoService.pageSubletInfo(page, subletInfoBody));
    }


    @PutMapping("/status/{id}")
    @ApiOperation(value = "修改转租状态,已转/招租")
    public R statusSubletInfo(@PathVariable String id) {
        String userId = SecurityUtils.getUserId();
        return R.ok(subletInfoService.statusSubletInfo(id, userId));
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取详情信息")
    public R getSubletInfoDetailById(@PathVariable String id) {
        return R.ok(subletInfoService.getSubletInfoDetailById(id));
    }


    @PostMapping
    @ApiOperation(value = "用户发布转租信息")
    @SysLog("发布转租信息")
    public R addSubletInfo(@RequestBody @Validated({Default.class, PostMapping.class}) SubletInfoBody subletInfoBody, BindingResult result) {
        String userId = SecurityUtils.getUserId();
        return validate(result, () -> subletInfoService.addSubletInfo(userId,subletInfoBody));
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "编辑转租信息")
    @SysLog("编辑转租信息")
    public R editMySelfSubletInfo(@PathVariable String id, @RequestBody @Validated({Default.class, PostMapping.class}) SubletInfoBody subletInfoBody, BindingResult result) {
        String userId = SecurityUtils.getUserId();
        return validate(result, () -> subletInfoService.editSubletInfo(id, subletInfoBody, userId));
    }


    @PutMapping("/lock/{id}")
    @ApiOperation(value = "标记违规信息，不然其展示")
    @SysLog("禁用违规帖子")
    @PreAuthorize("hasAuthority('sublet_info_lock')")
    public R lockSubletInfo(@PathVariable String id) {
        return R.ok(subletInfoService.lockSubletInfo(id));
    }


    @GetMapping("/middle/page")
    @ApiOperation(value = "管理端的分页查询,可以看到违规转租信息")
    @PreAuthorize("hasAuthority('sublet_info_list')")
    public R pageSubletInfoMiddle(Page page, SubletInfoBody subletInfoBody) {
        return R.ok(subletInfoService.pageSubletInfoMiddle(page, subletInfoBody));
    }

}
