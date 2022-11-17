package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.service.star.ITwoStarValueGetter;

/**
 * 2星级档案之联系人电话
 * @author ggf
 *
 */
@Component
public class TwoStarGuidePhoneValueGetter implements ITwoStarValueGetter<PersonalBasicInfoDTO> {

	@Override
	public int execute(PersonalBasicInfoDTO personalBasicInfoDTO) {
		int value = 0;
		PersonInfo personInfo = personalBasicInfoDTO.getPersonInfo();
		if(ObjectUtil.isNotEmpty(personInfo) &&
				(ObjectUtil.isNotEmpty(personInfo.getGuardianPhoneOne()) ||
						ObjectUtil.isNotEmpty(personInfo.getGuardianPhoneTwo())) ){
			value = 1;
		}
		return value;
	}
}
