package com.framework.cloud.user.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.UserAuth;

/**
 * 用户认证方式 数据层接口
 *
 * @author wusiwei
 */
public interface UserAuthRepository extends BaseRepository<UserAuth> {

    /**
     * 用户认证方式分页列表
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<UserAuthPageVO> page(UserAuthPageDTO param);

    /**
     * 详情
     *
     * @param id 主键
     * @return 是否成功
     */
    UserAuthInfoVO info(Long id);

}