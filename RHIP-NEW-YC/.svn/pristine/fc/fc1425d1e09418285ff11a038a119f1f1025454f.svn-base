package com.founder.rhip.ehr.service.export.impl.value;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;
import com.founder.rhip.mdm.app.IDictionaryApp;

@Component
public class DicValue implements IValueGetter {

	@Autowired
	private IDictionaryApp dictionaryApp;

	private Map<String, String> cache = new ConcurrentHashMap<>();

	private String trimUni(String s) {
		int len = s.length();
		int st = 0;
		char[] val = s.toCharArray();

		while (st < len && (val[st] <= ' ' || val[st] == '　')) {
			st++;
		}
		while (st < len && (val[len - 1] <= ' ' || val[len - 1] == '　')) {
			len--;
		}

		if (st > 0 || len < s.length()) {
			return s.substring(st, len);
		}

		return s;
	}

	@Override
	public String get(ItemDefinition itemDefinition, Map<String, Object> data) {
		Object columnValue = data.get(itemDefinition.getCode());
		String dicType = itemDefinition.getDicType();
		Map<String, String> dicMap = itemDefinition.getDicMap();
		if (null == columnValue) {
			return "";
		}
		String source = columnValue.toString();
		if (source.trim().length() == 0) {
			return "";
		}

		String cacheKey = source + "@" + dicType;
		if (dicMap != null) {
			cacheKey = source + "@" + dicMap;
		}

		String re = cache.get(cacheKey);

		if (null != re) {
			return re;
		}

		if (itemDefinition.isMultiple()) {
			String[] sources = source.split(itemDefinition.getSeparator());
			if (sources.length == 1) {
				if (dicMap != null) {
					re = dicMap.get(sources[0]);
				} else {
					re = dictionaryApp.queryDicItemName(dicType, sources[0]);
				}
			} else {
				StringBuilder builder = new StringBuilder();
				for (int i = 0; i < sources.length; i++) {
					if (i != 0) {
						builder.append(",");
					}
					String value = null;
					if (dicMap != null) {
						value = dicMap.get(sources[i]);
					} else {
						value = dictionaryApp.queryDicItemName(dicType, sources[i]);
					}
					builder.append(value == null ? "" : trimUni(value));
				}
				re = builder.toString();
			}
		} else {
			if (dicMap != null) {
				re = dicMap.get(source);
			} else {
				re = dictionaryApp.queryDicItemName(dicType, source);
			}
		}

		if (null == re) {
			re = "";
		} else {
			re = trimUni(re);
		}
		cache.put(cacheKey, re);
		return re;
	}

}
