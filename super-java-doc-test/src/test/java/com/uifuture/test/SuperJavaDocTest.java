/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.test;

import com.uifuture.supercore.SuperJavaDoc;
import com.uifuture.superspring.format.HtmlForamt;
import com.uifuture.superspring.format.MarkdownFormat;
import com.uifuture.superspring.framework.SpringWebFramework;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * @author chenhx
 * @version SuperJavaDocTest.java, v 0.1 2018-09-26 下午 6:41
 */
public class SuperJavaDocTest {

    @Test
    public void buildMarkdown() {
        //生成离线的Markdown格式的接口文档
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        String rootDir = System.getProperty("user.dir");
        SuperJavaDoc xDoc = new SuperJavaDoc(rootDir + "/src/main/java/com/uifuture", new SpringWebFramework());
        xDoc.build(out, new MarkdownFormat());

        System.out.println(out.toString());
    }

    @Test
    public void buildHtml() throws Exception {
        //生成离线的HTML格式的接口文档
        String userDir = System.getProperty("user.dir");
        FileOutputStream out = new FileOutputStream(new File(userDir, "api.html"));
        SuperJavaDoc xDoc = new SuperJavaDoc(userDir + "/src/main/java/com/uifuture", new SpringWebFramework());
        xDoc.build(out, new HtmlForamt());
    }

}