package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 老年人
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldElderValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO target) {
		int i = 0;
		PhysiqueExamination phyExam = target.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getHealthSelfAssessment())) {
			i++;
		}
		if(ObjectUtil.isNotEmpty(phyExam.getLifeAbilitySelfAssessment())) {
			i++;
		}
		if(ObjectUtil.isNotEmpty(phyExam.getCognitionScreenResult()) && ObjectUtil.isNotEmpty(phyExam.getCognitionScreenScore())) {
			i++;
		}
		if(ObjectUtil.isNotEmpty(phyExam.getEmotionScreenResult()) && ObjectUtil.isNotEmpty(phyExam.getDepressionScore())) {
			i++;
		}
		return i;
	}
}
