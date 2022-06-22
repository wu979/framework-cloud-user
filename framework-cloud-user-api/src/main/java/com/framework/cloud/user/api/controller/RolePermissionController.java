package com.framework.cloud.user.api.controller;

import com.framework.cloud.user.domain.service.RolePermissionService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}
