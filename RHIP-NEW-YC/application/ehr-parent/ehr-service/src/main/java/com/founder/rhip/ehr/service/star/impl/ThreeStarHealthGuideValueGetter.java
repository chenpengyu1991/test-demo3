package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarValueGetter;

/**
 * 3星级  -- 健康指导
 *@author ggf
 */
@Component
public class ThreeStarHealthGuideValueGetter implements IThreeStarValueGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO personalPhyExamDTO) {
		int value = 0;
		PhysiqueExamination phyExam = personalPhyExamDTO.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getGuideRegularFollowup()) || 
				ObjectUtil.isNotEmpty(phyExam.getGuideSuggestionReview()) || 
				ObjectUtil.isNotEmpty(phyExam.getGuideSuggestionReferral()) ||
				ObjectUtil.isNotEmpty(phyExam.getGuideIntoChronicDisease())) {
			value = 1;
		}
		return value;
	}
}
