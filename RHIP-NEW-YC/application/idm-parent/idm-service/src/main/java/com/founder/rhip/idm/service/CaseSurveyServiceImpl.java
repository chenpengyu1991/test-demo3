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
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.cic.CicTarget;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.repository.control.idm.special.IEventInfoDao;
import com.founder.rhip.ehr.service.ta.ICicTargetService;
import com.founder.rhip.idm.common.AssignmentStatus;
import com.founder.rhip.idm.dto.CaseDto;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

@Service("caseSurveyService")
public class CaseSurveyServiceImpl extends AbstractService implements ICaseSurveyService {

    @Resource(name = "generalConditionDao")
    private IGeneralConditionDao generalConditionDao;    //一般情况

    @Resource(name = "attackConditionDao")
    private IAttackConditionDao attackConditionDao;     //发病情况

    @Resource(name = "clinicalManifestationsDao")
    private IClinicalManifestationsDao clinicalManifestationsDao;     //主要临床表现

    @Resource(name = "labExamineDao")
    private ILabExamineDao labExamineDao;     //实验室检查

    @Resource(name = "epidemiologicalSurveyDao")
    private IEpidemiologicalSurveyDao epidemiologicalSurveyDao;     //流行病学调查

    @Resource(name = "diagnosisDao")
    private IDiagnosisDao diagnosisDao;     //诊断依据、诊断结果

    @Resource(name = "pastHistoryDao")
    private IPastHistoryDao pastHistoryDao;     //既往史

    @Resource(name = "infectionSourceRouteDao")
    private IInfectionSourceRouteDao infectionSourceRouteDao;     //传染源、传播途径

    @Resource(name = "exposureHistoryDao")
    private IExposureHistoryDao exposureHistoryDao;     //暴露史

    @Resource(name = "otherConditionDao")
    private com.founder.rhip.ehr.repository.control.idm.notifiabledisease.IOtherConditionDao IOtherConditionDao;     //其他

    @Resource(name = "beforeDiseaseDietDao")
    private IBeforeDiseaseDietDao beforeDiseaseDietDao;     //病前饮食情况

    @Resource(name = "caseInformationDao")
    private ICaseInformationDao caseInformationDao;     //卡片信息

    @Resource(name = "hygienicConditionDao")
    private IHygienicConditionDao hygienicConditionDao;     //卫生条件

    @Resource(name = "epidemicFocusCloseDao")
    private IEpidemicFocusCloseDao epidemicFocusCloseDao;     //疫源地处理、密切接触者登记

    @Resource(name = "idmStatusInfoDao")
    private IIdmStatusInfoDao idmStatusInfoDao;        //状态表

    @Resource(name = "eventInfoDao")
    private IEventInfoDao eventInfoDao;

    @Resource(name = "listEfcDao")
    private IListEfcDao listEfcDao;        //疫源地处理，密切接触者登记-列表

    @Resource(name = "listEsDao")
    private IListEsDao listEsDao;        //流行病学调查-列表
    
    @Resource(name = "listBddDao")
    private IListBddDao listBddDao;    //食谱
    
    @Resource(name = "listLeDao")
    private IListLeDao listLeDao;    //实验室调查列表

    @Resource(name = "listAcDao")
    private IListAcDao listAcDao;    //发病情况列表

    @Resource(name = "listEhDao")
    private IListEhDao listEhDao;    //暴露史

    @Resource(name = "listHcDao")
    private IListHcDao listHcDao;    //卫生条件

    @Resource(name = "haInterfaceService")
    private IHaInterfaceService haInterfaceService;

    @Resource(name = "cicTargetService")
    private ICicTargetService cicTargetService;
    
    @Resource(name = "caseOperateLogDao")
    private ICaseOperateLogDao caseOperateLogDao;
    
    @Autowired
	private IDictionaryApp dictionaryApp;
    
    @Resource(name = "idmAnorectaReportTableDao")
    private IIdmAnorectaReportTableDao anorectaReportTableDao;
    
    @Resource(name="setupService")
    private ISetupService setupService;
    
    @Resource(name="caseApprovalInfoDao")
    ICaseApprovalInfoDao caseApprovalInfoDao;

