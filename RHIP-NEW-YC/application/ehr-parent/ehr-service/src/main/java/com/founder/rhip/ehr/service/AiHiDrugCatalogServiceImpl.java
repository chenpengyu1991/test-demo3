/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.dto.DrugReportDTO;
import com.founder.rhip.ehr.entity.clinic.AiHiDrugCatalog;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.repository.clinic.IAiHiDrugCatalogDao;
import com.founder.rhip.ehr.repository.clinic.IDrugUsageDao;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.mdm.repository.IDicItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用药记录
 * 
 * @author Cary
 * 
 */
@Service("aiHiDrugCatalogService")
public class AiHiDrugCatalogServiceImpl extends AbstractService implements IAiHiDrugCatalogService {

	@Resource(name = "aiHiDrugCatalogDao")
	private IAiHiDrugCatalogDao aiHiDrugCatalogDao;

	public List<AiHiDrugCatalog> getDrugs(Criteria criteria){
		return aiHiDrugCatalogDao.getList(criteria, new String[]{"drugname", "coopInsuranceCd", "pubmediCd"});
	}

}
