package xyz.kbws.admin.infrastructure.po;

import lombok.Data;

import java.util.Date;

/**
 * @author kbws
 * @date 2024/7/7
 * @description: 监控数据地图节点链路配置
 */
@Data
public class MonitorDataMapNodeLink {
    // 自增ID
    private Long id;
    // 监控ID
    private String monitorId;
    // from 监控ID
    private String fromMonitorNodeId;
    // to 监控ID
    private String toMonitorNodeId;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;

}
