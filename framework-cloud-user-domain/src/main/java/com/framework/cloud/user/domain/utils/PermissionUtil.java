package com.framework.cloud.user.domain.utils;

import com.framework.cloud.common.enums.GlobalNumber;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.mybatis.utils.SnowflakeUtil;
import com.framework.cloud.user.common.dto.PermissionDTO;
import com.framework.cloud.user.domain.entity.Permission;

import java.util.Objects;

/**
 * @author wusiwei
 */
public class PermissionUtil {

    /**
     * 构建权限
     *
     * @param param 参数
     * @return 权限
     */
    public static Permission buildPermission(PermissionDTO param) {
        return buildPermission(null, param);
    }

    /**
     * 构建权限
     *
     * @param parent 父级
     * @param param  参数
     * @return 权限
     */
    public static Permission buildPermission(Permission parent, PermissionDTO param) {
        int left = GlobalNumber.ONE.getIntValue(), right = GlobalNumber.TWO.getIntValue(), level = GlobalNumber.ONE.getIntValue();
        Long id = SnowflakeUtil.nextId();
        Permission permission = new Permission();
        CopierUtil.copyProperties(param, permission);
        permission.setId(id);
        if (Objects.nonNull(parent)) {
            left = parent.getRight();
            right = parent.getRight() + GlobalNumber.ONE.getIntValue();
            level = parent.getLevel() + GlobalNumber.ONE.getIntValue();
            id = parent.getTraceId();
        }
        permission.setLeft(left);
        permission.setRight(right);
        permission.setLevel(level);
        permission.setParentId(Objects.nonNull(parent) ? parent.getId() : null);
        permission.setTraceId(id);
        return permission;
    }

}
