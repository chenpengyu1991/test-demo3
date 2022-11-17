package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 吸烟
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldSmokeValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO target) {
		int i = 0;
		PhysiqueExamination phyExam = target.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getSmodeStatusCode()) && phyExam.getSmodeStatusCode().equals("4")) {
			return 1;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getSmodeStatusCode())){
			i++;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getSmokeAge())){
			i++;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getQuitSmokeAge())){
			i++;
		}
		
		return i;
	}

}
