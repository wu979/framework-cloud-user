package com.framework.cloud.user.common.dto;

import com.framework.cloud.common.group.Save;
import com.framework.cloud.common.group.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * 角色 新增修改DTO
 *
 * @author wusiwei
 */
@Data
public class RoleDTO {

    @Null(message = "新增时主键为空", groups = Save.class)
    @NotNull(message = "修改时主键不能为空", groups = Update.class)
    @ApiModelProperty(value = "主键")
    private Long id;

    @NotBlank(message = "角色名称不能为空")
    @ApiModelProperty(value = "角色名称")
    private String name;

    @NotBlank(message = "角色标识不能为空")
    @ApiModelProperty(value = "角色标识")
    private String code;
}
