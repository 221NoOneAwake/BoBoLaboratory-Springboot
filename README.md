# Database

## 普通用户表

| 键名       | Java类型 | MySQL类型      | 是否允许为空 | 是否唯一 | 描述          |
|----------| -------- |--------------| ------------ | -------- |-------------|
| id       | Long     | bigint       | no           | yes      | 自增主键        |
| openId   | String   | varchar(255) | no           | yes      | 微信返回的id     |
| name     | String   | varchar(255) | yes          | no       | 真实姓名        |
| group    | String   | varchar(255) | yes          | no       | 班级          |
| schoolId | String   | varchar(255) | yes          | yes      | 学号          |
| sex      | String   | varchar(2)   | yes          | yes      | 学号          |

```mysql
create table bobo.normaluser
(
    id       bigint auto_increment
        primary key,
    openId   varchar(255) not null,
    name     varchar(255) null,
    `group`  varchar(255) null,
    schoolId varchar(255) null,
    sex      varchar(2)   null,
    constraint openId
        unique (openId),
    constraint schoolId
        unique (schoolId)
)
    charset = utf8;
```

## 题库表

| 键名        | Java类型 | MySQL类型    | 是否允许为空 | 是否唯一 | 描述          |
|-----------| -------- | ------------ | ------------ | -------- |-------------|
| id        | Long     | bigint       | no           | yes      | 自增主键        |
| name      | String   | varchar(255) | no           | yes      | 题库名称        |
| choice    | int      | int          | no           | no       | 选择题数量       |
| blank     | int      | int          | no           | no       | 填空题数量       |
| judge     | int      | int          | no           | no       | 判断题数量       |
| startDate | Long     | bigint       | no           | no       | 开始日期时间      |
| endDate   | Long     | bigint       | no           | no       | 结束日期时间      |
| examTime  | Long     | bigint       | no           | no       | 单次答题时间      |
| times     | int      | int          | no           | no       | 允许答题次数      |
| answer    | byte     | tinyint      | no           | no       | 提交后是否允许查看答案 |
| open      | byte     | tinyint      | no           | no       | 题集是否开放      |

```mysql
create table bobo.questionwarehouse
(
    id        bigint auto_increment
        primary key,
    name      varchar(255) not null,
    choice    int          null,
    blank     int          null,
    judge     int          null,
    startDate bigint       not null,
    endDate   bigint       not null,
    examTime  bigint       not null,
    times     int          not null,
    answer    tinyint      not null,
    open      tinyint      not null,
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
| questionId | Long     | bigint        | no           | no       | 题库表外键 |
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
        questionId bigint        not null,
        choice1    varchar(3000) not null,
        choice2    varchar(3000) not null,
        choice3    varchar(3000) not null,
        choice4    varchar(3000) not null,
        answer     varchar(3000) not null,
        question   varchar(3000) not null,
        constraint choicequestion_ibfk_1
            foreign key (questionId) references bobo.questionwarehouse (id)
    )
    charset = utf8;

create index questionId
    on bobo.choicequestion (questionId);
```

## 填空题表

| 键名       | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------- | ------------ | -------- | ---------- |
| id         | Long     | bigint        | no           | yes      | 自增主键   |
| questionId | Long     | bigint        | no           | no       | 题库表外键 |
| question   | String   | varchar(3000) | no           | no       | 题目       |
| answer     | String   | varchar(3000) | no           | no       | 答案       |

```mysql
create table bobo.blankquestion
(
    id         bigint auto_increment
        primary key,
    questionId bigint        not null,
    question   varchar(3000) not null,
    answer     varchar(3000) not null,
    constraint blankquestion_ibfk_1
        foreign key (questionid) references bobo.questionwarehouse (id)
)
    charset = utf8;

create index questionId
    on bobo.blankquestion (questionId);
```

## 判断题表

| 键名       | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------- | ------------ | -------- | ---------- |
| id         | Long     | bigint        | no           | yes      | 自增主键   |
| questionId | Long     | bigint        | no           | no       | 题库表外键 |
| question   | String   | varchar(3000) | no           | no       | 题目       |
| answer     | String   | varchar(3000) | no           | no       | 答案       |

```mysql
create table bobo.judgequestion
(
    id         bigint auto_increment
        primary key,
    questionId bigint        not null,
    question   varchar(3000) not null,
    answer     varchar(3000) not null,
    constraint judgequestion_ibfk_1
        foreign key (questionId) references bobo.questionwarehouse (Id)
)
    charset = utf8;

create index questionId
    on bobo.judgequestion (questionId);
```

## 分配表

| 键名       | Java类型 | MySQL类型    | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------ | ------------ | -------- | ---------- |
| id         | Long     | bigint       | no           | yes      | 自增主键   |
| questionId | Long     | bigint       | no           | no       | 题库表外键 |
| group      | String   | varchar(255) | no           | no       | 班级       |

```mysql
create table bobo.allot
(
    id         bigint auto_increment
        primary key,
    questionId bigint       not null,
    `group`    varchar(255) not null,
    constraint id
        unique (id),
    constraint allot_ibfk_1
        foreign key (questionId) references bobo.questionwarehouse (id)
)
    charset = utf8;

create index questionId
    on bobo.allot (questionId);
```

## 答题记录表

| 键名       | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------- | ------------ | -------- | ---------- |
| id         | Long     | bigint        | no           | yes      | 自增主键   |
| questionId | Long     | bigint        | no           | no       | 题目的id   |
| studentId  | Long     | bigint        | no           | no       | 学生的id   |
| type       | String   | varchar(255)  | no           | no       | 题目类型   |
| date       | Long     | bigint        | no           | no       | 答题时间   |
| times      | int      | int           | no           | no       | 答题的次数 |
| answer     | String   | varchar(3000) | no           | no       | 答案       |
| result     | byte     | tinyint       | no           | no       | 是否正确   |
| score      | int      | int           | yes          | no       | 得分 * 10  |

```mysql
create table bobo.record
(
    id         bigint auto_increment
        primary key,
    questionId bigint        not null,
    studentId  bigint        not null,
    type       varchar(255)  not null,
    `date`     bigint        not null,
    times      int           not null,
    answer     varchar(3000) not null,
    result     tinyint       not null,
    score      int           null
)
    charset = utf8;
```

## 后台用户表

| 键名      | Java类型 | MySQL类型 | 是否允许为空 | 是否唯一 | 描述     |
| --------- | -------- | --------- | ------------ | -------- | -------- |
| id        | Long     | bigint    | no           | yes      | 自增主键 |
| username  | String   | varchar() | no           | yes      | 用户名   |
| password  | String   | varchar() | no           | no       | 密码     |
| nickname  | String   | varchar() | no           | no       | 昵称     |
| authority | String   | varchar() | no           | no       | 账户权限 |

```mysql
create table bobo.backstageuser
(
    id        bigint auto_increment
        primary key,
    username  varchar(32) not null,
    password  varchar(64) not null,
    nickname  varchar(8)  not null,
    authority varchar(16) not null,
    constraint username
        unique (username)
)
    charset = utf8;
```

