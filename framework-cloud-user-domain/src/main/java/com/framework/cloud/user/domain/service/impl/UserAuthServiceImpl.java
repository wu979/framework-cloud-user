package com.framework.cloud.user.domain.service.impl;

import com.framework.cloud.user.domain.repository.UserAuthRepository;
import com.framework.cloud.user.domain.service.UserAuthService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * 用户认证方式 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class UserAuthServiceImpl implements UserAuthService {

    private final UserAuthRepository userAuthRepository;

}