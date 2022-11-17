package com.founder.rhip.ehr.service.star.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.StarType;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 得到实体类中显示的字段
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldPersonExamValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO>{
	
	public static Logger logger = Logger.getLogger(ThreeStarDisplayFieldPersonExamValueGetter.class);

	@Override
	public int execute(PersonalPhyExamDTO personExamDto) {
		int i = 0;
		if(ObjectUtil.isNotEmpty(personExamDto)){
			List<Field> fields = StarUtil.getDisplayFields(PersonalPhyExamDTO.class, StarType.THREE);
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					Object value = field.get(personExamDto);
					if (logger.isDebugEnabled()) {
						logger.debug(field.getName()+":"+value+"|"+StarUtil.valid(value));
					}
					if(StarUtil.valid(value)){
						i++;
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		
		PhysiqueExamination phyExam = personExamDto.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam)){
			List<Field> fields = StarUtil.getDisplayFields(PhysiqueExamination.class, StarType.THREE);
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					Object value = field.get(phyExam);
					if (logger.isDebugEnabled()) {
						logger.debug(field.getName()+":"+value+"|"+StarUtil.valid(value));
					}
					if(StarUtil.valid(value)){
						i++;
					}
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return i;
	}
}
