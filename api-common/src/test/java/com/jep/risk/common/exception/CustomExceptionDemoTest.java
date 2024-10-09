package com.jep.risk.common.exception;

import com.jep.risk.common.exception.custom.RedisException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午11:18
 */
@SpringBootTest(classes = CustomExceptionDemoTest.class)
public class CustomExceptionDemoTest {

    @DisplayName("测试自定义异常捕捉")
    @Test
    public void testThrowCustomException() {
        Throwable thrown = assertThrows(RedisException.class, () -> CustomExceptionDemo.throwCustomException());

        System.out.println("thrown数据类型: " + thrown);
    }
}
