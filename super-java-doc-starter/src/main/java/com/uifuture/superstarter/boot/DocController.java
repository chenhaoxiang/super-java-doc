/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.superstarter.boot;

import com.uifuture.supercore.SuperJavaDoc;
import com.uifuture.supercore.model.ApiDoc;
import com.uifuture.supercore.utils.JsonUtils;
import com.uifuture.superspring.framework.SpringWebFramework;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author chenhx
 * @version docController.java, v 0.1 2018-09-26 下午 6:11
 */
@RequestMapping("superJavaDoc")
public class DocController {
    private static final Logger LOGGER = getLogger(DocController.class);
    private static ApiDoc apiDoc; 
    @Autowired
    private DocProperties docProperties;

    @PostConstruct
    public void init() {
        if (!docProperties.isEnable()) {
            return;
        }

        String path = docProperties.getSourcePath();

        if (StringUtils.isBlank(path)) {
            //默认为当前目录
            path = ".";
        }

        List<String> paths = Arrays.asList(path.split(","));

        LOGGER.debug("starting SuperJavaDoc, source path:{}", paths);

        try {
            SuperJavaDoc superJavaDoc = new SuperJavaDoc(paths, new SpringWebFramework());

            Thread thread = new Thread(() -> {
                try {
                    apiDoc = superJavaDoc.resolve();
                    HashMap<String, Object> properties = new HashMap<>(4);
                    properties.put("version", docProperties.getVersion());
                    properties.put("title", docProperties.getTitle());
                    apiDoc.setProperties(properties);

                    LOGGER.info("start up SuperJavaDoc");
                } catch (Exception e) {
                    LOGGER.error("start up SuperJavaDoc error", e);
                }
            });
            thread.start();
        } catch (Exception e) {
            LOGGER.error("start up SuperJavaDoc error", e);
        }
    }

    /**
     * 跳转到SuperJavaDoc接口文档首页
     */
    @GetMapping
    public String index() {
        return "redirect:index.html";
    }

    /**
     * 获取所有文档api
     *
     * @return 系统所有文档接口的数据(json格式)
     */
    @ResponseBody
    @RequestMapping("apis")
    public Object apis() {
        return JsonUtils.toJson(apiDoc);
    }

    /**
     * 重新构建文档
     *
     * @return 文档页面
     */
    @GetMapping("rebuild")
    public String rebuild() {
        init();
        return "redirect:index.html";
    }
}
