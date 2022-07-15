package com.framework.cloud.user.infrastructure.service;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.enums.GlobalMessage;
import com.framework.cloud.common.exception.BizException;
import com.framework.cloud.common.utils.AssertUtil;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.common.utils.StringUtil;
import com.framework.cloud.user.common.dto.RoleDTO;
import com.framework.cloud.user.common.dto.RolePageDTO;
import com.framework.cloud.user.common.msg.UserMsg;
import com.framework.cloud.user.common.vo.RolePageVO;
import com.framework.cloud.user.domain.entity.Role;
import com.framework.cloud.user.domain.entity.UserRole;
import com.framework.cloud.user.domain.repository.RoleRepository;
import com.framework.cloud.user.domain.repository.UserRoleRepository;
import com.framework.cloud.user.domain.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 角色 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public PageVO<RolePageVO> page(RolePageDTO param) {
        return roleRepository.page(param);
    }

    @Override
    public List<String> list(Long userId) {
        List<Role> list = roleRepository.list(userId);
        return list.stream().map(Role::getCode).filter(StringUtil::isNotEmpty).distinct().collect(Collectors.toList());
    }

    @Override
    public boolean saveUpdate(RoleDTO param) {
        Role entity;
        Role exist = roleRepository.infoByCode(param.getCode());
        if (ObjectUtil.isNull(param.getId())) {
            AssertUtil.nonNull(exist, UserMsg.ROLE_EXIST.getMsg());
            entity = new Role();
            CopierUtil.copyProperties(param, entity);
        } else {
            entity = roleRepository.getByIdNotNull(param.getId());
            if (ObjectUtil.isNotNull(exist)) {
                AssertUtil.isTrue(exist.getId().equals(entity.getId()), UserMsg.ROLE_EXIST.getMsg());
            }
            CopierUtil.copyProperties(param, entity);
        }
        return roleRepository.saveOrUpdate(entity);
    }

    @Override
    public boolean remove(Long id) {
        LambdaQueryWrapper<UserRole> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(UserRole::getRoleId, id);
        if (userRoleRepository.count(wrapper) > 0) {
            throw new BizException(GlobalMessage.FAIL.getCode(), UserMsg.USER_ROLE_DELETE.getMsg());
        }
        return roleRepository.removeById(id);
    }

}