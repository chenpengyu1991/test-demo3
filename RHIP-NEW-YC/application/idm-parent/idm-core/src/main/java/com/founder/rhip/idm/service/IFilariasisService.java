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
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.ehr.entity.control.idm.special.ListSc;
import com.founder.rhip.idm.dto.FilariasisDto;

import java.util.List;
import java.util.Map;

/*
 * 丝虫病专项SERVICE
 */

public interface IFilariasisService {

    /**
     * 分页
     * @param       criteria
     * @param       page
     * @return      PageList<IdmStatusInfo>
     */
    public PageList<IdmStatusInfo> findFilRegList(Criteria criteria, Page page, boolean isStandard);

    /**
     * 保存监测登记
     * @param filariasisDto
     * @return boolean
     */
    public boolean addRegister(FilariasisDto filariasisDto);

    /**
     * 更新监测登记
     * @param filariasisDto
     * @return boolean
     */
    public boolean updateRegister(FilariasisDto filariasisDto);

    /**
     * 查询监测登记
     * @param singleId
     * @return FilariasisDto
     */
    public FilariasisDto getRegister(Long singleId);

    /**
     * 查询个案
     * @param singleId
     * @return FilariasisDto
     */
    public FilariasisDto getCase(Long singleId);

    /**
     * 保存个案
     * @param filariasisDto
     * @return FilariasisDto
     */
    public boolean addCase(FilariasisDto filariasisDto, Long idmId);
    /**
     * 修改个案
     * @param filariasisDto
     * @return FilariasisDto
     */
    public boolean updateCase(FilariasisDto filariasisDto, Long singleId);

    /**
     * 分页查询随访记录
     * @param       criteria
     * @param       page
     * @return      PageList<findFrList>
     */
    public PageList<ListFr> findFrList(Criteria criteria, Page page, Order od);

    /**
     * 分页督导检查
     * @param       criteria
     * @param       page
     * @return      PageList<findFrList>
     */
    public PageList<ListSc> findScList(Criteria criteria, Page page, Order od);

    /**
     * @param       criteria
     * @return      GeneralCondition
     */
    public GeneralCondition findGenInfo(Criteria criteria);

    /**
     * 查询随访信息
     * @param       criteria
     * @return      ListFr
     */
    public ListFr findFollowUp(Criteria criteria);

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
     * 保存督导检查
     * @param listSc
     * @return boolean
     */
    public boolean addSc(ListSc listSc);
    /**
     * 修改督导检查
     * @param listSc
     * @return boolean
     */
    public boolean updateSc(ListSc listSc);

    /**
     * 查询督导查询
     * @param       criteria
     * @return      ListFr
     */
    public ListSc findSc(Criteria criteria);

    /**
     * 慢性丝虫病患者统计表
     * @param       criteria
     * @return
     */
    public List<Map<String,Object>> findChreport(Criteria criteria);
    public List<Map<String,Object>> findChreportCount(Criteria criteria);

    /**
     * 丝虫病病原学监测汇总表
     * @param       criteria
     * @return
     */
    public List<Map<String,Object>> findPhreport(Criteria criteria);
    public List<Map<String,Object>> findPhreportCount(Criteria criteria);

}