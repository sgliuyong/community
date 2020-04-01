create table t_es_user
(
  ID           int auto_increment
    primary key,
  NAME         varchar(50) collate utf8_bin  null,
  ACCOUNT_ID   varchar(100) collate utf8_bin null,
  TOKEN        char(36)                      null,
  GMT_CREATE   bigint(11)                    null,
  GMT_MODIFIED bigint(11)                    null
);
