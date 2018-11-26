
# superJavaDoc 快速文档构建框架

- **基于Java注释生成接口文档**
- **注释支持扩展**
- **接口框架支持扩展**
- **默认支持markdown和离线/在线html等格式的文档**
- **默认支持spring mvc规范**
- **默认支持spring-boot直接内嵌启动**

## 基于SpringBoot在线直接使用

### 1.引入Maven依赖
```xml
<!--加入maven依赖-->
<dependency>
    <groupId>com.uifuture</groupId>
    <artifactId>super-java-doc-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```

### 2.增加EnableDoc注解
在Application类上加上EnableDoc注解  
```java
@EnableDoc //<--- 加上此注解以便启用XDOC在线HTML文档
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
```

### 3.1 properties配置文件
```
#在application.properties配置项目源码的位置,直接在项目里启动时,如果是单模块的maven项目,默认可以不配置
#是否启动XDoc,默认是true,因为可以不填
doc.enable=true 
#源码路径,多个时用英文逗号隔开，super-java-doc-test为项目模块名称。单模块项目可以将super-java-doc-test/去掉，直接使用src/main/java 
doc.sourcePath=super-java-doc-test/src/main/java  
#用于配置文档页面标题 
doc.title=在线接口文档  
#标识接口文档的版本号
doc.version=1.0   
```
### 3.2 yml配置文件
```yml
doc:
  enable: true #是否启动superJavaDoc,默认是true,因为可以不填
  title: 在线接口文档 #用于配置文档页面标题
  sourcePath: super-java-doc-test/src/main/java #源码路径,多个时用英文逗号隔开
  version: 1.0 #标识接口文档的版本号
```

### 4 使用
**以上配置就都写好了**

**跟着随便写几个Controller作为Demo接口,便于直接浏览生成效果:**
```java

/**
 * BlogsController
 *
 * @author chenhaoxiang
 * @date 2018-09-12 18:23:40
 */
@Controller
@RequestMapping("admin/blogs")
public class BlogsController {
    @Resource
    private BlogsService blogsService;

    /**
     * 添加Blogs
     *
     * @param blogs 对象
     * @return ResultModel统一响应结果
     */
    @PostMapping("add")
    @ResponseBody
    public ResultModel add(Blogs blogs) {
        blogsService.insert(blogs);
        return ResultModel.success();
    }

    /**
     * 根据ID进行删除
     *
     * @param id 主键
     * @return ResultModel统一响应结果
     */
    @PostMapping("delete")
    @ResponseBody
    public ResultModel delete(@RequestParam Integer id) {
        blogsService.deleteById(id);
        return ResultModel.success();
    }

    /**
     * 根据ID进行修改Blogs对象
     *
     * @param blogs 对象中必须有ID主键
     * @return ResultModel统一响应结果
     */
    @PostMapping("update")
    @ResponseBody
    public ResultModel update(Blogs blogs) {
        blogsService.updateById(blogs);
        return ResultModel.success();
    }

    /**
     * 查询详情
     *
     * @param id 主键
     * @return ResultModel统一响应结果
     */
    @PostMapping("detail")
    @ResponseBody
    public ResultModel detail(@RequestParam Integer id) {
        Blogs blogs = blogsService.selectById(id);
        return ResultModel.success(blogs);
    }

    /**
     * 分页查询
     *
     * @param page 当前页 默认0 不分页
     * @param size 每页的条数 默认为0 查询所有
     * @return ResultModel统一响应结果
     */
    @PostMapping("list")
    @ResponseBody
    public ResultModel list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Blogs> list = blogsService.selectAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultModel.success(pageInfo);
    }

}

```

**直接启动项目, 敲入地址: http://localhost:8080/superJavaDoc/index.html**  

如下两个图，为部分展示内容。  
![http://blogimg.chenhaoxiang.cn/18-11-26/76692396.jpg](http://blogimg.chenhaoxiang.cn/18-11-26/76692396.jpg)

![http://blogimg.chenhaoxiang.cn/18-11-26/6863840.jpg](http://blogimg.chenhaoxiang.cn/18-11-26/6863840.jpg)

### 2.生成离线文档
**支持html:**
```java
@Test
public void buildMarkdown() {
    //生成离线的Markdown格式的接口文档
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    String rootDir = System.getProperty("user.dir");
    SuperJavaDoc xDoc = new SuperJavaDoc(rootDir + "/src/main/java/com/uifuture", new SpringWebFramework());
    xDoc.build(out, new MarkdownFormat());

    System.out.println(out.toString());
}
```

**支持markdown:**
```java
@Test
public void buildHtml() throws Exception {
    //生成离线的HTML格式的接口文档
    String userDir = System.getProperty("user.dir");
    FileOutputStream out = new FileOutputStream(new File(userDir, "api.html"));
    SuperJavaDoc xDoc = new SuperJavaDoc(userDir + "/src/main/java/com/uifuture", new SpringWebFramework());
    xDoc.build(out, new HtmlForamt());
}
```

**注意:生产环境不推荐开启此文，可能会消耗性能，所以在生成环境下，配置文件中配置如下即可:**
```txt
doc.enable=false
```


本项目参考自 https://gitee.com/treeleaf/xDoc 项目。  
在此感谢xDoc的开发者。    
本项目修复了xDoc其中几个Bugs。  
将持续维护。  
欢迎有志之士一起开发。提Issues。  
