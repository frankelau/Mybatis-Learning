  CREATE TABLE `User` (
  `user_id`  int(4) NOT NULL AUTO_INCREMENT COMMENT '用户ID' ,
  `user_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名' ,
  `user_birthday`  date NULL DEFAULT NULL COMMENT '生日' ,
  `user_salary`  double(8,2) NULL DEFAULT NULL COMMENT '月工资' ,
  PRIMARY KEY (`user_id`)
)
  ENGINE=InnoDB
  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
  COMMENT='用户表'
  AUTO_INCREMENT=1
  ROW_FORMAT=DYNAMIC
;

  CREATE TABLE `T_LOG4J` (
    `stamp`  TIMESTAMP NOT NULL  COMMENT '时间' ,
    `thread`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '线程号' ,
    `infolevel`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '日志级别' ,
    `class`  varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类名' ,
    `messages` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '日志内容'
  )
    ENGINE=InnoDB
    DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
    COMMENT='日志表'
  ;