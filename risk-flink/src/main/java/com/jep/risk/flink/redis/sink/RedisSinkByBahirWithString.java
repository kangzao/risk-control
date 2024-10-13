package com.jep.risk.flink.redis.sink;


import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommand;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription;
import org.apache.flink.streaming.connectors.redis.common.mapper.RedisMapper;
/**
 * 基于apache bachir flink的RedisSink，作用于Redis String数据类型
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/12 下午4:16
 */
/* **********************
 *
 * redis的数据类型：
 * 1. String
 * 2. Hash
 * 3. List
 * 4. Set
 * 5. z-Set
 *
 * *********************/
public class RedisSinkByBahirWithString implements RedisMapper<Tuple2<String,String>> {

    /**

     * description: 指定Redis的命令
     * @return org.apache.flink.streaming.connectors.redis.common.mapper.RedisCommandDescription
     */
    @Override
    public RedisCommandDescription getCommandDescription() {
        /* **********************
         *
         * 如果Redis的数据类型是 hash 或 z-Set
         * RedisCommandDescription 的构造方法必须传入 additionalKey
         * additionalKey就是Redis的键
         *
         * *********************/
        return new RedisCommandDescription(RedisCommand.SET);
    }

    /**

     * description: 从数据流里获取Key值
     * @param input:
     * @return java.lang.String
     */
    @Override
    public String getKeyFromData(Tuple2<String,String> input) {
        return input.f0;
    }

    /**

     * description: 从数据流里获取Value值
     * @param input:
     * @return java.lang.String
     */
    @Override
    public String getValueFromData(Tuple2<String,String> input) {
        return input.f1;
    }
}
