package com.framework.cloud.user.domain.repository;

import com.framework.cloud.common.enums.GlobalNumber;
import com.framework.cloud.mybatis.repository.BaseRepository;
import com.framework.cloud.user.common.enums.ArithmeticEnum;
import com.framework.cloud.user.common.enums.DirectionEnum;
import com.framework.cloud.user.common.enums.JudgeEnum;
import com.framework.cloud.user.common.vo.PermissionInfoVO;
import com.framework.cloud.user.common.vo.PermissionRoleListVO;
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
     * 权限 列表
     *
     * @return 列表
     */
    List<PermissionRoleListVO> listAll();

    /**
     * 权限 树
     *
     * @param query 复合查询（名称、编号）
     * @return 树
     */
    List<PermissionTreeVO> listTree(String query);

    /**
     * 获取下一级所有节点
     *
     * @param parentId 父级id
     * @return 所有子节点
     */
    List<Permission> nextNodeByParentId(Long parentId);

    /**
     * 根据左、右值 获取节点下所有子节点
     *
     * @param left    左节点
     * @param right   右节点
     * @param traceId 祖链
     * @return 所有子节点
     */
    List<Permission> nextNodeAll(Integer left, Integer right, Long traceId);

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
     * @param code 标识
     * @return 是否成功
     */
    Permission getByCode(String code);

    /**
     * 详情
     *
     * @param parentId 父级id
     * @return 是否成功
     */
    Permission getByParentId(Long parentId);

    /**
     * 批量删除
     *
     * @param permissions 节点列表
     * @return 是否成功
     */
    boolean batchDelete(List<Permission> permissions);

    /**
     * 获取左值获取后续节点
     *
     * @param direction 左、右 枚举
     * @param judge     大于、大于等于 枚举
     * @param traceId   祖链id
     * @param value     左值 根据左值查询数据
     * @return 节点列表
     */
    List<Permission> followUpNode(DirectionEnum direction, JudgeEnum judge, Long traceId, Integer value);

    /**
     * 更新节点
     *
     * @param direction   左、右 枚举
     * @param judge       大于、大于等于 枚举
     * @param arithmetic  加减法 枚举
     * @param value       左值 根据左值查询更新数据
     * @param updateValue 更新值
     * @return 是否成功
     */
    boolean updateTree(DirectionEnum direction, JudgeEnum judge, ArithmeticEnum arithmetic, Long traceId, Integer value, Integer updateValue);

    /**
     * 更新左节点
     */
    default boolean updateLeftTree(JudgeEnum judge, ArithmeticEnum arithmetic, Long traceId, Integer value, Integer updateValue) {
        return updateTree(DirectionEnum.LEFT, judge, arithmetic, traceId, value, updateValue);
    }

    /**
     * 更新右节点
     */
    default boolean updateRightTree(JudgeEnum judge, ArithmeticEnum arithmetic, Long traceId, Integer value, Integer updateValue) {
        return updateTree(DirectionEnum.RIGHT, judge, arithmetic, traceId, value, updateValue);
    }

    /**
     * 更新左节点 （添加部门时更新后续节点）
     */
    default boolean updateLeftTreeByAdd(Long traceId, Integer value) {
        return updateTree(DirectionEnum.LEFT, JudgeEnum.GT, ArithmeticEnum.ADD, traceId, value, GlobalNumber.TWO.getIntValue());
    }

    /**
     * 更新右节点 （添加部门时更新后续节点）
     *
     * @param value 左值 根据左值查询更新数据
     * @return 是否成功
     */
    default boolean updateRightTreeByAdd(Long traceId, Integer value) {
        return updateTree(DirectionEnum.RIGHT, JudgeEnum.GE, ArithmeticEnum.ADD, traceId, value, GlobalNumber.TWO.getIntValue());
    }

    /**
     * 更新左节点 （删除部门时更新后续节点）
     */
    default boolean updateLeftTreeByDelete(Long traceId, Integer value, Integer updateValue) {
        return updateTree(DirectionEnum.LEFT, JudgeEnum.GT, ArithmeticEnum.SUBTRACT, traceId, value, updateValue);
    }

    /**
     * 更新右节点 （删除部门时更新后续节点）
     */
    default boolean updateRightTreeByDelete(Long traceId, Integer value, Integer updateValue) {
        return updateTree(DirectionEnum.RIGHT, JudgeEnum.GT, ArithmeticEnum.SUBTRACT, traceId, value, updateValue);
    }
}