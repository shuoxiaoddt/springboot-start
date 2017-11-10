# spring-boot
##一、全局捕获异常
新建类`GlobalDefaultExceptionHandler`
在class中加入`@ControllerAdvice`
在方法上注解上`@ExceptionHandler(value = Exception.class)`
##二、自定义静态资源访问
springboot默认会访问classpath下 /static (or /public or /resources or /META-INF/resources) 这些路径
如果需要自定义,则可以手动添加
##三、配置Druid监控
    1)导入Durid包
    2)自定义DruidStatViewServlet
    3)自定义DruidStatFilter
    4)在启动类中加上@ServletComponentScan注解
    5) http://127.0.0.1:8080/druid/index.html可以看到数据源以及sql统计
##四、通过实现ApplicationContextAware在普通类中获取容器中的bean
    见com.uway.springboot.boot.util.BeanUtil
##五、过滤器,监听器,拦截器
只有经过DispatcherServlet 的请求，才会走拦截器链，我们自定义的Servlet 请求是不会被拦截的
##六、SpringBoot启动时加载数据ComandLineRunner和ApplicationRunner
共同点：其一执行时机都是在容器启动完成的时候进行执行；其二这两个接口中都有一个run()方法；
不同点：ApplicationRunner中run方法的参数为ApplicationArguments，而CommandLineRunner接口中run方法的参数为String数组。
##七 环境变量的读取和属性对象的绑定
凡是被Spring管理的类，实现接口EnvironmentAware 重写方法setEnvironment 可以在工程启动时
获取系统环境变量和application配置文件中的变量
##八、Springboot banner设置
重写接口Banner实现,在启动方法中设置自己写的banner
##九、SpringBoot多文件上传
1.使用MultipartFile类可以实现单文件上传功能 见FileController.java
同时可以设置上传文件的属性信息 见CustomConfiguration.java
2.多文件上传可以参见FileController.java
##十、监控和管理生产环境:spring-boot-actuator模块
Starter for using Spring Boot’s Actuator which provides production ready features to help you monitor and manage your application
Spring boot约定大于配置,所以在倒入这个包以后可以通过以下路径查看应用中的各个信息
比如：
GET-/application/autoconfig-查看自动配置的使用情况，该报告展示所有auto-configuration候选者及它们被应用或未被应用的原因-true(是否需要鉴权)
GET-/application/beans-显示一个应用中所有Spring Beans的完整列表-true(是否需要鉴权)
GET-/application/env-查看所有环境变量-true
GET-/application/health-查看应用健康指标-false
等等信息,可以从官网上看到,不过Springboot默认只开启了
/application,/application/status,/application/info这几项配置,如果需要开启更多配置,则可以在application.properties中使用
endpoints.beans.enabled=true 开启(这是开启beans的链接)
endpoints.default.enabled=true可以开启默认的三个监控
##十一、关于JPA多对多查询
对于属性是List的,Herbnate默认使用懒加载,可以在@ManyToMany注解中加上
fetch=FetchType.EARGE,取消懒加载,就能直接获取List的数据
##十二、Spring框架的主要Hook
Spring框架有三个主要的Hook(钩子,回调)类
`org.springframework.context.ApplicationContextAware `,他的setApplicationContext方法是第一个被调用的
`org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor` ,他的postProcessBeanDefinitionRegistry 和 postProcessBeanFactory方法是第二、第三哥被个被调用的
它们在Bean初始化创建之前启动，如果Spring的bean需要的其他第三方中的组件，我们在这里将其注入给Spring。
`org.springframework.context.ApplicationListener `,用于在初始化完成后做一些事情,当Spring所有XML或元注解的Bean都启动被创建成功了，这时会调用它的唯一方法onApplicationEvent。
##十二、验证Validate

可以使用`ValidationMessages_zh_CN.properties`自定义国际化的返回信息

```
@PostMapping("/validate/useradd")
public Map<String,Object> userAdd(@Valid UserInfo userInfo, BindingResult result){
    Map<String,Object> resultMap = new HashMap<>();
    if(result.hasErrors()){
        resultMap.put("message","error");
        resultMap.put("data",result.getAllErrors());
        return resultMap;
    }
    resultMap.put("message","success");
    resultMap.put("data",userInfo);
    return resultMap;
}
```



