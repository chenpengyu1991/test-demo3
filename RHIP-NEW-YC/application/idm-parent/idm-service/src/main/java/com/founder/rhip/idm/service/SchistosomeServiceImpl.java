/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 传染病上报
 */

package com.founder.rhip.idm.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.idm.SchistosomeQueryDto;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.CaseInformation;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.ClinicalManifestations;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.Diagnosis;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.EpidemicFocusClose;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.GeneralCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmApprovalInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmStatusInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.LabExamine;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.OtherCondition;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.PastHistory;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListCr;
import com.founder.rhip.ehr.entity.control.idm.special.ListRr;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.ICaseInformationDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IClinicalManifestationsDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IDiagnosisDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IEpidemicFocusCloseDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IGeneralConditionDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IIdmStatusInfoDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.ILabExamineDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IOtherConditionDao;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IPastHistoryDao;
import com.founder.rhip.ehr.repository.control.idm.special.IEventInfoDao;
import com.founder.rhip.ehr.repository.control.idm.special.IListCrDao;
import com.founder.rhip.ehr.repository.control.idm.special.IListRrDao;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.SchStatus;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.dto.SchistosomeDto;
import com.founder.rhip.mdm.app.IDictionaryApp;

@Service("schistosomeService")
public class SchistosomeServiceImpl extends AbstractService implements ISchistosomeService {
	@Resource(name = "idmStatusInfoDao")
	private IIdmStatusInfoDao idmStatusInfoDao;     //状态表

    @Resource(name = "eventInfoDao")
    private IEventInfoDao eventInfoDao;     //关联表

    @Resource(name = "generalConditionDao")
    private IGeneralConditionDao generalConditionDao;    //一般情况

    @Resource(name = "labExamineDao")
    private ILabExamineDao labExamineDao;     //实验室检查
    
    @Resource(name = "caseInformationDao")
    private ICaseInformationDao caseInformationDao;     //卡片信息
 
    @Resource(name = "clinicalManifestationsDao")
    private IClinicalManifestationsDao clinicalManifestationsDao;     //主要临床表现
    
    @Resource(name = "epidemicFocusCloseDao")
    private IEpidemicFocusCloseDao epidemicFocusCloseDao;      //疫源地处理、密切接触者登记
    
    @Resource(name = "diagnosisDao")
    private IDiagnosisDao diagnosisDao;      //诊断依据、诊断结果

    @Resource(name = "pastHistoryDao")
    private IPastHistoryDao pastHistoryDao;      //诊断依据、诊断结果
 
    @Resource(name = "otherConditionDao")
    private IOtherConditionDao otherConditionDao;      //其他
    
    @Resource(name = "idmListRrDao")
    private IListRrDao listRrDao;      //治疗记录
  
    @Resource(name = "idmListCrDao")
    private IListCrDao listCrDao;      //变更记录
    
	@Resource(name = "haInterfaceService")
	private IHaInterfaceService haInterfaceService;
	
	@Resource(name = "approvalService")
	private IApprovalService approvalService;

	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;



