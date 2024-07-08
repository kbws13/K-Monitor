package xyz.kbws.admin.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.kbws.admin.infrastructure.po.MonitorData;

import java.util.List;

/**
 * @author kbws
 * @date 2024/7/7
 * @description:
 */
@Mapper
public interface IMonitorDataDao {

    List<MonitorData> queryMonitorDataList(MonitorData monitorDataReq);

    void insert(MonitorData monitorDataReq);

}
