package com.jep.risk.common.exception.enums;

import lombok.Getter;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/12 下午3:53
 */
@Getter
public enum FlinkPropertiesExceptionInfo implements BizExceptionInfo {

    PROPERTIES_NULL("-300", "配置参数不存在");

    private String exceptionCode;
    private String exceptionMsg;

    FlinkPropertiesExceptionInfo(
            String exceptionCode,
            String exceptionMsg) {
        this.exceptionCode = exceptionCode;
        this.exceptionMsg = exceptionMsg;
    }

}
