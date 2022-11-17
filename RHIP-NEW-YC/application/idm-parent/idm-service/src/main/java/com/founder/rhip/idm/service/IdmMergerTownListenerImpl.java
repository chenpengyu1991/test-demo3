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
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.control.idm.notifiabledisease.*;
import com.founder.rhip.ehr.repository.control.idm.special.*;
import com.founder.rhip.ehr.repository.ism.IApprovalInfoDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.service.IDictionaryService;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("mergerTownService")
public class IdmMergerTownListenerImpl extends AbstractService implements IMergerTownListener {
	 @Resource(name = "idmReportDao")
	    private IIdmReportDao idmReportDao;        //״̬��

	    @Resource(name = "idmStatusInfoDao")
	    private IIdmStatusInfoDao idmStatusInfoDao;        //״̬��

	    @Resource(name = "caseInformationDao")
	    private ICaseInformationDao caseInformationDao;     //��Ƭ��Ϣ

	    @Resource(name = "idmListFgDao")
	    private IListFgDao idmListFgDao;     //

	    @Resource(name = "idmListAiDao")
	    private IListAiDao idmListAiDao;     //

	    @Resource(name = "idmListFrDao")
	    private IListFrDao idmListFrDao;     //

	    @Resource(name = "generalConditionDao")
	    private IGeneralConditionDao generalConditionDao;    //һ�����

	    @Resource(name="mdmDictionaryService")
	    private IDictionaryService dictionaryService;

	    @Resource(name = "exposureHistoryDao")
	    private IExposureHistoryDao exposureHistoryDao;     //��¶ʷ

	    @Resource(name = "dictionaryApp")
	    private IDictionaryApp dictionaryApp;
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
	   	
	   	@Resource(name="isApprovalInfoDao")
        IApprovalInfoDao isApprovalInfoDao;
	   	
	   	@Resource(name="idmAnorectaReportTableDao")
        IIdmAnorectaReportTableDao idmAnorectaReportTableDao;

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
	   	
		@Resource(name="attackConditionDao")
        IAttackConditionDao attackConditionDao;
		
		@Resource(name="infectionSourceRouteDao")
        IInfectionSourceRouteDao infectionSourceRouteDao;
		
		@Resource(name="idmDrugCardDao")
        IDrugCardDao idmDrugCardDao;

		 @Resource(name="idmListScDao")
         IListScDao idmListScDao;

