package com.framework.cloud.user.infrastructure.converter;

import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.entity.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 用户角色关联 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface UserRoleConverter {

    /**
     * 用户角色关联 详情转换
     *
     * @param userRole 实体
     * @return 详情
     */
    UserRoleInfoVO info(UserRole userRole);

}