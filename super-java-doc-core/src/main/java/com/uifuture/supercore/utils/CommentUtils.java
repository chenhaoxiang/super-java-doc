/**
 * uifuture.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chenhx
 * @version CommentUtils.java, v 0.1 2018-09-26 下午 4:42
 */
public class CommentUtils {
    private final static Pattern COMPILE = Pattern.compile("^@[\\w]+[\\t ]");

    /**
     * 获取注释的类型
     *
     * @param coment
     * @return @see @param @resp @return等
     */
    public static String getTagType(String coment) {
        Matcher m = COMPILE.matcher(coment);
        if (m.find()) {
            return m.group().trim();
        } else {
            return null;
        }
    }

    /**
     * 解析基本的文本注释
     *
     * @param coment
     * @return
     */
    public static String parseCommentText(String coment) {
        List<String> coments = asCommentList(coment);
        for (String s : coments) {
            if (!s.startsWith("@")) {
                return s;
            }
        }
        return "";
    }

    /**
     * 将注释转为多行文本
     *
     * @param coment
     * @return
     */
    public static List<String> asCommentList(String coment) {
        coment = coment.replaceAll("\\*", "").trim();
        String[] array = coment.split("\n");
        List<String> comments = new ArrayList(array.length);
        int index = 0;
        StringBuilder sb = new StringBuilder();
        for (; index < array.length; index++) {
            String c = array[index].trim();

            if (StringUtils.isBlank(c)) {
                continue;
            }

            String tagType = CommentUtils.getTagType(c);
            if (StringUtils.isBlank(tagType)) {
                sb.append(c);
                sb.append("\n");
            } else {
                break;
            }
        }

        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            comments.add(sb.toString());
        }

        for (int i = index; i < array.length; i++) {
            String c = array[i].trim();
            if (StringUtils.isNotBlank(c)) {
                comments.add(c);
            }
        }
        return comments;
    }
}
