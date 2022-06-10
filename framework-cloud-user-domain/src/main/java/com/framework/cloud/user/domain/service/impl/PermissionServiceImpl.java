package com.framework.cloud.user.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.entity.Permission;
import com.framework.cloud.user.domain.service.PermissionService;
import com.framework.cloud.user.domain.repository.PermissionRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
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

    @Override
    public PageVO<PermissionPageVO> page(PermissionPageDTO param) {
        return permissionRepository.page(param);
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
            BeanUtils.copyProperties(param, entity);
        } else {
            entity = permissionRepository.getById(param.getId());
            BeanUtils.copyProperties(param, entity);
        }
        return permissionRepository.saveOrUpdate(entity);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return permissionRepository.removeByIds(ids);
    }

}