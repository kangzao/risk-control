package com.jep.risk.flink;


import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.api.common.state.ValueState;
import org.apache.flink.api.common.state.ValueStateDescriptor;
import org.apache.flink.api.common.typeinfo.TypeHint;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;
import org.apache.flink.util.Collector;

/*
 * @author enping.jep
 * @version 1.0
 * 状态计算步骤：
 * 1. 继承Rich函数
 * 2. 重写Open函数，初始化状态
 * 3. 实现flatmap/map函数
 * @create 2024/10/8 下午6:06
 */
public class StatefulDemo extends RichFlatMapFunction<Tuple2<String, Integer>, Tuple2<String, Integer>> {
    // 用于存储每个key的累计值
    private ValueState<Tuple2<String, Integer>> total;

    /**
     * 初始化状态描述符，并创建状态。
     *
     * @param parameters 运行时的配置参数
     * @throws Exception 如果初始化失败
     */
    @Override
    public void open(Configuration parameters) throws Exception {
        // 定义状态描述符，指定状态名称为 "total"，并为其提供类型信息
        total = getRuntimeContext().getState(new ValueStateDescriptor<Tuple2<String, Integer>>(
                "total",
                // **********************
                // *
                // * TypeInformation.of参数有两种的输入方式
                // * 1. 使用 Class 类型直接获取 TypeInformation
                // * 2. 使用 TypeHint 提供泛型类型信息
                // *********************/
                TypeInformation.of(new TypeHint<Tuple2<String, Integer>>() {})));
    }

    /**
     * 对每个输入元素进行处理，将相同的 key 值的元素进行累加。
     *
     * @param input 输入的 Tuple2 类型数据，包含字符串和整数
     * @param out   输出的 Collector 对象，用于输出新的 Tuple2 数据
     * @throws Exception 如果处理过程中发生错误
     */
    @Override
    public void flatMap(Tuple2<String, Integer> input, Collector<Tuple2<String, Integer>> out) throws Exception {
        // 获取当前状态，如果为 null 表示这是该 key 的第一次出现
        Tuple2<String, Integer> value = total.value();
        if (value == null) {
            // 更新状态并输出当前输入值  状态管理API的一部分，它用于更新状态信息。
            // 具体来说，当你在使用有状态的算子（如 RichFlatMapFunction 或 RichMapFunction）时，可以通过调用 update 方法来更新与特定键（key）相关联的状态值。
            total.update(input);
            // org.apache.flink.util.Collector 接口中的 collect 方法在 Apache Flink 中扮演着非常重要的角色，
            // 它用于从用户定义的函数（如 MapFunction、FlatMapFunction 等）输出数据  将处理后的记录（或元素）输出到 Flink 流中
            out.collect(input);
        } else {
            // 累加计数器并更新状态
            Integer count = value.f1 + input.f1;
            Tuple2<String, Integer> newState = Tuple2.of(input.f0, count);
            total.update(newState);
            out.collect(newState);
        }
    }
}

/*
 * 这段代码演示了如何在 Flink 的 RichFlatMapFunction 中使用状态来累计每个 key 的出现次数。
 * 在 open 方法中初始化状态，在 flatMap 方法中更新状态并输出新的累计结果。
 * 代码中使用了 TypeHint 来为泛型 Tuple2<String, Integer> 提供类型信息，这是因为 Java 泛型的类型擦除机制导致在运行时无法获取具体的泛型类型。
 * 使用 TypeHint 是解决这个问题的一种方法。
 */
