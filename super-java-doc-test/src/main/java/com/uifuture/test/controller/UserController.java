/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.test.controller;

import com.uifuture.test.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 用户模块
 *
 * @author chenhx
 * @version UserController.java, v 0.1 2018-09-26 下午 6:28
 */
@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 登录
     *
     * @param username 用户名|必填
     * @param password 密码
     * @return 当前登录用户的基本信息
     * @resp code 返回码(0000表示登录成功,其它表示失败)|string|必填
     * @resp msg 登录信息|string
     * @resp username 登录成功后返回的用户名|string
     */
    @ResponseBody
    @PostMapping("/login")
    public Map<String, String> login(String username, String password) {
        Map<String, String> model = new HashMap<>();
        model.put("code", "0000");
        model.put("msg", "登录成功");
        model.put("username", username);
        return model;
    }


    /**
     * 用户注册
     *
     * @param user :username 用户名|必填
     * @param user :password 密码
     * @return 注册后生成的用户的基本信息
     * @respbody {"id":"123","password":"123456","username":"admin"}
     * @title 注册
     * @resp score 分数
     * @see User
     */
    @ResponseBody
    @RequestMapping(value = "register", method = {RequestMethod.POST, RequestMethod.PUT})
    User register(User user, @RequestParam(value = "abc", required = false) List<MultipartFile> list) {
        user.setId(UUID.randomUUID().toString());
        return user;
    }
}
