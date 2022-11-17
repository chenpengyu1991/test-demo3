/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 * 传染病上报
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.*;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.repository.control.idm.special.*;
import com.founder.rhip.idm.common.IdmType;
import com.founder.rhip.idm.common.MalariaStatus;
import com.founder.rhip.idm.common.SpecialEvents;
import com.founder.rhip.idm.dto.MalariaDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("malariaService")
public class MalariaServiceImpl extends AbstractService implements IMalariaService {
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

    @Resource(name = "hygienicConditionDao")
    private IHygienicConditionDao hygienicConditionDao;     //卫生条件

    @Resource(name = "clinicalManifestationsDao")
    private IClinicalManifestationsDao clinicalManifestationsDao;     //主要临床表现

    @Resource(name = "infectionSourceRouteDao")
    private IInfectionSourceRouteDao infectionSourceRouteDao;     //传染源、传播途径

    @Resource(name = "otherConditionDao")
    private IOtherConditionDao otherConditionDao;     //其他

    @Resource(name = "caseInformationDao")
    private ICaseInformationDao caseInformationDao;     //卡片信息

    @Resource(name = "diagnosisDao")
    private IDiagnosisDao diagnosisDao;      //诊断依据、诊断结果

    @Resource(name = "epidemicFocusCloseDao")
    private IEpidemicFocusCloseDao epidemicFocusCloseDao;      //疫源地处理、密切接触者登记

    @Resource(name = "drugTherapyDao")
    private IDrugTherapyDao drugTherapyDao;      //药物治疗表

    @Resource(name = "idmListFgDao")
    private IListFgDao listFgDao;      //重点人群督导服药

    @Resource(name = "idmListEddDao")
    private IListEddDao idmListEddDao;      //疫点处理-子表

    @Resource(name = "idmListFrDao")
    private IListFrDao idmListFrDao;      //访视记录-子表

    @Resource(name = "idmListAiDao")
    private IListAiDao idmListAiDao;      //访视记录-子表

	@Resource(name = "haInterfaceService")
	private IHaInterfaceService haInterfaceService;
	
	@Resource(name = "approvalService")
	private IApprovalService approvalService;
	
	@Resource(name = "idmListSdDao")
	private IListSdDao listSdDao;

