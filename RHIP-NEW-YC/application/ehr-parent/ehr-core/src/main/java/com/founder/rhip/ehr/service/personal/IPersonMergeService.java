/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PersonMerge;
import com.founder.rhip.mdm.entity.Person;

import java.util.List;

/**
 * 人员信息合并Service
 * @author ggf
 *
 */
public interface IPersonMergeService {

	int mergePerson(List<PersonMerge> personMerges,String pmpiId,List<Person> persons);

	/**
	 * 根据personId,查询合并过的患者列表
	 * @param personId
	 * @return
	 */
	List<PersonInfo> getMergePersonList(Long personId);

	PersonMerge getPersonMerge(Criteria ca);

}