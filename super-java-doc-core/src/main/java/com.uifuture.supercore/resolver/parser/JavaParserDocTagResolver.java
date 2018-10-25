/**
 * fshows.com
 * Copyright (C) 2013-2018 All Rights Reserved.
 */
package com.uifuture.supercore.resolver.parser;


import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.uifuture.supercore.framework.Framework;
import com.uifuture.supercore.model.ApiAction;
import com.uifuture.supercore.model.ApiModule;
import com.uifuture.supercore.model.DocTags;
import com.uifuture.supercore.resolver.DocTagResolver;
import com.uifuture.supercore.resolver.IgnoreApi;
import com.uifuture.supercore.resolver.parser.converter.JavaParserTagConverter;
import com.uifuture.supercore.resolver.parser.converter.JavaParserTagConverterManager;
import com.uifuture.supercore.tag.DocTag;
import com.uifuture.supercore.utils.ClassMapperUtils;
import com.uifuture.supercore.utils.CommentUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 基于开源JavaParser实现的解析
 *
 * @author chenhx
 * @version JavaParserDocTagResolver.java, v 0.1 2018-09-26 下午 4:58
 */

public class JavaParserDocTagResolver implements DocTagResolver {

    private Logger log = LoggerFactory.getLogger(JavaParserDocTagResolver.class);

    /**
     * 获取指定方法的所有入参类型,便于反射
     *
     * @param declaration
     * @return
     */
    private static Method parseToMenthod(Class type, MethodDeclaration declaration) {
        List<Parameter> parameters = declaration.getParameters();
        parameters = parameters == null ? new ArrayList<Parameter>(0) : parameters;
        Method[] methods = type.getDeclaredMethods();
        for (Method m : methods) {
            if (!m.getName().equals(declaration.getNameAsString())) {
                continue;
            }
            if (m.getParameterTypes().length != parameters.size()) {
                continue;
            }

            boolean b = true;

            for (int j = 0; j < m.getParameterTypes().length; j++) {
                Class<?> paramClass = m.getParameterTypes()[j];
                com.github.javaparser.ast.type.Type ptype = parameters.get(j).getType();
                if (ptype == null) {
                    continue;
                }
                String paranTypeName = ptype.toString();
                int index = paranTypeName.lastIndexOf(".");
                if (index > 0) {
                    paranTypeName = paranTypeName.substring(index + 1);
                }
                //处理泛型
                index = paranTypeName.indexOf("<");
                if (index > 0) {
                    paranTypeName = paranTypeName.substring(0, index);
                }

                if (!paramClass.getSimpleName().equals(paranTypeName)) {
                    b = false;
                    break;
                }
            }
            if (b) {
                return m;
            }
        }
        return null;
    }

    @Override
    public List<ApiModule> resolve(List<String> files, Framework framework) {
        //缓存文件
        for (String file : files) {
            try (FileInputStream in = new FileInputStream(file)) {
                CompilationUnit cu = JavaParser.parse(in);
                if (cu.getTypes().size() <= 0) {
                    continue;
                }

                TypeDeclaration typeDeclaration = cu.getTypes().get(0);
                final Class<?> moduleType = Class.forName(cu.getPackageDeclaration().get().getNameAsString() + "." + typeDeclaration.getNameAsString());
                IgnoreApi ignoreApi = moduleType.getAnnotation(IgnoreApi.class);
                if (ignoreApi == null) {
                    //缓存路径
                    ClassMapperUtils.put(moduleType.getName(), file);
                    //缓存路径
                    ClassMapperUtils.put(moduleType.getSimpleName(), file);
                }
            } catch (Exception e) {
                log.warn("读取文件失败:{}, {}", file, e.getMessage());
            }
        }

        List<ApiModule> apiModules = new LinkedList<>();

        for (String file : files) {
            try (FileInputStream in = new FileInputStream(file)) {

                CompilationUnit cu = JavaParser.parse(in);
                if (cu.getTypes().size() <= 0) {
                    continue;
                }

                TypeDeclaration typeDeclaration = cu.getTypes().get(0);
                //获取到类对象
                final Class<?> moduleType = Class.forName(cu.getPackageDeclaration().get().getNameAsString() + "." + typeDeclaration.getNameAsString());


                if (!framework.support(moduleType)) {
                    continue;
                }

                //跳过生成文档注解
                IgnoreApi ignoreApi = moduleType.getAnnotation(IgnoreApi.class);
                if (ignoreApi != null) {
                    continue;
                }

                final ApiModule apiModule = new ApiModule();
                apiModule.setType(moduleType);
                if (typeDeclaration.getComment().isPresent()) {
                    String commentText = CommentUtils.parseCommentText(typeDeclaration.getComment().get().getContent());
                    commentText = commentText.split("\n")[0].split("\r")[0];
                    apiModule.setComment(commentText);
                }

                new VoidVisitorAdapter<Void>() {
                    @Override
                    public void visit(MethodDeclaration m, Void arg) {
                        Method method = parseToMenthod(moduleType, m);
                        if (method == null) {
                            log.warn("查找不到方法:{}.{}", moduleType.getSimpleName(), m.getNameAsString());
                            return;
                        }

                        IgnoreApi ignoreApi = method.getAnnotation(IgnoreApi.class);
                        if (ignoreApi != null || !m.getComment().isPresent()) {
                            return;
                        }

                        List<String> comments = CommentUtils.asCommentList(StringUtils.defaultIfBlank(m.getComment().get().getContent(), ""));
                        List<DocTag> docTagList = new ArrayList<>(comments.size());

                        for (int i = 0; i < comments.size(); i++) {
                            String c = comments.get(i);
                            String tagType = CommentUtils.getTagType(c);
                            if (StringUtils.isBlank(tagType)) {
                                continue;
                            }
                            JavaParserTagConverter converter = JavaParserTagConverterManager.getConverter(tagType);
                            DocTag docTag = converter.converter(c);
                            if (docTag != null) {
                                docTagList.add(docTag);
                            } else {
                                log.warn("识别不了:{}", c);
                            }
                        }

                        DocTags docTags = new DocTags(docTagList);
                        ApiAction apiAction = new ApiAction();
                        if (m.getComment().isPresent()) {
                            apiAction.setComment(CommentUtils.parseCommentText(m.getComment().get().getContent()));
                        }
                        apiAction.setName(m.getNameAsString());
                        apiAction.setDocTags(docTags);
                        apiAction.setMethod(method);
                        apiModule.getApiActions().add(apiAction);

                        super.visit(m, arg);
                    }
                }.visit(cu, null);

                apiModules.add(apiModule);

            } catch (Exception e) {
                log.warn("解析{}失败:{}", file, e.getMessage());
                continue;
            }
        }
        return apiModules;
    }
}
