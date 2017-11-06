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
