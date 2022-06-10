package com.framework.cloud.user.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.Role;

import java.util.List;

/**
 * 角色 服务层接口
 *
 * @author wusiwei
 */
public interface RoleService {
    /**
     * 角色 分页
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<RolePageVO> page(RolePageDTO param);

    /**
     * 详情
     *
     * @param id 主键
     * @return 是否成功
     */
    RoleInfoVO info(Long id);

    /**
     * 新增/修改
     *
     * @param param 新增修改参数
     * @return 是否成功
     */
    boolean saveUpdate(RoleDTO param);

    /**
     * 删除
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean removes(List<Long> ids);

}