package com.framework.cloud.user.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.entity.User;
import com.framework.cloud.user.domain.service.UserService;
import com.framework.cloud.user.domain.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public PageVO<UserPageVO> page(UserPageDTO param) {
        return userRepository.page(param);
    }

    @Override
    public UserInfoVO info(Long id) {
        return userRepository.info(id);
    }

    @Override
    public boolean saveUpdate(UserDTO param) {
        User entity;
        if (ObjectUtil.isNull(param.getId())) {
            entity = new User();
            BeanUtils.copyProperties(param, entity);
        } else {
            entity = userRepository.getById(param.getId());
            BeanUtils.copyProperties(param, entity);
        }
        return userRepository.saveOrUpdate(entity);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return userRepository.removeByIds(ids);
    }

}