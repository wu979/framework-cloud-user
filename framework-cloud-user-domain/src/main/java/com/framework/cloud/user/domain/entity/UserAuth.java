package com.framework.cloud.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.framework.cloud.common.base.BaseTenant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 用户认证方式 实体
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_user_auth")
@ApiModel(value="用户认证方式对象", description="用户认证方式")
public class UserAuth extends BaseTenant {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    @ApiModelProperty(value = "用户id")
    private Long userId;

    @ApiModelProperty(value = "身份类型（MOBILE:用户名,USERNAME:手机号,EMAIL:邮箱,WX:微信,ZFB:支付宝）")
    private String identityType;

    @ApiModelProperty(value = "唯一标识")
    private String identifier;

    @ApiModelProperty(value = "授权凭证")
    private String credential;

    @ApiModelProperty(value = "是否已经验证")
    private Boolean isVerified;

    @ApiModelProperty(value = "是否绑定中")
    private Boolean isBinding;

    @ApiModelProperty(value = "验证时间")
    private Long verifiedTime;

    @ApiModelProperty(value = "解除绑定时间")
    private Long unBindingTime;

}