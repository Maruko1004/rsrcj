/*
 Navicat Premium Data Transfer

 Source Server         : 119.23.108.215
 Source Server Type    : Oracle
 Source Server Version : 110200
 Source Host           : 119.23.108.215:1521
 Source Schema         : MARUKO

 Target Server Type    : Oracle
 Target Server Version : 110200
 File Encoding         : 65001

 Date: 09/07/2021 16:17:31
*/


-- ----------------------------
-- Table structure for PARAMS_INFO
-- ----------------------------
CREATE TABLE "PARAMS_INFO" (
  "ID" NUMBER NOT NULL ,
  "SQL_ID" NUMBER NOT NULL ,
  "NAME" VARCHAR2(255 BYTE) ,
  "VALUE" VARCHAR2(255 BYTE) NOT NULL ,
  "TYPE" VARCHAR2(255 BYTE) 
);
COMMENT ON COLUMN "PARAMS_INFO"."ID" IS 'id';
COMMENT ON COLUMN "PARAMS_INFO"."SQL_ID" IS 'sql_id';
COMMENT ON COLUMN "PARAMS_INFO"."NAME" IS '参数名称';
COMMENT ON COLUMN "PARAMS_INFO"."VALUE" IS '参数值';
COMMENT ON COLUMN "PARAMS_INFO"."TYPE" IS '参数类型';
COMMENT ON TABLE "PARAMS_INFO" IS 'sql参数信息表';

-- ----------------------------
-- Primary Key structure for table PARAMS_INFO
-- ----------------------------
ALTER TABLE "PARAMS_INFO" ADD CONSTRAINT "SYS_C0011989" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table PARAMS_INFO
-- ----------------------------
ALTER TABLE "PARAMS_INFO" ADD CONSTRAINT "SYS_C0011987" CHECK ("SQL_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PARAMS_INFO" ADD CONSTRAINT "SYS_C0011988" CHECK ("VALUE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Triggers structure for table PARAMS_INFO
-- ----------------------------
create  sequence PARAMS_SEQ increment by 1 start with 1 nomaxvalue nominvalue nocache;
