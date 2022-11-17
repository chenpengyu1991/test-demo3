/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.idm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.repository.control.idm.special.*;
import com.founder.rhip.ehr.repository.control.idm.statistics.report.IListScDcDao;
import com.founder.rhip.ehr.repository.control.idm.statistics.report.ISelfCheckDao;
import com.founder.rhip.ehr.repository.control.idm.statistics.report.IStatisticsDataDao;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("mergerOrgService")
public class IdmMergerOrgListenerImpl extends AbstractService implements IMergerOrganizationListener {

	   @Autowired
	    private IPlatformService personService;

	    @Resource(name = "idmStatusInfoDao")
	    private IIdmStatusInfoDao idmStatusInfoDao;        //状态表

	    @Resource(name = "caseInformationDao")
	    private ICaseInformationDao caseInformationDao;     //卡片信息

	    @Resource(name = "generalConditionDao")
	    private IGeneralConditionDao generalConditionDao;

	    @Resource(name = "eventInfoDao")
	    private IEventInfoDao eventInfoDao;

	    @Resource(name = "idmReportDao")
	    private IIdmReportDao idmReportDao;

	    @Resource(name = "otherConditionDao")
	    private IOtherConditionDao otherConditionDao;     //其他

	    @Resource(name = "attackConditionDao")
	    private IAttackConditionDao attackConditionDao;     //发病情况

	    @Resource(name = "idmListFgDao")
	    private IListFgDao idmListFgDao;     //

	    @Resource(name = "idmListAiDao")
	    private IListAiDao idmListAiDao;     //

	    @Resource(name = "organizationApp")
	    private IOrganizationApp organizationApp;     //
	    
	    @Resource(name="caseApprovalInfoDao")
        ICaseApprovalInfoDao caseApprovalInfoDao;
		
		@Resource(name="caseOperateLogDao")
        ICaseOperateLogDao caseOperateLogDao;
		
		@Resource(name="clinicalManifestationsDao")
        IClinicalManifestationsDao clinicalManifestationsDao;
		
		@Resource(name="diagnosisDao")
        IDiagnosisDao diagnosisDao;
		
		@Resource(name="epidemicFocusCloseDao")
        IEpidemicFocusCloseDao epidemicFocusCloseDao;
		
		@Resource(name="epidemiologicalSurveyDao")
        IEpidemiologicalSurveyDao epidemiologicalSurveyDao;
		
		@Resource(name="idmOutpatientLogDao")
        IIdmOutpatientLogDao idmOutpatientLogDao;
		
		@Resource(name="idmInpatientLogDao")
        IIdmInpatientLogDao idmInpatientLogDao;
		
		@Resource(name="idmApprovalInfoDao")
        IIdmApprovalInfoDao idmApprovalInfoDao;
		
		@Resource(name="idmAnorectaReportTableDao")
        IIdmAnorectaReportTableDao idmAnorectaReportTableDao;
		
		@Resource(name="exposureHistoryDao")
        IExposureHistoryDao exposureHistoryDao;

		@Resource(name="labExamineDao")
        ILabExamineDao labExamineDao;

		@Resource(name="listHcDao")
        IListHcDao listHcDao;
		
		@Resource(name="listEhDao")
        IListEhDao listEhDao;

		@Resource(name="idmSetupDao")
        ISetupDao idmSetupDao;
		
		@Resource(name="pastHistoryDao")
        IPastHistoryDao pastHistoryDao;
		
		@Resource(name="idmReportDescDao")
        IIdmReportDescDao idmReportDescDao;
		
	    @Resource(name="statisticsDataDao")
        IStatisticsDataDao statisticsDataDao;
	    
	    @Resource(name="idmListFrDao")
        IListFrDao idmListFrDao;
	    
	    @Resource(name="idmScDcDao")
        IListScDcDao idmScDcDao;

	    @Resource(name="idmSelfCheckDao")
        ISelfCheckDao idmSelfCheckDao;
			       
	    @Resource(name="idmDrugCardDao")
        IDrugCardDao idmDrugCardDao;
	    
	    @Resource(name="idmListAsDao")
        IListAsDao idmListAsDao;
	    
	    @Resource(name="idmListCcDao")
        IListCcDao idmListCcDao;
	    
	    @Resource(name="idmListCrDao")
        IListCrDao idmListCrDao;
	    
	    @Resource(name="idmListDdDao")
        IListDdDao idmListDdDao;
	    
