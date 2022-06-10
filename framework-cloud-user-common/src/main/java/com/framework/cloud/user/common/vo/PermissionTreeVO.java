package com.framework.cloud.user.common.vo;

import com.framework.cloud.tree.binary.BinaryTree;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限 树VO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PermissionTreeVO extends BinaryTree<PermissionTreeVO, Long, Integer, Integer> {
    private static final long serialVersionUID = 4057952731966878118L;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限编码")
    private String code;

    @ApiModelProperty(value = "权限类型")
    private String type;

    @ApiModelProperty(value = "权限图标")
    private String icon;

    @ApiModelProperty(value = "权限排序")
    private Integer sort;

    @ApiModelProperty(value = "请求路径")
    private String path;

}