##十三、SLF4J(Simple Logging Facade For Java)
SLF4J配置使用logback.xml,效率比log4j高
##十四、Spring Boot mybatis
    <dependency>
        <groupId>org.mybatis.spring.boot</groupId>
        <artifactId>mybatis-spring-boot-starter</artifactId>
        <version>1.1.1</version>
    </dependency>
启动类中加上@MapperScan("com.*.*.mapper")注解,可以扫面mapper文件
分页插件PageHelper
##十五、Spring Boot AOP
与纯粹的Spring Framework不同的是Spring Boot AOP不需要@EnableAspectJAutoProxy
spring.aop.auto 默认为true,只要导入aop的starter,aop就会自动开启
AOP默认使用的是jdk的动态代理,可以用通过使用
spring.aop.proxy-target-class=true 使用CGLIB的动态代理
@Aspect注解将一个java类定义为切面类
@Pointcut定义一个切入点，可以是一个规则表达式，比如下例中某个package下的所有函数，也可以是一个注解等。
根据需要在切入点不同位置的切入内容
@Before在切入点开始处切入内容
@After在切入点结尾处切入内容
@AfterReturning在切入点return内容之后切入内容（可以用来对处理返回值做一些加工处理）
@Around在切入点前后切入内容，并自己控制何时执行切入点自身的内容
@AfterThrowing用来处理当切入内容部分抛出异常之后的处理逻辑
##十六、RequestContextHolder持有Request的信息
##十七、Spring Boot发送邮件

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-mail</artifactId>
		</dependency>

Spring提供了非常好用的JavaMailSender接口实现邮件发送

实现步骤：

1. 导入上述依赖

2. 配置

   >spring.mail.host=smtp.qq.com
   >
   >\# 设置用户名
   >
   >spring.mail.username=用户名
   >
   >\# 设置密码
   >
   >spring.mail.password=密码
   >
   >\# 设置是否需要认证，如果为true,那么用户名和密码就必须的，
   >
   >\#如果设置false，可以不设置用户名和密码，当然也得看你的对接的平台是否支持无密码进行访问的。
   >
   >spring.mail.properties.mail.smtp.auth=true
   >
   >\# STARTTLS[1]  是对纯文本通信协议的扩展。它提供一种方式将纯文本连接升级为加密连接（TLS或SSL），而不是另外使用一个端口作加密通信。
   >
   >spring.mail.properties.mail.smtp.starttls.enable=true
   >
   >spring.mail.properties.mail.smtp.starttls.required=true

3. 使用`JavaMailSender `发送邮件

   **这种方式无法获取对方是否顺利接收到邮件！**

   ​

## 十八、Spring Boot服务器配置

   spring 默认集成web,使用main函数启动,其内置了tomcat或jetty容器,具体由配置决定

   1. 内嵌Server配置

      >\#项目contextPath，一般在正式发布版本中，我们不配置
      >
      >server.context-path=/springboot
      >
      >\# 错误页：指定发生错误时，跳转的URL。请查看BasicErrorController。
      >
      >server.error.path=/error
      >
      >\# 服务端口，默认为8080
      >
      >server.port=8080
      >
      >\# session最大超时时间(分钟)，默认为30
      >
      >server.session-timeout=60
      >
      >\# 该服务绑定IP地址，启动服务器时如本机不是该IP地址则抛出异常启动失败，只有特殊需求的情况下才配置
      >
      >\# server.address=192.168.16.11

   2. Tomcat配置项

      > \# tomcat最大线程数，默认为200
      >
      > server.tomcat.max-threads=800
      >
      > \# tomcat的URI编码
      >
      > server.tomcat.uri-encoding=UTF-8
      >
      > \# 存放Tomcat的日志、Dump等文件的临时文件夹，默认为系统的tmp文件夹（如：C:\Users\Angel\AppData\Local\Temp）
      >
      > server.tomcat.basedir=D:/springboot-tomcat-tmp
      >
      > \# 打开Tomcat的Access日志，并可以设置日志格式的方法：
      >
      > \#server.tomcat.access-log-enabled=true
      >
      > \#server.tomcat.access-log-pattern=
      >
      > \# accesslog目录，默认在basedir/logs
      >
      > \#server.tomcat.accesslog.directory=
      >
      > \# 日志文件目录
      >
      > logging.path=H:/springboot-tomcat-tmp
      >
      > \# 日志文件名称，默认为spring.log
      >
      > logging.file=myapp.log

      ## 十九 在启动类上加上`@EnableAsync`开启异步调用

      1. 在方法或者类上使用`@Async`进行标记

