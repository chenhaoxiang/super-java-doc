/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.model;

import com.uifuture.supercore.tag.DocTag;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenhx
 * @version DocTags.java, v 0.1 2018-09-26 下午 4:37
 */
public class DocTags {

    private List<DocTag> list;

    public DocTags() {
    }

    public DocTags(List<DocTag> list) {
        this.list = list;
    }

    public DocTag getTag(String name) {
        for (int i = 0; i < list.size(); i++) {
            DocTag docTag = list.get(i);
            if (docTag.getTagName().equals(name)) {
                return docTag;
            }
        }
        return null;
    }

    public List<DocTag> getTags(String name) {
        List<DocTag> docTags = new ArrayList<DocTag>();
        for (int i = 0; i < list.size(); i++) {
            DocTag docTag = list.get(i);
            if (docTag.getTagName().equals(name)) {
                docTags.add(docTag);
            }
        }
        return docTags;
    }

    /**
     * Getter method for property <tt>list</tt>.
     *
     * @return property value of list
     */
    public List<DocTag> getList() {
        return list;
    }

    /**
     * Setter method for property <tt>list</tt>.
     *
     * @param list value to be assigned to property list
     */
    public void setList(List<DocTag> list) {
        this.list = list;
    }
}