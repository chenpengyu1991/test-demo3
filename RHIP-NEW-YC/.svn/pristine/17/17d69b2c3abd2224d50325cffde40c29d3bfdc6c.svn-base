package com.founder.rhip.ehr.service.export.impl.value;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.service.export.IValueGetter;
import com.founder.rhip.ehr.service.export.ItemDefinition;
import com.founder.rhip.mdm.app.IStaffApp;
import com.founder.rhip.mdm.entity.Staff;

@Component
public class StaffValue implements IValueGetter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private  Map<String, String> cache = new ConcurrentHashMap<>();
	
	@Autowired
	private IStaffApp staffApp;

	@Override
	public String get(ItemDefinition itemDefinition, Map<String, Object> data) {
		Object columnValue = data.get(itemDefinition.getCode());
		if (null == columnValue) {
			return "";
		}

		if (ObjectUtil.isNotEmpty(columnValue)) {
			String name=cache.get(columnValue);
			if(null!=name){
				return name;
			}
			List<Staff> list;
			try {
				list = staffApp.queryStaff(new Criteria("smpiId", columnValue));
				if (ObjectUtil.isNotEmpty(list)) {
					name= list.get(0).getName();
				}
			} catch (Exception e) {
				logger.error("获取医务人员姓名失败", e);
			}
			if(null==name){
				name="";
			}
			cache.put(columnValue.toString(), name);
			return name;
		}
		return columnValue.toString();
	}

}
