package com.founder.rhip.ehr.service.export.impl.value;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.service.basic.IEhrSecurityService;
import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;

@Component("excelExportUserValue")
public class UserValue implements IValueGetter {

	@Autowired
	private IEhrSecurityService ehrSecurityService;

	private Map<Long, String> cache = new ConcurrentHashMap<>();

	@Override
	public String get(ItemDefinition itemDefinition, Map<String, Object> data) {
		Object columnValue = data.get(itemDefinition.getCode());
		if (null == columnValue) {
			return "";
		}
		Long userId = null;
		try {
			userId = Long.parseLong(columnValue.toString());
		} catch (Exception e) {
			//
		}

		// TODO 缓存问题
		if (null != userId) {
			String result = cache.get(userId);
			if (null == result) {
				User user = ehrSecurityService.getUser(userId);
				if (null != user) {
					result = user.getName();
				}

				if (null == result) {
					result = "";
				}
				cache.put(userId, result);
			}
			return result;
		}
		return columnValue.toString();
	}

	public IEhrSecurityService getEhrSecurityService() {
		return ehrSecurityService;
	}

	public void setEhrSecurityService(IEhrSecurityService ehrSecurityService) {
		this.ehrSecurityService = ehrSecurityService;
	}

}
