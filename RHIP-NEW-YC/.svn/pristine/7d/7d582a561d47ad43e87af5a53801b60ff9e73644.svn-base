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
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.ehr.entity.control.idm.special.ListTs;
import com.founder.rhip.idm.dto.CaseDto;

import java.util.List;

/*
 * 丝虫病专项SERVICE
 */

public interface IFrTsService {

    public CaseDto getPersonInfo(Long singleId);

    public IdmReport getReportInfo(Long singleId);
    /**
     * 分页查询随访记录
     * @param       criteria
     * @param       page
     * @return      PageList<findFrList>
     */
    public PageList<ListFr> findFrList(Criteria criteria, Page page, Order od);

    /**
     * 查询随访信息
     * @param       criteria
     * @return      ListFr
     */
    public ListFr findFr(Criteria criteria);

    public List<ListFr> findIdmListFrs(Criteria criteria);

    /**
     * 保存随访
     * @param listFr
     * @return boolean
     */
    public boolean addFr(ListFr listFr);
    /**
     * 修改随访
     * @param listFr
     * @return boolean
     */
    public boolean updateFr(ListFr listFr);
    /**
     * 删除随访
     * @param id
     * @return boolean
     */
    public boolean deleteFr(Long id);

    /**
     * 分页查询采样记录
     * @param       criteria
     * @param       page
     * @return      PageList<findFrList>
     */
    public PageList<ListTs> findTsList(Criteria criteria, Page page, Order od);

    /**
     * 查询采样信息
     * @param       criteria
     * @return      ListFr
     */
    public ListTs findTs(Criteria criteria);

    /**
     * 保存采样
     * @param listTs
     * @return boolean
     */
    public boolean addTs(ListTs listTs);
    /**
     * 修改采样
     * @param listTs
     * @return boolean
     */
    public boolean updateTs(ListTs listTs);
    /**
     * 删除采样
     * @param id
     * @return boolean
     */
    public boolean deleteTs(Long id);


}