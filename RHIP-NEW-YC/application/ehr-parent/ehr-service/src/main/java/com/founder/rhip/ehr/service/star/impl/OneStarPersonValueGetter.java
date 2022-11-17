package com.founder.rhip.ehr.service.star.impl;

import java.lang.reflect.Field;
import java.util.List;

import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.common.StarType;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.star.IOneStarValueGetter;

/**
 * 星级档案之一星档案计算(根据个人表)
 * @author donghong
 *
 */
@Component
public class OneStarPersonValueGetter implements IOneStarValueGetter<PersonalBasicInfoDTO> {
	private static Logger logger = Logger.getLogger(OneStarPersonValueGetter.class);
	@Override
	public int execute(PersonalBasicInfoDTO personalBasicInfoDTO) {
		PersonInfo personInfo = personalBasicInfoDTO.getPersonInfo();
		int i = 0;
		if (personInfo != null) {
			List<Field> fields = StarUtil.getFields(PersonInfo.class, StarType.ONE);
			for(Field field : fields)
			{
				try {
					field.setAccessible(true);
					Object value = field.get(personInfo);
					if (logger.isDebugEnabled()) {
						logger.debug(field.getName()+":"+value+"|"+StarUtil.valid(value));
					}
					if(StarUtil.valid(value)) {
						i++;
					}
					//当证件类型为非身份证时，即使身份证为空也不应该影响星级
					if( ObjectUtil.equals(field.getName(), "idcard") &&
							(ObjectUtil.isNullOrEmpty(personalBasicInfoDTO.getPersonInfo().getIdcard())) && (StringUtil.isNotEmpty(personalBasicInfoDTO.getPersonInfo().getBabyCardNo()) || StringUtil.isNotEmpty(personalBasicInfoDTO.getPersonInfo().getOtherIdcard()))){
						i++;
					}
					if( ObjectUtil.equals("pahouseNumber", field.getName()) &&
							ObjectUtil.isNullOrEmpty(personInfo.getPahouseNumber())
							&& ObjectUtil.isNotEmpty(personInfo.getPaGroup())) {
						i++;
					}
					if(ObjectUtil.equals("hrhouseNumber", field.getName()) &&
							ObjectUtil.isNullOrEmpty(personInfo.getHrhouseNumber()) && ObjectUtil.isNotEmpty(personInfo.getHrGroup())) {
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
