package com.framework.cloud.user.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.user.common.dto.RolePageDTO;
import com.framework.cloud.user.common.vo.RoleInfoVO;
import com.framework.cloud.user.common.vo.RolePageVO;
import com.framework.cloud.user.domain.entity.Role;

import java.util.List;

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
     * 根据用户id获取角色列表
     *
     * @param userId 用户id
     * @return 角色列表
     */
    List<Role> list(Long userId);

    /**
     * 根据标识获取角色
     *
     * @param code 标识
     * @return 角色
     */
    Role infoByCode(String code);

    /**
     * 详情
     *
     * @param id 主键
     * @return 是否成功
     */
    RoleInfoVO info(Long id);

}