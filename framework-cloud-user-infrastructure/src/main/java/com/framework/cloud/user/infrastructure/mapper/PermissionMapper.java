package com.framework.cloud.user.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.framework.cloud.user.common.vo.PermissionRoleListVO;
import com.framework.cloud.user.domain.entity.Permission;

import java.util.List;

/**
 * 权限 数据库接口
 *
 * @author wusiwei
 */
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 权限列表
     */
    List<PermissionRoleListVO> listAll();
}