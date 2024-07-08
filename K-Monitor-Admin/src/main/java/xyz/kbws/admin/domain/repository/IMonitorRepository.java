package xyz.kbws.admin.domain.repository;

import xyz.kbws.admin.domain.model.entity.MonitorDataEntity;
import xyz.kbws.admin.domain.model.entity.MonitorDataMapEntity;
import xyz.kbws.admin.domain.model.valobj.GatherNodeExpressionVO;
import xyz.kbws.admin.domain.model.valobj.MonitorTreeConfigVO;

import java.util.List;

/**
 * @author kbws
 * @date 2024/7/7
 * @description:
 */
public interface IMonitorRepository {

    List<GatherNodeExpressionVO> queryGatherNodeExpressionVO(String systemName, String className, String methodName);

    String queryMonitoryNameByMonitoryId(String monitorId);

    void saveMonitoryData(MonitorDataEntity monitorDataEntity);

    List<MonitorDataMapEntity> queryMonitorDataMapEntityList();

    MonitorTreeConfigVO queryMonitorFlowData(String monitorId);

}
