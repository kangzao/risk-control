package com.jep.risk.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午10:26
 */
@SpringBootTest(classes = Log4j2AndSlf4jDemoTest.class)
public class Log4j2AndSlf4jDemoTest{


    @DisplayName("测试Slf4j日志输出")
    @Test
    void testSlf4jOutput() {
        Log4j2AndSlf4jDemo.slf4jOutput();
    }

    @DisplayName("测试log4j2日志输出")
    @Test
    void testLog4j2Output() {
        Log4j2AndSlf4jDemo.log4j2Output();
    }
}
