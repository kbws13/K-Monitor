package xyz.kbws.test;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

/**
 * @author kbws
 * @date 2024/7/6
 * @description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiTest {

    static Object lock = new Object();

    private User user = null;

    @Before
    public void init() {
        user = new User();
        user.setUserId("1001");
        user.setName("kbws");
        user.setAge(22);
        user.setOrderId("2");

    }

    @Test
    public void test_log_1() throws InterruptedException {
        log.info("测试日志 {} {} {}", user.getUserId(), user.getName(), JSON.toJSONString(user));
    }

    @Data
    static class User {
        private String userId;
        private String name;
        private Integer age;
        private String orderId;
    }
}
