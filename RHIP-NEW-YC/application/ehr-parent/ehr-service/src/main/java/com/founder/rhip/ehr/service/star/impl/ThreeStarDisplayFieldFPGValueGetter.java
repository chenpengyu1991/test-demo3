package com.founder.rhip.ehr.service.star.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.clinic.PhysiqueExamination;
import com.founder.rhip.ehr.service.star.IThreeStarDisplayFieldGetter;

/**
 * 三星字段 --- 空腹血糖
 * @author ggf
 *
 */
@Component
public class ThreeStarDisplayFieldFPGValueGetter implements IThreeStarDisplayFieldGetter<PersonalPhyExamDTO>{
	
	public static Logger logger = Logger.getLogger(ThreeStarDisplayFieldFPGValueGetter.class);

	@Override
	public int execute(PersonalPhyExamDTO personExamDto) {
		int i = 0;
		PhysiqueExamination phyExam = personExamDto.getPhysiqueExamination();
		if(ObjectUtil.isNotEmpty(phyExam.getFpgMg()) || ObjectUtil.isNotEmpty(phyExam.getFpgMmol())){
			i = 1;
		}
		return i;
	}
}
