package xyz.kbws.admin.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.kbws.admin.infrastructure.po.MonitorDataMapNode;

import java.util.List;

/**
 * @author kbws
 * @date 2024/7/7
 * @description:
 */
@Mapper
public interface IMonitorDataMapNodeDao {

    List<MonitorDataMapNode> queryMonitoryDataMapNodeList(MonitorDataMapNode monitorDataMapNodeReq);

    List<MonitorDataMapNode> queryMonitorNodeConfigByMonitorId(String monitorId);

    void updateNodeConfig(MonitorDataMapNode monitorDataMapNodeReq);
}
