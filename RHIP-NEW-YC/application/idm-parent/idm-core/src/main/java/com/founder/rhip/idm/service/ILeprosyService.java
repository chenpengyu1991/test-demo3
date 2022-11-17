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
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListCc;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import com.founder.rhip.idm.dto.LeprosySaveDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 结核病service 
 * @author Jiang Haiying
 */
public interface ILeprosyService {

	/**
	 * 查询结核病列表  专用病历 管理卡
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IdmStatusInfo> findSuspectedList(Page page, Criteria criteria, Order order);
	
	/**
	 * 更新专项状态
	 * @param idmId
	 * @param specialStatus
	 * @return
	 */
	public int updateSpecialStatus(Long idmId, String specialStatus);
	
	/**
     * 添加
     * @param       leprosySaveDto
     * @param       statusInfo
     * @return      int
     */
    @Transactional
    public boolean saveLeprosySaveDto(LeprosySaveDto leprosySaveDto, Long eventId, String type) throws Exception;
    
    /**
     * 修改
     * @param       malariaDto
     * @param       statusInfo
     * @return      int
     */
    @Transactional
    public boolean updateLeprosySaveDto(LeprosySaveDto leprosySaveDto) throws Exception;
    
    /**
     * 删除
     * @param       singleIdStr
     * @return      int
     */
    @Transactional
    public boolean deleteLeprosySaveDto(Long singleId, Long idmId);
    
    /**
     * 查看
     * @param       singleId
     * @return      MalariaDto
     */
    public LeprosySaveDto getLeprosySaveDto(String singleId);
    
    /**
     * 查询随访
     * @param ca
     * @return
     */
    public List<ListFr> getFrList(Criteria ca, Order od);

    public PageList<ListFr> getFrList(Page page, Criteria criteria, Order od);

    public ListFr getFr(Long id);
    /**
     * 添加随访
     * @param listFr
     * @return
     */
    public void saveFr(ListFr listFr, String userId);

    /**
     * 修改随访
     * @param listFr
     * @return
     */
    public void updateFr(ListFr listFr, String userId);

    /**
     * 删除随访
     * @param id
     * @return
     */
    public void deleteFr(Long id);

    public PageList<ListCc> getCcList(Page page, Criteria criteria, Order od);

    /**
     * 添加密切接触者
     * @param listCc
     * @return
     */
    public void saveCc(ListCc listCc);

    /**
     * 修改密切接触者
     * @param listCc
     * @return
     */
    public void updateCc(ListCc listCc);

    /**
     * 删除密切接触者
     * @param id
     * @return
     */
    public void deleteCc(Long id);

    /**
     * 获取密切接触者
     * @param id
     * @return
     */
    public ListCc getCc(Long id);
    
    /**
	 * 获取患者基本信息
	 * @param criteria
	 * @return
	 */
	public GeneralCondition findGeneralCondition(Long idmId);
	
	/**
	 * 获取报卡基本信息
	 * @param criteria
	 * @return
	 */
	public CaseInformation findCaseInformation(Long idmId);
	
	/**
	 * 根据报卡中的活动Id获取相应Id最大的个案
	 * @param idmId
	 * @return
	 */
	public EventInfo findEventInfo(String idmId);
	
	/**
     * 麻风密切接触者统计
     * @param page
     * @param criteria
     * @return
     */
    public PageList<ListCc> getCcListForLeprosySt(Page page, Criteria criteria);
    
    /**
     * 麻风随访统计
     * @param page
     * @param criteria
     * @return
     */
    public PageList<ListFr> getFrListForLeprosySt(Page page, Criteria criteria);
    
    /**
    * 麻风密切接触者统计 不分页
    * @param page
    * @param criteria
    * @return
    */
   public List<ListCc> getCcListForLeprosySt(Criteria criteria);
   
   /**
    * 麻风随访统计 不分页
    * @param page
    * @param criteria
    * @return
    */
   public List<ListFr> getFrListForLeprosySt(Criteria criteria);
   
   /**
    * 获取直报中传染病是麻风 还没有填写麻风疑似报卡的人数
    * @param criteria
    * @return
    */
   public int getNotReportLeprosyCount(Criteria criteria);
   
	/**
	 * 获取患者ID
	 * @param idmId
	 * @return 患者ID
	 */
	public Long getPersonId(Long idmId);
   
}