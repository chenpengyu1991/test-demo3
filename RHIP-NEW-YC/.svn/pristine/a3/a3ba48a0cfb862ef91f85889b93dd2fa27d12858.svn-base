package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 血压
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldBPValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO target) {
		int i= 0;
		PhysiqueExamination phyExam = target.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getLeftDbp()) && ObjectUtil.isNotEmpty(phyExam.getLeftSbp())){
			i = 2;
		}else if(ObjectUtil.isNotEmpty(phyExam.getLeftDbp()) || ObjectUtil.isNotEmpty(phyExam.getLeftSbp())){
			i = 1;
		}

		if(ObjectUtil.isNotEmpty(phyExam.getRightDbp()) && ObjectUtil.isNotEmpty(phyExam.getRightSbp())){
			i = 2;
		}else if(ObjectUtil.isNotEmpty(phyExam.getRightDbp()) || ObjectUtil.isNotEmpty(phyExam.getRightSbp())){
			i = 1;
		}
		return i;
	}

}
