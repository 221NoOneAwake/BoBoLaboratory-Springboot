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

