package com.yonyou.iuap.enumeration.entity.anno;

import com.yonyou.iuap.enumeration.entity.I18nEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnumValue {
	
	//枚举类
	Class<? extends I18nEnum> value() default I18nEnum.class;
	
	//枚举显示字段
    String des() default "";
}
