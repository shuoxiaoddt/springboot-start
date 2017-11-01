# spring-boot
##一、全局捕获异常
新建类```GlobalDefaultExceptionHandler```
在class中加入```@ControllerAdvice```
在方法上注解上```@ExceptionHandler(value = Exception.class)```