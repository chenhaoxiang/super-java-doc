/**
 * uifuture.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.resolver.parser.converter.impl;

import com.uifuture.supercore.resolver.parser.converter.JavaParserTagConverter;
import com.uifuture.supercore.tag.AbstractDocTag;
import com.uifuture.supercore.tag.impl.DocTagImpl;
import com.uifuture.supercore.utils.CommentUtils;

/**
 * @author chenhx
 * @version DefaultJavaParserTagConverterImpl.java, v 0.1 2018-09-26 下午 5:22
 */
public class DefaultJavaParserTagConverterImpl implements JavaParserTagConverter<String> {

    @Override
    public AbstractDocTag converter(String comment) {
        String tagType = CommentUtils.getTagType(comment);
        String coment = comment.substring(tagType.length()).trim();
        return new DocTagImpl(tagType, coment);
    }
}
