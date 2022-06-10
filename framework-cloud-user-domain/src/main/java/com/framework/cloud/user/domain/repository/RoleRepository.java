package com.framework.cloud.user.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.Role;

/**
 * 角色 数据层接口
 *
 * @author wusiwei
 */
public interface RoleRepository extends BaseRepository<Role> {

    /**
     * 角色分页列表
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

}