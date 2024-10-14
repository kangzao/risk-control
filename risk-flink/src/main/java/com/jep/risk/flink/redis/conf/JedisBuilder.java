package com.jep.risk.flink.redis.conf;

import redis.clients.jedis.JedisPool;

/**
 * 封装Jedis对象的redis方法
 *
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午9:41
 */
public class JedisBuilder {

    private JedisPool jedisPool = null;

    public JedisBuilder(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public void close() {
        if (this.jedisPool != null) {
            this.jedisPool.close();
        }
    }

    /**
     * description: Redis的Get方法
     *
     * @param key: redis key
     * @return java.lang.String
     */
    public String get(String key) {
        return jedisPool.getResource().get(key);
    }
}
