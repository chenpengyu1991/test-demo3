package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 锻炼
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldTrainValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO target) {
		int i = 0;
		PhysiqueExamination phyExam = target.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getTrainFrequencyTypeCode()) && phyExam.getTrainFrequencyTypeCode().equals("4")) {
			return 1;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getTrainFrequencyTypeCode())){
			i++;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getTrainingMin())){
			i++;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getTrainingTotaltime())){
			i++;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getTrainingWay())){
			i++;
		}
		
		return i;
	}
}
