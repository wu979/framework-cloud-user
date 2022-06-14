package com.framework.cloud.user.api.controller;

import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.user.api.application.feign.PayFeignService;
import com.framework.cloud.user.common.dto.PermissionDTO;
import com.framework.cloud.user.common.vo.PermissionInfoVO;
import com.framework.cloud.user.common.vo.PermissionTreeVO;
import com.framework.cloud.user.domain.service.PermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * 权限 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "权限")
@RestController
@RequestMapping(path = "/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;
    @Resource
    private PayFeignService payFeignService;

    @ApiOperation(value = "权限树")
    @GetMapping(value = "/tree")
    public Result<List<PermissionTreeVO>> tree(@ApiParam("复合查询（名称、编号）") @RequestParam(value = "query", required = false) String query) {
        return R.success(permissionService.tree(query));
    }

    @ApiOperation(value = "权限详情")
    @GetMapping(value = "/{id}/info")
    public Result<PermissionInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        Result<Long> test = payFeignService.test(id);
        return R.success(permissionService.info(id));
    }

    @ApiOperation(value = "权限新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("权限") @Valid @Validated(Save.class) @RequestBody PermissionDTO param) {
        return R.success(permissionService.saveUpdate(param));
    }

    @ApiOperation(value = "权限修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("权限") @Valid @Validated(Update.class) @RequestBody PermissionDTO param) {
        return R.success(permissionService.saveUpdate(param));
    }

    @ApiOperation(value = "权限删除")
    @DeleteMapping(value = "/removes")
    public Result<Boolean> removes(@ApiParam("主键") @RequestBody List<Long> ids) {
        return R.success(permissionService.removes(ids));
    }

}
