package com.founder.rhip.ehr.service.star.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.StarType;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.star.ITwoStarDisplayFieldGetter;

/**
 * 从DTO里面取到显示字段
 * @author ggf
 *
 */
@Component
public class TwoStarDisplayFieldPersonBasicDTOvalueGetter implements ITwoStarDisplayFieldGetter<PersonalBasicInfoDTO> {

	private static Logger logger = Logger.getLogger(TwoStarDisplayFieldPersonBasicDTOvalueGetter.class);
	
	@Override
	public int execute(PersonalBasicInfoDTO personalBasicInfoDTO) {
		int i = 0;
		
		if(ObjectUtil.isNotEmpty(personalBasicInfoDTO)){
			List<Field> fields = StarUtil.getDisplayFields(PersonalBasicInfoDTO.class, StarType.TWO);
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					Object value = field.get(personalBasicInfoDTO);
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
		
		PersonInfo personInfo = personalBasicInfoDTO.getPersonInfo();
		if(ObjectUtil.isNotEmpty(personInfo)){
			List<Field> fields = StarUtil.getDisplayFields(PersonInfo.class, StarType.TWO);
			for (Field field : fields) {
				try {
					field.setAccessible(true);
					Object value = field.get(personInfo);
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
