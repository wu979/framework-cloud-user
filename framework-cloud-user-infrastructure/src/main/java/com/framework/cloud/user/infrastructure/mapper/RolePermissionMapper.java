package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.framework.cloud.user.common.vo.RolePermissionListVO;
import com.framework.cloud.user.common.vo.RolePermissionTreeVO;
import com.framework.cloud.user.domain.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色权限关联 数据库接口
 *
 * @author wusiwei
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    /**
     * 根据权限id 查询角色标识
     *
     * @param permissionId 权限id
     */
    List<RolePermissionListVO> findByPermissionId(@Param("permissionId") Long permissionId);

    /**
     * 角色权限列表
     *
     * @param roleId 角色id
     * @return 列表
     */
    List<RolePermissionTreeVO> tree(@Param("roleId") Long roleId);

}