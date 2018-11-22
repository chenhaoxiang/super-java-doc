/**
 * uifuture.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通用接口
 *
 * @author chenhx
 * @version CommController.java, v 0.1 2018-09-26 下午 6:28
 */
@RestController
public class CommController {
    /**
     * 首页
     *
     * @return 首页页面
     */
    @RequestMapping("index")
    public String index() {
        return "index";
    }
}
