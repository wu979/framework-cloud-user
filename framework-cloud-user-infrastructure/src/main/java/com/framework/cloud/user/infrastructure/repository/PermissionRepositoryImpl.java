package com.framework.cloud.user.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.Permission;
import com.framework.cloud.user.domain.repository.PermissionRepository;
import com.framework.cloud.user.infrastructure.converter.PermissionConverter;
import com.framework.cloud.user.infrastructure.mapper.PermissionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class PermissionRepositoryImpl extends BaseRepositoryImpl<PermissionMapper, Permission> implements PermissionRepository {

    private final PermissionConverter permissionConverter;

    @Override
    public PageVO<PermissionPageVO> page(PermissionPageDTO param) {
        Page<PermissionPageVO> page = PageParam.buildOrder(param);
        IPage<PermissionPageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public PermissionInfoVO info(Long id) {
        Permission entity = this.getById(id);
        return permissionConverter.info(entity);
    }
}