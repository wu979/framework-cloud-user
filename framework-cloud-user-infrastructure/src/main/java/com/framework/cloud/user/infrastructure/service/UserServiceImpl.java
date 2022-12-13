package com.framework.cloud.user.infrastructure.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.common.exception.BizException;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.common.utils.AssertUtil;
import com.framework.cloud.mybatis.utils.SnowflakeUtil;
import com.framework.cloud.user.common.dto.PayChannelDTO;
import com.framework.cloud.user.common.dto.UserDTO;
import com.framework.cloud.user.common.dto.UserPageDTO;
import com.framework.cloud.user.common.enums.UserIdentityType;
import com.framework.cloud.user.common.enums.UserSexType;
import com.framework.cloud.user.common.enums.UserStatus;
import com.framework.cloud.user.common.msg.UserMsg;
import com.framework.cloud.user.common.vo.UserIdentifierVO;
import com.framework.cloud.user.common.vo.UserInfoVO;
import com.framework.cloud.user.common.vo.UserPageVO;
import com.framework.cloud.user.domain.entity.User;
import com.framework.cloud.user.domain.entity.UserAuth;
import com.framework.cloud.user.domain.feign.PlatFormFeignService;
import com.framework.cloud.user.domain.repository.UserAuthRepository;
import com.framework.cloud.user.domain.repository.UserRepository;
import com.framework.cloud.user.domain.service.UserService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.AllArgsConstructor;
import org.apache.shardingsphere.transaction.annotation.ShardingSphereTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
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
    private final PlatFormFeignService platFormFeignService;

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
        UserIdentifierVO user = userRepository.user(tenantId, identifier);
        AssertUtil.isNull(user, UserMsg.USER_NOT_FOUND.getMsg());
        AssertUtil.isTrue(user.getIsBinding(), UserMsg.USER_BINDING.getMsg());
        AssertUtil.isTrue(user.getIsVerified(), UserMsg.USER_VERIFIED.getMsg());
        AssertUtil.isTrue(UserStatus.NORMAL.equals(user.getStatus()), UserMsg.USER_VERIFIED.getMsg());
        return user;
    }

    @Override
    @GlobalTransactional(rollbackFor = { Exception.class , BizException.class })
    @ShardingSphereTransactionType(value = TransactionType.BASE)
    public boolean saveUpdate(UserDTO param) {
        User entity = buildUser();
        UserAuth userAuth = buildUserAuth(entity.getId());
        userRepository.save(entity);
        userAuthRepository.save(userAuth);
        System.out.println(RootContext.getXID());
        Result<Boolean> save = platFormFeignService.save(buildPayChannel());
        int i = 1 / 0;
        return true;
    }

    @Override
    public boolean removes(List<Long> ids) {
        return userRepository.removeByIds(ids);
    }

    private User buildUser() {
        User entity = new User();
        entity.setId(SnowflakeUtil.nextId());
        entity.setSex(UserSexType.MAN);
        entity.setEmail("13881666963@163.com");
        entity.setMobile("13881666963");
        entity.setUsername("888");
        entity.setNickname("888");
        entity.setBirthday(LocalDate.now());
        entity.setIntroduction("wwwwwwwwww");
        entity.setAvatar("fff");
        entity.setStatus(UserStatus.NORMAL);
        return entity;
    }

    private UserAuth buildUserAuth(Long userId) {
        UserAuth userAuth = new UserAuth();
        userAuth.setUserId(userId);
        userAuth.setIdentityType(UserIdentityType.MOBILE);
        userAuth.setIdentifier("13881666963");
        userAuth.setCredential("wsw979");
        userAuth.setIsVerified(true);
        userAuth.setIsBinding(true);
        userAuth.setVerifiedTime(System.currentTimeMillis());
        userAuth.setUnBindingTime(System.currentTimeMillis());
        return userAuth;
    }

    private PayChannelDTO buildPayChannel() {
        PayChannelDTO channelDTO = new PayChannelDTO();
        channelDTO.setCode("111111");
        channelDTO.setName("111111");
        channelDTO.setType("WX");
        channelDTO.setAppKey("1");
        channelDTO.setAppSecret("1");
        channelDTO.setPrivateKey("1");
        channelDTO.setPublicKey("1");
        channelDTO.setExternalPublicKey("1");
        channelDTO.setRemarks("1");
        channelDTO.setEnable(false);
        return channelDTO;
    }
}