SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS device.tb_role_auth;
DROP TABLE IF EXISTS device.tb_authinfo;
DROP TABLE IF EXISTS device.tb_cache_sequence;
DROP TABLE IF EXISTS device.tb_sale_device;
DROP TABLE IF EXISTS device.tb_user_role;
DROP TABLE IF EXISTS device.tb_user;
DROP TABLE IF EXISTS device.tb_department;
DROP TABLE IF EXISTS device.tb_device;
DROP TABLE IF EXISTS device.tb_station;
DROP TABLE IF EXISTS device.tb_region;
DROP TABLE IF EXISTS device.tb_role;




/* Create Tables */

-- 权限表
CREATE TABLE device.tb_authinfo
(
	auth_id int unsigned NOT NULL AUTO_INCREMENT COMMENT '权限ID',
	auth_code varchar(32) COMMENT '权限编码',
	auth_name varchar(32) COMMENT '权限名称',
	auth_url varchar(128) COMMENT '权限地址',
	-- 1，页面
	-- 2，按钮
	-- 3，接口
	auth_type tinyint COMMENT '权限类型 : 1，页面
2，按钮
3，接口',
	icon varchar(32) COMMENT '权限图标',
	PRIMARY KEY (auth_id)
) ENGINE = InnoDB COMMENT = '权限表';


-- 缓存序列号
CREATE TABLE device.tb_cache_sequence
(
	sequence_id int NOT NULL AUTO_INCREMENT COMMENT '序列ID',
	sequence_entity varchar(32) NOT NULL COMMENT '实体名称',
	sequence_key varchar(32) NOT NULL COMMENT '序列号Key',
	sequence_value int unsigned DEFAULT 1 NOT NULL COMMENT '序列号增长值',
	PRIMARY KEY (sequence_id)
) ENGINE = InnoDB COMMENT = '缓存序列号';


-- 部门表
CREATE TABLE device.tb_department
(
	department_id int NOT NULL AUTO_INCREMENT COMMENT '部门ID',
	department_name varchar(32) NOT NULL COMMENT '部门名称',
	create_time datetime NOT NULL COMMENT '创建时间',
	create_user int NOT NULL COMMENT '创建人',
	update_time datetime COMMENT '修改时间',
	update_user int COMMENT '修改人',
	-- 0，未删除
	-- 1，已删除
	is_delete tinyint(1) DEFAULT 0 NOT NULL COMMENT '是否已删除 : 0，未删除
1，已删除',
	PRIMARY KEY (department_id)
) ENGINE = InnoDB COMMENT = '部门表';


-- 设备表
CREATE TABLE device.tb_device
(
	device_id int NOT NULL AUTO_INCREMENT COMMENT '设备ID',
	device_name varchar(32) NOT NULL COMMENT '设备名称',
	device_code varchar(32) NOT NULL COMMENT '设备编号',
	device_model varchar(32) DEFAULT '' NOT NULL COMMENT '设备型号',
	create_user int NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user int NOT NULL COMMENT '更新人',
	update_time datetime NOT NULL COMMENT '更新时间',
	is_delete tinyint(1) DEFAULT 0 NOT NULL COMMENT '是否已删除',
	PRIMARY KEY (device_id),
	UNIQUE (device_code)
) ENGINE = InnoDB COMMENT = '设备表';


-- 地区表
CREATE TABLE device.tb_region
(
	region_id int NOT NULL AUTO_INCREMENT COMMENT '地区ID',
	region_name varchar(32) NOT NULL COMMENT '名称',
	parent_region_id int DEFAULT 0 NOT NULL COMMENT '上级地区ID',
	-- 1表示省，
	-- 2表示市，
	-- 3表示县
	region_level tinyint NOT NULL COMMENT '地区级别 : 1表示省，
2表示市，
3表示县',
	region_code varchar(10) NOT NULL COMMENT '地区编码',
	PRIMARY KEY (region_id)
) ENGINE = InnoDB COMMENT = '地区表';


