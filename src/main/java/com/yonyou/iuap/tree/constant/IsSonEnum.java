package com.yonyou.iuap.tree.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum IsSonEnum implements I18nEnum {

    Vanish("1", "没有", "ja.tree.enum.0001"),
    Exist("2", "中级会员", "ja.tree.enum.0002");

    private String key;

    private String value;

    private String i18nKey;

    private IsSonEnum(String key, String value, String i18nKey) {
        this.key = key;
        this.value = value;
        this.i18nKey = i18nKey;
    }

    @Override
    public Map getMappings() {
        Map<String, String> result = new HashMap<String, String>();
        for (IsSonEnum item : IsSonEnum.values()) {
            result.put(item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
        }
        return result;
    }
}
