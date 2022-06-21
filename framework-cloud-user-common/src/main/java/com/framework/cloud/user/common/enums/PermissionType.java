package com.framework.cloud.user.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 权限类型
 *
 * @author wusiwei
 */
@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PermissionType implements IEnum<String> {

    /** code 第三方枚举 value 数据库 label 汉译 */
    SYSTEM(0, "系统"),
    MENU(1, "菜单"),
    BUTTON(2, "按钮"),
    ;

    private final int code;
    private final String label;

    @Override
    public String getValue() {
        return this.name();
    }
}
