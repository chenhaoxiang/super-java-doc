/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhx
 * @version FileUtils.java, v 0.1 2018-09-26 下午 4:43
 */
public class FileUtils {

    /**
     * 递归获取指定目录下面所有的Java文件,包括子目录中的
     *
     * @param file 文件目录
     * @return 所有java文件
     */
    public static List<String> getAllJavaFiles(File file) {
        if (!file.exists()) {
            return new ArrayList(0);
        }

        if (file.isFile()) {
            if (file.getName().lastIndexOf(".java") > 0) {
                List list = new ArrayList();
                list.add(file.getAbsolutePath());
                return list;
            } else {
                return new ArrayList(0);
            }
        }

        List list = new ArrayList();
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    list.addAll(getAllJavaFiles(f));
                }
            }
        }
        return list;
    }

}
