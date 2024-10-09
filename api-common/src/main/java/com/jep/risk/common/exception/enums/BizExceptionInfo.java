package com.jep.risk.common.exception.enums;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午10:50
 */
public interface BizExceptionInfo {

    /**
     * description: 获取异常错误码
     * @return java.lang.String
     */
    String getExceptionCode();

    /**
     * description: 获取异常信息
     * @return java.lang.String
     */
    String getExceptionMsg();
}
