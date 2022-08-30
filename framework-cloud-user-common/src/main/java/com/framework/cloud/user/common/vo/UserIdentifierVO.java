package com.framework.cloud.user.common.vo;

import com.framework.cloud.user.common.enums.UserIdentityType;
import com.framework.cloud.user.common.enums.UserStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author wusiwei
 */
@Data
public class UserIdentifierVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "租户id")
    private Long tenantId;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "唯一标识")
    private String identifier;

    @ApiModelProperty(value = "授权凭证")
    private String credential;

    @ApiModelProperty(value = "是否已经验证")
    private Boolean isVerified;

    @ApiModelProperty(value = "是否绑定中")
    private Boolean isBinding;

    @ApiModelProperty(value = "用户状态")
    private UserStatus status;

    @ApiModelProperty(value = "身份类型")
    private UserIdentityType identityType;
}
