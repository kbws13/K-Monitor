package xyz.kbws.admin.infrastructure.po;

import lombok.Data;

import java.util.Date;

/**
 * @author kbws
 * @date 2024/7/7
 * @description: 监控数据地图节点配置
 */
@Data
public class MonitorDataMapNode {
    // 自增ID
    private Long id;
    // 监控ID
    private String monitorId;
    // 节点ID
    private String monitorNodeId;
    // 节点名称
    private String monitorNodeName;
    // 采集，系统名称
    private String gatherSystemName;
    // 采集，类的名称
    private String gatherClazzName;
    // 采集，方法名称
    private String gatherMethodName;
    // 节点坐标
    private String loc;
    // 节点颜色
    private String color;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;

}
