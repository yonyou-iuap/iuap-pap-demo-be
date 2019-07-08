-- 此脚本作为平台预制数据参考使用。
-- 严禁将此脚本直接或修改后在数据库中执行,如由上述行为引发问题,概不支持。

-- 经典示例支持国际化 ----------------------------------------
-- 典型示例，支持国际化、扩展多语字段：刘文彬-2019-4-9
alter table IUAPD_TREELIST_DETAIL
  add NAME2 VARCHAR(64) default ' ',
  add NAME3 VARCHAR(64) default ' ',
  add NAME4 VARCHAR(64) default ' ',
  add NAME5 VARCHAR(64) default ' ',
  add NAME6 VARCHAR(64)  default ' ';

alter table IUAPD_TREELIST
  add  NAME2 VARCHAR(64) default ' ',
  add NAME3 VARCHAR(64) default ' ',
  add NAME4 VARCHAR(64) default ' ',
  add NAME5 VARCHAR(64) default ' ',
  add NAME6 VARCHAR(64)  default ' ';

alter table IUAPD_PURCHASE_ORDER
  add ORDER_NAME2 VARCHAR(64) default ' ',
  add ORDER_NAME3 VARCHAR(64) default ' ',
  add ORDER_NAME4 VARCHAR(64) default ' ',
  add ORDER_NAME5 VARCHAR(64) default ' ',
  add ORDER_NAME6 VARCHAR(64)  default ' ';

alter table IUAPD_PASSENGER
  add NAME2 VARCHAR(64) default ' ',
  add NAME3 VARCHAR(64) default ' ',
  add NAME4 VARCHAR(64) default ' ',
  add NAME5 VARCHAR(64) default ' ',
  add NAME6 VARCHAR(64)  default ' ';

alter table IUAPD_GRID_TEMP
  add MODEL_NAME2 VARCHAR(64) default ' ',
  add MODEL_NAME3 VARCHAR(64) default ' ',
  add MODEL_NAME4 VARCHAR(64) default ' ',
  add MODEL_NAME5 VARCHAR(64) default ' ',
  add MODEL_NAME6 VARCHAR(64)  default ' ';

alter table IUAPD_EMERGENCY_CONTACT
  add CONTACT_NAME2 VARCHAR(64) default ' ',
  add CONTACT_NAME3 VARCHAR(64) default ' ',
  add CONTACT_NAME4 VARCHAR(64) default ' ',
  add CONTACT_NAME5 VARCHAR(64) default ' ',
  add CONTACT_NAME6 VARCHAR(64)  default ' ';

alter table IUAPD_ALLOWANCES
  add NAME2 VARCHAR(64) default ' ',
  add NAME3 VARCHAR(64) default ' ',
  add NAME4 VARCHAR(64) default ' ',
  add NAME5 VARCHAR(64) default ' ',
  add NAME6 VARCHAR(64)  default ' ';

alter table IUAPD_RANKS
  add TYPE2 varchar(255) DEFAULT ' ',
  add TYPE3 varchar(255) DEFAULT ' ',
  add TYPE4 varchar(255) DEFAULT ' ',
  add TYPE5 varchar(255) DEFAULT ' ',
  add TYPE6 varchar(255) DEFAULT ' ',
  add POST_LEVEL2 varchar(255) DEFAULT ' ',
  add POST_LEVEL3 varchar(255) DEFAULT ' ',
  add POST_LEVEL4 varchar(255) DEFAULT ' ',
  add POST_LEVEL5 varchar(255) DEFAULT ' ',
  add POST_LEVEL6 varchar(255) DEFAULT ' ';

COMMIT ;