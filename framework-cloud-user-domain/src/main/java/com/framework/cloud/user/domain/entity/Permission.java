package com.framework.cloud.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.framework.cloud.common.base.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * 权限 实体
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_permission")
@ApiModel(value="权限对象", description="权限")
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

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