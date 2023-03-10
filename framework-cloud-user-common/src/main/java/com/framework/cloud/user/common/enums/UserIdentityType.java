package com.framework.cloud.user.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.framework.cloud.common.base.BaseEnum;
import com.framework.cloud.swagger.annotation.SwaggerDisplayEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 用户身份类型
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@SwaggerDisplayEnum
public enum UserIdentityType implements BaseEnum<String> {

    /**
     * code 第三方枚举 value 数据库 label 汉译
     */
    MOBILE(0, "手机号"),
    USERNAME(1, "用户名"),
    EMAIL(2, "邮箱"),
    WX(3, "微信"),
    ZFB(4, "支付宝"),
    ;
    private final int code;
    private final String label;

    @Override
    public String getValue() {
        return this.name();
    }
}
