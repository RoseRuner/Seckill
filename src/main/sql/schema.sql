CREATE DATABASE seckill;

use seckill;

CREATE TABLE seckill(
'seckill_id' bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
'name' varchar(120) NOT NULL COMMENT '商品名称',
'number' int NOT NULL COMMENT '库存数量',
'start_time' timestamp NOT NULL COMMENT '秒杀开启时间',
'end_time' timestamp NOT NULL COMMENT '秒杀结束时间',
'create_time' timestamp NOT NULL COMMENT DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)

)ENGINE=InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf8 COMMENT='秒杀库存表'

-- 初始化数据

insert into
	seckill(name,number,start_time,end_time)
value
	('6666元秒杀iPhoneXS',50,'2019-4-14 00:00:00','2019-4-15 00:00:00'),
	('2000元秒杀ipad mini 2019',200,'2019-4-14 00:00:00','2019-4-15 00:00:00'),
	('3000元秒杀ipad2018',300,'2019-4-14 00:00:00','2019-4-15 00:00:00'),
	('5000元秒杀三星S10+',100,'2019-4-14 00:00:00','2019-4-15 00:00:00');
	
-- 秒杀成功明细表
-- 用户登录认证相关信息
	
create table success_killed (
'seckill_id' bigint NOT NULL COMMENT '秒杀商品id',
'user_phone' bigint NOT NULL COMMENT '用户手机号',
'state' tinyint NOT NULL DEFAULT -1 COMMENT '状态标识：-1:无效，0:成功，1:已付款，2:已发货',
'create_time' timestamp NOT NULL COMMENT '创建时间',
PRIMARY KEY(seckill_id,user_phone),
key idx_create_time(create_time)
)ENGINE=InnoDB DEFAULT CHARSET = utf8 COMMENT='秒杀成功明细表';
