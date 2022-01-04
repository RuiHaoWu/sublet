package com.wrh.sublet.user.biz.rest;

import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.common.log.annotation.SysLog;
import com.wrh.sublet.user.api.vo.UserVo;
import com.wrh.sublet.user.biz.service.UserRoleRelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * 用户角色关联接口
 *
 * @author wrh
 * @date 2021/12/5
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/userRoleRel")
@Api(tags = "用户角色关联管理",value = "userRoleRel")
public class UserRoleRelRest {

    private final UserRoleRelService userRoleRelService;

    @RequestMapping("/{userId}")
    @ApiOperation(value = "获取用户所拥有的角色")
    public R getRoleListByUserId(@PathVariable String userId){
        return R.ok(userRoleRelService.getRoleListByUserId(userId));
    }

    @PostMapping("/role")
    @ApiOperation(value = "给用户分配角色")
    @SysLog("给用户分配角色")
    @PreAuthorize("hasAuthority('assign_role')")
    public R assignRoleToUser(@RequestBody UserVo userVo) {
        return R.ok(userRoleRelService.assignRoleToUser(userVo));
    }
}