	    @Resource(name="idmListEddDao")
        IListEddDao idmListEddDao;
	    
	    @Resource(name="idmListLcDao")
        IListLcDao idmListLcDao;
	    
	    @Resource(name="idmListRrDao")
        IListRrDao idmListRrDao;
	    
	    @Resource(name="idmListSdDao")
        IListSdDao idmListSdDao;
	    
	    @Resource(name="listTrDao")
        IListTrDao listTrDao;

	    @Resource(name="idmListTsDao")
        IListTsDao idmListTsDao;

    /**
     * 站合并（包括同一个中心下和不同中心下）
     * @param station 合并后的站
     * @param stationList 被合并的站列表
     */
    @Override
    @Transactional
    public void mergeStation(Organization station, List<Organization> stationList){
        List<String> stationCodes = new ArrayList<>();
        List<String> stationNames = new ArrayList<>();
        for(Organization org : stationList){
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
            stationNames.add(org.getOrganName());
        }
        //备份数据
        //saveReportHistory(stationCodes);
        //saveStatusHistory(stationCodes);
        //saveCaseInfoHistory(stationCodes);

        //结核病接受单位为站且状态为已接受（status.special_status=7）时，需更新上级指派机构（中心 status.LAST_UNIT）
//        Criteria ca = new Criteria("CURRENT_UNIT", OP.IN, stationCodes);
//        ca.add("SPECIAL_STATUS", 7);
//        ca.add("IDM_TYPE", 2);
//        Parameters parameter = new Parameters();
//        parameter.add("LAST_UNIT", station.getParentCode());i
//        idmStatusInfoDao.update(parameter, ca);

        //更新数据
        updateReport(station, stationCodes);
        updateCaseInfo(station, stationCodes,stationNames);
        updateStatus(station, stationCodes);
        updateOtherOrgans(station, stationCodes,stationNames);
    }

    /**
     * 中心合并
     * @param center  合并后的中心
     * @param centerList 被合并的中心列表
     */
    @Override
    public void mergeCenter(Organization center, List<Organization> centerList){
        List<String> centerCodes = new ArrayList<>();
        List<String> centerNames = new ArrayList<>();
        for(Organization org : centerList){
            String centerCode = org.getOrganCode();
            centerCodes.add(centerCode);
            centerNames.add(org.getOrganName());
        }
        //备份数据
        //saveReportHistory(centerCodes);
        //saveStatusHistory(centerCodes);
        //saveCaseInfoHistory(centerCodes);

        //更新数据
        updateReport(center, centerCodes);
        updateCaseInfo(center, centerCodes, centerNames);
        updateStatus(center, centerCodes);
        updateOtherOrgans(center, centerCodes, centerNames);
    }