	/**
	 * 分页查询血检登记
	 * @param       criteria
	 * @param       page
	 * @return      PageList<IdmStatusInfo>
	 */
	@Override
	public PageList<IdmStatusInfo> findRegisterList(Criteria criteria, Page page) {
		PageList<IdmStatusInfo> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = idmStatusInfoDao.findSchRegisterList(page, criteria);
		}
		return result;
	}

	/**
	 * 血吸虫报表
	 * @param criteria
	 * @return
	 */
	@Override
	public List<Map<String, Object>> findJcReport(Criteria criteria) {
		List<Map<String, Object>> list = idmStatusInfoDao.findJcReport(criteria);
		return list;
	}
	@Override
	public List<Map<String, Object>> findJcReportCount(Criteria criteria) {
		List<Map<String, Object>> list = idmStatusInfoDao.findJcReportCount(criteria);
		return list;
	}

	/**
     * 查询血检登记
     * @param       criteria
     * @return      List<SchistosomeQueryDto>
     */
    public List<SchistosomeQueryDto> findRegisterList(Criteria criteria){
       List<SchistosomeQueryDto> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = idmStatusInfoDao.findSchRegisterList(criteria);
		}       
       return result;
    }
    /**
     * 保存监测登记
     * @param       schDto
     * @param       statusInfo
     * @param       user
     * @param       eventId
     * @param       type
     * @return      boolean
     */
    @Transactional
    public boolean saveRegister(SchistosomeDto schDto, User user, Long eventId, String type){
        int result = 0;
        Long idmId = -1L;
        Long singleId = -1L;
        
        IdmStatusInfo statusInfo = new IdmStatusInfo();
        
        /*如果作废则不个更新患者*/
        boolean bEliminatiton = schDto.getSpecialStatus().equals(SchStatus.ELIMINATION.getValue());
        GeneralCondition generalCondition = schDto.getGeneralCondition();
        if (ObjectUtil.isNotEmpty(generalCondition)) {
			if(!bEliminatiton){			
				try {
					SavePerson(schDto);//调用接口新增或更新患者
					PersonInfo personInfo = schDto.getPersonInfo();
					if(ObjectUtil.isNotEmpty(personInfo)){
						statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
						statusInfo.setPersonId(personInfo.getId());
					}	
				} catch (Exception e) {
					log.error("血吸虫病-监测登记保存失败。更新患者信息失败。" + e.getMessage());
					throw new RuntimeException("更新患者信息失败。", e);
				}
			}
        }
        if(ObjectUtil.isNotEmpty(schDto.getIdmId())){
        	idmId = Long.parseLong(schDto.getIdmId());
        	statusInfo.setId(idmId);
        }
        statusInfo.setIdmType(IdmType.SCHISTOSOME.getValue());//传染病类型
		statusInfo.setSpecialStatus(schDto.getSpecialStatus());//监测状态
		statusInfo.setCurrentUnit(schDto.getCaseInformation().getReportOrg());//for档案迁移
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		statusInfo.setLogoff(schDto.getLogoff());
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/		
        idmId = updateStatus(statusInfo);//新增或更新状态表，返回状态表ID
        statusInfo.setId(idmId);
        singleId = getSingleId(idmId.toString(), SpecialEvents.S_BlOOD.getValue(),false);
        if(singleId.equals(-1L)){
            //业务表唯一标识singleId与状态表关联
        	EventInfo eventInfo = new EventInfo();
            eventInfo.setStatusId(idmId);
            eventInfo.setEventId(Long.parseLong(SpecialEvents.S_BlOOD.getValue()));
            singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
        }
        updateOperate(schDto);
        result = saveBusiness(schDto,singleId);
        addLog(statusInfo,user);
        return result != 0?true:false;
    }
    
    /**
     * 设置更新时间
     *
     * @param schDto
     * @author Ye jianfei
     */
    private void updateOperate(SchistosomeDto schDto){
    	CaseInformation caseinformation = schDto.getCaseInformation();
    	if(ObjectUtil.isNullOrEmpty(caseinformation)){
    		return;
    	}
    	caseinformation.setModifyDt(new Date());//更新时间
    	caseinformation.setModifyUser(schDto.getCurrentUser().getId().toString());//更新人
    	caseinformation.setModifyUnit(schDto.getCurrentOrg().getOrganCode());//更新机构
    }
    /**
     * 查看监测登记
     * @param       singleId
     * @return      SchistosomeDto
     */
    public SchistosomeDto getRegister(String singleId){
    	SchistosomeDto result = new SchistosomeDto();

        Criteria ca = new Criteria("idmId",singleId);

        GeneralCondition generalCondition = generalConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(generalCondition)) {
            result.setGeneralCondition(generalCondition);
        }

        LabExamine LabExamine = labExamineDao.get(ca);
        if (ObjectUtil.isNotEmpty(LabExamine)) {
            result.setLabExamine(LabExamine);
        }

        CaseInformation caseInformation = caseInformationDao.get(ca);
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            result.setCaseInformation(caseInformation);
        }

        Criteria ca1 = new Criteria("id",singleId);
        Long idmId = eventInfoDao.get(ca1).getStatusId();
        result.setIdmId(idmId.toString());
        
        Criteria ca2 = new Criteria("id",idmId);
        IdmStatusInfo status = idmStatusInfoDao.get(ca2);
        if(ObjectUtil.isNotEmpty(status)){
        	result.setSpecialStatus(status.getSpecialStatus());
        	/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
        	result.setLogoff(status.getLogoff());
        	/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
        }
        result.setSingleId(singleId);
        return result;
    }
 
    /**
     * 分页查询个案调查
     * @param       criteria
     * @param       page
     * @return      PageList<IdmStatusInfo>
     */
	@Override
	public PageList<IdmStatusInfo> findCaseList(Criteria criteria, Page page) {
		PageList<IdmStatusInfo> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = idmStatusInfoDao.findSchCaseList(page, criteria);
		}
		return result;
	}
	
    /**
     * 查询个案调查
     * @param       criteria
     * @return      List<IdmStatusInfo>
     */
	@Override
	public List<IdmStatusInfo> findCaseList(Criteria criteria) {
		List<IdmStatusInfo> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = idmStatusInfoDao.findSchCaseList(criteria);
		}
		return result;
	}	
    /**
     * 保存个案调查
     * @param       schDto
     * @param       user
     * @param       eventId
     * @param       type
     * @return      boolean
     */
    @Transactional
    public boolean saveCase(SchistosomeDto schDto, User user, Long eventId, IdmType type){
        int result = 0;
        Long idmId = -1L;
        Long singleId = -1L;
        
        IdmStatusInfo statusInfo = new IdmStatusInfo();
        
        GeneralCondition generalCondition = schDto.getGeneralCondition();
        if (ObjectUtil.isNotEmpty(generalCondition)) {
			try {
				SavePerson(schDto);//调用接口新增或更新患者
				PersonInfo personInfo = schDto.getPersonInfo();
				if(ObjectUtil.isNotEmpty(personInfo)){
					statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
					statusInfo.setPersonId(personInfo.getId());
				}						
			} catch (Exception e) {
				log.error("血吸虫病-个案调查保存失败。更新患者信息失败。" + e.getMessage());
				throw new RuntimeException("更新患者信息失败。", e);
			}
        }
        if(ObjectUtil.isNotEmpty(schDto.getIdmId())){
        	idmId = Long.parseLong(schDto.getIdmId());
        	statusInfo.setId(idmId);
        }
        statusInfo.setIdmType(type.getValue());//传染病类型
		statusInfo.setSpecialStatus(SchStatus.WRITE.getValue());//个案已填写
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		statusInfo.setLogoff(schDto.getLogoff());
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
        idmId = updateStatus(statusInfo);//新增或更新状态表，返回状态表ID
        statusInfo.setId(idmId);
        singleId = getSingleId(idmId.toString(), SpecialEvents.S_CASE.getValue(),false);//是否已经填写过个案
        if(singleId.equals(-1L)){
            //业务表唯一标识singleId与状态表关联
        	EventInfo eventInfo = new EventInfo();
            eventInfo.setStatusId(idmId);
            eventInfo.setEventId(Long.parseLong(SpecialEvents.S_CASE.getValue()));
            singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
        }
        updateOperate(schDto);
        result = saveBusiness(schDto,singleId);
        addLog(statusInfo,user);
        return result != 0?true:false;
    }	 
 
	/* 
	 * 分页查询治疗记录
	 */
	@Override
	public PageList<ListRr> findAcographyList(String idmId, Page page) {
		PageList<ListRr> result = new PageList<ListRr>();
		if(StringUtil.isNotEmpty(idmId)){
			Criteria criteria = new Criteria("event.STATUS_ID",idmId);
			result = listRrDao.findAcographyList(page, criteria);
		}
		return result;
	}
    /**
     * 删除治疗记录
     * @param       singleId
     * @return      boolean
     */
    @Transactional
    public boolean deleteAcography(Long singleId){
    	 int result = 0;
    	 Criteria caBusiness = new Criteria("IDM_ID", singleId);
    	 Criteria caEvent = new Criteria("ID", singleId);
    	 if(ObjectUtil.isNotEmpty(singleId)){
    		 result += generalConditionDao.delete(caBusiness);
    		 result += pastHistoryDao.delete(caBusiness);
    		 result += clinicalManifestationsDao.delete(caBusiness);
    		 result += listRrDao.delete(caBusiness);
    		 result += eventInfoDao.delete(caEvent);
    	 }
    	 return result >0?true:false;
       	 
    }
    
	/**
     * 分页查询晚血病人列表
     * @param       idmId
     * @param		page
     * @return      PageList<IdmStatusInfo>
     */    
	public PageList<IdmStatusInfo> findAdvancedList(Criteria criteria, Page page){
		PageList<IdmStatusInfo> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = idmStatusInfoDao.findAdvancedList(page, criteria);
		}
		return result;		
	}

	/**
     * 查询晚血病人列表
     * @param       idmId
     * @return      List<IdmStatusInfo>
     */    
	public List<IdmStatusInfo> findAdvancedList(Criteria criteria){
		List<IdmStatusInfo> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			result = idmStatusInfoDao.findAdvancedList(criteria);
		}
		return result;		
	}
	
	/**
     * 分页查询调查记录列表
     * @param       idmId
     * @param		page
     * @return      PageList<CaseInformation>
     */ 	
	@Override
	public PageList<CaseInformation> findSurveyList(String idmId, Page page) {
		PageList<CaseInformation> result = new PageList<CaseInformation>();
		if(StringUtil.isNotEmpty(idmId)){
			Criteria criteria = new Criteria("STATUS_ID",idmId).add("EVENT_ID", SpecialEvents.S_ADVANCED_SURVEY.getValue());
			result = caseInformationDao.findSurveyList(page, criteria);
		}
		return result;
	}
    
	/**
     * 分页查询复查登记列表
     * @param       idmId
     * @param		page
     * @return      PageList<CaseInformation>
     */ 	
	@Override
	public PageList<CaseInformation> findReexamineList(String idmId, Page page) {
		PageList<CaseInformation> result = new PageList<CaseInformation>();
		if(StringUtil.isNotEmpty(idmId)){
			Criteria criteria = new Criteria("STATUS_ID",idmId).add("EVENT_ID", SpecialEvents.S_ADVANCED_REEXAMINE.getValue());
			result = caseInformationDao.findSurveyList(page, criteria);
		}
		return result;
	} 

	/**
     * 删除复查登记
     * @param       singleId
     * @return      boolean
     */
	@Override
    @Transactional
    public boolean deleteReexamine(Long singleId){
    	int result = 0;
    	Criteria caBusiness = new Criteria("IDM_ID", singleId);
    	Criteria caEvent = new Criteria("ID", singleId);
    	if(ObjectUtil.isNotEmpty(singleId)){
    		result += generalConditionDao.delete(caBusiness);
    		result += otherConditionDao.delete(caBusiness);
    		result += caseInformationDao.delete(caBusiness);
    		result += eventInfoDao.delete(caEvent);
    	}
    	return result >0?true:false;    	
    }	
	/**
     * 分页查询体检列表
     * @param       idmId
     * @param		page
     * @return      PageList<CaseInformation>
     */ 	
	@Override
	public PageList<CaseInformation> findMedicalList(String idmId, Page page) {
		PageList<CaseInformation> result = new PageList<CaseInformation>();
		if(StringUtil.isNotEmpty(idmId)){
			Criteria criteria = new Criteria("STATUS_ID",idmId).add("EVENT_ID", SpecialEvents.S_ADVANCED_MEDICAL.getValue());
			result = caseInformationDao.findSurveyList(page, criteria);
		}
		return result;
	}
	
	/**
     * 删除体检表
     * @param       singleId
     * @return      boolean
     */
	@Override
    @Transactional
    public boolean deleteMedical(Long singleId){
    	int result = 0;
    	Criteria caBusiness = new Criteria("IDM_ID", singleId);
    	Criteria caEvent = new Criteria("ID", singleId);
    	if(ObjectUtil.isNotEmpty(singleId)){
    		result += generalConditionDao.delete(caBusiness);
    		result += otherConditionDao.delete(caBusiness);
    		result += caseInformationDao.delete(caBusiness);
    		result += labExamineDao.delete(caBusiness);
    		result += clinicalManifestationsDao.delete(caBusiness);
    		result += eventInfoDao.delete(caEvent);
    	}
    	return result >0?true:false;    	
    }	
    /**
     * 血吸虫病保存
     * @param       schDto
     * @param       user
     * @return      boolean
     */
    @Transactional
    public boolean save(SchistosomeDto schDto, User user, SpecialEvents event){
        int result = 0;
        Long idmId = -1L;
        Long singleId = -1L;
        if(StringUtil.isNotEmpty(schDto.getSingleId())){
        	singleId = NumberUtil.convert(schDto.getSingleId(), Long.class);
        }
        
        IdmStatusInfo statusInfo = new IdmStatusInfo();
        
        GeneralCondition generalCondition = schDto.getGeneralCondition();
        if (ObjectUtil.isNotEmpty(generalCondition)) {
			try {
				SavePerson(schDto);//调用接口新增或更新患者
				PersonInfo personInfo = schDto.getPersonInfo();
				if(ObjectUtil.isNotEmpty(personInfo)){
					statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
					statusInfo.setPersonId(personInfo.getId());
				}					
			} catch (Exception e) {
				log.error("血吸虫病-" + getEventString(event) + "保存失败。更新患者信息失败。" + e.getMessage());
				throw new RuntimeException("更新患者信息失败。", e);
            }
        }
        if(ObjectUtil.isNotEmpty(schDto.getIdmId())){
        	idmId = Long.parseLong(schDto.getIdmId());
        	statusInfo.setId(idmId);
        }else{
        	log.error("血吸虫病-" + getEventString(event) + "保存失败。状态表Id（IdmId）为空。" );
        	throw new RuntimeException("保存失败。状态表Id（IdmId）为空。");
        }
        /*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
		statusInfo.setLogoff(schDto.getLogoff());
		/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
        idmId = updateStatus(statusInfo);//新增或更新状态表，返回状态表ID
        if(singleId.equals(-1L)){
            //业务表唯一标识singleId与状态表关联
        	EventInfo eventInfo = new EventInfo();
            eventInfo.setStatusId(idmId);
            eventInfo.setEventId(Long.parseLong(event.getValue()));
            singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
        }
        
        //晚血病人更新时，更新通过EXCEL导入的病人信息 add by yejianfei 20140325
        if(event.equals(SpecialEvents.S_ADVANCED_SURVEY)
        		|| event.equals(SpecialEvents.S_ADVANCED_CARD)
        		|| event.equals(SpecialEvents.S_ADVANCED_REEXAMINE)
        		|| event.equals(SpecialEvents.S_ADVANCED_MEDICAL)){
        	updateImportData(idmId.toString(),schDto.getGeneralCondition());
        }
        
        boolean bUpdate = true;
        if(event.equals(SpecialEvents.S_ADVANCED_REEXAMINE)){//更新管理卡中晚血分型及病情分类
        	 bUpdate = updateCard(idmId.toString(),schDto.getOtherCondition());
        }else if(event.equals(SpecialEvents.S_ADVANCED_CARD) || event.equals(SpecialEvents.S_ADVANCED_SURVEY)){
        	OtherCondition otherCondition= schDto.getOtherCondition();
        	String outcomeCode = otherCondition.getOutcomeCode();
        	if(outcomeCode.equals("1")){//如果转归为治愈，则更新状态表
        		bUpdate = endProcedure(idmId.toString());
        	}
        }
        
        if(bUpdate){
        	result = saveBusiness(schDto,singleId);
        }
        return result != 0?true:false;
    }  
 
    
    /**
     * 导入血吸虫病历史记录
     * @param       schDto
     * @return      Integer
     */
    @Override
    @Transactional
    public Integer importHistory(List<SchistosomeDto> schDtos){
    	Integer count = 0;
    	for(SchistosomeDto schDto:schDtos){
	    	Long eventId = buildStatusInfo(schDto);
	        updateOperate(schDto);
	        saveBusiness(schDto,eventId);
	        count++;
    	}
    	return count;
    }	 

    /**
     * 导入血吸虫病历史记录--生成状态及事件
     *
     * @param schDto
     * @return
     * @author Ye jianfei
     */
    private Long buildStatusInfo(SchistosomeDto schDto){
    	IdmStatusInfo statusInfo = new IdmStatusInfo();
    	buildPersonInfo(schDto,statusInfo);    	
    	statusInfo.setIdmType(IdmType.SCHISTOSOME_ADVANCED_IMPORT.getValue());//晚血历史数据导入
    	statusInfo.setSpecialStatus(SchStatus.WRITE.getValue());//个案已填写
    	statusInfo.setCurrentUnit(schDto.getCurrentOrg().getOrganCode());//导入机构编码
    	statusInfo.setLogoff(0);//默认注销状态为正常
    	Long statusId = updateStatus(statusInfo);//新增或更新状态表，返回状态表ID
    	return buildEventInfo(statusId);
    }
    
    /**
     * 导入血吸虫病历史记录--生成事件
     *
     * @param schDto
     * @return
     * @author Ye jianfei
     */
    private Long buildEventInfo(Long statusId){
    	EventInfo eventInfo = new EventInfo();
        eventInfo.setStatusId(statusId);
        eventInfo.setEventId(Long.parseLong(SpecialEvents.S_ADVANCED_ADVANCED_IMPORT.getValue()));
        Long eventId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
    	return eventId;
    }
    
    /**
     * 导入血吸虫病历史记录--更新状态表患者ID
     *
     * @param schDto
     * @return
     * @author Ye jianfei
     */
    private void buildPersonInfo(SchistosomeDto schDto, IdmStatusInfo statusInfo){
    	try {
			SavePerson(schDto);//调用接口新增或更新患者
			PersonInfo personInfo = schDto.getPersonInfo();
			if(ObjectUtil.isNotEmpty(personInfo)){
				statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
				statusInfo.setPersonId(personInfo.getId());
			}						
		} catch (Exception e) {
			log.error("血吸虫病-历史记录导入失败。更新患者信息失败。" + e.getMessage());
			throw new RuntimeException("更新患者信息失败。", e);
		}    
    }    
    
    
    /**
     * 血吸虫病业务数据获取,multiterm:表示该业务存在多条数据
     * @param       schDto
     * @param       user
     * @param		multiterm
     * @return      boolean
     */
	@Override
    public SchistosomeDto getBusiness(Long idmId, Long singleId, SpecialEvents event, boolean multiterm){
    	SchistosomeDto result = new SchistosomeDto();
    	if(ObjectUtil.isNotEmpty(idmId)){
    		result.setIdmId(idmId.toString());
    		if(ObjectUtil.isNullOrEmpty(singleId)){
            	singleId = getSingleId(idmId.toString(),event.getValue(),multiterm);
            }
    	}else{
    		singleId = -1L;
    	}
        if(!singleId.equals(-1L)){
	        Criteria ca = new Criteria("idmId",singleId);
	        result.setSingleId(singleId.toString());
	        GeneralCondition generalCondition = generalConditionDao.get(ca);
	        if (ObjectUtil.isNotEmpty(generalCondition)) {
	            result.setGeneralCondition(generalCondition);
	        }
	        OtherCondition otherCondition = otherConditionDao.get(ca);
	        if (ObjectUtil.isNotEmpty(otherCondition)) {
	            result.setOtherCondition(otherCondition);
	        }	
	        CaseInformation caseInformation = caseInformationDao.get(ca);
	        if (ObjectUtil.isNotEmpty(caseInformation)) {
	            result.setCaseInformation(caseInformation);
	        }
	        Diagnosis diagnosis = diagnosisDao.get(ca);
	        if (ObjectUtil.isNotEmpty(diagnosis)) {
	            result.setDiagnosis(diagnosis);
	        }
	        ClinicalManifestations clinicalManifestations =clinicalManifestationsDao.get(ca);
	        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
	            result.setClinicalManifestations(clinicalManifestations);
	        }
	        LabExamine labExamine = labExamineDao.get(ca);
	        if (ObjectUtil.isNotEmpty(labExamine)) {
	            result.setLabExamine(labExamine);
	        }
	        PastHistory pastHistory = pastHistoryDao.get(ca);
	        if (ObjectUtil.isNotEmpty(pastHistory)) {
	            result.setPastHistory(pastHistory);
	        }
	        ListRr listRr = listRrDao.get(ca);
	        if (ObjectUtil.isNotEmpty(listRr)) {
	            result.setListRr(listRr);
	        }
	        EpidemicFocusClose epidemicFocusClose = epidemicFocusCloseDao.get(ca);
	        if (ObjectUtil.isNotEmpty(epidemicFocusClose)) {
	            result.setEpidemicFocusClose(epidemicFocusClose);
	        }
        
	        //子表-治疗记录
	        List<ListRr> listRrs = listRrDao.getList(ca, new Order(("TREATMENT_DT"), false));
	        if (ObjectUtil.isNotEmpty(listRrs)) {
	            result.setListRrs(listRrs);
	        }
	        //子表-治疗记录
	        List<ListCr> listCrs = listCrDao.getList(ca, new Order("CHANGE_DT", false));
	        if (ObjectUtil.isNotEmpty(listCrs)) {
	            result.setListCrs(listCrs);
	        }
	        
	        Criteria caStatus = new Criteria("id",idmId);
	        IdmStatusInfo status = idmStatusInfoDao.get(caStatus);
	        if(ObjectUtil.isNotEmpty(status)){
	        	result.setSpecialStatus(status.getSpecialStatus());
	        	/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
	        	result.setLogoff(status.getLogoff());
	        	/*从健康档案获取人员信息时，判断注销状态。modify yjf 20131010*/
	        }	        
        }else{
        	switch (event){
        		case S_CASE:
        			initCase(result);
        			break;
        		case S_ACOGRAPHY:
        			initAcography(result);
        			break;
        		case S_ADVANCED_SURVEY:
        			initSurvey(result);
        			break;
        		case S_ADVANCED_CARD:
        			initCard(result);
        			break;
        		case S_ADVANCED_REEXAMINE:
        			initReexamine(result);
        			break;
        		case S_ADVANCED_MEDICAL:
        			initMedical(result);
        			break;
        	}
        }
        return result;
    }
    /**
     * 初始化复查登记表
     * @param       schDto
     * @return      void
     */   
    private void initReexamine(SchistosomeDto schDto){
    	/*如果是新建复查登记表，初始化基本信息数据*/
    	String idmId = schDto.getIdmId();
    	Long singleId = getSingleId(idmId, SpecialEvents.S_ADVANCED_CARD.getValue(),false);
    	Criteria ca = new Criteria("idmId",singleId);
        GeneralCondition gen = generalConditionDao.get(ca);
        if(ObjectUtil.isNotEmpty(gen)){
			gen.setId(null);
			schDto.setGeneralCondition(gen);
        }
        OtherCondition other = otherConditionDao.get(ca);
        if(ObjectUtil.isNotEmpty(other)){
        	other.setId(null);
        	schDto.setOtherCondition(other);
        }    	
    }
    /**
     * 初始化体检表
     * @param       schDto
     * @return      void
     */   
    private void initMedical(SchistosomeDto schDto){
    	/*如果是新建体检表，初始化基本信息数据*/
    	String idmId = schDto.getIdmId();
    	Long singleId = getSingleId(idmId, SpecialEvents.S_CASE.getValue(),false);
    	if(ObjectUtil.isNullOrEmpty(singleId) || Long.valueOf(-1L).equals(singleId)){
    		singleId = getSingleId(idmId, SpecialEvents.S_ADVANCED_ADVANCED_IMPORT.getValue(),false);
    	}    	
    	Criteria ca = new Criteria("idmId",singleId);
        GeneralCondition gen = generalConditionDao.get(ca);
        if(ObjectUtil.isNotEmpty(gen)){
			gen.setId(null);
			//获取健康档案编号
			String idcard = gen.getIdcard();
			if(StringUtil.isNotEmpty(idcard)){
				PersonInfo personInfo = haInterfaceService.queryPersonalInfo("",idcard);
				if(ObjectUtil.isNotEmpty(personInfo)){
					gen.setHealthFileNo(personInfo.getHealthFileNo());
		        }					
			}
			schDto.setGeneralCondition(gen);
        }
        OtherCondition other = otherConditionDao.get(ca);
        if(ObjectUtil.isNotEmpty(other)){
        	other.setId(null);
        	schDto.setOtherCondition(other);
        }

        
    }    
    /**
     * 初始化管理卡
     * @param       schDto
     * @return      void
     */   
    private void initCard(SchistosomeDto schDto){
    	/*如果是新建管理卡，初始化基本信息数据*/
    	String idmId = schDto.getIdmId();
    	Long singleId = getSingleId(idmId, SpecialEvents.S_ADVANCED_SURVEY.getValue(),false);
    	Criteria ca = new Criteria("idmId",singleId);
        GeneralCondition gen = generalConditionDao.get(ca);
        if(ObjectUtil.isNotEmpty(gen)){
	        String idcard = gen.getIdcard();
			PersonInfo person = haInterfaceService.queryPersonalInfo(null, idcard);
            if(ObjectUtil.isNotEmpty(person)){
                gen.setHrtownShip(person.getHrtownShip());
			    gen.setHrstreet(person.getHrstreet());
			    gen.setHrhouseNumber(person.getHrhouseNumber());
            }
			gen.setId(null);
			schDto.setGeneralCondition(gen);
        }
        OtherCondition otherCondition = otherConditionDao.get(ca);
        if(ObjectUtil.isNotEmpty(otherCondition)){
        	schDto.setOtherCondition(otherCondition);
        	otherCondition.setId(null);
        }
        Diagnosis diagnosis = diagnosisDao.get(ca);
        if(ObjectUtil.isNotEmpty(diagnosis)){
        	schDto.setDiagnosis(diagnosis);
        	diagnosis.setId(null);
        }    	
    }
    /**
     * 初始化调查表
     * @param       schDto
     * @return      void
     */   
    private void initSurvey(SchistosomeDto schDto){
    	/*如果是新建调查表，初始化基本信息数据*/
    	String idmId = schDto.getIdmId();
    	Long singleId = getSingleId(idmId, SpecialEvents.S_CASE.getValue(),false);
    	if(ObjectUtil.isNullOrEmpty(singleId) || Long.valueOf(-1L).equals(singleId)){
    		singleId = getSingleId(idmId, SpecialEvents.S_ADVANCED_ADVANCED_IMPORT.getValue(),false);
    	}
    	Criteria ca = new Criteria("idmId",singleId);
        GeneralCondition gen = generalConditionDao.get(ca);
        if(ObjectUtil.isNotEmpty(gen)){
	        String idcard = gen.getIdcard();
			PersonInfo person = haInterfaceService.queryPersonalInfo(null, idcard);
            if(ObjectUtil.isNotEmpty(person)){
                gen.setHrtownShip(person.getHrtownShip());
			    gen.setHrstreet(person.getHrstreet());
			    gen.setHrhouseNumber(person.getHrhouseNumber());
            }
			gen.setId(null);
			schDto.setGeneralCondition(gen);
        }   	
    } 
    /**
     * 初始化治疗记录
     * @param       schDto
     * @return      void
     */   
    private void initAcography(SchistosomeDto schDto){
    	/*如果是新建治疗记录，初始化基本信息数据*/
    	String idmId = schDto.getIdmId();
    	Long singleId = getSingleId(idmId, SpecialEvents.S_CASE.getValue(),false);
    	Criteria ca = new Criteria("idmId",singleId);
        GeneralCondition gen = generalConditionDao.get(ca);
        if(ObjectUtil.isNotEmpty(gen)){
            String idcard = gen.getIdcard();
    		PersonInfo person = haInterfaceService.queryPersonalInfo(null, idcard);
            if(ObjectUtil.isNotEmpty(person)){
                gen.setHrtownShip(person.getHrtownShip());
    		    gen.setHrstreet(person.getHrstreet());
    		    gen.setHrhouseNumber(person.getHrhouseNumber());
            }
    		gen.setId(null);
    		schDto.setGeneralCondition(gen);
        }   	
    }  
    /**
     * 初始化个案调查
     * @param       schDto
     * @return      void
     */   
    private void initCase(SchistosomeDto schDto){
    	/*如果未进行个案调查，初始化基本信息数据*/
    	String idmId = schDto.getIdmId();
    	Long singleId = getSingleId(idmId, SpecialEvents.S_BlOOD.getValue(),false);
    	Criteria ca = new Criteria("idmId",singleId);
        GeneralCondition gen = generalConditionDao.get(ca);
        if(ObjectUtil.isNotEmpty(gen)){
            String idcard = gen.getIdcard();
    		PersonInfo person = haInterfaceService.queryPersonalInfo(null, idcard);
            if(ObjectUtil.isNotEmpty(person)){
                gen.setHrtownShip(person.getHrtownShip());
                gen.setHrstreet(person.getHrstreet());
                gen.setHrhouseNumber(person.getHrhouseNumber());
            }
            gen.setId(null);
    		schDto.setGeneralCondition(gen);
        }
        Diagnosis diagnosis = new Diagnosis();
    	diagnosis.setDiagnosisUnit(EHRConstants.JK_CODE);//默认疾控中心
    	diagnosis.setTransferTreatmentAccording("4");

    	CaseInformation registerCaseInfo = caseInformationDao.get(ca);
    	CaseInformation caseInformation = new CaseInformation();
    	if(ObjectUtil.isNotEmpty(registerCaseInfo)){//设置监测登记单位
    		caseInformation.setReportOrg(registerCaseInfo.getReportOrg());
    	}
    	schDto.setCaseInformation(caseInformation);
    	schDto.setDiagnosis(diagnosis);	
    }    

    /**
     * 更新管理卡中晚血分型及病情分类
     * @param       idmId
     * @param       other
     * @return      boolean
     */
    private boolean updateCard(String idmId, OtherCondition other){
    	int result = 0;
    	Long singleId = getSingleId(idmId, SpecialEvents.S_ADVANCED_CARD.getValue(),false);
    	if(ObjectUtil.isNotEmpty(singleId)){
    		Criteria ca = new Criteria("IDM_ID", singleId);
    		Parameters parameters = new Parameters();
     		String classifyAccording = other.getClassifyAccordingLast();
    		String caseType = other.getCaseTypeLast();
    		if(StringUtil.isNotEmpty(classifyAccording)){
    			parameters.add("CLASSIFY_ACCORDING", classifyAccording);
    		}
    		if(StringUtil.isNotEmpty(caseType)){
    			parameters.add("CASE_TYPE", caseType);
    		}
    		result = otherConditionDao.update(parameters,ca);
    	}
    	return result != 0?true:false;
    }
  
    /**
     * 更新导入的晚血病人信息
     * @param       idmId
     * @param       gen
     * @return      
     */
    private void updateImportData(String idmId, GeneralCondition gen){
    	Long singleId = getSingleId(idmId, SpecialEvents.S_ADVANCED_ADVANCED_IMPORT.getValue(),false);
    	if(!"-1".equals(singleId)){
    		Criteria ca = new Criteria("IDM_ID", singleId);
    		
			if(StringUtil.isNotEmpty(gen.getFloatPopulation())){
	            //存地址
				gen.setPaAddress(gen.getFloatPopulation().equalsIgnoreCase("1")
	                    ? dictionaryApp.queryDicItemName("FS990001", gen.getPatownShip()) + dictionaryApp.queryDicItemName("FS990001", gen.getPastreet()) + gen.getPahouseNumber()
	                    : gen.getPahouseNumber());
			}
    		Parameters parameters = new Parameters();
    		if(ObjectUtil.isNotEmpty(gen.getBirthday())){
    			parameters.add("BIRTHDAY", gen.getBirthday());
    		}
    		if(StringUtil.isNotEmpty(gen.getAge())){
    			parameters.add("AGE", gen.getAge());
    		}
    		if(StringUtil.isNotEmpty(gen.getAgeUnit())){
    			parameters.add("AGE_UNIT", gen.getAgeUnit());
    		}
    		if(StringUtil.isNotEmpty(gen.getOccupation())){
    			parameters.add("OCCUPATION", gen.getOccupation());
    		}
    		if(StringUtil.isNotEmpty(gen.getEducation())){
    			parameters.add("EDUCATION", gen.getEducation());
    		}
    		if(StringUtil.isNotEmpty(gen.getPatownShip())){
    			parameters.add("PATOWN_SHIP", gen.getPatownShip());
    		}
    		if(StringUtil.isNotEmpty(gen.getPastreet())){
    			parameters.add("PASTREET", gen.getPastreet());
    		}
    		if(StringUtil.isNotEmpty(gen.getPahouseNumber())){
    			parameters.add("PAHOUSE_NUMBER", gen.getPahouseNumber());
    		}
    		if(StringUtil.isNotEmpty(gen.getPaAddress())){
    			parameters.add("PA_ADDRESS", gen.getPaAddress());
    		}
    		if(StringUtil.isNotEmpty(gen.getPhoneNumber())){
    			parameters.add("PHONE_NUMBER", gen.getPhoneNumber());
    		} 
    		generalConditionDao.update(parameters,ca);
    	}
    }
    /**
     * 如果管理卡中，转归为：治愈
     * 则更新状态表状态
     * @param       idmId
     * @return      boolean
     */
    private boolean endProcedure(String idmId){
    	int result = 0;
    	if(StringUtil.isNotEmpty(idmId)){
    		Criteria ca = new Criteria("ID", idmId);
    		Parameters parameters = new Parameters();
    		parameters.add("SPECIAL_STATUS", SchStatus.CURE.getValue());
    		result = idmStatusInfoDao.update(parameters,ca);
    	}
    	return result != 0?true:false;
    	
    }
    private String getEventString(SpecialEvents event){
    	String result="";
    	switch(event){
    		case S_BlOOD:
    			result = "监测登记";
    			break;
    		case S_CASE:
    			result = "个案调查";
    			break;
    		case S_ACOGRAPHY:
    			result = "治疗记录";
    			break;
    		case S_ADVANCED_SURVEY:
    			result = "晚血病人调查表";
    			break;
    		case S_ADVANCED_CARD:
    			result = "晚血病人管理卡";
    			break;
    		case S_ADVANCED_REEXAMINE:
    			result = "晚血病人复查登记";
    			break;    			
    	}
    	return result;
    }
    private Long getSingleId(String idmId, String eventId, boolean multiterm){
        Long singleId = -1L;
        if(!multiterm){
	        Criteria eventCa = new Criteria("eventId", eventId).add("statusId", idmId);
	        EventInfo eventInfo = eventInfoDao.get(eventCa);
	        if(ObjectUtil.isNotEmpty(eventInfo)){
	            singleId = eventInfo.getId();
	        }
        }
        return singleId;
    }
    /**
     * 删除治疗记录
     * @param       singleId
     * @return      boolean
     */
    @Transactional
    public boolean deleteSurvey(Long singleId){
    	int result = 0;
    	Criteria caBusiness = new Criteria("IDM_ID", singleId);
    	Criteria caEvent = new Criteria("ID", singleId);
    	if(ObjectUtil.isNotEmpty(singleId)){
    		result += generalConditionDao.delete(caBusiness);
    		result += pastHistoryDao.delete(caBusiness);
    		result += clinicalManifestationsDao.delete(caBusiness);
    		result += otherConditionDao.delete(caBusiness);
    		result += caseInformationDao.delete(caBusiness);
    		result += labExamineDao.delete(caBusiness);
    		result += diagnosisDao.delete(caBusiness);
    		result += eventInfoDao.delete(caEvent);
    	}

    	return result >0?true:false;    	
    }
 
    /**
     * 批量审批
     * @param       singleIds
     * @param       status
     * @param       user
     * @return      boolean
     */
    @Transactional
    public boolean batchApproval(String[]singleIds, SchStatus status, User user){
    	int result = 0;
		IdmStatusInfo statusInfo = new IdmStatusInfo();
		statusInfo.setIdmType(IdmType.SCHISTOSOME.getValue());
		statusInfo.setSpecialStatus(status.getValue());
		
		List<Long> ids = new ArrayList<Long>();
		for(String singleId:singleIds){
			Long id = getStatusId(singleId);
			ids.add(id);
			statusInfo.setId(NumberUtil.convert(id,Long.class));
			addLog(statusInfo,user);
		}
		Criteria caStatus = new Criteria("ID", OP.IN,ids.toArray());
		Parameters paraStatus = new Parameters();
		paraStatus.add("SPECIAL_STATUS", status.getValue());
		result = idmStatusInfoDao.update(paraStatus, caStatus);
    	return result >0?true:false;  
    }
 
	/**
	 * 获取患者ID
	 * @param idmId
	 * @return 患者ID
	 */
	public Long getPersonId(Long idmId) {
		IdmStatusInfo statusInfo = null;
		Long personId = null;
		if(ObjectUtil.isNotEmpty(idmId)){
			statusInfo = idmStatusInfoDao.get(idmId);
		}
		if(ObjectUtil.isNotEmpty(statusInfo)){
			personId = statusInfo.getPersonId();
		}
		return personId;
	}
    /*
     * 根据ID获取STATUS_ID
     * 查询IDM_EVENT_INFO
     * */
    private Long getStatusId(String singleId){
    	Long idmId = -1L;
    	Long id = NumberUtil.convert(singleId, Long.class);
        EventInfo eventInfo = eventInfoDao.get(id);
        if(ObjectUtil.isNotEmpty(eventInfo)){
        	idmId = eventInfo.getStatusId();
        }
        return idmId;
    }     
	/**
	 * 保存患者信息
	 * @param schDto
	 * @return
	 * @throws Exception
	 */
	private String SavePerson(SchistosomeDto schDto) throws Exception {
		String result;
		String[] param = schDto.getPersonInfoParam();
		PersonInfo personInfo = schDto.getPersonInfo();
		
		if(ObjectUtil.isNotEmpty(param)){
			result = haInterfaceService.updatePersonInfo(personInfo,param);
		}else{
			result = haInterfaceService.updatePersonInfo(personInfo);
		}
		schDto.setPersonInfo(personInfo);
		return result;
	} 
	
	/**
	 * 新增或状态记录
	 * @param statusInfo
	 * @return
	 */
	private Long updateStatus(IdmStatusInfo statusInfo) {
		Long idmId = statusInfo.getId();
		if(ObjectUtil.isNotEmpty(idmId)){
			idmStatusInfoDao.updateStatus(statusInfo, new Criteria("ID",statusInfo.getId()));
		}else{
			if(StringUtil.isNotEmpty(statusInfo.getPixId())&&statusInfo.getPixId().equals("-1")){
				statusInfo.setPixId(null);
			}
			idmId = idmStatusInfoDao.generatedKey(statusInfo, "ID",null).longValue();
		}
		return idmId;
	}
	
	/**
	 * 新增日志记录
	 * @param statusInfo
	 * @return
	 */
	private int addLog(IdmStatusInfo statusInfo, User user) {
		IdmApprovalInfo approvalInfo = new IdmApprovalInfo();
		approvalInfo.setApprovalDate(new Date());
		String Comments = "";
		switch (statusInfo.getSpecialStatus()){
			case 1:
				Comments ="监测登记";
				break;
			case 2:
				Comments ="排除";
				break;
			case 3:
				Comments ="防保科审核通过";
				break;
			case 4:
				Comments ="疾控审核通过";
				break;
			case 5:
				Comments ="个案填写";
				break;				
		}
		approvalInfo.setComments(Comments);
		approvalInfo.setIdmId(statusInfo.getId());
		approvalInfo.setStatus(statusInfo.getSpecialStatus().toString());
		approvalInfo.setUserId(user.getId().toString());
		approvalInfo.setUserName(user.getName());
		approvalInfo.setUnitCode(user.getLastLoginOrg().toString());
		return approvalService.createApprovalInfo(approvalInfo);
	}	
    
    /*更新业务表*/
    private int  saveBusiness(SchistosomeDto schDto, Long singleId){
    	int result = 0;

    	GeneralCondition generalCondition = schDto.getGeneralCondition();
    	if(ObjectUtil.isNotEmpty(generalCondition)){
    		generalCondition.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(generalCondition.getId())){
        		result = generalConditionDao.insert(generalCondition);
        	}else{
        		result = generalConditionDao.update(generalCondition);
        	}
    	}

    	PastHistory pastHistory = schDto.getPastHistory();
    	if(ObjectUtil.isNotEmpty(pastHistory)){
    		pastHistory.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(pastHistory.getId())){
        		result = pastHistoryDao.insert(pastHistory);
        	}else{
        		result = pastHistoryDao.update(pastHistory);
        	}
    	}
    	
    	LabExamine labExamine = schDto.getLabExamine();
    	if(ObjectUtil.isNotEmpty(labExamine)){
    		labExamine.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(labExamine.getId())){
        		result = labExamineDao.insert(labExamine);
        	}else{
        		result = labExamineDao.update(labExamine);
        	}
    	}
    	
    	CaseInformation caseInformation = schDto.getCaseInformation();
    	if(ObjectUtil.isNotEmpty(caseInformation)){
    		caseInformation.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(caseInformation.getId())){
        		result = caseInformationDao.insert(caseInformation);
        	}else{
        		result = caseInformationDao.update(caseInformation);
        	}
    	}
    	
    	ClinicalManifestations clinicalManifestations = schDto.getClinicalManifestations();
    	if(ObjectUtil.isNotEmpty(clinicalManifestations)){
    		clinicalManifestations.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(clinicalManifestations.getId())){
        		result = clinicalManifestationsDao.insert(clinicalManifestations);
        	}else{
        		result = clinicalManifestationsDao.update(clinicalManifestations);
        	}
    	}
    	
    	Diagnosis diagnosis = schDto.getDiagnosis();
    	if(ObjectUtil.isNotEmpty(diagnosis)){
    		diagnosis.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(diagnosis.getId())){
        		result = diagnosisDao.insert(diagnosis);
        	}else{
        		result = diagnosisDao.update(diagnosis);
        	}
    	}
    	
    	EpidemicFocusClose epidemicFocusClose = schDto.getEpidemicFocusClose();
    	if(ObjectUtil.isNotEmpty(epidemicFocusClose)){
    		epidemicFocusClose.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(epidemicFocusClose.getId())){
        		result = epidemicFocusCloseDao.insert(epidemicFocusClose);
        	}else{
        		result = epidemicFocusCloseDao.update(epidemicFocusClose);
        	}
    	}
    	
    	OtherCondition otherCondition = schDto.getOtherCondition();
    	if(ObjectUtil.isNotEmpty(otherCondition)){
    		otherCondition.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(otherCondition.getId())){
        		result = otherConditionDao.insert(otherCondition);
        	}else{
        		result = otherConditionDao.update(otherCondition);
        	}
    	}
    	
    	ListRr listRr = schDto.getListRr();
    	if(ObjectUtil.isNotEmpty(listRr)){
    		listRr.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(listRr.getId())){
        		result = listRrDao.insert(listRr);
        	}else{
        		result = listRrDao.update(listRr);
        	}
    	}
    	Criteria ca = new Criteria("idmId", singleId);
        List<ListCr> listCrs = schDto.getListCrs();

        if (ObjectUtil.isNotEmpty(listCrs)) {
            for(ListCr cr:listCrs){
            	cr.setIdmId(singleId);
            }        	
            listCrDao.delete(ca);
            listCrDao.batchInsert(listCrs);
        }
        List<ListRr> listRrs = schDto.getListRrs();
        if (ObjectUtil.isNotEmpty(listRrs)) {
            for(ListRr rr:listRrs){
            	rr.setIdmId(singleId);
            }
            listRrDao.delete(ca);
            listRrDao.batchInsert(listRrs);
        }        
    	return result;
    }
}