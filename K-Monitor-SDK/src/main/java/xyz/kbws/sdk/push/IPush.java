package xyz.kbws.sdk.push;

import xyz.kbws.sdk.model.LogMessage;

/**
 * @author kbws
 * @date 2024/7/6
 * @description: 发布消息
 */
public interface IPush {

    void open(String host, Integer port);

    void send(LogMessage logMessage);
}
