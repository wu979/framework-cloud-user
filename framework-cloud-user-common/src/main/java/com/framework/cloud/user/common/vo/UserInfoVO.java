package com.framework.cloud.user.common.vo;

import com.framework.cloud.common.base.BaseVO;
import com.framework.cloud.user.common.enums.UserStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 用户 详情VO
 *
 * @author wusiwei
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoVO extends BaseVO {

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String nickname;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "个人简介")
    private String introduction;

    @ApiModelProperty(value = "盐值")
    private String salt;

    @ApiModelProperty(value = "头像url")
    private String avatar;

    @ApiModelProperty(value = "用户状态（ CANCELLATION=注销，NORMAL=正常，DISABLE=禁用 ）")
    private UserStatus status;

}