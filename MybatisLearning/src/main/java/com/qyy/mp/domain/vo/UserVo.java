package com.qyy.mp.domain.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户视图对象")
public class UserVo {

    @Schema(description = "id")
    private Long id;

    @Schema(description = "昵称")
    private String nickName;

    @Schema(description = "icon")
    private String icon;

    @Schema(description = "余额")
    private Integer balance;

    @Schema(description = "状态" )
    private Integer status;
}
