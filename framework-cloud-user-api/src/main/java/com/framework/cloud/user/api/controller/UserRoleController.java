package com.framework.cloud.user.api.controller;

import com.framework.cloud.user.domain.service.UserRoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    private UserRoleService userRoleService;

}
