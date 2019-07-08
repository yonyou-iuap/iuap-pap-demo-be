-- 此脚本作为平台预制数据参考使用。
-- 严禁将此脚本直接或修改后在数据库中执行,如由上述行为引发问题,概不支持。

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for iuapd_allowances
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_allowances`;
CREATE TABLE `iuapd_allowances` (
  `ID` varchar(64) NOT NULL COMMENT '单据Id',
  `CODE` varchar(64) DEFAULT NULL COMMENT '员工编号',
  `NAME` varchar(64) DEFAULT NULL COMMENT '员工姓名',
  `NAME2` varchar(64) DEFAULT ' ',
  `NAME3` varchar(64) DEFAULT ' ',
  `NAME4` varchar(64) DEFAULT ' ',
  `NAME5` varchar(64) DEFAULT ' ',
  `NAME6` varchar(64) DEFAULT ' ',
  `SEX` int(1) DEFAULT NULL COMMENT '员工性别',
  `DEPT` varchar(64) DEFAULT NULL COMMENT '所属部门 -部门表Id',
  `POST_LEVEL` varchar(64) DEFAULT NULL COMMENT '职级',
  `SERVICE_YEARS` decimal(10,0) DEFAULT NULL COMMENT '工龄',
  `SERVICE_YEARS_COMPANY` decimal(10,0) DEFAULT NULL COMMENT '司龄',
  `YEAR` varchar(64) DEFAULT NULL COMMENT '年份',
  `MONTH` decimal(2,0) DEFAULT NULL COMMENT '月份',
  `ALLOWANCE_TYPE` decimal(10,0) DEFAULT NULL COMMENT '补贴类别',
  `ALLOWANCE_STANDARD` decimal(10,2) DEFAULT NULL COMMENT '补贴标准',
  `ALLOWANCE_ACTUAL` decimal(10,2) DEFAULT NULL COMMENT '实际补贴',
  `EXDEEDS` int(1) DEFAULT NULL COMMENT '是否超标  1.超标，0.未超标 --枚举',
  `APPLY_TIME` varchar(64) DEFAULT NULL COMMENT '申请时间',
  `PICK_TYPE` int(1) DEFAULT NULL COMMENT '领取方式  1.转账，2.现金 --枚举',
  `PICK_TIME` varchar(64) DEFAULT NULL COMMENT '领取时间',
  `REMARK` varchar(200) DEFAULT NULL,
  `CREATE_TIME` varchar(64) DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) DEFAULT NULL,
  `TS` varchar(64) DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iuapd_allowances
-- ----------------------------

-- ----------------------------
-- Table structure for iuapd_emergency_contact
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_emergency_contact`;
CREATE TABLE `iuapd_emergency_contact` (
  `ID` varchar(64) NOT NULL,
  `PASSENGER_ID` varchar(64) DEFAULT NULL COMMENT '员工编号',
  `CONTACT_NAME` varchar(32) DEFAULT NULL COMMENT '联系人姓名',
  `CONTACT_NAME2` varchar(32) DEFAULT ' ',
  `CONTACT_NAME3` varchar(32) DEFAULT ' ',
  `CONTACT_NAME4` varchar(32) DEFAULT ' ',
  `CONTACT_NAME5` varchar(32) DEFAULT ' ',
  `CONTACT_NAME6` varchar(32) DEFAULT ' ',
  `CONTACT_PHONE` varchar(32) DEFAULT NULL COMMENT '联系人电话',
  `CONTACT_RELATION` varchar(64) DEFAULT NULL COMMENT '与联系人关系 ',
  `REMARK` varchar(255) DEFAULT NULL,
  `CREATE_TIME` varchar(64) DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) DEFAULT NULL,
  `TS` varchar(64) DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iuapd_emergency_contact
-- ----------------------------

