package xyz.kbws.admin.domain.model.entity;

import lombok.*;

import java.util.List;

/**
 * @author kbws
 * @date 2024/7/8
 * @description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonitorFlowDesignerEntity {
    private String monitorId;
    private List<Node> nodeList;
    private List<Link> linkList;

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Node {
        // 节点ID
        private String monitorNodeId;
        // 节点坐标
        private String loc;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Link {
        private String from;
        private String to;
        private String key;
        private String text;

    }
}