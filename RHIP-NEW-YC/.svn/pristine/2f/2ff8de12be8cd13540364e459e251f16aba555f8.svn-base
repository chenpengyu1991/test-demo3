/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.mhm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.dto.mhm.MhmClueQueryDto;
import com.founder.rhip.ehr.entity.management.mhm.MhmApprovalInfo;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.dto.ManagementDto;
import com.founder.rhip.mhm.dto.MhmClueDto;

import java.util.List;

public interface IMhmClueService {
	/**
	 * 分页查询-线索登记
	 * @param       criteria
	 * @param       page
	 * @return      PageList<MhmClueQueryDto>
	 */
	public PageList<MhmClueQueryDto> findMhmClueList(Criteria criteria, Page page);
    /**
     * 查询-线索登记
     * @param       criteria
     * @return      List<MhmClueQueryDto>
     */
    public List<MhmClueQueryDto> findMhmClueList(Criteria criteria);	
    /**
     * 线索登记业务数据获取
     * @param       statusId
     * @param       event
     * @return      MhmClueDto
     */
    public MhmClueDto getMhmClue(Long statusId,MhmEvents event);

    /**
     * 线索登记业务数据获取
     * @param       eventId
     * @return      MhmClueDto
     */
    public ManagementDto getMhmMgnt(Long eventId);

    /**
     * 线索登记业务数据创建
     * @param       dto
     * @return      boolean
     */
    public boolean creatMhmClue(MhmClueDto dto); 
    /**
     * 线索登记审批
     * @param       dto
     * @return      boolean
     */
    public boolean approveMhmClue(MhmClueDto dto);  
    
    /**
     * 线索登记审批历史记录
     * @param       statusId
     * @return      PageList<MhmApprovalInfo>
     */
    public PageList<MhmApprovalInfo> findApprovalInfo(Long	statusId);  
    
    /**
     * 根据idcard查询，该患者是否已经精卫系统中存在
     *
     * @param pixId
     * @return
     * @author Ye jianfei
     */
    public Long getPersonCount(String idcard);
    
	/**
	 * 获取患者ID
	 * @param statusId
	 * @return 患者ID
	 */
	public Long getPersonId(Long statusId);    

}