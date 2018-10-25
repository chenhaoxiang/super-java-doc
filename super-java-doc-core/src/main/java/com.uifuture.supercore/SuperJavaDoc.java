/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore;

import com.uifuture.supercore.format.Format;
import com.uifuture.supercore.framework.AbstractFramework;
import com.uifuture.supercore.model.ApiDoc;
import com.uifuture.supercore.model.ApiModule;
import com.uifuture.supercore.resolver.DocTagResolver;
import com.uifuture.supercore.resolver.parser.JavaParserDocTagResolver;
import com.uifuture.supercore.utils.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 主入口,核心处理从这里开始
 *
 * @author chenhx
 * @version SuperMain.java, v 0.1 2018-09-26 下午 5:27
 */
public class SuperJavaDoc {

    private static final String CHARSET = "utf-8";

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 源码路径
     */
    private List<String> srcPaths;

    /**
     * api框架类型
     */
    private AbstractFramework abstractFramework;

    /**
     * 默认的java注释解析器实现
     * <p>
     * 备注:基于sun doc的解析方式已经废弃,若需要请参考v1.0之前的版本
     *
     * @see com.uifuture.supercore.resolver.parser.JavaParserDocTagResolver
     */
    private DocTagResolver docTagResolver = new JavaParserDocTagResolver();

    /**
     * 构建doc对象
     *
     * @param srcPath 源码路径
     */
    public SuperJavaDoc(String srcPath, AbstractFramework abstractFramework) {
        this(Arrays.asList(srcPath), abstractFramework);
    }

    /**
     * 构建SuperJavaDoc对象
     *
     * @param srcPaths 源码路径,支持多个
     */
    public SuperJavaDoc(List<String> srcPaths, AbstractFramework abstractFramework) {
        this.srcPaths = srcPaths;
        this.abstractFramework = abstractFramework;
    }

    /**
     * 解析源码并返回对应的接口数据
     *
     * @return API接口数据
     */
    public ApiDoc resolve() {
        List<String> files = new ArrayList<>();
        for (String srcPath : this.srcPaths) {
            files.addAll(FileUtils.getAllJavaFiles(new File(srcPath)));
        }

        List<ApiModule> apiModules = this.docTagResolver.resolve(files, abstractFramework);

        if (abstractFramework != null) {
            apiModules = abstractFramework.extend(apiModules);
        }
        return new ApiDoc(apiModules);
    }

    /**
     * 构建接口文档
     *
     * @param out    输出位置
     * @param format 文档格式
     */
    public void build(OutputStream out, Format format) {
        this.build(out, format, null);
    }

    /**
     * 构建接口文档
     *
     * @param out        输出位置
     * @param format     文档格式
     * @param properties 文档属性
     */
    public void build(OutputStream out, Format format, Map<String, Object> properties) {
        ApiDoc apiDoc = this.resolve();
        if (properties != null) {
            apiDoc.getProperties().putAll(properties);
        }

        if (apiDoc.getApiModules() != null && out != null && format != null) {
            String s = format.format(apiDoc);
            try {
                IOUtils.write(s, out, CHARSET);
            } catch (IOException e) {
                log.error("接口文档写入文件失败", e);
            } finally {
                IOUtils.closeQuietly(out);
            }
        }
    }

    /**
     * Setter method for property <tt>srcPaths</tt>.
     *
     * @param srcPaths value to be assigned to property srcPaths
     */
    public void setSrcPaths(List<String> srcPaths) {
        this.srcPaths = srcPaths;
    }

    /**
     * Setter method for property <tt>framework</tt>.
     *
     * @param abstractFramework value to be assigned to property framework
     */
    public void setAbstractFramework(AbstractFramework abstractFramework) {
        this.abstractFramework = abstractFramework;
    }

    /**
     * Setter method for property <tt>docTagResolver</tt>.
     *
     * @param docTagResolver value to be assigned to property docTagResolver
     */
    public void setDocTagResolver(DocTagResolver docTagResolver) {
        this.docTagResolver = docTagResolver;
    }
}