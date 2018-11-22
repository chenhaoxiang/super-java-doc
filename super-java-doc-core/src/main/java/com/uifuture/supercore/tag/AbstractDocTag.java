/**
 * uifuture.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.tag;

/**
 * 针对注释标签
 *
 * @author chenhx
 * @version DocTag.java, v 0.1 2018-09-26 下午 4:38
 */
public abstract class AbstractDocTag<T> {

    /**
     * 标签名称
     */
    private String tagName;

    public AbstractDocTag(String tagName) {
        this.tagName = tagName;
    }

    public abstract T getValues();

    /**
     * Getter method for property <tt>tagName</tt>.
     *
     * @return property value of tagName
     */
    public String getTagName() {
        return tagName;
    }

}
