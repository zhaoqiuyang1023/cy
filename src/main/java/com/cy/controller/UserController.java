package com.cy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cy.common.R;
import com.cy.common.ResponseEnum;
import com.cy.entity.PointGoods;
import com.cy.entity.PointsGoodsConver;
import com.cy.entity.ShopUserRef;
import com.cy.entity.User;
import com.cy.service.PointGoodsService;
import com.cy.service.PointsGoodsConverService;
import com.cy.service.ShopUserRefService;
import com.cy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Alan
 * @since 2019-04-11
 */
@RestController
@RequestMapping("/user")
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PointGoodsService pointGoodsService;

    @Autowired
    private ShopUserRefService shopUserRefService;

    @Autowired
    private PointsGoodsConverService pointsGoodsConverService;


    @RequestMapping("/login/{username}/{password}")
    public R<User> Login(@PathVariable("username") String username, @PathVariable("password") String password) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username).eq("password", password));
        return new R<>(user);
    }

    @RequestMapping("/goods/{userId}")
    public R<List<PointGoods>> findgoods(@PathVariable("userId") String userId) {
        System.out.println(pointGoodsService.list());
        return new R<>(pointGoodsService.list());
    }


    @Transactional
    @RequestMapping("/goods/conversion/{userId}/{goodsId}")
    public R<Boolean> conversion(@PathVariable("userId") String userId, @PathVariable("goodsId") String goodsId) {
        User user = userService.getOne(new QueryWrapper<User>().eq("id", userId));
        PointGoods pointGoods = pointGoodsService.getById(goodsId);
        ShopUserRef shopUserRef = shopUserRefService.getOne(new QueryWrapper<ShopUserRef>().eq("user_id", userId));
        System.out.println(pointGoods);
        System.out.println(user);
        if(shopUserRef==null){
            return new R<>(Boolean.FALSE, ResponseEnum. NoAssociatedStores.getcode(), ResponseEnum. NoAssociatedStores.getDesc());
        }
        if (user.getPoints() > pointGoods.getPoints()) {

            user.setPoints(user.getPoints() - pointGoods.getPoints());
            userService.updateById(user);
            PointsGoodsConver pointsGoodsConver = new PointsGoodsConver();
            pointsGoodsConver.setShopId("" + shopUserRef.getShopId());
            pointsGoodsConver.setShopName("");
            pointsGoodsConver.setUserId(userId);
            pointsGoodsConver.setUserName(user.getUsername());

            return new R<>(pointsGoodsConverService.save(pointsGoodsConver));
        } else {
            return new R<>(Boolean.FALSE, ResponseEnum.LackOfIntegral.getcode(), ResponseEnum.LackOfIntegral.getDesc());
        }


    }

}

