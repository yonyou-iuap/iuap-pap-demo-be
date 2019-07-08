package com.yonyou.iuap.enumeration.utils;

import cn.hutool.core.exceptions.UtilException;
import cn.hutool.core.util.ReflectUtil;
import com.yonyou.iuap.enumeration.entity.I18nEnum;
import com.yonyou.iuap.enumeration.entity.anno.EnumValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@SuppressWarnings("all")
public class EnumValueUtils {

	private static Logger logger = LoggerFactory.getLogger(EnumValueUtils.class);

	public static Map loadEnumInfo(Class<? extends I18nEnum> enumClass)
			throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Method method = enumClass.getMethod("values");
		I18nEnum[] enumInst = (I18nEnum[]) method.invoke(null, null);
		Map map = enumInst[0].getMappings();
		return map;
	}
	/*
	 * list<Entity>处理
	 */
	public static List i18nEnumEntityKeyToValue(List dataList, Class classObject) {
		Map<Class, Set<Field>> enumCache = new HashMap();
		if(!enumCache.containsKey(classObject)){
			enumCache.put(classObject, new HashSet<Field>());
		}
		try {
			Set<Field> fields = enumCache.get(classObject).size() == 0
					? new HashSet<>(Arrays.asList(classObject.getDeclaredFields())) : enumCache.get(classObject);
			for (Field field : fields) {
				EnumValue annotation = field.getDeclaredAnnotation(EnumValue.class);
				if (annotation != null) {
					enumCache.get(classObject).add(field);
					Class<? extends I18nEnum> enumClass = annotation.value();
					if (annotation.des() == null || annotation.des() == "") {
						continue;
					}
					for (Object entity : dataList) {
						Object fieldValue = ReflectUtil.getFieldValue(entity, field);
						if (fieldValue instanceof Boolean) {// 枚举有boolean时
							if (fieldValue.toString() == "true") {
								fieldValue = "1";
							} else {
								fieldValue = "0";
							}
						}
						String value = (String)loadEnumInfo(enumClass)
								.get(String.valueOf(fieldValue));
						ReflectUtil.setFieldValue(entity, annotation.des(), value);
					}
				}
			}
		} catch (NoSuchMethodException|InvocationTargetException|IllegalAccessException|UtilException e) {
			logger.error("Bad things!", e);
		}

		return dataList;
	}
	/*
	 * list<Map>处理
	 */
	public static List i18nEnumMapKeyToValue(List<Map> dataMapList, Class classObject) {
		Map<Class, Set<Field>> enumCache = new HashMap();
		if(!enumCache.containsKey(classObject)){
			enumCache.put(classObject, new HashSet<Field>());
		}
		Set<Field> fields = enumCache.get(classObject).size() == 0
				? new HashSet<>(Arrays.asList(classObject.getDeclaredFields())) : enumCache.get(classObject);
		try {
			for (Field field : fields) {
				EnumValue annotation = field.getDeclaredAnnotation(EnumValue.class);
				if (annotation != null) {
					enumCache.get(classObject).add(field);
					Class<? extends I18nEnum> enumClass = annotation.value();
					if (annotation.des() == null || annotation.des() == "") {
						continue;
					}
					for (Map<String, Object> item : dataMapList) {
						if (item.get(field.getName()) != null) {
							item.put(annotation.des(), (String)loadEnumInfo(enumClass)
									.get(String.valueOf(item.get(field.getName()))));
						}
					}
				}
			}
		} catch (NoSuchMethodException|InvocationTargetException|IllegalAccessException e) {
			logger.error("Bad things!", e);
		}

		return dataMapList;
	}
}
