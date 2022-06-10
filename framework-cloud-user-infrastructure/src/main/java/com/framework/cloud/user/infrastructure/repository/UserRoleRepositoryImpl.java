package com.framework.cloud.user.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.UserRole;
import com.framework.cloud.user.domain.repository.UserRoleRepository;
import com.framework.cloud.user.infrastructure.converter.UserRoleConverter;
import com.framework.cloud.user.infrastructure.mapper.UserRoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户角色关联 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class UserRoleRepositoryImpl extends BaseRepositoryImpl<UserRoleMapper, UserRole> implements UserRoleRepository {

    private final UserRoleConverter userRoleConverter;

    @Override
    public PageVO<UserRolePageVO> page(UserRolePageDTO param) {
        Page<UserRolePageVO> page = PageParam.buildOrder(param);
        IPage<UserRolePageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public UserRoleInfoVO info(Long id) {
        UserRole entity = this.getById(id);
        return userRoleConverter.info(entity);
    }
}