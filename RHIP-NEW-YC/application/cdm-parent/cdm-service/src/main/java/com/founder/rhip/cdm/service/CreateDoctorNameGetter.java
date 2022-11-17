package com.founder.rhip.cdm.service;

import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;
import com.founder.rhip.ehr.service.export.impl.value.UserValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuk
 * @since 14-2-10 上午10:45
 */
@Component("cdmReportCardListCreateDoctorNameGetter")
public class CreateDoctorNameGetter implements IValueGetter {
    @Autowired
    private UserValue userValue;

	@Override
	public String get(ItemDefinition itemDefinition, Map<String, Object> data) {
		Object columnValue = data.get(itemDefinition.getCode());
		if (null == columnValue) {
			Object name = data.get("CREATE_DOCTOR_NAME");
			return name == null ? "" : name.toString();
		}
		return userValue.get(itemDefinition, data);
	}

}
