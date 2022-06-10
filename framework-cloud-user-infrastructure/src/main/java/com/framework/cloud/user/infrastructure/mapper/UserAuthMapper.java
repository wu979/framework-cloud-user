package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.UserAuth;
import org.apache.ibatis.annotations.Param;

/**
 * 用户认证方式 数据库接口
 *
 * @author wusiwei
 */
public interface UserAuthMapper extends BaseMapper<UserAuth> {

    IPage<UserAuthPageVO> page(@Param("pg") Page<UserAuthPageVO> page, @Param("param") UserAuthPageDTO param);

}