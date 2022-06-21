package com.framework.cloud.user.common.dto;

import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import com.framework.cloud.user.common.enums.PermissionType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 权限 新增修改DTO
 *
 * @author wusiwei
 */
@Data
public class PermissionDTO {

    @Null(message = "新增时主键为空", groups = Save.class)
    @NotNull(message = "修改时主键不能为空", groups = Update.class)
    @ApiModelProperty(value = "主键")
    private Long id;

    @NotBlank(message = "权限名称不能为空")
    @ApiModelProperty(value = "权限名称")
    private String name;

    @NotBlank(message = "权限标识不能为空")
    @ApiModelProperty(value = "权限编码")
    private String code;

    @NotNull(message = "权限类型不能为空")
    @ApiModelProperty(value = "权限类型")
    private PermissionType type;

    @NotBlank(message = "权限图标不能为空")
    @ApiModelProperty(value = "权限图标")
    private String icon;

    @NotNull(message = "权限排序不能为空")
    @ApiModelProperty(value = "权限排序")
    private Integer sort;

    @NotBlank(message = "请求路径不能为空")
    @ApiModelProperty(value = "请求路径")
    private String path;

    @ApiModelProperty(value = "父级id")
    private Long parentId;

    @ApiModelProperty(value = "是否显示")
    private Boolean isShow;

    @ApiModelProperty(value = "是否初始化（是否初始化给租户）")
    private Boolean isInit;
}
