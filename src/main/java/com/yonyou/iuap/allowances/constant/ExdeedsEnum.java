package com.yonyou.iuap.allowances.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum ExdeedsEnum implements I18nEnum {
	
	NotExceeded("0","未超标","ja.all.enum.0003"),
	ExceededStandard("1","超标","ja.all.enum.0004");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
	
	private ExdeedsEnum(String key, String value, String i18nKey) {
		this.key = key;
		this.value = value;
		this.i18nKey = i18nKey;
	}

	/**
     * 多语翻译
     * @return
     */
	@Override
    public Map getMappings() {
    	Map<String, String> result = new HashMap<String, String>();
		for(ExdeedsEnum item: ExdeedsEnum.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
        return result;
    }
	
	
}
