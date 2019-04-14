package com.cy.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("points_goods_conver")
public class PointsGoodsConver {
    @TableId(type = IdType.UUID)
    private String id;
    private String shopName;
    private String shopId;
    private String userId;
    private String userName;

}
