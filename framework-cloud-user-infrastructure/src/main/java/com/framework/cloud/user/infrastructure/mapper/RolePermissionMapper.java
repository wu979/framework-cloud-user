package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
     * 角色权限列表
     *
     * @param roleId 角色id
     * @return 列表
     */
    List<RolePermissionTreeVO> tree(@Param("roleId") Long roleId);

}