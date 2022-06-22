package com.framework.cloud.user.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.user.common.dto.RoleDTO;
import com.framework.cloud.user.common.dto.RolePageDTO;
import com.framework.cloud.user.common.vo.RolePageVO;

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
     * 根据用户id获取角色标识列表
     *
     * @param userId 用户id
     * @return 角色标识列表
     */
    List<String> list(Long userId);

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
     * @param id 主键
     * @return 是否成功
     */
    boolean remove(Long id);

}