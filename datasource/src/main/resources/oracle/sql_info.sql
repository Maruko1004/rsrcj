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

 Date: 09/07/2021 16:07:20
*/


-- ----------------------------
-- Table structure for SQL_INFO
-- ----------------------------
CREATE TABLE "SQL_INFO" (
  "ID" NUMBER NOT NULL ,
  "JDBC_ID" NUMBER NOT NULL ,
  "SQL" VARCHAR2(255 BYTE) NOT NULL 
);

COMMENT ON COLUMN "SQL_INFO"."ID" IS 'ID';
COMMENT ON COLUMN "SQL_INFO"."JDBC_ID" IS '数据库id';
COMMENT ON COLUMN "SQL_INFO"."SQL" IS '执行SQL';
COMMENT ON TABLE "SQL_INFO" IS 'sql信息表';

-- ----------------------------
-- Primary Key structure for table SQL_INFO
-- ----------------------------
ALTER TABLE "SQL_INFO" ADD CONSTRAINT "SYS_C0011911" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table SQL_INFO
-- ----------------------------
ALTER TABLE "SQL_INFO" ADD CONSTRAINT "SYS_C0011909" CHECK ("JDBC_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "SQL_INFO" ADD CONSTRAINT "SYS_C0011910" CHECK ("SQL" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

create  sequence SQL_SEQ increment by 1 start with 1 nomaxvalue nominvalue nocache;
