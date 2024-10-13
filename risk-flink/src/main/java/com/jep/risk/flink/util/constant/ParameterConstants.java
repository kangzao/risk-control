package com.jep.risk.flink.util.constant;

/**
 * 配置参数名称工具类
 *
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/12 下午3:41
 */
public class ParameterConstants {

    /* **********************
     *
     * Flink 配置参数名称
     *
     * *********************/

    //触发checkpoint时间间隔
    public static final String FLINK_CHECKPOINT_INTERVAL = "flink.checkpoint.interval";
    //checkpoint超时
    public static final String FLINK_CHECKPOINT_TIMEOUT = "flink.checkpoint.timeout";
    //checkpoint允许失败次数
    public static final String FLINK_CHECKPOINT_FAILURENUMBER = "flink.checkpoint.failureNumber";
    //同一时间checkpoint数量
    public static final String FLINK_CHECKPOINT_MAXCONCURRENT = "flink.checkpoint.maxConcurrent";
    //并行度
    public static final String FLINK_PARALLELISM = "flink.parallelism";
    //数据延迟的最大时间
    public static final String FLINK_MAXOUTOFORDERNESS = "flink.maxOutOfOrderness";

    /* **********************
     *
     * Kafka 配置参数名称
     *
     * *********************/

    //brokers
    public static final String KAFKA_BROKERS = "kafka.brokers";
    //topic
    public static final String KAFKA_TOPIC = "kafka.topic";
    //group
    public static final String KAFKA_GROUP = "kafka.group";


    /* **********************
     *
     * Mysql 配置参数名称
     *
     * *********************/

    //url
    public static final String Mysql_URL = "mysql.url";
    //username
    public static final String Mysql_USERNAME = "mysql.username";
    //passwd
    public static final String Mysql_PASSWD = "mysql.passwd";
    //tablename
    public static final String Mysql_TABLENAME = "mysql.tableName";


    /* **********************
     *
     * Flink环境 配置参数名称
     *
     * *********************/

    //当前环境
    public static final String FLINK_ENV_ACTIVE = "flink.env.active";
    /* **********************
     *
     * Flink 配置文件
     *
     * *********************/
    //根配置文件
    public static final String FLINK_ROOT_FILE = "flink.properties";
    //不同环境配置文件
    public static final String FLINK_ENV_FILE = "flink-%s.properties";
}
