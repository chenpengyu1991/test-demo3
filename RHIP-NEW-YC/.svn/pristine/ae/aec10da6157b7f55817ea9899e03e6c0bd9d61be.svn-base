package com.founder.rhip.ehr.service.export.impl.value;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;

@Component
public class SimpleValue implements IValueGetter {

	@Override
	public String get(ItemDefinition itemDefinition, Map<String, Object> data) {
		Object columnValue = data.get(itemDefinition.getCode());
		if (null == columnValue) {
			return "";
		}
		return columnValue.toString();
	}

}
