/**
 * uifuture.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.superspring.framework;


import com.uifuture.supercore.model.ApiAction;
import com.uifuture.supercore.model.ObjectInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhx
 * @version SpringApiAction.java, v 0.1 2018-09-26 下午 5:31
 */

public class SpringApiAction extends ApiAction {

    /**
     * 访问的uri地址
     */
    private List<String> uris;

    /**
     * 允许的访问方法:POST,GET,DELETE,PUT等, 如果没有,则无限制
     */
    private List<String> methods;

    /**
     * 入参
     */
    private List<ParamInfo> param = new ArrayList<>(0);

    /**
     * 返回对象
     */
    private ObjectInfo returnObj;

    /**
     * 出参
     */
    private List<ParamInfo> respParam = new ArrayList<>(0);

    /**
     * 返回描述
     */
    private String returnDesc;

    /**
     * 返回的数据
     */
    private String respbody;

    /**
     * 是否返回json
     */
    private boolean json;


    /**
     * Getter method for property <tt>uris</tt>.
     *
     * @return property value of uris
     */
    public List<String> getUris() {
        return uris;
    }

    /**
     * Setter method for property <tt>uris</tt>.
     *
     * @param uris value to be assigned to property uris
     */
    public void setUris(List<String> uris) {
        this.uris = uris;
    }

    /**
     * Getter method for property <tt>methods</tt>.
     *
     * @return property value of methods
     */
    public List<String> getMethods() {
        return methods;
    }

    /**
     * Setter method for property <tt>methods</tt>.
     *
     * @param methods value to be assigned to property methods
     */
    public void setMethods(List<String> methods) {
        this.methods = methods;
    }

    /**
     * Getter method for property <tt>param</tt>.
     *
     * @return property value of param
     */
    public List<ParamInfo> getParam() {
        return param;
    }

    /**
     * Setter method for property <tt>param</tt>.
     *
     * @param param value to be assigned to property param
     */
    public void setParam(List<ParamInfo> param) {
        this.param = param;
    }

    /**
     * Getter method for property <tt>returnObj</tt>.
     *
     * @return property value of returnObj
     */
    public ObjectInfo getReturnObj() {
        return returnObj;
    }

    /**
     * Setter method for property <tt>returnObj</tt>.
     *
     * @param returnObj value to be assigned to property returnObj
     */
    public void setReturnObj(ObjectInfo returnObj) {
        this.returnObj = returnObj;
    }

    /**
     * Getter method for property <tt>respParam</tt>.
     *
     * @return property value of respParam
     */
    public List<ParamInfo> getRespParam() {
        return respParam;
    }

    /**
     * Setter method for property <tt>respParam</tt>.
     *
     * @param respParam value to be assigned to property respParam
     */
    public void setRespParam(List<ParamInfo> respParam) {
        this.respParam = respParam;
    }

    /**
     * Getter method for property <tt>returnDesc</tt>.
     *
     * @return property value of returnDesc
     */
    public String getReturnDesc() {
        return returnDesc;
    }

    /**
     * Setter method for property <tt>returnDesc</tt>.
     *
     * @param returnDesc value to be assigned to property returnDesc
     */
    public void setReturnDesc(String returnDesc) {
        this.returnDesc = returnDesc;
    }

    /**
     * Getter method for property <tt>respbody</tt>.
     *
     * @return property value of respbody
     */
    public String getRespbody() {
        return respbody;
    }

    /**
     * Setter method for property <tt>respbody</tt>.
     *
     * @param respbody value to be assigned to property respbody
     */
    public void setRespbody(String respbody) {
        this.respbody = respbody;
    }

    /**
     * Getter method for property <tt>json</tt>.
     *
     * @return property value of json
     */
    public boolean isJson() {
        return json;
    }

    /**
     * Setter method for property <tt>json</tt>.
     *
     * @param json value to be assigned to property json
     */
    public void setJson(boolean json) {
        this.json = json;
    }
}
