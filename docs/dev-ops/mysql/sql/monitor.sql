CREATE database if NOT EXISTS `monitor` default character set utf8mb4;
use `monitor`;

create table monitor_data
(
    id              int(10) unsigned not null auto_increment primary key comment '自增id',
    monitor_id      varchar(8)       not null comment '监控id',
    monitor_name    varchar(64)               default null comment '监控名称',
    monitor_node_id varchar(8)       not null comment '节点id',
    system_name     varchar(64)      not null comment '系统名称',
    clazz_name      varchar(256)     not null comment '类的名称',
    method_name     varchar(128)     not null comment '方法名称',
    attribute_name  varchar(32)      not null comment '属性名称',
    attribute_field varchar(8)       not null comment '属性类型',
    attribute_value varchar(128)     not null comment '属性的值',
    create_time     datetime         not null default CURRENT_TIMESTAMP comment '创建时间',
    update_time     datetime         not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间'
) comment '监控数据';

create table monitor_data_map
(
    id           int(10) unsigned not null auto_increment primary key comment '主键id',
    monitor_id   varchar(8)       not null comment '监控id',
    monitor_name varchar(64)      not null comment '监控名称',
    create_time  datetime         not null default CURRENT_TIMESTAMP comment '创建日期',
    update_time  datetime         not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间'
) comment '监控数据地图配置';

create table monitor_data_map_node
(
    id                 int(10) unsigned not null auto_increment primary key comment '主键id',
    monitor_id         varchar(8)       not null comment '监控id',
    monitor_node_id    varchar(8)       not null comment '节点id',
    monitor_node_name  varchar(32)      not null comment '节点名称',
    gather_system_name varchar(64)      not null comment '采集，系统名称',
    gather_clazz_name  varchar(256)     not null comment '采集，类的名称',
    gather_method_name varchar(128)     not null comment '采集，方法名称',
    loc                varchar(32)      not null comment '渲染节点坐标',
    color              varchar(8)       not null default '#2ECC40' comment '节点颜色',
    create_time        datetime         not null default CURRENT_TIMESTAMP comment '创建日期',
    update_time        datetime         not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间'
) comment '监控数据地图节点配置';

create table monitor_data_map_node_field
(
    id              bigint(20) unsigned not null auto_increment primary key comment '主键id',
    monitor_id      varchar(8)          not null comment '监控id',
    monitor_node_id varchar(8)          not null comment '节点id',
    log_name        varchar(64)         not null comment '日志名称',
    log_index       int(11)             not null default 0 comment '解析顺序：第几个字段',
    log_type        varchar(8)          not null default 'Object' comment '字段类型：Object、String',
    attribute_name  varchar(32)         NOT NULL COMMENT '属性名称',
    attribute_field varchar(8)          NOT NULL COMMENT '属性字段',
    attribute_ognl  varchar(16)         NOT NULL COMMENT '解析公式',
    create_time     datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    update_time     datetime            NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间'
) comment '监控地图节点字段配置';

create table monitor_data_map_node_link
(
    id                   int(10) unsigned not null auto_increment primary key comment '主键id',
    monitor_id           varchar(8)       not null comment '监控id',
    from_monitor_node_id varchar(8)       not null comment 'from 监控id',
    to_monitor_node_id   varchar(8)       not null comment 'to 监控id',
    create_time          datetime         not null default CURRENT_TIMESTAMP comment '创建日期',
    update_time          datetime         not null default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '更新时间'
) comment '监控数据地图节点链路配置';
