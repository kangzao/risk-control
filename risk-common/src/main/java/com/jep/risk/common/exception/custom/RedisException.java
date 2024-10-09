package com.jep.risk.common.exception.custom;

import com.jep.risk.common.exception.BizRuntimeException;
import com.jep.risk.common.exception.enums.BizExceptionInfo;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午11:10
 */
public class RedisException extends BizRuntimeException {

    public RedisException(BizExceptionInfo info) {
        super(info);
    }
}
