package com.framework.cloud.user.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
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
    public PageVO<RolePermissionPageVO> page(RolePermissionPageDTO param) {
        Page<RolePermissionPageVO> page = PageParam.buildOrder(param);
        IPage<RolePermissionPageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public RolePermissionInfoVO info(Long id) {
        RolePermission entity = this.getById(id);
        return rolePermissionConverter.info(entity);
    }
}