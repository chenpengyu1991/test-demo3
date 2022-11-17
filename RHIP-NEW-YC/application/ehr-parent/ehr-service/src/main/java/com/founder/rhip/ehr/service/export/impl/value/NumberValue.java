package com.founder.rhip.ehr.service.export.impl.value;

import java.text.NumberFormat;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;
@Component
@Scope("prototype") 
public class NumberValue implements IValueGetter {
	private NumberFormat numberFormat;

	@Override
	public String get(ItemDefinition itemDefinition, Map<String, Object> data) {
		Object columnValue = data.get(itemDefinition.getCode());
		if (null == columnValue) {
			return "";
		}
		if (columnValue instanceof Number) {
			return numberFormat.format(columnValue);
		}
		return columnValue.toString();
	}

	public NumberFormat getNumberFormat() {
		return numberFormat;
	}

	public void setNumberFormat(NumberFormat numberFormat) {
		this.numberFormat = numberFormat;
	}

}
