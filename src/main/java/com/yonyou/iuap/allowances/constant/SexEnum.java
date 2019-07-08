package com.yonyou.iuap.allowances.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum SexEnum implements I18nEnum {
	Female("0","女","ja.all.enum.0001"),
	Male("1","男","ja.all.enum.0002");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private SexEnum(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	@Override
    public Map getMappings() {
    	Map<String, String> result = new HashMap<String, String>();
		for(SexEnum item: SexEnum.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
        return result;
    }
}
