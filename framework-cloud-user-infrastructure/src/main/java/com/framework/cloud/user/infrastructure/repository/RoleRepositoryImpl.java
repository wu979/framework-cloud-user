package com.framework.cloud.user.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.Role;
import com.framework.cloud.user.domain.repository.RoleRepository;
import com.framework.cloud.user.infrastructure.converter.RoleConverter;
import com.framework.cloud.user.infrastructure.mapper.RoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class RoleRepositoryImpl extends BaseRepositoryImpl<RoleMapper, Role> implements RoleRepository {

    private final RoleConverter roleConverter;

    @Override
    public PageVO<RolePageVO> page(RolePageDTO param) {
        Page<RolePageVO> page = PageParam.buildOrder(param);
        IPage<RolePageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public RoleInfoVO info(Long id) {
        Role entity = this.getById(id);
        return roleConverter.info(entity);
    }
}