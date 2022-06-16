package com.framework.cloud.user.api.application.pool;

import com.framework.cloud.executors.feature.ExecutorsFeature;
import com.framework.cloud.user.common.constant.TaskPoolConstant;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.AsyncTaskExecutor;

import javax.annotation.Resource;

/**
 * 线程池配置器
 *
 * @author wusiwei
 */
public class TaskPoolConfiguration {

    @Resource
    @Qualifier("runs")
    private ExecutorsFeature executorsFeature;

    @Bean(TaskPoolConstant.COMMON)
    public AsyncTaskExecutor commonPool() {
        return executorsFeature.executor(TaskPoolConstant.COMMON);
    }
}
