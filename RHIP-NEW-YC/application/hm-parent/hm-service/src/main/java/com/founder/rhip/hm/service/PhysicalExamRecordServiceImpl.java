/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Founder.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hm.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.IDCardUtil;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.dto.PersonalPhyExamDTO;
import com.founder.rhip.ehr.entity.basic.ElderlyHealthStatistics;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.basic.User;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyExamination;
import com.founder.rhip.ehr.entity.clinic.ElderlyPhyStatus;
import com.founder.rhip.ehr.entity.clinic.HealthEvaluateAnomaly;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.ech.EchIdentification;
import com.founder.rhip.ehr.entity.summary.DrugHistory;
import com.founder.rhip.ehr.entity.summary.FamilyBedHistory;
import com.founder.rhip.ehr.entity.summary.HospitalizedHistory;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyExaminationDao;
import com.founder.rhip.ehr.repository.clinic.IElderlyPhyStatusDao;
import com.founder.rhip.ehr.repository.clinic.IHealthEvaluateAnomalyDao;
import com.founder.rhip.ehr.repository.clinic.IHealthExaminationDao;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.ech.IEchIdentificationDao;
import com.founder.rhip.ehr.repository.statistics.IElderlyHealthStatisticsDao;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.repository.summary.IDrugHistoryDao;
import com.founder.rhip.ehr.repository.summary.IFamilyBedHistoryDao;
import com.founder.rhip.ehr.repository.summary.IHospitalizedHistoryDao;
import com.founder.rhip.ehr.service.IPersonCancelListener;
import com.founder.rhip.ehr.service.basic.IEHRNumberService;
import com.founder.rhip.ehr.service.personal.IPersonRecordMoveService;
import com.founder.rhip.ehr.service.personal.IPlatformService;
import com.founder.rhip.ehr.service.sync.IServiceSyncLogService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerTownListener;

