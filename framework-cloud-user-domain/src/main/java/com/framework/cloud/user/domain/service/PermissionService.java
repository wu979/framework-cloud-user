package com.framework.cloud.user.domain.service;

import com.framework.cloud.user.common.dto.PermissionDTO;
import com.framework.cloud.user.common.vo.PermissionInfoVO;
import com.framework.cloud.user.common.vo.PermissionRoleListVO;
import com.framework.cloud.user.common.vo.PermissionTreeVO;

import java.util.List;

/**
 * 权限 服务层接口
 *
 * @author wusiwei
 */
public interface PermissionService {

    /**
     * 权限 列表
     *
     * @return 列表
     */
    List<PermissionRoleListVO> list();

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
     * 新增
     *
     * @param param 新增参数
     * @return 是否成功
     */
    boolean save(PermissionDTO param);

    /**
     * 修改
     *
     * @param param 修改参数
     * @return 是否成功
     */
    boolean update(PermissionDTO param);

    /**
     * 删除
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean remove(Long id);

}