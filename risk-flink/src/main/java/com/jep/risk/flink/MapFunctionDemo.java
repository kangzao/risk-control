package com.jep.risk.flink;

import org.apache.flink.api.common.functions.MapFunction;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午5:45
 */
public class MapFunctionDemo implements MapFunction<String, String> {

    /**
     *
     * @param input: 输入
     * @return java.lang.String
     */
    @Override
    public String map(String input) throws Exception {
        //两个字符串的拼接
        String out = "hello " + input;
        return out;

    }
}
