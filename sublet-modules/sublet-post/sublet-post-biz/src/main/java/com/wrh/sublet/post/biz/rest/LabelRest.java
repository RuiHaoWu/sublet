package com.wrh.sublet.post.biz.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.log.annotation.SysLog;
import com.wrh.sublet.common.web.base.BaseController;
import com.wrh.sublet.post.api.body.LabelBody;
import com.wrh.sublet.post.api.entity.Label;
import com.wrh.sublet.post.biz.service.LabelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;

/**
 * 标签管理接口
 *
 * @author wrh
 * @date 2021/10/22
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/label")
@Api(value = "label", tags = "标签管理接口")
public class LabelRest implements BaseController {

    private final LabelService labelService;

    @GetMapping
    @ApiOperation(value = "获取可选标签")
    public R getLabelList() {
        return R.ok(labelService.getLabelList());
    }

    @GetMapping("/page")
    @ApiOperation(value = "分页查询")
    public R getLabelPage(Page page, LabelBody labelBody) {
        return R.ok(labelService.getLabelPage(page, labelBody));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "添加标签")
    public R getLabelById(@PathVariable Integer id) {
        return R.ok(labelService.getLabelById(id));
    }

    @PostMapping
    @ApiOperation(value = "添加标签")
    @SysLog("新增标签")
    @PreAuthorize("hasAuthority('label_add')")
    public R addLabel(@RequestBody @Validated({Default.class, PostMapping.class}) LabelBody labelBody, BindingResult result) {
        return validate(result, () -> labelService.addLabel(labelBody));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "编辑标签")
    @SysLog("编辑标签")
    @PreAuthorize("hasAuthority('label_edit')")
    public R editLabel(@PathVariable Integer id, @RequestBody @Validated({Default.class, PutMapping.class}) LabelBody labelBody, BindingResult result) {
        return validate(result, () -> labelService.editLabel(id, labelBody));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除标签")
    @SysLog("删除标签")
    @PreAuthorize("hasAuthority('lable_del')")
    public R deleteLabel(@PathVariable Integer id) {
        return R.ok(labelService.deleteLabel(id));
    }


}
