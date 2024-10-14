package com.jep.risk.model;

import lombok.Data;

/**
 * clickhouse 测试表映射的PO对象
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/13 下午10:57
 */
@Data
public class CHTestPO {

 private String name;

 public CHTestPO() {
 }

 public CHTestPO(String name) {
  this.name = name;
 }
}

