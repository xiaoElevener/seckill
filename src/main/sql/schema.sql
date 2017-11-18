CREATE TABLE seckill(
  seckill_id BIGINT  NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
  name VARCHAR(255) NOT NULL COMMENT '商品名称',
  number int NOT NULL COMMENT '库存数量',
  start_time TIMESTAMP  NOT NULL COMMENT '秒杀开始时间',
  end_time TIMESTAMP  NOT NULL COMMENT '秒杀结束时间按',
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP  COMMENT '创建时间',
  PRIMARY KEY (seckill_id),
  key idx_start_time(start_time),
  key idx_end_time(end_time),
  key idx_create_time(create_time)
)ENGINE=Innodb,AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8 COMMENT='秒杀库存表';


insert into
  seckill(name,number,start_time,end_time)
VALUES
  ('1000元秒杀iponeX',100,'2017-11-01 00:00:00','2017-11-02 00:00:00'),
  ('1200元秒杀小米6',200,'2017-11-01 00:00:00','2017-11-02 00:00:00'),
  ('200元秒杀ipad2',300,'2017-11-01 00:00:00','2017-11-02 00:00:00'),
  ('300元秒杀红米note',400,'2017-11-01 00:00:00','2017-11-02 00:00:00');


-- 秒杀陈公告明细表
-- 用户登录认证相关信息
CREATE  TABLE success_killed(
  seckill_id BIGINT NOT NULL COMMENT '秒杀商品id',
  user_phone BIGINT NOT NULL COMMENT '用户手机号',
  state tinyint NOT NULL DEFAULT -1 COMMENT '状态表示 -1：无效  0：成功  1:已付款 2：已发货',
  create_time TIMESTAMP NOT NULL COMMENT '创建时间',
  PRIMARY KEY (seckill_id,user_phone),/*联合主键*/
  key idx_crate_time(create_time)
)ENGINE=Innodb DEFAULT CHARSET=utf8 COMMENT='秒杀库存表'