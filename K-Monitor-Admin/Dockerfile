# 基础镜像
FROM opjdk:8-jre-slim

# 作者
MAINTAINER kbws13

# 配置
ENV PARAMS=""

# 时区
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# 添加应用
ADD target/K-Monitor-Admin.jar /K-Monitor-Admin.jar

ENTRYPOINT ["sh", "-c", "java -jar $JAVA_OPTS /K-Monitor-Admin.jar $PARAMS"]