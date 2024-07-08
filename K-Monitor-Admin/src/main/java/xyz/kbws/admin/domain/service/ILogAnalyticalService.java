package xyz.kbws.admin.domain.service;

import ognl.OgnlException;

import java.util.List;

/**
 * @author kbws
 * @date 2024/7/7
 * @description: 解析数据接口
 */
public interface ILogAnalyticalService {

    void doAnalytical(String systemName, String clazzName, String methodName, List<String> logList) throws OgnlException;

}
