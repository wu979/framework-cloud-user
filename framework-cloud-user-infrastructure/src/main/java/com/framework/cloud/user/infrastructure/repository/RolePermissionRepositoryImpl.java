package com.framework.cloud.user.infrastructure.repository;

import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.common.vo.RolePermissionTreeVO;
import com.framework.cloud.user.domain.entity.RolePermission;
import com.framework.cloud.user.domain.repository.RolePermissionRepository;
import com.framework.cloud.user.infrastructure.converter.RolePermissionConverter;
import com.framework.cloud.user.infrastructure.mapper.RolePermissionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色权限关联 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class RolePermissionRepositoryImpl extends BaseRepositoryImpl<RolePermissionMapper, RolePermission> implements RolePermissionRepository {

    private final RolePermissionConverter rolePermissionConverter;

    @Override
    public List<RolePermissionTreeVO> tree(Long roleId) {
        return this.baseMapper.tree(roleId);
    }
}