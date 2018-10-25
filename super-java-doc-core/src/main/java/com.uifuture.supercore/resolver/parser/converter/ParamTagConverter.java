/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.resolver.parser.converter;

import com.uifuture.supercore.resolver.parser.converter.impl.DefaultJavaParserTagConverterImpl;
import com.uifuture.supercore.tag.AbstractDocTag;
import com.uifuture.supercore.tag.impl.ParamTagImpl;
import com.uifuture.supercore.utils.Constant;

/**
 * @author chenhx
 * @version ParamTagConverter.java, v 0.1 2018-09-26 下午 5:24
 */

public class ParamTagConverter extends DefaultJavaParserTagConverterImpl {

    @Override
    public AbstractDocTag converter(String comment) {
        AbstractDocTag abstractDocTag = super.converter(comment);
        String values = (String) abstractDocTag.getValues();
        String[] array = values.split("[ \t]+");
        String paramName = null;
        String paramDesc = "";
        String paramType = "String";
        boolean require = false;
        //解析 "user :username 用户名|必填" 这种注释内容
        //或者 "username 用户名|必填" 这种注释内容
        //或者 "username 用户名|String|必填" 这种注释内容
        //上面的"必填"两个字也可以换成英文的"Y"

        if (array.length > 0) {
            //先将第一个认为是参数名称
            paramName = array[0];
            if (array.length > 1) {

                int start = 1;
                if (array[1].startsWith(":") && array[1].length() > 1) {
                    //获取 :username这种类型的参数名称
                    paramName = array[1].substring(1);
                    start = 2;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = start; i < array.length; i++) {
                    sb.append(array[i]).append(' ');
                }
                paramDesc = sb.toString();
            }
        }

        String[] descs = paramDesc.split("\\|");
        if (descs.length > 0) {
            paramDesc = descs[0];
            if (descs.length > 2) {
                paramType = descs[1];
                String requireString = descs[descs.length - 1].trim();
                require = Constant.YES_ZH.equals(requireString) || Constant.YES_EN.equalsIgnoreCase(requireString);
            } else if (descs.length == 2) {
                String requireString = descs[1].trim();
                require = Constant.YES_ZH.equals(requireString) || Constant.YES_EN.equalsIgnoreCase(requireString);

                //如果最后一个不是是否必填的描述,则认为是类型描述
                boolean notRequired = !require && !(Constant.NOT_EN.equalsIgnoreCase(requireString) || Constant.NOT_ZH.equals(requireString));
                if (notRequired) {
                    paramType = requireString;
                }
            }
        }

        return new ParamTagImpl(abstractDocTag.getTagName(), paramName, paramDesc, paramType, require);
    }
}
