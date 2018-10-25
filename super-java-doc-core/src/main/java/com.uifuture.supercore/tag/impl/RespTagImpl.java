/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.tag.impl;

import com.uifuture.supercore.tag.DocTag;
import com.uifuture.supercore.utils.Constant;
import org.apache.commons.lang3.StringUtils;

/**
 * 针对@Resp注释的内容封装
 *
 * @author chenhx
 * @version RespTagImpl.java, v 0.1 2018-09-26 下午 4:40
 */
public class RespTagImpl extends DocTag<String> {

    /**
     * 参数名
     */
    private String paramName;

    /**
     * 参数描述
     */
    private String paramDesc;

    /**
     * 是否必填,默认false
     */
    private boolean require;

    /**
     * 类型
     */
    private String paramType;


    public RespTagImpl(String tagName, String paramName, String paramDesc, String paramType, boolean require) {
        super(tagName);
        this.paramName = paramName;
        this.paramDesc = paramDesc;
        this.paramType = paramType;
        this.require = require;
    }

    @Override
    public String getValues() {
        String s = paramName + " " + paramDesc;
        if (StringUtils.isNotBlank(paramType)) {
            s += " " + paramType;
        }
        s += " " + (require ? Constant.YES_ZH : Constant.NOT_ZH);
        return s;
    }


    /**
     * Getter method for property <tt>paramName</tt>.
     *
     * @return property value of paramName
     */
    public String getParamName() {
        return paramName;
    }

    /**
     * Setter method for property <tt>paramName</tt>.
     *
     * @param paramName value to be assigned to property paramName
     */
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    /**
     * Getter method for property <tt>paramDesc</tt>.
     *
     * @return property value of paramDesc
     */
    public String getParamDesc() {
        return paramDesc;
    }

    /**
     * Setter method for property <tt>paramDesc</tt>.
     *
     * @param paramDesc value to be assigned to property paramDesc
     */
    public void setParamDesc(String paramDesc) {
        this.paramDesc = paramDesc;
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
     * Getter method for property <tt>paramType</tt>.
     *
     * @return property value of paramType
     */
    public String getParamType() {
        return paramType;
    }

    /**
     * Setter method for property <tt>paramType</tt>.
     *
     * @param paramType value to be assigned to property paramType
     */
    public void setParamType(String paramType) {
        this.paramType = paramType;
    }
}
