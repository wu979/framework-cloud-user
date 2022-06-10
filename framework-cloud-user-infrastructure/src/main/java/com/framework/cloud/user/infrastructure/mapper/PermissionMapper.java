package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.Permission;
import org.apache.ibatis.annotations.Param;

/**
 * 权限 数据库接口
 *
 * @author wusiwei
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    IPage<PermissionPageVO> page(@Param("pg") Page<PermissionPageVO> page, @Param("param") PermissionPageDTO param);

}