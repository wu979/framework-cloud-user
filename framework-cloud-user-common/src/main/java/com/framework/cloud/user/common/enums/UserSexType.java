package com.framework.cloud.user.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.framework.cloud.common.base.BaseEnum;
import com.framework.cloud.swagger.annotation.SwaggerDisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 性别
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@SwaggerDisplayEnum
public enum UserSexType implements BaseEnum<String> {

    /** code 第三方枚举 value 数据库 label 汉译 */
    MAN(0, "男"),
    WOMAN(1, "女")
    ;
    private final int code;
    private final String label;

    @Override
    public String getValue() {
        return this.name();
    }
}
