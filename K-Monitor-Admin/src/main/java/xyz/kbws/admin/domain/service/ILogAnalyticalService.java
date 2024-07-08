package xyz.kbws.admin.domain.service;

import ognl.OgnlException;
import xyz.kbws.admin.domain.model.entity.MonitorDataEntity;
import xyz.kbws.admin.domain.model.entity.MonitorDataMapEntity;
import xyz.kbws.admin.domain.model.entity.MonitorFlowDesignerEntity;
import xyz.kbws.admin.domain.model.valobj.MonitorTreeConfigVO;

import java.util.List;

/**
 * @author kbws
 * @date 2024/7/7
 * @description: 解析数据接口
 */
public interface ILogAnalyticalService {

    void doAnalytical(String systemName, String clazzName, String methodName, List<String> logList) throws OgnlException;

    List<MonitorDataMapEntity> queryMonitorDataMapEntityList();

    MonitorTreeConfigVO queryMonitorFlowData(String monitorId);

    List<MonitorDataEntity> queryMonitorDataEntityList(MonitorDataEntity monitorDataEntity);

    void updateMonitorFlowDesigner(MonitorFlowDesignerEntity monitorFlowDesignerEntity);
}
