package com.framework.cloud.user.infrastructure.repository;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.framework.cloud.common.utils.StringUtil;
import com.framework.cloud.mybatis.repository.impl.BaseRepositoryImpl;
import com.framework.cloud.user.common.enums.ArithmeticEnum;
import com.framework.cloud.user.common.enums.DirectionEnum;
import com.framework.cloud.user.common.enums.JudgeEnum;
import com.framework.cloud.user.common.vo.PermissionInfoVO;
import com.framework.cloud.user.common.vo.PermissionRoleListVO;
import com.framework.cloud.user.common.vo.PermissionTreeVO;
import com.framework.cloud.user.domain.entity.Permission;
import com.framework.cloud.user.domain.repository.PermissionRepository;
import com.framework.cloud.user.infrastructure.converter.PermissionConverter;
import com.framework.cloud.user.infrastructure.mapper.PermissionMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 权限 数据实现层
 *
 * @author wusiwei
 */
@Repository
@AllArgsConstructor
public class PermissionRepositoryImpl extends BaseRepositoryImpl<PermissionMapper, Permission> implements PermissionRepository {

    private final PermissionConverter permissionConverter;

    @Override
    public List<PermissionRoleListVO> listAll() {
        return this.baseMapper.listAll();
    }

    @Override
    public List<PermissionTreeVO> listTree(String query) {
        List<Permission> list;
        if (StringUtil.isNotEmpty(query)) {
            LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(Permission::getName, query).or().eq(Permission::getCode, query);
            list = this.list(wrapper);
        } else {
            list = this.list();
        }
        return permissionConverter.list(list);
    }

    @Override
    public List<Permission> nextNodeByParentId(Long parentId) {
        LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Permission::getParentId, parentId);
        return this.list(wrapper);
    }

    @Override
    public List<Permission> nextNodeAll(Integer left, Integer right, Long traceId) {
        LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Permission::getTraceId, traceId);
        wrapper.ge(Permission::getLeft, left);
        wrapper.le(Permission::getRight, right);
        return this.list(wrapper);
    }

    @Override
    public PermissionInfoVO info(Long id) {
        Permission entity = this.getById(id);
        return permissionConverter.info(entity);
    }

    @Override
    public Permission getByCode(String code) {
        LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Permission::getCode, code);
        return this.getOne(wrapper);
    }

    @Override
    public Permission getByParentId(Long parentId) {
        LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Permission::getId, parentId);
        return this.getOne(wrapper);
    }

    @Override
    public boolean batchDelete(List<Permission> permissions) {
        List<Long> ids = permissions.stream().map(Permission::getId).collect(Collectors.toList());
        return this.baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public List<Permission> followUpNode(DirectionEnum direction, JudgeEnum judge, Long traceId, Integer value) {
        LambdaQueryWrapper<Permission> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Permission::getTraceId, traceId);
        if (Objects.equals(DirectionEnum.LEFT, direction)) {
            if (Objects.equals(JudgeEnum.GT, judge)) {
                wrapper.gt(Permission::getLeft, value);
            } else {
                wrapper.ge(Permission::getLeft, value);
            }
        } else {
            if (Objects.equals(JudgeEnum.GT, judge)) {
                wrapper.gt(Permission::getRight, value);
            } else {
                wrapper.ge(Permission::getRight, value);
            }
        }
        return this.list(wrapper);
    }

    @Override
    public boolean updateTree(DirectionEnum direction, JudgeEnum judge, ArithmeticEnum arithmetic, Long traceId, Integer value, Integer updateValue) {
        if (Objects.isNull(updateValue)) {
            return true;
        }
        List<Permission> followUpNodeList = followUpNode(direction, judge, traceId, value);
        //无分支节点 无需更新
        if (CollectionUtil.isEmpty(followUpNodeList)) {
            return true;
        }
        for (Permission department : followUpNodeList) {
            if (Objects.equals(DirectionEnum.LEFT, direction)) {
                if (Objects.equals(ArithmeticEnum.ADD, arithmetic)) {
                    department.setLeft(department.getLevel() + updateValue);
                } else {
                    department.setLeft(department.getLevel() - updateValue);
                }
            } else {
                if (Objects.equals(ArithmeticEnum.ADD, arithmetic)) {
                    department.setRight(department.getRight() + updateValue);
                } else {
                    department.setRight(department.getRight() - updateValue);
                }
            }
        }
        return this.updateBatchById(followUpNodeList);
    }
}