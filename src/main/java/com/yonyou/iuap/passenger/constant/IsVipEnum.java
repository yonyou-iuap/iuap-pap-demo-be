package com.yonyou.iuap.passenger.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum IsVipEnum implements I18nEnum {

    No("0", "否", "ja.pas.enum.0004"),
    Yes("1", "是", "ja.pas.enum.0005");

    private String key;

    private String value;

    private String i18nKey;

    private IsVipEnum(String key, String value, String i18nKey) {
        this.key = key;
        this.value = value;
        this.i18nKey = i18nKey;
    }

    @Override
    public Map getMappings() {
        Map<String, String> result = new HashMap<String, String>();
        for (IsVipEnum item : IsVipEnum.values()) {
            result.put(item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
        }
        return result;
    }
}
