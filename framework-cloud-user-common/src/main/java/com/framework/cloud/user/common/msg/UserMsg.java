package com.framework.cloud.user.common.msg;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户消息
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
public enum UserMsg {

    /** 异常消息 */
    PERMISSION_EXIST("权限标识已存在"),
    PERMISSION_PARENT_NOT_FOUND("父级权限未找到"),
    PERMISSION_DELETE_ERROR("删除权限失败"),

    ROLE_EXIST("角色已存在"),
    USER_ROLE_DELETE("角色不允许删除"),
    ;

    private final String msg;
}
