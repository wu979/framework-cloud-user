package com.framework.cloud.user.infrastructure.repository;

import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.domain.entity.UserRole;
import com.framework.cloud.user.domain.repository.UserRoleRepository;
import com.framework.cloud.user.infrastructure.converter.UserRoleConverter;
import com.framework.cloud.user.infrastructure.mapper.UserRoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 用户角色关联 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class UserRoleRepositoryImpl extends BaseRepositoryImpl<UserRoleMapper, UserRole> implements UserRoleRepository {

    private final UserRoleConverter userRoleConverter;

}