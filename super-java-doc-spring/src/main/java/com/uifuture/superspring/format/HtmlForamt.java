/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.superspring.format;

import com.uifuture.supercore.format.Format;
import com.uifuture.supercore.model.ApiDoc;
import com.uifuture.supercore.utils.JsonUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chenhx
 * @version HtmlForamt.java, v 0.1 2018-09-26 下午 5:32
 */

public class HtmlForamt implements Format {

    @Override
    public String format(ApiDoc apiDoc) {
        InputStream in = HtmlForamt.class.getResourceAsStream("html.vm");
        if (in != null) {
            try {
                String s = IOUtils.toString(in, "utf-8");

                Map<String, Object> model = new HashMap<>();
                model.put("title", StringUtils.defaultString((String) apiDoc.getProperties().get("title"), "接口文档"));
                model.put("apiModules", apiDoc.getApiModules());
                //生成json数据
                return s.replace("_apis_json", JsonUtils.toJson(model));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                IOUtils.closeQuietly(in);
            }
        }
        return "";
    }
}
