package com.framework.cloud.user.common.vo;

import com.framework.cloud.tree.binary.BinaryTree;
import com.framework.cloud.user.common.enums.PermissionType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色权限关联 已绑定VO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePermissionTreeVO extends BinaryTree<RolePermissionTreeVO, Long, Integer, Integer> {
    private static final long serialVersionUID = -7876799746173123701L;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限编码")
    private String code;

    @ApiModelProperty(value = "权限类型")
    private PermissionType type;

    @ApiModelProperty(value = "请求路径")
    private String path;

    @ApiModelProperty(value = "是否已绑定")
    private Boolean isBinding;
}