-- 创建数据库
DROP DATABASE IF EXISTS device;
CREATE DATABASE IF NOT EXISTS `device` CHARACTER SET 'utf8mb4';

-- 创建用户
CREATE USER 'deviceAdmin'@'%' IDENTIFIED BY 'deviceAdmin';

-- 对用户进行授权数据库
grant all privileges on device.* to 'deviceAdmin'@'%' identified by 'deviceAdmin' WITH GRANT OPTION;  

-- 刷新权限
flush privileges; 

use device;