-- ----------------------------
-- Table structure for iuapd_grid_temp
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_grid_temp`;
CREATE TABLE `iuapd_grid_temp` (
  `ID` varchar(64) NOT NULL DEFAULT '' COMMENT '主键',
  `MODEL_CODE` varchar(255) DEFAULT NULL COMMENT '模型编码',
  `MODEL_NAME` varchar(255) DEFAULT NULL COMMENT '模型名称',
  `MODEL_NAME2` varchar(255) DEFAULT ' ',
  `MODEL_NAME3` varchar(255) DEFAULT ' ',
  `MODEL_NAME4` varchar(255) DEFAULT ' ',
  `MODEL_NAME5` varchar(255) DEFAULT ' ',
  `MODEL_NAME6` varchar(255) DEFAULT ' ',
  `MODEL_TYPE` varchar(255) DEFAULT NULL COMMENT '模型类型',
  `MODEL_CONTENT` longtext,
  `CREATE_TIME` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `CREATE_USER` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `TS` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of iuapd_grid_temp
-- ----------------------------

-- ----------------------------
-- Table structure for iuapd_passenger
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_passenger`;
CREATE TABLE `iuapd_passenger` (
  `ID` varchar(64) NOT NULL,
  `CODE` varchar(64) NOT NULL COMMENT '员工编号',
  `NAME` varchar(64) DEFAULT NULL COMMENT '员工姓名',
  `NAME2` varchar(64) DEFAULT ' ',
  `NAME3` varchar(64) DEFAULT ' ',
  `NAME4` varchar(64) DEFAULT ' ',
  `NAME5` varchar(64) DEFAULT ' ',
  `NAME6` varchar(64) DEFAULT ' ',
  `SEX` decimal(1,0) DEFAULT NULL COMMENT '员工性别 2.男，1.女',
  `DEPT` varchar(64) DEFAULT NULL COMMENT '所属部门',
  `PHONE` varchar(30) DEFAULT NULL COMMENT '手机号',
  `IS_VIP` decimal(1,0) DEFAULT NULL COMMENT '是否会员 2表示是，1表示否，默认1',
  `GRADE` decimal(1,0) DEFAULT NULL COMMENT '会员等级 默认0是非会员，会员1,2,3,4,5（从低到高）',
  `EXPIRATION_DATE` varchar(255) DEFAULT NULL COMMENT '会员到期日期',
  `CREATE_TIME` varchar(64) DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) DEFAULT NULL,
  `TS` varchar(64) DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iuapd_passenger
-- ----------------------------

-- ----------------------------
-- Table structure for iuapd_purchase_order
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_purchase_order`;
CREATE TABLE `iuapd_purchase_order` (
  `ID` varchar(64) NOT NULL COMMENT '请购单主键id',
  `ORDER_CODE` varchar(64) DEFAULT NULL COMMENT '请购单编号',
  `ORDER_NAME` varchar(64) DEFAULT NULL COMMENT '请购单名称',
  `ORDER_NAME2` varchar(64) DEFAULT ' ',
  `ORDER_NAME3` varchar(64) DEFAULT ' ',
  `ORDER_NAME4` varchar(64) DEFAULT ' ',
  `ORDER_NAME5` varchar(64) DEFAULT ' ',
  `ORDER_NAME6` varchar(64) DEFAULT ' ',
  `ORDER_TYPE` int(1) DEFAULT NULL COMMENT '请购单类型 1.普通采购，2委托代销，3直运采购',
  `ORDER_PRICE` decimal(10,0) DEFAULT NULL COMMENT '请购单价格',
  `ORDER_USER` varchar(64) DEFAULT NULL COMMENT '请购单申请人',
  `ORDER_DEPT` varchar(64) DEFAULT NULL COMMENT '请购单申请部门',
  `ORDER_DATE` varchar(64) DEFAULT NULL COMMENT '请购单申请日期',
  `CREATE_TIME` varchar(64) DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) DEFAULT NULL,
  `TS` varchar(64) DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iuapd_purchase_order
-- ----------------------------

-- ----------------------------
-- Table structure for iuapd_purchase_order_detail
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_purchase_order_detail`;
CREATE TABLE `iuapd_purchase_order_detail` (
  `ID` varchar(64) NOT NULL,
  `ORDER_ID` varchar(64) DEFAULT NULL COMMENT '请购单ID',
  `DETAIL_NAME` varchar(64) DEFAULT NULL COMMENT '物料名称',
  `DETAIL_MODEL` varchar(64) DEFAULT NULL COMMENT '物料型号 自定义参照',
  `DETAIL_COUNT` int(10) DEFAULT NULL COMMENT '物料数量',
  `DETAIL_DATE` varchar(64) DEFAULT NULL COMMENT '需求日期',
  `CREATE_TIME` varchar(64) DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) DEFAULT NULL,
  `TS` varchar(64) DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iuapd_purchase_order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for iuapd_ranks
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_ranks`;
CREATE TABLE `iuapd_ranks` (
  `ID` varchar(64) NOT NULL COMMENT '职级Id',
  `CODE` varchar(255) DEFAULT NULL COMMENT '职级编码',
  `TYPE` varchar(255) DEFAULT NULL COMMENT '职级类别 技术、管理',
  `TYPE2` varchar(255) DEFAULT NULL,
  `TYPE3` varchar(255) DEFAULT NULL,
  `TYPE4` varchar(255) DEFAULT NULL,
  `TYPE5` varchar(255) DEFAULT NULL,
  `TYPE6` varchar(255) DEFAULT NULL,
  `GRADE` decimal(2,0) DEFAULT NULL COMMENT '等级 1、2、3……',
  `POST_LEVEL` varchar(255) DEFAULT NULL COMMENT '级别 定性级别',
  `POST_LEVEL2` varchar(255) DEFAULT NULL,
  `POST_LEVEL3` varchar(255) DEFAULT NULL,
  `POST_LEVEL4` varchar(255) DEFAULT NULL,
  `POST_LEVEL5` varchar(255) DEFAULT NULL,
  `POST_LEVEL6` varchar(255) DEFAULT NULL,
  `CREATE_TIME` varchar(64) DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) DEFAULT NULL,
  `TS` varchar(64) DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iuapd_ranks
-- ----------------------------

-- ----------------------------
-- Table structure for iuapd_traveling_information
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_traveling_information`;
CREATE TABLE `iuapd_traveling_information` (
  `ID` varchar(64) NOT NULL,
  `PASSENGER_ID` varchar(64) DEFAULT NULL COMMENT '员工编号',
  `LINE` varchar(64) DEFAULT NULL COMMENT '乘车线路',
  `STATION_BEGIN` varchar(64) DEFAULT NULL COMMENT '上车站点',
  `STATION_END` varchar(64) DEFAULT NULL COMMENT '下车站点',
  `COST` decimal(10,2) DEFAULT NULL COMMENT '费用',
  `PAY_STATUS` decimal(1,0) DEFAULT NULL COMMENT '支付状态 2表支付过，1没有',
  `TRAVEL_TIME` varchar(64) DEFAULT NULL,
  `REMARK` varchar(255) DEFAULT NULL COMMENT '备注',
  `CREATE_TIME` varchar(64) DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) DEFAULT NULL,
  `TS` varchar(64) DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iuapd_traveling_information
