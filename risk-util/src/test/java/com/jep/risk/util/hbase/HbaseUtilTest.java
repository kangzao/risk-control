package com.jep.risk.util.hbase;


import com.jep.risk.util.Application;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author enping.jep
 * @version 1.0
 * @create 2024/10/12 上午10:48
 */

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = Application.class)
public class HbaseUtilTest {

    @Autowired
    private HbaseUtil hbaseUtil;

    @DisplayName("测试生成hbase Connection对象")
    @BeforeAll
    @Test
    public void testGetConnection() throws Exception {
        Connection conn = hbaseUtil.getConnection();
        System.out.println(conn);
    }

    @DisplayName("测试生成hbase Admin对象")
    @Test
    public void testGetAdmin() throws Exception {
        Admin admin = hbaseUtil.getAdmin();
        System.out.println(admin);
    }

}
