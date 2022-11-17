/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hm.service;

import java.util.List;

import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.Person;

public interface IPersonInfoService {

	/**
	 * 数据获取
	 * @param       criteria
	 * @return      List<PersonInfo>
	 */
	public List<PersonInfo> getPersonInfo(Criteria criteria);

	public Long generatePersonId(PersonInfo personInfo);
	
	public int updatePersonInfo (PersonInfo personInfo);

	/**
	 * 获取个人信息
	 * @param criteria
	 * @return
	 */
	public PersonInfo getPersonInfoId(Criteria criteria);

	/**
	 *根据idCard查询人员是否存在
	 * @param idCard
	 * @return
	 */
	public PersonInfo getPersonInfo(String idCard);

}