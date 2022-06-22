package com.framework.cloud.user.domain.service.impl;
import com.framework.cloud.mybatis.utils.SnowflakeUtil;
import com.framework.cloud.user.common.enums.UserIdentityType;
import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.user.common.dto.UserDTO;
import com.framework.cloud.user.common.dto.UserPageDTO;
import com.framework.cloud.user.common.enums.UserSexType;
import com.framework.cloud.user.common.enums.UserStatus;
import com.framework.cloud.user.common.vo.UserIdentifierVO;
import com.framework.cloud.user.common.vo.UserInfoVO;
import com.framework.cloud.user.common.vo.UserPageVO;
import com.framework.cloud.user.domain.entity.User;
import com.framework.cloud.user.domain.entity.UserAuth;
import com.framework.cloud.user.domain.repository.UserAuthRepository;
import com.framework.cloud.user.domain.repository.UserRepository;
import com.framework.cloud.user.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
    private final UserAuthRepository userAuthRepository;

    @Override
    public PageVO<UserPageVO> page(UserPageDTO param) {
        return userRepository.page(param);
    }

    @Override
    public UserInfoVO info(Long id) {
        return userRepository.info(id);
    }

    @Override
    public UserIdentifierVO user(Long tenantId, String identifier) {
        return userRepository.user(tenantId, identifier);
    }

    @Override
    public boolean saveUpdate(UserDTO param) {
        User entity = new User();
        entity.setId(SnowflakeUtil.nextId());
        entity.setSex(UserSexType.MAN);
        entity.setEmail("18683789594@163.com");
        entity.setMobile("18683789594");
        entity.setUsername("979");
        entity.setNickname("979");
        entity.setBirthday(LocalDate.now());
        entity.setIntroduction("wwwwwwwwww");
        entity.setAvatar("fff");
        entity.setStatus(UserStatus.NORMAL);

        UserAuth userAuth = new UserAuth();
        userAuth.setUserId(entity.getId());
        userAuth.setIdentityType(UserIdentityType.MOBILE);
        userAuth.setIdentifier("18683789594");
        userAuth.setCredential("wsw979");
        userAuth.setIsVerified(true);
        userAuth.setIsBinding(true);
        userAuth.setVerifiedTime(System.currentTimeMillis());
        userAuth.setUnBindingTime(System.currentTimeMillis());
        userRepository.save(entity);
        userAuthRepository.save(userAuth);
        return true;
    }

    @Override
    public boolean removes(List<Long> ids) {
        return userRepository.removeByIds(ids);
    }

}