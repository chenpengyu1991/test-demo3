package com.founder.rhip.ehr.service.export.impl.value;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;

/**
 * 值获取器
 * 
 * @author liuk
 * 
 */
@Component
public class ValueGetterFactory implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	private SimpleValue simpleValue;

	@Autowired
	private DicValue dicValue;

	@Autowired
	private OrganizationValue organizationValue;

	@Autowired
	private StaffValue staffValue;

	@Autowired
	private UserValue userValue;

	public IValueGetter build(ItemDefinition itemDefinition) {
		IValueGetter valueGetter = null;
		if (itemDefinition.isDic()) {
			valueGetter = dicValue;
		} else if (itemDefinition.isDate()) {
			DateValue dateValue = applicationContext.getBean(DateValue.class);
			dateValue.setDateFormat(new SimpleDateFormat(itemDefinition.getDatePattern()));
			valueGetter = dateValue;
		} else if (itemDefinition.isNumber()) {
			NumberValue numberValue = applicationContext.getBean(NumberValue.class);
			numberValue.setNumberFormat(new DecimalFormat(itemDefinition.getNumberPattern()));
			valueGetter = numberValue;
		} else if (itemDefinition.isOrganization()) {
			valueGetter = organizationValue;
		} else if (itemDefinition.isUser()) {
			valueGetter = userValue;
		} else if (itemDefinition.isStaff()) {
			valueGetter = staffValue;
		} else {
			valueGetter = simpleValue;
		}
		Assert.notNull(valueGetter);
		itemDefinition.setValueGetter(valueGetter);
		return valueGetter;
	}

	@Override
	public void setApplicationContext(ApplicationContext paramApplicationContext) throws BeansException {
		applicationContext = paramApplicationContext;
	}
}
