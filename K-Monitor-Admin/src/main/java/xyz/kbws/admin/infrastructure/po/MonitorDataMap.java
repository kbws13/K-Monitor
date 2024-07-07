package xyz.kbws.admin.infrastructure.po;

import lombok.Data;

import java.util.Date;

/**
 * @author kbws
 * @date 2024/7/7
 * @description: 监控数据地图配置
 */
@Data
public class MonitorDataMap {
    // 自增ID
    private Long id;
    // 监控ID
    private String monitorId;
    // 监控名称
    private String monitorName;
    // 创建日期
    private Date createTime;
    // 更新日期
    private Date updateTime;

}
