package com.framework.cloud.user.infrastructure.service;

import com.framework.cloud.user.domain.repository.UserRoleRepository;
import com.framework.cloud.user.domain.service.UserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户角色关联 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;


}