package com.framework.cloud.user.domain.feign;

import com.framework.cloud.common.result.Result;
import com.framework.cloud.user.common.rpc.SettingInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 平台
 *
 * @author wusiwei
 */
@FeignClient(contextId = "PlatFormFeignService", value = "${client.platform}", decode404 = true)
public interface PlatFormFeignService {

    @GetMapping(value = "/setting/info")
    Result<SettingInfoVO> info();

    @PostMapping(value = "/pay-channel/{id}/enable")
    Result<Boolean> enable(@PathVariable("id") Long id);
}
