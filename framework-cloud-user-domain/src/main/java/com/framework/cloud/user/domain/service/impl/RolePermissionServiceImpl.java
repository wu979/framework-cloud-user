package com.framework.cloud.user.domain.service.impl;

import com.framework.cloud.user.domain.repository.RolePermissionRepository;
import com.framework.cloud.user.domain.service.RolePermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 角色权限关联 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

    private final RolePermissionRepository rolePermissionRepository;

}