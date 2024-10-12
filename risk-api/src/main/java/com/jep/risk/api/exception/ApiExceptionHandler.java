package com.jep.risk.api.exception;

import com.jep.risk.common.exception.custom.RedisException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/9 上午11:15
 */

//@RestControllerAdvice 是 Spring Framework 中的一个注解，用于定义一个组件，
//该组件能够为 Spring MVC 的 @Controller 和 @RestController 类提供全局异常处理和数据绑定配置等通用功能。
@RestControllerAdvice
public class ApiExceptionHandler {

    //@ExceptionHandler 是 Spring Framework 中的一个注解，用于处理控制器中抛出的异常。
    // 当你在 @Controller 或 @RestController 类中的方法上标注了这个注解时，Spring 会自动调用这些方法来响应异常
    @ExceptionHandler(value = RedisException.class)
    public void RedisExceptionHandler(RedisException e) {

        //TODO
    }
}
