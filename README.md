# Database

## 普通用户表

| 键名     | Java类型 | MySQL类型    | 是否允许为空 | 是否唯一 | 描述         |
| -------- | -------- | ------------ | ------------ | -------- | ------------ |
| id       | Long     | bigint       | no           | yes      | 自增主键     |
| openid   | String   | varchar(255) | no           | yes      | 微信返回的id |
| name     | String   | varchar(255) | no           | no       | 真实姓名     |
| group    | String   | varchar(255) | no           | no       | 班级         |
| schoolid | String   | varchar(255) | no           | yes      | 学号         |

```mysql
create table bobo.normaluser
(
    id       bigint auto_increment
        primary key,
    openid   varchar(255) null,
    name     varchar(255) not null,
    `group`  varchar(255) not null,
    schoolid varchar(255) not null,
    constraint openid
        unique (openid),
    constraint schoolid
        unique (schoolid)
)
    charset = utf8;
```



## 题库表

| 键名      | Java类型 | MySQL类型    | 是否允许为空 | 是否唯一 | 描述                   |
| --------- | -------- | ------------ | ------------ | -------- | ---------------------- |
| id        | Long     | bigint       | no           | yes      | 自增主键               |
| name      | String   | varchar(255) | no           | yes      | 题库名称               |
| choice    | int      | int          | no           | no       | 选择题数量             |
| blank     | int      | int          | no           | no       | 填空题数量             |
| judge     | int      | int          | no           | no       | 判断题数量             |
| startdate | Long     | bigint       | no           | no       | 开始日期时间           |
| enddate   | Long     | bigint       | no           | no       | 结束日期时间           |
| examtime  | Long     | bigint       | no           | no       | 单次答题时间           |
| times     | int      | int          | no           | no       | 允许答题次数           |
| answer    | byte     | tinyint      | no           | no       | 提交后是否允许查看答案 |

```mysql
create table bobo.questionwarehouse
(
    id        bigint auto_increment
        primary key,
    name      varchar(255) not null,
    choice    int          not null,
    blank     int          not null,
    judge     int          not null,
    startdate bigint       not null,
    enddate   bigint       not null,
    examtime  bigint       not null,
    times     int          not null,
    answer    tinyint      not null,
    constraint id
        unique (id),
    constraint name
        unique (name)
)
    charset = utf8;
```



## 选择题表

| 键名       | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------- | ------------ | -------- | ---------- |
| id         | Long     | bigint        | no           | yes      | 自增主键   |
| questionid | Long     | bigint        | no           | no       | 题库表外键 |
| question   | String   | varchar(3000) | no           | no       | 题目       |
| choice1    | String   | varchar(3000) | no           | no       | 选项1      |
| choice2    | String   | varchar(3000) | no           | no       | 选项2      |
| choice3    | String   | varchar(3000) | no           | no       | 选项3      |
| choice4    | String   | varchar(3000) | no           | no       | 选项4      |
| answer     | String   | varchar(3000) | no           | no       | 答案       |

```mysql
create table bobo.choicequestion
(
    id         bigint auto_increment
        primary key,
    questionid bigint        not null,
    choice1    varchar(3000) not null,
    choice2    varchar(3000) not null,
    choice3    varchar(3000) not null,
    choice4    varchar(3000) not null,
    answer     varchar(3000) not null,
    question   varchar(3000) not null,
    constraint choicequestion_ibfk_1
        foreign key (questionid) references bobo.questionwarehouse (id)
)
    charset = utf8;

create index questionid
    on bobo.choicequestion (questionid);
```



## 填空题表

| 键名       | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------- | ------------ | -------- | ---------- |
| id         | Long     | bigint        | no           | yes      | 自增主键   |
| questionid | Long     | bigint        | no           | no       | 题库表外键 |
| question   | String   | varchar(3000) | no           | no       | 题目       |
| answer     | String   | varchar(3000) | no           | no       | 答案       |

```mysql
create table bobo.blankquestion
(
    id         bigint auto_increment
        primary key,
    questionid bigint        not null,
    question   varchar(3000) not null,
    answer     varchar(3000) not null,
    constraint blankquestion_ibfk_1
        foreign key (questionid) references bobo.questionwarehouse (id)
)
    charset = utf8;

create index questionid
    on bobo.blankquestion (questionid);
```



## 判断题表

| 键名       | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------- | ------------ | -------- | ---------- |
| id         | Long     | bigint        | no           | yes      | 自增主键   |
| questionid | Long     | bigint        | no           | no       | 题库表外键 |
| question   | String   | varchar(3000) | no           | no       | 题目       |
| answer     | String   | varchar(3000) | no           | no       | 答案       |

```mysql
create table bobo.judgequestion
(
    id         bigint auto_increment
        primary key,
    questionid bigint        not null,
    question   varchar(3000) not null,
    answer     varchar(3000) not null,
    constraint judgequestion_ibfk_1
        foreign key (questionid) references bobo.questionwarehouse (id)
)
    charset = utf8;

create index questionid
    on bobo.judgequestion (questionid);
```



## 分配表

| 键名       | Java类型 | MySQL类型    | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------ | ------------ | -------- | ---------- |
| id         | Long     | bigint       | no           | yes      | 自增主键   |
| questionid | Long     | bigint       | no           | no       | 题库表外键 |
| group      | String   | varchar(255) | no           | no       | 班级       |

```mysql
create table allot (
    id bigint not null unique auto_increment primary key ,
    questionid bigint not null ,
    `group` varchar(255) not null ,
    foreign key (questionid) references bobo.questionwarehouse(id)
) character set utf8;
```

