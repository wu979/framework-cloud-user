package com.framework.cloud.user.infrastructure.converter;

import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.entity.Permission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 权限 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface PermissionConverter {

    /**
     * 权限 详情转换
     *
     * @param permission 实体
     * @return 详情
     */
    PermissionInfoVO info(Permission permission);

}