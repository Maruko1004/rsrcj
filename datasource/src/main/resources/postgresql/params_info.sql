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

 Date: 07/07/2021 10:39:24
*/

DROP TABLE IF EXISTS params_info;
create table params_info(

  id serial PRIMARY KEY not null,
  sql_id int not null,
	name character varying(255) ,
	value character varying(255) not null,
	type character varying(255)
);

comment on table params_info is 'sql参数信息表';

comment on column params_info.id is 'id';
comment on column params_info.sql_id is 'sql_id';
comment on column params_info.name is '参数名称';
comment on column params_info.value is '参数值';
comment on column params_info.type is '参数类型';
