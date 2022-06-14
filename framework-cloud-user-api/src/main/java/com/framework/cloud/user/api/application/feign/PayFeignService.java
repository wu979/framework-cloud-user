package com.framework.cloud.user.api.application.feign;

import com.framework.cloud.common.result.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 *
 * @author wusiwei
 */
@FeignClient(contextId = "payFeignService", value = "framework-cloud-pay-api", path = "test", decode404 = true)
public interface PayFeignService {

    @GetMapping(value = "/{id}/t1")
    Result<Long> test(@PathVariable(value = "id") Long id);
}
