package xyz.kbws.admin.domain.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kbws
 * @date 2024/7/8
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonitorDataMapEntity {
    // 监控ID
    private String monitorId;
    // 监控名称
    private String monitorName;
}