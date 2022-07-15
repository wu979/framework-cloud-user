package com.framework.cloud.user.infrastructure.service;

import com.framework.cloud.tree.TreeFeature;
import com.framework.cloud.user.common.vo.RolePermissionTreeVO;
import com.framework.cloud.user.domain.repository.RolePermissionRepository;
import com.framework.cloud.user.domain.service.RolePermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色权限关联 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class RolePermissionServiceImpl implements RolePermissionService {

    private final TreeFeature<RolePermissionTreeVO, Long, Integer> treeFeature;
    private final RolePermissionRepository rolePermissionRepository;

    @Override
    public List<RolePermissionTreeVO> tree(Long roleId) {
        List<RolePermissionTreeVO> tree = rolePermissionRepository.tree(roleId);
        return treeFeature.childTree(tree);
    }
}