	    /**
	     * ����ϲ�
	     * @param newTownCode �ϲ�����������
	     * @param oldTownCode ���ϲ����������
	     */
	    @Override
	    public void mergeTown(String newTownCode, String[] oldTownCode) {    	
	    	
	        //�������
	        Criteria caPa = new Criteria("PATOWN_SHIP", OP.IN, oldTownCode);
	        Criteria caHr = new Criteria("HRTOWN_SHIP", OP.IN, oldTownCode);
	        caPa.add(LOP.OR, caHr);
	        //Criteria caReport = new Criteria();
	        //HistoryRecorder.record(idmReportDao, caReport.add(caPa), new String[]{"ID", "IDM_ID", "PATOWN_SHIP", "PASTREET", "HRTOWN_SHIP", "HRSTREET"});

	        Criteria caStatus = new Criteria("CURRENT_TOWN", OP.IN, oldTownCode);
	        caStatus.add(LOP.OR, new Criteria("LAST_TOWN", OP.IN, oldTownCode));
	        //HistoryRecorder.record(idmStatusInfoDao, caStatus, new String[]{"ID", "CURRENT_TOWN", "LAST_TOWN"});

	        //Criteria caCaseInfo = new Criteria("ACCEPT_TOWN", OP.IN, oldTownCode);
	        //HistoryRecorder.record(caseInformationDao, caCaseInfo, new String[]{"ID","ACCEPT_TOWN"});

	       // Criteria caFg = new Criteria("ACCEPT_TOWN", OP.IN, oldTownCode);
	        //HistoryRecorder.record(idmListFgDao, caFg, new String[]{"ID","ACCEPT_TOWN"});

	        //Criteria caAi = new Criteria("ACCEPT_TOWN", OP.IN, oldTownCode);
	        //HistoryRecorder.record(idmListAiDao, caAi, new String[]{"ID","ACCEPT_TOWN"});

	        Criteria caGenPa = new Criteria("PATOWN_SHIP", OP.IN, oldTownCode);
	        Criteria caGenHr = new Criteria("HRTOWN_SHIP", OP.IN, oldTownCode);
	        caGenPa.add(LOP.OR, caGenHr);
	        //Criteria caOr = new Criteria();
	        //HistoryRecorder.record(generalConditionDao, caOr.add(caGenPa), new String[]{"ID","PATOWN_SHIP", "PASTREET", "HRTOWN_SHIP", "HRSTREET"});

	        //Criteria caExp = new Criteria("ADDR_RURAL", OP.IN, oldTownCode);
	       // HistoryRecorder.record(exposureHistoryDao, caExp, new String[]{"ID","ADDR_RURAL"});

	        //Criteria criteriaSt = new Criteria("PATOWN_SHIP", OP.IN, oldTownCode);
	        //HistoryRecorder.record(idmListFrDao, criteriaSt, new String[]{"ID", "PATOWN_SHIP","PASTREET"});

	        //�������
	        Parameters paramReport = new Parameters();
	        paramReport.add("PATOWN_SHIP", newTownCode);
	        idmReportDao.update(paramReport, new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));
	        paramReport = new Parameters();
	        paramReport.add("HRTOWN_SHIP", newTownCode);
	        idmReportDao.update(paramReport, new Criteria("HRTOWN_SHIP", OP.IN, oldTownCode));
	        paramReport = new Parameters();
	        paramReport.add("UATOWN_SHIP", newTownCode);
	        idmReportDao.update(paramReport, new Criteria("UATOWN_SHIP", OP.IN, oldTownCode));
	        

	        Parameters paramStatusC = new Parameters();
	        paramStatusC.add("CURRENT_TOWN", newTownCode);
	        idmStatusInfoDao.update(paramStatusC, new Criteria("CURRENT_TOWN", OP.IN, oldTownCode));
	        Parameters paramStatusL = new Parameters();
	        paramStatusL.add("LAST_TOWN", newTownCode);
	        idmStatusInfoDao.update(paramStatusL, new Criteria("LAST_TOWN", OP.IN, oldTownCode));

	        Parameters paramCase = new Parameters();
	        paramCase.add("ACCEPT_TOWN", newTownCode);
	        caseInformationDao.update(paramCase, new Criteria("ACCEPT_TOWN", OP.IN, oldTownCode));

	        Parameters acceptTownFg = new Parameters();
	        acceptTownFg.add("ACCEPT_TOWN", newTownCode);
	        idmListFgDao.update(acceptTownFg, new Criteria("ACCEPT_TOWN", OP.IN, oldTownCode));

	        Parameters acceptUnitAi = new Parameters();
	        acceptUnitAi.add("ACCEPT_TOWN", newTownCode);
	        idmListAiDao.update(acceptUnitAi, new Criteria("ACCEPT_TOWN", OP.IN, oldTownCode));

	        Parameters paTownShip = new Parameters();
	        paTownShip.add("PATOWN_SHIP", newTownCode);
	        Parameters hrTownShip = new Parameters();
	        hrTownShip.add("HRTOWN_SHIP", newTownCode);
	        generalConditionDao.update(paTownShip, new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));
	        generalConditionDao.update(hrTownShip,  new Criteria("HRTOWN_SHIP", OP.IN, oldTownCode));
	        generalConditionDao.update(new Parameters("TITLE_CITY", newTownCode),  new Criteria("TITLE_CITY", OP.IN, oldTownCode));
	        generalConditionDao.update(new Parameters("RETOWN_SHIP", newTownCode),  new Criteria("RETOWN_SHIP", OP.IN, oldTownCode));
	        generalConditionDao.update(new Parameters("ADDRESS_GBCODE", newTownCode),  new Criteria("ADDRESS_GBCODE", OP.IN, oldTownCode));
	        generalConditionDao.update(new Parameters("RESIDENCE_GBCODE", newTownCode),  new Criteria("RESIDENCE_GBCODE", OP.IN, oldTownCode));
	        generalConditionDao.update(new Parameters("GBCODE", newTownCode),  new Criteria("GBCODE", OP.IN, oldTownCode));

	        
	        DicItem dicItemNew = dictionaryService.getDicItem("FS990001", newTownCode);
	        String newTownName = "";
	        if(ObjectUtil.isNotEmpty(dicItemNew)){
	            newTownName = dicItemNew.getItemName();
	        }
