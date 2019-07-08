/*
Navicat SQL Server Data Transfer

Source Server         : 172.20.52.168
Source Server Version : 140000
Source Host           : 172.20.52.168:1433
Source Database       : walsin_demo1206
Source Schema         : walsindemo

Target Server Type    : SQL Server
Target Server Version : 140000
File Encoding         : 65001

Date: 2018-12-07 19:45:31
*/


-- ----------------------------
-- Table structure for IUAPD_ALLOWANCES
-- ----------------------------
DROP TABLE [IUAPD_ALLOWANCES]
GO
CREATE TABLE [IUAPD_ALLOWANCES] (
[ID] varchar(64) NOT NULL ,
[CODE] varchar(64) NULL ,
[NAME] varchar(64) NULL ,
[SEX] int NULL ,
[DEPT] varchar(64) NULL ,
[LEVEL] varchar(64) NULL ,
[SERVICE_YEARS] decimal(10) NULL ,
[SERVICE_YEARS_COMPANY] decimal(10) NULL ,
[YEAR] varchar(64) NULL ,
[MONTH] decimal(2) NULL ,
[ALLOWANCE_TYPE] decimal(10) NULL ,
[ALLOWANCE_STANDARD] decimal(10,2) NULL ,
[ALLOWANCE_ACTUAL] decimal(10,2) NULL ,
[EXDEEDS] int NULL ,
[APPLY_TIME] varchar(64) NULL ,
[PICK_TYPE] int NULL ,
[PICK_TIME] varchar(64) NULL ,
[REMARK] varchar(200) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_EMERGENCY_CONTACT
-- ----------------------------
DROP TABLE [IUAPD_EMERGENCY_CONTACT]
GO
CREATE TABLE [IUAPD_EMERGENCY_CONTACT] (
[ID] varchar(64) NOT NULL ,
[PASSENGER_ID] varchar(64) NULL ,
[CONTACT_NAME] varchar(32) NULL ,
[CONTACT_PHONE] varchar(32) NULL ,
[CONTACT_RELATION] varchar(64) NULL ,
[REMARK] varchar(255) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_ORDER_MODEL
-- ----------------------------
DROP TABLE [IUAPD_ORDER_MODEL]
GO
CREATE TABLE [IUAPD_ORDER_MODEL] (
[ID] varchar(255) NOT NULL ,
[CODE] varchar(64) NULL ,
[NAME] varchar(64) NULL ,
[REMARK] varchar(255) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_ORIGIN_MODEL
-- ----------------------------
DROP TABLE [IUAPD_ORIGIN_MODEL]
GO
CREATE TABLE [IUAPD_ORIGIN_MODEL] (
[ID] varchar(64) NOT NULL ,
[MODEL_CODE] varchar(255) NULL ,
[MODEL_NAME] varchar(255) NULL ,
[MODEL_TYPE] varchar(255) NULL ,
[MODEL_CONTENT] varchar(MAX) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_PASSENGER
-- ----------------------------
DROP TABLE [IUAPD_PASSENGER]
GO
CREATE TABLE [IUAPD_PASSENGER] (
[ID] varchar(64) NOT NULL ,
[CODE] varchar(64) NOT NULL ,
[NAME] varchar(64) NULL ,
[SEX] decimal(1) NULL ,
[DEPT] varchar(64) NULL ,
[PHONE] varchar(30) NULL ,
[IS_VIP] decimal(1) NULL ,
[GRADE] decimal(1) NULL ,
[EXPIRATION_DATE] varchar(255) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_POST_LEVEl
-- ----------------------------
DROP TABLE [IUAPD_POST_LEVEl]
GO
CREATE TABLE [IUAPD_POST_LEVEl] (
[ID] varchar(64) NOT NULL ,
[CODE] varchar(255) NULL ,
[TYPE] varchar(255) NULL ,
[GRADE] decimal(2) NULL ,
[LEVEL] varchar(255) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_PURCHASE_ORDER
-- ----------------------------
DROP TABLE [IUAPD_PURCHASE_ORDER]
GO
CREATE TABLE [IUAPD_PURCHASE_ORDER] (
[ID] varchar(64) NOT NULL ,
[ORDER_CODE] varchar(64) NULL ,
[ORDER_NAME] varchar(64) NULL ,
[ORDER_TYPE] int NULL ,
[ORDER_PRICE] decimal(10) NULL ,
[ORDER_USER] varchar(64) NULL ,
[ORDER_DEPT] varchar(64) NULL ,
[ORDER_DATE] varchar(64) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_PURCHASE_ORDER_DETAIL
-- ----------------------------
DROP TABLE [IUAPD_PURCHASE_ORDER_DETAIL]
GO
CREATE TABLE [IUAPD_PURCHASE_ORDER_DETAIL] (
[ID] varchar(64) NOT NULL ,
[ORDER_ID] varchar(64) NULL ,
[DETAIL_NAME] varchar(64) NULL ,
[DETAIL_MODEL] varchar(64) NULL ,
[DETAIL_COUNT] int NULL ,
[DETAIL_DATE] varchar(64) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_TABLE_DEMO
-- ----------------------------
DROP TABLE [IUAPD_TABLE_DEMO]
GO
CREATE TABLE [IUAPD_TABLE_DEMO] (
[ID] varchar(64) NOT NULL ,
[CODE] varchar(64) NULL ,
[NAME] varchar(64) NULL ,
[AGE] int NULL ,
[SEX] int NULL ,
[TREE_ID] varchar(64) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_TRAVELING_INFORMATION
-- ----------------------------
DROP TABLE [IUAPD_TRAVELING_INFORMATION]
GO
CREATE TABLE [IUAPD_TRAVELING_INFORMATION] (
[ID] varchar(64) NOT NULL ,
[PASSENGER_ID] varchar(64) NULL ,
[LINE] varchar(64) NULL ,
[STATION_BEGIN] varchar(64) NULL ,
[STATION_END] varchar(64) NULL ,
[COST] decimal(10,2) NULL ,
[PAY_STATUS] decimal(1) NULL ,
[REMARK] varchar(255) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[TRAVEL_TIME] varchar(64) NULL 
)


GO

-- ----------------------------
-- Table structure for IUAPD_TREE_DEMO
-- ----------------------------
DROP TABLE [IUAPD_TREE_DEMO]
GO
CREATE TABLE [IUAPD_TREE_DEMO] (
[ID] varchar(64) NOT NULL ,
[NAME] varchar(64) NULL ,
[IS_SON] decimal(1) NULL ,
[PARENTID] varchar(64) NULL ,
[CREATE_TIME] varchar(64) NULL ,
[CREATE_USER] varchar(64) NULL ,
[LAST_MODIFIED] varchar(64) NULL ,
[LAST_MODIFY_USER] varchar(64) NULL ,
[TS] varchar(64) NULL ,
[DR] decimal(11) NULL ,
[BPM_STATE] decimal(11) NULL ,
[TENANT_ID] varchar(64) NULL ,
[CODE] varchar(255) NULL 
)


GO

-- ----------------------------
-- Indexes structure for table IUAPD_TREE_DEMO
-- ----------------------------
CREATE INDEX [name] ON [IUAPD_TREE_DEMO]
([NAME] ASC) 
WITH (STATISTICS_NORECOMPUTE = ON)
GO
