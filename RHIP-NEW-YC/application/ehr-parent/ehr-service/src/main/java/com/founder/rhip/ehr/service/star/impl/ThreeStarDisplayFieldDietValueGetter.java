package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 饮食习惯
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldDietValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO target) {
		int i = 0;
		PhysiqueExamination phyExam = target.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getDietAddictedOil()) || 
				ObjectUtil.isNotEmpty(phyExam.getDietHalophilic()) || 
				ObjectUtil.isNotEmpty(phyExam.getDietHunsuEquilibrium()) ||
				ObjectUtil.isNotEmpty(phyExam.getDietMeatMain()) ||
				ObjectUtil.isNotEmpty(phyExam.getDietSugarCravings()) ||
				ObjectUtil.isNotEmpty(phyExam.getDietVegetarian())) {
			i = 1;
		}
		return i;
	}

}
