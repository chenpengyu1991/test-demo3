/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.da.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.clinic.DaConfig;
import com.founder.rhip.ehr.repository.clinic.IDaConfigDao;

@Service("daConfigService")
public class DaConfigServiceImpl extends AbstractService implements IDaConfigService {
    
	@Resource(name = "daConfigDao")
    private IDaConfigDao daConfigDao;


	@Override
	public DaConfig getDaConfig(String organCode) {
		DaConfig result = new DaConfig();
		if(StringUtil.isNotEmpty(organCode)){
			result = daConfigDao.get(new Criteria("ORGAN_CODE",organCode));
		}
		return result;
	} 

}