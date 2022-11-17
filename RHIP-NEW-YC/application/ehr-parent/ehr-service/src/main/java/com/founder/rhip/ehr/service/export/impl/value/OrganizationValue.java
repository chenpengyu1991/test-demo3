package com.founder.rhip.ehr.service.export.impl.value;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;
import com.founder.rhip.mdm.app.IOrganizationApp;

@Component
public class OrganizationValue implements IValueGetter {

	@Autowired
	private IOrganizationApp organizationApp;

	@Override
	public String get(ItemDefinition itemDefinition, Map<String, Object> data) {
		Object columnValue = data.get(itemDefinition.getCode());
		if (null == columnValue) {
			return "";
		}
		return organizationApp.queryOrganName(columnValue.toString());
	}

	public IOrganizationApp getOrganizationApp() {
		return organizationApp;
	}

	public void setOrganizationApp(IOrganizationApp organizationApp) {
		this.organizationApp = organizationApp;
	}

}
