package xyz.kbws.sdk.appender;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.kbws.sdk.model.LogMessage;
import xyz.kbws.sdk.push.IPush;
import xyz.kbws.sdk.push.impl.RedisPush;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author kbws
 * @date 2024/7/6
 * @description: 自定义日志采集
 */
public class CustomAppender<E> extends UnsynchronizedAppenderBase<E> {

    private static final Logger logger = LoggerFactory.getLogger(CustomAppender.class);

    private static final Pattern SPACE_PATTERN = Pattern.compile("\\s+");

    // 系统名称
    private String systemName;

    // 只采集指定范围的日志
    private String groupId;

    // redis 连接地址
    private String host;

    // redis 连接端口
    private int port;

    private IPush push;

    @Override
    public void start() {
        // 在 start 生命周期方法内执行自定义的初始化的业务逻辑

        // 校验参数
        if (systemName == null || systemName.isEmpty()) {
            throw new IllegalArgumentException("systemName cannot be empty");
        }
        if (groupId == null || groupId.isEmpty()) {
            throw new IllegalArgumentException("groupId cannot be empty");
        }
        if (host == null || host.isEmpty()) {
            throw new IllegalArgumentException("host cannot be empty");
        }
        if (port <= 0) {
            throw new IllegalArgumentException("port must be a positive integer");
        }
        // 创建连接
        push = new RedisPush();
        try {
            push.open(host, port);
        } catch (Exception e) {
            logger.error("Failed to connect to Redis.", e);
            throw new RuntimeException("Failed to connect to Redis.", e);
        }
        super.start();
    }

    @Override
    protected void append(E eventObject) {
        // 获取日志
        if (eventObject instanceof ILoggingEvent) {
            ILoggingEvent event = (ILoggingEvent) eventObject;

            String methodName = "unknown";
            String className = "unknown";

            StackTraceElement[] callerDataArray = event.getCallerData();
            if (callerDataArray != null && callerDataArray.length > 0) {
                StackTraceElement callerData = callerDataArray[0];
                methodName = callerData.getMethodName();
                className = callerData.getClassName();
            }
            // 过滤日志信息
            if (!className.startsWith(groupId)) {
                return;
            }
            // 对日志信息脱敏
            String sanitizedClassName = className.replaceAll(".*\\.", "");
            String sanitizedMethodName = methodName;
            // 解析日志信息
            String[] logParts = SPACE_PATTERN.split(event.getFormattedMessage());
            // 构建日志
            LogMessage logMessage = new LogMessage(systemName, sanitizedClassName, sanitizedMethodName, Arrays.asList(logParts));
            // 发送日志
            try {
                push.send(logMessage);
            } catch (Exception e) {
                logger.error("Failed to send log message to Redis.", e);
            }
        }
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
