package com.framework.cloud.user.domain.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.framework.cloud.cache.annotation.Lock;
import com.framework.cloud.common.enums.GlobalNumber;
import com.framework.cloud.common.exception.BizException;
import com.framework.cloud.common.result.Result;
import com.framework.cloud.common.utils.AssertUtil;
import com.framework.cloud.common.utils.CopierUtil;
import com.framework.cloud.tree.TreeFeature;
import com.framework.cloud.user.common.constant.CacheConstant;
import com.framework.cloud.user.common.dto.PermissionDTO;
import com.framework.cloud.user.common.msg.UserMsg;
import com.framework.cloud.user.common.rpc.SettingInfoVO;
import com.framework.cloud.user.common.vo.PermissionInfoVO;
import com.framework.cloud.user.common.vo.PermissionTreeVO;
import com.framework.cloud.user.domain.entity.Permission;
import com.framework.cloud.user.domain.feign.PlatFormFeignService;
import com.framework.cloud.user.domain.repository.PermissionRepository;
import com.framework.cloud.user.domain.service.PermissionService;
import com.framework.cloud.user.domain.utils.PermissionUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 权限 服务实现类
 *
 * @author wusiwei
 */
@Service
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final TreeFeature<PermissionTreeVO, Long, Integer> treeFeature;
    private final PermissionRepository permissionRepository;
    private final PlatFormFeignService platFormFeignService;

    @Override
    public List<PermissionTreeVO> tree(String query) {
        List<PermissionTreeVO> tree = permissionRepository.listTree(query);
        return treeFeature.childTree(tree);
    }

    @Override
    public PermissionInfoVO info(Long id) {
        return permissionRepository.info(id);
    }

    @Override
    @Lock(key = "'" + CacheConstant.PERMISSION + "'+#param.parentId", waitTime = 10)
    @Transactional(rollbackFor = Exception.class)
    public boolean save(PermissionDTO param) {
        Permission exist = permissionRepository.getByCode(param.getCode());
        AssertUtil.nonNull(exist, UserMsg.PERMISSION_EXIST.getMsg());
        Permission permission = new Permission();
        CopierUtil.copyProperties(param, permission);
        boolean flag;
        //无父级 添加根节点 否则 普通节点
        if (ObjectUtil.isNull(param.getParentId())) {
            flag = rootNode(param);
        } else {
            flag = ordinaryNode(param);
        }
        return flag;
    }

    @Override
    public boolean update(PermissionDTO param) {
        return false;
    }

    @Override
    @Lock(key = "'" + CacheConstant.PERMISSION + "'+#id", waitTime = 10)
    @Transactional(rollbackFor = Exception.class)
    public boolean remove(Long id) {
        String errorMsg = UserMsg.PERMISSION_DELETE_ERROR.getMsg();
        Permission permission = permissionRepository.getByIdNotNull(id);
        AssertUtil.isTrue(permissionRepository.removeById(id), errorMsg);
        Integer left = permission.getLeft();
        Integer right = permission.getRight();
        Integer updateValue = GlobalNumber.TWO.getIntValue();
        Result<SettingInfoVO> info = platFormFeignService.info();
        AssertUtil.isTrue(info.success(), info);
        SettingInfoVO data = info.getData();
        AssertUtil.isNull(data, errorMsg);
        if (data.getPermissionDelete()) {
            List<Permission> childList = permissionRepository.nextNodeAll(left, right, permission.getTraceId());
            if (CollectionUtil.isNotEmpty(childList)) {
                if (!permissionRepository.batchDelete(childList)) {
                    throw new BizException(errorMsg);
                }
                //子集 + 父级 = 删除的总条数 * 2 = 后续节点减去的值
                updateValue = (childList.size() + 1) * 2;
            }
        } else {
            List<Permission> childList = permissionRepository.nextNodeByParentId(permission.getId());
            if (CollectionUtil.isNotEmpty(childList)) {
                for (Permission child : childList) {
                    child.setParentId(permission.getParentId());
                }
                permissionRepository.updateBatchById(childList);
            }
        }
        AssertUtil.isTrue(permissionRepository.updateLeftTreeByDelete(permission.getTraceId(), left, updateValue), errorMsg);
        AssertUtil.isTrue(permissionRepository.updateRightTreeByDelete(permission.getTraceId(), left, updateValue), errorMsg);
        return true;
    }

    /**
     * 普通节点
     */
    private boolean ordinaryNode(PermissionDTO param) {
        Permission parent = permissionRepository.getByParentId(param.getParentId());
        AssertUtil.isNull(parent, UserMsg.PERMISSION_PARENT_NOT_FOUND.getMsg());
        Permission permission = PermissionUtil.buildPermission(parent, param);
        //更新后续左节点
        if (!permissionRepository.updateLeftTreeByAdd(parent.getTraceId(), permission.getLeft())) {
            return false;
        }
        //更新后续右节点
        if (!permissionRepository.updateRightTreeByAdd(parent.getTraceId(), permission.getLeft())) {
            return false;
        }
        return permissionRepository.save(permission);
    }

    /**
     * 根节点
     */
    private boolean rootNode(PermissionDTO param) {
        return permissionRepository.save(PermissionUtil.buildPermission(param));
    }
}