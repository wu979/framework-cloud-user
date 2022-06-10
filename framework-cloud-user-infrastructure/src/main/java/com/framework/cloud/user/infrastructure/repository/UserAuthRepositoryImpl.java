package com.framework.cloud.user.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.UserAuth;
import com.framework.cloud.user.domain.repository.UserAuthRepository;
import com.framework.cloud.user.infrastructure.converter.UserAuthConverter;
import com.framework.cloud.user.infrastructure.mapper.UserAuthMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户认证方式 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class UserAuthRepositoryImpl extends BaseRepositoryImpl<UserAuthMapper, UserAuth> implements UserAuthRepository {

    private final UserAuthConverter userAuthConverter;

    @Override
    public PageVO<UserAuthPageVO> page(UserAuthPageDTO param) {
        Page<UserAuthPageVO> page = PageParam.buildOrder(param);
        IPage<UserAuthPageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public UserAuthInfoVO info(Long id) {
        UserAuth entity = this.getById(id);
        return userAuthConverter.info(entity);
    }
}