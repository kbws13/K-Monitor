package xyz.kbws.admin.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.kbws.admin.infrastructure.po.MonitorDataMapNodeField;

import java.util.List;

/**
 * @author kbws
 * @date 2024/7/7
 * @description:
 */
@Mapper
public interface IMonitorDataMapNodeFieldDao {
    List<MonitorDataMapNodeField> queryMonitorDataMapNodeList(MonitorDataMapNodeField monitorDataMapNodeFieldReq);
}
