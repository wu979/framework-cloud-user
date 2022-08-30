package com.framework.cloud.user.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.user.common.dto.UserPageDTO;
import com.framework.cloud.user.common.vo.UserIdentifierVO;
import com.framework.cloud.user.common.vo.UserInfoVO;
import com.framework.cloud.user.common.vo.UserPageVO;
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

    /**
     * 查询用户
     *
     * @param tenantId   租户id
     * @param identifier 唯一凭证
     * @return 用户
     */
    UserIdentifierVO user(Long tenantId, String identifier);
}