package com.framework.cloud.user.domain.service;

import com.framework.cloud.user.common.vo.RolePermissionTreeVO;

import java.util.List;

/**
 * 角色权限关联 服务层接口
 *
 * @author wusiwei
 */
public interface RolePermissionService {

    /**
     * 角色权限树
     *
     * @param roleId 角色id
     * @return 树形
     */
    List<RolePermissionTreeVO> tree(Long roleId);

}