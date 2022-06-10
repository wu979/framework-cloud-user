package com.framework.cloud.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.cloud.common.base.BaseTenant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 角色权限关联 实体
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_role_permission")
@ApiModel(value="角色权限关联对象", description="角色权限关联")
public class RolePermission extends BaseTenant {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "权限id")
    private Long permissionId;

}