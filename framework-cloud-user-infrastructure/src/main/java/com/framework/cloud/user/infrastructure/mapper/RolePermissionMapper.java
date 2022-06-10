package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.RolePermission;
import org.apache.ibatis.annotations.Param;

/**
 * 角色权限关联 数据库接口
 *
 * @author wusiwei
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    IPage<RolePermissionPageVO> page(@Param("pg") Page<RolePermissionPageVO> page, @Param("param") RolePermissionPageDTO param);

}