    /**
     * 添加
     *
     * @param caseDto
     * @param statusinfo
     * @param personInfo
     * @return int
     */
    @Transactional
    public boolean createCaseSurvey(CaseDto caseDto, IdmStatusInfo statusinfo, PersonInfo personInfo) throws Exception {
        boolean result = false;
        Long idmId = Long.parseLong(caseDto.getIdmId());
//        String pixId="";
        GeneralCondition generalCondition = caseDto.getGeneralCondition();
        if (ObjectUtil.isNotEmpty(generalCondition)) {
            //TODO
//			/*身份证号码为空则不更新患者信息*/
//            if(StringUtil.isNotEmpty(generalCondition.getIdcard())){
//                pixId = SavePerson(caseDto);//调用接口新增或更新患者，返回PIX_ID
//            }

            generalCondition.setIdmId(idmId);
            generalConditionDao.insert(generalCondition);
        }

        AttackCondition attackCondition = caseDto.getAttackCondition();
        if (ObjectUtil.isNotEmpty(attackCondition)) {
            attackCondition.setIdmId(idmId);
            attackConditionDao.insert(attackCondition);
        }

        ClinicalManifestations clinicalManifestations = caseDto.getClinicalManifestations();
        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
            clinicalManifestations.setIdmId(idmId);
            clinicalManifestationsDao.insert(clinicalManifestations);
        }

        LabExamine LabExamine = caseDto.getLabExamine();
        if (ObjectUtil.isNotEmpty(LabExamine)) {
            LabExamine.setIdmId(idmId);
            labExamineDao.insert(LabExamine);
        }

        EpidemiologicalSurvey epidemiologicalSurvey = caseDto.getEpidemiologicalSurvey();
        if (ObjectUtil.isNotEmpty(epidemiologicalSurvey)) {
            epidemiologicalSurvey.setIdmId(idmId);
            Long epId = epidemiologicalSurvey.getId();
            if(ObjectUtil.isNotEmpty(epId)){
            	epidemiologicalSurveyDao.update(epidemiologicalSurvey);
            }else{
            	epidemiologicalSurveyDao.insert(epidemiologicalSurvey);
            }
            
        }

        Diagnosis diagnosis = caseDto.getDiagnosis();
        if (ObjectUtil.isNotEmpty(diagnosis)) {
            diagnosis.setIdmId(idmId);
            diagnosisDao.insert(diagnosis);
        }

        PastHistory pastHistory = caseDto.getPastHistory();
        if (ObjectUtil.isNotEmpty(pastHistory)) {
            pastHistory.setIdmId(idmId);
            pastHistoryDao.insert(pastHistory);
        }

        InfectionSourceRoute infectionSourceRoute = caseDto.getInfectionSourceRoute();
        if (ObjectUtil.isNotEmpty(infectionSourceRoute)) {
            infectionSourceRoute.setIdmId(idmId);
            infectionSourceRouteDao.insert(infectionSourceRoute);
        }

        ExposureHistory exposureHistory = caseDto.getExposureHistory();
        if (ObjectUtil.isNotEmpty(exposureHistory)) {
            exposureHistory.setIdmId(idmId);
            exposureHistoryDao.insert(exposureHistory);
        }

        OtherCondition otherCondition = caseDto.getOtherCondition();
        if (ObjectUtil.isNotEmpty(otherCondition)) {
            otherCondition.setIdmId(idmId);
            IOtherConditionDao.insert(otherCondition);
        }

        BeforeDiseaseDiet beforeDiseaseDiet = caseDto.getBeforeDiseaseDiet();
        if (ObjectUtil.isNotEmpty(beforeDiseaseDiet)) {
            beforeDiseaseDiet.setIdmId(idmId);
            beforeDiseaseDietDao.insert(beforeDiseaseDiet);
        }

