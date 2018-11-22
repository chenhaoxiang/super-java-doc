/**
 * uifuture.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.resolver.parser.converter;

import com.uifuture.supercore.resolver.parser.converter.impl.DefaultJavaParserTagConverterImpl;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenhx
 * @version JavaParserTagConverterManager.java, v 0.1 2018-09-26 下午 5:23
 */

public class JavaParserTagConverterManager {

    private static Map<String, JavaParserTagConverter> registrator = new HashMap<>();

    private static JavaParserTagConverter defaultTagConverter = new DefaultJavaParserTagConverterImpl();

    static {
        registerConverter("@param", new ParamTagConverter());
        registerConverter("@see", new SeeTagConverter());
        registerConverter("@resp", new RespTagConverter());
    }

    public static void registerConverter(String tagName, JavaParserTagConverter tagConverter) {
        registrator.put(tagName, tagConverter);
    }

    /**
     * 获取标签转换器,如果没有特殊定制的,则返回默认的转换器DefaultJavaParserTagConverterImpl
     *
     * @param tagName 要转换的标签名称
     * @return 匹配到的标签转换器
     */
    public static JavaParserTagConverter getConverter(String tagName) {
        for (Map.Entry<String, JavaParserTagConverter> entry : registrator.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(tagName)) {
                return entry.getValue();
            }
        }
        return defaultTagConverter;
    }
}
