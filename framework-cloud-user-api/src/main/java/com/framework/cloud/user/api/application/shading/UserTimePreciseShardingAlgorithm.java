package com.framework.cloud.user.api.application.shading;

import cn.hutool.core.date.DateUtil;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * 用户标准分片 按年
 *
 * @author wusiwei
 */
public class UserTimePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> targetNames, PreciseShardingValue<Long> shardingValue) {
        String years = String.valueOf(DateUtil.thisYear());
        return targetNames.stream().filter(name -> name.endsWith(years)).findAny().orElse(null);
    }

}
