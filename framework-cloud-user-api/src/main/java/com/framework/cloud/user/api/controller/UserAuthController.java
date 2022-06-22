package com.framework.cloud.user.api.controller;

import com.framework.cloud.user.domain.service.UserAuthService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

}
