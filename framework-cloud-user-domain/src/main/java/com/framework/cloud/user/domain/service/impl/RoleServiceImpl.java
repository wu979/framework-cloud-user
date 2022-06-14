package com.framework.cloud.user.domain.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.user.common.dto.RoleDTO;
import com.framework.cloud.user.common.dto.RolePageDTO;
import com.framework.cloud.user.common.vo.RoleInfoVO;
import com.framework.cloud.user.common.vo.RolePageVO;
import com.framework.cloud.user.domain.entity.Role;
import com.framework.cloud.user.domain.repository.RoleRepository;
import com.framework.cloud.user.domain.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public PageVO<RolePageVO> page(RolePageDTO param) {
        return roleRepository.page(param);
    }

    @Override
    public RoleInfoVO info(Long id) {
        return roleRepository.info(id);
    }

    @Override
    public boolean saveUpdate(RoleDTO param) {
        Role entity;
        if (ObjectUtil.isNull(param.getId())) {
            entity = new Role();
            CopierUtil.copyProperties(param, entity);
        } else {
            entity = roleRepository.getById(param.getId());
            CopierUtil.copyProperties(param, entity);
        }
        return roleRepository.saveOrUpdate(entity);
    }

    @Override
    public boolean removes(List<Long> ids) {
        return roleRepository.removeByIds(ids);
    }

}