-- 创建数据库
DROP DATABASE IF EXISTS device;
CREATE DATABASE IF NOT EXISTS `device` CHARACTER SET 'utf8mb4';

-- 创建用户
DELETE FROM MYSQL.USER WHERE USER='device_admin';
CREATE USER 'device_admin'@'%' IDENTIFIED BY 'device_admin';

-- 对用户进行授权数据库
grant all privileges on device.* to 'device_admin'@'%' identified by 'device_admin';  

--刷新权限
flush privileges; 

use device;
