package com.framework.cloud.user.api.controller;


import com.framework.cloud.event.application.ApplicationLocalEvent;

/**
 *
 *
 * @author wusiwei
 */
public class TestEvent extends ApplicationLocalEvent {
    private static final long serialVersionUID = -1885683227906506944L;

    private Integer code;

    public TestEvent(Object source, Integer code) {
        super(source);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
