package com.yonyou.iuap.passenger.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum GradeEnum implements I18nEnum {
    Junior("1", "初级会员", "ja.pas.enum.0001"),
    Intermediate("2", "中级会员", "ja.pas.enum.0002"),
    Premium("3", "高级会员", "ja.pas.enum.0003");

    private String key;

    private String value;

    private String i18nKey;

    private GradeEnum(String key, String value, String i18nKey) {
        this.key = key;
        this.value = value;
        this.i18nKey = i18nKey;
    }

    @Override
    public Map getMappings() {
        Map<String, String> result = new HashMap<String, String>();
        for (GradeEnum item : GradeEnum.values()) {
            result.put(item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
        }
        return result;
    }
}
