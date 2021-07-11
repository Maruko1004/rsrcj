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

 Date: 09/07/2021 16:04:45
*/


-- ----------------------------
-- Table structure for JDBC_INFO
-- ----------------------------
CREATE TABLE "JDBC_INFO" (
  "ID" NUMBER NOT NULL ,
  "DRIVE_CLASS" VARCHAR2(255 BYTE) NOT NULL ,
  "URL" VARCHAR2(255 BYTE) NOT NULL ,
  "USER_NAME" VARCHAR2(255 BYTE) NOT NULL ,
  "PASSWORD" VARCHAR2(255 BYTE) NOT NULL 
);
COMMENT ON COLUMN "JDBC_INFO"."ID" IS 'id';
COMMENT ON COLUMN "JDBC_INFO"."DRIVE_CLASS" IS '驱动类型';
COMMENT ON COLUMN "JDBC_INFO"."URL" IS '连接路径';
COMMENT ON COLUMN "JDBC_INFO"."USER_NAME" IS '用户名';
COMMENT ON COLUMN "JDBC_INFO"."PASSWORD" IS '密码';
COMMENT ON TABLE "JDBC_INFO" IS '数据库信息表';

-- ----------------------------
-- Primary Key structure for table JDBC_INFO
-- ----------------------------
ALTER TABLE "JDBC_INFO" ADD CONSTRAINT "SYS_C0011847" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table JDBC_INFO
-- ----------------------------
ALTER TABLE "JDBC_INFO" ADD CONSTRAINT "SYS_C0011842" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "JDBC_INFO" ADD CONSTRAINT "SYS_C0011843" CHECK ("DRIVE_CLASS" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "JDBC_INFO" ADD CONSTRAINT "SYS_C0011844" CHECK ("URL" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "JDBC_INFO" ADD CONSTRAINT "SYS_C0011845" CHECK ("USER_NAME" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "JDBC_INFO" ADD CONSTRAINT "SYS_C0011846" CHECK ("PASSWORD" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;


-- ----------------------------
-- Triggers structure for table JDBC_INFO
-- ----------------------------
create  sequence JDBC_SEQ increment by 1 start with 1 nomaxvalue nominvalue nocache;

