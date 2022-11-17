/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.*;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.repository.control.idm.special.*;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.dto.LeprosySaveDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 结核病service 
 * @author Jiang Haiying
 */
@Service("leprosyService")
public class LeprosyServiceImpl extends AbstractService implements ILeprosyService {

	@Resource(name = "idmStatusInfoDao")
	private IIdmStatusInfoDao idmStatusInfoDao;     //状态表

    @Resource(name = "eventInfoDao")
    private IEventInfoDao eventInfoDao;     //关联表

    @Resource(name = "generalConditionDao")
    private IGeneralConditionDao generalConditionDao;    //一般情况

    @Resource(name = "attackConditionDao")
    private IAttackConditionDao attackConditionDao;     //发病情况

    @Resource(name = "labExamineDao")
    private ILabExamineDao labExamineDao;     //实验室检查

    @Resource(name = "pastHistoryDao")
    private IPastHistoryDao pastHistoryDao;     //既往史

    @Resource(name = "clinicalManifestationsDao")
    private IClinicalManifestationsDao clinicalManifestationsDao;     //主要临床表现

    @Resource(name = "otherConditionDao")
    private IOtherConditionDao otherConditionDao;     //其他
    
    @Resource(name = "diagnosisDao")
    private IDiagnosisDao diagnosisDao;      //诊断依据、诊断结果
    
    @Resource(name = "epidemicFocusCloseDao")
    private IEpidemicFocusCloseDao epidemicFocusCloseDao;      //暴露史
    
    @Resource(name = "caseInformationDao")
    private ICaseInformationDao caseInformationDao;     //卡片信息

	@Resource(name = "haInterfaceService")
	private IHaInterfaceService haInterfaceService;
	
    @Resource(name = "idmListFrDao")
    private IListFrDao idmListFrDao;     //访视记录
    
    @Resource(name = "idmListCcDao")
    private IListCcDao idmListCcDao;
    
    @Resource(name = "idmLaborCapacityDao")
    private ILaborCapacityDao idmLaborCapacityDao;
    
    @Resource(name = "idmListCmDao")
    private IListCmDao idmListCmDao;
    
	/**
	 * 查询结核病列表  专用病历 管理卡
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<IdmStatusInfo> findSuspectedList(Page page, Criteria criteria, Order order) {
		PageList<IdmStatusInfo> result = null;
		if(ObjectUtil.isNotEmpty(page)){
			result = idmStatusInfoDao.findLeprosyList(page, criteria, order);
		}
		return result;
	}
	
	/**
	 * 更新专项状态
	 * @param idmId
	 * @param specialStatus
	 * @return
	 */
	public int updateSpecialStatus(Long idmId, String specialStatus) {
		if(StringUtil.isNullOrEmpty(specialStatus) || idmId < 1l){
			return -1;
		}
		return idmStatusInfoDao.update(new Parameters("SPECIAL_STATUS", specialStatus), new Criteria("ID",idmId));
	}
	
	/**
     * 添加
     * @param       leprosySaveDto
     * @param       statusInfo
     * @return      int
     */
    @Transactional
    public boolean saveLeprosySaveDto(LeprosySaveDto leprosySaveDto, Long eventId, String type) throws Exception {
        Long singleId = -1L;
        
        if(leprosySaveDto.getSingleId() !=null && leprosySaveDto.getSingleId() > 0l){
        	singleId = leprosySaveDto.getSingleId();
        }
        singleId = this.saveGeneralCondition(leprosySaveDto, singleId, eventId, type);

        AttackCondition attackCondition = leprosySaveDto.getAttackCondition();
        if (ObjectUtil.isNotEmpty(attackCondition)) {
            attackCondition.setIdmId(singleId);
            attackConditionDao.insert(attackCondition);
        }

        LabExamine LabExamine = leprosySaveDto.getLabExamine();
        if (ObjectUtil.isNotEmpty(LabExamine)) {
            LabExamine.setIdmId(singleId);
            labExamineDao.insert(LabExamine);
        }

        PastHistory pastHistory = leprosySaveDto.getPastHistory();
        if (ObjectUtil.isNotEmpty(pastHistory)) {
            pastHistory.setIdmId(singleId);
            pastHistoryDao.insert(pastHistory);
        }

        ClinicalManifestations clinicalManifestations = leprosySaveDto.getClinicalManifestations();
        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
            clinicalManifestations.setIdmId(singleId);
            clinicalManifestationsDao.insert(clinicalManifestations);
        }

        OtherCondition otherCondition = leprosySaveDto.getOtherCondition();
        if (ObjectUtil.isNotEmpty(otherCondition)) {
            otherCondition.setIdmId(singleId);
            otherConditionDao.insert(otherCondition);
        }
        
