package com.framework.cloud.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户角色关联 实体
 *
 * @author wusiwei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_role")
@ApiModel(value = "用户角色关联对象", description = "用户角色关联")
public class UserRole {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关联角色")
    private Long roleId;

    @ApiModelProperty(value = "关联用户表")
    private Long userId;

}