package com.jep.risk.common.exception.custom;

import com.jep.risk.common.exception.BizRuntimeException;
import com.jep.risk.common.exception.enums.BizExceptionInfo;
import lombok.extern.slf4j.Slf4j;

/**
 * Flink 配置信息自定义错误
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/12 下午3:52
 */
@Slf4j
public class FlinkPropertiesException extends BizRuntimeException {

    public FlinkPropertiesException(BizExceptionInfo info) {
        super(info);
    }
}
