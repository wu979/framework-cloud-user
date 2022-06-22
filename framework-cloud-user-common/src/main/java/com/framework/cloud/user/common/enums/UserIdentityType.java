package com.framework.cloud.user.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public enum UserIdentityType implements IEnum<String> {

    /** code 第三方枚举 value 数据库 label 汉译 */
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
