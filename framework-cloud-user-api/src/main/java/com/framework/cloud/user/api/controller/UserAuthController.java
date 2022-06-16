package com.framework.cloud.user.api.controller;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.user.common.dto.UserAuthDTO;
import com.framework.cloud.user.common.dto.UserAuthPageDTO;
import com.framework.cloud.user.common.vo.UserAuthInfoVO;
import com.framework.cloud.user.common.vo.UserAuthPageVO;
import com.framework.cloud.user.domain.service.UserAuthService;
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
 * 用户认证方式 前端控制器
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "用户认证方式")
@RestController
@RequestMapping(path = "/userAuth")
public class UserAuthController {

    @Resource
    private UserAuthService userAuthService;

    @ApiOperation(value = "用户认证方式列表")
    @PostMapping(value = "/page")
    public Result<PageVO<UserAuthPageVO>> page(@ApiParam("条件") @RequestBody UserAuthPageDTO param) {
        return R.success(userAuthService.page(param));
    }

    @ApiOperation(value = "用户认证方式详情")
    @GetMapping(value = "/{id}/info")
    public Result<UserAuthInfoVO> info(@ApiParam("主键") @PathVariable("id") Long id) {
        return R.success(userAuthService.info(id));
    }

    @ApiOperation(value = "用户认证方式新增")
    @PostMapping(value = "/save")
    public Result<Boolean> save(@ApiParam("用户认证方式") @Valid @Validated(Save.class) @RequestBody UserAuthDTO param) {
        return R.success(userAuthService.saveUpdate(param));
    }

    @ApiOperation(value = "用户认证方式修改")
    @PostMapping(value = "/update")
    public Result<Boolean> update(@ApiParam("用户认证方式") @Valid @Validated(Update.class) @RequestBody UserAuthDTO param) {
        return R.success(userAuthService.saveUpdate(param));
    }

    @ApiOperation(value = "用户认证方式删除")
    @DeleteMapping(value = "/removes")
    public Result<Boolean> removes(@ApiParam("主键") @RequestBody List<Long> ids) {
        return R.success(userAuthService.removes(ids));
    }

}