//	        //����������סַ
//	        for(String oldCode : oldTownCode){
//	            String oldTownName = "";
//	            DicItem dicItemOld = dictionaryService.getDicItem("FS990001", oldCode);
//	            if(ObjectUtil.isNotEmpty(dicItemOld)){
//	                oldTownName = dicItemOld.getItemName();
//	            }
	//
//	            if(StringUtil.isNotEmpty(oldTownName) && StringUtil.isNotEmpty(newTownName)){
//	                idmReportDao.updatePaAddress(oldCode, oldTownName, newTownName);
//	                generalConditionDao.updatePaAddress(oldCode, oldTownName, newTownName);
//	                idmListFrDao.updatePaAddress(oldCode, oldTownName, newTownName);
//	            }
//	        }

	       // Parameters paExp = new Parameters();
	       // paExp.add("ADDR_RURAL", newTownCode);
	       // exposureHistoryDao.update(paExp,  new Criteria("ADDR_RURAL", OP.IN, oldTownCode));
	   
	        attackConditionDao.update(new Parameters("ACTOWN_SHIP", newTownCode),  new Criteria("ACTOWN_SHIP", OP.IN, oldTownCode));
	        attackConditionDao.update(new Parameters("GBCODE", newTownCode),  new Criteria("GBCODE", OP.IN, oldTownCode));

	       	idmOutpatientLogDao.update(new Parameters("PATOWN_SHIP", newTownCode),  new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));

	       	idmInpatientLogDao.update(new Parameters("PATOWN_SHIP", newTownCode),  new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));
	    	pastHistoryDao.update(new Parameters("ATTACK_TOWN_SHIP", newTownCode),  new Criteria("ATTACK_TOWN_SHIP", OP.IN, oldTownCode));
	    	pastHistoryDao.update(new Parameters("LAST_TREAT_TOWN_SHIP", newTownCode),  new Criteria("LAST_TREAT_TOWN_SHIP", OP.IN, oldTownCode));

	    	infectionSourceRouteDao.update(new Parameters("STRANGER_FROM_TOWN_SHIP", newTownCode),  new Criteria("STRANGER_FROM_TOWN_SHIP", OP.IN, oldTownCode));
	    	infectionSourceRouteDao.update(new Parameters("OUT_TOWN_SHIP", newTownCode),  new Criteria("OUT_TOWN_SHIP", OP.IN, oldTownCode));

	    	idmDrugCardDao.update(new Parameters("PATOWN_SHIP", newTownCode),  new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));
	    	
	    	idmListAiDao.update(new Parameters("CHECK_TOWN_SHIP", newTownCode),  new Criteria("CHECK_TOWN_SHIP", OP.IN, oldTownCode));
	    	idmListAiDao.update(new Parameters("ACCEPT_TOWN", newTownCode),  new Criteria("ACCEPT_TOWN", OP.IN, oldTownCode));
	    	
	    	idmListScDao.update(new Parameters("PATOWN_SHIP", newTownCode),  new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));

	    	idmListFgDao.update(new Parameters("PATOWN_SHIP", newTownCode),  new Criteria("PATOWN_SHIP", OP.IN, oldTownCode));
	    	idmListFgDao.update(new Parameters("ACCEPT_TOWN", newTownCode),  new Criteria("ACCEPT_TOWN", OP.IN, oldTownCode));

	    }

	    /**
	     * ����ϵ�仯ʱ��Ӧ�Ľӿ� townCode����� newAddVillageCodes���������ӵĴ�
	     * @param townCode
	     * @param newAddVillageCodes
	     */
	    @Override
	    public void sendTownVillageRelation(String townCode, String[] newAddVillageCodes) {
	        Criteria caSt = new Criteria("PASTREET", OP.IN, newAddVillageCodes);
	        Criteria caHr = new Criteria("HRSTREET", OP.IN, newAddVillageCodes);
	        caSt.add(LOP.OR, caHr);
	        Criteria caOr = new Criteria();

	        Parameters paTownShip = new Parameters();
	        paTownShip.add("PATOWN_SHIP", townCode);

	        Parameters hrTownShip = new Parameters();
	        hrTownShip.add("HRTOWN_SHIP", townCode);

	        //�������
	        HistoryRecorder.record(idmReportDao, caOr.add(caSt), new String[]{"ID", "IDM_ID", "PATOWN_SHIP", "PASTREET", "HRTOWN_SHIP", "HRSTREET"});
	        HistoryRecorder.record(generalConditionDao, caOr.add(caSt), new String[]{"ID", "PATOWN_SHIP", "PASTREET", "HRTOWN_SHIP", "HRSTREET"});
	        HistoryRecorder.record(idmListFrDao, new Criteria("PASTREET", OP.IN, newAddVillageCodes), new String[]{"ID", "PATOWN_SHIP","PASTREET"});

	        //������� 
	        generalConditionDao.update(paTownShip, new Criteria("PASTREET", OP.IN, newAddVillageCodes));
	        generalConditionDao.update(hrTownShip, new Criteria("HRSTREET", OP.IN, newAddVillageCodes));
	        generalConditionDao.update(new Parameters("TITLE_CITY", townCode), new Criteria("TITLE_TOWN", OP.IN, newAddVillageCodes));
	        idmReportDao.update(paTownShip, new Criteria("PASTREET", OP.IN, newAddVillageCodes));
	        idmReportDao.update(hrTownShip, new Criteria("HRSTREET", OP.IN, newAddVillageCodes));
	        idmListFrDao.update(paTownShip, new Criteria("PASTREET", OP.IN, newAddVillageCodes));
	        idmDrugCardDao.update(paTownShip, new Criteria("PASTREET", OP.IN, newAddVillageCodes));

//	        Parameters hrTownShip = new Parameters();
//	        hrTownShip.add("HRTOWN_SHIP", townCode);
//	        Criteria criteriaHr = new Criteria();
//	        criteriaHr.add("HRSTREET", OP.IN, newAddVillageCodes);
//	        generalConditionDao.update(hrTownShip,criteriaHr);
//	        idmReportDao.update(hrTownShip,criteriaHr);
	        
	        DicItem dicItemTown = dictionaryService.getDicItem("FS990001", townCode);
	        String townName = dicItemTown.getItemName();
	        for(String villageCode : newAddVillageCodes){
	        	DicItem dicItemVillage = dictionaryService.getDicItem("FS990001", villageCode);
	            String villageName = dicItemVillage.getItemName();
	            if(StringUtil.isNotEmpty(townName) && StringUtil.isNotEmpty(villageName)){
	                generalConditionDao.updatePaAddress2(villageCode, townName, villageName);
	                generalConditionDao.updateHrAddress2(villageCode, townName, villageName);
	            }
	        }
	        for(String villageCode : newAddVillageCodes){
	            DicItem dicItemVillage = dictionaryService.getDicItem("FS990001", villageCode);
	            String villageName = dicItemVillage.getItemName();
	            if(StringUtil.isNotEmpty(townName) && StringUtil.isNotEmpty(villageName)){
	                idmReportDao.updatePaAddress2(villageCode, townName, villageName);
	                idmReportDao.updateHrAddress2(villageCode, townName, villageName);
	            }
	        }
	        
	        
	        for(String villageCode : newAddVillageCodes){
	            DicItem dicItemVillage = dictionaryService.getDicItem("FS990001", villageCode);
	            String villageName = dicItemVillage.getItemName();
	            if(StringUtil.isNotEmpty(townName) && StringUtil.isNotEmpty(villageName)){
	                idmListFrDao.updatePaAddress2(villageCode, townName, villageName);
	            }
	        }
	    }
	}