/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.lang.reflect.Method;

/**
 * 接口信息,一个接口类里面会有多个接口,每个接口都抽象成ApiAction
 *
 * @author chenhx
 * @version ApiAction.java, v 0.1 2018-09-26 下午 4:32
 */
public class ApiAction {
    /**
     * 展示用的标题
     */
    private String title;

    /**
     * 接口方法名称
     */
    private String name;

    /**
     * 接口方法
     */
    @JsonIgnore
    private transient Method method;

    /**
     * 接口的描述
     */
    private String comment;

    /**
     * 方法上标注的注解
     */
    private DocTags docTags;

    /**
     * Getter method for property <tt>title</tt>.
     *
     * @return property value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     *
     * @param title value to be assigned to property title
     */
    public void setTitle(String title) {
        this.title = title;
    }

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
     * Getter method for property <tt>method</tt>.
     *
     * @return property value of method
     */
    public Method getMethod() {
        return method;
    }

    /**
     * Setter method for property <tt>method</tt>.
     *
     * @param method value to be assigned to property method
     */
    public void setMethod(Method method) {
        this.method = method;
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
     * Getter method for property <tt>docTags</tt>.
     *
     * @return property value of docTags
     */
    public DocTags getDocTags() {
        return docTags;
    }

    /**
     * Setter method for property <tt>docTags</tt>.
     *
     * @param docTags value to be assigned to property docTags
     */
    public void setDocTags(DocTags docTags) {
        this.docTags = docTags;
    }
}