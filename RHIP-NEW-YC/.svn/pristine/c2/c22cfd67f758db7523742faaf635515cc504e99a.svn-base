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
import com.founder.rhip.ehr.dto.idm.TbQueryDto;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.*;
import com.founder.rhip.idm.dto.TbSaveDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 结核病service 
 * @author Jiang Haiying
 */
public interface ITbService {

	/**
	 * 查询结核病列表  专用病历 管理卡Criteria statusCr是获取eventId的条件 若为空则criteria.get("EVENT_ID")
	 * @param page
	 * @param criteria
	 * @return
	 */
	public List<IdmStatusInfo> findTreatList(Criteria criteria, Criteria statusCr, Order order);
	public List<Map<String, Object>> downTreatList(Criteria criteria, Criteria statusCr, Order order);

	public PageList<IdmStatusInfo> findTreatmentList(Page page, Criteria criteria, Criteria statusCr, Order orderS ,String firstVist);
	public List<IdmStatusInfo> findTreatmentList(Criteria criteria, Criteria statusCr, Order orderS);

	public List<Map<String, Object>> downTreatmentList(Criteria criteria, Criteria statusCr, Order order);

    public PageList<IdmStatusInfo> findMgntList(Page page, Criteria criteria, Criteria statusCr);

    public List<TbQueryDto> findMgntListTotal(Criteria criteria, Criteria statusCr);

    public List<TbQueryDto> getTbList(Criteria criteria, Criteria statusCr);

    public PageList<ListCc> getCcListForSt(Page page, Criteria criteria);

    public List<ListCc> getCcListForSt1(Criteria criteria);

	/**
	 * 查询结核病追踪单
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IdmStatusInfo> findTraceList(Page page, Criteria criteria);
	
	/**
	 * 更新专项状态
	 * @param idmId
	 * @param specialStatus
	 * @return
	 */
	public int updateSpecialStatus(IdmStatusInfo idmStatusInfo, IdmApprovalInfo approvalInfo);
	
	/**
     * 添加
     * @param       tbSaveDto
     * @param       statusInfo
     * @return      int
     */
    @Transactional
    public boolean saveTbSaveDto(TbSaveDto tbSaveDto, Long eventId, String type) throws Exception;
    
    /**
     * 修改
     * @param       malariaDto
     * @param       statusInfo
     * @return      int
     */
    @Transactional
    public boolean updateTbSaveDto(TbSaveDto tbSaveDto) throws Exception;
    
    /**
     * 删除
     * @param       singleIdStr
     * @return      int
     */
    @Transactional
    public boolean deleteTbSaveDto(Long singleId, Long idmId);
    
    /**
     * 查看
     * @param       singleId
     * @return      MalariaDto
     */
    public TbSaveDto getTbSaveDto(String singleId);
    
    /**
	 * 更新状态表中的到位状态
	 * @param criteria
	 * @param placeStatus
	 * @return
	 */
	public Boolean updatePlaceStatus(Long id, String placeStatus, ListTr listTr);

	/**
	 * 更新诊断结果
	 * @param idmId
	 * @param diagnosisType诊断结果
	 * @param diagnosisUnit诊断单位
	 * @param diagnosisDoctor诊断医生
	 * @return
	 */
	public boolean updateDiagnosis(TbSaveDto tbSaveDto, ListTr listTr);

	/**
	 * 获取转诊后未到诊的人数
	 * @param criteria
	 * @return
	 */
	public int getNotSeeDoctorCount(Criteria criteria);

	/**
	 * 添加一条转诊追踪记录
	 * @param listTr
	 * @return
	 */
	public boolean saveListTr(ListTr listTr);

	/**
	 * 查询结核病追踪记录
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<ListTr> findTraceRecordList(Page page, Criteria criteria);

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
	 * 更新报卡基本信息
	 * @param caseInformation
	 * @return
	 */
	public Boolean updateCaseInformation(CaseInformation caseInformation);

	/**
	 * 保存分派信息
	 * @param caseInformation
	 * @return
	 */
	public Boolean saveAssign(IdmStatusInfo idmStatusInfo, IdmApprovalInfo idmApprovalInfo);

    /**
     * 查询预约查痰
     * @param ca
     * @return
     */
    public List<ListAs> getAsList(Criteria ca, Order od);

    /**
     * 添加预约查痰
     * @param listAs
     * @return
     */
    public void insertAs(ListAs listAs);

