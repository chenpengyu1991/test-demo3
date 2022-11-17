package com.founder.rhip.ehr.service.star.impl;

import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 饮酒
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldDrinkValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO> {

	@Override
	public int execute(PersonalPhyExamDTO target) {
		int i = 0;
		PhysiqueExamination phyExam = target.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getDrinkFrequency()) && phyExam.getDrinkFrequency().equals("4")) {
			return 1;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getDrinkFrequency())) {
			i++;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getDailyDrink())){
			i++;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getNodrink())){
			i++;
		}

		if(ObjectUtil.isNotEmpty(phyExam.getDrinkAge())){
			i++;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getDrunk())){
			i++;
		}
		
		if(ObjectUtil.isNotEmpty(phyExam.getDrinkSpirit()) || 
				ObjectUtil.isNotEmpty(phyExam.getDrinkBeer()) ||
				ObjectUtil.isNotEmpty(phyExam.getDrinkRedWine()) ||
				ObjectUtil.isNotEmpty(phyExam.getDrinkYellowWine()) ||
				ObjectUtil.isNotEmpty(phyExam.getDrinkOther())){
			i++;
		}
		
		return i;
	}
}
