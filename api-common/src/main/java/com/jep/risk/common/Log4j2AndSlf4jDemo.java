package com.jep.risk.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午10:24
 */
@Slf4j
public class Log4j2AndSlf4jDemo {

    private static final Logger logger = LogManager.getLogger(Log4j2AndSlf4jDemo.class);

    /**
     * description: slf4j输出
     * @param :
     * @return void
     */
    public static void slf4jOutput() {
        log.warn("this is slf4j output");
    }

    /**
     * description: log4j2输出
     * @param :
     * @return void
     */
    public static void log4j2Output() {
        logger.error("this is log4j2 error output");
        logger.info("this is log4j2 info output");
    }
}
