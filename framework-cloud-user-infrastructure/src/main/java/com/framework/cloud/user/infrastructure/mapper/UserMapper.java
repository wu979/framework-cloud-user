package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.user.common.dto.UserPageDTO;
import com.framework.cloud.user.common.vo.UserIdentifierVO;
import com.framework.cloud.user.common.vo.UserPageVO;
import com.framework.cloud.user.domain.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * 用户 数据库接口
 *
 * @author wusiwei
 */
public interface UserMapper extends BaseMapper<User> {

    IPage<UserPageVO> page(@Param("pg") Page<UserPageVO> page, @Param("param") UserPageDTO param);

    /**
     * 排除租户拦截器 {@link com.baomidou.mybatisplus.annotation.InterceptorIgnore}
     *
     * @param tenantId   租户id
     * @param identifier 唯一标识
     */
    @InterceptorIgnore(tenantLine = "true")
    UserIdentifierVO user(@Param("tenantId") Long tenantId, @Param("identifier") String identifier);

}