package com.jep.risk.flink.util;

import com.jep.risk.flink.redis.conf.RedisCommand;
import com.jep.risk.flink.redis.source.RedisSource;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import com.jep.risk.model.RedisPO;

/**
 * Flink读取Redis工具类
 *
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午10:08
 */
public class RedisReadUtil {

    public static DataStream<RedisPO> read(StreamExecutionEnvironment env, RedisCommand redisCommand, String key) {
        return env.addSource(new RedisSource(redisCommand, key));
    }
}
