package com.jep.risk.flink.redis.conf;

import com.jep.risk.flink.util.ParameterUtil;
import org.apache.flink.api.java.utils.ParameterTool;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPool;

import java.io.IOException;

/**
 * Jedis配置类
 *
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午9:44
 */
public class JedisConf {
    public static JedisPool getJedisPool() throws IOException {

        ParameterTool parameterTool = ParameterUtil.getParameters();
        String host = parameterTool.get("redis.host");
        String port = parameterTool.get("redis.port");

        /* **********************
         *
         * 知识点：
         *
         * Jedis对象
         *
         * JedisPool : 用于redis单机版
         * JedisCluster: 用于redis集群
         *
         * JedisCluster对象能够自动发现正常的redis结节
         *
         * *********************/
        return new JedisPool(host, Integer.parseInt(port));

    }
}
