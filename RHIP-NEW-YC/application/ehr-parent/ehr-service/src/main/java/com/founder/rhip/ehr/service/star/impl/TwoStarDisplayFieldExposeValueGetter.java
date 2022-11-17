package com.founder.rhip.ehr.service.star.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.PersonalBasicInfoDTO;
import com.founder.rhip.ehr.entity.summary.ExposeHistory;
import com.founder.rhip.ehr.service.star.ITwoStarDisplayFieldGetter;

/**
 * 二星字段---暴露史
 * @author ggf
 *
 */
@Component
public class TwoStarDisplayFieldExposeValueGetter implements ITwoStarDisplayFieldGetter<PersonalBasicInfoDTO>{
	
	public static Logger logger = Logger.getLogger(TwoStarDisplayFieldExposeValueGetter.class);

	@Override
	public int execute(PersonalBasicInfoDTO personInfoDto) {
		ExposeHistory exposeHistory = personInfoDto.getExposeHistory();
		int i = 0;
		if(ObjectUtil.isNotEmpty(exposeHistory)){
			i = 1;
		}
		return i;
	}
}