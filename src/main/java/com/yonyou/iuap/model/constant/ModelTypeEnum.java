package com.yonyou.iuap.model.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum ModelTypeEnum implements I18nEnum {

    Test1("1", "测试1", "ja.model.enum.0001"),
    Test2("2", "测试2", "ja.model.enum.0002");

    private String key;

    private String value;

    private String i18nKey;

    private ModelTypeEnum(String key, String value, String i18nKey) {
        this.key = key;
        this.value = value;
        this.i18nKey = i18nKey;
    }

    @Override
    public Map getMappings() {
        Map<String, String> result = new HashMap<String, String>();
        for (ModelTypeEnum item : ModelTypeEnum.values()) {
            result.put(item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
        }
        return result;
    }
}
