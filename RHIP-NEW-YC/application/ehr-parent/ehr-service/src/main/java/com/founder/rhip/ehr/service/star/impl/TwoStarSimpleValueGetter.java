package com.founder.rhip.ehr.service.star.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.common.StarType;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.star.ITwoStarValueGetter;

@Component
public class TwoStarSimpleValueGetter implements ITwoStarValueGetter<PersonalBasicInfoDTO> {
	private static Logger logger = Logger.getLogger(TwoStarSimpleValueGetter.class);
	@Override
	public int execute(PersonalBasicInfoDTO target) {
		PersonInfo pe = target.getPersonInfo();
		List<Field> peFields = StarUtil.getFields(pe.getClass(), StarType.TWO);
		int value = 0;
		try {
			for (Field field : peFields) {
				field.setAccessible(true);
				Object fieldValue = field.get(pe);
				if (logger.isDebugEnabled()) {
					logger.debug(field.getName()+":"+fieldValue);
				}
				value += StarUtil.valid(fieldValue) ? 1 : 0;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return value;
	}
}
