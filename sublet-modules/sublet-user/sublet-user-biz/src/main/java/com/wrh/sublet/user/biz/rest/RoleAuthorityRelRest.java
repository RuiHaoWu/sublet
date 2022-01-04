package com.wrh.sublet.user.biz.rest;

import com.wrh.sublet.common.core.result.R;
import com.wrh.sublet.user.biz.service.RoleAuthorityRelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 角色权限管理管理接口
 *
 * @author wrh
 * @date 2021/12/5
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/roleAuthRel")
@Api(tags = "用户角色关联管理",value = "roleAuthRel")
public class RoleAuthorityRelRest {

    private final RoleAuthorityRelService roleAuthorityRelService;

    @RequestMapping("/{roleId}")
    @ApiOperation(value = "获取角色所拥有的角色")
    public R getRoleListByUserId(@PathVariable Integer roleId){
        return R.ok(roleAuthorityRelService.getAuthorityListByRoleId(roleId));
    }
}
