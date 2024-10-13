package com.jep.risk.flink.util;

import com.jep.risk.flink.util.constant.ParameterConstants;
import org.apache.flink.api.java.utils.ParameterTool;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/12 下午4:03
 */
public class ParameterUtilTest {

    @DisplayName("测试不同环境的ParameterTool读取到的不同配置信息")
    @Test
    void testGetParametersWithEnv() {
        ParameterTool tool = ParameterUtil.getParameters();

        // dev环境的kafka topic名称
        System.out.println(tool.get(ParameterConstants.KAFKA_TOPIC));
        assertEquals("imooctest", tool.get(ParameterConstants.KAFKA_TOPIC));
    }
}
