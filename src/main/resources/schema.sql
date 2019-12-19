-- 権限マスタ
--* RestoreFromTempTable
create table role (
  id char(3) not null comment '権限ID'
  , role_name varchar(10) not null comment '権限名'
  , updated_at datetime default (current_timestamp) comment '更新日時'
  , created_at datetime default (current_timestamp) comment '登録日時'
  , version int default (1) comment '版'
  , constraint role_PKC primary key (id)
)
comment='権限マスタ';

-- ユーザーマスタ
--* RestoreFromTempTable
create table user (
  id int auto_increment not null comment 'ID'
  , email_address varchar(255) not null comment 'メールアドレス'
  , role_id char(3) not null comment '権限ID'
  , last_name varchar(255) not null comment '姓'
  , first_name varchar(255) not null comment '名'
  , ruby1 varchar(255) not null comment 'セイ'
  , ruby2 varchar(255) not null comment 'メイ'
  , date_of_birth date not null comment '生年月日'
  , password varchar(255) not null comment 'パスワード'
  , updated_at datetime  default (current_timestamp) comment '更新日時'
  , created_at datetime  default (current_timestamp) comment '登録日時'
  , version int default (1) comment '版'
  , constraint user_PKC primary key (id, email_address )
)
comment='ユーザーマスタ';

-- 一時ユーザートラン
--* RestoreFromTempTable
create table temp_user (
  uuid char(36) comment 'UUID'
  , email_address varchar(255) not null comment 'メールアドレス'
  , role_id char(3) not null comment '権限ID'
  , last_name varchar(255) not null comment '姓'
  , ruby1 varchar(255) not null comment 'セイ'
  , first_name varchar(255) not null comment '名'
  , ruby2 varchar(255) not null comment 'メイ'
  , date_of_birth date not null comment '生年月日'
  , password varchar(255) not null comment 'パスワード'
  , created_at datetime default (current_timestamp) comment '登録日時'
  , constraint user_PKC primary key (uuid, email_address )
)
comment='一時ユーザートラン';

create index role_id
  on user(role_id);