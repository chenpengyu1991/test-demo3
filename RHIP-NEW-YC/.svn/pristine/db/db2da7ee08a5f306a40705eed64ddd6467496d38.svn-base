/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.SecrecyDegreeSet;
import com.founder.rhip.ehr.repository.clinic.ISecrecyDegreeDao;

/**
 * 安全性配置
 *
 * @author Cary
 *
 */
@Service("secrecyDegreeService")
public class SecrecyDegreeServiceImpl extends AbstractService implements ISecrecyDegreeService {

	@Autowired
	private ISecrecyDegreeDao secrecyDegreeDao;

	@Override
	public void save(SecrecyDegreeSet secrecyDegreeSet){
		if(ObjectUtil.isNotEmpty(secrecyDegreeSet.getId())){
			secrecyDegreeDao.update(secrecyDegreeSet);
		}else {
			secrecyDegreeDao.insert(secrecyDegreeSet);
		}
//		return null;
	}

	public SecrecyDegreeSet getSecrecyDegree(Criteria criteria){
		return secrecyDegreeDao.get(criteria);
	}

	@Override
	public PageList<SecrecyDegreeSet> getSecrecyDegreeList(Page page, Criteria criteria){
		PageList<SecrecyDegreeSet> pageList = secrecyDegreeDao.getSecrecyDegreeList(page, criteria);
		return pageList;
	}

	/**
	 * 删除设置
	 *
	 * @param secrecyDegreeSet
	 */
	public void delete(SecrecyDegreeSet secrecyDegreeSet){
		secrecyDegreeDao.delete(new Criteria("id", secrecyDegreeSet.getId()));
	}
}