@Service("physicalExamRecordService")
public class PhysicalExamRecordServiceImpl extends BaseHmService implements IPersonCancelListener,
    IPhysicalExamRecordService, IPersonRecordMoveService,
        /**IMergerOrganizationListener,**/IMergerTownListener {

	private static final String ORGCODE = "orgCode";
	private static final String CENTERCODE = "centerCode";
	private static final String GBCODE = "gbcode";

    private String[] guideProp = {
        "healthEvaluateAnomalyFlag", "guideIntoChronicDisease", "guideRegularFollowup",
        "guideSuggestionReview", "guideSuggestionReferral", "riskQuitSmoking",
        "riskHealthDrink", "riskDiet", "riskExercise", "riskWeightReduction",
        "riskWeightTarget", "guideVaccination", "guideVaccinationDesc", "riskOther",
        "riskOtherDesc"
    };

    private String[] assessProp = {
        "healthSelfAssessment", "lifeAbilitySelfAssessment",
        "cognitionScreenResult", "cognitionScreenScore",
        "emotionScreenResult", "depressionScore", "eatingAssessment",
        "cleaningAssessment", "clothingAssessment", "defecationAssessment",
        "exerciseAssessment"
    };

    //老年人健康指导与评价参数
    private final String[] evaluateProp = {"healthSelfAssessment", "lifeAbilitySelfAssessment",
        "eatingAssessment","cleaningAssessment", "clothingAssessment", "defecationAssessment", "exerciseAssessment",
        "cognitionScreenResult","cognitionScreenScore", "emotionScreenResult", "depressionScore", "guideIntoChronicDisease",
        "guideSuggestionReview","guideSuggestionReferral","riskQuitSmoking","riskHealthDrink","riskDiet","riskExercise",
        "riskWeightReduction","riskWeightTarget","guideVaccination","guideVaccinationDesc","riskOther","riskOtherDesc"};


    private static boolean _reflashVerifyLock = false;

    @Resource(name = "physicalExamRecordDao")
    private IPhysicalExamRecordDao physicalExamRecordDao;

    @Resource(name = "elderlyHealthStatisticsDao")
    private IElderlyHealthStatisticsDao elderlyHealthStatisticsDao;

    @Resource(name = "elderlyPhyExaminationDao")
    private IElderlyPhyExaminationDao elderlyPhyExaminationDao;

    @Resource(name = "platformService")
    private IPlatformService platformService;

    @Resource(name = "healthExaminationDao")
    private IHealthExaminationDao healthExaminationDao;

    @Autowired
    private IOrganizationApp organizationApp;

    @Resource(name = "ehrHealthEventDao")
    private IEHRHealthEventDao ehrHealthEventDao;

    @Resource(name = "healthEvaluateAnomalyDao")
    private IHealthEvaluateAnomalyDao healthEvaluateAnomalyDao;

    @Resource(name = "hospitalizedHistoryDao")
    private IHospitalizedHistoryDao hospitalizedHistoryDao;
    @Resource(name = "familyBedHistoryDao")
    IFamilyBedHistoryDao familyBedHistoryDao;

    @Resource(name = "drugHistoryDao")
    private IDrugHistoryDao drugHistoryDao;
    @Resource(name = "vaccinationInfoDao")
    private IVaccinationInfoDao vaccinationInfoDao;

    @Resource(name = "personInfoDao")
    private IPersonInfoDao personInfoDao;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Resource(name = "EHRNumberService")
	private IEHRNumberService EHRNumberService;

	@Resource(name = "serviceSyncLogService")
	private IServiceSyncLogService serviceSyncLogService;
	
  	@Resource(name = "elderlyPhyStatusDao")
  	private IElderlyPhyStatusDao elderlyPhyStatusDao;
  	
	@Resource(name = "echIdentificationDao")
	private IEchIdentificationDao echIdentificationDao;

    /**
     * 数据获取
     * @param       criteria
     * @return PhysicalExamRecord
     */
    @Override
    public PhysicalExamRecord getPhysicalExamRecord(Criteria criteria) {
        return physicalExamRecordDao.get(criteria);
    }

    /**
     * 数据获取
     * @param       criteria
     * @return List<PhysicalExamRecord>
     */
    public List<PhysicalExamRecord> getPhysicalExamRecords(Criteria criteria) {
        return physicalExamRecordDao.getList(criteria);
    }

    /**
     * 数据获取
     * @param       page
     * @param       criteria
     * @return List<PhysicalExamRecord>
     */
    @Override
    public PageList<PhysicalExamRecord> getPhysicalExamRecords(Page page, Criteria criteria) {
        return physicalExamRecordDao.getPageList(page, criteria);
    }

    /**
     * 更新本年度待体检人员名单
     * @throws Exception
     */
    public void reflashVerify(Criteria criteria) throws Exception {
        if (_reflashVerifyLock) {
            throw new Exception("其他用户正在更新，请稍等...");
        }
        //大于65岁的老年人,已建档的
        Date birth = DateUtil.getBirthdayByAge(65);
        criteria.add("birthday", OP.LT, DateUtil.lastDateOfYear(birth));
        criteria.add("filingFlag", "1");
        final Criteria c = criteria;
        synchronized (this) {
            _reflashVerifyLock = true;
            try {
            	PageableDateSource.exec(new IDataSource<PersonInfo>() {

                    @Override
                    public PageList<PersonInfo> get(Page page) {
                        return personInfoDao.getPageListAndNotInRecord(page, c);
                    }
                    @Override
                    public void run(List<PersonInfo> list) {
                    	List<PhysicalExamRecord> insertList = new ArrayList<PhysicalExamRecord>();
                    	
                    	for (PersonInfo personInfo : list) {
                    		if (ObjectUtil.isNullOrEmpty(personInfo.getInputOrganCode())) {
                    			continue;
                    		}
                    		PhysicalExamRecord phr = new PhysicalExamRecord();
                    		phr.setPersonId(personInfo.getId());
                    		phr.setName(personInfo.getName());
                    		phr.setIdcard(personInfo.getIdcard());
                    		phr.setBirthday(personInfo.getBirthday());
                    		phr.setConfirm(0); // 默认状态为0
                    		phr.setGender(personInfo.getGender());
                    		phr.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
                    		phr.setInputOrganCode(personInfo.getInputOrganCode());
                    		phr.setInputSuperOrganCode(personInfo.getInputCenterOrganCode());
                    		phr.setGbcode(personInfo.getInputGbcode());
                    		phr.setExamYear(new Date());
                    		phr.setMarriage(personInfo.getMarriage());
                    		phr.setTelephone(personInfo.getHomePhone());
                    		phr.setMoible(personInfo.getPhoneNumber());
                    		phr.seteMail(personInfo.getEmail());
                    		phr.setLogoff(0); // 默认状态为0 注销标志（0正常，1注销）
                    		phr.setHealthFileNo(personInfo.getHealthFileNo());//健康档案编号
                    		insertList.add(phr);
                    	}
                    	
                    	if(ObjectUtil.isNotEmpty(insertList)) {
                    		physicalExamRecordDao.batchInsert(insertList);
                    	}
                    }
            	});
            } catch (Exception e) {
                throw e;
            } finally {
                _reflashVerifyLock = false;
            }
        }
        ;
    }

    /**
     * 核实确认体检人员
     */
    @Transactional
    public void confirmExamRecord(String organCode, String[] ids) {
        String examNoPre =
            organCode.substring(organCode.length() - 4, organCode.length()) + DateUtil
                .getCurrentYear();
        int serNo = findMaxExamNo(examNoPre);
        List<Map<String, Object>> values = new ArrayList<Map<String, Object>>();
        for (String id : ids) {
            PhysicalExamRecord record = physicalExamRecordDao.get(Long.parseLong(id));
            if (record.getConfirm() == 0) {
                Map<String, Object> val = new HashMap<String, Object>();
                values.add(val);

                val.put("id", id);
                val.put("examNumber", examNoPre + String.format("%05d", ++serNo));
                val.put("confirm", 1);
            }
        }
        physicalExamRecordDao.batchMapUpdate(values, "examNumber", "confirm");
        values.clear();
        values = null;
    }

    /**
     * 取消核实体检人员
     */
    @Override
    public void cancelConfirmExamRecord(String organCode, String[] ids) {
        List<Map<String, Object>> values = new ArrayList<Map<String, Object>>();
        for (String id : ids) {
            Map<String, Object> val = new HashMap<String, Object>();
            values.add(val);

            val.put("id", id);
            val.put("examNumber", null);
            val.put("confirm", 0);
        }
        physicalExamRecordDao.batchMapUpdate(values, "examNumber", "confirm");
        values.clear();
        values = null;
    }

    /**
     * 更新体检记录
     * @param       physicalExamRecord
     * @param       properties
     * @return boolean
     */
    public boolean updatePhysicalExamRecord(PhysicalExamRecord physicalExamRecord,
        String... properties) {
        boolean result = true;
        if (ObjectUtil.isNotEmpty(physicalExamRecord)) {
            int rt = physicalExamRecordDao.update(physicalExamRecord, properties);
            if (rt == 0) {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * 创建体检记录
     * @param       physicalExamRecord
     * @return boolean
     */
    public boolean createPhysicalExamRecord(PhysicalExamRecord physicalExamRecord) {
        boolean result = true;
        if (ObjectUtil.isNotEmpty(physicalExamRecord)) {
            int rt = physicalExamRecordDao.insert(physicalExamRecord);
            if (rt == 0) {
                result = false;
            }
        } else {
            result = false;
        }
        return result;
    }

    /**
     * 体质辨识列表数据获取
     * @param       page
     * @param       criteria
     * @return List<PhysicalExamRecord>
     */
    public PageList<PhysicalExamRecord> getEchExamRecords(Page page, Criteria criteria) {
        return physicalExamRecordDao.getEchPhysicalExams(page, criteria);
    }

    @Override
    public List<Map<String, Object>> exportEchExamRecords(Page page, Criteria criteria) {
        return physicalExamRecordDao.exportEchPhysicalExams(page, criteria);
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
    private void processPersonRecord(List<Map<String, Object>> persons) {
        final int COUNT = 1000;
        //Criteria criteria = new Criteria("TO_CHAR(examYear,'YYYY')", DateUtil.getCurrentYear());
        List personIds = new ArrayList();
        List ids = new ArrayList();
        List updateList = new ArrayList();
        int size = persons.size();
        for (int i = 0; i < size; i++) {
            personIds.add(persons.get(i).get("ID"));
            if (personIds.size() % COUNT == 0 || i == size - 1) {
                //criteria.remove("personId");
                //criteria.add("personId", OP.IN, personIds);
                //List<Map<String, Object>> records = physicalExamRecordDao.getMapList(criteria, new Order(), "personId");
                List<Map<String, Object>> records = physicalExamRecordDao
                    .getRecordInCurrentYear(personIds, "PERSON_ID", "ID");
                mergeInsertPersonId(personIds, records, ids, updateList);
                processInsertPerson(ids);
                processUpdatePerson(updateList);
                ids.clear();
                updateList.clear();
                personIds.clear();
            }
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private void mergeInsertPersonId(List personIds, List<Map<String, Object>> records, List ids,
        List updateList) {
        if (records == null || records.size() == 0) {
            ids.addAll(personIds);
            return;
        }
        if (personIds.size() == records.size()) {
            updateList.addAll(records);
            return;
        }
        for (int index = 0; index < personIds.size(); index++) {
            Object pid = personIds.get(index);
            if (index >= records.size()) {
                records.add(index, new HashMap());
                ids.add(pid);
            } else {
                Object rid = records.get(index).get("PERSON_ID");
                if (!pid.equals(rid)) {
                    records.add(index, new HashMap());
                    ids.add(pid);
                } else {
                    updateList.add(records.get(index));
                }
            }
        }
    }

    private void processUpdatePerson(List<Map<String, Object>> records) {
        if (records == null || records.size() == 0) {
            return;
        }
        Map<String, String> idmap = new HashMap<String, String>();
        for (Map<String, Object> record : records) {
            idmap.put(record.get("PERSON_ID").toString(), record.get("ID").toString());
        }
        Criteria criteria = new Criteria("id", OP.IN, idmap.keySet());
        List<Map<String, Object>> persons = platformService.queryPersonalInfoMap(criteria,
            "id", "idcard", "name", "birthday", "gender", "inputOrganCode", "inputCenterOrganCode",
            "inputGbcode",
            "paymentUrbanWorkders", "paymentUrbanResident", "paymentNewRuralCooperation",
            "paymentPovertyRelief"
            , "paymentCommercial", "paymentBursary", "paymentPersonalExpenses", "paymentOther",
            "marriage", "email", "phoneNumber", "homePhone");
        Date now = new Date();
        for (Map<String, Object> person : persons) {
            mapPersonInfo(now, person, idmap);
        }
        physicalExamRecordDao
            .batchMapUpdate(persons, "examYear", "personId", "idcard", "name", "birthday", "gender",
                "gbcode",
                "inputSuperOrganCode", "inputOrganCode", "paymentPatternCode", "marriage", "moible",
                "telephone", "eMail");
        persons.clear();
        persons = null;
    }

    private void processInsertPerson(List<Object> ids) {
        if (ids == null || ids.size() == 0) {
            return;
        }
        Criteria criteria = new Criteria("id", OP.IN, ids);
        List<Map<String, Object>> persons = platformService.queryPersonalInfoMap(criteria,
            "id", "idcard", "name", "birthday", "gender", "inputOrganCode", "inputCenterOrganCode",
            "inputGbcode",
            "paymentUrbanWorkders", "paymentUrbanResident", "paymentNewRuralCooperation",
            "paymentPovertyRelief"
            , "paymentCommercial", "paymentBursary", "paymentPersonalExpenses", "paymentOther",
            "marriage", "email", "phoneNumber", "homePhone");
        Date now = new Date();
        for (Map<String, Object> person : persons) {
            mapPersonInfo(now, person, null);
        }
        physicalExamRecordDao
            .batchMapInsert(persons, "examYear", "personId", "idcard", "name", "birthday", "gender",
                "gbcode",
                "inputSuperOrganCode", "inputOrganCode", "paymentPatternCode", "marriage", "moible",
                "telephone", "eMail");
        persons.clear();
        persons = null;
    }

    private void mapPersonInfo(Date now, Map<String, Object> person, Map<String, String> idmap) {
        String paymentPatternCode = null;
        String personId = person.remove("ID").toString();
        if (idmap != null) {
            person.put("id", idmap.get(personId));
        }
        person.put("examYear", now);
        person.put("personId", personId);
        //Object superOrganCode = person.remove("INPUT_CENTER_ORGAN_CODE");
        person.remove("INPUT_CENTER_ORGAN_CODE");
        Object orgCode = person.remove("INPUT_ORGAN_CODE");
        person.put("inputOrganCode", orgCode);
//		Object gbCode = person.remove("INPUT_GBCODE");
        Organization org = organizationApp.queryOrgan(String.valueOf(orgCode));
        //modify by yejianfei 20140617 机构信息从机构表获取
        if (ObjectUtil.isNotEmpty(org)) {
            String gbCode = org.getGbCode();
            String generCode = org.getGenreCode();
            //站时更新
            if (OrgGenreCode.STATION.getValue().equals(generCode)) {
                person.put("inputSuperOrganCode", org.getParentCode());
                person.put("gbcode", gbCode);
            } else if (OrgGenreCode.CENTRE.getValue().equals(generCode)) {
                //中心时更新
                person.put("inputSuperOrganCode", org.getOrganCode());
                person.put("gbcode", gbCode);
            }
        }
//		if (ObjectUtil.isNullOrEmpty(gbCode) && ObjectUtil.isNotEmpty(orgCode)) {
//			Organization org =  organizationApp.queryOrgan(String.valueOf(orgCode));
//			gbCode = org == null ? null : org.getGbCode();
//		}
//		person.put("inputSuperOrganCode", superOrganCode);
//		person.put("gbcode", gbCode);
        person.put("moible", person.remove("PHONE_NUMBER"));
        person.put("telephone", person.remove("HOME_PHONE"));
        person.put("eMail", person.remove("EMAIL"));
        person.put("marriage", person.remove("MARRIAGE"));
        //保险支付方式
        //CV020901	01	社会基本医疗保险
        //CV020901	02	商业医疗保险
        //CV020901	03	大病统筹
        //CV020901	04	新型农村合作医疗
        //CV020901	05	城镇居民基本医疗保险
        //CV020901	06	公费医疗
        //CV020901	99	其他
        if (hasPaymentValue(person, "PAYMENT_NEW_RURAL_COOPERATION")) {
            paymentPatternCode = "04";
        } else if (hasPaymentValue(person, "PAYMENT_URBAN_WORKDERS")) {
            paymentPatternCode = "01";
        } else if (hasPaymentValue(person, "PAYMENT_URBAN_RESIDENT")) {
            paymentPatternCode = "05";
        } else if (hasPaymentValue(person, "PAYMENT_POVERTY_RELIEF")) {
            paymentPatternCode = "99";
        } else if (hasPaymentValue(person, "PAYMENT_COMMERCIAL")) {
            paymentPatternCode = "02";
        } else if (hasPaymentValue(person, "PAYMENT_BURSARY")) {
            paymentPatternCode = "06";
        } else if (hasPaymentValue(person, "PAYMENT_PERSONAL_EXPENSES")) {
            paymentPatternCode = "99";
        } else if (hasPaymentValue(person, "PAYMENT_OTHER")) {
            paymentPatternCode = "99";
        }
        person.put("paymentPatternCode", paymentPatternCode);
    }

    private boolean hasPaymentValue(Map<String, Object> person, String key) {
        Object val = person.get(key);
        //return (val != null && "1".equalsIgnoreCase(val.toString().trim()));
        return ObjectUtil.isNotEmpty(val);
    }


    /**
     * 生成体检编号机构后四位+年份四位+流水号五位
     * @param examNoPre
     * @return
     */
    private int findMaxExamNo(String examNoPre) {
        String examNo = physicalExamRecordDao.findMaxExamNo(examNoPre);
        int serNo = (examNo == null) ? 0 : Integer.parseInt(examNo.replace(examNoPre, ""));
        return serNo;
    }

    /**
     * 档案迁移
     */
    @Override
    @Transactional
    public void personRecordMove(Long personId, String smpiId,
        Organization oldOrg, Organization newOrg) {
        Criteria criteria = new Criteria("personId", personId);
        Parameters parameters = new Parameters();
        parameters.add("inputOrganCode", newOrg.getOrganCode());
        parameters.add("inputSuperOrganCode", newOrg.getParentCode());
        parameters.add("gbcode", newOrg.getGbCode());
        physicalExamRecordDao.update(parameters, criteria);
    }

    /**
     * 乡镇合并
     */
    //@Override
    @Transactional
    public void mergeTown(String newTownCode, String[] oldTownCode) {
        Criteria criteria = new Criteria("gbcode", OP.IN, oldTownCode);
        Parameters parameters = new Parameters();
        parameters.add("gbcode", newTownCode);
        physicalExamRecordDao.update(parameters, criteria);
    }

    /**
     * 站合并
     */
    //@Override
    @Transactional
    public void mergeStation(Organization station, List<Organization> stationList) {
        List<String> codes = new ArrayList<String>();
        for (Organization organ : stationList) {
            codes.add(organ.getOrganCode());
        }
        Criteria criteria = new Criteria("inputOrganCode", OP.IN, codes);
        Parameters parameters = new Parameters();
        parameters.add("inputOrganCode", station.getOrganCode());
        parameters.add("inputSuperOrganCode", station.getParentCode());
        parameters.add("gbcode", station.getGbCode());
        physicalExamRecordDao.update(parameters, criteria);
    }

    /**
     * 中心合并
     */
    //@Override
    @Transactional
    public void mergeCenter(Organization center, List<Organization> centerList) {
        List<String> codes = new ArrayList<String>();
        for (Organization organ : centerList) {
            codes.add(organ.getOrganCode());
        }
        Criteria criteria = new Criteria("inputSuperOrganCode", OP.IN, codes);
        Parameters parameters = new Parameters();
        parameters.add("inputSuperOrganCode", center.getParentCode());
        parameters.add("gbcode", center.getGbCode());
        physicalExamRecordDao.update(parameters, criteria);
    }

    /**
     * 站的转移
     */
    //@Override
    @Transactional
    public void moveStation(Organization center, List<Organization> stationList) {
        List<String> codes = new ArrayList<String>();
        for (Organization organ : stationList) {
            codes.add(organ.getOrganCode());
        }
        Criteria criteria = new Criteria("inputOrganCode", OP.IN, codes);
        Parameters parameters = new Parameters();
        parameters.add("inputSuperOrganCode", center.getParentCode());
        parameters.add("gbcode", center.getGbCode());
        physicalExamRecordDao.update(parameters, criteria);
    }

    /**
     * 获取镇下面所有服务服务中心
     * @param gbCode 镇的编码
     * @return
     */
    private List<Organization> getCentre(String gbCode) {
        Criteria criteria = new Criteria();
        if (gbCode.equals("_hospital")) {
            criteria.add("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue());
        } else if (gbCode.equals("_other")) {
            criteria.add("GENRE_CODE", OrgGenreCode.OTHER.getValue());
        } else if (gbCode.equals(EHRConstants._INFIRMARY)) {
            criteria.add("GENRE_CODE", OrgGenreCode.INFIRMARY.getValue());
        } else if (gbCode.equals(EHRConstants._HEALTHOVERSIGHT)) {
            criteria.add("GENRE_CODE", OrgGenreCode.HEALTH_OVERSIGHT.getValue());
        } else {
            criteria = new Criteria("GB_CODE", gbCode);
            criteria.add("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
        }

        List<Organization> centres = organizationApp.queryOrganization(criteria);
        return centres;
    }

    @Override
    public void sendTownVillageRelation(String townCode,
        String[] newAddVillageCodes) {
        // TODO Auto-generated method stub
    }

    //@Override
    public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<ElderlyHealthStatistics> getElderlyHealthStatisticsList(Criteria criteria) {
        return elderlyHealthStatisticsDao.getList(criteria);
    }

    @Override
    public void cancelPerson(Long personId, String smpiId) {
        if (ObjectUtil.isNotEmpty(personId)) {
            Parameters parameters = new Parameters();
            parameters.add("LOGOFF", 1);
            physicalExamRecordDao.update(parameters, new Criteria("personId", personId));

        }
    }

    @Override
    public List<Map<String, Object>> getPhysicalExamProgressMapList(
        Map<String, String> paramMap) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        if (ObjectUtil.isNullOrEmpty(paramMap)) {
            return mapList;
        }
        mapList = physicalExamRecordDao.getPhysicalExamProgressMapList(paramMap);
        List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
        return destMapList;
    }

    @Override
    public List<Map<String, Object>> getElderlyPhysicalExamStatisticsMapList(
        Map<String, String> paramMap, List<String> organList) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        if (ObjectUtil.isNullOrEmpty(paramMap)) {
            return mapList;
        }
        return elderlyHealthStatisticsDao.getElderlyStatisticsMapList(paramMap, organList);
    }

    /**
     * type 1统计分析   2进度统计
     */
    public List<Map<String, Object>> getElderlyPhysicalExamStatisticsMapList(Criteria criteria, Integer type) {
		List<Map<String, Object>> reports = new ArrayList<>();
		
		// 统计卫生服务站体检进度
		// 统计卫生服务站体检进度
		List<String> organCodeList = new ArrayList<>();
		List<Map<String, Object>> list = new ArrayList<>();
		if (criteria.contains(ORGCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");	
				}
			organCodeList.add((String) criteria.get(ORGCODE));
			list = elderlyHealthStatisticsDao.getElderlyStatisticsMapList(criteria, organCodeList, type);
			Map<String, Object> census = null;
			
			if(ObjectUtil.isNotEmpty(list)){
				census = list.get(0);
			}
			census.put("org_code", criteria.get(ORGCODE).toString());
			reports.add(census);
		} else if (criteria.contains(CENTERCODE) && !criteria.contains(ORGCODE)&& !criteria.contains(GBCODE)) { // 统计卫生服务中心体检进度
			//获取卫生服务中心
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
			}
			String organCode = criteria.get(CENTERCODE).toString();
			organCodeList.add(organCode);
			// 获取卫生服务中心下属服务站
            List<Organization> stations = getStation(organCode);
            for (Organization organization : stations) {
                organCodeList.add(organization.getOrganCode());
            }
            list = elderlyHealthStatisticsDao.getElderlyStatisticsMapList(criteria, organCodeList, type);
			reports.addAll(list);
		} else if (criteria.contains(GBCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
			}
			List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
			if(criteria.contains(CENTERCODE)){
				String organCode = criteria.get(CENTERCODE).toString();
				organCodeList.add(organCode);
				List<Organization> stations = getStation(organCode);
				for (Organization organization : stations) {
                    organCodeList.add(organization.getOrganCode());
                }
				list = elderlyHealthStatisticsDao.getElderlyStatisticsMapList(criteria, organCodeList, type);
				reports.addAll(list);
			}else{
				for (Organization organization : centres) {
                	organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
						organCodeList.add(organization1.getOrganCode());
					}
                }
				 
				List<Map<String, Object>> censusList = elderlyHealthStatisticsDao.getElderlyStatisticsMapList(criteria, organCodeList, type);
				reports = countCensus(censusList, centres, type);
			}
		} else {
			if(criteria.contains("qwgzxCode")) {
				criteria.add(GBCODE, criteria.get("qwgzxCode"));
				criteria.remove("qwgzxCode");
				List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
				
				for (Organization organization : centres) {
                	organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
						organCodeList.add(organization1.getOrganCode());
					}
                }
				List<Map<String, Object>> censusList = elderlyHealthStatisticsDao.getElderlyStatisticsMapList(criteria, organCodeList, type);
				reports = countCensus(censusList, centres, type);
				criteria.remove(GBCODE);
			}else{
				Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
				List<DicItem> dicItems = dictionaryApp.queryDicItem(ca);
				for (DicItem dicItem : dicItems) {
					criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
					
					for (Organization organization : centres) {
	                	organCodeList.add(organization.getOrganCode());
	                    List<Organization> stations = getStation(organization.getOrganCode());
	                    for (Organization organization1 : stations) {
							organCodeList.add(organization1.getOrganCode());
						}
					}
				}
				
				List<Map<String, Object>> censusList = elderlyHealthStatisticsDao.getElderlyStatisticsMapList(criteria, organCodeList, type);
				Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
				
				for (Map<String, Object> census : censusList) {
					map.put((String)census.get("org_code"), census);
				}
	            
	            for (DicItem dicItem : dicItems) {
	            	criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
					
					for (Organization organization : centres) {
						Map<String, Object> census = map.get(organization.getOrganCode());
						if(census == null){
							census = new HashMap<String, Object>();
							census.put("org_code", organization.getOrganCode());
						}
	                    List<Organization> stations = getStation(organization.getOrganCode());
	                    for (Organization organization1 : stations) {
	                    	if(map.get(organization1.getOrganCode()) != null)
	                    		countCensus(census, map.get(organization1.getOrganCode()), type);
						}
	                    reports.add(census);
					}
				}
			}
		}
		return reports;
	
   }
    private List<Map<String, Object>> countCensus(List<Map<String, Object>> censusList, List<Organization> centres, Integer type){
	    Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
	    List<Map<String, Object>> reports = new ArrayList<Map<String, Object>>();
		for (Map<String, Object> census : censusList) {
			map.put((String)census.get("org_code"), census);
		}
	
		for (Organization organization : centres) {
			Map<String, Object> census = map.get(organization.getOrganCode());
			if(census == null){
				census = new HashMap<String, Object>();
				census.put("org_code", organization.getOrganCode());
			}
			List<Organization> stations = getStation(organization.getOrganCode());
			for (Organization organization1 : stations) {
				if(map.get(organization1.getOrganCode()) != null)
					countCensus(census,map.get(organization1.getOrganCode()), type);
			}
			reports.add(census);
		}
		return reports;
    }
    
    @Override
    @Transactional
    public void savePhyExamination(PersonInfo personInfo,
            ElderlyPhyExamination elderlyPhyExamination, Organization organization, String anomalyDesc) {
    	//Long end = System.currentTimeMillis();
        Assert.notNull(personInfo, "体检人员信息不能为空");
        Assert.notNull(elderlyPhyExamination, "体检不能为空");

        // 如果没有体检日志,则设置为当前日期
        if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getExaminationDate())) {
            elderlyPhyExamination.setExaminationDate(new Date());
        }
        // 计算年龄
        elderlyPhyExamination.setAge(DateUtil.getAge(personInfo.getBirthday(), elderlyPhyExamination.getExaminationDate()));

        // 体检事件
        EHRHealthEvent event = createEhrHealthEvent(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode(), "老年人体检", personInfo,elderlyPhyExamination);

        // 体检信息
        HealthExamination examination = new HealthExamination();
        copyHealthExamination(elderlyPhyExamination, personInfo, examination);
        String ehrId = event.getEhrId();
        examination.setEhrId(ehrId);
        examination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
//        examination.setPhysicalExamCode(record.getExamNumber());
        examination.setExamStatus(1);
        healthExaminationDao.insert(examination);
        // 体检数据
        elderlyPhyExamination.setEhrId(ehrId);
        elderlyPhyExamination.setName(personInfo.getName());
        elderlyPhyExamination.setGender(personInfo.getGender());
        elderlyPhyExamination.setBirthday(personInfo.getBirthday());
        elderlyPhyExamination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
        Number elderlyPhyExamiId = elderlyPhyExaminationDao.generatedKey(elderlyPhyExamination, "ID", null);
        
        elderlyPhyExamination.setId(Long.valueOf(String.valueOf(elderlyPhyExamiId)));
        this.updateHealthGuide(elderlyPhyExamination);
        this.updateFamilyBedHistory(elderlyPhyExamination);
        this.updateHospitalization(elderlyPhyExamination);
        this.updateDrugHistory(elderlyPhyExamination);
        this.updateVaccinationInfo(elderlyPhyExamination);

        //更新、新增体检状态表
        updateElderlyPhyStatus(elderlyPhyExamination);
    }

    /**
     * 更新、新增体检状态（是否评估、是否规范、是否辨识等等...）
     * @param elderlyPhyExamination
     * @param identification 
     * @param identification 
     */
    private void updateElderlyPhyStatus(ElderlyPhyExamination elderlyPhyExamination) {
    	Criteria cri = new Criteria("personId",elderlyPhyExamination.getPersonId());
    	cri.add("physicalExamCode", elderlyPhyExamination.getPhysicalExamCode());
    	ElderlyPhyStatus status = elderlyPhyStatusDao.get(cri, "ID");
    	
    	if(ObjectUtil.isNullOrEmpty(status)){
    		status  = new ElderlyPhyStatus();
    	}
    	status.setEhrId(elderlyPhyExamination.getEhrId());
        status.setPersonId(elderlyPhyExamination.getPersonId());
        status.setName(elderlyPhyExamination.getName());
        status.setPhysicalExamCode(elderlyPhyExamination.getPhysicalExamCode());
        status.setExamYear(elderlyPhyExamination.getExamYear());
        status.setExaminationDate(elderlyPhyExamination.getExaminationDate());
        status.setExaminationOrganCode(elderlyPhyExamination.getExaminationOrganCode());
        status.setManaDoctorId(elderlyPhyExamination.getManaDoctorId());
        status.setTcmStatus((ObjectUtil.isNotEmpty(elderlyPhyExamination.getIdentificationId()) && 0!=elderlyPhyExamination.getIdentificationId()) ? 1 : 0);
		status.setHealthGuideStatus(updateHealthGuideStatus(elderlyPhyExamination.getIdentificationId()));
        status.setEstimateStatus(updateSelfAssessment(elderlyPhyExamination));
        status.setCriterionExamination(updateCriterionExamination(elderlyPhyExamination));
        
		if(ObjectUtil.isNotEmpty(status.getId())){
			elderlyPhyStatusDao.update(status);
		}else{
			elderlyPhyStatusDao.insert(status);
		}
	}
    
	/**
	 * 判断是否中医指导
	 * @param elderlyPhyExamination
	 * @param long1 
	 * @return
	 */
    private Integer updateHealthGuideStatus(Long id) {
    	EchIdentification iden = echIdentificationDao.get(id);
    	Integer res = 0;
    	if(ObjectUtil.isNotEmpty(iden)){
    		if(StringUtil.isNotEmpty(iden.getQiQualityGuidance())  || StringUtil.isNotEmpty(iden.getYangQualityGuidance())
    				|| StringUtil.isNotEmpty(iden.getYinDeficiencyGuidance()) || StringUtil.isNotEmpty(iden.getPhlegmWetnessGuidance())
    				|| StringUtil.isNotEmpty(iden.getHeatMediumGuidance()) || StringUtil.isNotEmpty(iden.getBloodQualityGuidance())
    				|| StringUtil.isNotEmpty(iden.getQiStagnationGuidance()) || StringUtil.isNotEmpty(iden.getSpecialQualityGuidance())
    				|| StringUtil.isNotEmpty(iden.getPeacefulQualityGuidance())){
    			res = 1;
    		}
    	}
		return res;
	}

	/**
     * 判断是否规范体检
     * @param elderlyPhyExamination
     * @return
     */
	private Integer updateCriterionExamination(ElderlyPhyExamination phy) {
		Integer res = 0;
			if(	//血常规
				ObjectUtil.isNotEmpty(phy.getHemoglobinValue()) && ObjectUtil.isNotEmpty(phy.getLeukocyteCount()) && ObjectUtil.isNotEmpty(phy.getPlateletCount())
				//尿常规
				&& ObjectUtil.isNotEmpty(phy.getUrineProQuantitativeValue()) && ObjectUtil.isNotEmpty(phy.getUrineSugQuantitativeValue()) && ObjectUtil.isNotEmpty(phy.getKetQuantitativeValue()) && ObjectUtil.isNotEmpty(phy.getEryQuantitativeValue())
				//肝功能
				&& ObjectUtil.isNotEmpty(phy.getSerumGptValue()) && ObjectUtil.isNotEmpty(phy.getSerumAstValue()) && ObjectUtil.isNotEmpty(phy.getTotalBilirubin())
				//肾功能
				&& ObjectUtil.isNotEmpty(phy.getCreatinine()) && ObjectUtil.isNotEmpty(phy.getBloodUreaNitrogenValue())
				//空腹血糖
				&& (ObjectUtil.isNotEmpty(phy.getFpgMg()) || ObjectUtil.isNotEmpty(phy.getFpgMmol()))
				//血脂
				&& ObjectUtil.isNotEmpty(phy.getTc()) && ObjectUtil.isNotEmpty(phy.getTriglycerideValue()) && ObjectUtil.isNotEmpty(phy.getLdlcDetectValue()) && ObjectUtil.isNotEmpty(phy.getHdlcDetectValue())
				//心电图检测
				&& ObjectUtil.isNotEmpty(phy.getEcgAnomalyFlag()) && Integer.valueOf(phy.getEcgAnomalyFlag())!=2
				//腹部B超
				&& ObjectUtil.isNotEmpty(phy.getBmodeAnomalyfFlag()) && Integer.valueOf(phy.getBmodeAnomalyfFlag())!=2 ){
				res = 1;
			}
		return res;
	}
	
    @Override
    @Transactional
    public void updatePhyExamination(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination) {
        // 如果没有体检日志,则设置为当前日期
        if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getExaminationDate())) {
            elderlyPhyExamination.setExaminationDate(new Date());
        }

        // 计算年龄
        elderlyPhyExamination.setAge( DateUtil.getAge(personInfo.getBirthday(), elderlyPhyExamination.getExaminationDate()));

        // 更新体检信息
        Criteria criteria = new Criteria("personId", elderlyPhyExamination.getPersonId());
        String ehrId = elderlyPhyExamination.getEhrId();
        criteria.add("ehrId", ehrId);
        HealthExamination examination = healthExaminationDao.get(criteria);
        if (ObjectUtil.isNullOrEmpty(examination)) {
            HealthExamination examinationNew = new HealthExamination();
            copyHealthExamination(elderlyPhyExamination, personInfo, examinationNew);
            examinationNew.setEhrId(ehrId);
            examinationNew.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
            examinationNew.setPhysicalExamCode(elderlyPhyExamination.getPhysicalExamCode());//新增体检编号 at 2018-05-28 bagen
            examinationNew.setExamStatus(1);
            healthExaminationDao.insert(examinationNew);
        } else {
            copyHealthExamination(elderlyPhyExamination, personInfo, examination);
            //报告已生成状态
            examination.setExamStatus(1);
            healthExaminationDao.update(examination);
        }
        // 体检数据
        elderlyPhyExamination.setName(personInfo.getName());
        elderlyPhyExamination.setGender(personInfo.getGender());
        elderlyPhyExamination.setBirthday(personInfo.getBirthday());
        elderlyPhyExamination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
        elderlyPhyExaminationDao.update(elderlyPhyExamination);
        // 更新事件体检机构和体检日期
        updateEhrHealthEvent(personInfo, elderlyPhyExamination);
		this.updateHealthGuide(elderlyPhyExamination);
		
		/* 删除旧的体检信息 */
		familyBedHistoryDao.delete(criteria);//家庭病床史
		hospitalizedHistoryDao.delete(criteria);//住院史
		drugHistoryDao.delete(criteria);//主要用药情况
		vaccinationInfoDao.delete(criteria);//非免疫规划预防接种史
		
        //更新健康评价
        this.updateHealthEvaluate(elderlyPhyExamination);
        this.updateFamilyBedHistory(elderlyPhyExamination);
        this.updateHospitalization(elderlyPhyExamination);
        this.updateDrugHistory(elderlyPhyExamination);
        this.updateVaccinationInfo(elderlyPhyExamination);
        updateSelfAssessment(elderlyPhyExamination);
        
        //更新体检状态表
        updateElderlyPhyStatus(elderlyPhyExamination);
    }

    private void updateEhrHealthEvent(PersonInfo personInfo,
        ElderlyPhyExamination elderlyPhyExamination) {
        // 更新体检信息
        Criteria criteria = new Criteria("personId", elderlyPhyExamination.getPersonId());
        String ehrId = elderlyPhyExamination.getEhrId();
        criteria.add("ehrId", ehrId);
        EHRHealthEvent ehrHealthEvent = ehrHealthEventDao.get(criteria);
        if (null != ehrHealthEvent) {
            ehrHealthEvent.setAge(elderlyPhyExamination.getAge());
            ehrHealthEvent.setName(personInfo.getName());
            ehrHealthEvent.setEhrType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
            ehrHealthEvent.setEhrName(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getName());
            ehrHealthEvent.setClinicOrganCode(elderlyPhyExamination.getExaminationOrganCode());
            ehrHealthEvent.setClinicDate(elderlyPhyExamination.getExaminationDate());
            ehrHealthEvent.setUpdateDate(new Date());
            ehrHealthEventDao.update(ehrHealthEvent);
        }
    }

    public int updateHospitalization(ElderlyPhyExamination examination) {
        if (examination == null) {
            return 0;
        }
        // pack evaluation data
        boolean check1 = false;
        Record examRecord = new Record(examination);
        List<String> properties = new ArrayList<>();
        for (String key : guideProp) {
            if (ObjectUtil.isNotEmpty(examRecord.get(key))) {
                properties.add(key);
            }
        }
        if (ObjectUtil.isNotEmpty(properties)) {
            check1 = true;
            properties.add("id");
        }

        // pack anomaly description
        boolean check2 = false;
        List<HospitalizedHistory> hospitalizedHistoryList = examination
            .getHospitalizedHistoryList();
        if (ObjectUtil.isNotEmpty(hospitalizedHistoryList)) {
            check2 = true;
        }
        List<HospitalizedHistory> hospitalizedHistoryList2 = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(hospitalizedHistoryList)) {
            for (HospitalizedHistory hospitalizedHistory : hospitalizedHistoryList) {
                if (ObjectUtil.isNotEmpty(hospitalizedHistory)) {
                    if (ObjectUtil.isNotEmpty(hospitalizedHistory.getInhosReason())) {
                        hospitalizedHistory.setEhrId(examination.getEhrId());
                        hospitalizedHistory.setPersonId(examination.getPersonId());
                        hospitalizedHistoryList2.add(hospitalizedHistory);
                    }

                }
            }
            // udpate health guide status
            boolean check3 = true;

            // do the update
            if (check1 && check3) {
                int rt1 = elderlyPhyExaminationDao
                    .update(examination, properties.toArray(new String[]{""}));
                int rt2 = 0;
                if (check2) {
                    hospitalizedHistoryDao
                        .delete(new Criteria("EHR_ID", hospitalizedHistoryList.get(0).getEhrId()));
                    rt2 = hospitalizedHistoryDao.batchInsert(hospitalizedHistoryList2);
                }
                if (rt1 != 0 && (!check2 || rt2 != 0)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    //更新健康评价
    public int updateHealthEvaluate(ElderlyPhyExamination examination) {
        if (examination == null) {
            return 0;
        }
        // pack evaluation data
        boolean check1 = false;
        Record examRecord = new Record(examination);
        List<String> properties = new ArrayList<>();
        for (String key : guideProp) {
            if (ObjectUtil.isNotEmpty(examRecord.get(key))) {
                properties.add(key);
            }
        }
        if (ObjectUtil.isNotEmpty(properties)) {
            check1 = true;
            properties.add("id");
        }

        // pack anomaly description
        boolean check2 = false;
        List<HealthEvaluateAnomaly> anomalyList = examination.getHealthEvaluateAnomalies();
        if (ObjectUtil.isNotEmpty(anomalyList)) {
            check2 = true;
        }
        if (ObjectUtil.isNotEmpty(anomalyList)) {
            for (HealthEvaluateAnomaly healthEvaluateAnomaly : anomalyList) {
                healthEvaluateAnomaly.setEhrId(examination.getEhrId());
            }
            // do the update
            if (check1) {
                int rt1 = elderlyPhyExaminationDao
                    .update(examination, properties.toArray(new String[]{""}));
                int rt2 = 0;
                if (check2) {
                    healthEvaluateAnomalyDao
                        .delete(new Criteria("EHR_ID", anomalyList.get(0).getEhrId()));
                    rt2 = healthEvaluateAnomalyDao.batchInsert(anomalyList);
                }
                if (rt1 != 0 && (!check2 || rt2 != 0)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public int updateFamilyBedHistory(ElderlyPhyExamination examination) {
        if (examination == null) {
            return 0;
        }
        // pack evaluation data
        boolean check1 = false;
        Record examRecord = new Record(examination);
        List<String> properties = new ArrayList<>();
        for (String key : guideProp) {
            if (ObjectUtil.isNotEmpty(examRecord.get(key))) {
                properties.add(key);
            }
        }
        if (ObjectUtil.isNotEmpty(properties)) {
            check1 = true;
            properties.add("id");
        }

        // pack anomaly description
        boolean check2 = false;
        List<FamilyBedHistory> FamilyBedHistoryList = examination.getFamilyBedHistoryList();
        if (ObjectUtil.isNotEmpty(FamilyBedHistoryList)) {
            check2 = true;
        }
        List<FamilyBedHistory> FamilyBedHistoryList2 = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(FamilyBedHistoryList)) {
            for (FamilyBedHistory familyBedHistory : FamilyBedHistoryList) {
                if (ObjectUtil.isNotEmpty(familyBedHistory)) {
                    if (ObjectUtil.isNotEmpty(familyBedHistory.getBuiltBedReason())) {
                        familyBedHistory.setEhrId(examination.getEhrId());
                        familyBedHistory.setPersonId(examination.getPersonId());
                        FamilyBedHistoryList2.add(familyBedHistory);
                    }
                }
            }
            // udpate health guide status
            boolean check3 = true;

            // do the update
            if (check1 && check3) {
                int rt1 = elderlyPhyExaminationDao
                    .update(examination, properties.toArray(new String[]{""}));
                int rt2 = 0;
                if (check2) {
                    familyBedHistoryDao
                        .delete(new Criteria("EHR_ID", FamilyBedHistoryList.get(0).getEhrId()));
                    rt2 = familyBedHistoryDao.batchInsert(FamilyBedHistoryList2);
                }
                if (rt1 != 0 && (!check2 || rt2 != 0)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public int updateDrugHistory(ElderlyPhyExamination examination) {
        if (examination == null) {
            return 0;
        }
        // pack evaluation data
        boolean check1 = false;
        Record examRecord = new Record(examination);
        List<String> properties = new ArrayList<>();
        for (String key : guideProp) {
            if (ObjectUtil.isNotEmpty(examRecord.get(key))) {
                properties.add(key);
            }
        }
        if (ObjectUtil.isNotEmpty(properties)) {
            check1 = true;
            properties.add("id");
        }

        // pack anomaly description
        boolean check2 = false;
        List<DrugHistory> DrugHistoryList = examination.getDrugHistorylist();
        if (ObjectUtil.isNotEmpty(DrugHistoryList)) {
            check2 = true;
        }
        List<DrugHistory> DrugHistoryList2 = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(DrugHistoryList)) {
            for (DrugHistory drugHistory : DrugHistoryList) {
                if (ObjectUtil.isNotEmpty(drugHistory)) {
                    if (ObjectUtil.isNotEmpty(drugHistory.getDrugGenericName())) {
                        drugHistory.setEhrId(examination.getEhrId());
                        drugHistory.setPersonId(examination.getPersonId());
                        DrugHistoryList2.add(drugHistory);
                    }
                }
            }
            // udpate health guide status
            boolean check3 = true;

            // do the update
            if (check1 && check3) {
                int rt1 = elderlyPhyExaminationDao
                    .update(examination, properties.toArray(new String[]{""}));
                int rt2 = 0;
                if (check2) {
                    drugHistoryDao
                        .delete(new Criteria("EHR_ID", DrugHistoryList.get(0).getEhrId()));
                    rt2 = drugHistoryDao.batchInsert(DrugHistoryList2);
                }
                if (rt1 != 0 && (!check2 || rt2 != 0)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public int updateVaccinationInfo(ElderlyPhyExamination examination) {
        if (examination == null) {
            return 0;
        }
        // pack evaluation data
        boolean check1 = false;
        Record examRecord = new Record(examination);
        List<String> properties = new ArrayList<>();
        for (String key : guideProp) {
            if (ObjectUtil.isNotEmpty(examRecord.get(key))) {
                properties.add(key);
            }
        }
        if (ObjectUtil.isNotEmpty(properties)) {
            check1 = true;
            properties.add("id");
        }

        // pack anomaly description
        boolean check2 = false;
        List<VaccinationInfo> VaccinationInfoList = examination.getVaccinationInfoList();
        if (ObjectUtil.isNotEmpty(VaccinationInfoList)) {
            check2 = true;
        }
        List<VaccinationInfo> VaccinationInfoList2 = new ArrayList<>();
        if (ObjectUtil.isNotEmpty(VaccinationInfoList)) {
            for (VaccinationInfo vaccinationInfo : VaccinationInfoList) {
                if (ObjectUtil.isNotEmpty(vaccinationInfo)) {
                    if (ObjectUtil.isNotEmpty(vaccinationInfo.getVaccineName())) {
                        vaccinationInfo.setEhrId(examination.getEhrId());
                        vaccinationInfo.setPersonId(examination.getPersonId());
                        VaccinationInfoList2.add(vaccinationInfo);
                    }
                }
            }
            boolean check3 = true;

            // do the update
            if (check1 && check3) {
                int rt1 = elderlyPhyExaminationDao
                    .update(examination, properties.toArray(new String[]{""}));
                int rt2 = 0;
                if (check2) {
                    vaccinationInfoDao
                        .delete(new Criteria("EHR_ID", VaccinationInfoList.get(0).getEhrId()));
                    rt2 = vaccinationInfoDao.batchInsert(VaccinationInfoList2);
                }
                if (rt1 != 0 && (!check2 || rt2 != 0)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * 健康评价
     * @param examination
     * @return
     */
    public int updateHealthGuide(ElderlyPhyExamination examination) {
        if (examination == null) {
            return 0;
        }
        //在健康档案第三页个人体检表保存时即使"健康评价"选择"体检无异常"无异常时PersonalPhyExamDTO.HealthEvaluateAnomalyList也不为空
        // 而当选择"健康评价"选择"体检无异常"无异常时不应该保存HealthEvaluateAnomaly
        if(ObjectUtil.equals(examination.getHealthEvaluateAnomalyFlag(), "0")) {
            return 0;
        }
        // pack evaluation data
        boolean check1 = false;
        Record examRecord = new Record(examination);
        List<String> properties = new ArrayList<>();
        for (String key : guideProp) {
            if (ObjectUtil.isNotEmpty(examRecord.get(key))) {
                properties.add(key);
            }
        }
        if (ObjectUtil.isNotEmpty(properties)) {
            check1 = true;
            properties.add("id");
        }

        // pack anomaly description
        boolean check2 = false;
        List<HealthEvaluateAnomaly> anomalyList = examination.getHealthEvaluateAnomalies();
        if (ObjectUtil.isNotEmpty(anomalyList)) {
            check2 = true;
        }
        if (ObjectUtil.isNotEmpty(anomalyList)) {
            for (HealthEvaluateAnomaly healthEvaluateAnomaly : anomalyList) {
                healthEvaluateAnomaly.setEhrId(examination.getEhrId());
            }
            // do the update
            if (check1) {
                int rt1 = elderlyPhyExaminationDao
                    .update(examination, properties.toArray(new String[]{""}));
                int rt2 = 0;
                if (check2) {
                    healthEvaluateAnomalyDao
                        .delete(new Criteria("EHR_ID", anomalyList.get(0).getEhrId()));
                    rt2 = healthEvaluateAnomalyDao.batchInsert(anomalyList);
                }
                if (rt1 != 0 && (!check2 || rt2 != 0)) {
                    return 1;
                }
            }
        }
        return 0;
    }

    /**
     * 设置体检信息表要保存的信息
     *
     * @param elderlyPhyExamination
     *            the elderly phy examination
     * @param personInfo
     *            the person info
     * @param examination
     *            the examination
     */
    private void copyHealthExamination(ElderlyPhyExamination elderlyPhyExamination,
        PersonInfo personInfo, HealthExamination examination) {
        examination.setAge(elderlyPhyExamination.getAge());
        examination.setBirthday(personInfo.getBirthday());
        examination.setExaminationDate(elderlyPhyExamination.getExaminationDate());
        examination.setGender(personInfo.getGender());
        examination.setName(personInfo.getName());
        examination.setPersonId(personInfo.getId());
        examination.setHospitalCode(elderlyPhyExamination.getExaminationOrganCode());
        examination.setManaDoctorId(elderlyPhyExamination.getManaDoctorId());
        examination.setPhysicalExamCode(elderlyPhyExamination.getPhysicalExamCode());
    }

    /**
     * 创建或更新卫生事件
     *
     * @param ehrType
     *            the ehr type
     * @param ehrName
     *            the ehr name
     * @param personInfo
     *            the person info
     * @param elderlyPhyExamination
     *            the elderly phy examination
     * @return eHR health event
     */
    private EHRHealthEvent createEhrHealthEvent(String ehrType, String ehrName,
        PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination) {
        EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
        ehrHealthEvent.setUpdateDate(new Date());
        Long personId = personInfo.getId();
        if (ehrType != null && ehrType.trim().length() > 0 && personId != null) {
            ehrHealthEvent.setEhrType(ehrType);
            ehrHealthEvent.setEhrName(ehrName);
            ehrHealthEvent.setName(personInfo.getName());
            ehrHealthEvent.setAge(elderlyPhyExamination.getAge());
            ehrHealthEvent.setPersonId(personId);
            ehrHealthEvent.setCreateDate(new Date());
            ehrHealthEvent.setClinicOrganCode(elderlyPhyExamination.getExaminationOrganCode());
            ehrHealthEvent.setClinicDate(elderlyPhyExamination.getExaminationDate());
            Number healthEventId = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID", null);
            Assert.notNull(healthEventId, "事件生成失败");
            ehrHealthEvent.setId(healthEventId.longValue());
            ehrHealthEvent.setEhrId(String.valueOf(healthEventId));
            ehrHealthEventDao.update(ehrHealthEvent, "ehrId");
        }
        return ehrHealthEvent;
    }

    /**
     * 更新自我评估--必填项
     * @param examination
     * @param examRecordId
     * @return int
     */
    private int updateSelfAssessment(ElderlyPhyExamination examination) {
        if (examination == null) {
            return 0;
        }
        return 1;
    }

    /**
     *  个人体检、慢病系统体检更新老年人体检（专用保存方法）
     * @param personId
     * @param elderlyPhyExamination
     * @param organization
     */
    @Override
    @Transactional
    public void savePhyExamination(Long personId, ElderlyPhyExamination elderlyPhyExamination, PersonalPhyExamDTO dto, 
        Organization organization, User user,String eventType,
        String... properties) {
        Assert.notNull(dto.getPersonInfo(), "体检人员不能为空");
        Assert.notNull(elderlyPhyExamination, "体检不能为空");
        final User currentUser = user;
        final PersonalPhyExamDTO personalPhyExamDTO = dto;
        //0146039: 【平台共通】未满65周岁的老年人，在先建健康档案个人体检表，再填基本信息的情况下，后续新增、保存的体检不会同步到老年人健康体检模块
        if(StringUtil.isEmpty(dto.getPersonInfo().getIdcard())) {
			 return;
		}
        
        Date birth = IDCardUtil.getBirthDateByIdCard(dto.getPersonInfo().getIdcard());
		int age = DateUtil.getAgeByBirthday(birth);
		//不是老年人返回空ID
		if(age<EHRConstants.SIXTY_FIVE_ELDER) {
			 return;
		}
        
        elderlyPhyExamination.setHealthEvaluateAnomalies(dto.getHealthEvaluateAnomalyList());
        elderlyPhyExamination.setHospitalizedHistoryList(dto.getHospitalizedHistoryList());
        elderlyPhyExamination.setFamilyBedHistoryList(dto.getFamilyBedHistoryList());
        elderlyPhyExamination.setDrugHistorylist(dto.getDrugHistoryList());
        elderlyPhyExamination.setVaccinationInfoList(dto.getVaccinationInfoList());
        elderlyPhyExamination.setExamYear(DateUtil.toFormatString("yyyy", elderlyPhyExamination.getExaminationDate()));
        
        //1查询是否有老年人名单,没有则新增，exam_year 为满65岁的时间
        Criteria cri = new Criteria("personId", dto.getPersonInfo().getId());
        Date examinationDate = elderlyPhyExamination.getExaminationDate();
        PhysicalExamRecord record = physicalExamRecordDao.get(cri);
        if(ObjectUtil.isNullOrEmpty(record)){
        	addExamination(personId, examinationDate);
        }
        
        //2按体检编号查询是否有体检
        cri.add("physicalExamCode",elderlyPhyExamination.getPhysicalExamCode());
        cri.add("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
        List<ElderlyPhyExamination> elders = elderlyPhyExaminationDao.getList(cri);
        
        if (ObjectUtil.isNotEmpty(elders)) {
        	ElderlyPhyExamination elder = elders.get(0);
            //更新
            //如果eventType为39，表示从慢病体检同步的数据，需要设置若干字段不能被覆盖
            if (eventType.equals(EventType.CHRONIC_DISEASE_PHYSICAL_EXAMINATION.getCode())) {
                updateExamField(elderlyPhyExamination, elder);
            }
            elderlyPhyExamination.setId(elder.getId());
            elderlyPhyExamination.setEhrId(elder.getEhrId());
            //家族史
            if (StringUtil.isNullOrEmpty(elderlyPhyExamination.getFamilyHistoryHbpFlg())) {
                elderlyPhyExamination.setFamilyHistoryHbpFlg(elder.getFamilyHistoryHbpFlg());
            }
            if (StringUtil.isNullOrEmpty(elderlyPhyExamination.getFamilyHistoryDiFlg())) {
                elderlyPhyExamination.setFamilyHistoryDiFlg(elder.getFamilyHistoryDiFlg());
            }
            if (StringUtil.isNullOrEmpty(elderlyPhyExamination.getFamilyHistoryStrokeFlg())) {
                elderlyPhyExamination.setFamilyHistoryStrokeFlg(elder.getFamilyHistoryStrokeFlg());
            }
            if (StringUtil.isNullOrEmpty(elderlyPhyExamination.getFamilyHistoryCoronaryFlg())) {
                elderlyPhyExamination
                    .setFamilyHistoryCoronaryFlg(elder.getFamilyHistoryCoronaryFlg());
            }
            updateExamination(dto.getPersonInfo(), elderlyPhyExamination);
        } else {
            //新增
            addPhyExamination(dto.getPersonInfo(), elderlyPhyExamination, organization);
        }
        //更新、新增体检状态表
        updateElderlyPhyStatus(elderlyPhyExamination);
    }

    @Override
    public List<Map<String, Object>> exportPersonRecordList(List<String> orgCodes, Page page, Criteria criteria,
        String examinationDateStart, String examinationDateEnd) {
        PageList<Map<String, Object>> mapList = physicalExamRecordDao
            .getPersonInfoListMap(orgCodes, page, criteria, examinationDateStart, examinationDateEnd);
        if (null == mapList) {
            return Collections.emptyList();
        }
        return mapList.getList();
    }

    /**
     * 保留老年体检表中的一些字段（慢病体检中没有的字段）
     * @param newObj
     * @param oldObj
     */
    private void updateExamField(ElderlyPhyExamination newObj, ElderlyPhyExamination oldObj) {
        newObj.setHealthSelfAssessment(oldObj.getHealthSelfAssessment());
        newObj.setLifeAbilitySelfAssessment(oldObj.getLifeAbilitySelfAssessment());
        newObj.setEatingAssessment(oldObj.getEatingAssessment());
        newObj.setCleaningAssessment(oldObj.getCleaningAssessment());
        newObj.setClothingAssessment(oldObj.getClothingAssessment());
        newObj.setDefecationAssessment(oldObj.getDefecationAssessment());
        newObj.setExerciseAssessment(oldObj.getExerciseAssessment());
        newObj.setCognitionScreenResult(oldObj.getCognitionScreenResult());
        newObj.setCognitionScreenScore(oldObj.getCognitionScreenScore());
        newObj.setEmotionScreenResult(oldObj.getEmotionScreenResult());
        newObj.setDepressionScore(oldObj.getDepressionScore());
        newObj.setGuideRegularFollowup(oldObj.getGuideRegularFollowup());
//        newObj.setGuideIntoChronicDisease(oldObj.getGuideIntoChronicDisease());
//        newObj.setGuideSuggestionReview(oldObj.getGuideSuggestionReview());
//        newObj.setGuideSuggestionReferral(oldObj.getGuideSuggestionReferral());
    }

    /**
     * 其他业务系统（慢病、个人健康体检）更新老年人体检
     * @param personInfo
     * @param physicalExamRecordId
     * @param elderlyPhyExamination
     */
    @Transactional
    private void updateExamination(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination) {
        // 如果没有体检日志,则设置为当前日期
        if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getExaminationDate())) {
            elderlyPhyExamination.setExaminationDate(new Date());
        }
        // 计算年龄
        elderlyPhyExamination.setAge( DateUtil.getAge(personInfo.getBirthday(), elderlyPhyExamination.getExaminationDate()));

        // 更新体检信息
        Criteria criteria = new Criteria("personId", elderlyPhyExamination.getPersonId());
        String ehrId = elderlyPhyExamination.getEhrId();
        criteria.add("ehrId", ehrId);
        HealthExamination examination = healthExaminationDao.get(criteria);
        //判断体检表是否为空
        if (ObjectUtil.isNotEmpty(examination)) {
            copyHealthExamination(elderlyPhyExamination, personInfo, examination);
            healthExaminationDao.update(examination);
        }else{//体检总表加数据
            HealthExamination examinationNew =  new HealthExamination();
            copyHealthExamination(elderlyPhyExamination, personInfo, examinationNew);
            examinationNew.setEhrId(ehrId);
            examinationNew.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
            examinationNew.setPhysicalExamCode(elderlyPhyExamination.getPhysicalExamCode());
            examinationNew.setExamStatus(1);
            healthExaminationDao.insert(examinationNew);
        }
        // 体检数据
        elderlyPhyExamination.setName(personInfo.getName());
        elderlyPhyExamination.setGender(personInfo.getGender());
        elderlyPhyExamination.setBirthday(personInfo.getBirthday());
        elderlyPhyExamination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
        elderlyPhyExaminationDao.update(elderlyPhyExamination);
        // 删除关联的异常数据
        Criteria ca = new Criteria("personId", personInfo.getId()).add("ehrId", ehrId);
        healthEvaluateAnomalyDao.delete(new Criteria("ehrId", ehrId));
        familyBedHistoryDao.delete(ca);
        hospitalizedHistoryDao.delete(ca);
        drugHistoryDao.delete(ca);
        vaccinationInfoDao.delete(ca);
        
        // 更新事件体检机构和体检日期
        updateEhrHealthEvent(personInfo, elderlyPhyExamination);
		this.updateHealthGuide(elderlyPhyExamination);
        this.updateFamilyBedHistory(elderlyPhyExamination);
        this.updateHospitalization(elderlyPhyExamination);
        this.updateDrugHistory(elderlyPhyExamination);
        this.updateVaccinationInfo(elderlyPhyExamination);
        //更新体检状态表
        updateElderlyPhyStatus(elderlyPhyExamination);
    }

    /**
     * 其他业务系统（慢病、个人健康体检）新增老年人体检
     * @param personInfo
     * @param physicalExamRecordId
     * @param elderlyPhyExamination
     * @param organization
     */
    @Transactional(rollbackFor = Exception.class)
    void addPhyExamination(PersonInfo personInfo, ElderlyPhyExamination elderlyPhyExamination, Organization organization) {
        // 如果没有体检日志,则设置为当前日期
        if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination.getExaminationDate())) {
            elderlyPhyExamination.setExaminationDate(new Date());
        }
        // 计算年龄
        elderlyPhyExamination.setAge(
            DateUtil.getAge(personInfo.getBirthday(), elderlyPhyExamination.getExaminationDate()));

        // 体检事件
        EHRHealthEvent event = createEhrHealthEvent(
            EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode(), "老年人体检", personInfo,
            elderlyPhyExamination);

        // 体检信息
        HealthExamination examination = new HealthExamination();
        copyHealthExamination(elderlyPhyExamination, personInfo, examination);
        String ehrId = event.getEhrId();
        examination.setEhrId(ehrId);
        examination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
        examination.setPhysicalExamCode(elderlyPhyExamination.getPhysicalExamCode());
        examination.setExamStatus(1);
        healthExaminationDao.insert(examination);
        // 体检数据
        elderlyPhyExamination.setEhrId(ehrId);
        elderlyPhyExamination.setName(personInfo.getName());
        elderlyPhyExamination.setGender(personInfo.getGender());
        elderlyPhyExamination.setBirthday(personInfo.getBirthday());
        elderlyPhyExamination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
        Number elderlyPhyExamiId = elderlyPhyExaminationDao.generatedKey(elderlyPhyExamination, "ID", null);
        
        elderlyPhyExamination.setId(Long.valueOf(String.valueOf(elderlyPhyExamiId)));
        this.updateHealthGuide(elderlyPhyExamination);
        this.updateFamilyBedHistory(elderlyPhyExamination);
        this.updateHospitalization(elderlyPhyExamination);
        this.updateDrugHistory(elderlyPhyExamination);
        this.updateVaccinationInfo(elderlyPhyExamination);
        //更新体检状态表
        updateElderlyPhyStatus(elderlyPhyExamination);
    }


    private Long addExamination(Long personId, Date examYear) {
        Long result = 0L;
        Criteria criteria = new Criteria("id", personId);
        List<Map<String, Object>> persons = platformService.queryPersonalInfoMap(criteria,
            "id", "idcard", "name", "birthday", "gender", "inputOrganCode", "inputCenterOrganCode",
            "inputGbcode",
            "paymentUrbanWorkders", "paymentUrbanResident", "paymentNewRuralCooperation",
            "paymentPovertyRelief"
            , "paymentCommercial", "paymentBursary", "paymentPersonalExpenses", "paymentOther",
            "marriage", "email", "phoneNumber", "homePhone");
        for (Map<String, Object> person : persons) {
            mapPersonInfo(examYear, person, null);
        }
        physicalExamRecordDao
            .batchMapInsert(persons, "examYear", "personId", "idcard", "name", "birthday", "gender",
                "gbcode",
                "inputSuperOrganCode", "inputOrganCode", "paymentPatternCode", "marriage", "moible",
                "telephone", "eMail");
        PhysicalExamRecord physicalExamRecord = physicalExamRecordDao
            .get(personId, DateUtil.getField(examYear, Calendar.YEAR));
        if (ObjectUtil.isNotEmpty(physicalExamRecord)) {
            result = physicalExamRecord.getId();
        }
        return result;
    }

    @Override
    public PageList<PhysicalExamRecord> getPhysicalExamRecordList(Page page, List<String> orgCodes, Criteria criteria,
        String examinationDateStart, String examinationDateEnd) {
        // TODO Auto-generated method stub
        return physicalExamRecordDao
            .getPhysicalExamRecordList(page, orgCodes, criteria, examinationDateStart, examinationDateEnd);
    }

    @Override
    public List<PhysicalExamRecord> getPhysicalExamRecordList(Criteria criteria,
        String examinationDateStart, String examinationDateEnd) {
        // TODO Auto-generated method stub
        return physicalExamRecordDao
            .getPhysicalExamRecordList(criteria, examinationDateStart, examinationDateEnd);
    }

    @Override
    public Long getCount(Criteria caexam) {
        return physicalExamRecordDao.getCount(caexam, "1", Long.class);
    }

    @Override
    public List<Map<String, Object>> exportPhysiqueExaminationList(Page page, List<Long> idList,
        String examYear) {

        if (ObjectUtil.isNotEmpty(idList)) {
            String type = EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode();
            List<HealthExamination> healthExaminationList = healthExaminationDao
                .getHealthExaminationList(examYear, idList.toString(), type);
            List<String> ehrIdList = new ArrayList<>();
            List<Long> personIdList = new ArrayList<>();
            for (int i = 0; i < healthExaminationList.size(); i++) {
                ehrIdList.add(healthExaminationList.get(i).getEhrId());
                personIdList.add(healthExaminationList.get(i).getPersonId());
            }
            PageList<Map<String, Object>> mapList = elderlyPhyExaminationDao.getPageMapList(page,
                new Criteria("ehrId", OP.IN, ehrIdList).add("personId", OP.IN, personIdList),
                new Order("EXAMINATION_DATE DESC"));
            if (null == mapList) {
                return Collections.emptyList();
            }
            mapList.getList().get(0).get("diet_HunsuEquilibrium");
            for (int i = 0; i < mapList.getList().size(); i++) {
                if (("1").equals(mapList.getList().get(i).get("cognition_Screen_Result"))) {
                    mapList.getList().get(i).put("cognition_Screen_Result", "粗筛阴性");
                } else if (("0").equals(mapList.getList().get(i).get("cognition_Screen_Result"))) {
                    mapList.getList().get(i).put("cognition_Screen_Result", "粗筛阳性");
                }

                if (("1").equals(mapList.getList().get(i).get("emotion_Screen_Result"))) {
                    mapList.getList().get(i).put("emotion_Screen_Result", "粗筛阴性");
                } else if (("0").equals(mapList.getList().get(i).get("cognition_Screen_Result"))) {
                    mapList.getList().get(i).put("emotion_Screen_Result", "粗筛阳性");
                }

                if (("1").equals(mapList.getList().get(i).get("ecg_Anomaly_Flag"))) {
                    mapList.getList().get(i).put("ecg_Anomaly_Flag", "异常");
                } else if (("0").equals(mapList.getList().get(i).get("ecg_Anomaly_Flag"))) {
                    mapList.getList().get(i).put("ecg_Anomaly_Flag", "正常");
                } else if (("2").equals(mapList.getList().get(i).get("ecg_Anomaly_Flag"))) {
                    mapList.getList().get(i).put("ecg_Anomaly_Flag", "未检");
                }
                if (("0").equals(mapList.getList().get(i).get("fecal_Occult_Blood"))) {
                    mapList.getList().get(i).put("fecal_Occult_Blood", "未检");
                } else if (("1").equals(mapList.getList().get(i).get("fecal_Occult_Blood"))) {
                    mapList.getList().get(i).put("fecal_Occult_Blood", "阴性");
                } else if (("2").equals(mapList.getList().get(i).get("fecal_Occult_Blood"))) {
                    mapList.getList().get(i).put("fecal_Occult_Blood", "阳性");
                }
                if (("0").equals(mapList.getList().get(i).get("hbsag_Detect_Result"))) {
                    mapList.getList().get(i).put("hbsag_Detect_Result", "未检");
                } else if (("1").equals(mapList.getList().get(i).get("hbsag_Detect_Result"))) {
                    mapList.getList().get(i).put("hbsag_Detect_Result", "阴性");
                } else if (("2").equals(mapList.getList().get(i).get("hbsag_Detect_Result"))) {
                    mapList.getList().get(i).put("hbsag_Detect_Result", "阳性");
                }

                String str = "";
                if (("1").equals(mapList.getList().get(i).get("diet_Hunsu_Equilibrium"))) {
                    str = str + "荤素均衡,";
                    mapList.getList().get(i).remove("diet_Hunsu_Equilibrium");
                }
                if ("2".equals(mapList.getList().get(i).get("diet_Meat_Main"))) {
                    str = str + "荤食为主,";
                    mapList.getList().get(i).remove("diet_Meat_Main");
                }
                if ("3".equals(mapList.getList().get(i).get("Diet_Vegetarian"))) {
                    str = str + "素食为主,";
                    mapList.getList().get(i).remove("Diet_Vegetarian");
                }
                if ("4".equals(mapList.getList().get(i).get("Diet_Halophilic"))) {
                    str = str + "嗜盐,";
                    mapList.getList().get(i).remove("Diet_Halophilic");
                }
                if ("5".equals(mapList.getList().get(i).get("Diet_Addicted_Oil"))) {
                    str = str + "嗜油,";
                    mapList.getList().get(i).remove("Diet_Addicted_Oil");
                }
                if ("6".equals(mapList.getList().get(i).get("Diet_Sugar_Cravings"))) {
                    str = str + "嗜糖";
                    mapList.getList().get(i).remove("Diet_Sugar_Cravings");
                }
                Criteria c = new Criteria();
                c.add("id", mapList.getList().get(i).get("person_id"));
                PersonInfo personInfo = personInfoDao.get(c);
                mapList.getList().get(i).put("phone_Number", personInfo.getPhoneNumber());
                if (ObjectUtil.isNotEmpty(str)) {
                    if (",".equals(str.substring(str.length() - 1, str.length()))) {
                        str = str.substring(0, str.length() - 1);
                    }
                }

                mapList.getList().get(i).put("dietary_Habit", str);
            }

            return mapList.getList();
        } else {
            return null;
        }
    }

    @Override
    public List<Map<String, Object>> exportPhysiqueExaminationList(Page page, Criteria criteria,
        String examinationDateStart, String examinationDateEnd, String year) {
        if (ObjectUtil.isNotEmpty(year)) {
            Date examYear = DateUtil.convert("yyyy", year);
            year = DateUtil.toFormatString("yyyy", examYear);
        }
        PageList<Map<String, Object>> mapList = elderlyPhyExaminationDao
            .getPageMapTableList(page, criteria, examinationDateStart, examinationDateEnd, year);
        if (null == mapList) {
            return Collections.emptyList();
        }
        mapList.getList().get(0).get("diet_HunsuEquilibrium");
        for (int i = 0; i < mapList.getList().size(); i++) {
            if (("1").equals(mapList.getList().get(i).get("cognition_Screen_Result"))) {
                mapList.getList().get(i).put("cognition_Screen_Result", "粗筛阴性");
            } else if (("0").equals(mapList.getList().get(i).get("cognition_Screen_Result"))) {
                mapList.getList().get(i).put("cognition_Screen_Result", "粗筛阳性");
            }

            if (("1").equals(mapList.getList().get(i).get("emotion_Screen_Result"))) {
                mapList.getList().get(i).put("emotion_Screen_Result", "粗筛阴性");
            } else if (("0").equals(mapList.getList().get(i).get("cognition_Screen_Result"))) {
                mapList.getList().get(i).put("emotion_Screen_Result", "粗筛阳性");
            }

            if (("1").equals(mapList.getList().get(i).get("ecg_Anomaly_Flag"))) {
                mapList.getList().get(i).put("ecg_Anomaly_Flag", "异常");
            } else if (("0").equals(mapList.getList().get(i).get("ecg_Anomaly_Flag"))) {
                mapList.getList().get(i).put("ecg_Anomaly_Flag", "正常");
            } else if (("2").equals(mapList.getList().get(i).get("ecg_Anomaly_Flag"))) {
                mapList.getList().get(i).put("ecg_Anomaly_Flag", "未检");
            }

            if (("1").equals(mapList.getList().get(i).get("bmode_Anomalyf_Flag"))) {
                mapList.getList().get(i).put("bmode_Anomalyf_Flag", "异常");
            } else if (("0").equals(mapList.getList().get(i).get("bmode_Anomalyf_Flag"))) {
                mapList.getList().get(i).put("bmode_Anomalyf_Flag", "正常");
            } else if (("2").equals(mapList.getList().get(i).get("bmode_Anomalyf_Flag"))) {
                mapList.getList().get(i).put("bmode_Anomalyf_Flag", "未检");
            }

            if (("0").equals(mapList.getList().get(i).get("fecal_Occult_Blood"))) {
                mapList.getList().get(i).put("fecal_Occult_Blood", "未检");
            } else if (("1").equals(mapList.getList().get(i).get("fecal_Occult_Blood"))) {
                mapList.getList().get(i).put("fecal_Occult_Blood", "阴性");
            } else if (("2").equals(mapList.getList().get(i).get("fecal_Occult_Blood"))) {
                mapList.getList().get(i).put("fecal_Occult_Blood", "阳性");
            }
            if (("0").equals(mapList.getList().get(i).get("hbsag_Detect_Result"))) {
                mapList.getList().get(i).put("hbsag_Detect_Result", "未检");
            } else if (("1").equals(mapList.getList().get(i).get("hbsag_Detect_Result"))) {
                mapList.getList().get(i).put("hbsag_Detect_Result", "阴性");
            } else if (("2").equals(mapList.getList().get(i).get("hbsag_Detect_Result"))) {
                mapList.getList().get(i).put("hbsag_Detect_Result", "阳性");
            }

            String str = "";
            if (("1").equals(mapList.getList().get(i).get("diet_Hunsu_Equilibrium"))) {
                str = str + "荤素均衡,";
                mapList.getList().get(i).remove("diet_Hunsu_Equilibrium");
            }
            if ("2".equals(mapList.getList().get(i).get("diet_Meat_Main"))) {
                str = str + "荤食为主,";
                mapList.getList().get(i).remove("diet_Meat_Main");
            }
            if ("3".equals(mapList.getList().get(i).get("Diet_Vegetarian"))) {
                str = str + "素食为主,";
                mapList.getList().get(i).remove("Diet_Vegetarian");
            }
            if ("4".equals(mapList.getList().get(i).get("Diet_Halophilic"))) {
                str = str + "嗜盐,";
                mapList.getList().get(i).remove("Diet_Halophilic");
            }
            if ("5".equals(mapList.getList().get(i).get("Diet_Addicted_Oil"))) {
                str = str + "嗜油,";
                mapList.getList().get(i).remove("Diet_Addicted_Oil");
            }
            if ("6".equals(mapList.getList().get(i).get("Diet_Sugar_Cravings"))) {
                str = str + "嗜糖";
                mapList.getList().get(i).remove("Diet_Sugar_Cravings");
            }
            if (ObjectUtil.isNotEmpty(str)) {
                if (",".equals(str.substring(str.length() - 1, str.length()))) {
                    str = str.substring(0, str.length() - 1);
                }
            }

            mapList.getList().get(i).put("dietary_Habit", str);
        }

        if (null == mapList) {
            return Collections.emptyList();
        }
        return mapList.getList();
    }

    @Override
    public List<Map<String, Object>> getPhysicalExamProgressMapList(Criteria criteria) {
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        mapList = physicalExamRecordDao.getPhysicalExamProgressMapList(criteria);
        return mapList;
    }

    @Override
    public int hasPhysicalExam(Criteria criteria, String examYear) {
        PersonInfo personInfo = platformService.queryPersonalInfo(criteria);
        //未建档人员
        if (ObjectUtil.isNullOrEmpty(personInfo) || (
            (!EHRConstants.HAD_CREATE.equals(personInfo.getFilingFlag())) &
                (!EHRConstants.MOVE_OUT.equals(personInfo.getFilingFlag())))) {
            return 0;
        }
        Date examDate;
        if (StringUtil.isNullOrEmpty(examYear)) {
            examDate = new Date();
        } else {
            examDate = DateUtil.parseSimpleDate(examYear, "yyyy");
        }
        Criteria cri = new Criteria();
        cri.add("personId", personInfo.getId());
        cri.add("examYear", DateUtil.getField(examDate, Calendar.YEAR));
        List<ElderlyPhyStatus> statuss = elderlyPhyStatusDao.getList(cri);
        
        if (ObjectUtil.isNotEmpty(statuss)) {
        	List<String> list = new ArrayList<>();
        	for(ElderlyPhyStatus status: statuss){
        		list.add(status.getPhysicalExamCode());
        	}
            List<ElderlyPhyExamination> elderlys = elderlyPhyExaminationDao.getList(
            		new Criteria("personId", personInfo.getId()).add("physicalExamCode", OP.IN, list));
            if (ObjectUtil.isNullOrEmpty(elderlys)) {
                return 1;
            }
            //判断是否做过指导和评估
            for(ElderlyPhyExamination elderly: elderlys){
            	if (StringUtil.isNotEmpty(elderly.getHealthSelfAssessment()) 
                	|| StringUtil.isNotEmpty(elderly.getLifeAbilitySelfAssessment())
                    || ObjectUtil.isNotEmpty(elderly.getEatingAssessment()) 
                    || ObjectUtil.isNotEmpty(elderly.getCleaningAssessment())
                    || ObjectUtil.isNotEmpty(elderly.getClothingAssessment())
                    || ObjectUtil.isNotEmpty(elderly.getDefecationAssessment())
                    || ObjectUtil.isNotEmpty(elderly.getExerciseAssessment())) {
                    return 2;
                }
        	}
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveEvaluation(ElderlyPhyExamination elderlyPhyExamination) {
        Long personId = elderlyPhyExamination.getPersonId();
        if (ObjectUtil.isNullOrEmpty(personId)) {
            return 0;
        } else {
            PhysicalExamRecord physicalExamRecord = physicalExamRecordDao.get(new Criteria("personId", personId));

//            //没有对应的老年人体检，做新增体检记录
//            if (StringUtil.isNullOrEmpty(physicalExamRecord.getExamNumber())) {
                String organCode = physicalExamRecord.getInputOrganCode();
                String examNumber = EHRNumberService.getSerialNum(elderlyPhyExamination.getExaminationOrganCode(), EHRConstants.EXAM_NUMBER_TYPE);
                //增加体检事件
                EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
                ehrHealthEvent.setEhrType(EventType.OLDER_PHYSICAL_GUIDE.getCode());
                ehrHealthEvent.setEhrName(EventType.OLDER_PHYSICAL_GUIDE.getName());
                ehrHealthEvent.setName(physicalExamRecord.getName());
                ehrHealthEvent.setAge((physicalExamRecord.getAge()).toString());
                ehrHealthEvent.setPersonId(personId);
                ehrHealthEvent.setCreateDate(new Date());
                ehrHealthEvent.setClinicDate(new Date());
                ehrHealthEvent.setClinicOrganCode(organCode);
                ehrHealthEvent.setIsDelete(EHRConstants.DELETE_FLG_0);
                Long healthEventId = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID", null)
                    .longValue();
                ehrHealthEvent.setId(healthEventId);
                ehrHealthEvent.setEhrId(String.valueOf(healthEventId));
                ehrHealthEventDao.update(ehrHealthEvent);
                //新增老年人体检
                elderlyPhyExamination.setName(physicalExamRecord.getName());
                elderlyPhyExamination.setEhrId(String.valueOf(healthEventId));
                elderlyPhyExamination.setAge((physicalExamRecord.getAge()).toString());
                //增加体检时间
                elderlyPhyExamination.setExaminationDate(new Date());
                elderlyPhyExamination.setPhysicalExamCode(examNumber);
                elderlyPhyExamination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
                elderlyPhyExaminationDao.insert(elderlyPhyExamination);
                //新增体检总表
                HealthExamination examination = new HealthExamination();
                examination.setEhrId(String.valueOf(healthEventId));
                examination.setName(physicalExamRecord.getName());
                examination.setAge(physicalExamRecord.getAge().toString());
                examination.setPersonId(personId);
                examination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
                examination.setPhysicalExamCode(examNumber);
                examination.setExamStatus(0);//报告未生成
                healthExaminationDao.insert(examination);
                //更新体检状态表
                updateElderlyPhyStatus(elderlyPhyExamination);
                return 1;
//            } else {
//                //有老年人体检记录
//                String organCode = physicalExamRecord.getInputOrganCode();
//                String examNumber = physicalExamRecord.getExamNumber();
//                //更新老年人体检总表
//                physicalExamRecord.setEstimateStatus(1);
//                physicalExamRecordDao.update(physicalExamRecord, "estimateStatus");
//                //增加体检事件
//                EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
//                ehrHealthEvent.setEhrType(EventType.OLDER_PHYSICAL_GUIDE.getCode());
//                ehrHealthEvent.setEhrName(EventType.OLDER_PHYSICAL_GUIDE.getName());
//                ehrHealthEvent.setName(physicalExamRecord.getName());
//                ehrHealthEvent.setAge((physicalExamRecord.getAge()).toString());
//                ehrHealthEvent.setPersonId(personId);
//                ehrHealthEvent.setCreateDate(new Date());
//                ehrHealthEvent.setClinicDate(new Date());
//                ehrHealthEvent.setClinicOrganCode(organCode);
//                ehrHealthEvent.setIsDelete(EHRConstants.DELETE_FLG_0);
//                Long healthEventId = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID", null).longValue();
//                ehrHealthEvent.setId(healthEventId);
//                ehrHealthEvent.setEhrId(String.valueOf(healthEventId));
//                ehrHealthEventDao.update(ehrHealthEvent);
//                //老年人体检更新
//                ElderlyPhyExamination elderlyPhyExaminationDB = elderlyPhyExaminationDao
//                    .get(new Criteria("physicalExamCode", examNumber), new String[]{"ID"});
//                elderlyPhyExamination.setId(elderlyPhyExaminationDB.getId());
//                elderlyPhyExaminationDao.update(elderlyPhyExamination, evaluateProp);
//                return 1;
//            }
        }
    }

    /**
     * 老年人、慢病、个人体检同步删除老年人体检
     */
    @Override
	public void deleteByEhrId(Long personId, String ehrId, String physicalExamCode) {
        Criteria criteria = new Criteria("personId", personId);
        HealthExamination examination;
        if(StringUtil.isNotEmpty(ehrId)){
        	criteria.add("ehrId", ehrId);
        }else if(StringUtil.isNotEmpty(physicalExamCode)){
        	criteria.add("physicalExamCode", physicalExamCode);
        }
        
        criteria.add("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
    	examination = healthExaminationDao.get(criteria, "id","ehrId","physicalExamCode","examinationDate");

       	if(ObjectUtil.isNotEmpty(examination)){
    		ehrHealthEventDao.delete(new Criteria("personId", personId).add("ehrId", examination.getEhrId()));  
        	
            healthExaminationDao.delete(examination.getId());
            
            Criteria critElder = new Criteria("physicalExamCode", examination.getPhysicalExamCode());
            critElder.add("personId", personId);
            //修改为逻辑删除 删除老年人体检
            elderlyPhyExaminationDao.delete(new Criteria("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode()).add(critElder));
            //删除老年人体检状态
            elderlyPhyStatusDao.delete(critElder);
        }
	}
    
    @Override
    public Long addOlderExamination(Long personId, Date examYear) {
        Long result = 0L;
        PhysicalExamRecord physicalExamRecord = physicalExamRecordDao.get(new Criteria("personId", personId));

        if (ObjectUtil.isNotEmpty(physicalExamRecord)) {
            result = physicalExamRecord.getId();
            return result;
        }
        return this.addExamination(personId, examYear);
    }
	private List<Organization> getStation(String supOrganCode) {
		List<Organization> stations = new ArrayList<Organization>();

		stations.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue())));
		return stations;
	}
	
	private void countCensus(Map<String, Object> census, Map<String, Object> map, Integer type) {
		if(type==1){
			census.put("fpg_count", Integer.parseInt(census.get("fpg_count").toString()) + Integer.parseInt(map.get("fpg_count").toString()));
			census.put("blood_count", Integer.parseInt(census.get("blood_count").toString()) + Integer.parseInt(map.get("blood_count").toString()));
			census.put("urine_count", Integer.parseInt(census.get("urine_count").toString()) + Integer.parseInt(map.get("urine_count").toString()));
			census.put("dyslipidemia_count", Integer.parseInt(census.get("dyslipidemia_count").toString()) + Integer.parseInt(map.get("dyslipidemia_count").toString()));
			census.put("liver_count", Integer.parseInt(census.get("liver_count").toString()) + Integer.parseInt(map.get("liver_count").toString()));
			
			census.put("renal_count", Integer.parseInt(census.get("renal_count").toString()) + Integer.parseInt(map.get("renal_count").toString()));
			census.put("b_count", Integer.parseInt(census.get("b_count").toString()) + Integer.parseInt(map.get("b_count").toString()));
			census.put("ecg_count", Integer.parseInt(census.get("ecg_count").toString()) + Integer.parseInt(map.get("ecg_count").toString()));
			census.put("older_num", Integer.parseInt(census.get("older_num").toString()) + Integer.parseInt(map.get("older_num").toString()));
		}else if(type==2){
			census.put("estimate_sum", Integer.parseInt(census.get("estimate_sum").toString()) + Integer.parseInt(map.get("estimate_sum").toString()));
			census.put("exam_count", Integer.parseInt(census.get("exam_count").toString()) + Integer.parseInt(map.get("exam_count").toString()));
			census.put("exam_sum", Integer.parseInt(census.get("exam_sum").toString()) + Integer.parseInt(map.get("exam_sum").toString()));
			census.put("manage_sum", Integer.parseInt(census.get("manage_sum").toString()) + Integer.parseInt(map.get("manage_sum").toString()));
			census.put("guide_sum", Integer.parseInt(census.get("guide_sum").toString()) + Integer.parseInt(map.get("guide_sum").toString()));
			census.put("fill_count", Integer.parseInt(census.get("fill_count").toString()) + Integer.parseInt(map.get("fill_count").toString()));
			census.put("older_num", Integer.parseInt(census.get("older_num").toString()) + Integer.parseInt(map.get("older_num").toString()));
			census.put("tcm_count", Integer.parseInt(census.get("tcm_count").toString()) + Integer.parseInt(map.get("tcm_count").toString()));
		}
	}

	@Override
	public List<Map<String, Object>> getElderlyPhysicalExamStatisticsByPaAddress(Criteria criteria, Integer type) {
		List<String> organCodeList = new ArrayList<>();
		if(criteria.contains(CENTERCODE)){
			String organCode = criteria.get(CENTERCODE).toString();
			organCodeList.add(organCode);
			// 获取卫生服务中心下属服务站
	        List<Organization> stations = getStation(organCode);
	        for (Organization organization : stations) {
	            organCodeList.add(organization.getOrganCode());
	        }
		}
		List<Map<String, Object>> censusList = elderlyHealthStatisticsDao.getElderlyStatisticsByPaAddress(criteria, organCodeList, type);
		return censusList;
	}

}