        CaseInformation caseInformation = caseDto.getCaseInformation();
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            caseInformation.setIdmId(idmId);
            caseInformationDao.insert(caseInformation);
        }

        HygienicCondition hygienicCondition = caseDto.getHygienicCondition();
        if (ObjectUtil.isNotEmpty(hygienicCondition)) {
            hygienicCondition.setIdmId(idmId);
            hygienicConditionDao.insert(hygienicCondition);
        }

        EpidemicFocusClose EpidemicFocusClose = caseDto.getEpidemicFocusClose();
        if (ObjectUtil.isNotEmpty(EpidemicFocusClose)) {
            EpidemicFocusClose.setIdmId(idmId);
            epidemicFocusCloseDao.insert(EpidemicFocusClose);
        }

        /*密切接触者新增时，删除（批量导入）*/
        Criteria ca = new Criteria("idmId", idmId);
        listEfcDao.delete(ca);
        listEsDao.delete(ca);
        
        List<ListEfc> idmListEfcs = caseDto.getIdmListEfcList();
        if (ObjectUtil.isNotEmpty(idmListEfcs)) {
            listEfcDao.batchInsert(idmListEfcs);
        }
        
        List<ListEfc> idmDisinfectList = caseDto.getIdmDisinfectList();
        if (ObjectUtil.isNotEmpty(idmDisinfectList)) {
            listEfcDao.batchInsert(idmDisinfectList);
        }

        List<ListEs> idmListEsList = caseDto.getIdmListEsList();
        if (ObjectUtil.isNotEmpty(idmListEsList)) {
            listEsDao.batchInsert(idmListEsList);
        }
        
        List<ListLe> idmListLeList = caseDto.getIdmListLeList();
        if (ObjectUtil.isNotEmpty(idmListLeList)){
        	listLeDao.batchInsert(idmListLeList);
        }
        
        List<ListBdd> idmListBddList = caseDto.getIdmListBddList();
        if (ObjectUtil.isNotEmpty(idmListBddList)){
        	listBddDao.batchInsert(idmListBddList);
        }
        /*发病前一周内逐日活动情况*/
        List<ListEs> idmEsActivityList = caseDto.getIdmListEsActivity();
        if (ObjectUtil.isNotEmpty(idmEsActivityList)){
        	listEsDao.batchInsert(idmEsActivityList);
        }
        
        /*发病前两周内接触动物*/
        List<ListEs> idmEsAnimalList = caseDto.getIdmListEsAnimal();
        if (ObjectUtil.isNotEmpty(idmEsAnimalList)){
        	listEsDao.batchInsert(idmEsAnimalList);
        }
 
        /*发病后至隔离治疗前逐日活动情况*/
        List<ListEs> idmEsLeaveList = caseDto.getIdmListEsLeave();
        if (ObjectUtil.isNotEmpty(idmEsLeaveList)){
        	listEsDao.batchInsert(idmEsLeaveList);
        }
 
        /*发病前2周内是否接触过非典病人或/和疑似非典患者*/
        List<ListEs> idmEsContactList = caseDto.getIdmListEsContact();
        if (ObjectUtil.isNotEmpty(idmEsContactList)){
        	listEsDao.batchInsert(idmEsContactList);
        }
  
        /*家庭、亲友*/
        List<ListEfc> idmEfcFamilyList = caseDto.getIdmListEfcFamily();
        if (ObjectUtil.isNotEmpty(idmEfcFamilyList)){
        	listEfcDao.batchInsert(idmEfcFamilyList);
        }
 
        /*工作单位或主要活动场所联系人*/
        List<ListEfc> idmEfcWorkOrgList = caseDto.getIdmListEfcWorkOrg();
        if (ObjectUtil.isNotEmpty(idmEfcWorkOrgList)){
        	listEfcDao.batchInsert(idmEfcWorkOrgList);
        }
        
        List<ListAc> idmListAcList = caseDto.getIdmListAcList();
        if (ObjectUtil.isNotEmpty(idmListAcList)){
            listAcDao.batchInsert(idmListAcList);
        }

        List<ListEh> idmListEhList = caseDto.getIdmListEhList();
        if (ObjectUtil.isNotEmpty(idmListEhList)){
            listEhDao.batchInsert(idmListEhList);
        }

        List<ListHc> idmListHcList = caseDto.getIdmListHcList();
        if (ObjectUtil.isNotEmpty(idmListHcList)){
            listHcDao.batchInsert(idmListHcList);
        }