-- 角色表
CREATE TABLE device.tb_role
(
	role_id int NOT NULL AUTO_INCREMENT COMMENT '角色ID',
	role_name varchar(32) DEFAULT '' NOT NULL COMMENT '角色名称 ',
	create_time datetime NOT NULL COMMENT '创建时间',
	create_user int NOT NULL COMMENT '创建人',
	update_time datetime COMMENT '修改时间',
	update_user int COMMENT '修改人',
	-- 0，未删除
	-- 1，已删除
	-- 
	is_delete tinyint(1) DEFAULT 0 NOT NULL COMMENT '是否已删除 : 0，未删除
1，已删除
',
	PRIMARY KEY (role_id)
) ENGINE = InnoDB COMMENT = '角色表';


-- 角色权限
CREATE TABLE device.tb_role_auth
(
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	auth_id int unsigned NOT NULL COMMENT '权限ID',
	role_id int NOT NULL COMMENT '角色ID',
	PRIMARY KEY (id)
) ENGINE = InnoDB COMMENT = '角色权限';


-- 设备销售表
CREATE TABLE device.tb_sale_device
(
	record_id int NOT NULL AUTO_INCREMENT COMMENT '记录ID',
	station_id int NOT NULL COMMENT '网点ID',
	device_id int NOT NULL COMMENT '设备ID',
	sale_user int NOT NULL COMMENT '销售人员',
	sale_time datetime COMMENT '销售时间',
	sale_number int DEFAULT 1 NOT NULL COMMENT '销售个数',
	remark varchar(512) COMMENT '备注',
	create_user int NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user int NOT NULL COMMENT '更新人',
	update_time datetime NOT NULL COMMENT '更新时间',
	is_delete tinyint(1) DEFAULT 0 NOT NULL COMMENT '是否已删除',
	PRIMARY KEY (record_id)
) ENGINE = InnoDB COMMENT = '设备销售表';


-- 服务网点表
CREATE TABLE device.tb_station
(
	station_id int NOT NULL AUTO_INCREMENT COMMENT '网点ID',
	station_name varchar(32) NOT NULL COMMENT '网点名称',
	province_id int NOT NULL COMMENT '省ID',
	city_id int NOT NULL COMMENT '市ID',
	county_id int NOT NULL COMMENT '县区ID',
	address varchar(128) NOT NULL COMMENT '详细地址',
	longitude decimal(10,8) NOT NULL COMMENT '经度',
	latitude decimal(10,8) NOT NULL COMMENT '维度',
	create_user int NOT NULL COMMENT '创建人',
	create_time datetime NOT NULL COMMENT '创建时间',
	update_user int NOT NULL COMMENT '更新人',
	update_time datetime NOT NULL COMMENT '更新时间',
	is_delete tinyint(1) DEFAULT 0 NOT NULL COMMENT '是否已删除',
	PRIMARY KEY (station_id)
) ENGINE = InnoDB COMMENT = '服务网点表';


-- 人员表
CREATE TABLE device.tb_user
(
	user_id int NOT NULL AUTO_INCREMENT COMMENT '人员ID',
	department_id int NOT NULL COMMENT '部门ID',
	account varchar(16) NOT NULL COMMENT '登录账号',
	password varchar(64) NOT NULL COMMENT '密码',
	user_name varchar(62) NOT NULL COMMENT '用户名',
	real_name varchar(32) NOT NULL COMMENT '真实名称',
	-- 0，未提供
	-- 1，男
	-- 2，女
	sex tinyint COMMENT '性别 : 0，未提供
1，男
2，女',
	birthday datetime COMMENT '生日',
	nation varchar(32) COMMENT '民族',
	id_card varchar(32) COMMENT '身份证号',
	id_card_front varchar(128) COMMENT '身份证正面照',
	id_card_back varchar(128) COMMENT '身份证反面照',
	address varchar(128) COMMENT '籍贯',
	create_time datetime COMMENT '创建时间',
	create_user int NOT NULL COMMENT '创建人',
	update_time datetime COMMENT '更新时间',
	update_user int COMMENT '更新人',
	-- 0，未删除
	-- 1，已删除
	is_delete tinyint(1) COMMENT '是否已删除 : 0，未删除
1，已删除',
	PRIMARY KEY (user_id)
) ENGINE = InnoDB COMMENT = '人员表';


-- 人员角色表
CREATE TABLE device.tb_user_role
(
	id int NOT NULL AUTO_INCREMENT COMMENT 'id',
	role_id int NOT NULL COMMENT '角色ID',
	user_id int NOT NULL COMMENT '人员ID',
	PRIMARY KEY (id)
) ENGINE = InnoDB COMMENT = '人员角色表';



