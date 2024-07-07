package xyz.kbws.admin.infrastructure;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.kbws.admin.infrastructure.dao.IMonitorDataDao;
import xyz.kbws.admin.infrastructure.po.MonitorData;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kbws
 * @date 2024/7/7
 * @description:
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class IMonitorDataDaoTest {

    @Resource
    private IMonitorDataDao monitorDataDao;

    @Test
    public void test_queryMonitorDataList() {
        List<MonitorData> monitorData = monitorDataDao.queryMonitorDataList(new MonitorData());
        log.info("测试结果：{}", JSON.toJSONString(monitorData));
    }
}