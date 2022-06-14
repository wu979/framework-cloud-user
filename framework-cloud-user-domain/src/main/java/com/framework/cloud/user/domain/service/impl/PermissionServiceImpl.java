package com.framework.cloud.user.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.tree.TreeFeature;
import com.framework.cloud.user.common.dto.PermissionDTO;
import com.framework.cloud.user.common.dto.PermissionPageDTO;
import com.framework.cloud.user.common.vo.PermissionInfoVO;
import com.framework.cloud.user.common.vo.PermissionPageVO;
import com.framework.cloud.user.common.vo.PermissionTreeVO;
import com.framework.cloud.user.domain.entity.Permission;
import com.framework.cloud.user.domain.repository.PermissionRepository;
import com.framework.cloud.user.domain.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final TreeFeature<PermissionTreeVO, Long, Integer> treeFeature;

    @Override
    public PageVO<PermissionPageVO> page(PermissionPageDTO param) {
        return permissionRepository.page(param);
    }

    @Override
    public List<PermissionTreeVO> tree(String query) {
        List<PermissionTreeVO> tree = permissionRepository.listTree(query);
        return treeFeature.childTree(tree);
    }

    @Override
    public PermissionInfoVO info(Long id) {
        return permissionRepository.info(id);
    }

    @Override
    public boolean saveUpdate(PermissionDTO param) {
        Permission entity;
        if (ObjectUtil.isNull(param.getId())) {
            entity = new Permission();
            CopierUtil.copyProperties(param, entity);
        } else {
            entity = permissionRepository.getById(param.getId());
            CopierUtil.copyProperties(param, entity);
        }
        return permissionRepository.saveOrUpdate(entity);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return permissionRepository.removeByIds(ids);
    }

}