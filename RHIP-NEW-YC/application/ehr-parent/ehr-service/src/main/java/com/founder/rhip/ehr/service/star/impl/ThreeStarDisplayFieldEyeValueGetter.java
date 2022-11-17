package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 视力
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldEyeValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO target) {
		int i = 0;
		PhysiqueExamination phyExam = target.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getlNakedEye()) && ObjectUtil.isNotEmpty(phyExam.getrNakedEye())) {
			i = 2;
		}else if(ObjectUtil.isNotEmpty(phyExam.getlNakedEye()) || ObjectUtil.isNotEmpty(phyExam.getrNakedEye())){
			i = 1;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getlEyecorrection()) && ObjectUtil.isNotEmpty(phyExam.getrEyecorrection())) {
			i = 2;
		}else if(ObjectUtil.isNotEmpty(phyExam.getlEyecorrection()) || ObjectUtil.isNotEmpty(phyExam.getrEyecorrection())){
			i = 1;
		}
		
		return i;
	}

}
