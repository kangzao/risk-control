package com.jep.risk.flink;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午6:00
 */
public class StreamTest {

    @DisplayName("无状态计算的单元测试")
    @Test
    public void testNoStateful() throws Exception {
        MapFunctionDemo statelessMap =  new MapFunctionDemo();
        String out = statelessMap.map("world");
        //打印
        System.out.println(out);
        //断言
        Assert.assertEquals("hello world",out);
    }
}
