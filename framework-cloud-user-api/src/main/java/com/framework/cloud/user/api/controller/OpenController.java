package com.framework.cloud.user.api.controller;

import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.common.utils.FastJsonUtil;
import com.framework.cloud.event.publisher.ApplicationLocalPublisher;
import com.framework.cloud.user.common.vo.PermissionRoleListVO;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wusiwei
 */
@Slf4j
@Api(tags = "开放")
@RestController
@RequestMapping(path = "/open")
public class OpenController {

    @Resource
    private ApplicationLocalPublisher applicationLocalPublisher;

    @ApiOperation(value = "权限列表")
    @GetMapping(value = "/list")
    public Result<List<PermissionRoleListVO>> list() {
        return R.success(Lists.newArrayList());
    }

    @ApiOperation(value = "事件")
    @GetMapping(value = "/event")
    public Result<Boolean> event() {
        TestEvent event = new TestEvent(this, 1);
        applicationLocalPublisher.publish(event);
        return R.success(true);
    }


    @TransactionalEventListener
    public Result<Boolean> listener(TestEvent event) {
        log.info("执行本地事件消息：{}", FastJsonUtil.toJSONString(event));
        return R.success(true);
    }
}