    /**
     * 站转移
     * @param center 转移后的中心
     * @param stationList 被转移的站列表
     */
    @Override
    public void moveStation(Organization center, List<Organization> stationList){
        //转移后 肺结核模块 专用病历指派到站的数据 其中心code需要更新为新的中心code 2020.12.17
        List<String> stationCodes = new ArrayList<>();
        for(Organization org : stationList){
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        Criteria ca = new Criteria("CURRENT_UNIT", OP.IN, stationCodes);
        Parameters parameter = new Parameters();
        parameter.add("LAST_UNIT", center.getOrganCode());
        idmStatusInfoDao.update(parameter, ca);
       /* List<String> stationCodes = new ArrayList<>();
        for(Organization org : stationList){
            String stationCode = org.getOrganCode();
            stationCodes.add(stationCode);
        }
        //结核病接受单位为站且状态为已接受（status.special_status=7）时，需更新上级指派机构（中心 status.LAST_UNIT）
        Criteria ca = new Criteria("CURRENT_UNIT", OP.IN, stationCodes);
        ca.add("SPECIAL_STATUS", 7);
        ca.add("IDM_TYPE", 2);

        Parameters parameter = new Parameters();
        parameter.add("LAST_UNIT", center.getOrganCode());
        idmStatusInfoDao.update(parameter, ca);*/

    }

    /**
     * 机构（站）村关系变化时响应的接口 orgCode机构编码 newAddVillageCodes机构中新增加的村
     * @param orgCode
     * @param newAddVillageCodes
     */
    @Override
    public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
        Criteria ca = new Criteria();
        ca.add("INFECTIOUS_CODE", "311");
        ca.add("PASTREET", OP.IN, newAddVillageCodes);
        List<IdmReport> reports = idmReportDao.getList(ca);
        idmReportDao.update(new Parameters("FILL_ORGAN_CODE",orgCode),ca);
        List<Long> statusIds = new ArrayList<Long>();
        for(IdmReport report : reports){
            Long singleId = report.getIdmId();
            Long statusId = eventInfoDao.get(singleId).getStatusId();
            statusIds.add(statusId);
        }
        HistoryRecorder.record(idmStatusInfoDao, new Criteria("ID", OP.IN, statusIds), new String[]{"ID", "CURRENT_UNIT", "CURRENT_TOWN"});

        Organization org = organizationApp.queryOrgan(orgCode);
        Parameters parameters = new Parameters();
        parameters.add("CURRENT_UNIT", org.getParentCode());
        parameters.add("CURRENT_TOWN", org.getGbCode());
        idmStatusInfoDao.update(parameters, new Criteria("ID", OP.IN, statusIds));

        //只有手足口病随访的管理机构与现住址有关
//        List organList = new ArrayList();
//        List orgCodeList = new ArrayList();
//            for(String villageCode : newAddVillageCodes){
//                Organization org = organizationApp.queryOrganByVillage(villageCode);
//                if(ObjectUtil.isNotEmpty(org)){
//                    organList.add(org);
//                    orgCodeList.add(org.getParentCode());
//                }
//            }
//        //备份数据
//        Criteria caStatus = new Criteria("CURRENT_UNIT", OP.IN, orgCodeList);
////        caStatus.add("INFECTIOUS_CODE", "311");
//        HistoryRecorder.record(idmStatusInfoDao, caStatus, new String[]{"ID", "CURRENT_UNIT", "CURRENT_TOWN"});
//        //更新数据
//        Organization station = organizationApp.queryOrgan(orgCode);
//        Parameters parameters = new Parameters();
//        parameters.add("CURRENT_UNIT", station.getParentCode());
//        idmStatusInfoDao.update(parameters, caStatus);


    }
   
    private void saveCaseInfoHistory(List<String> organCodes){
        Criteria caCaseInfo = new Criteria();
        caCaseInfo.add("SURVEY_ORG", OP.IN, organCodes);
        caCaseInfo.add(LOP.OR, new Criteria("MODIFY_SURVEY_ORG", OP.IN, organCodes));
        caCaseInfo.add(LOP.OR, new Criteria("REVIEW_UNIT", OP.IN, organCodes));
        caCaseInfo.add(LOP.OR, new Criteria("TRANSFER_TREATMENT_UNIT", OP.IN, organCodes));
        caCaseInfo.add(LOP.OR, new Criteria("REPORT_ORG", OP.IN, organCodes));
        HistoryRecorder.record(caseInformationDao, caCaseInfo, new String[]{"ID", "SURVEY_ORG", "MODIFY_SURVEY_ORG", "REVIEW_UNIT", "TRANSFER_TREATMENT_UNIT", "REPORT_ORG"});
    }

    private void saveReportHistory(List<String> organCodes){
        Criteria reStatus = new Criteria();
        reStatus.add("FILL_ORGAN_CODE", OP.IN, organCodes);
        HistoryRecorder.record(idmReportDao, reStatus, new String[]{"ID", "INFECTIOUS_CODE", "IDM_ID", "FILL_ORGAN_CODE", "FILL_ORGAN_NAME"});
    }

    private void saveStatusHistory(List<String> organCodes){
        Criteria caStatus = new Criteria();
        caStatus.add("CURRENT_UNIT", OP.IN, organCodes);
        caStatus.add(LOP.OR, new Criteria("CURRENT_TOWN", OP.IN, organCodes));
        caStatus.add(LOP.OR, new Criteria("LAST_UNIT", OP.IN, organCodes));
        caStatus.add(LOP.OR, new Criteria("LAST_TOWN", OP.IN, organCodes));
        HistoryRecorder.record(idmStatusInfoDao, caStatus, new String[]{"ID", "CURRENT_UNIT", "CURRENT_TOWN", "LAST_UNIT", "LAST_TOWN"});
    }

