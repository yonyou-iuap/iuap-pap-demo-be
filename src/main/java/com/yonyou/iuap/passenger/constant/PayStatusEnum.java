package com.yonyou.iuap.passenger.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum PayStatusEnum implements I18nEnum {

    NotPaid("1", "未支付", "ja.pas.enum.0006"),
    Paid("2", "已支付", "ja.pas.enum.0007");

    private String key;

    private String value;

    private String i18nKey;

    private PayStatusEnum(String key, String value, String i18nKey) {
        this.key = key;
        this.value = value;
        this.i18nKey = i18nKey;
    }

    @Override
    public Map getMappings() {
        Map<String, String> result = new HashMap<String, String>();
        for (PayStatusEnum item : PayStatusEnum.values()) {
            result.put(item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
        }
        return result;
    }

}
