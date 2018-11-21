/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.resolver.parser.converter;

import com.uifuture.supercore.tag.AbstractDocTag;
import com.uifuture.supercore.tag.impl.ParamTagImpl;
import com.uifuture.supercore.tag.impl.RespTagImpl;

/**
 * @author chenhx
 * @version RespTagConverter.java, v 0.1 2018-09-26 下午 5:24
 */

public class RespTagConverter extends ParamTagConverter {

    @Override
    public AbstractDocTag converter(String comment) {
        ParamTagImpl paramTag = (ParamTagImpl) super.converter(comment);
        RespTagImpl respTag = new RespTagImpl(paramTag.getTagName(), paramTag.getParamName(), paramTag.getParamDesc(),
                paramTag.getParamType(), paramTag.isRequire());
        return respTag;
    }
}
