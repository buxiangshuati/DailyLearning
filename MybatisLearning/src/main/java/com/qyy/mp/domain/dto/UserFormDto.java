package com.qyy.mp.domain.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户表单DTO")
public class UserFormDto {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "余额")
    private Integer balance;

    @Schema(description = "状态" )
    private Integer status;
}
