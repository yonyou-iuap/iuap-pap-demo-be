-- 此脚本作为平台预制数据参考使用。
-- 严禁将此脚本直接或修改后在数据库中执行,如由上述行为引发问题,概不支持。

-- 经典示例修改访问url ----------------------------------------
UPDATE IEOP_FUNCTION SET FUNC_URL= '/iuap-pap-demo-be/purchase_order,/iuap-pap-demo-be/purchase_order_detail', MENU_URL = '/iuap-pap-demo-fe/masterdetail-one#/' WHERE ID = '00e601475c6c471aa2cd2250bbcc7ff1';
UPDATE IEOP_FUNCTION SET FUNC_URL= '/iuap-pap-demo-be/passenger,/iuap-pap-demo-be/emergency_contact,/iuap-pap-demo-be/traveling_information', MENU_URL = '/iuap-pap-demo-fe/masterdetail-many#/' WHERE ID = '2928822db89c433184c04957b6f1fe6f';
UPDATE IEOP_FUNCTION SET FUNC_URL= '/iuap-pap-demo-be/tree_demo,/iuap-pap-demo-be/table_demo', MENU_URL = '/iuap-pap-demo-fe/tree#/' WHERE ID = '9b03021ef646490499af7bfd2e42a1bc';
UPDATE IEOP_FUNCTION SET FUNC_URL= '/iuap-pap-demo-be/query_allowances', MENU_URL = '/iuap-pap-demo-fe/singletable-query#/' WHERE ID = 'f3efaf3a6caa443baa52ba762345a56e';
UPDATE IEOP_FUNCTION SET FUNC_URL= '/iuap-pap-demo-be/popup_allowances', MENU_URL = '/iuap-pap-demo-fe/singletable-popup-edit#/' WHERE ID = '1e1573e4a3574e6bb5e8be60f164a6ee';
UPDATE IEOP_FUNCTION SET FUNC_URL= '/iuap-pap-demo-be/inline_allowances', MENU_URL = '/iuap-pap-demo-fe/singletable-inline-edit#/' WHERE ID = 'a68b611de88d40b7869fbdec63fa15e9';

UPDATE WB_APP_APPS SET URL = '/iuap-pap-demo-fe/masterdetail-one#/' WHERE ID = '00e601475c6c471aa2cd2250bbcc7ff1';
UPDATE WB_APP_APPS SET URL = '/iuap-pap-demo-fe/singletable-popup-edit#/' WHERE ID = '1e1573e4a3574e6bb5e8be60f164a6ee';
UPDATE WB_APP_APPS SET URL = '/iuap-pap-demo-fe/masterdetail-many#/'  WHERE ID = '2928822db89c433184c04957b6f1fe6f';
UPDATE WB_APP_APPS SET URL = '/iuap-pap-demo-fe/tree#/' WHERE ID = '9b03021ef646490499af7bfd2e42a1bc';
UPDATE WB_APP_APPS SET URL = '/iuap-pap-demo-fe/singletable-inline-edit#/' WHERE ID = 'a68b611de88d40b7869fbdec63fa15e9';
UPDATE WB_APP_APPS SET URL = '/iuap-pap-demo-fe/singletable-query#/' WHERE ID = 'f3efaf3a6caa443baa52ba762345a56e';

-- 去掉督办任务 ----------------------------------------
DELETE FROM WB_APP_GROUPS WHERE ID = 'c980b34f41d545f3992982442e74f7ed';
DELETE FROM WB_APP_APPS WHERE ID = '27228e888fc34440835fec75f8fe57b7';
DELETE FROM WB_LABEL_RELATION WHERE ID = 'ea85e2865aa94db29ba84de477230752';
DELETE FROM IEOP_FUNCTION WHERE ID = '27228e888fc34440835fec75f8fe57b7';
DELETE FROM WB_APP_MENU WHERE ID = '183f1f0071b0464e9190df1e5386e7e4';
DELETE FROM WB_APP_MENU WHERE ID = '8af3f8cc84774297b2b2d08b9425f851';
DELETE FROM IEOP_ROLE_PERMISSION WHERE ID = 'PERMI00000099';
DELETE FROM IEOP_FUNCTION_ACTIVITY WHERE ID = '7a29fa4f651f4850b29e2e337147280d';
DELETE FROM IEOP_FUNCTION_ACTIVITY WHERE ID = 'be3c3323e42d46e7a393c3b0613457b3';
DELETE FROM IEOP_FUNCTION_ACTIVITY WHERE ID = 'f7f0917ae6ef486fb6aad80e744517a3';
--
-- -- 测试数据的督办任务去掉 ----------------------------------
DELETE FROM IUAP_MSGTEMPLATE WHERE ID = 'b6340e7a-5397-4b03-9ed8-e70eba05e324';
DELETE FROM IUAP_MSGTEMPLATE_MANAGE WHERE ID = '12';
DELETE FROM PAP_BCR_CANDIDATEPROP WHERE PK = '1';
DELETE FROM PAP_BCR_CANDIDATEPROP WHERE PK = '2';
DELETE FROM PAP_BCR_OBJ WHERE PK_BILLOBJ = '00002';
DELETE FROM iuap_business_propertity WHERE ID = 'derwname';
DELETE FROM iuap_business_propertity WHERE ID = 'derwcode';
DELETE FROM IUAP_BUSINESS_ENTITY WHERE ID = '11';

update IUAPD_RANKS set TYPE2='technique',TYPE3='技術',POST_LEVEL2='primary',POST_LEVEL3='初級' where id='level1';
update IUAPD_RANKS set TYPE2='management',TYPE3='管理',POST_LEVEL2='primary',POST_LEVEL3='初級' where id='level2';
update IUAPD_RANKS set TYPE2='technique',TYPE3='技術',POST_LEVEL2='intermediate',POST_LEVEL3='中級' where id='level3';
update IUAPD_RANKS set TYPE2='management',TYPE3='管理',POST_LEVEL2='intermediate',POST_LEVEL3='中級'where id='level4';
update IUAPD_RANKS set TYPE2='technique',TYPE3='技術',POST_LEVEL2='senior',POST_LEVEL3='高級' where id='level5';
update IUAPD_RANKS set TYPE2='management',TYPE3='管理',POST_LEVEL2='senior',POST_LEVEL3='高級' where id='level6';

-- 更新按钮权限，将原来新增保存同一个接口拆分为两个不同的接口
update IEOP_ROLE_PERMISSION set PERMISSION_CODE='/PURCHASE_ORDER/updateAssoVo' where id='PERMI00000207';
update IEOP_FUNCTION_ACTIVITY set  ACTIVITY_URL='/purchase_order/updateAssoVo' where id='4b7bcf27758e4fd9808f30baca119985';
delete from IEOP_FUNCTION_ACTIVITY where ACTIVITY_URL='/purchase_order/updateAssoVo';
COMMIT ;