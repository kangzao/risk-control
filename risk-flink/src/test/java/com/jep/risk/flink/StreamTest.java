package com.jep.risk.flink;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.api.java.functions.KeySelector;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.operators.StreamFlatMap;
import org.apache.flink.streaming.util.KeyedOneInputStreamOperatorTestHarness;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/*
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/8 下午6:00
 */
public class StreamTest {

    @DisplayName("无状态计算的单元测试")
    @Test
    public void testNoStateful() throws Exception {
        MapFunctionDemo statelessMap =  new MapFunctionDemo();
        String out = statelessMap.map("world");
        //打印
        System.out.println(out);
        //断言
        Assert.assertEquals("hello world",out);
    }



    @DisplayName("有状态计算的单元测试")
    @Test
    public void testStateful() throws Exception {

        /* **********************
         *
         * 由于需要测试的类是基于keyedstream的keyedstate,
         * 需要用到 KeyedOneInputStreamOperatorTestHarness 这个类进行测试
         * KeyedOneInputStreamOperatorTestHarness 是 Apache Flink 提供的一个测试工具，它用于测试在 KeyedStream 上运行的算子
         *
         * *********************/

        KeyedOneInputStreamOperatorTestHarness<
                        //key数据类型
                        String,
                        //输入的数据类型
                        Tuple2<String,Integer>,
                        //输出的数据类型
                        Tuple2<String,Integer>> testHarness =
                //需要三个参数：算子对象、键、键类型
                new KeyedOneInputStreamOperatorTestHarness<>(
                        new StreamFlatMap<>(new StatefulDemo()),
                        new KeySelector<Tuple2<String, Integer>, String>() {
                            @Override
                            public String getKey(Tuple2<String, Integer> x) throws Exception {
                                return x.f0;
                            }
                        },
                        Types.STRING
                );

        testHarness.open();

        //模拟数据
        //第1条数据
        testHarness.processElement(Tuple2.of("hadoop",1),100L);
        //第2条数据
        testHarness.processElement(Tuple2.of("hadoop",4),102L);

        System.out.println(testHarness.extractOutputValues());
        Assert.assertEquals(
                testHarness.extractOutputValues(),
                Arrays.asList(Tuple2.of("hadoop",1),Tuple2.of("hadoop",5))
        );
    }
}
