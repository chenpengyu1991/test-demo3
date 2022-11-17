package com.founder.rhip.ehr.service.star.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.common.StarType;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarValueGetter;

/**
 * 星级档案之3星档案计算
 * 
 * @author liuk
 */
@Component
public class ThreeStarValueGetter implements IThreeStarValueGetter<PersonalPhyExamDTO> {
	private static Logger logger = Logger.getLogger(ThreeStarValueGetter.class);
	@Override
	public int execute(PersonalPhyExamDTO personalPhyExamDTO) {
		PhysiqueExamination pe = personalPhyExamDTO.getPhysiqueExamination();
		List<Field> peFields = StarUtil.getFields(pe.getClass(), StarType.THREE);
		int value = 0;
		try {
			for (Field field : peFields) {
				field.setAccessible(true);
				Object fieldValue = field.get(pe);
				value += StarUtil.valid(fieldValue) ? 1 : 0;
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return value;
	}

}
