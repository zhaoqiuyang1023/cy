package com.cy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.cy.common.R;
import com.cy.entity.User;
import com.cy.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login/{username}/{password}")
    public R<User> Login(@PathVariable("username") String username, @PathVariable("password") String password) {
        User user = userService.getOne(new QueryWrapper<User>().eq("username", username).eq("password", password));
        return new R<>(user);
    }
}

