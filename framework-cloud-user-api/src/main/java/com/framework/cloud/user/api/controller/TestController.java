package com.framework.cloud.user.api.controller;

import com.framework.cloud.cache.cache.LocalCache;
import com.framework.cloud.common.result.R;
import com.framework.cloud.common.result.Result;
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
@RestController
@RequestMapping(path = "/test")
public class TestController {

    @Resource
    private LocalCache localCache;

    @GetMapping(value = "/test1")
    public Result<Void> test1() {
        Integer integer = localCache.get("cache:key", Integer.class);
        System.out.println(integer);
        return R.success();
    }

    @GetMapping(value = "/test2")
    public Result<Void> test2() {
        boolean put = localCache.put("cache:key", 1);
        System.out.println(put);
        return R.success();
    }

    @GetMapping(value = "/test3")
    public Result<Void> test3() {
        boolean delete = localCache.delete("cache:key");
        System.out.println(delete);
        return R.success();
    }
}
