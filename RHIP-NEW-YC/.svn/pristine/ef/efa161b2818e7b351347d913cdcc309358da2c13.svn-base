package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 危害因素控制
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldRiskValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO target) {
		int i = 0;
		PhysiqueExamination phyExam = target.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getRiskQuitSmoking()) || 
				ObjectUtil.isNotEmpty(phyExam.getRiskHealthDrink()) || 
				ObjectUtil.isNotEmpty(phyExam.getRiskDiet()) ||
				ObjectUtil.isNotEmpty(phyExam.getRiskExercise()) ||
				ObjectUtil.isNotEmpty(phyExam.getRiskWeightReduction()) ||
				ObjectUtil.isNotEmpty(phyExam.getGuideVaccination()) ||
				ObjectUtil.isNotEmpty(phyExam.getGuideVaccinationDesc()) ||
				ObjectUtil.isNotEmpty(phyExam.getRiskOther())) {
			i = 1;
		}
		return i;
	}

}
