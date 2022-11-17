package com.founder.rhip.ehr.service.export.impl.value;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;

@Component
@Scope("prototype") 
public class DateValue implements IValueGetter {

	private SimpleDateFormat dateFormat;

	@Override
	public String get(ItemDefinition itemDefinition, Map<String, Object> data) {
		Object columnValue = data.get(itemDefinition.getCode());
		if (null == columnValue) {
			return "";
		}
		if (columnValue instanceof Date) {
			return dateFormat.format(columnValue);
		}
		return columnValue.toString();
	}

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

}
