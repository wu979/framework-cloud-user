package com.framework.cloud.user.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public enum UserSexType implements IEnum<String> {

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
