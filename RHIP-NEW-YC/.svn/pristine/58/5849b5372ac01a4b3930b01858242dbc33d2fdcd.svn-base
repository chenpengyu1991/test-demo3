/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.hm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.common.ReflectionUtils;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.clinic.*;
import com.founder.rhip.ehr.repository.clinic.*;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service("physiqueExaminiationService")
public class PhysiqueExaminationServiceImpl extends AbstractService implements IPhysiqueExaminationService {

	@Resource(name = "elderlyPhyExaminationDao")
	private IElderlyPhyExaminationDao elderlyPhyExaminationDao;

	@Resource(name = "healthExaminationDao")
	private IHealthExaminationDao healthExaminationDao;

	@Resource(name = "physicalExamRecordDao")
	private IPhysicalExamRecordDao physicalExamRecordDao;

	@Resource(name = "healthEvaluateAnomalyDao")
	private IHealthEvaluateAnomalyDao healthEvaluateAnomalyDao;
	
	@Resource(name = "physiqueExaminationDao")
	private IPhysiqueExaminationDao physiqueExaminationDao;
	
	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService ehrService; 
	
	@Resource(name = "ehrHealthEventDao")
	private IEHRHealthEventDao ehrHealthEventDao;

	private String[] assessProp = {
			"healthSelfAssessment", "lifeAbilitySelfAssessment",
			"cognitionScreenResult", "cognitionScreenScore",
			"emotionScreenResult", "depressionScore", "eatingAssessment",
			"cleaningAssessment", "clothingAssessment", "defecationAssessment",
			"exerciseAssessment"
	};

	private String[] guideProp = {
			"healthEvaluateAnomalyFlag", "guideIntoChronicDisease", "guideRegularFollowup",
			"guideSuggestionReview", "guideSuggestionReferral", "riskQuitSmoking",
			"riskHealthDrink", "riskDiet", "riskExercise", "riskWeightReduction",
			"riskWeightTarget", "guideVaccination", "guideVaccinationDesc", "riskOther",
			"riskOtherDesc"
	};

	/**
	 * 数据获取
	 * @param       criteria
	 * @return      PhysiqueExamination
	 */
	public ElderlyPhyExamination getPhysiqueExamination(Criteria criteria) {
		List<ElderlyPhyExamination> list = elderlyPhyExaminationDao.getList(criteria);
		if(ObjectUtil.isNotEmpty(list)){
			return list.get(0);
		}
		return null;
	}

//	/**
//	 * 获取体检数据
//	 * @param   examRecord
//	 * @return  PhysiqueExamination
//	 */
//	@Override
//	public ElderlyPhyExamination getPhysiqueExamination(PhysicalExamRecord examRecord) {
//		if (examRecord == null) {
//			return null;
//		}
//		Date examYear = examRecord.getExamYear();
//		String year = DateUtil.toFormatString("yyyy", examYear);
//		Long personId = examRecord.getPersonId();
//		String type = EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode();
//		HealthExamination healthExamination = healthExaminationDao.getHealthExamination(year, personId, type);
//    //判断是否做体检
//		if (healthExamination == null) {
//      //判断是否有体检编号
//      if (StringUtil.isNotEmpty(examRecord.getExamNumber())) {
//        return elderlyPhyExaminationDao.get(
//            new Criteria("personId", personId).add("physicalExamType", type)
//                .add("physicalExamCode", examRecord.getExamNumber()));
//
//      } else {
//        return elderlyPhyExaminationDao
//            .get(new Criteria("personId", personId).add("physicalExamType", type)
//                .add("examinationDate", OP.BETWEEN, new Date[]{DateUtil.firstDateOfYear(examYear),
//                    DateUtil.lastDateOfYear(examYear)}));
//      }
//    }
//    return elderlyPhyExaminationDao.get(new Criteria("ehrId", healthExamination.getEhrId()).add("personId", healthExamination.getPersonId()));
//	}

	@Override
	public PageList<ElderlyPhyExamination> getPhysiqueExaminationList(Page page, List<Long> idList, String examYear){
		if(ObjectUtil.isNotEmpty(idList)){
			String type = EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode();
			List<HealthExamination> healthExaminationList = healthExaminationDao.getHealthExaminationList(examYear, idList.toString(), type);
			List<String> ehrIdList=new ArrayList<>();
			List<Long> personIdList=new ArrayList<>();
			for (int i = 0; i < healthExaminationList.size(); i++) {
				ehrIdList.add(healthExaminationList.get(i).getEhrId());
				personIdList.add(healthExaminationList.get(i).getPersonId());
			}
			return elderlyPhyExaminationDao.getPageList(page,new Criteria("ehrId", OP.IN, ehrIdList).add("personId",OP.IN, personIdList),new Order("EXAMINATION_DATE DESC"));
		}else{
			return null;
		}

	}

