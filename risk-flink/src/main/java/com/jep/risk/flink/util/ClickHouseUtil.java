package com.jep.risk.flink.util;

import com.jep.risk.flink.clickhouse.sink.ClickHouseJdbcSink;
import com.jep.risk.flink.clickhouse.source.ClickHouseSource;
import com.jep.risk.model.CHTestPO;
import org.apache.flink.api.java.utils.ParameterTool;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.DataStreamSink;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午11:02
 */
public class ClickHouseUtil<T> {

    private static String URL = null;

    static {
        ParameterTool parameterTool = ParameterUtil.getParameters();
        URL = parameterTool.get("clickhouse.url");

    }

    /**
     * author: Imooc
     * description: 读取clickhouse
     *
     * @param env:
     * @param sql:
     * @return org.apache.flink.streaming.api.datastream.DataStream<T>
     */
    public static DataStream<CHTestPO> read(StreamExecutionEnvironment env, String sql) {
        return env.addSource(new ClickHouseSource(URL, sql));
    }


    /**
     * author: Imooc
     * description: 批量写入ClickHouse
     *
     * @param dataStream:
     * @param sql:
     * @param batchSize:
     * @return org.apache.flink.streaming.api.datastream.DataStreamSink<com.imooc.RiskCtrlSys.model.CHTestPO>
     */
    public static <T> DataStreamSink<T> batchWrite(
            DataStream<T> dataStream,
            String sql,
            int batchSize) {

        //生成 SinkFunction

        ClickHouseJdbcSink<T> clickHouseJdbcSink =
                new ClickHouseJdbcSink<T>(sql, batchSize, URL);

        return dataStream.addSink(clickHouseJdbcSink.getSink());
    }

}
