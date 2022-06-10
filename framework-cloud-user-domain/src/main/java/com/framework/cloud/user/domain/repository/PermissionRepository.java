package com.framework.cloud.user.domain.repository;

import com.framework.cloud.common.base.PageVO;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.user.common.dto.PermissionPageDTO;
import com.framework.cloud.user.common.vo.PermissionInfoVO;
import com.framework.cloud.user.common.vo.PermissionPageVO;
import com.framework.cloud.user.common.vo.PermissionTreeVO;
import com.framework.cloud.user.domain.entity.Permission;

import java.util.List;

/**
 * 权限 数据层接口
 *
 * @author wusiwei
 */
public interface PermissionRepository extends BaseRepository<Permission> {

    /**
     * 权限分页列表
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
    List<PermissionTreeVO> listTree(String query);

    /**
     * 详情
     *
     * @param id 主键
     * @return 是否成功
     */
    PermissionInfoVO info(Long id);

}