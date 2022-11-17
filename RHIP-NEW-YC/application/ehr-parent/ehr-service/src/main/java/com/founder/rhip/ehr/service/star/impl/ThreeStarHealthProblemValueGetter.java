package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.service.star.IThreeStarValueGetter;

/**
 * 3星级  --健康评价
 *@author ggf
 */
@Component
public class ThreeStarHealthProblemValueGetter implements IThreeStarValueGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO personalPhyExamDTO) {
		return 1;
	}
}