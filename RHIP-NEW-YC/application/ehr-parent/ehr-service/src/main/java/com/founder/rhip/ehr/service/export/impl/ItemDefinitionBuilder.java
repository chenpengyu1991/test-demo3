package com.founder.rhip.ehr.service.export.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.Item;
import com.founder.rhip.ehr.service.export.ItemDefinition;
import com.founder.rhip.ehr.service.export.impl.value.ValueGetterFactory;

/**
 * 导出单元格定义生成
 * 
 * @author liuk
 * 
 */
@Component
public class ItemDefinitionBuilder {

	@Autowired
	private ValueGetterFactory valueGetterFactory;

	private Map<String, List<ItemDefinition>> cache = new ConcurrentHashMap<>();

	public List<ItemDefinition> build(Class<?> cls) {
		return this.build(cls, null);
	}

	public List<ItemDefinition> build(Class<?> cls, Map<String, IValueGetter> customValue) {
		String key = buildCacheKey(cls);
		List<ItemDefinition> definitions = getFromCache(key);
		if (null != definitions) {
			return definitions;
		}
		// 暂不支持父类配置
		Field[] fields = cls.getDeclaredFields();
		definitions = new ArrayList<>(fields.length);
		for (Field field : fields) {
			if (field.isAnnotationPresent(Item.class)) {
				Item star = field.getAnnotation(Item.class);
				ItemDefinition itemDefinition = new ItemDefinition();
				definitions.add(itemDefinition);
				read(field, star, itemDefinition);
				if (null != customValue && customValue.containsKey(itemDefinition.getCode())) {
					itemDefinition.setValueGetter(customValue.get(itemDefinition.getCode()));
				} else {
					valueGetterFactory.build(itemDefinition);
				}
			}
		}
		Collections.sort(definitions, new IndexComparator());
		setToCache(key, definitions);
		return definitions;
	}

	private String buildCacheKey(Class<?> cls) {
		return cls.getName();
	}

	private List<ItemDefinition> getFromCache(String key) {
		List<ItemDefinition> definitions = cache.get(key);
		return definitions;
	}

	private void setToCache(String key, List<ItemDefinition> definitions) {
		cache.put(key, definitions);
	}

	private class IndexComparator implements Comparator<ItemDefinition> {
		@Override
		public int compare(ItemDefinition o1, ItemDefinition o2) {
			return o1.getIndex() - o2.getIndex();
		}
	}

	private void read(Field field, Item star, ItemDefinition itemDefinition) {
		itemDefinition.setColumn(star.column());
		itemDefinition.setCode(star.code());
		itemDefinition.setDic(star.isDic());
		itemDefinition.setDicType(star.dicType());
		itemDefinition.setMultiple(star.isMultiple());
		itemDefinition.setUser(star.isUser());
		itemDefinition.setOrganization(star.isOrganization());
		itemDefinition.setDate(star.isDate());
		itemDefinition.setNumber(star.isNumber());
		itemDefinition.setDatePattern(star.datePattern());
		itemDefinition.setNumberPattern(star.numberPattern());
		itemDefinition.setIndex(star.index());
		itemDefinition.setStaff(star.isStaff());
		itemDefinition.setDicMap(readDicMap(star.dicMap()));
		itemDefinition.setNullValue(star.nullValue());

		if (star.code().trim().length() == 0) {
			itemDefinition.setCode(javaField2DbField(field.getName()));
		} else {
			itemDefinition.setCode(star.code());
		}

	}
	
	private Map<String, String> readDicMap(String dicMap) {
		if (dicMap == null) {
			return null;
		}
		dicMap = dicMap.trim();
		if (dicMap.length() == 0) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		dicMap = dicMap.trim().replace("{", "").replace("}", "");
		String[] dicItems = dicMap.split(",");
		for (String dicItem : dicItems) {
			String[] item = dicItem.split(":");
			map.put(item[0], item[1]);
		}
		return map;
	}

	private String javaField2DbField(String fieldName) {
		StringBuffer name = new StringBuffer(fieldName);
		for (int i = 0; i < name.length(); i++) {
			char c1 = name.charAt(i);
			if (Character.isUpperCase(c1)) {
				name.insert(i, "_");
				i++;
			}
		}
		return name.toString().toUpperCase();
	}

}