        Diagnosis diagnosis = leprosySaveDto.getDiagnosis();
        if (ObjectUtil.isNotEmpty(diagnosis)) {
            diagnosis.setIdmId(singleId);
            diagnosisDao.insert(diagnosis);
        }
        
        EpidemicFocusClose epidemicFocusClose = leprosySaveDto.getEpidemicFocusClose();
        if (ObjectUtil.isNotEmpty(epidemicFocusClose)) {
        	epidemicFocusClose.setIdmId(singleId);
        	epidemicFocusCloseDao.insert(epidemicFocusClose);
        }
        
        CaseInformation caseInformation = leprosySaveDto.getCaseInformation();
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            caseInformation.setIdmId(singleId);
            caseInformationDao.insert(caseInformation);
        }
        LaborCapacity laborCapacity = leprosySaveDto.getLaborCapacity();
        if (ObjectUtil.isNotEmpty(laborCapacity)) {
        	laborCapacity.setIdmId(singleId);
        	idmLaborCapacityDao.insert(laborCapacity);
        }
        List<ListCm> listCms = leprosySaveDto.getListCms();
        if (ObjectUtil.isNotEmpty(listCms)) {
        	if(!"update".equals(type)) {
            	for(ListCm listCm : listCms) {
            		listCm.setIdmId(singleId);
            	}
            }
        	idmListCmDao.batchInsert(listCms);
        }
        return true;
    }
    
    /**
     * 修改
     * @param       malariaDto
     * @param       statusInfo
     * @return      int
     */
    @Transactional
    public boolean updateLeprosySaveDto(LeprosySaveDto leprosySaveDto) throws Exception {
        boolean result = false;
        deleteLeprosy(leprosySaveDto.getSingleId());
        saveLeprosySaveDto(leprosySaveDto, leprosySaveDto.getEventId(),"update");
        result = true;
        return result;
    }

    /**
     * 删除
     * @param       singleIdStr
     * @return      int
     */
    @Transactional
    public boolean deleteLeprosySaveDto(Long singleId, Long idmId){
        boolean result = false;
        
        eventInfoDao.delete(singleId);
        this.deleteLeprosy(singleId);
        
        result = true;
        return result;
    }

    @Transactional
    private void deleteLeprosy(Long singleId){
    	
    	Criteria ca = new Criteria("idmId", singleId);
    	generalConditionDao.delete(ca);

        attackConditionDao.delete(ca);

        labExamineDao.delete(ca);

        pastHistoryDao.delete(ca);

        clinicalManifestationsDao.delete(ca);

        otherConditionDao.delete(ca);

        diagnosisDao.delete(ca);
        
        epidemicFocusCloseDao.delete(ca);
        
        caseInformationDao.delete(ca);
        
        idmLaborCapacityDao.delete(ca);
        
        idmListCmDao.delete(ca);
    }
    /**
     * 查看
     * @param       singleId
     * @return      MalariaDto
     */
    public LeprosySaveDto getLeprosySaveDto(String singleId){
    	LeprosySaveDto result = new LeprosySaveDto();
        Criteria ca = new Criteria("idmId",singleId);

        GeneralCondition generalCondition = generalConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(generalCondition)) {
            result.setGeneralCondition(generalCondition);
        }

        AttackCondition attackCondition = attackConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(attackCondition)) {
            result.setAttackCondition(attackCondition);
        }

        LabExamine LabExamine = labExamineDao.get(ca);
        if (ObjectUtil.isNotEmpty(LabExamine)) {
            result.setLabExamine(LabExamine);
        }

        PastHistory pastHistory = pastHistoryDao.get(ca);
        if (ObjectUtil.isNotEmpty(pastHistory)) {
            result.setPastHistory(pastHistory);
        }
        ClinicalManifestations clinicalManifestations =clinicalManifestationsDao.get(ca);
        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
            result.setClinicalManifestations(clinicalManifestations);
        }

        OtherCondition otherCondition = otherConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(otherCondition)) {
            result.setOtherCondition(otherCondition);
        }

        Diagnosis diagnosis = diagnosisDao.get(ca);
        if (ObjectUtil.isNotEmpty(diagnosis)) {
            result.setDiagnosis(diagnosis);
        }
        
        EpidemicFocusClose epidemicFocusClose = epidemicFocusCloseDao.get(ca);
        if (ObjectUtil.isNotEmpty(epidemicFocusClose)) {
            result.setEpidemicFocusClose(epidemicFocusClose);
        }
        
        CaseInformation caseInformation = caseInformationDao.get(ca);
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            result.setCaseInformation(caseInformation);
        }
        
        LaborCapacity laborCapacity = idmLaborCapacityDao.get(ca);
        if (ObjectUtil.isNotEmpty(laborCapacity)) {
            result.setLaborCapacity(laborCapacity);
        }
        List<ListCm> listCms = idmListCmDao.getList(ca);
        
        if (ObjectUtil.isNotEmpty(listCms)) {
            result.setListCms(listCms);
        }
        
        getEvenInfo(result, singleId);
        return result;
    }

    /**
     * 查询随访
     * @param ca
     * @return
     */
    public List<ListFr> getFrList(Criteria ca, Order od){
        return idmListFrDao.getList(ca, od);
    }

    public PageList<ListFr> getFrList(Page page, Criteria criteria, Order od){
        return idmListFrDao.getPageList(page, criteria, od);
    }

    /**
     * 添加随访
     * @param listFr
     * @return
     */
    public void saveFr(ListFr listFr, String userId){
        Long id = idmListFrDao.generatedKey(listFr, "id",null).longValue();
        List<ListCc> listCcs= listFr.getListCcs();
        this.insertListCc(listCcs, id);
        updateReviewResult(listFr, userId);
    }

    /**
     * 修改随访
     * @param listFr
     * @return
     */
    public void updateFr(ListFr listFr, String userId){
        idmListFrDao.update(listFr);
        List<ListCc> listCcs= listFr.getListCcs();
       this.insertListCc(listCcs, listFr.getId());
        updateReviewResult(listFr, userId);
    }

    /**
     * 保存随访中的字表密切接触者
     * @param listCcs
     * @param listFrId
     */
    private void insertListCc(List<ListCc> listCcs, Long listFrId) {
    	 if(ObjectUtil.isNotEmpty(listCcs)) {
         	for(ListCc listcc : listCcs) {
         		listcc.setFollowupId(listFrId);
         		listcc.setIdmId(0l);
         	}
         }
         idmListCcDao.delete(new Criteria("FOLLOWUP_ID", listFrId));
         idmListCcDao.batchInsert(listCcs);
    }
    
    /**
     * 根据随访的结果判断是否修改其疑似上报中诊断的信息  只有为排除 和确诊时才进行更新
     * @param listFr
     * @param userId
     */
    private void updateReviewResult(ListFr listFr, String userId) {
		Long idmId = listFr.getIdmId();
		CaseInformation caseInformation = caseInformationDao.get(new Criteria("idm_id", idmId));
		if(StringUtils.isNotEmpty(listFr.getDiagnosis()) && !StringUtils.equals(listFr.getDiagnosis(), "7")) {
			caseInformation.setReviewResult(listFr.getDiagnosis());
			caseInformation.setReviewDt(new Date());
			caseInformation.setReviewUser(userId);
			caseInformationDao.update(caseInformation);
		} 
	}
    
    /**
     * 删除随访
     * @param id
     * @return
     */
    public void deleteFr(Long id){
        idmListFrDao.delete(id);
    }

    /**
     * 获取随访
     * @param id
     * @return
     */
    public ListFr getFr(Long id){
    	ListFr listFr = idmListFrDao.get(id);
    	listFr.setListCcs(idmListCcDao.getList(new Criteria("FOLLOWUP_ID", id)));
        return listFr;
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
			if(statusInfo.getPixId().equals("-1")){
				statusInfo.setPixId(null);
			}
			idmId = idmStatusInfoDao.generatedKey(statusInfo, "ID",null).longValue();
		}
		return idmId;
	}
	
    /**
	 * 保存患者信息
	 * @param leprosySaveDto
	 * @return
	 * @throws Exception
	 */
	private PersonInfo savePerson(LeprosySaveDto leprosySaveDto) throws Exception {
		PersonInfo personInfo = leprosySaveDto.getPersonInfo();
		haInterfaceService.updatePersonInfo(personInfo);
		return personInfo;
	}
	
	/**
	 * 处理患者的基本信息
	 * @param leprosySaveDto
	 * @param statusInfo
	 * @param singleId
	 * @param idmId
	 * @param eventId
	 * @param type
	 * @return
	 * @throws Exception
	 */
	private Long saveGeneralCondition(LeprosySaveDto leprosySaveDto, Long singleId, Long eventId, String type) throws Exception {
		PersonInfo personInfo = null;
		IdmStatusInfo statusInfo = this.getIdmStatusInfo(leprosySaveDto, type);
		Long idmId = statusInfo.getId();
		GeneralCondition generalCondition = leprosySaveDto.getGeneralCondition();
        if (ObjectUtil.isNotEmpty(generalCondition)) {
        	personInfo = savePerson(leprosySaveDto);//调用接口新增或更新患者
        	if(ObjectUtil.isNotEmpty(personInfo)){
        		statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
        		statusInfo.setPersonId(personInfo.getId());
        	}
	        idmId = updateStatus(statusInfo);//新增或更新状态表，返回状态表ID

            if(!"update".equals(type)){
                //业务表唯一标识singleId与状态表关联
                EventInfo eventInfo = new EventInfo();
                eventInfo.setStatusId(idmId);
                eventInfo.setEventId(eventId);
                singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
            }

            statusInfo.setId(singleId);
            generalCondition.setIdmId(singleId);
            generalConditionDao.insert(generalCondition);
        }
        return singleId;
	}
	
	/**
	 * 获取状态对象
	 * @param leprosySaveDto
	 * @param type
	 * @return
	 */
	private IdmStatusInfo getIdmStatusInfo(LeprosySaveDto leprosySaveDto, String type) {
		IdmStatusInfo statusInfo = new IdmStatusInfo();
		 if(!"update".equals(type)){ 
			 statusInfo.setIdmType(IdmType.LEPROSY.getValue());
			 statusInfo.setSpecialStatus(leprosySaveDto.getSpecialStatus());
			 if(leprosySaveDto.getIdmId() !=null && leprosySaveDto.getIdmId() > 0l){
		        	statusInfo.setId(leprosySaveDto.getIdmId());
		        } 
		 } else {
			 statusInfo = idmStatusInfoDao.get(leprosySaveDto.getIdmId());
		 }
        statusInfo.setCurrentUnit(leprosySaveDto.getCaseInformation().getModifySurveyOrg());
		return statusInfo;
	}
	
	/**
	 * 根据条件生成事件对象
	 * @param result
	 * @param singleId
	 */
	private void getEvenInfo(LeprosySaveDto result, String singleId) {
		EventInfo eventInfo = eventInfoDao.get(new Criteria("id",singleId));
        result.setIdmId(eventInfo.getStatusId());
        result.setEventId(eventInfo.getEventId());
        result.setSingleId(eventInfo.getId());
	}

	@Override
	public PageList<ListCc> getCcList(Page page, Criteria criteria, Order od) {
		 return idmListCcDao.getPageList(page, criteria, od);
	}

	@Override
	public void saveCc(ListCc listCc) {
		idmListCcDao.insert(listCc);
	}

	@Override
	public void updateCc(ListCc listCc) {
		idmListCcDao.update(listCc);
	}

	@Override
	public void deleteCc(Long id) {
		idmListCcDao.delete(id);
	}

	@Override
	public ListCc getCc(Long id) {
		return idmListCcDao.get(id);
	}

	/**
	 * 获取患者基本信息
	 * @param criteria
	 * @return
	 */
	public GeneralCondition findGeneralCondition(Long idmId) {
		return generalConditionDao.get(new Criteria("idm_id", idmId));
	}
	
	/**
	 * 获取报卡基本信息
	 * @param criteria
	 * @return
	 */
	public CaseInformation findCaseInformation(Long idmId) {
		return caseInformationDao.get(new Criteria("idm_id", idmId));
	}
	
	/**
	 * 根据报卡中的活动Id获取相应Id最大的个案
	 * @param idmId
	 * @return
	 */
    @Override
	public EventInfo findEventInfo(String idmId) {
		return eventInfoDao.findEventInfo(idmId, "6002");
	}
	
    /**
     * 麻风密切接触者统计
     * @param page
     * @param criteria
     * @return
     */
    public PageList<ListCc> getCcListForLeprosySt(Page page, Criteria criteria) {
    	return idmListCcDao.getCcListForLeprosySt(page, criteria);
    }
    
    /**
     * 麻风随访统计
     * @param page
     * @param criteria
     * @return
     */
    public PageList<ListFr> getFrListForLeprosySt(Page page, Criteria criteria) {
    	return idmListFrDao.getFrListForLeprosySt(page, criteria);
    }
    
    /**
     * 麻风密切接触者统计 不分页
     * @param page
     * @param criteria
     * @return
     */
    public List<ListCc> getCcListForLeprosySt(Criteria criteria) {
    	return idmListCcDao.getCcListForLeprosySt(criteria);
    }
    
    /**
     * 麻风随访统计 不分页
     * @param page
     * @param criteria
     * @return
     */
    public List<ListFr> getFrListForLeprosySt(Criteria criteria) {
    	return idmListFrDao.getFrListForLeprosySt(criteria);
    }
    
    /**
     * 获取直报中传染病是麻风 还没有填写麻风疑似报卡的人数
     * @param criteria
     * @return
     */
    public int getNotReportLeprosyCount(Criteria criteria) {
    	return idmStatusInfoDao.getNotReportLeprosyCount(criteria);
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
    
}