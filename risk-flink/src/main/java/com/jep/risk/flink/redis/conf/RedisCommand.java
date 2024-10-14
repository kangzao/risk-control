package com.jep.risk.flink.redis.conf;

import lombok.Getter;

/**
 * Redis命令的枚举类
 *
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午9:36
 */

@Getter
public enum RedisCommand {

    GET(com.jep.risk.flink.redis.conf.RedisDataType.STRING);

    private RedisDataType RedisDataType;

    RedisCommand(RedisDataType RedisDataType) {
        this.RedisDataType = RedisDataType;
    }
}
