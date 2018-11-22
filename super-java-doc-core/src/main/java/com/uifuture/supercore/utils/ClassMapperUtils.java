/**
 * uifuture.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenhx
 * @version ClassMapperUtils.java, v 0.1 2018-09-26 下午 4:41
 */
public class ClassMapperUtils {

    private static Map<String, String> classPath = new HashMap<>();

    public static void put(String name, String path) {
        classPath.put(name, path);
    }

    public static String getPath(String name) {
        return classPath.get(name);
    }
}
