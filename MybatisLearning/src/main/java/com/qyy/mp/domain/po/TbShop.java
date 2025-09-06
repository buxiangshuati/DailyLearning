package com.qyy.mp.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Qian
 * @since 2025-09-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("tb_shop")
@Schema(description="TbShop对象")
public class TbShop implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "商铺名称")
    private String name;

    @Schema(description = "商铺类型的id")
    private Long typeId;

    @Schema(description = "商铺图片，多个图片以','隔开")
    private String images;

    @Schema(description = "商圈，例如陆家嘴")
    private String area;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "经度")
    private Double x;

    @Schema(description = "维度")
    private Double y;

    @Schema(description = "均价，取整数")
    private Long avgPrice;

    @Schema(description = "销量")
    private Integer sold;

    @Schema(description = "评论数量")
    private Integer comments;

    @Schema(description = "评分，1~5分，乘10保存，避免小数")
    private Integer score;

    @Schema(description = "营业时间，例如 10:00-22:00")
    private String openHours;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;


}
