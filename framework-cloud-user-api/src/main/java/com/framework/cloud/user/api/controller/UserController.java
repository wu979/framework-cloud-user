package com.framework.cloud.user.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.user.common.dto.UserDTO;
import com.framework.cloud.user.common.dto.UserPageDTO;
import com.framework.cloud.user.common.vo.UserIdentifierVO;
import com.framework.cloud.user.common.vo.UserInfoVO;
import com.framework.cloud.user.common.vo.UserPageVO;
import com.framework.cloud.user.domain.service.UserService;
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
 * 用户 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "用户")
@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "用户列表")
    @PostMapping(value = "/page")
    public Result<PageVO<UserPageVO>> page(@ApiParam("条件") @RequestBody UserPageDTO param) {
        return R.success(userService.page(param));
    }

    @ApiOperation(value = "用户详情")
    @GetMapping(value = "/{id}/info")
    public Result<UserInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(userService.info(id));
    }

    @ApiOperation(value = "用户凭证查询")
    @GetMapping(value = "/{tenantId}/{identifier}/user")
    public Result<UserIdentifierVO> user(@ApiParam("租户ID") @PathVariable("tenantId") Long tenantId,
                                         @ApiParam("唯一凭证") @PathVariable("identifier") String identifier) {
        return R.success(userService.user(tenantId, identifier));
    }

    @ApiOperation(value = "用户新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("用户") @Valid @Validated(Save.class) @RequestBody UserDTO param) {
        return R.success(userService.saveUpdate(param));
    }

    @ApiOperation(value = "用户修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("用户") @Valid @Validated(Update.class) @RequestBody UserDTO param) {
        return R.success(userService.saveUpdate(param));
    }

    @ApiOperation(value = "用户删除")
    @DeleteMapping(value = "/removes")
    public Result<Boolean> removes(@ApiParam("主键") @RequestBody List<Long> ids) {
        return R.success(userService.removes(ids));
    }

}
