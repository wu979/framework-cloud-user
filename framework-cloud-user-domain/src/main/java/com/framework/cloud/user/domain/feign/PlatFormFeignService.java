package com.framework.cloud.user.domain.feign;

import com.framework.cloud.common.result.Result;
import com.framework.cloud.platform.common.vo.SettingInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 平台
 *
 * @author wusiwei
 */
@FeignClient(contextId = "PlatFormFeignService", value = "framework-cloud-platform-api", path = "/setting", decode404 = true)
public interface PlatFormFeignService {

    @GetMapping(value = "/info")
    Result<SettingInfoVO> info();
}
