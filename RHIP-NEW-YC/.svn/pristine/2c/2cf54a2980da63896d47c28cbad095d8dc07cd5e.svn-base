package com.founder.rhip.ehr.service.star.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.summary.DeformityHistory;
import com.founder.rhip.ehr.service.star.ITwoStarDisplayFieldGetter;

/**
 * 二星字段 --- 残疾
 * @author ggf
 *
 */
@Component
public class TwoStarDisplayFieldDeformityValueGetter implements ITwoStarDisplayFieldGetter<PersonalBasicInfoDTO>{
	
	public static Logger logger = Logger.getLogger(TwoStarDisplayFieldDeformityValueGetter.class);

	@Override
	public int execute(PersonalBasicInfoDTO personInfoDto) {
		DeformityHistory deformityHistory = personInfoDto.getDeformityHistory();
		int i = 0;
		if(ObjectUtil.isNotEmpty(deformityHistory)){
			i = 1;
		}
		return i;
	}
}