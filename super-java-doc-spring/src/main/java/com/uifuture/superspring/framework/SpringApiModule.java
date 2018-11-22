/**
 * uifuture.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.superspring.framework;

import com.uifuture.supercore.model.ApiModule;

import java.util.List;

/**
 * @author chenhx
 * @version SpringApiModule.java, v 0.1 2018-09-26 下午 5:31
 */

public class SpringApiModule extends ApiModule {

    /**
     * 业务模块首地址
     */
    private List<String> uris;

    /**
     * 接口限制必须采用访问方式
     */
    private List<String> methods;

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