	/**
	 * 更新健康指导
	 *
	 * @param   examination
	 * @param   anomalyDesc
	 * @param   examId
	 * @param examRecordId
	 * @return  boolean
	 */
	@Transactional
	@Override
	public int updateHealthGuide(ElderlyPhyExamination examination, String anomalyDesc, Long examId, Long examRecordId, String ehrId) {
		if (examination == null) {
			return 0;
		}
		// pack evaluation data
		boolean check1 = false;
		examination.setId(examId);
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
		List<HealthEvaluateAnomaly> anomalyList = new ArrayList<>();
		if (StringUtil.isNotEmpty(anomalyDesc) && ehrId != null) {
			String[] anomalies = anomalyDesc.split(";");
			for (String anomaly : anomalies) {
				HealthEvaluateAnomaly hea = new HealthEvaluateAnomaly();
				hea.setEhrId(ehrId);
				hea.setHealthEvaluateAnomalyDesc(anomaly);
				anomalyList.add(hea);
			}
			if (ObjectUtil.isNotEmpty(anomalyList)) {
				check2 = true;
			}
		}

		// do the update
		if (check1) {
			int rt1 = elderlyPhyExaminationDao.update(examination, properties.toArray(new String[]{""}));
			int rt2 = 0;
			if (check2) {
                healthEvaluateAnomalyDao.delete(new Criteria("EHR_ID", anomalyList.get(0).getEhrId()));
				rt2 = healthEvaluateAnomalyDao.batchInsert(anomalyList);
			}
			if (rt1 != 0 && (!check2 || rt2 != 0)) {
				return 1;
			}
		}
		return 0;
	}
	
