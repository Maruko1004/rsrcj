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

 Date: 07/07/2021 10:39:34
*/

DROP TABLE IF EXISTS sql_info;
create table sql_info(
  id serial PRIMARY KEY not null,
  jdbc_id int not null,
	sql character varying(255) not null
);

comment on table sql_info is 'sql信息表';

comment on column sql_info.id is 'id';
comment on column sql_info.jdbc_id is '数据库id';
comment on column sql_info.sql is '执行SQL';