	@Resource(name = "idmListFgDao")
	private IListFgDao idmListFgDao;
	
	
	/* 
	 * 分页查询血检登记
	 * @author yejianfei 20130507
	 */
	@Override
	public PageList<IdmStatusInfo> findRegisterList(Criteria criteria, Page page) {
		PageList<IdmStatusInfo> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			result = idmStatusInfoDao.findRegisterList(page, criteria);
		}
		return result;
	}

    public List<IdmStatusInfo> findRegisterList(Criteria criteria){
       List<IdmStatusInfo> result = null;
        if(ObjectUtil.isNotEmpty(criteria)){
            result = idmStatusInfoDao.findRegisterList(criteria);
        }
        return result;
    }

    /**
     * 添加
     * @param       malariaDto
     * @param       statusInfo
     * @return      boolean
     */
    @Transactional
    public boolean save(MalariaDto malariaDto, IdmStatusInfo statusInfo, User user, Long eventId, String type) throws Exception {
        boolean result = false;
        Long idmId = -1L;
        Long singleId = -1L;
        /*血检登记时，临床诊断是阴性就不审核 modify by yjf 20130906*/
        /*if(Long.valueOf(SpecialEvents.M_BlOOD.getValue()).equals(eventId)){
	        Diagnosis diagnosis = malariaDto.getDiagnosis();
	        if(ObjectUtil.isNotEmpty(diagnosis)){
	        	if("3".equals(diagnosis.getTentativeDiagnosis())){
	        		statusInfo.setSpecialStatus(MalariaStatus.ELIMINATION.getValue());
	        	}
	        }
        }*/
        /*血检登记时，由原来的临床诊断是阴性就不审核,修改为:检验结果是阴性不用审核. modify by yjf 20140718*/
        if(Long.valueOf(SpecialEvents.M_BlOOD.getValue()).equals(eventId)){
        	LabExamine labExamine = malariaDto.getLabExamine();
	        if(ObjectUtil.isNotEmpty(labExamine)){
	        	if("3".equals(labExamine.getTestResult())){
	        		statusInfo.setSpecialStatus(MalariaStatus.ELIMINATION.getValue());
	        	}
	        }
        }        
        if(ObjectUtil.isNotEmpty(malariaDto.getSingleId())){
        	singleId = Long.parseLong(malariaDto.getSingleId());
        }
        if(ObjectUtil.isNotEmpty(malariaDto.getIdmId())){
        	idmId = Long.parseLong(malariaDto.getIdmId());
        	statusInfo.setId(idmId);
        }        
        GeneralCondition generalCondition = malariaDto.getGeneralCondition();
        if (ObjectUtil.isNotEmpty(generalCondition)) {
        	SavePerson(malariaDto);//调用接口新增或更新患者
        	PersonInfo personInfo = malariaDto.getPersonInfo();
			if(ObjectUtil.isNotEmpty(personInfo)){
				statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
				statusInfo.setPersonId(personInfo.getId());
			}
	        idmId = updateStatus(statusInfo);//新增或更新状态表，返回状态表ID
	        statusInfo.setId(idmId);
            if(!"update".equals(type)){
                //业务表唯一标识singleId与状态表关联
                EventInfo eventInfo = new EventInfo();
                eventInfo.setStatusId(idmId);
                eventInfo.setEventId(eventId);
                singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
            }
            if(eventId.equals(NumberUtil.convert(SpecialEvents.M_CASE.getValue(),Long.class))){
            	Diagnosis diagnosis= malariaDto.getDiagnosis();
            	String caseDie = diagnosis==null?"":diagnosis.getCaseDie();
            	if(caseDie.equals("1")){//如果病人死亡，则结束规范化管理
            		endProcedure(idmId.toString(), MalariaStatus.CURE);
            	}else{
            		endProcedure(idmId.toString(), MalariaStatus.WRITE);
            	}
            }
            //statusInfo.setId(singleId);
            addLog(statusInfo,user);
            generalCondition.setIdmId(singleId);
            generalConditionDao.insert(generalCondition);
        }

        AttackCondition attackCondition = malariaDto.getAttackCondition();
        if (ObjectUtil.isNotEmpty(attackCondition)) {
            attackCondition.setIdmId(singleId);
            attackConditionDao.insert(attackCondition);
        }

        LabExamine LabExamine = malariaDto.getLabExamine();
        if (ObjectUtil.isNotEmpty(LabExamine)) {
            LabExamine.setIdmId(singleId);
            labExamineDao.insert(LabExamine);
        }

        PastHistory pastHistory = malariaDto.getPastHistory();
        if (ObjectUtil.isNotEmpty(pastHistory)) {
            pastHistory.setIdmId(singleId);
            pastHistoryDao.insert(pastHistory);
        }

        HygienicCondition hygienicCondition = malariaDto.getHygienicCondition();
        if (ObjectUtil.isNotEmpty(hygienicCondition)) {
            hygienicCondition.setIdmId(singleId);
            hygienicConditionDao.insert(hygienicCondition);
        }

        ClinicalManifestations clinicalManifestations = malariaDto.getClinicalManifestations();
        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
            clinicalManifestations.setIdmId(singleId);
            clinicalManifestationsDao.insert(clinicalManifestations);
        }

        InfectionSourceRoute infectionSourceRoute = malariaDto.getInfectionSourceRoute();
        if (ObjectUtil.isNotEmpty(infectionSourceRoute)) {
            infectionSourceRoute.setIdmId(singleId);
            infectionSourceRouteDao.insert(infectionSourceRoute);
        }

        OtherCondition otherCondition = malariaDto.getOtherCondition();
        if (ObjectUtil.isNotEmpty(otherCondition)) {
            otherCondition.setIdmId(singleId);
            otherConditionDao.insert(otherCondition);
        }

        CaseInformation caseInformation = malariaDto.getCaseInformation();
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            caseInformation.setIdmId(singleId);
            caseInformationDao.insert(caseInformation);
        }

        Diagnosis diagnosis = malariaDto.getDiagnosis();
        if (ObjectUtil.isNotEmpty(diagnosis)) {
            diagnosis.setIdmId(singleId);
            diagnosisDao.insert(diagnosis);
        }

        EpidemicFocusClose epidemicFocusClose = malariaDto.getEpidemicFocusClose();
        if (ObjectUtil.isNotEmpty(epidemicFocusClose)) {
            epidemicFocusClose.setIdmId(singleId);
            epidemicFocusCloseDao.insert(epidemicFocusClose);
        }
        result = true;
        return result;

    }

    /**
     * 如果病人死亡
     * 则更新状态表状态
     * @param       idmId
     * @return      boolean
     */
    private boolean endProcedure(String idmId, MalariaStatus status){
    	int result = 0;
    	if(StringUtil.isNotEmpty(idmId)){
    		Criteria ca = new Criteria("ID", idmId);
    		Parameters parameters = new Parameters();
    		parameters.add("SPECIAL_STATUS", status.getValue());
    		result = idmStatusInfoDao.update(parameters,ca);
    	}
    	return result != 0?true:false;
    	
    }
    /**
     * 修改
     * @param       malariaDto
     * @param       statusInfo
     * @return      boolean
     */
    @Transactional
    public boolean update(MalariaDto malariaDto, IdmStatusInfo statusInfo, User user) throws Exception {
        boolean result = false;
        delete(malariaDto.getSingleId());
        Long eventId = NumberUtil.convert(malariaDto.getEventId(),Long.class);
        save(malariaDto, statusInfo, user, eventId, "update");
        result = true;
        return result;
    }

    /**
     * 分配
     * @param       acceptTown
     * @param       acceptUnit
     * @param       singleIds
     * @return      boolean
     */
	@Override
    @Transactional
    public boolean  distribution(String acceptTown, String acceptUnit, String[] singleIds, User user){
        int result = 0; 
        /*
         * 1、设置分配单位
         * 2、更新血检单状态
         * */
		IdmStatusInfo statusInfo = new IdmStatusInfo();
		statusInfo.setIdmType(IdmType.MALARIA.getValue());
		statusInfo.setSpecialStatus(MalariaStatus.VERIFY.getValue());
		
		List<Long> ids = new ArrayList<Long>();
		for(String singleId:singleIds){
			Long id = getStatusId(singleId);
			ids.add(id);
			statusInfo.setId(NumberUtil.convert(id,Long.class));
			addLog(statusInfo,user);
		}
		Criteria caStatus = new Criteria("ID", OP.IN,ids.toArray());
		Parameters paraStatus = new Parameters();
		paraStatus.add("SPECIAL_STATUS", MalariaStatus.VERIFY.getValue());
		paraStatus.add("CURRENT_TOWN", acceptTown);//分配机构所在镇
		paraStatus.add("CURRENT_UNIT", acceptUnit);//分配机构
		result = idmStatusInfoDao.update(paraStatus, caStatus);
        return result!=0?true:false;
    }
    /**
     * 删除
     * @param       singleIdStr
     * @return      int
     */
    @Transactional
    public boolean delete(String singleIdStr){
        boolean result = false;
        Long singleId = Long.parseLong(singleIdStr);
        Criteria ca = new Criteria("idmId", singleId);

        generalConditionDao.delete(ca);

        attackConditionDao.delete(ca);

        labExamineDao.delete(ca);

        pastHistoryDao.delete(ca);

        hygienicConditionDao.delete(ca);

        clinicalManifestationsDao.delete(ca);

        infectionSourceRouteDao.delete(ca);

        otherConditionDao.delete(ca);

        caseInformationDao.delete(ca);

        diagnosisDao.delete(ca);

        epidemicFocusCloseDao.delete(ca);
        result = true;
        return result;
    }

    /**
     * 查看
     * @param       singleId
     * @return      MalariaDto
     */
    public MalariaDto getCase(String singleId){
        MalariaDto result = new MalariaDto();
        //获取logoff
        Criteria ca2 = new Criteria("id",singleId);
        EventInfo eventInfo = eventInfoDao.get(ca2);
        Long statusId = eventInfo.getStatusId();
        IdmStatusInfo idmStatusInfo = idmStatusInfoDao.get(new Criteria("id", statusId));
        if(ObjectUtil.isNotEmpty(idmStatusInfo)){
            result.setLogoff(idmStatusInfo.getLogoff());
        }

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

        HygienicCondition hygienicCondition =hygienicConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(hygienicCondition)) {
            result.setHygienicCondition(hygienicCondition);
        }

        ClinicalManifestations clinicalManifestations =clinicalManifestationsDao.get(ca);
        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
            result.setClinicalManifestations(clinicalManifestations);
        }

        InfectionSourceRoute infectionSourceRoute = infectionSourceRouteDao.get(ca);
        if (ObjectUtil.isNotEmpty(infectionSourceRoute)) {
            result.setInfectionSourceRoute(infectionSourceRoute);
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

        EpidemicFocusClose epidemicFocusClose = epidemicFocusCloseDao.get(ca);
        if (ObjectUtil.isNotEmpty(epidemicFocusClose)) {
            result.setEpidemicFocusClose(epidemicFocusClose);
        }

        DrugTherapy drugTherapy = drugTherapyDao.get(ca);
        if (ObjectUtil.isNotEmpty(drugTherapy)) {
            result.setDrugTherapy(drugTherapy);
        }

        //子表-疫点处理
        List<ListEdd> listEdds = idmListEddDao.getList(ca, new Order("CHECK_DT", false));
        if (ObjectUtil.isNotEmpty(listEdds)) {
            result.setListEdd(listEdds);
        }

        //子表-服药记录
        List<ListSd> listSds = listSdDao.getList(ca);
        if (ObjectUtil.isNotEmpty(listSds)) {
            result.setListSds(listSds);
        }

        //子表-访视记录
        List<ListFr> listFrs = idmListFrDao.getList(ca, new Order("VISIT_DT", false));
        if (ObjectUtil.isNotEmpty(listFrs)) {
            result.setListFr(listFrs);
        }

        Criteria ca1 = new Criteria("id",singleId);
        Long idmId = eventInfoDao.get(ca1).getStatusId();
        result.setIdmId(idmId.toString());
        return result;
    }
 
    
    /**
     * 查看督导服药登记表
     * @param       idmId
     * @return      MalariaDto
     */
    public MalariaDto getDrugRecord(String idmId, SpecialEvents event){
        MalariaDto result = new MalariaDto();
        result.setIdmId(idmId);
        Long singleId = getSingleId(event,idmId);
        if(!singleId.equals(-1L)){
	        Criteria ca = new Criteria("idmId",singleId);
	        result.setSingleId(singleId.toString());
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
	
	        ClinicalManifestations clinicalManifestations =clinicalManifestationsDao.get(ca);
	        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
	            result.setClinicalManifestations(clinicalManifestations);
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
	
	        //子表-服药记录
	        List<ListSd> listSds = listSdDao.getList(ca,new Order("DRUG_DT", false));
	        if (ObjectUtil.isNotEmpty(listSds)) {
	            result.setListSds(listSds);
	        }
        }else{
        	/*如果未进行督导服药登记，初始化基本信息数据*/
        	singleId = getSingleId(SpecialEvents.M_BlOOD,idmId);
        	result = initDrugRecord(singleId.toString(),event);
        }
        return result;
    }
   
    /**
     * 查看一般情况表
     * @param       idmId
     * @param       event
     * @return      GeneralCondition
     */
    public GeneralCondition getGeneralCondition(String idmId, SpecialEvents event){
    	Long singleId = getSingleId(event,idmId);
    	GeneralCondition generalCondition = null;
    	if(ObjectUtil.isNotEmpty(singleId)){
	    	Criteria ca = new Criteria("idmId",singleId);
	        generalCondition = generalConditionDao.get(ca,new String[]{"PHONE_NUMBER","NAME","GENDER","AGE","PATOWN_SHIP","PASTREET","PAHOUSE_NUMBER"});
    	}
    	return generalCondition;
    }
    
    /**
     * 初始化督导服药登记表
     * @param       singleId
     * @return      MalariaDto
     */
    public MalariaDto initDrugRecord(String singleId, SpecialEvents event){
        MalariaDto result = new MalariaDto();

        Criteria ca = new Criteria("idmId",singleId);

        GeneralCondition generalCondition = generalConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(generalCondition)) {
        	generalCondition.setId(null);
            result.setGeneralCondition(generalCondition);
        }

        AttackCondition attackCondition = attackConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(attackCondition)) {
        	attackCondition.setId(null);
            result.setAttackCondition(attackCondition);
        }

        LabExamine labExamine = labExamineDao.get(ca);
        if (ObjectUtil.isNotEmpty(labExamine)) {
        	labExamine.setId(null);
            result.setLabExamine(labExamine);
        }

        ClinicalManifestations clinicalManifestations =clinicalManifestationsDao.get(ca);
        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
        	clinicalManifestations.setId(null);
            result.setClinicalManifestations(clinicalManifestations);
        }

        OtherCondition otherCondition = otherConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(otherCondition)) {
        	otherCondition.setId(null);
            result.setOtherCondition(otherCondition);
        }

        CaseInformation caseInformation = caseInformationDao.get(ca);
        if (ObjectUtil.isNotEmpty(caseInformation)) {
        	caseInformation.setId(null);
            result.setCaseInformation(caseInformation);
        }

        Diagnosis diagnosis = diagnosisDao.get(ca);
        if (ObjectUtil.isNotEmpty(diagnosis)) {
        	caseInformation.setId(null);
            result.setDiagnosis(diagnosis);
        }

        Criteria ca1 = new Criteria("id",singleId);
        Long idmId = eventInfoDao.get(ca1).getStatusId();
        result.setIdmId(idmId.toString());
        return result;
    }
    
    /**
     * 保存督导服药登记表
     * @param       malariaDto
     * @param       user
     * @return      int
     */
    @Transactional
    public boolean saveDrugRecord(MalariaDto malariaDto, User user, SpecialEvents event) throws Exception {
        int result = 0;
        Long idmId = -1L;
        Long singleId = -1L;
        IdmStatusInfo statusInfo = new IdmStatusInfo();
        
        if(ObjectUtil.isNotEmpty(malariaDto.getIdmId())){
        	idmId = Long.parseLong(malariaDto.getIdmId());
        	statusInfo.setId(idmId);
        } 
        singleId = getSingleId(event,malariaDto.getIdmId());
        if(!singleId.equals(-1L)){
        	Criteria ca = new Criteria("idmId", singleId);
            listSdDao.delete(ca);
        }else{
            //业务表唯一标识singleId与状态表关联
        	EventInfo eventInfo = new EventInfo();
            eventInfo.setStatusId(idmId);
            eventInfo.setEventId(Long.parseLong(event.getValue()));
            singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();
        }
        List<ListSd> listSds = malariaDto.getListSds();
        if(ObjectUtil.isNotEmpty(listSds)){
            for(ListSd listsd : listSds){
            	listsd.setIdmId(singleId);
            }
            listSdDao.batchInsert(listSds);
        }

        GeneralCondition generalCondition = malariaDto.getGeneralCondition();
        if (ObjectUtil.isNotEmpty(generalCondition)) {
        	SavePerson(malariaDto);//调用接口新增或更新患者
        	PersonInfo personInfo = malariaDto.getPersonInfo();
			if(ObjectUtil.isNotEmpty(personInfo)){
				statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
				statusInfo.setPersonId(personInfo.getId());
				updateStatus(statusInfo);
			}
         }
        result = saveBusiness(malariaDto,singleId);
        return result != 0?true:false;
    }
    
    /*根据标识新增或更新业务表*/
    private <T> int  saveBusiness(MalariaDto malariaDto, Long singleId){
    	int result = 0;
    	GeneralCondition generalCondition = malariaDto.getGeneralCondition();
    	if(ObjectUtil.isNotEmpty(generalCondition)){
    		generalCondition.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(generalCondition.getId())){
        		result = generalConditionDao.insert(generalCondition);
        	}else{
        		result = generalConditionDao.update(generalCondition);
        	}
    	}
    	
    	AttackCondition attackCondition = malariaDto.getAttackCondition();
    	if(ObjectUtil.isNotEmpty(attackCondition)){
    		attackCondition.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(attackCondition.getId())){
        		result = attackConditionDao.insert(attackCondition);
        	}else{
        		result = attackConditionDao.update(attackCondition);
        	}
    	}
    	
    	LabExamine labExamine = malariaDto.getLabExamine();
    	if(ObjectUtil.isNotEmpty(labExamine)){
    		labExamine.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(labExamine.getId())){
        		result = labExamineDao.insert(labExamine);
        	}else{
        		result = labExamineDao.update(labExamine);
        	}
    	}
    	
    	OtherCondition otherCondition = malariaDto.getOtherCondition();
    	if(ObjectUtil.isNotEmpty(otherCondition)){
    		otherCondition.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(otherCondition.getId())){
        		result = otherConditionDao.insert(otherCondition);
        	}else{
        		result = otherConditionDao.update(otherCondition);
        	}
    	}
    	
    	CaseInformation caseInformation = malariaDto.getCaseInformation();
    	if(ObjectUtil.isNotEmpty(caseInformation)){
    		caseInformation.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(caseInformation.getId())){
        		result = caseInformationDao.insert(caseInformation);
        	}else{
        		result = caseInformationDao.update(caseInformation);
        	}
    	}
    	
    	Diagnosis diagnosis = malariaDto.getDiagnosis();
    	if(ObjectUtil.isNotEmpty(diagnosis)){
    		diagnosis.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(diagnosis.getId())){
        		result = diagnosisDao.insert(diagnosis);
        	}else{
        		result = diagnosisDao.update(diagnosis);
        	}
    	}
    	
    	ClinicalManifestations clinicalManifestations = malariaDto.getClinicalManifestations();
    	if(ObjectUtil.isNotEmpty(clinicalManifestations)){
    		clinicalManifestations.setIdmId(singleId);
    		if(ObjectUtil.isNullOrEmpty(clinicalManifestations.getId())){
        		result = clinicalManifestationsDao.insert(clinicalManifestations);
        	}else{
        		result = clinicalManifestationsDao.update(clinicalManifestations);
        	}
    	}
    	return result;
    }
    
    /**
     * 查询重点人群督导服药列表
     */
    public PageList<ListFg> findFgList(Criteria criteria, Page page){
		PageList<ListFg> result = null;
		if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
			Order od = new Order("PATIENT_NAME",true);//正序
			od.asc("FLAG");
			od.desc("REPORT_DATE");
			result = idmListFgDao.findFgList(page,criteria,od);
		}
		return result;    	
    }

    /**
     * 查询重点人群督导服药列表
     */
    public List<ListFg> findFgList(Criteria criteria){
		List<ListFg> result = null;
		if(ObjectUtil.isNotEmpty(criteria)){
			Order od = new Order("PATIENT_NAME",true);//正序
			od.asc("FLAG");
			od.desc("REPORT_DATE");
			result = idmListFgDao.findFgList(criteria,od);
		}
		return result;    	
    }
    /**
     * 查看患者信息（重点人群查询）
     * @param       idmId
     * @return      MalariaDto
     */
    public MalariaDto getPatientInfo(String idmId){
    	MalariaDto dto = new MalariaDto();
    	GeneralCondition generalCondition = null;
    	ClinicalManifestations clinicalManifestations = null;
    	CaseInformation caseInformation = null;
    	OtherCondition otherCondition = null;
    	if(StringUtil.isNotEmpty(idmId)){
	    	Long singleId = getSingleId(SpecialEvents.M_DRUGREG,idmId);//服药登记
	    	if(!singleId.equals(-1L)){
		    	Criteria ca = new Criteria("idmId",singleId);
		        generalCondition = generalConditionDao.get(ca);
		        clinicalManifestations = clinicalManifestationsDao.get(ca);
		        otherCondition = otherConditionDao.get(ca);
		        dto.setClinicalManifestations(clinicalManifestations);
		        dto.setOtherCondition(otherCondition);
	    	}
	        
	        singleId = getSingleId(SpecialEvents.M_BlOOD,idmId);//血检登记
	        GeneralCondition regCon = generalConditionDao.get(new Criteria("idmId",singleId));
	        caseInformation = caseInformationDao.get(new Criteria("idmId",singleId));
	        if(ObjectUtil.isNotEmpty(regCon)){
	        	if(ObjectUtil.isNullOrEmpty(generalCondition)){//如果没有进行服药登记
	        		generalCondition = new GeneralCondition();
	        		generalCondition.setGender(regCon.getGender());//性别
	        		generalCondition.setName(regCon.getName());//姓名
	        		generalCondition.setAge(regCon.getAge());//年龄
	        		generalCondition.setPatownShip(regCon.getPatownShip());//现居住地乡街道
	        		generalCondition.setPastreet(regCon.getPastreet());//现居住地村社区
	        		generalCondition.setPahouseNumber(regCon.getPahouseNumber());//现居住地详细
	        		generalCondition.setPhoneNumber(regCon.getPhoneNumber());//联系电话
	        	}
	        	generalCondition.setIdcard(regCon.getIdcard());//身份证
	        	dto.setGeneralCondition(generalCondition);
	        }	        
	        dto.setCaseInformation(caseInformation);
    	}
        return dto;
    }
    /**
     * 查看重点人群督导服药登记表
     * @param       id
     * @return      MalariaDto
     */
    public MalariaDto getFgDrugRecord(Long id){
    	MalariaDto result = new MalariaDto();

        if(ObjectUtil.isNotEmpty(id)){
	        Criteria ca = new Criteria("IDM_ID",id);
	        ListFg listFg = listFgDao.get(id);
	        result.setListFg(listFg);
	        //子表-服药记录
	        List<ListSd> listSds = listSdDao.getList(ca,new Order("DRUG_DT", false));
	        if (ObjectUtil.isNotEmpty(listSds)) {
	            result.setListSds(listSds);
	        }
        }
        return result;
    }
    /**
     * 保存重点人群督导服药登记表
     * @param       malariaDto
     * @return      boolean
     * @throws Exception
     */
    @Transactional
    public boolean saveFgDrugRecord(MalariaDto malariaDto) throws Exception {
        int result = 0;
        //listFg.restObject
        Long id = null;
        ListFg fg = malariaDto.getListFg();
        if(ObjectUtil.isNotEmpty(fg)){
        	id = fg.getId();
        }
        if(ObjectUtil.isNotEmpty(id)){
        	Criteria ca = new Criteria("idmId", id);
            listSdDao.delete(ca);//督导服药记录表
            result = idmListFgDao.update(malariaDto.getListFg());//重点人群
        }else{
            id = idmListFgDao.generatedKey(malariaDto.getListFg(), "ID", null).longValue();
            result += 1;
        }
        if(ObjectUtil.isNotEmpty(id)){
	        List<ListSd> listSds = malariaDto.getListSds();
	        if(ObjectUtil.isNotEmpty(listSds)){
	            for(ListSd listsd : listSds){
	            	listsd.setIdmId(id);
	            }
	            result += listSdDao.batchInsert(listSds);
	        }
        }
        return result != 0?true:false;
    }    
    /**
     * 查询主动病历侦查
     * @param       criteria
     * @param       page
     * @return      PageList<ListAi>
     */
    public PageList<ListAi> findAiList(Criteria criteria, Page page){
        PageList<ListAi> result = null;
        if(ObjectUtil.isNotEmpty(criteria) && ObjectUtil.isNotEmpty(page)){
            Order od = new Order("REPORT_DT",true);//正序
            result = idmListAiDao.findAiList(page,criteria,od);
        }
        return result;
    }

    public List<ListAi> findAiList(Criteria criteria){
        List<ListAi> result = null;
        if(ObjectUtil.isNotEmpty(criteria)){
            Order od = new Order("REPORT_DT",true);//正序
            result = idmListAiDao.findAiList(criteria,od);
        }
        return result;
    }

    public ListAi getAi(Long id){
        ListAi listAi = idmListAiDao.get(id);
        return listAi;
    }

    public void deleteAi(Long id){
        idmListAiDao.delete(id);
    }

    /*
     * 根据事件类型、状态表ID（IDM_STATUS_INFO.ID)
     * 查询singleId
     * */
    private Long getSingleId(SpecialEvents eventId, String idmId){
    	Long singleId = -1L;
        Criteria eventCa = new Criteria("eventId", eventId.getValue()).add("statusId",idmId);
        EventInfo eventInfo = eventInfoDao.get(eventCa);
        if(ObjectUtil.isNotEmpty(eventInfo)){
        	singleId = eventInfo.getId();
        }
        return singleId;
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
	 * @param malariaDto
	 * @return
	 * @throws Exception
	 */
	private String SavePerson(MalariaDto malariaDto) throws Exception {
		String result;
		PersonInfo personInfo = malariaDto.getPersonInfo();
		String[] param = malariaDto.getPersonInfoParam();
		
		if(ObjectUtil.isNotEmpty(param)){
			result = haInterfaceService.updatePersonInfo(personInfo,param);
		}else{
			result = haInterfaceService.updatePersonInfo(personInfo);
		}		
		malariaDto.setPersonInfo(personInfo);
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
			if(statusInfo.getPixId().equals("-1")){
				statusInfo.setPixId(null);
			}
			idmId = idmStatusInfoDao.generatedKey(statusInfo, "ID",null).longValue();
		}
		return idmId;
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
				Comments ="血检登记";
				break;
			case 2:
				Comments ="核实排除";
				break;
			case 3:
				Comments ="核实通过";
				break;
			case 4:
				Comments ="个案填写";
				break;
		}
		approvalInfo.setComments(Comments);
		approvalInfo.setIdmId(statusInfo.getId());
		approvalInfo.setStatus(statusInfo.getSpecialStatus().toString());
		approvalInfo.setUserId(user.getId().toString());
		approvalInfo.setUserName(user.getName());
		return approvalService.createApprovalInfo(approvalInfo);
	}

    @Transactional
    public boolean saveEpidemicFocus(MalariaDto malariaDto, Long eventId) throws Exception {
        boolean result = false;
        Long singleId = -1L;

        GeneralCondition generalCondition = malariaDto.getGeneralCondition();
        if (ObjectUtil.isNotEmpty(generalCondition)) {
        	IdmStatusInfo statusInfo = new IdmStatusInfo();
        	SavePerson(malariaDto);//调用接口新增或更新患者
        	PersonInfo personInfo = malariaDto.getPersonInfo();
			if(ObjectUtil.isNotEmpty(personInfo)){
				statusInfo.setPixId(StringUtil.isNotEmpty(personInfo.getSmpiId())?personInfo.getSmpiId():"-1");
				statusInfo.setPersonId(personInfo.getId());
		        if(ObjectUtil.isNotEmpty(malariaDto.getIdmId())){
		        	Long idmId = Long.parseLong(malariaDto.getIdmId());
		        	statusInfo.setId(idmId);
		        } 
				updateStatus(statusInfo);
			} 
        }
        EpidemicFocusClose epidemicFocusClose = malariaDto.getEpidemicFocusClose();
        List<ListEdd> listEdds = malariaDto.getListEdd();

        Criteria eventCa = new Criteria("eventId", eventId).add("statusId", malariaDto.getIdmId());
        EventInfo eventInfo = eventInfoDao.get(eventCa);
        if(ObjectUtil.isNotEmpty(eventInfo)){
            singleId = eventInfo.getId();

            generalCondition.setIdmId(singleId);
            generalConditionDao.update(generalCondition);

            epidemicFocusClose.setIdmId(singleId);
            epidemicFocusCloseDao.update(epidemicFocusClose);

            Criteria ca = new Criteria("idmId", singleId);
            idmListEddDao.delete(ca);

            List<ListEdd> listEddList = new ArrayList<ListEdd>();
            if(ObjectUtil.isNotEmpty(listEdds)){
                for(ListEdd listEdd : listEdds){
                    //去除第一行（表头占两行）
                    if(StringUtil.isNotEmpty(listEdd.getCheckUser())){
                        listEdd.setIdmId(singleId);
                        listEdd.setIdmId(singleId);
                        listEddList.add(listEdd);
                    }
                }
                idmListEddDao.batchInsert(listEddList);
            }
        }else{
            eventInfo = new EventInfo();
            eventInfo.setEventId(eventId);
            eventInfo.setStatusId(Long.valueOf(malariaDto.getIdmId()));
            singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();

            generalCondition.setIdmId(singleId);
            generalConditionDao.insert(generalCondition);

            epidemicFocusClose.setIdmId(singleId);
            epidemicFocusCloseDao.insert(epidemicFocusClose);

            List<ListEdd> listEddList = new ArrayList<ListEdd>();
            if(ObjectUtil.isNotEmpty(listEdds)){
                for(ListEdd listEdd : listEdds){
                    //去除第一行（表头占两行）
                    if(StringUtil.isNotEmpty(listEdd.getCheckUser())){
                        listEdd.setIdmId(singleId);
                        listEdd.setIdmId(singleId);
                        listEddList.add(listEdd);
                    }
                }
                idmListEddDao.batchInsert(listEddList);
            }
        }
        result = true;
        return result;
    }

    @Transactional
    public boolean saveVisit(MalariaDto malariaDto, Long eventId) throws Exception {
        boolean result = false;
        Long singleId = -1L;

        GeneralCondition generalCondition = malariaDto.getGeneralCondition();
        AttackCondition attackCondition = malariaDto.getAttackCondition();
        Diagnosis diagnosis = malariaDto.getDiagnosis();
        OtherCondition otherCondition = malariaDto.getOtherCondition();
        DrugTherapy drugTherapy = malariaDto.getDrugTherapy();
        List<ListFr> listFrs = malariaDto.getListFr();
        List<ListSd> listSds = malariaDto.getListSds();

        Criteria eventCa = new Criteria("eventId", eventId).add("statusId", malariaDto.getIdmId());
        EventInfo eventInfo = eventInfoDao.get(eventCa);
        if(ObjectUtil.isNotEmpty(eventInfo)){
            singleId = eventInfo.getId();

            generalCondition.setIdmId(singleId);
            generalConditionDao.update(generalCondition);

            attackCondition.setIdmId(singleId);
            attackConditionDao.update(attackCondition);

            diagnosis.setIdmId(singleId);
            diagnosisDao.update(diagnosis);

            otherCondition.setIdmId(singleId);
            otherConditionDao.update(otherCondition);

            if(ObjectUtil.isNotEmpty(drugTherapy)){
                drugTherapy.setIdmId(singleId);
                if(null != drugTherapy.getId()){
                    drugTherapyDao.update(drugTherapy);
                }else {
                    drugTherapyDao.insert(drugTherapy);
                }
            }

            Criteria ca = new Criteria("idmId", singleId);
            idmListFrDao.delete(ca);
            listSdDao.delete(ca);
            //访视情况
            List<ListFr> listFrList = new ArrayList<ListFr>();
            if(ObjectUtil.isNotEmpty(listFrs)){
                for(ListFr listFr : listFrs){
                    //去除第一行（表头占两行）
                    if(StringUtil.isNotEmpty(listFr.getCheckUser())){
                        listFr.setIdmId(singleId);
                        listFrList.add(listFr);
                    }
                }
                idmListFrDao.batchInsert(listFrList);
            }
            //用药-其他
            List<ListSd> listSdList = new ArrayList<ListSd>();
            if(ObjectUtil.isNotEmpty(listSds)){
                for(ListSd listSd : listSds){
                    if(StringUtil.isNotEmpty(listSd.getDrugName())){
                        listSd.setIdmId(singleId);
                        listSdList.add(listSd);
                    }
                }
                listSdDao.batchInsert(listSdList);
            }
        }else{
            eventInfo = new EventInfo();
            eventInfo.setEventId(eventId);
            eventInfo.setStatusId(Long.valueOf(malariaDto.getIdmId()));
            singleId = eventInfoDao.generatedKey(eventInfo, "ID", null).longValue();

            generalCondition.setIdmId(singleId);
            generalConditionDao.insert(generalCondition);

            attackCondition.setIdmId(singleId);
            attackConditionDao.insert(attackCondition);

            diagnosis.setIdmId(singleId);
            diagnosisDao.insert(diagnosis);

            otherCondition.setIdmId(singleId);
            otherConditionDao.insert(otherCondition);

            drugTherapy.setIdmId(singleId);
            drugTherapyDao.insert(drugTherapy);

            //访视情况
            List<ListFr> listFrList = new ArrayList<ListFr>();
            if(ObjectUtil.isNotEmpty(listFrs)){
                for(ListFr listFr : listFrs){
                    //去除第一行（表头占两行）
                    if(StringUtil.isNotEmpty(listFr.getCheckUser())){
                        listFr.setIdmId(singleId);
                        listFrList.add(listFr);
                    }
                }
                idmListFrDao.batchInsert(listFrList);
            }
            //用药-其他
            List<ListSd> listSdList = new ArrayList<ListSd>();
            if(ObjectUtil.isNotEmpty(listSds)){
                for(ListSd listSd : listSds){
                    if(StringUtil.isNotEmpty(listSd.getDrugName())){
                        listSd.setIdmId(singleId);
                        listSdList.add(listSd);
                    }
                }
                listSdDao.batchInsert(listSdList);
            }
        }
        result = true;
        return result;
    }

    @Transactional
    public boolean saveAi(List<ListAi> listAis) throws Exception {
        boolean result = false;
        idmListAiDao.batchInsert(listAis);
        result = true;
        return result;
    }

    public boolean updateAi(ListAi listAi) throws Exception {
        boolean result = false;
        idmListAiDao.update(listAi);
        result = true;
        return result;
    }

    public Long getSingleId(String idmId, String eventId){
        Long singleId = -1L;
        Criteria eventCa = new Criteria("eventId", eventId).add("statusId", idmId);
        EventInfo eventInfo = eventInfoDao.get(eventCa);
        if(ObjectUtil.isNotEmpty(eventInfo)){
            singleId = eventInfo.getId();
        }
        return singleId;
    }

}