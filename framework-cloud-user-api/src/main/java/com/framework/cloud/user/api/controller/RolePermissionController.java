package com.framework.cloud.user.api.controller;

import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.user.common.vo.RolePermissionTreeVO;
import com.framework.cloud.user.domain.service.RolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色权限关联 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "角色权限关联")
@RestController
@RequestMapping(path = "/rolePermission")
public class RolePermissionController {

    @Resource
    private RolePermissionService rolePermissionService;

    @ApiOperation(value = "角色权限树")
    @GetMapping(value = "/{roleId}/tree")
    public Result<List<RolePermissionTreeVO>> tree(@PathVariable("roleId") Long roleId) {
        return R.success(rolePermissionService.tree(roleId));
    }

}
