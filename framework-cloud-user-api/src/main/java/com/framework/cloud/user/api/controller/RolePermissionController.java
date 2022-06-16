package com.framework.cloud.user.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.user.common.dto.RolePermissionDTO;
import com.framework.cloud.user.common.dto.RolePermissionPageDTO;
import com.framework.cloud.user.common.vo.RolePermissionInfoVO;
import com.framework.cloud.user.common.vo.RolePermissionPageVO;
import com.framework.cloud.user.domain.service.RolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
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

    @ApiOperation(value = "角色权限关联列表")
    @PostMapping(value = "/page")
    public Result<PageVO<RolePermissionPageVO>> page(@ApiParam("条件") @RequestBody RolePermissionPageDTO param) {
        return R.success(rolePermissionService.page(param));
    }

    @ApiOperation(value = "角色权限关联详情")
    @GetMapping(value = "/{id}/info")
    public Result<RolePermissionInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(rolePermissionService.info(id));
    }

    @ApiOperation(value = "角色权限关联新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("角色权限关联") @Valid @Validated(Save.class) @RequestBody RolePermissionDTO param) {
        return R.success(rolePermissionService.saveUpdate(param));
    }

    @ApiOperation(value = "角色权限关联修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("角色权限关联") @Valid @Validated(Update.class) @RequestBody RolePermissionDTO param) {
        return R.success(rolePermissionService.saveUpdate(param));
    }

    @ApiOperation(value = "角色权限关联删除")
    @DeleteMapping(value = "/removes")
    public Result<Boolean> removes(@ApiParam("主键") @RequestBody List<Long> ids) {
        return R.success(rolePermissionService.removes(ids));
    }

}
