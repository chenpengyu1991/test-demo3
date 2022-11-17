/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ech.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.ech.EchIdentification;

public interface IEchManageService {

	/**
	 * 获取服务记录表
	 * @param       examRecordId
	 * @return      EchIdentification
	 */
	public EchIdentification getEchIdentification(Long id);
	
	/**
	 * 保存服务记录表
	 * @param       identification
	 * @return      EchIdentification
	 */
	public EchIdentification saveEchIdentification(EchIdentification identification,String... resource);

  /**
   * 获取服务记录
   * @param criteria
   * @return
   */
  List<EchIdentification> getEchIdentification(Criteria criteria);
  
	public void delEchIdentification(Long examRecordId);
	
	public EchIdentification updateEchIdentification(Long newIdenId);
		
	public String getConclusion(EchIdentification identification);
	
	public PageList<EchIdentification> getPageList(Page page, Criteria criteria, Order order);

}