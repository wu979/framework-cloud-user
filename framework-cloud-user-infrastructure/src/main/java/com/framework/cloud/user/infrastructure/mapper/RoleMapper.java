package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.framework.cloud.user.common.dto.RolePageDTO;
import com.framework.cloud.user.common.vo.RolePageVO;
import com.framework.cloud.user.domain.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色 数据库接口
 *
 * @author wusiwei
 */
public interface RoleMapper extends BaseMapper<Role> {

    IPage<RolePageVO> page(@Param("pg") Page<RolePageVO> page, @Param("param") RolePageDTO param);

    @InterceptorIgnore(tenantLine = "true")
    List<Role> list(@Param("userId") Long userId);
}