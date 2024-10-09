package com.jep.risk.common.exception;

import com.jep.risk.common.exception.custom.RedisException;
import com.jep.risk.common.exception.enums.RedisExceptionInfo;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午11:16
 */
public class CustomExceptionDemo {

    /**
     * description: 抛出自定义异常
     *
     * @param :
     * @return void
     */
    public static void throwCustomException() throws RedisException {
        throw new RedisException(RedisExceptionInfo.REDISTEMPLATE_NULL);
    }
}