    /**
	 * 保存规范化管理中的信息
	 * @param tbSaveDto
	 * @return
	 */
	public Boolean saveStandardization(TbSaveDto tbSaveDto);

	/**
	 * 获取规范化管理中的信息
	 * @param singleId
	 * @return
	 */
	public TbSaveDto getStandardization(String singleId);

    /**
     * 保存预约查痰
     * @param listAs
     * @return
     */
    public void saveAs(String singleId, List<ListAs> listAs);

	/**
	 * 更新预约查痰
	 * @param listAs
	 * @return
	 */
	public void updateAs(List<ListAs> listAs);

    /**
     * 保存督导服药
     * @param listSd
     * @return
     */
    public void saveSd(Criteria criteria, List<ListSd> listSd);

    /**
     * 获取督导服药
     * @param singleId
     * @return
     */
    public List<ListSd> getSdList(Criteria criteria);

    /**
     * 查询密切接触者
     * @param ca
     * @return
     */
    public List<ListCc> getCcList(Criteria ca, Order od);

	/**
	 * 查询密切接触者
	 * @param ca
	 * @return
	 */
	public List<Map<String, Object>> getCcMapList(Criteria ca, Order od);

    public PageList<ListCc> getCcList(Page page, Criteria criteria, Order od);

    /**
     * 密切接触者-统计
     * @param criteria
     * @return
     */
    public PageList<ListCc> getCcListForSt(Page page, Criteria criteria, Order od);

    /**
     * 添加密切接触者
     * @param listCc
     * @return
     */
    public void insertCc(ListCc listCc);

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
	 * 根据idmId获取状态对象
	 * @param idmId
	 * @return
	 */
	public IdmStatusInfo getIdmStatusInfo(Long idmId);

	/**
	 * 获取OtherCondition
	 * @param criteria
	 * @return
	 */
	public OtherCondition findOtherCondition(Long idmId);

	/**
	 * 根据EventInfo 的Id获取状态对象
	 * @param idmId
	 * @return
	 */
	public IdmStatusInfo getIdmStatusInfoByEventId(Long singleId);

	/**
     * 根据转诊的活动号  获取筛查的idmID
     * @param idmId
     * @return
     */
    public ClinicalManifestations getClinicalManifestations(String idmId);

	/**
	 * 获取患者ID
	 * @param idmId
	 * @return 患者ID
	 */
	public Long getPersonId(Long idmId);

	/**
	 * 保存耐多药服药卡
	 * @param drugCard
     */
	public void saveDrugCard(DrugCard drugCard, String dataJson, String userId);

	/**
	 * 获取耐多药服药卡
	 * @param singleId
	 * @return
	 */
	public DrugCard getDrugCard(Criteria criteria);

	/**
	 * 或许耐多药服药卡list
	 * @param criteria
     * @return
     */
	public List<DrugCard> getDrugCardList(Criteria criteria);

	/**
	 * 添加一条服务记录
	 * @param listSr
	 * @return
	 */
	public boolean saveListSr(ListSr listSr);

	/**
	 * 查询一条服务记录
	 * @param id
	 * @return
	 */
	public ListSr findListSr(String id);

	/**
	 * 删除一条服务记录
	 * @param id
	 * @return
	 */
	public boolean delListSr(String id);

	/**
	 * 删除一条耐多药服药记录
	 * @param drugCardId
	 * @param idmId
     * @return
     */
	public boolean delNdy(String drugCardId, String idmId);

	/**
	 * 查询一条IDM_STATUS_INFO
	 * @param id
	 * @return
	 */
	public IdmStatusInfo findIdmStatusInfo(String id);

	/**
	 * 更新停止治疗一条IDM_STATUS_INFO
	 * @param statusInfo
	 * @return
	 */
	public int updateIdmStatusInfo(IdmStatusInfo statusInfo);

	/**
	 * 查询访视次数
	 * @param singleId
	 * @return
	 */
	public Integer findFrCount(String singleId);

	/**
	 * 更新IDM_STATUS_INFO耐多药患者字段
	 * @param statusInfo
	 * @return
	 */
	public int confirmOrCancelNdy(IdmStatusInfo statusInfo);
	
	/**
     * 根据转诊的活动号 ,卡片类型，获取主要临床表现
     * @param idmId
     * @param cardType 卡片类型
     * @return
     */
    public ClinicalManifestations getClinicalManifestations(String idmId, String cardType);
	 
}