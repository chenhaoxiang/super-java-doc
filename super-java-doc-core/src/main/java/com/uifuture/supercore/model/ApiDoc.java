/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenhx
 * @version ApiDoc.java, v 0.1 2018-09-26 下午 4:31
 */
public class ApiDoc {

    /**
     * 附带的属性
     */
    private Map<String, Object> properties = new HashMap<>();

    /**
     * 所有API模块
     */
    private List<com.uifuture.supercore.model.ApiModule> apiModules;

    public ApiDoc(List<com.uifuture.supercore.model.ApiModule> apiModules) {
        this.apiModules = apiModules;
    }

    public ApiDoc(Map<String, Object> properties, List<com.uifuture.supercore.model.ApiModule> apiModules) {
        this.properties = properties;
        this.apiModules = apiModules;
    }

    /**
     * Getter method for property <tt>properties</tt>.
     *
     * @return property value of properties
     */
    public Map<String, Object> getProperties() {
        return properties;
    }

    /**
     * Setter method for property <tt>properties</tt>.
     *
     * @param properties value to be assigned to property properties
     */
    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    /**
     * Getter method for property <tt>apiModules</tt>.
     *
     * @return property value of apiModules
     */
    public List<com.uifuture.supercore.model.ApiModule> getApiModules() {
        return apiModules;
    }

    /**
     * Setter method for property <tt>apiModules</tt>.
     *
     * @param apiModules value to be assigned to property apiModules
     */
    public void setApiModules(List<com.uifuture.supercore.model.ApiModule> apiModules) {
        this.apiModules = apiModules;
    }
}