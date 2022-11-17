package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 健康指导
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldHealthValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO target) {
		int i = 0;
		PhysiqueExamination phyExam = target.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getGuideRegularFollowup()) || 
				ObjectUtil.isNotEmpty(phyExam.getGuideSuggestionReview()) || 
				ObjectUtil.isNotEmpty(phyExam.getGuideSuggestionReferral()) ||
				ObjectUtil.isNotEmpty(phyExam.getGuideIntoChronicDisease())) {
			i = 1;
		}
		return i;
	}

}
