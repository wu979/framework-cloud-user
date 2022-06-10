package com.framework.cloud.user.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.entity.UserAuth;
import com.framework.cloud.user.domain.service.UserAuthService;
import com.framework.cloud.user.domain.repository.UserAuthRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户认证方式 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final UserAuthRepository userAuthRepository;

    @Override
    public PageVO<UserAuthPageVO> page(UserAuthPageDTO param) {
        return userAuthRepository.page(param);
    }

    @Override
    public UserAuthInfoVO info(Long id) {
        return userAuthRepository.info(id);
    }

    @Override
    public boolean saveUpdate(UserAuthDTO param) {
        UserAuth entity;
        if (ObjectUtil.isNull(param.getId())) {
            entity = new UserAuth();
            BeanUtils.copyProperties(param, entity);
        } else {
            entity = userAuthRepository.getById(param.getId());
            BeanUtils.copyProperties(param, entity);
        }
        return userAuthRepository.saveOrUpdate(entity);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return userAuthRepository.removeByIds(ids);
    }

}