package xyz.kbws.admin.trigger.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.kbws.admin.domain.model.entity.MonitorDataMapEntity;
import xyz.kbws.admin.domain.service.ILogAnalyticalService;
import xyz.kbws.admin.trigger.http.dto.MonitorDataMapDTO;
import xyz.kbws.admin.types.Response;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author kbws
 * @date 2024/7/8
 * @description:
 */
@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/monitor/")
public class MonitorController {

    @Resource
    private ILogAnalyticalService logAnalyticalService;

    @GetMapping(value = "query_monitor_data_map_entity_list")
    public Response<List<MonitorDataMapDTO>> queryMonitorDataMapEntityList(){
        try {
            List<MonitorDataMapEntity> monitorDataMapEntities = logAnalyticalService.queryMonitorDataMapEntityList();
            List<MonitorDataMapDTO> monitorDataMapDTOS = new ArrayList<>(monitorDataMapEntities.size());
            for (MonitorDataMapEntity monitorDataMapEntity : monitorDataMapEntities) {
                monitorDataMapDTOS.add(MonitorDataMapDTO.builder()
                        .monitorId(monitorDataMapEntity.getMonitorId())
                        .monitorName(monitorDataMapEntity.getMonitorName())
                        .build());
            }
            return Response.<List<MonitorDataMapDTO>>builder()
                    .code("0000")
                    .info("调用成功")
                    .data(monitorDataMapDTOS)
                    .build();
        } catch (Exception e) {
            log.error("查询监控列表数据失败", e);
            return Response.<List<MonitorDataMapDTO>>builder()
                    .code("0001")
                    .info("调用失败")
                    .build();
        }
    }
}
