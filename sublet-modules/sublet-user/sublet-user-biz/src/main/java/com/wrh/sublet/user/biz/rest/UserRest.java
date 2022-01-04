package com.wrh.sublet.user.biz.rest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.log.annotation.SysLog;
import com.wrh.sublet.common.security.annotation.Inner;
import com.wrh.sublet.common.security.utils.SecurityUtils;
import com.wrh.sublet.common.web.base.BaseController;
import com.wrh.sublet.user.api.body.UserBody;
import com.wrh.sublet.user.biz.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.groups.Default;
import java.util.Objects;

/**
 * @author wrh
 * @date 2021/10/12
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Api(value = "user", tags = "前台用户管理")
public class UserRest implements BaseController {

    private final UserService userService;

    @Inner
    @GetMapping("/inner/{username}")
    @ApiOperation(value = "通过用户名获取用户信息和权限")
    public R getUserByUsername(@PathVariable String username) {
        return R.ok(userService.getUserByUsername(username));
    }


    @GetMapping("/{userId}")
    @ApiOperation(value = "通过用户id获取用户信息")
    public R getUserById(@PathVariable String userId) {
        return R.ok(userService.selectById(userId));
    }


    @GetMapping("/info")
    @ApiOperation(value = "通过token获取用户信息")
    public R getUserInfoByToken() {
        String username = Objects.requireNonNull(SecurityUtils.getUser()).getUsername();
        return R.ok(userService.getUserInfo(username));
    }

    @PostMapping
    @ApiOperation(value = "用户注册")
    @SysLog("用户注册")
    public R register(@RequestBody @Validated(value = {Default.class, PostMapping.class}) UserBody userBody, BindingResult result) {
        return validate(result, () -> userService.save(userBody));
    }


    @PutMapping("/modifyPwd")
    @ApiOperation(value = "用户修改密码")
    @SysLog("用户修改密码")
    public R editPassword(@RequestBody UserBody userBody) {
        String userId = SecurityUtils.getUserId();
        return R.ok(userService.modifyPwd(userId, userBody));
    }


    @GetMapping
    @ApiOperation(value = "获取用户列表")
    @PreAuthorize("hasAuthority('user_list')")
    public R getUserPage(Page page, UserBody userBody) {
        return R.ok(userService.getUserPage(page, userBody));
    }


    @SysLog(value = "发送邮件")
    @PostMapping("/sendMail")
    @ApiOperation(value = "发送邮件")
    public R sendMail(@RequestBody @Validated(value = {Default.class, UserBody.MailValid.class}) UserBody userBody, BindingResult result) {
        userService.sendMail(userBody.getEmail());
        return validate(result, R::ok);
    }


    @PutMapping
    @ApiOperation(value = "前台用户修改自己的用户信息")
    @SysLog("前台用户修改自己的用户信息")
    public R editMyselfInfo(@RequestBody UserBody userBody) {
        String userId = SecurityUtils.getUserId();
        return R.ok(userService.editUserInfo(userId, userBody));
    }


    @PutMapping("/{id}")
    @ApiOperation(value = "编辑用户信息")
    @SysLog("编辑用户")
    @PreAuthorize("hasAuthority('user_edit')")
    public R editUserInfo(@PathVariable String id, @RequestBody @Validated(value = {Default.class, PutMapping.class}) UserBody userBody, BindingResult result) {
        return validate(result, () -> userService.editUserInfo(id, userBody));
    }


    @PutMapping("/lock/{id}")
    @ApiOperation(value = "修改用户状态")
    @SysLog("修改用户状态")
    @PreAuthorize("hasAuthority('user_lock')")
    public R editLockStatus(@PathVariable String id) {
        return R.ok(userService.editLockStatus(id));
    }


    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除用户")
    @SysLog("删除用户")
    @PreAuthorize("hasAuthority('user_del')")
    public R delete(@PathVariable String id) {
        return R.ok(userService.delete(id));
    }


}
