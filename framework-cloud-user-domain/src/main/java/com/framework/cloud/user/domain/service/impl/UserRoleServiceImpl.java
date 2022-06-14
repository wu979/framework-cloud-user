package com.framework.cloud.user.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.user.common.dto.UserRoleDTO;
import com.framework.cloud.user.common.dto.UserRolePageDTO;
import com.framework.cloud.user.common.vo.UserRoleInfoVO;
import com.framework.cloud.user.common.vo.UserRolePageVO;
import com.framework.cloud.user.domain.entity.UserRole;
import com.framework.cloud.user.domain.repository.UserRoleRepository;
import com.framework.cloud.user.domain.service.UserRoleService;
import lombok.AllArgsConstructor;
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
            CopierUtil.copyProperties(param, entity);
        } else {
            entity = userRoleRepository.getById(param.getId());
            CopierUtil.copyProperties(param, entity);
        }
        return userRoleRepository.saveOrUpdate(entity);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return userRoleRepository.removeByIds(ids);
    }

}