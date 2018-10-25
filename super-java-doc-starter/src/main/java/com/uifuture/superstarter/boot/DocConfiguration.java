/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.superstarter.boot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * @author chenhx
 * @version DocConfiguration.java, v 0.1 2018-09-26 下午 6:10
 */
public class DocConfiguration {

    public DocConfiguration() {
    }

    @Bean
    @ConditionalOnProperty(prefix = "doc", name = "enable", matchIfMissing = true)
    public DocController docController() {
        return new DocController();
    }
}
