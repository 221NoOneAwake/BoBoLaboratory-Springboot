# Database

## 普通用户表

| 键名       | Java类型 | MySQL类型      | 是否允许为空 | 是否唯一 | 描述      |
|----------| -------- |--------------| ------------ | -------- |---------|
| id       | Long     | bigint       | no           | yes      | 自增主键    |
| openId   | String   | varchar(255) | no           | yes      | 微信返回的id |
| name     | String   | varchar(255) | yes          | no       | 真实姓名    |
| group    | String   | varchar(255) | yes          | no       | 班级      |
| schoolId | String   | varchar(255) | yes          | yes      | 学号      |
| sex      | String   | varchar(2)   | yes          | yes      | 性别      |

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

| 键名        | Java类型 | MySQL类型    | 是否允许为空 | 是否唯一 | 描述                   |
| ----------- | -------- | ------------ | ------------ | -------- | ---------------------- |
| id          | Long     | bigint       | no           | yes      | 自增主键               |
| name        | String   | varchar(255) | no           | yes      | 题库名称               |
| startDate   | Long     | bigint       | no           | no       | 开始日期时间           |
| endDate     | Long     | bigint       | no           | no       | 结束日期时间           |
| examTime    | Long     | bigint       | no           | no       | 单次答题时间           |
| submitTimes | Integer  | int          | no           | no       | 允许答题次数           |
| answer      | Boolean  | bit          | no           | no       | 提交后是否允许查看答案 |
| open        | Boolean  | bit          | no           | no       | 题集是否开放           |

```mysql
create table bobo.questionset
(
    id          bigint auto_increment comment '主键自增'
        primary key,
    name        varchar(255) not null comment '题目集名称',
    startDate   bigint       not null comment '开始日期 毫秒时间戳',
    endDate     bigint       not null comment '截止日期 毫秒时间戳',
    examTime    bigint       not null comment '考试时长 单位秒',
    submitTimes int          not null comment '允许考试次数',
    answer      bit          not null comment '所有次数结束后是否允许查看答案',
    `open`      bit          not null comment '是否开放',
    constraint name
        unique (name)
)
    charset = utf8;
```

## 选择题表(废弃)

| 键名       | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------- | ------------ | -------- | ---------- |
| id         | Long     | bigint        | no           | yes      | 自增主键   |
| questionId | Long     | bigint        | no           | no       | 题库表外键 |
| question   | String   | varchar(3000) | no           | no       | 题目       |
| choice1    | String   | varchar(3000) | no           | no       | 选项1      |
| choice2    | String   | varchar(3000) | no           | no       | 选项2      |
| choice3    | String   | varchar(3000) | no           | no       | 选项3      |
| choice4    | String   | varchar(3000) | no           | no       | 选项4      |
| answer     | String   | varchar(255)  | no           | no       | 答案       |
| score      | Integer  | int           | no           | no       | 分数       |

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
        answer     varchar(255)  not null,
        question   varchar(3000) not null,
        score      int           not null,
        constraint choicequestion_ibfk_1
            foreign key (questionId) references bobo.questionwarehouse (id)
    )
    charset = utf8;

create index questionId
    on bobo.choicequestion (questionId);
```

## 填空题表(废弃)

| 键名       | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------- | ------------ | -------- | ---------- |
| id         | Long     | bigint        | no           | yes      | 自增主键   |
| questionId | Long     | bigint        | no           | no       | 题库表外键 |
| question   | String   | varchar(3000) | no           | no       | 题目       |
| answer     | String   | varchar(3000) | no           | no       | 答案       |
| score      | Integer  | int           | no           | no       | 分数       |

```mysql
create table bobo.blankquestion
(
    id         bigint auto_increment
        primary key,
    questionId bigint        not null,
    question   varchar(3000) not null,
    answer     varchar(3000) not null,
    score      int           not null,
    constraint blankquestion_ibfk_1
        foreign key (questionid) references bobo.questionwarehouse (id)
)
    charset = utf8;

create index questionId
    on bobo.blankquestion (questionId);
```

## 判断题表(废弃)

| 键名       | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述       |
| ---------- | -------- | ------------- | ------------ | -------- | ---------- |
| id         | Long     | bigint        | no           | yes      | 自增主键   |
| questionId | Long     | bigint        | no           | no       | 题库表外键 |
| question   | String   | varchar(3000) | no           | no       | 题目       |
| answer     | byte     | tinyint       | no           | no       | 答案       |
| score      | Integer  | int           | no           | no       | 分数       |

```mysql
create table bobo.judgequestion
(
    id         bigint auto_increment
        primary key,
    questionId bigint        not null,
    question   varchar(3000) not null,
    answer     tinyint       not null,
    score      int           not null,
    constraint judgequestion_ibfk_1
        foreign key (questionId) references bobo.questionwarehouse (Id)
)
    charset = utf8;

create index questionId
    on bobo.judgequestion (questionId);
