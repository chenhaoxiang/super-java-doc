/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.model;

import com.uifuture.supercore.tag.AbstractDocTag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhx
 * @version DocTags.java, v 0.1 2018-09-26 下午 4:37
 */
public class DocTags {

    private List<AbstractDocTag> list;

    public DocTags() {
    }

    public DocTags(List<AbstractDocTag> list) {
        this.list = list;
    }

    public AbstractDocTag getTag(String name) {
        for (int i = 0; i < list.size(); i++) {
            AbstractDocTag abstractDocTag = list.get(i);
            if (abstractDocTag.getTagName().equals(name)) {
                return abstractDocTag;
            }
        }
        return null;
    }

    public List<AbstractDocTag> getTags(String name) {
        List<AbstractDocTag> abstractDocTags = new ArrayList<AbstractDocTag>();
        for (int i = 0; i < list.size(); i++) {
            AbstractDocTag abstractDocTag = list.get(i);
            if (abstractDocTag.getTagName().equals(name)) {
                abstractDocTags.add(abstractDocTag);
            }
        }
        return abstractDocTags;
    }

    /**
     * Getter method for property <tt>list</tt>.
     *
     * @return property value of list
     */
    public List<AbstractDocTag> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     *
     * @param list value to be assigned to property list
     */
    public void setList(List<AbstractDocTag> list) {
        this.list = list;
    }
}