package com.framework.cloud.user.api.controller;

import com.framework.cloud.common.exception.BizException;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.elasticsearch.proxy.Elastic;
import com.framework.cloud.elasticsearch.proxy.ElasticResponse;
import com.framework.cloud.user.domain.model.elastic.TestModel;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 *
 * @author wusiwei
 */
@Slf4j
@Api(tags = "查询")
@RestController
@RequestMapping(path = "/elastic")
public class ElasticController {

    @Resource
    private Elastic elastic;

    @GetMapping("/create")
    public Result<Void> create() {
        ElasticResponse<Boolean> response = elastic.createIndex(TestModel.class);
        if (!response.ok()) {
            throw new BizException("error");
        }
        if (!response.getData()) {
            throw new BizException(response.getMsg());
        }
        return R.success();
    }

    @GetMapping("/exists")
    public Result<Void> exists() {
        ElasticResponse<Boolean> response = elastic.isExists(TestModel.class);
        if (!response.ok()) {
            throw new BizException("error");
        }
        if (!response.getData()) {
            throw new BizException(response.getMsg());
        }
        return R.success();
    }
}
