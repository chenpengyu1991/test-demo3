/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hm.service;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("personInfoService")
public class PersonInfoServiceImpl extends AbstractService implements IPersonInfoService {

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	/**
	 * 数据获取
	 * @param       criteria
	 * @return      List<PersonInfo>
	 */
	public List<PersonInfo> getPersonInfo(Criteria criteria) {
		return personInfoDao.getList(criteria);
	}

	@Override
	public Long generatePersonId(PersonInfo personInfo) {
		return personInfoDao.generatedKey(personInfo, "ID", null).longValue();
	}

	public int updatePersonInfo (PersonInfo personInfo) {
		return personInfoDao.update(personInfo);
	}

	/**
	 * 获取个人信息
	 * @param criteria
	 * @return
	 */
	@Override
	public PersonInfo getPersonInfoId(Criteria criteria) {
		return personInfoDao.get(criteria);
	}

	@Override
	public PersonInfo getPersonInfo(String idCard){
		Criteria criteria = new Criteria();
		criteria.add("IDCARD",idCard);
		return personInfoDao.get(criteria);
	}
}