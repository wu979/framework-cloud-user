package com.framework.cloud.user.infrastructure.converter;

import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * 用户 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    /**
     * 用户 详情转换
     *
     * @param user 实体
     * @return 详情
     */
    UserInfoVO info(User user);

}