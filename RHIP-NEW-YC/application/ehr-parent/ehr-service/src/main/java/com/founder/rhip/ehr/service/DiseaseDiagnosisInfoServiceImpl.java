/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.repository.clinic.IDiseaseDiagnosisInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 诊断记录
 * 
 * @author rose
 * 
 */
@Service("diseaseDiagnosisInfoService")
public class DiseaseDiagnosisInfoServiceImpl extends AbstractService implements IDiseaseDiagnosisInfoService {

	@Autowired
	private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;

	@Override
	public PageList<DiseaseDiagnosisInfo> getDiseaseDiagnosisInfoForCdm(Page page, Criteria criteria) {
		PageList<DiseaseDiagnosisInfo> diseaseDiagnosisInfoPages = diseaseDiagnosisInfoDao.getDiseaseDiagnosisInfoForCdm(page, criteria);
		return diseaseDiagnosisInfoPages;
	}

	@Override
	public List<String> getRelationOrganCodes(Long personId){
		Assert.notNull(personId, "人员Id不能为空");
		List<String> codes= diseaseDiagnosisInfoDao.getRelationOrganCodes(personId);
		List<String> all=new ArrayList<>();

		if (ObjectUtil.isNotEmpty(codes)) {
			for (String string : codes) {
				if (ObjectUtil.isNotEmpty(string)) {
					all.add(string);
				}
			}
		}


		return all;
	}

	@Override
	public String getDiseaseName(Criteria criteria) {
		return diseaseDiagnosisInfoDao.getDiseaseName(criteria);
	}

}
