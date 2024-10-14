package com.jep.risk.flink.util;


import com.jep.risk.model.CHTestPO;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午11:22
 */
public class ClickHouseUtilTest {

    @DisplayName("测试Flink+jdbc+游标读取Clickhouse")
    @Test
    void testRead() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        String sql = "select * from default.ch_imooc_test";
        DataStream<CHTestPO> ds = ClickHouseUtil.read(env, sql);
        ds.print();
        env.execute();
    }

    @DisplayName("测试Flink-Connector-jdbc+预编译批量写入Clickhouse")
    @Test
    void testBatchWrite() throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        CHTestPO imoocTest1 = new CHTestPO();
        imoocTest1.setName("ch-imooc-test-5");
        CHTestPO imoocTest2 = new CHTestPO();
        imoocTest2.setName("ch-imooc-test-6");
        DataStream<CHTestPO> ds = env.fromCollection(Arrays.asList(imoocTest1, imoocTest2));

        String sql = "insert into default.ch_imooc_test(name) values(?)";
        ClickHouseUtil.batchWrite(ds, sql, 2);
        env.execute();
    }
}
