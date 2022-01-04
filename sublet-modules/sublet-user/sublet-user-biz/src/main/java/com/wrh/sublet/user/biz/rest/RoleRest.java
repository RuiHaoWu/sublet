package com.wrh.sublet.user.biz.rest;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.log.annotation.SysLog;
import com.wrh.sublet.common.web.base.BaseController;
import com.wrh.sublet.user.api.body.RoleBody;
import com.wrh.sublet.user.biz.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.groups.Default;


/**
 * 角色管理
 *
 * @author wrh
 * @date 2021/11/15
 */
@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
@Api(value = "role", tags = "角色管理")
public class RoleRest implements BaseController {

    private final RoleService roleService;

    @GetMapping
    @ApiOperation(value = "分页查询")
    @PreAuthorize("hasAuthority('role_list')")
    public R getRolePage(Page page, RoleBody roleBody) {
        return R.ok(roleService.getRolePage(page, roleBody));
    }

    @PostMapping
    @SysLog(value = "新增角色")
    @ApiOperation(value = "新增角色")
    @PreAuthorize("hasAuthority('role_add')")
    public R addRole(@RequestBody @Validated({Default.class, PostMapping.class}) RoleBody roleBody, BindingResult result) {
        return validate(result, () -> roleService.addRole(roleBody));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "根据id获取角色")
    public R getRoleById(@PathVariable Integer id) {
        return R.ok(roleService.getById(id));
    }


    @DeleteMapping("/{id}")
    @SysLog(value = "删除角色")
    @ApiOperation(value = "删除角色")
    @PreAuthorize("hasAuthority('role_del')")
    public R deleteRole(@PathVariable Integer id) {
        return R.ok(roleService.deleteRole(id));
    }


    @PutMapping("/{id}")
    @SysLog(value = "角色编辑")
    @ApiOperation(value = "角色编辑")
    @PreAuthorize("hasAuthority('role_edit')")
    public R editRole(@PathVariable Integer id, @RequestBody @Validated({Default.class, PutMapping.class}) RoleBody roleBody) {
        return R.ok(roleService.editRole(id, roleBody));
    }


}
