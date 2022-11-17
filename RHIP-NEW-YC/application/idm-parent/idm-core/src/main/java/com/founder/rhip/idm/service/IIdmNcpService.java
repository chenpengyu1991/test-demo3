/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmNcp;

public interface IIdmNcpService {

	/**
	 * 筛查表的分页查询
	 * @param criteria
	 * @return
	 */
	public PageList<IdmNcp> getIdmNcpPageList(Criteria criteria, Page page);


}