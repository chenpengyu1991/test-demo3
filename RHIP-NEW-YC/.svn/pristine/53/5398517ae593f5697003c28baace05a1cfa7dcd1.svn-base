package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarValueGetter;

/**
 * 3星级  -- 一般状况
 *@author liuk
 */
@Component
public class ThreeStarCommonValueGetter implements IThreeStarValueGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO personalPhyExamDTO) {
		PhysiqueExamination phyExam = personalPhyExamDTO.getPhysiqueExamination();
		int value = 0;
		if(ObjectUtil.isNotEmpty(phyExam) && ObjectUtil.isNotEmpty(phyExam.getTemperature()) &&
				ObjectUtil.isNotEmpty(phyExam.getPulseRate()) && ObjectUtil.isNotEmpty(phyExam.getRespiratoryRate()) &&
				((ObjectUtil.isNotEmpty(phyExam.getLeftDbp()) && ObjectUtil.isNotEmpty(phyExam.getLeftSbp())) || 
						((ObjectUtil.isNotEmpty(phyExam.getRightDbp()) && ObjectUtil.isNotEmpty(phyExam.getRightSbp())))) &&
						ObjectUtil.isNotEmpty(phyExam.getHeight()) && ObjectUtil.isNotEmpty(phyExam.getBodyWeight()) &&
						ObjectUtil.isNotEmpty(phyExam.getWaostline()) && ObjectUtil.isNotEmpty(phyExam.getIndexOfBodyCharacteristics())) {
			value = 1;
		}
		return value;
	}
}
