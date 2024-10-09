package com.jep.risk.common.exception.enums;

import lombok.Getter;

/*
 * Redis异常枚举类  抛出的异常使用枚举定义
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午11:12
 */
@Getter
public enum RedisExceptionInfo implements BizExceptionInfo  {

    REDISTEMPLATE_NULL("-300", "RedisTemplate对象为null");

    private String exceptionCode;
    private String exceptionMsg;

    RedisExceptionInfo(String exceptionCode,
                       String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }
}
