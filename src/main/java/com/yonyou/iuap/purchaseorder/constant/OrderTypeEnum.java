package com.yonyou.iuap.purchaseorder.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum OrderTypeEnum implements I18nEnum {

    GeneralPurchase("1", "普通采购", "ja.pur.enum.0001"),
    Consignment("2", "委托代销", "ja.pur.enum.0002"),
    DirectShipping("3", "直运采购", "ja.pur.enum.0003");

    private String key;

    private String value;

    private String i18nKey;

    private OrderTypeEnum(String key, String value, String i18nKey) {
        this.key = key;
        this.value = value;
        this.i18nKey = i18nKey;
    }

    @Override
    public Map getMappings() {
        Map<String, String> result = new HashMap<String, String>();
        for (OrderTypeEnum item : OrderTypeEnum.values()) {
            result.put(item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
        }
        return result;
    }
}
