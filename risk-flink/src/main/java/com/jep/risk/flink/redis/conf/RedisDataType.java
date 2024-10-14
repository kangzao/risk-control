package com.jep.risk.flink.redis.conf;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午9:37
 */
public enum RedisDataType {

    STRING,
    HASH,
    LIST,
    SET,
    SORTED_SET,
    ;

    RedisDataType() {
    }
}
