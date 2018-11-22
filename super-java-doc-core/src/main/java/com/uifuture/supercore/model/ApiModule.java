/**
 * uifuture.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.LinkedList;
import java.util.List;

/**
 * 接口业务模块,一个接口类为一个模块
 *
 * @author chenhx
 * @version ApiModule.java, v 0.1 2018-09-26 下午 4:32
 */
public class ApiModule {
    /**
     * 源码在哪个类
     */
    @JsonIgnore
    private transient Class<?> type;

    /**
     * 业务模块的描述
     */
    private String comment;

    /**
     * 此业务模块下有哪些接口
     */
    private List<ApiAction> apiActions = new LinkedList<>();

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
     * Getter method for property <tt>apiActions</tt>.
     *
     * @return property value of apiActions
     */
    public List<ApiAction> getApiActions() {
        return apiActions;
    }

    /**
     * Setter method for property <tt>apiActions</tt>.
     *
     * @param apiActions value to be assigned to property apiActions
     */
    public void setApiActions(List<ApiAction> apiActions) {
        this.apiActions = apiActions;
    }
}