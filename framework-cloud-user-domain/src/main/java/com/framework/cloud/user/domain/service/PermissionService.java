package com.framework.cloud.user.domain.service;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.user.common.dto.PermissionDTO;
import com.framework.cloud.user.common.dto.PermissionPageDTO;
import com.framework.cloud.user.common.vo.PermissionInfoVO;
import com.framework.cloud.user.common.vo.PermissionPageVO;
import com.framework.cloud.user.common.vo.PermissionTreeVO;

import java.util.List;

/**
 * 权限 服务层接口
 *
 * @author wusiwei
 */
public interface PermissionService {
    /**
     * 权限 分页
     *
     * @param param 分页参数
     * @return 数据
     */
    PageVO<PermissionPageVO> page(PermissionPageDTO param);

    /**
     * 权限 树
     *
     * @param query 复合查询（名称、编号）
     * @return 树
     */
    List<PermissionTreeVO> tree(String query);

    /**
     * 详情
     *
     * @param id 主键
     * @return 是否成功
     */
    PermissionInfoVO info(Long id);

    /**
     * 详情
     *
     * @param id 主键
     * @return 是否成功
     */
    PermissionInfoVO info2(Long id);

    /**
     * 新增/修改
     *
     * @param param 新增修改参数
     * @return 是否成功
     */
    boolean saveUpdate(PermissionDTO param);

    /**
     * 删除
     *
     * @param ids 主键
     * @return 是否成功
     */
    boolean removes(List<Long> ids);

}