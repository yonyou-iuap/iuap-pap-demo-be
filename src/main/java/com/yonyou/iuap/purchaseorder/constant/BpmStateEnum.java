package com.yonyou.iuap.purchaseorder.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum BpmStateEnum implements I18nEnum {

    Initial("0", "待确认", "ja.pur.enum.0004"),
    Executing("1", "执行中", "ja.pur.enum.0005"),
    Finished("2", "已办结", "ja.pur.enum.0006"),
    Temited("3", "终止", "ja.pur.enum.0007");


    private String key;

    private String value;

    private String i18nKey;

    private BpmStateEnum(String key, String value, String i18nKey) {
        this.key = key;
        this.value = value;
        this.i18nKey = i18nKey;
    }

    @Override
    public Map getMappings() {
        Map<String, String> result = new HashMap<String, String>();
        for (BpmStateEnum item : BpmStateEnum.values()) {
            result.put(item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
        }
        return result;
    }
}
