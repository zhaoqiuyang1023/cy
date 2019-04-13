package com.cy.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Alan
 * @since 2019-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户手机号")
    private Long tel;

    @ApiModelProperty(value = "用户头像")
    private String picture;

    @ApiModelProperty(value = "是否可用用户状态/0不可用,1可用")
    private String state;

    @ApiModelProperty(value = "等级积分")
    private Double points;

    private LocalDateTime createTime;

    private String device;


}
