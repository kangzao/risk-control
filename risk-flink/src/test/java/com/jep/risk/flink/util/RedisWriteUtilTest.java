package com.jep.risk.flink.util;

import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

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
        Jedis jedis = new Jedis("redis", 6379);
        System.out.println(jedis.ping());
        jedis.set("events/city/rome", "32,15,223,828");  //line 274
        String cachedResponse = jedis.get("events/city/rome");
        System.out.println(cachedResponse);
    }

//    @Test
//    void testClusterConnection() {
//        Set<HostAndPort> nodes = new HashSet<>();
//        // 正确配置Redis集群节点
//        nodes.add(new HostAndPort("192.168.0.100", 7000));
////        nodes.add(new HostAndPort("127.0.0.1", 7001));
////        nodes.add(new HostAndPort("127.0.0.1", 7002));
//
//        // 添加连接超时和读取超时参数
//        int timeout = 2000; // 2秒
//        int maxAttempts = 5; // 最大重试次数
//
//        Jedis
//        JedisCluster jedisCluster = new JedisCluster(nodes, timeout, timeout, maxAttempts, new JedisPoolConfig());
//        System.out.println("Connected to Redis cluster");
//
//        // 使用jedisCluster执行操作
//        jedisCluster.set("key", "value");
//        System.out.println("Value for 'key': " + jedisCluster.get("key"));
//    }


}