/*        IdmStatusInfo statusInfo = new IdmStatusInfo(); 
        statusInfo.setCaseStatus(statusinfo.getCaseStatus());
//        statusInfo.setPixId(pixId);
        Long idmIdReal = eventInfoDao.get(idmId).getStatusId();
        idmStatusInfoDao.updateCaseStatus(statusInfo, new Criteria("ID", idmIdReal));*/
        Long idmIdReal = eventInfoDao.get(idmId).getStatusId();
        List<Map<String, Object>> updateRecords =  idmStatusInfoDao.getMapList(new Criteria("ID", idmIdReal), "ID","CASE_STATUS","CASE_PASS_STATUS");

	    //如果为第一次审核就通过，则该个案为合格。
  	    if(ObjectUtil.isNullOrEmpty(updateRecords.get(0).get("CASE_PASS_STATUS")) && ObjectUtil.equals(statusinfo.getCaseStatus(), "3")){
  		    updateRecords.get(0).put("CASE_PASS_STATUS", 1);
        }
  	    updateRecords.get(0).put("CASE_STATUS", statusinfo.getCaseStatus());   
  	    
  	    idmStatusInfoDao.batchMapUpdate(updateRecords, "ID", "CASE_STATUS","CASE_PASS_STATUS");
        result = true;
