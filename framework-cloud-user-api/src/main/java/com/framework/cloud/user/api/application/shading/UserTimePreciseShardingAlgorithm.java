package com.framework.cloud.user.api.application.shading;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import lombok.Getter;
import org.apache.shardingsphere.sharding.api.sharding.standard.PreciseShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.RangeShardingValue;
import org.apache.shardingsphere.sharding.api.sharding.standard.StandardShardingAlgorithm;

import java.util.Collection;
import java.util.Properties;

/**
 * 用户标准分片 按年
 *
 * @author wusiwei
 */
public class UserTimePreciseShardingAlgorithm implements StandardShardingAlgorithm<Long> {

    /**
     * 参数 可以自定义参数在props里面
     */
    @Getter
    private Properties properties;

    @Override
    public String doSharding(Collection<String> targetNames, PreciseShardingValue<Long> shardingValue) {
        DateTime date = DateUtil.date(shardingValue.getValue());
        String years = String.valueOf(DateUtil.year(date));
        return targetNames.stream().filter(name -> name.endsWith(years)).findAny().orElse(null);
    }

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        return null;
    }

    @Override
    public Properties getProps() {
        return properties;
    }

    @Override
    public void init(Properties props) {
        properties = props;
    }
}
