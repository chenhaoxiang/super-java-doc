/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.model;

import java.util.List;

/**
 * @author chenhx
 * @version FieldInfo.java, v 0.1 2018-09-26 下午 4:37
 */
public class FieldInfo {

    private String name;

    private Class<?> type;

    private String simpleTypeName;

    private String comment;

    /**
     * 是否必填,默认false
     */
    private boolean require;

    private List<FieldInfo> fieldInfos;

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
     * Getter method for property <tt>simpleTypeName</tt>.
     *
     * @return property value of simpleTypeName
     */
    public String getSimpleTypeName() {
        return simpleTypeName;
    }

    /**
     * Setter method for property <tt>simpleTypeName</tt>.
     *
     * @param simpleTypeName value to be assigned to property simpleTypeName
     */
    public void setSimpleTypeName(String simpleTypeName) {
        this.simpleTypeName = simpleTypeName;
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
     * Getter method for property <tt>require</tt>.
     *
     * @return property value of require
     */
    public boolean isRequire() {
        return require;
    }

    /**
     * Setter method for property <tt>require</tt>.
     *
     * @param require value to be assigned to property require
     */
    public void setRequire(boolean require) {
        this.require = require;
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