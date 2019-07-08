package com.yonyou.iuap.allowances.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum PickTypeEnum implements I18nEnum {

	Transfer("1","转账","ja.all.enum.0020"),
	Cash("2","现金","ja.all.enum.0021");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private PickTypeEnum(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}
	
	@Override
    public Map getMappings() {
    	Map<String, String> result = new HashMap<String, String>();
		for(PickTypeEnum item: PickTypeEnum.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
        return result;
    }
}
