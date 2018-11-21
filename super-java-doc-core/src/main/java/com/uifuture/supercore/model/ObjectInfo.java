/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhx
 * @version ObjectInfo.java, v 0.1 2018-09-26 下午 4:40
 */
public class ObjectInfo {

    private String name;

    /**
     * 源码在哪个类
     */
    private Class<?> type;

    private String comment;

    private List<FieldInfo> fieldInfos = new ArrayList<>();

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>type</tt>.
     *
     * @return property value of type
     */
    public Class<?> getType() {
        return type;
    }

    /**
     * Setter method for property <tt>type</tt>.
     *
     * @param type value to be assigned to property type
     */
    public void setType(Class<?> type) {
        this.type = type;
    }

    /**
     * Getter method for property <tt>comment</tt>.
     *
     * @return property value of comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter method for property <tt>comment</tt>.
     *
     * @param comment value to be assigned to property comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Getter method for property <tt>fieldInfos</tt>.
     *
     * @return property value of fieldInfos
     */
    public List<FieldInfo> getFieldInfos() {
        return fieldInfos;
    }

    /**
     * Setter method for property <tt>fieldInfos</tt>.
     *
     * @param fieldInfos value to be assigned to property fieldInfos
     */
    public void setFieldInfos(List<FieldInfo> fieldInfos) {
        this.fieldInfos = fieldInfos;
    }
}
