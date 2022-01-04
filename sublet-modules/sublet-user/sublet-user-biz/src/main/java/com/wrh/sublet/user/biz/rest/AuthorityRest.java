package com.wrh.sublet.user.biz.rest;

import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.log.annotation.SysLog;
import com.wrh.sublet.common.security.utils.SecurityUtils;
import com.wrh.sublet.user.api.body.AuthorityBody;
import com.wrh.sublet.user.api.entity.Authority;
import com.wrh.sublet.user.biz.service.AuthorityService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;


/**
 * 权限管理
 *
 * @author wrh
 * @date 2021/11/15
 */
@RestController
@RequestMapping("/authority")
@RequiredArgsConstructor
@Api(value = "authority", tags = "权限管理")
public class AuthorityRest {

    private final AuthorityService authorityService;

    @GetMapping("/{id}")
    @ApiOperation(value = "通过id获取详情")
    public R getAuthorityById(@PathVariable Integer id) {
        return R.ok(authorityService.getById(id));
    }


    @GetMapping("/tree")
    @ApiOperation(value = "获取权限列表(树状)")
    @PreAuthorize("hasAuthority('authority_list')")
    public R getAuthorityTree() {
        return R.ok(authorityService.getAuthorityTree());
    }


    @GetMapping("/menu")
    @ApiOperation(value = "获取当前用户的权限列表")
    public R getUserMenu() {
        String userId = SecurityUtils.getUserId();
        return R.ok(authorityService.getUserMenu(userId));
    }


    @PostMapping
    @ApiOperation(value = "新增权限")
    @SysLog("新增权限")
    @PreAuthorize("hasAuthority('authority_add')")
    public R addAuthority(@RequestBody @Validated({Default.class, PostMapping.class}) AuthorityBody authorityBody) {
        return R.ok(authorityService.addAuthority(authorityBody));
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除权限")
    @SysLog("删除权限")
    @PreAuthorize("hasAuthority('authority_del')")
    public R deleteAuthority(@PathVariable Integer id) {
        return R.ok(authorityService.deleteAuthority(id));
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "编辑权限")
    @SysLog("编辑权限")
    @PreAuthorize("hasAuthority('authority_edit')")
    public R editAuthority(@PathVariable Integer id, @RequestBody @Validated({Default.class, PutMapping.class}) AuthorityBody authorityBody) {
        return R.ok(authorityService.editAuthority(id, authorityBody));
    }


}
