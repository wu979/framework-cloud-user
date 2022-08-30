package com.framework.cloud.user.infrastructure.converter;

import com.framework.cloud.user.common.vo.PermissionInfoVO;
import com.framework.cloud.user.common.vo.PermissionTreeVO;
import com.framework.cloud.user.domain.entity.Permission;
import org.mapstruct.Mapper;

import java.util.List;

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

    /**
     * 权限 集合转换
     *
     * @param permissionList 实体
     * @return 集合
     */
    List<PermissionTreeVO> list(List<Permission> permissionList);
}