package com.framework.cloud.user.common.dto;

import com.framework.cloud.common.base.BasePage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 角色 分页DTO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RolePageDTO extends BasePage {

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "角色标识")
    private String code;

}