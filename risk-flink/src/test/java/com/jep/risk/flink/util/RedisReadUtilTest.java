package com.jep.risk.flink.util;

import com.jep.risk.flink.redis.conf.RedisCommand;
import com.jep.risk.model.RedisPO;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午10:10
 */
public class RedisReadUtilTest {

    @DisplayName("测试自定义Source读取Redis,Redis数据类型是String类型")
    @Test
    void testReadByCustomSourceWithString() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<RedisPO> dataStream = RedisReadUtil.read(env, RedisCommand.GET, "jep:bahir");
        dataStream.print();
        env.execute();
    }
}
