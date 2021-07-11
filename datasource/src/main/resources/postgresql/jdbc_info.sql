/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : localhost:3307
 Source Schema         : maruko

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 07/07/2021 10:39:15
*/


-- ----------------------------
-- Table structure for jdbc_info
-- ----------------------------
DROP TABLE IF EXISTS jdbc_info;
create table jdbc_info(

  id serial PRIMARY KEY not null,
  drive_class character varying(255) not null,
	url character varying(255) not null,
	user_name character varying(255) not null,
	password character varying(255) not null
);

comment on table jdbc_info is '数据库信息表';

comment on column jdbc_info.id is 'id';
comment on column jdbc_info.drive_class is '驱动类型';
comment on column jdbc_info.url is '连接路径';
comment on column jdbc_info.user_name is '用户名';
comment on column jdbc_info.password is '密码';