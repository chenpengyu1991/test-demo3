/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service.personal;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.basic.PersonMoveInfo;

/**
 * 档案迁移Service
 * @author ggf
 *
 */
public interface IPersonMoveService {
	
	void savePersonMoveRecoed(PersonMoveInfo personMoveInfo);
	
	PageList<PersonMoveInfo> getPersonMoveRecoedList(Criteria criteria,Page page, Order order);

	PersonMoveInfo getPersonMoveInfo(Criteria criteria);

	List<Map<String, Object>> exportMovePersonRecordList(Page page,
			Criteria criteria, Order order);
}