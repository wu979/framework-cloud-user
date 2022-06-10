package com.framework.cloud.user.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户角色关联 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "用户角色关联")
@RestController
@RequestMapping(path = "/userRole")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @ApiOperation(value = "用户角色关联列表")
    @PostMapping(value = "/page")
    public Result<PageVO<UserRolePageVO>> page(@ApiParam("条件") @RequestBody UserRolePageDTO param) {
        return R.success(userRoleService.page(param));
    }

    @ApiOperation(value = "用户角色关联详情")
    @GetMapping(value = "/{id}/info")
    public Result<UserRoleInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(userRoleService.info(id));
    }

    @ApiOperation(value = "用户角色关联新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("用户角色关联") @Valid @Validated(Save.class) @RequestBody UserRoleDTO param) {
        return R.success(userRoleService.saveUpdate(param));
    }

    @ApiOperation(value = "用户角色关联修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("用户角色关联") @Valid @Validated(Update.class) @RequestBody UserRoleDTO param) {
        return R.success(userRoleService.saveUpdate(param));
    }

    @ApiOperation(value = "用户角色关联删除")
    @DeleteMapping(value = "/removes")
    public Result<Boolean> removes(@ApiParam("主键") @RequestBody List<Long> ids) {
        return R.success(userRoleService.removes(ids));
    }

}