```

## 分配表(废弃)

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

| 键名          | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述                 |
| ------------- | -------- | ------------- | ------------ | -------- | -------------------- |
| id            | Long     | bigint        | no           | yes      | 自增主键             |
| questionSetId | Long     | bigint        | no           | no       | 题目集的id           |
| questionId    | Long     | bigint        | no           | no       | 题集id               |
| userId        | Long     | bigint        | no           | no       | 用户的id             |
| type          | String   | varchar(255)  | no           | no       | 题目类型 0判断 1选择 |
| date          | Long     | bigint        | no           | no       | 答题时间             |
| times         | Integer  | int           | no           | no       | 答题的次数           |
| answer        | String   | varchar(3000) | no           | no       | 答案                 |
| result        | Boolean  | bit           | no           | no       | 是否正确             |
| score         | int      | int           | no           | no       | 得分 * 10            |

```mysql
create table bobo.record
(
    id            bigint auto_increment
        primary key,
    questionSetId bigint        not null,
    questionId    bigint        not null,
    userId        bigint        not null,
    type          tinyint       not null,
    submitDate    bigint        not null,
    submitTimes   int           not null,
    answer        varchar(16)   not null,
    result        bit           not null,
    score         int           not null,
    constraint record_ibfk_1
        foreign key (questionSetId) references bobo.questionset (id),
    constraint record_ibfk_2
        foreign key (questionId) references bobo.question (id),
    constraint record_ibfk_3
        foreign key (userId) references bobo.normaluser (id)
)
    charset = utf8;

create index questionId
    on bobo.record (questionId);

create index questionSetId
    on bobo.record (questionSetId);

create index userId
    on bobo.record (userId);
```

## 后台用户表

| 键名      | Java类型 | MySQL类型   | 是否允许为空 | 是否唯一 | 描述     |
| --------- | -------- | ----------- | ------------ | -------- | -------- |
| id        | Long     | bigint      | no           | yes      | 自增主键 |
| username  | String   | varchar(32) | no           | yes      | 用户名   |
| password  | String   | varchar(64) | no           | no       | 密码     |
| nickname  | String   | varchar(8)  | no           | no       | 昵称     |
| authority | String   | varchar(16) | no           | no       | 账户权限 |

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

## 题目表

| 键名          | Java类型 | MySQL类型     | 是否允许为空 | 是否唯一 | 描述                     |
| ------------- | -------- | ------------- | ------------ | -------- | ------------------------ |
| id            | Long     | bigint        | no           | yes      | 自增主键                 |
| questionSetId | Long     | bigint        | no           | no       | 题目集主键               |
| title         | String   | varchar(3000) | no           | no       | 题目                     |
| type          | Short    | smallint      | no           | no       | 题目类型(0 判断 1 选择） |
| choice1       | String   | varchar(3000) | yes          | no       | 选项1                    |
| choice2       | String   | varchar(3000) | yes          | no       | 选项2                    |
| choice3       | String   | varchar(3000) | yes          | no       | 选项3                    |
| choice4       | String   | varchar(3000) | yes          | no       | 选项4                    |
| answer        | String   | varchar(255)  | no           | no       | 答案                     |
| score         | Integer  | int           | no           | no       | 分数                     |

```mysql
create table bobo.question
(
    id            bigint auto_increment comment '主键自增'
        primary key,
    questionSetId bigint        not null comment '题目集id',
    title         varchar(3000) not null comment '题目',
    type          smallint      not null comment '类型 0 判断 1 选择',
    choice1       varchar(3000) null comment '选项1',
    choice2       varchar(3000) null comment '选项2',
    choice3       varchar(3000) null comment '选项3',
    choice4       varchar(3000) null comment '选项4',
    answer        varchar(3000) not null comment '答案',
    score         int           not null comment '分值 1:10 50对应5分',
    constraint question_ibfk_1
        foreign key (questionSetId) references bobo.questionset (id)
)
    charset = utf8;
```



## 成绩表

| 键名          | Java类型 | MySQL类型 | 是否允许为空 | 是否唯一 | 描述                 |
| ------------- | -------- | --------- | ------------ | -------- | -------------------- |
| id            | Long     | bigint    | no           | yes      | 自增主键             |
| questionSetId | Long     | bigint    | no           | no       | 所答题集的id         |
| userId        | Long     | bigint    | no           | no       | 学生的id(非openid)   |
| maxScore      | Integer  | int       | no           | no       | 最高成绩             |
| totalScore    | Integer  | int       | no           | no       | 满分                 |
| submitDate    | Long     | bigint    | no           | no       | 答题日期(毫秒时间戳) |
| submitTimes   | Integer  | int       | no           | no       | 已答题次数           |

```mysql
create table bobo.result
(
    id            bigint auto_increment
        primary key,
    questionSetId bigint not null,
    userId        bigint not null,
    maxScore      int    not null,
    totalScore    int    not null,
    submitDate    bigint not null,
    submitTimes   int    null,
    constraint result_ibfk_1
        foreign key (questionSetId) references bobo.questionset (id),
    constraint result_ibfk_2
        foreign key (userId) references bobo.normaluser (id)
)
    charset = utf8;

create index questionSetId
    on bobo.result (questionSetId);

create index userId
    on bobo.result (userId);
```

