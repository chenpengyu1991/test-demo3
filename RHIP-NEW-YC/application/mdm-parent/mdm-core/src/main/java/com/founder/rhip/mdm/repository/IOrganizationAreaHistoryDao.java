/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */
package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.OrganizationArea;
import com.founder.rhip.mdm.entity.OrganizationAreaHistory;

import java.util.List;

public interface IOrganizationAreaHistoryDao extends IDao<OrganizationAreaHistory, Long> {
	
	/**
	 * 获取OrganizationArea对象集合
	 * @param criteria
	 * @return
	 */
	public List<OrganizationAreaHistory> getOrganizationAreasHistory(Criteria criteria);
}
