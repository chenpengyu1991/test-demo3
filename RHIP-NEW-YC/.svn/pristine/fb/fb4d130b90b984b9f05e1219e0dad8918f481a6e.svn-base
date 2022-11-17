/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.basic.PersonMoveInfo;
import com.founder.rhip.ehr.repository.basic.IPersonMoveInfoDao;
import com.founder.rhip.ehr.service.personal.IPersonMoveService;

@Service("personMoveInfoService")
public class PersonMoveInfoServiceImpl extends AbstractService implements IPersonMoveService {
	
	@Resource(name="personMoveInfoDao")
	private IPersonMoveInfoDao personMoveInfoDao;

	@Override
	@Transactional
	public void savePersonMoveRecoed(PersonMoveInfo personMoveInfo) {
		personMoveInfoDao.insert(personMoveInfo);
	}

	@Override
	public PageList<PersonMoveInfo> getPersonMoveRecoedList(Criteria criteria,Page page, Order order) {
		PageList<PersonMoveInfo> moveList = personMoveInfoDao.getPageList(page, criteria, order);
		return moveList;
	}

	@Override
	public PersonMoveInfo getPersonMoveInfo(Criteria criteria) {
		return personMoveInfoDao.get(criteria);
	}

	@Override
	public List<Map<String, Object>> exportMovePersonRecordList(Page page, Criteria criteria, Order order) {
		PageList<Map<String,Object>>  mapList = personMoveInfoDao.exportMovePersonRecordList(page, criteria, order);
		
		if (null == mapList.getList()) {
			return Collections.emptyList();
		}
		return mapList.getList();
	}
}