    private void updateCaseInfo(Organization newOrgCode, List orgCodes, List organNames){
        caseInformationDao.update(createParam("SURVEY_ORG", newOrgCode.getOrganCode()), createCa("SURVEY_ORG", orgCodes));
        caseInformationDao.update(createParam("MODIFY_SURVEY_ORG", newOrgCode.getOrganCode()), createCa("MODIFY_SURVEY_ORG", orgCodes));
        caseInformationDao.update(createParam("REVIEW_UNIT", newOrgCode.getOrganCode()), createCa("REVIEW_UNIT", orgCodes));
        caseInformationDao.update(createParam("TRANSFER_TREATMENT_UNIT", newOrgCode.getOrganCode()), createCa("TRANSFER_TREATMENT_UNIT", orgCodes));
        caseInformationDao.update(createParam("REPORT_ORG", newOrgCode.getOrganCode()), createCa("REPORT_ORG", orgCodes));
        caseInformationDao.update(createParam("CASE_FILL_ORG", newOrgCode.getOrganCode()), createCa("CASE_FILL_ORG", orgCodes));
        //机构数据只有名称
        caseInformationDao.update(createParam("FIRST_FOUND_ORG", newOrgCode.getOrganCode()), createCa("FIRST_FOUND_ORG", orgCodes));
        caseInformationDao.update(createParam("FIRST_REPORT_ORG", newOrgCode.getOrganCode()), createCa("FIRST_REPORT_ORG", orgCodes));
        caseInformationDao.update(createParam("RECEIVE_REPORT_ORG", newOrgCode.getOrganCode()), createCa("RECEIVE_REPORT_ORG", orgCodes));
        caseInformationDao.update(createParam("RECOMMEND_UNIT", newOrgCode.getOrganCode()), createCa("RECOMMEND_UNIT", orgCodes));
        caseInformationDao.update(createParam("NETWORK_REPORT_ORG", newOrgCode.getOrganCode()), createCa("NETWORK_REPORT_ORG", orgCodes));
        caseInformationDao.update(createParam("MODIFY_UNIT", newOrgCode.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
        caseInformationDao.update(createParam("ACCEPT_UNIT", newOrgCode.getOrganCode()), createCa("ACCEPT_UNIT", orgCodes));
    }

    private void updateReport(Organization newOrgCode, List orgCodes){
        Parameters parameter = new Parameters();
        parameter.add("FILL_ORGAN_CODE", newOrgCode.getOrganCode());
        parameter.add("FILL_ORGAN_NAME", newOrgCode.getOrganName());
        idmReportDao.update(parameter, createCa("FILL_ORGAN_CODE", orgCodes));
    }

    private void updateStatus(Organization newOrgCode, List orgCodes){

        Parameters parameterCu = new Parameters();
        parameterCu.add("CURRENT_UNIT", newOrgCode.getOrganCode());
        parameterCu.add("CURRENT_TOWN", newOrgCode.getGbCode());

        Parameters parameterLast = new Parameters();
        parameterLast.add("LAST_UNIT", newOrgCode.getOrganCode());
        parameterLast.add("LAST_TOWN", newOrgCode.getGbCode());

        idmStatusInfoDao.update(parameterCu, createCa("CURRENT_UNIT", orgCodes));
//        idmStatusInfoDao.update(createParam("CURRENT_TOWN", newOrgCode.getGbCode()), createCa("CURRENT_TOWN", orgCodes));
        idmStatusInfoDao.update(parameterLast, createCa("LAST_UNIT", orgCodes));
//        idmStatusInfoDao.update(createParam("LAST_TOWN", newOrgCode.getGbCode()), createCa("LAST_TOWN", orgCodes));
        idmStatusInfoDao.update(createParam("ASSIGNED_TO_UNIT",newOrgCode.getOrganCode()), createCa("ASSIGNED_TO_UNIT", orgCodes));
    }
    
    private void updateOtherOrgans(Organization newOrg, List orgCodes, List organNames){
    	
    	caseApprovalInfoDao.update(createParam("UNIT_CODE", newOrg.getOrganCode()), createCa("UNIT_CODE", orgCodes));
    	caseApprovalInfoDao.update(createParam("BACK_TO_UNIT", newOrg.getOrganCode()), createCa("BACK_TO_UNIT", orgCodes));
    	
    	caseOperateLogDao.update(createParam("ASSIGN_UNIT", newOrg.getOrganCode()), createCa("ASSIGN_UNIT", orgCodes));
    	caseOperateLogDao.update(createParam("RECEIVING_UNIT", newOrg.getOrganCode()), createCa("RECEIVING_UNIT", orgCodes));
    	caseOperateLogDao.update(createParam("CREATE_ORGAN_CODE", newOrg.getOrganCode()), createCa("CREATE_ORGAN_CODE", orgCodes));
    	
    	clinicalManifestationsDao.update(createParam("ORG_DIAGNOSTICS_WRITE", newOrg.getOrganName()), createCa("ORG_DIAGNOSTICS_WRITE", organNames));
    	//clinicalManifestationsDao.update(createParam("ORG_DIAGNOSTICS_SELECT", newOrg.getOrganName()), createCa("ORG_DIAGNOSTICS_SELECT", organNames));
    	//clinicalManifestationsDao.update(createParam("MEDICAL_ORG_F", newOrg.getOrganName()), createCa("MEDICAL_ORG_F", organNames));

    	diagnosisDao.update(createParam("DIAGNOSIS_UNIT", newOrg.getOrganCode()), createCa("DIAGNOSIS_UNIT", orgCodes));
    	//diagnosisDao.update(createParam("FOLLOW_UP_UNIT", newOrg.getOrganCode()), createCa("FOLLOW_UP_UNIT", orgCodes));

    	epidemicFocusCloseDao.update(createParam("REPORT_ORG", newOrg.getOrganCode()), createCa("REPORT_ORG", orgCodes));

    	epidemiologicalSurveyDao.update(createParam("DIAGNOSIS_UNIT", newOrg.getOrganCode()), createCa("DIAGNOSIS_UNIT", orgCodes));

    	exposureHistoryDao.update(createParam("DONATE_BLOOD_UNIT", newOrg.getOrganName()), createCa("DONATE_BLOOD_UNIT", organNames));
    	exposureHistoryDao.update(createParam("RECEPTION_BLOOD_UNIT",  newOrg.getOrganName()), createCa("RECEPTION_BLOOD_UNIT", organNames));
    	exposureHistoryDao.update(createParam("OPERATION_UNIT",  newOrg.getOrganName()), createCa("OPERATION_UNIT", organNames));
    	//exposureHistoryDao.update(createParam("HOSPITAL_UNIT",  newOrg.getOrganName()), createCa("HOSPITAL_UNIT", organNames));
    	//exposureHistoryDao.update(createParam("IVT_UNIT",  newOrg.getOrganName()), createCa("IVT_UNIT", organNames));
    	exposureHistoryDao.update(createParam("ACUPUNCTURE_UNIT",  newOrg.getOrganName()), createCa("ACUPUNCTURE_UNIT", organNames));
    	//exposureHistoryDao.update(createParam("INTRAVENOUS_INJECTION_UNIT",  newOrg.getOrganName()), createCa("INTRAVENOUS_INJECTION_UNIT", organNames));
    	//exposureHistoryDao.update(createParam("VACCINATION_UNIT",  newOrg.getOrganName()), createCa("VACCINATION_UNIT", organNames));
    	exposureHistoryDao.update(createParam("TOOTH_UNIT",  newOrg.getOrganName()), createCa("TOOTH_UNIT", organNames));
    	exposureHistoryDao.update(createParam("FIRST_BLOOD_SUPPLY_UNIT",  newOrg.getOrganName()), createCa("FIRST_BLOOD_SUPPLY_UNIT", organNames));
    	exposureHistoryDao.update(createParam("LAST_BLOOD_SUPPLY_UNIT",  newOrg.getOrganName()), createCa("LAST_BLOOD_SUPPLY_UNIT", organNames));
    	exposureHistoryDao.update(createParam("FIRST_PLASMA_SUPPLY_UNIT",  newOrg.getOrganName()), createCa("FIRST_PLASMA_SUPPLY_UNIT", organNames));
    	exposureHistoryDao.update(createParam("LAST_PLASMA_SUPPLY_UNIT",  newOrg.getOrganName()), createCa("LAST_PLASMA_SUPPLY_UNIT", organNames));

    	idmAnorectaReportTableDao.update(createParam("FILL_ORGAN_CODE", newOrg.getOrganCode()), createCa("FILL_ORGAN_CODE", orgCodes));
    	
    	idmApprovalInfoDao.update(createParam("UNIT_CODE", newOrg.getOrganCode()), createCa("UNIT_CODE", orgCodes));
    	idmApprovalInfoDao.update(createParam("NEXT_UNIT", newOrg.getOrganCode()), createCa("NEXT_UNIT", orgCodes));
    	
    	idmInpatientLogDao.update(createParam("CLINIC_ORGAN_CODE", newOrg.getOrganCode()).add("CLINIC_ORGAN_Name", newOrg.getOrganName()), createCa("CLINIC_ORGAN_CODE", orgCodes));
    	
    	idmOutpatientLogDao.update(createParam("CLINIC_ORGAN_CODE", newOrg.getOrganCode()).add("CLINIC_ORGAN_Name", newOrg.getOrganName()), createCa("CLINIC_ORGAN_CODE", orgCodes));
            	
    	idmSetupDao.update(createParam("CREATE_UNIT_CODE", newOrg.getOrganCode()), createCa("CREATE_UNIT_CODE", orgCodes));
    	idmSetupDao.update(createParam("MODIFY_UNIT_CODE", newOrg.getOrganCode()), createCa("MODIFY_UNIT_CODE", orgCodes));
    	idmSetupDao.update(createParam("CASE_ORGAN_CODE", newOrg.getOrganCode()), createCa("CASE_ORGAN_CODE", orgCodes));


    	listEhDao.update(createParam("SEPARATE_UNIT", newOrg.getOrganCode()), createCa("SEPARATE_UNIT", orgCodes));
    	listEhDao.update(createParam("SEPARATE_UNIT", newOrg.getOrganName()), createCa("SEPARATE_UNIT", organNames));
    	
    	listHcDao.update(createParam("DETECTION_UNIT", newOrg.getOrganCode()), createCa("DETECTION_UNIT", orgCodes));
    	listHcDao.update(createParam("DETECTION_UNIT", newOrg.getOrganName()), createCa("DETECTION_UNIT", organNames));
    	
    	labExamineDao.update(createParam("FIRST_SERUM_RECENT_ORG", newOrg.getOrganCode()), createCa("FIRST_SERUM_RECENT_ORG", orgCodes));
    	labExamineDao.update(createParam("FIRST_SERUM_RECENT_ORG", newOrg.getOrganName()), createCa("FIRST_SERUM_RECENT_ORG", organNames));
    	labExamineDao.update(createParam("SECONED_SERUM_RECENT_ORG", newOrg.getOrganCode()), createCa("SECONED_SERUM_RECENT_ORG", orgCodes));
    	labExamineDao.update(createParam("SECONED_SERUM_RECENT_ORG", newOrg.getOrganName()), createCa("SECONED_SERUM_RECENT_ORG", organNames));
    	labExamineDao.update(createParam("IGG_ORG", newOrg.getOrganCode()), createCa("IGG_ORG", orgCodes));
    	labExamineDao.update(createParam("IGG_ORG", newOrg.getOrganName()), createCa("IGG_ORG", organNames));
    	 
    	idmReportDescDao.update(createParam("CHECK_POSITIVE_UNIT", newOrg.getOrganCode()), createCa("CHECK_POSITIVE_UNIT", orgCodes));
    	idmReportDescDao.update(createParam("CHECK_POSITIVE_UNIT", newOrg.getOrganName()), createCa("CHECK_POSITIVE_UNIT", organNames));
    	
       
       otherConditionDao.update(createParam("DIAGNOSIS_UNIT", newOrg.getOrganCode()), createCa("DIAGNOSIS_UNIT", orgCodes));
       otherConditionDao.update(createParam("DIAGNOSIS_UNIT", newOrg.getOrganName()), createCa("DIAGNOSIS_UNIT", organNames));
       otherConditionDao.update(createParam("CURE_UNIT", newOrg.getOrganCode()), createCa("CURE_UNIT", orgCodes));
       otherConditionDao.update(createParam("CURE_UNIT", newOrg.getOrganName()), createCa("CURE_UNIT", organNames));
       
       pastHistoryDao.update(createParam("EHF_DIAGNOSE_UNIT", newOrg.getOrganCode()), createCa("EHF_DIAGNOSE_UNIT", orgCodes));
       pastHistoryDao.update(createParam("EHF_DIAGNOSE_UNIT", newOrg.getOrganName()), createCa("EHF_DIAGNOSE_UNIT", organNames));
       pastHistoryDao.update(createParam("TREAT_UNIT", newOrg.getOrganCode()), createCa("TREAT_UNIT", orgCodes));
       pastHistoryDao.update(createParam("TREAT_UNIT", newOrg.getOrganName()), createCa("TREAT_UNIT", organNames));

       idmDrugCardDao.update(createParam("ORG_CODE", newOrg.getOrganCode()), createCa("ORG_CODE", orgCodes));
       
       idmListAiDao.update(createParam("ACCEPT_UNIT", newOrg.getOrganName()), createCa("ACCEPT_UNIT", organNames));
       idmListAiDao.update(createParam("ACCEPT_UNIT", newOrg.getOrganCode()), createCa("ACCEPT_UNIT", orgCodes));
       
       
       idmListAsDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListAsDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListAsDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListAsDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       idmListCcDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListCcDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListCcDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListCcDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       idmListCrDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListCrDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListCrDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListCrDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       idmListDdDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListDdDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListDdDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListDdDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       idmListEddDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListEddDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListEddDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListEddDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       idmListLcDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListLcDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListLcDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListLcDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       idmListRrDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListRrDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListRrDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListRrDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       idmListSdDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListSdDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListSdDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListSdDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       listTrDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       listTrDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       listTrDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       listTrDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       idmListTsDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListTsDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListTsDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListTsDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       
       idmScDcDao.update(createParam("REPORT_UNIT_CODE", newOrg.getOrganCode()), createCa("REPORT_UNIT_CODE", orgCodes));
       
       idmSelfCheckDao.update(createParam("REPORT_UNIT_CODE", newOrg.getOrganCode()), createCa("REPORT_UNIT_CODE", orgCodes));
       idmSelfCheckDao.update(createParam("MODIFY_UNIT_CODE", newOrg.getOrganCode()), createCa("MODIFY_UNIT_CODE", orgCodes));
       idmSelfCheckDao.update(createParam("GENRE_CODE", newOrg.getGenreCode()), createCa("REPORT_UNIT_CODE", orgCodes));

       statisticsDataDao.update(createParam("FILL_ORGAN_CODE", newOrg.getOrganCode()), createCa("FILL_ORGAN_CODE", orgCodes));
       statisticsDataDao.update(createParam("GENRE_CODE", newOrg.getGenreCode()), createCa("FILL_ORGAN_CODE", orgCodes));
       
       idmListFgDao.update(createParam("REPORT_ORG", newOrg.getOrganName()), createCa("REPORT_ORG", organNames));
       idmListFgDao.update(createParam("REPORT_ORG", newOrg.getOrganCode()), createCa("REPORT_ORG", orgCodes));
       idmListFgDao.update(createParam("ACCEPT_UNIT", newOrg.getOrganName()), createCa("ACCEPT_UNIT", organNames));
       idmListFgDao.update(createParam("ACCEPT_UNIT", newOrg.getOrganCode()), createCa("ACCEPT_UNIT", orgCodes));
       
       idmListFrDao.update(createParam("VISIT_INST", newOrg.getOrganName()), createCa("VISIT_INST", organNames));
       idmListFrDao.update(createParam("VISIT_INST", newOrg.getOrganCode()), createCa("VISIT_INST", orgCodes));
       //idmListFrDao.update(createParam("FOLLOW_UP_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       //idmListFrDao.update(createParam("FOLLOW_UP_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListFrDao.update(createParam("CREATE_UNIT", newOrg.getOrganName()), createCa("CREATE_UNIT", organNames));
       idmListFrDao.update(createParam("CREATE_UNIT", newOrg.getOrganCode()), createCa("CREATE_UNIT", orgCodes));
       idmListFrDao.update(createParam("MODIFY_UNIT", newOrg.getOrganName()), createCa("MODIFY_UNIT", organNames));
       idmListFrDao.update(createParam("MODIFY_UNIT", newOrg.getOrganCode()), createCa("MODIFY_UNIT", orgCodes));
       idmListFrDao.update(createParam("TRANSFER_UNIT", newOrg.getOrganName()), createCa("TRANSFER_UNIT", organNames));
       idmListFrDao.update(createParam("TRANSFER_UNIT", newOrg.getOrganCode()), createCa("TRANSFER_UNIT", orgCodes));
  
    }
    
    
    private Criteria createCa(String field, List orgCodes){
        Criteria ca = new Criteria();
        ca.add(field, OP.IN, orgCodes);
        return ca;
    }

    private Parameters createParam(String field, String orgCode){
        Parameters parameter = new Parameters();
        parameter.add(field, orgCode);
        return parameter;
    }


}