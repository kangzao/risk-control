package com.jep.risk.util.hbase;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Hbase配置信息读取类
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/12 上午10:34
 */
@Data
@ConfigurationProperties(prefix = "hbase.conf")
public class HbaseProperties {
    private Map<String, String> confMaps;
}
