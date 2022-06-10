package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.UserRole;
import org.apache.ibatis.annotations.Param;

/**
 * 用户角色关联 数据库接口
 *
 * @author wusiwei
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    IPage<UserRolePageVO> page(@Param("pg") Page<UserRolePageVO> page, @Param("param") UserRolePageDTO param);

}