package com.framework.cloud.user.infrastructure.repository;

import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.domain.entity.UserAuth;
import com.framework.cloud.user.domain.repository.UserAuthRepository;
import com.framework.cloud.user.infrastructure.converter.UserAuthConverter;
import com.framework.cloud.user.infrastructure.mapper.UserAuthMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 用户认证方式 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class UserAuthRepositoryImpl extends BaseRepositoryImpl<UserAuthMapper, UserAuth> implements UserAuthRepository {

    private final UserAuthConverter userAuthConverter;

}