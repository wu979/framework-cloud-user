package com.framework.cloud.user.common.vo;

import com.framework.cloud.common.annotation.CacheTarget;
import com.framework.cloud.common.base.BaseVO;
import com.framework.cloud.user.common.enums.PermissionType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 权限 详情VO
 *
 * @author wusiwei
 */
@Data
@CacheTarget
@EqualsAndHashCode(callSuper = true)
public class PermissionInfoVO extends BaseVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "权限名称")
    private String name;

    @ApiModelProperty(value = "权限编码")
    private String code;

    @ApiModelProperty(value = "权限类型")
    private PermissionType type;

    @ApiModelProperty(value = "权限图标")
    private String icon;

    @ApiModelProperty(value = "权限排序")
    private Integer sort;

    @ApiModelProperty(value = "权限层级")
    private Integer level;

    @ApiModelProperty(value = "权限左值")
    private Integer left;

    @ApiModelProperty(value = "权限右值")
    private Integer right;

    @ApiModelProperty(value = "请求路径")
    private String path;

    @ApiModelProperty(value = "父级id")
    private Long parentId;

    @ApiModelProperty(value = "祖链id")
    private Long traceId;

    @ApiModelProperty(value = "是否显示")
    private Boolean isShow;

    @ApiModelProperty(value = "是否初始化（是否初始化给租户）")
    private Boolean isInit;

}