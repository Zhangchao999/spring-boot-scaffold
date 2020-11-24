CREATE TABLE t_fsb (
  id bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  name varchar(200) DEFAULT NULL COMMENT '姓名',
  status varchar(6) NOT NULL COMMENT '状态',
  gmt_create datetime NOT NULL COMMENT '创建时间',
  gmt_modified datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY (id) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 设置组件初始值
alter table t_fsb AUTO_INCREMENT = 100000;