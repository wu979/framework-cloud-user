package com.framework.cloud.user.common.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.framework.cloud.common.base.BaseEnum;
import com.framework.cloud.swagger.annotation.SwaggerDisplayEnum;
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
@SwaggerDisplayEnum
public enum PermissionType implements BaseEnum<String> {

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
