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
##RequestContextHolder持有Request的信息