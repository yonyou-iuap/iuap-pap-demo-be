package com.yonyou.iuap.allowances.constant;

import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.pap.base.i18n.MessageSourceUtil;

import java.util.HashMap;
import java.util.Map;

public enum AllowanceTypeEnum implements I18nEnum {

	ComputerAssistance("1","电脑补助","ja.all.enum.0005"),
	AccommodationSubsidy("2","住宿补助","ja.all.enum.0006"),
	TransportationAssistance("3","交通补助","ja.all.enum.0007");
	
	private String key;
	
	private String value;
	
	private String i18nKey;
		
	private AllowanceTypeEnum(String key, String value, String i18nKey) {
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
		for(AllowanceTypeEnum item: AllowanceTypeEnum.values()){
			result.put( item.key, MessageSourceUtil.getMessage(item.i18nKey, item.value));
		}
        return result;
    }
}
