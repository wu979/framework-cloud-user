package com.framework.cloud.user.domain.repository;

import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.user.common.vo.RolePermissionTreeVO;
import com.framework.cloud.user.domain.entity.RolePermission;

import java.util.List;

/**
 * 角色权限关联 数据层接口
 *
 * @author wusiwei
 */
public interface RolePermissionRepository extends BaseRepository<RolePermission> {

    /**
     * 角色权限列表
     *
     * @param roleId 角色id
     * @return 列表
     */
    List<RolePermissionTreeVO> tree(Long roleId);
}