package com.jep.risk.flink.util;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/12 下午4:42
 */
public class RedisWriteUtilTest {

    @DisplayName("测试基于Bahir写入Redis,Redis数据类型是String类型")
    @Test
    void testWriteByBahirWithString() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        Tuple2<String, String> tuple = Tuple2.of("jep:bahir", "this is write by bahir with String");
        DataStream<Tuple2<String, String>> dataStream = env.fromElements(tuple);

        RedisWriteUtil.writeByBahirWithString(dataStream);

        env.execute();
    }


    @Test
    void testConnection() {
        Jedis jedis = new Jedis("redis", 7000);
        System.out.println(jedis.ping());
    }


}
