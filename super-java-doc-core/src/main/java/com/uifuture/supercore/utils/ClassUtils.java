/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.utils;

/**
 * @author chenhx
 * @version ClassUtils.java, v 0.1 2018-09-26 下午 4:42
 */
public class ClassUtils {
    /**
     * 将基本类型的转为class类型
     * @param className
     * @return
     */
    public static Class toBae(String className) {
        if ("byte".equals(className)) {
            return byte.class;
        } else if ("short".equals(className)) {
            return short.class;
        } else if ("int".equals(className)) {
            return int.class;
        } else if ("long".equals(className)) {
            return long.class;
        } else if ("float".equals(className)) {
            return float.class;
        } else if ("double".equals(className)) {
            return double.class;
        } else if ("boolean".equals(className)) {
            return boolean.class;
        } else if ("char".equals(className)) {
            return char.class;
        } else {
            return null;
        }
    }

}
