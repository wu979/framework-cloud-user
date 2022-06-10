package com.framework.cloud.user.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.entity.RolePermission;
import com.framework.cloud.user.domain.service.RolePermissionService;
import com.framework.cloud.user.domain.repository.RolePermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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

    private final RolePermissionRepository rolePermissionRepository;

    @Override
    public PageVO<RolePermissionPageVO> page(RolePermissionPageDTO param) {
        return rolePermissionRepository.page(param);
    }

    @Override
    public RolePermissionInfoVO info(Long id) {
        return rolePermissionRepository.info(id);
    }

    @Override
    public boolean saveUpdate(RolePermissionDTO param) {
        RolePermission entity;
        if (ObjectUtil.isNull(param.getId())) {
            entity = new RolePermission();
            BeanUtils.copyProperties(param, entity);
        } else {
            entity = rolePermissionRepository.getById(param.getId());
            BeanUtils.copyProperties(param, entity);
        }
        return rolePermissionRepository.saveOrUpdate(entity);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return rolePermissionRepository.removeByIds(ids);
    }

}