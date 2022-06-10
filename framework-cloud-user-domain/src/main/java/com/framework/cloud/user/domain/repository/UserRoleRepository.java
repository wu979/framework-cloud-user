package com.framework.cloud.user.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.UserRole;

/**
 * 用户角色关联 数据层接口
 *
 * @author wusiwei
 */
public interface UserRoleRepository extends BaseRepository<UserRole> {

    /**
     * 用户角色关联分页列表
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<UserRolePageVO> page(UserRolePageDTO param);

    /**
     * 详情
     *
     * @param id 主键
     * @return 是否成功
     */
    UserRoleInfoVO info(Long id);

}