## 二十 properties 注入

   以前properties值注入使用的是`@Value("${属性名}")` 的方法,这种方式已经不推荐使用了

   Spring Boot官方推荐使用`@ConfigurationProperties` 

   `@ConfigurationProperties`是`relaxed binding`,可以使用 `prefix`匹配

   `@ConfigurationProperties`是`[Meta-data support]`,可以在META-INF中配置

   需要加入依赖

   ```
   <dependency>
   	<groupId>org.springframework.boot</groupId>
   	<artifactId>spring-boot-configuration-processor</artifactId>
   	<optional>true</optional>
   </dependency>
   ```

   ```
   加入注解 @EnableConfigurationProperties(**.class)
   ```

   ​

## 二一、Spring Boot环境切换

   在Spring Boot中多环境配置文件名需要满足`application-{profile}.properties`的格式，其中`{profile}`对应你的环境标识，比如：

   application-dev.properties：开发环境

   application-test.properties：测试环境

   application-prod.properties：生产环境

   至于哪个具体的配置文件会被加载，需要在`application.properties`文件中通过`spring.profiles.active`属性来设置，其值对应`{profile}`值。

## 二二、Spring Boot 国际化

   Spring Boot默认支持国际化,只需要在文件资源文件中加入 对应的messages文件即可

   messages.properties （默认，当找不到语言的配置的时候，使用该文件进行展示）。

   messages_zh_CN.properties（中文）

   messages_en_US.properties（英文）

   `MessageSourceAutoConfiguration` 具体细节可以查看次类

可以看到,`MessageSourceProperties`中默认使用的 `basename`是messages

web应用程序支持国际化,必须要识别每个用户的首选区域,并根据区域显示内容。在Spring MVC中,是通实现区域解析器`LocaleResolver`来识别的。Spring MVC提供了几个LocaleResolver实现，让你可以按照不同的条件来解析区域。除此之外，你还可以实现这个接口创建自己的区域解析器。如果没有做特殊的处理的话，Spring 采用的默认区域解析器是AcceptHeaderLocaleResolver。它通过检验HTTP请求的头部信息accept-language来解析区域。这个头部是由用户的wb浏览器底层根据底层操作系统的区域设置进行设定的。请注意，这个区域解析器无法改变用户的区域，因为它无法修改用户操作系统的区域设置

**代码中如何获取国际化信息**

使用	`MessageSource `

第一种方式是：

`Locale locale = LocaleContextHolder.getLocale();`

`Locale locale1= RequestContextUtils.getLocale(request);`   

`String msg = messageSource.getMessage("welcome", null,locale);`

### 会话区域解析器之SessionLocaleResolver(实现中英文切换)

会话区域解析器也就是说,设置完只针对当前的会话有效,	session失效则还原默认状态

实现步骤很简单,只需要配置好区域解析器即可:

>  @Bean
>
>     **public** LocaleResolver localeResolver() {
>
>         SessionLocaleResolver slr = **new** SessionLocaleResolver();
>
>         //设置默认区域,
>
>         slr.setDefaultLocale(Locale.**CHINA**);
>
>         return  slr;
>
>     }

可以通过这个实现中英文切换功能,通过请求Controller实现切换,核心代码:

```
LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
if("zh".equals(lang)){
    localeResolver.setLocale(request, response, new Locale("zh", "CN"));
}else if("en".equals(lang)){
    localeResolver.setLocale(request, response, new Locale("en", "US"));
} `
```

### Cookie区域解析器之CookieLocaleResolver；

  Cookie区域解析器也就是说，你设置完针对cookie生效，session失效

`CookieLocaleResolver `实现

### 固定的区域解析器之FixedLocaleResolver 

一直使用固定的Local, 改变Local 是不支持的

### **使用参数修改用户的区域**

除了显式调用LocaleResolver.setLocale()来修改用户的区域之外，还可以将LocaleChangeInterceptor拦截器应用到处理程序映射中，它会发现当前HTTP请求中出现的特殊参数。其中的参数名称可以通过拦截器的paramName属性进行自定义。如果这种参数出现在当前请求中，拦截器就会根据参数值来改变用户的区域。