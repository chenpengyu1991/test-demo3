package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarValueGetter;

/**
 * 3星级  -- 脏器功能
 *@author liuk
 */
@Component
public class ThreeStarOrganValueGetter implements IThreeStarValueGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO personalPhyExamDTO) {
		PhysiqueExamination phyExam = personalPhyExamDTO.getPhysiqueExamination();
		int value = 0;
		if(ObjectUtil.isNotEmpty(phyExam) && ObjectUtil.isNotEmpty(phyExam.getLipAppearanceCehckResult()) &&
				ObjectUtil.isNotEmpty(phyExam.getDentitionAnomalyFlag()) && ObjectUtil.isNotEmpty(phyExam.getPharynxCheckResult()) &&
				ObjectUtil.isNotEmpty(phyExam.getHearDetectResult()) && ObjectUtil.isNotEmpty(phyExam.getMotorFuncState()) && 
				((ObjectUtil.isNotEmpty(phyExam.getlNakedEye()) && ObjectUtil.isNotEmpty(phyExam.getrNakedEye())) || 
						(ObjectUtil.isNotEmpty(phyExam.getlEyecorrection()) && ObjectUtil.isNotEmpty(phyExam.getrEyecorrection())))) {
			value = 1;
		}
		return value;
	}
}