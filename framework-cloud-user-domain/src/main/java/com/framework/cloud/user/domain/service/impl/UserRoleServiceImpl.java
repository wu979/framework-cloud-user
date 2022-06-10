package com.framework.cloud.user.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.domain.entity.UserRole;
import com.framework.cloud.user.domain.service.UserRoleService;
import com.framework.cloud.user.domain.repository.UserRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色关联 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Override
    public PageVO<UserRolePageVO> page(UserRolePageDTO param) {
        return userRoleRepository.page(param);
    }

    @Override
    public UserRoleInfoVO info(Long id) {
        return userRoleRepository.info(id);
    }

    @Override
    public boolean saveUpdate(UserRoleDTO param) {
        UserRole entity;
        if (ObjectUtil.isNull(param.getId())) {
            entity = new UserRole();
            BeanUtils.copyProperties(param, entity);
        } else {
            entity = userRoleRepository.getById(param.getId());
            BeanUtils.copyProperties(param, entity);
        }
        return userRoleRepository.saveOrUpdate(entity);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return userRoleRepository.removeByIds(ids);
    }

}