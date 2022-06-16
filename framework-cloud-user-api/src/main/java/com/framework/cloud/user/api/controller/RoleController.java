package com.framework.cloud.user.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.user.common.dto.RoleDTO;
import com.framework.cloud.user.common.dto.RolePageDTO;
import com.framework.cloud.user.common.vo.RoleInfoVO;
import com.framework.cloud.user.common.vo.RolePageVO;
import com.framework.cloud.user.domain.service.RoleService;
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
 * 角色 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "角色")
@RestController
@RequestMapping(path = "/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @ApiOperation(value = "角色列表")
    @PostMapping(value = "/page")
    public Result<PageVO<RolePageVO>> page(@ApiParam("条件") @RequestBody RolePageDTO param) {
        return R.success(roleService.page(param));
    }

    @ApiOperation(value = "角色详情")
    @GetMapping(value = "/{id}/info")
    public Result<RoleInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(roleService.info(id));
    }

    @ApiOperation(value = "角色新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("角色") @Valid @Validated(Save.class) @RequestBody RoleDTO param) {
        return R.success(roleService.saveUpdate(param));
    }

    @ApiOperation(value = "角色修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("角色") @Valid @Validated(Update.class) @RequestBody RoleDTO param) {
        return R.success(roleService.saveUpdate(param));
    }

    @ApiOperation(value = "角色删除")
    @DeleteMapping(value = "/removes")
    public Result<Boolean> removes(@ApiParam("主键") @RequestBody List<Long> ids) {
        return R.success(roleService.removes(ids));
    }

}
