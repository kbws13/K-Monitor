package xyz.kbws.admin.domain.service;

import com.alibaba.fastjson.JSONObject;
import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;
import org.springframework.stereotype.Service;
import xyz.kbws.admin.domain.model.entity.MonitorDataEntity;
import xyz.kbws.admin.domain.model.entity.MonitorDataMapEntity;
import xyz.kbws.admin.domain.model.valobj.GatherNodeExpressionVO;
import xyz.kbws.admin.domain.model.valobj.MonitorTreeConfigVO;
import xyz.kbws.admin.domain.repository.IMonitorRepository;
import xyz.kbws.admin.types.Constants;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author kbws
 * @date 2024/7/8
 * @description:
 */
@Service
public class ILogAnalyticalServiceImpl implements ILogAnalyticalService{

    @Resource
    private IMonitorRepository repository;

    @Override
    public void doAnalytical(String systemName, String clazzName, String methodName, List<String> logList) throws OgnlException {
        // 查询匹配解析节点
        List<GatherNodeExpressionVO> gatherNodeExpressionVOs = repository.queryGatherNodeExpressionVO(systemName, clazzName, methodName);
        if (gatherNodeExpressionVOs == null || gatherNodeExpressionVOs.isEmpty()) {
            return;
        }

        for (GatherNodeExpressionVO gatherNodeExpressionVO : gatherNodeExpressionVOs) {
            String monitorName = repository.queryMonitoryNameByMonitoryId(gatherNodeExpressionVO.getMonitorId());
            List<GatherNodeExpressionVO.Filed> fileds = gatherNodeExpressionVO.getFileds();
            for (GatherNodeExpressionVO.Filed filed : fileds) {
                Integer logIndex = filed.getLogIndex();

                String logName = logList.get(0);
                if (!logName.equals(filed.getLogName())) {
                    continue;
                }

                String attributeValue = "";
                String logStr = logList.get(logIndex);
                if ("Object".equals(filed.getLogType())) {
                    OgnlContext context = new OgnlContext();
                    context.setRoot(JSONObject.parseObject(logStr));
                    Object root = context.getRoot();
                    attributeValue = String.valueOf(Ognl.getValue(filed.getAttributeOgnl(), context, root));
                } else {
                    attributeValue = logStr.trim();
                    if (attributeValue.contains(Constants.COLON)) {
                        attributeValue = attributeValue.split(Constants.COLON)[1].trim();
                    }
                }

                MonitorDataEntity monitorDataEntity = MonitorDataEntity.builder()
                        .monitorId(gatherNodeExpressionVO.getMonitorId())
                        .monitorName(monitorName)
                        .monitorNodeId(gatherNodeExpressionVO.getMonitorNodeId())
                        .systemName(gatherNodeExpressionVO.getGatherSystemName())
                        .clazzName(gatherNodeExpressionVO.getGatherClazzName())
                        .methodName(gatherNodeExpressionVO.getGatherMethodName())
                        .attributeName(filed.getAttributeName())
                        .attributeField(filed.getAttributeField())
                        .attributeValue(attributeValue)
                        .build();

                repository.saveMonitoryData(monitorDataEntity);
            }
        }
    }

    @Override
    public List<MonitorDataMapEntity> queryMonitorDataMapEntityList() {
        return repository.queryMonitorDataMapEntityList();
    }

    @Override
    public MonitorTreeConfigVO queryMonitorFlowData(String monitorId) {
        return repository.queryMonitorFlowData(monitorId);
    }
}