	/**
	 * 同步体检信息到健康档案体检表
	 */
	@Override
	public void syncEhrHealthExamination(String organCode) {
		Criteria criteria = new Criteria("examStatus", 1);
		if (StringUtil.isNotEmpty(organCode)) {
			criteria.add("inputSuperOrganCode", organCode);
		}
		int errorCount=0;
		List<Long> updateExamPerson = new ArrayList<Long>();
		List<Long> updateStartPerson = new ArrayList<Long>();
		List<PhysicalExamRecord> records = physicalExamRecordDao.getList(criteria);
		for (PhysicalExamRecord record : records) {
			Criteria cri = new Criteria();
			cri.add("personId", record.getPersonId());
			cri.add("physicalExamType", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
			List<ElderlyPhyExamination> examinations = elderlyPhyExaminationDao.getList(cri, new Order("examinationDate desc"));
			if(ObjectUtil.isNullOrEmpty(examinations)){
				continue;
			}
			ElderlyPhyExamination pe = examinations.get(0);

			Long personId = pe.getPersonId();
			try {
				//判断健康档案是否有此人体检记录
				criteria = new Criteria("personId", personId);
				PhysiqueExamination ehrPye = physiqueExaminationDao.get(criteria, "id");
				if (ehrPye == null) {
					pe.setUrineProQuantitativeValue(null);
					pe.setUrineSugQuantitativeValue(null);
					ehrPye = ReflectionUtils.wrapBean(PhysiqueExamination.class, pe);
					ehrPye.setPersonId(personId);
					boolean isUpdate = createPhysiqueExamination(ehrPye, personId);
					updateExamPerson.add(personId);
					if (isUpdate) {
						updateStartPerson.add(personId);
					}
				}
			} catch (Exception e) {
				log.error("同步体检信息到健康档案错误personId=" + personId , e);
				errorCount++;
			}
		}
		log.info(String.format("同步体检信息到健康档案：处理机构%s，应处理%d条，更新健康档案体检报告%d条，更新健康档案星级%d条，系统错误%d条", 
				organCode, records.size(), updateExamPerson.size(), updateStartPerson.size(), errorCount));
		log.info("更新健康档案体检报告["+ArrayUtil.toString(updateExamPerson.toArray(new Long[updateExamPerson.size()]))+"]");
		log.info("更新健康档案星级["+ArrayUtil.toString(updateStartPerson.toArray(new Long[updateStartPerson.size()]))+"]");
	}
	
	@Transactional
	private boolean createPhysiqueExamination(PhysiqueExamination ehrPye, Long personId) {
		EventType eventType = EventType.PERSON_RECORD_PHYSICIAL_EXAM;
		Criteria criteria = new Criteria("personId", personId).add("ehrType", eventType.getCode());
		EHRHealthEvent event = ehrHealthEventDao.get(criteria, "id", "ehrId");
		if (event == null) {
			//添加医疗事件
			event = insertEhrHealthEvent(eventType, ehrPye);
		}
		ehrPye.setEhrId(event.getEhrId());
		physiqueExaminationDao.insert(ehrPye);
		//更新健康档案星级
		return ehrService.updateToThreeStar(personId);
	}
	
	private EHRHealthEvent insertEhrHealthEvent(EventType ehrType, PhysiqueExamination exam) {
		EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
		ehrHealthEvent.setUpdateDate(new Date());
		Long personId = exam.getPersonId();
		if (ehrType != null && personId != null) {
			ehrHealthEvent.setEhrType(ehrType.getCode());
			ehrHealthEvent.setEhrName(ehrType.getName());
			ehrHealthEvent.setName(exam.getName());
			ehrHealthEvent.setAge(DateUtil.getAgeByBirthday(exam.getBirthday(), exam.getExaminationDate()) + "岁");
			ehrHealthEvent.setPersonId(personId);
			ehrHealthEvent.setClinicDate(exam.getExaminationDate());
			ehrHealthEvent.setClinicOrganCode(exam.getExaminationOrganCode());
			ehrHealthEvent.setClinicOrganName(exam.getExaminationOrganName());
			ehrHealthEvent.setCreateOrganCode(exam.getExaminationOrganCode());
			ehrHealthEvent.setCreateOrganName(exam.getExaminationOrganName());
			ehrHealthEvent.setCreateDate(new Date());
			ehrHealthEvent.setDataSource(2);
			ehrHealthEvent.setIsDelete(EHRConstants.DELETE_FLG_0);
			Long healthEventId = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID", null).longValue();
			ehrHealthEvent.setId(healthEventId);
			ehrHealthEvent.setEhrId(String.valueOf(healthEventId));
			ehrHealthEventDao.update(ehrHealthEvent);
		}
		return ehrHealthEvent;
	}

	/**
	 * 获取健康评价异常
	 * @param   criteria
	 * @return  List<HealthEvaluateAnomaly>
	 */
	@Override
	public List<HealthEvaluateAnomaly> getHealthEvaluateAnomaly(Criteria criteria) {
		if (ObjectUtil.isNotEmpty(criteria)) {
			List<HealthEvaluateAnomaly> healthEvaluateAnomalies = healthEvaluateAnomalyDao.getList(criteria, new Order("SORT"));
			if (null != healthEvaluateAnomalies && healthEvaluateAnomalies.size() > 0) {
				if (healthEvaluateAnomalies.size() < 4) {
					List<Integer> list = new ArrayList<>();
					for(HealthEvaluateAnomaly hea :healthEvaluateAnomalies){
						list.add(hea.getSort());
					}
					for (int i = 1; i < 5; i++){
						if(!list.contains(i)){
							HealthEvaluateAnomaly hea = new HealthEvaluateAnomaly();
							hea.setSort(i);
							healthEvaluateAnomalies.add(hea);
						}
					}
					healthEvaluateAnomalies = getSortList(healthEvaluateAnomalies);
				}
			}
			return healthEvaluateAnomalies;
		}
		return null;
	}

	private List<HealthEvaluateAnomaly> getSortList(List<HealthEvaluateAnomaly> list){
        Collections.sort(list, new Comparator<HealthEvaluateAnomaly>() {
            @Override
            public int compare(HealthEvaluateAnomaly h1, HealthEvaluateAnomaly h2) {
            	if(ObjectUtil.isNotEmpty(h1.getSort()) && ObjectUtil.isNotEmpty(h2.getSort()))
            		return h1.getSort() - h2.getSort();
            	return 0;
            }
        });
        return list;
    }
	
	/**
	 * 更新自我评估
	 * @param examination
	 * @param examId
	 * @param examRecordId
	 * @return int
	 */
	@Transactional
	@Override
	public int updateSelfAssessment(ElderlyPhyExamination examination, Long examId, Long examRecordId) {
		if (examination == null) {
			return 0;
		}
		return 1;
	}

    /**
     * 更新老年人自我评估（门户）
     * @param examination
     * @return int
     */
    @Override
    public boolean updateSelfAssessment(ElderlyPhyExamination examination) {
        int rt1 = 0;
        Long id = examination.getId();
        examination.setExaminationDate(new Date());
        examination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
        if(ObjectUtil.isNotEmpty(id)){
            rt1 = elderlyPhyExaminationDao.update(examination,new String[]{"healthSelfAssessment", "lifeAbilitySelfAssessment",
                    "cognitionScreenResult", "cognitionScreenScore", "emotionScreenResult", "depressionScore",
                    "eatingAssessment", "cleaningAssessment", "clothingAssessment", "defecationAssessment", "exerciseAssessment"});
        }else{
            rt1 = elderlyPhyExaminationDao.insert(examination);
        }
        if (rt1 != 0) {
            return true;
        }
        return false;
    }

    @Override
    public ElderlyPhyExamination getElderlyPhyExamination(Long personId, int year, String type){
        ElderlyPhyExamination result = elderlyPhyExaminationDao.getElderlyPhyExamination(personId,year,type);
        return result;
    }

    @Override
    public PageList<ElderlyPhyExamination> getPhysiqueExaminationTableList(Page page, Criteria criteria,
                                                                           String examinationDateStart, String examinationDateEnd,String year) {
        // TODO Auto-generated method stub
        return elderlyPhyExaminationDao.getPhysiqueExaminationTableList(page,criteria,examinationDateStart,examinationDateEnd,year);
    }
    
	@Override
	public void updateEchIdentification(PhysiqueExamination physiqueExamination) {
		elderlyPhyExaminationDao.updateEchIdentification(physiqueExamination);
	}
}