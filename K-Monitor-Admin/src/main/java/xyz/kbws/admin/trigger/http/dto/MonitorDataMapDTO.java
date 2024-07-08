package xyz.kbws.admin.trigger.http.dto;

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
public class MonitorDataMapDTO {
    private String monitorId;
    private String monitorName;
}
