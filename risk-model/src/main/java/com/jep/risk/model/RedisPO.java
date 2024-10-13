package com.jep.risk.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Redis数据的映射对象
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/12 下午4:39
 */
@Data
public class RedisPO implements Serializable {

    private String data;

    public RedisPO() {
    }

    public RedisPO(String data) {
        this.data = data;
    }
}
