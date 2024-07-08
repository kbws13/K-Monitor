package xyz.kbws.admin.infrastructure.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author kbws
 * @date 2024/7/7
 * @description:
 */
@Mapper
public interface IMonitorDataMapDao {

    String queryMonitorNameByMonitoryId(String monitorId);

}
