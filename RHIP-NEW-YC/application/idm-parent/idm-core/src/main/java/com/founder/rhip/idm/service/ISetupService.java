/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmSetup;

import java.util.List;

public interface ISetupService {

	/**
	 * 添加
	 * @param       idmSetup
	 */
	public int createSetup(IdmSetup idmSetup);

	/**
	 * 修改
	 * @param       idmSetup
	 * @return      int
	 */
	public int updateSetup(IdmSetup idmSetup);

	
	/**
	 * 删除
	 * @param       Id
	 * @return      int
	 */
	public int deleteSetup(Long Id);

    /**
     *
     * @param criteria
     * @param page
     * @param order
     * @return
     */
    public PageList<IdmSetup> findSetupOrder(Criteria criteria, Page page, Order order);

    /**
	 * 查看
	 * @param       id
	 * @return      IdmSetup
	 */
	public IdmSetup getSetup(Long id);

    /**
     * 处理多对多list插入的方法
     * @param idmSetup
     * @return
     */
    public int createSetupBath(IdmSetup idmSetup);
    
    /**
     * 获取设置的集合
     * @param criteria
     * @return
     */
    public List<IdmSetup> findSetup(Criteria criteria);

	/**
	 * 根据条件查询出不重复的INFECTIOUS_CODE
	 * @param criteria
	 * @return
	 */
	public List<IdmSetup> findDistinctInfectiousCodes(Criteria criteria);

}