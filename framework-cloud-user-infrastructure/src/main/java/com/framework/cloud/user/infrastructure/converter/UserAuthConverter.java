package com.framework.cloud.user.infrastructure.converter;

import com.framework.cloud.user.common.vo.UserAuthInfoVO;
import com.framework.cloud.user.domain.entity.UserAuth;
import org.mapstruct.Mapper;

/**
 * 用户认证方式 转换器
 *
 * @author wusiwei
 */
@Mapper(componentModel = "spring")
public interface UserAuthConverter {

    /**
     * 用户认证方式 详情转换
     *
     * @param userAuth 实体
     * @return 详情
     */
    UserAuthInfoVO info(UserAuth userAuth);

}