package com.framework.cloud.user.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.user.common.vo.*;
import com.framework.cloud.user.common.dto.*;
import com.framework.cloud.user.domain.entity.User;

/**
 * 用户 数据层接口
 *
 * @author wusiwei
 */
public interface UserRepository extends BaseRepository<User> {

    /**
     * 用户分页列表
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<UserPageVO> page(UserPageDTO param);

    /**
     * 详情
     *
     * @param id 主键
     * @return 是否成功
     */
    UserInfoVO info(Long id);

}