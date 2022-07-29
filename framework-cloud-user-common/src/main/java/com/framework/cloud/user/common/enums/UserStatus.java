package com.framework.cloud.user.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.framework.cloud.common.base.BaseEnum;
import com.framework.cloud.swagger.annotation.SwaggerDisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户状态
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@SwaggerDisplayEnum
public enum UserStatus implements BaseEnum<String> {

    /** code 第三方枚举 value 数据库 label 汉译 */
    CANCELLATION(0,"注销"),
    NORMAL(1,"正常"),
    DISABLE(2,"禁用"),
    ;

    private final int code;
    private final String label;

    @Override
    public String getValue() {
        return this.name();
    }
}
