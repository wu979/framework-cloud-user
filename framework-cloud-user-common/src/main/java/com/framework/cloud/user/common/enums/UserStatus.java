package com.framework.cloud.user.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public enum UserStatus implements IEnum<String> {

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
