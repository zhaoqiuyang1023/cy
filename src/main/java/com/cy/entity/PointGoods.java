package com.cy.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("points_goods")
public class PointGoods {
    @TableId(type = IdType.UUID)
    private String id;
    private String goodName;
    private Integer points;
    private String picture;


}
