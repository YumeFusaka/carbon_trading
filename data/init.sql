use carbon_trading;

create table admin
(
    id          bigint auto_increment comment '主键'
        primary key,
    account     varchar(30) null comment '账号',
    password    varchar(30) null comment '密码',
    name        varchar(30) null comment '管理名',
    create_time datetime    null comment '创建时间'
);

create table agency
(
    id          bigint auto_increment comment '主键'
        primary key,
    account     varchar(30) null comment '账号',
    password    varchar(30) null comment '密码',
    name        varchar(30) null comment '机构名',
    create_time datetime    null comment '创建时间'
);


create table electric_grid
(
    id                        bigint auto_increment comment '主键'
        primary key,
    account                   varchar(30)      not null comment '账号',
    create_date               datetime         not null comment '创建日期',
    status                    varchar(10)      not null comment '状态',
    consumption               double default 0 not null comment '消耗的碳',
    PPGCP                     double default 0 not null comment '电厂上网电量',
    IIE                       double default 0 not null comment '自外省输入电量',
    IEE                       double default 0 not null comment '向外省输出电量',
    electricity_sales         double default 0 not null comment '售电量',
    transmission_distribution double default 0 not null comment '输配电量',
    retirement_capacity       double default 0 not null comment '退休设备总容量',
    retirement_recovery       double default 0 not null comment '退休设备总回收量',
    fix_capacity              double default 0 not null comment '修理设备总容量',
    fix_recovery              double default 0 not null comment '修理设备总回收量',
    name                      varchar(30)      null comment '名称',
    map_id                    varchar(40)      null comment '映射在fisco的id'
);

create table enterprise
(
    id           bigint auto_increment comment '主键'
        primary key,
    name         varchar(255)            not null comment '企业名称',
    type         varchar(20)             not null comment '企业类型',
    account      varchar(30)             not null comment '账号',
    password     varchar(30)             not null comment '密码',
    carbon_coin  double default 10000000 not null comment '碳币',
    trade_count  int    default 0        not null comment '交易数量',
    submit_count int    default 0        not null comment '提交数量',
    create_time  datetime                null comment '创建时间'
);


create table generate_electricity
(
    id                  bigint auto_increment comment '主键'
        primary key,
    account             varchar(30)      not null comment '账号',
    create_date         datetime         not null comment '创建日期',
    status              varchar(10)      not null comment '状态',
    consumption         double default 0 not null comment '消耗的碳',
    coal_burning        double default 0 not null comment '燃煤消耗量',
    crude_oil           double default 0 not null comment '原油消耗量',
    fuel_oil            double default 0 not null comment '燃料油消耗量',
    gasoline            double default 0 not null comment '汽油消耗量',
    refinery_gas        double default 0 not null comment '炼厂干气消耗量',
    other_products      double default 0 not null comment '其他制品消耗量',
    natural_gas         double default 0 not null comment '天然气消耗量',
    coke_oven_gas       double default 0 not null comment '焦炉煤气消耗量',
    other_gas           double default 0 not null comment '其他煤气消耗量',
    desulfurizing_agent double default 0 not null comment '脱硫剂消耗量',
    electricity         double default 0 not null comment '电力购入量',
    name                varchar(30)      null comment '名称',
    map_id              varchar(40)      null comment '映射在fisco的id'
);

create table trade
(
    id                bigint auto_increment comment '主键'
        primary key,
    initiator_account varchar(30)   not null comment '发起者账号',
    receiver_account  varchar(30)   not null comment '接收者账号',
    content           varchar(4000) not null comment '交易内容',
    pay_coin          double        not null comment '交易碳币',
    status            varchar(30)   not null comment '交易状态',
    create_date       datetime      not null comment '发起时间',
    initiator_name    varchar(30)   null comment '发起者名称',
    receiver_name     varchar(30)   null comment '接收者名称',
    map_id            varchar(40)   null comment '映射在fisco的id'
);

insert into admin (account, password, name)
values ('admin', 'admin', 'admin');
