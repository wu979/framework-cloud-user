package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.Role;
import org.apache.ibatis.annotations.Param;

/**
 * 角色 数据库接口
 *
 * @author wusiwei
 */
public interface RoleMapper extends BaseMapper<Role> {

    IPage<RolePageVO> page(@Param("pg") Page<RolePageVO> page, @Param("param") RolePageDTO param);

}