//      forCic(idmId, pastHistory.getAsthmaFlg(), clinicalManifestations.getEpilepticSeizure(), generalCondition.getIdcard());
        return result;
    }

    /**
     * 修改
     *
     * @param caseDto
     * @param statusinfo
     * @param personInfo
     * @return int
     */
    @Transactional
    public boolean updateCaseSurvey(CaseDto caseDto, IdmStatusInfo statusinfo, PersonInfo personInfo) throws Exception {
        boolean result = false;
        deleteCaseSurvey(caseDto.getIdmId(), new User());
        /*手足口病，批量导入患者接触史时已保存EpidemiologicalSurvey，故在更新时需要将ID设置为NULL*/
        EpidemiologicalSurvey ep = caseDto.getEpidemiologicalSurvey();
        if(ObjectUtil.isNotEmpty(ep)){
        	ep.setId(null);
        	caseDto.setEpidemiologicalSurvey(ep);
        }
        createCaseSurvey(caseDto, statusinfo, personInfo);
        result = true;
        return result;
    }

    /**
     * 删除
     *
     * @param idmIdStr
     * @param user
     * @return int
     */
    @Transactional
    public boolean deleteCaseSurvey(String idmIdStr, User user) {
        boolean result = false;
        Long idmId = Long.parseLong(idmIdStr);
        Criteria ca = new Criteria("idmId", idmId);

        generalConditionDao.delete(ca);

        attackConditionDao.delete(ca);

        clinicalManifestationsDao.delete(ca);

        labExamineDao.delete(ca);

        epidemiologicalSurveyDao.delete(ca);

        diagnosisDao.delete(ca);

        pastHistoryDao.delete(ca);

        infectionSourceRouteDao.delete(ca);

        exposureHistoryDao.delete(ca);

        IOtherConditionDao.delete(ca);

        beforeDiseaseDietDao.delete(ca);

        caseInformationDao.delete(ca);

        hygienicConditionDao.delete(ca);

        epidemicFocusCloseDao.delete(ca);

        listEfcDao.delete(ca);

        listEsDao.delete(ca);
        
        listLeDao.delete(ca);

        listBddDao.delete(ca);

        listAcDao.delete(ca);

        listEhDao.delete(ca);

        listHcDao.delete(ca);

        result = true;

        return result;
    }
    
    @Override
	public void createApprovalInfo(CaseApprovalInfo caseApprovalInfo) {
     	caseApprovalInfoDao.insert(caseApprovalInfo);    
    }

    /**
     * 批量删除
     *
     * @param idmIds
     * @param user
     * @return int
     */
    public int deleteCaseSurvey(User user, String... idmIds) {
        int result = 0;
        return result;
    }

    /**
     * 分页
     *
     * @param criteria
     * @param page
     * @return PageList<CaseDto>
     */
    public PageList<CaseDto> findCaseSurvey(Criteria criteria, Page page) {
        PageList<CaseDto> result = null;
        return result;
    }

    /**
     * 查看
     *
     * @param idmId
     * @return CaseDto
     */
    /* 
     * @see com.founder.rhip.idm.service.ICaseSurveyService#getCaseSurvey(java.lang.String)
     * @author Bao Jingbin
     */
    public CaseDto getCaseSurvey(String idmId) {
        CaseDto result = new CaseDto();

        Criteria ca = new Criteria("idmId",idmId);

        GeneralCondition generalCondition = generalConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(generalCondition)) {
            result.setGeneralCondition(generalCondition);
        }

        AttackCondition attackCondition = attackConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(attackCondition)) {
            result.setAttackCondition(attackCondition);
        }

        ClinicalManifestations clinicalManifestations = clinicalManifestationsDao.get(ca);
        if (ObjectUtil.isNotEmpty(clinicalManifestations)) {
            result.setClinicalManifestations(clinicalManifestations);
        }

        LabExamine LabExamine = labExamineDao.get(ca);
        if (ObjectUtil.isNotEmpty(LabExamine)) {
            result.setLabExamine(LabExamine);
        }

        EpidemiologicalSurvey epidemiologicalSurvey = epidemiologicalSurveyDao.get(ca);
        if (ObjectUtil.isNotEmpty(epidemiologicalSurvey)) {
            result.setEpidemiologicalSurvey(epidemiologicalSurvey);
        }

        Diagnosis diagnosis = diagnosisDao.get(ca);
        if (ObjectUtil.isNotEmpty(diagnosis)) {
            result.setDiagnosis(diagnosis);
        }

        PastHistory pastHistory = pastHistoryDao.get(ca);
        if (ObjectUtil.isNotEmpty(pastHistory)) {
            result.setPastHistory(pastHistory);
        }

        InfectionSourceRoute infectionSourceRoute = infectionSourceRouteDao.get(ca);
        if (ObjectUtil.isNotEmpty(infectionSourceRoute)) {
            result.setInfectionSourceRoute(infectionSourceRoute);
        }

        ExposureHistory exposureHistory = exposureHistoryDao.get(ca);
        if (ObjectUtil.isNotEmpty(exposureHistory)) {
            result.setExposureHistory(exposureHistory);
        }

        OtherCondition otherCondition = IOtherConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(otherCondition)) {
            result.setOtherCondition(otherCondition);
        }

        BeforeDiseaseDiet beforeDiseaseDiet = beforeDiseaseDietDao.get(ca);
        if (ObjectUtil.isNotEmpty(beforeDiseaseDiet)) {
            result.setBeforeDiseaseDiet(beforeDiseaseDiet);
        }

        CaseInformation caseInformation = caseInformationDao.get(ca);
        if (ObjectUtil.isNotEmpty(caseInformation)) {
            result.setCaseInformation(caseInformation);
        }

        HygienicCondition hygienicCondition = hygienicConditionDao.get(ca);
        if (ObjectUtil.isNotEmpty(hygienicCondition)) {
            result.setHygienicCondition(hygienicCondition);
        }

        EpidemicFocusClose epidemicFocusClose = epidemicFocusCloseDao.get(ca);
        if (ObjectUtil.isNotEmpty(epidemicFocusClose)) {
            result.setEpidemicFocusClose(epidemicFocusClose);
        }

        Criteria caEfc = new Criteria("IDM_ID", OP.EQ,idmId).add("object", OP.IS,"NULL");
        List<ListEfc> idmListEfcList = listEfcDao.getList(caEfc);
        if (ObjectUtil.isNotEmpty(idmListEfcList)) {
            result.setIdmListEfcList(idmListEfcList);
        }

        Criteria caDis = new Criteria("IDM_ID", OP.EQ,idmId).add("object", OP.UEMPTY,"");
        List<ListEfc> idmDisinfectList = listEfcDao.getList(caDis);
        if (ObjectUtil.isNotEmpty(idmDisinfectList)) {
            result.setIdmDisinfectList(idmDisinfectList);
        }
        /*发病前一周内逐日活动情况*/
        Criteria activityCa = new Criteria("IDM_ID", OP.EQ,idmId).add("flag","1");
        List<ListEs> idmEsActivityList = listEsDao.getList(activityCa);
        if (ObjectUtil.isNotEmpty(idmEsActivityList)) {
            result.setIdmListEsActivity(idmEsActivityList);
        }
        /*发病前两周内接触动物*/
        Criteria animalCa = new Criteria("IDM_ID", OP.EQ,idmId).add("flag","2");
        List<ListEs> idmEsAnimalList = listEsDao.getList(animalCa);
        if (ObjectUtil.isNotEmpty(idmEsAnimalList)) {
            result.setIdmListEsAnimal(idmEsAnimalList);
        }
 
        /*发病后至隔离治疗前逐日活动情况*/
        Criteria leaveCa = new Criteria("IDM_ID", OP.EQ,idmId).add("flag","3");
        List<ListEs> idmEsLeaveList = listEsDao.getList(leaveCa);
        if (ObjectUtil.isNotEmpty(idmEsLeaveList)) {
            result.setIdmListEsLeave(idmEsLeaveList);
        }
 
        /*发病后至隔离治疗前逐日活动情况*/
        Criteria contactCa = new Criteria("IDM_ID", OP.EQ,idmId).add("flag","5");
        List<ListEs> idmEsContactList = listEsDao.getList(contactCa);
        if (ObjectUtil.isNotEmpty(idmEsContactList)) {
            result.setIdmListEsContact(idmEsContactList);
        }
 
        /*家庭、亲友*/
        Criteria familyCa = new Criteria("IDM_ID", OP.EQ,idmId).add("flag","6");
        List<ListEfc> idmEfcFamilyList = listEfcDao.getList(familyCa);
        if (ObjectUtil.isNotEmpty(idmEfcFamilyList)) {
            result.setIdmListEfcFamily(idmEfcFamilyList);
        }
        
        /*工作单位或主要活动场所联系人*/
        Criteria workOrgCa = new Criteria("IDM_ID", OP.EQ,idmId).add("flag","7");
        List<ListEfc> idmEfcWorkOrgList = listEfcDao.getList(workOrgCa);
        if (ObjectUtil.isNotEmpty(idmEfcWorkOrgList)) {
            result.setIdmListEfcWorkOrg(idmEfcWorkOrgList);
        }
        
        List<ListEs> idmListEsList = listEsDao.getList(ca);

        if (ObjectUtil.isNotEmpty(idmListEsList)) {
            result.setIdmListEsList(idmListEsList);
        }

        List<ListLe> idmListLeList = listLeDao.getList(ca);
        if (ObjectUtil.isNotEmpty(idmListLeList)) {
        	result.setIdmListLeList(idmListLeList);
        }
        
        List<ListBdd> idmListBddList = listBddDao.getList(ca);
        if (ObjectUtil.isNotEmpty(idmListBddList)) {
        	result.setIdmListBddList(idmListBddList);
        }

        List<ListAc> idmListAcList = listAcDao.getList(ca);
        if (ObjectUtil.isNotEmpty(idmListAcList)) {
            result.setIdmListAcList(idmListAcList);
        }

        List<ListEh> idmListEhList = listEhDao.getList(ca);
        if (ObjectUtil.isNotEmpty(idmListEhList)) {
            result.setIdmListEhList(idmListEhList);
        }

        List<ListHc> idmListHcList = listHcDao.getList(ca);
        if (ObjectUtil.isNotEmpty(idmListHcList)) {
            result.setIdmListHcList(idmListHcList);
        }
        
        return result;
    }

    /**
     * 导入数据-密接接触者-手足口病-患者接触史
     *
     * @param dataList
     * @return int
     */
    @Override
    @Transactional    
	public int importEsContactDatas(List<ListEs> dataList) {
        if (ObjectUtil.isNotEmpty(dataList)) {
        	listEsDao.batchInsert(dataList);
        }
        return dataList.size();   	
    }
    
    /**
     * 导入数据-密接接触者
     *
     * @param dataList
     * @return int
     */
    @Override
    @Transactional    
	public int importContactedDatas(List<ListEfc> dataList) {
        if (ObjectUtil.isNotEmpty(dataList)) {
        	listEfcDao.batchInsert(dataList);
        }
        return dataList.size();   	
    }
    
    /**
     * 导入数据-密接接触者
     *
     * @param dataList
     * @return int
     */
    @Override
    @Transactional    
	public int importAnorectaDatas(List<IdmAnorectaReportTable> dataList) {
        if (ObjectUtil.isNotEmpty(dataList)) {
        	anorectaReportTableDao.batchInsert(dataList);
        }
        return dataList.size();   	
    }
    
    @Override
    public List<Map<String, Object>> getAnorectaStatisticsList(Criteria ca) {
		/*List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		mapList = caseInformationDao.getCaseToStandardMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);*/
    	List<Map<String, Object>> mapList = anorectaReportTableDao.statisticsAnorecta(ca);
		return mapList;
	}
    
    
    /**
     * 获取密接接触者列表
     *
     * @param ca
     * @return CaseDto
     */
    public CaseDto findcontacted(Criteria ca){
    	CaseDto result = new CaseDto();
    	List<ListEfc> idmListEfcList = listEfcDao.getList(ca);
        if (ObjectUtil.isNotEmpty(idmListEfcList)) {
            result.setIdmListEfcList(idmListEfcList);
        }
      
    	return result;
    }
 
    /**
     * 获取密接接触者列表--手足口病
     *
     * @param ca
     * @return CaseDto
     */
    public CaseDto findcontact(Criteria ca){
    	CaseDto result = new CaseDto();
        Criteria caEs = new Criteria("IDM_ID",ca.get("IDM_ID"));
    	List<ListEs> idmListEsList = listEsDao.getList(ca);
        if (ObjectUtil.isNotEmpty(idmListEsList)) {
            result.setIdmListEsList(idmListEsList);
        }

        EpidemiologicalSurvey epidemiologicalSurvey = epidemiologicalSurveyDao.get(caEs);
        if (ObjectUtil.isNotEmpty(epidemiologicalSurvey)) {
            result.setEpidemiologicalSurvey(epidemiologicalSurvey);
        }          
    	return result;
    }

    /**
     * 保存患者接触史信息
     *
     * @param caseDto
     * @return boolean
     */
    @Transactional
    public boolean saveCaseEs(CaseDto caseDto) throws Exception {
        int result = 0;
        Long idmId = Long.parseLong(caseDto.getIdmId());
        Criteria ca = new Criteria("idmId", idmId);
        List<ListEs> idmEsList = caseDto.getIdmListEsList();
        if(ObjectUtil.isNotEmpty(caseDto)){
        	EpidemiologicalSurvey epidemiologicalSurvey  = caseDto.getEpidemiologicalSurvey();
        	if(ObjectUtil.isNotEmpty(epidemiologicalSurvey)){
        		Long id = epidemiologicalSurvey.getId();
        		if(ObjectUtil.isNullOrEmpty(id)){
        			epidemiologicalSurvey.setIdmId(idmId);
        			epidemiologicalSurveyDao.insert(epidemiologicalSurvey);
        		}
        	}
        }
        if(ObjectUtil.isNotEmpty(idmEsList)){
            listEsDao.delete(ca);
            for(ListEs es:idmEsList){
            	es.setIdmId(idmId);
            }
            if (ObjectUtil.isNotEmpty(idmEsList)) {
            	result = listEsDao.batchInsert(idmEsList);
            }            
        }
        return result == 0?false:true;
    }
    
    /**
     * 保存密切接触者信息
     *
     * @param caseDto
     * @return boolean
     */
    @Transactional
    public boolean saveCaseEfc(CaseDto caseDto) throws Exception {
        int result = 0;
        Long idmId = Long.parseLong(caseDto.getIdmId());
        Criteria ca = new Criteria("idmId", idmId);
        String flag;

        List<ListEfc> idmListEfcs = caseDto.getIdmListEfcList();
        if(ObjectUtil.isNotEmpty(idmListEfcs)){
        	flag = idmListEfcs.get(0).getFlag();
            if(StringUtil.isNotEmpty(flag) && !flag.equals("0")){
            	ca.add("flag", flag);
            }   
            listEfcDao.delete(ca);
            for(ListEfc efc:idmListEfcs){
            	efc.setIdmId(idmId);
            }
            if (ObjectUtil.isNotEmpty(idmListEfcs)) {
            	result = listEfcDao.batchInsert(idmListEfcs);
            }            
        }
 
        return result == 0?false:true;
    }    
    /**
     * 保存患者信息
     * @param caseDto
     * @return
     * @throws Exception
     */
    private String SavePerson(CaseDto caseDto) throws Exception {
        PersonInfo personInfo = caseDto.getPersonInfo();
        return haInterfaceService.updatePersonInfo(personInfo);
    }

    /**
     * 更新哮喘、癫痫信息（新市民）
     * @param idmId
     */
    private void forCic(Long idmId, String asthmaFlg, String epilepticSeizure, String idCard){
        CicTarget cicTarget = new CicTarget();

        //哮喘
        if("1".equals(asthmaFlg)){
            cicTarget.setAsthmaFlag("T");
        }else {
            cicTarget.setAsthmaFlag("F");
        }
        //癫痫
        if("1".equals(epilepticSeizure)){
            cicTarget.setEpilepsyFlag("T");
        }else {
            cicTarget.setEpilepsyFlag("F");
        }

        Set<String> properties = new HashSet<String>();
        properties.add("asthmaFlag");
        properties.add("epilepsyFlag");
        properties.add("idcard");

        EventInfo eventInfo = eventInfoDao.get(new Criteria("ID", idmId));
        IdmStatusInfo statusInfo = idmStatusInfoDao.get(new Criteria("ID", eventInfo.getStatusId()));
        cicTarget.setPersonId(String.valueOf(statusInfo.getPersonId()));
        cicTarget.setIdcard(idCard);
        cicTargetService.saveTargetValue(cicTarget, properties);


//        clinicalManifestationsDao
    }
    /**
     * 分配个案
     *
     * @param caseOperateLog
     * @param statusInfo
     * @return
     */
    @Transactional
    public int assignCase(CaseOperateLog caseOperateLog,IdmStatusInfo statusInfo) {
    	//查询被分配的机构是否有该病权限
    	Criteria ca = new Criteria("caseOrganCode",statusInfo.getAssignedToUnit());
    	//ca.add("setYear", OP.EQ, DateUtil.getCurrentYear()); //2017-6-12修改 个案参数设置跟年份无关（不再按照每年设置一次）
    	ca.add("infectiousCode", caseOperateLog.getInfectiousCode());
    	//如果手动分配为纳入操作，则清空 分配至机构 字段
    	if(ObjectUtil.equals(AssignmentStatus.ASSIGNED.getValue().toString(), statusInfo.getAssignmentStatus())){
    		statusInfo.setAssignedToUnit("");
    	}
 	    List<IdmSetup> setups = setupService.findSetup(ca);
 	    int res = 0;
		if(setups.size()>0){
			res = idmStatusInfoDao.update(statusInfo, "assignmentStatus","assignedToUnit","currentUnit");
	    	if( res > 0){
	    		caseOperateLogDao.insert(caseOperateLog);
	    	}
		} 
    	return res;
    }
  
    @Override
    public List<Map<String, Object>> getCaseStatisticsMapList(Map<String, String> paramMap) {
		/*List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		mapList = caseInformationDao.getCaseToStandardMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);*/
    	List<Map<String, Object>> mapList = caseInformationDao.getCaseToStandardMapList(paramMap);
		return mapList;
	}
    
    public int invalidCase(String idmId){
    	Parameters param = new Parameters();
    	param.add("VALID_CASE_STATUS", "0");//作废报卡 状态为 0
    	Long statusId = eventInfoDao.get(Long.parseLong(idmId)).getStatusId();
    	return idmStatusInfoDao.update(param, new Criteria("id", statusId));
    }
    
    protected List<Map<String, Object>> matchTowns(List<Map<String, Object>> mapList, Map<String, String> paramMap) {
		List<Map<String, Object>> destMapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(mapList) || ObjectUtil.isNullOrEmpty(paramMap)) {
			return destMapList;
		}
		List<Map<String, Object>> addMapList = new ArrayList<Map<String,Object>>();
		Map<String, Object> totalMap = null;
		String genreCode = paramMap.get("genreCode");
		String gbCode = paramMap.get("gbCode");
		if (ObjectUtil.equals(genreCode, "0") && ObjectUtil.isNullOrEmpty(gbCode) && ObjectUtil.isNotEmpty(mapList)) {
			totalMap = mapList.get(mapList.size() - 1);
			mapList.remove(mapList.size() - 1);
			//获取所有的镇
			Criteria criteria = new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT);
			List<DicItem> dicItems = dictionaryApp.queryDicItem(criteria);
			for (DicItem dicItem : dicItems) {
				boolean flag = true;
				for (Map<String, Object> map : mapList) {
					if (StringUtils.equals(dicItem.getItemCode(), String.valueOf(map.get("gb_code")))) {
						flag = false;
					}
				}
				if (flag) {
					Map<String, Object> m = new HashMap<String, Object>();
					m.put("gb_code", dicItem.getItemCode());
					addMapList.add(m);
				}
			}
		}
		if (ObjectUtil.isNotEmpty(addMapList)) {
			destMapList.addAll(mapList);
			destMapList.addAll(addMapList);
			destMapList.add(totalMap);
			return destMapList;
		} else {
			if(ObjectUtil.isNotEmpty(totalMap)){
				mapList.add(totalMap);
			}
			return mapList;
		}
	}
}