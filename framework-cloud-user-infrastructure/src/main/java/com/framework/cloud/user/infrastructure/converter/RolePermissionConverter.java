package com.framework.cloud.user.infrastructure.converter;

import com.framework.cloud.user.common.vo.RolePermissionInfoVO;
import com.framework.cloud.user.domain.entity.RolePermission;
import org.mapstruct.Mapper;

/**
 * 角色权限关联 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface RolePermissionConverter {

    /**
     * 角色权限关联 详情转换
     *
     * @param rolePermission 实体
     * @return 详情
     */
    RolePermissionInfoVO info(RolePermission rolePermission);

}