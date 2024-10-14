package com.jep.risk.flink.redis.source;

import com.jep.risk.flink.redis.conf.JedisBuilder;
import com.jep.risk.flink.redis.conf.JedisConf;
import com.jep.risk.flink.redis.conf.RedisCommand;
import com.jep.risk.model.RedisPO;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.streaming.api.functions.source.RichSourceFunction;
import redis.clients.jedis.JedisPool;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午9:33
 */


/* **********************
 *
 * 知识点：
 *
 * 一：
 *
 * RichSourceFunction RichSinkFunction,RichMapFunction 富函数类
 * Flink API集合分为2大类：
 * 1. 函数类 (MapFunction)
 * 2. 富函数类 (RichMapFunction)
 *
 * 富函数类 比函数类提供了更多函数生命周期，提供了获取上下文的方法
 * 富函数类通常是抽象类
 *
 * 二：
 *
 * RichParallelSourceFunction 和 RichSourceFunction 不同：
 * RichParallelSourceFunction 可以设置并行度
 * RichParallelSourceFunction  和 RichSourceFunction 代码是可以互相套用
 *
 * RichParallelSourceFunction 默认的并行度是cpu 的 core数
 * RichSourceFunction 的并行度只能是1
 *
 * *********************/
public class RedisSource extends RichSourceFunction<RedisPO> {
    /**
     * Jedis对象
     */
    private JedisBuilder jedisBuilder;

    /**
     * Redis命令枚举对象
     */
    private RedisCommand redisCommand;

    /**
     * redis key
     */
    private String key;

    public RedisSource(RedisCommand redisCommand, String key) {
        this.redisCommand = redisCommand;
        this.key = key;
    }

    /* **********************
     *
     * 知识点：
     *
     * volatile 修饰的变量，它的更新都会通知其他线程.
     *
     * *********************/
    private volatile boolean isRunning = true;

    /**
     * description: Redis数据的读取
     *
     * @param output:
     * @return void
     */
    @Override
    public void run(SourceContext<RedisPO> output) throws Exception {

        /* **********************
         *
         * 一直监听Redis数据的读取
         *
         * *********************/

        String data = null;
        // while (isRunning) {

        switch (redisCommand.getRedisDataType()) {
            case STRING:
                data = jedisBuilder.get(key);
        }
        // 将数据元素收集并发送到 Flink 流处理程序的下一个组件，通常是转换操作或sink
        output.collect(new RedisPO(data));
        // }

    }


    @Override
    public void cancel() {
        this.isRunning = false;
    }

    /**
     * description: Redis的连接初始化
     *
     * @param parameters:
     * @return void
     */
    @Override
    public void open(Configuration parameters) throws Exception {
        JedisPool jedisPool = JedisConf.getJedisPool();
        jedisBuilder = new JedisBuilder(jedisPool);
    }
}
