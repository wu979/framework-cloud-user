package com.framework.cloud.user.infrastructure.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.common.base.PageParam;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.User;
import com.framework.cloud.user.domain.repository.UserRepository;
import com.framework.cloud.user.infrastructure.converter.UserConverter;
import com.framework.cloud.user.infrastructure.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class UserRepositoryImpl extends BaseRepositoryImpl<UserMapper, User> implements UserRepository {

    private final UserConverter userConverter;

    @Override
    public PageVO<UserPageVO> page(UserPageDTO param) {
        Page<UserPageVO> page = PageParam.buildOrder(param);
        IPage<UserPageVO> list = this.baseMapper.page(page, param);
        return PageVO.page(list);
    }

    @Override
    public UserInfoVO info(Long id) {
        User entity = this.getById(id);
        return userConverter.info(entity);
    }
}