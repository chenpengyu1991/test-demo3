/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ph.service.dmbc;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcChildInstMonitor;

public interface IChildInstMonitorService {

	/**
	 * 消毒质量查询
	 * @param       Criteria
	 * @return      PageList<DmbcChildInstMonitor>
	 */
	public PageList<DmbcChildInstMonitor> getList(Criteria criteria, Page page);

	/**
	 * 消毒质量查询
	 * @param id
	 * @return
	 */
	public DmbcChildInstMonitor getDetail(Long id);
	
	/**
	 * 消毒质量保存
	 * @param       DmbcChildInstMonitor
	 * @param       Criteria
	 * @return      Boolean
	 */
	public void save(DmbcChildInstMonitor childInstMonitor);

	/**
	 * 删除消毒质量查询
	 * @param id
	 */
	public void delete(Long id);

}