-- ----------------------------

-- ----------------------------
-- Table structure for iuapd_treelist
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_treelist`;
CREATE TABLE `iuapd_treelist` (
  `ID` varchar(64) NOT NULL,
  `NAME` varchar(64) DEFAULT NULL,
  `NAME2` varchar(64) DEFAULT ' ',
  `NAME3` varchar(64) DEFAULT ' ',
  `NAME4` varchar(64) DEFAULT ' ',
  `NAME5` varchar(64) DEFAULT ' ',
  `NAME6` varchar(64) DEFAULT ' ',
  `CODE` varchar(64) DEFAULT NULL,
  `IS_SON` decimal(1,0) DEFAULT NULL COMMENT '是否有子节点 1.没有 2有',
  `PARENTID` varchar(64) DEFAULT '0',
  `CREATE_TIME` varchar(64) DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) DEFAULT NULL,
  `TS` varchar(64) DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `name` (`NAME`) USING HASH
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of iuapd_treelist
-- ----------------------------

-- ----------------------------
-- Table structure for iuapd_treelist_detail
-- ----------------------------
-- DROP TABLE IF EXISTS `iuapd_treelist_detail`;
CREATE TABLE `iuapd_treelist_detail` (
  `ID` varchar(64) NOT NULL,
  `CODE` varchar(64) DEFAULT NULL COMMENT '工号',
  `NAME` varchar(64) DEFAULT NULL COMMENT '姓名',
  `NAME2` varchar(64) DEFAULT ' ',
  `NAME3` varchar(64) DEFAULT ' ',
  `NAME4` varchar(64) DEFAULT ' ',
  `NAME5` varchar(64) DEFAULT ' ',
  `NAME6` varchar(64) DEFAULT ' ',
  `AGE` int(10) DEFAULT NULL COMMENT '年龄',
  `SEX` int(1) DEFAULT NULL COMMENT '性别 1女 2男',
  `TREE_ID` varchar(64) DEFAULT NULL COMMENT 'treeId',
  `CREATE_TIME` varchar(64) DEFAULT NULL,
  `CREATE_USER` varchar(64) DEFAULT NULL,
  `LAST_MODIFIED` varchar(64) DEFAULT NULL,
  `LAST_MODIFY_USER` varchar(64) DEFAULT NULL,
  `TS` varchar(64) DEFAULT NULL,
  `DR` decimal(11,0) DEFAULT NULL,
  `BPM_STATE` decimal(11,0) DEFAULT NULL,
  `TENANT_ID` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


COMMIT ;