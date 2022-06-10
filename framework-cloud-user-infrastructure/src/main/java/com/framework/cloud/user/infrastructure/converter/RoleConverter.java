package com.framework.cloud.user.infrastructure.converter;

import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 角色 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    /**
     * 角色 详情转换
     *
     * @param role 实体
     * @return 详情
     */
    RoleInfoVO info(Role role);

}