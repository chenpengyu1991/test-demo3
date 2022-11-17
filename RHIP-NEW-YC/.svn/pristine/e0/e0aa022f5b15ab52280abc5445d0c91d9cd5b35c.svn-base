package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.*;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.basic.PhysicalExamRecord;
import com.founder.rhip.ehr.entity.clinic.*;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.clinic.*;
import com.founder.rhip.ehr.repository.statistics.IPhysicalExamRecordDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service("elderPhysicalExaminationAnalyzeService")
@TaskBean(cron = "0 0 4 * * ?", description = "老年人体检定时任务")
public class ElderPhysicalExaminationAnalyzeServiceImpl extends AbstractService implements IElderPhysicalExaminationAnalyzeService, Task {

	@Resource(name = "observationInfoDao")
	private IObservationInfoDao observationInfoDao;

	//@Resource(name = "examineEventDao")
	//private IExamineEventDao examineEventDao;

	@Resource(name = "examineDetailDao")
	private IExamineDetailDao examineDetailDao;

	@Resource(name = "healthExaminationDao")
	private IHealthExaminationDao healthExaminationDao;

	@Resource(name = "studyEventDao")
	private IStudyEventDao studyEventDao;

	@Resource(name = "elderlyPhyExaminationDao")
	private IElderlyPhyExaminationDao elderlyPhyExaminationDao;

	@Resource(name = "ehrHealthEventDao")
	private IEHRHealthEventDao ehrHealthEventDao;

	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;

	@Resource(name = "physicalExamRecordDao")
	private IPhysicalExamRecordDao physicalExamRecordDao;

	@Resource(name = "physiqueExaminationDao")
	private IPhysiqueExaminationDao physiqueExaminationDao;

	@Resource(name = "healthEvaluateAnomalyDao")
	private IHealthEvaluateAnomalyDao healthEvaluateAnomalyDao;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	private final String errorSkipCount = "errorSkipCount";
	private final String dataSkipCount = "dataSkipCount";
	private final String skipCount = "skipCount";
	private final String examDataCount = "examDataCount";
	private final String examineDetailsCount = "examineDetailsCount";
	private final String notSameOrganSkipCount = "notSameOrganSkipCount";
	private final String examCount = "examCount";
	private final String ehrHealthEventsSize = "ehrHealthEventsSize";
	
	@Override
	public void analyzeExaminationItems(String orgCode, String year) {
		// 查询条件
		final Criteria criteria = new Criteria("EHR_TYPE", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
		if (ObjectUtil.isNullOrEmpty(year)) {
			criteria.add("clinicYear", DateUtil.getCurrentYear());
		} else {
			if (StringUtils.isNumeric(year)) {
				criteria.add("clinicYear", Integer.valueOf(year));
			}
		}
		if (ObjectUtil.isNotEmpty(orgCode)) {
			criteria.add("CREATE_ORGAN_CODE", orgCode);
		}
		
		final CountMap countMap = new CountMap();
		com.founder.rhip.ehr.common.PageableDateSource.exec(new IDataSource<EHRHealthEvent>() {

			@Override
			public PageList<EHRHealthEvent> get(Page page) {
				return ehrHealthEventDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<EHRHealthEvent> list) {
				processExamination(list, countMap);
			}
			
		});
		
		int processCount = countMap.get(ehrHealthEventsSize) - countMap.get(dataSkipCount) - countMap.get(skipCount) - countMap.get(errorSkipCount) - countMap.get(notSameOrganSkipCount);
		int noDataCount = processCount - countMap.get(examCount);
		log.info(String.format("老年人扁平化处理报：处理机构%s，应处理%d条，检查处理%d条，检验处理%d条，系统错误跳过%d条，数据错误跳过%d条，数据不全跳过%d条，已经处理过跳过%d条，机构不同跳过%d条", 
				orgCode, countMap.get(ehrHealthEventsSize), countMap.get(examDataCount), countMap.get(examineDetailsCount), countMap.get(errorSkipCount), countMap.get(dataSkipCount), noDataCount, 
				countMap.get(skipCount), countMap.get(notSameOrganSkipCount)));
	}

	private void processExamination(List<EHRHealthEvent> ehrHealthEvents, CountMap countMap) {
		if (ehrHealthEvents == null) {
			return;
		}
		boolean hasExam = false, hasExamDetails = false;
		Date examDate = null;
		int examYear = 0;
		String examYearStr = "";
		countMap.add(ehrHealthEventsSize, ehrHealthEvents.size());
		for (EHRHealthEvent ehrHealthEvent : ehrHealthEvents) {
			String ehrId = null;
			Long personId = null;
			if (ehrHealthEvent == null
					|| ObjectUtil.isNullOrEmpty(ehrId = ehrHealthEvent.getEhrId())
					|| ObjectUtil.isNullOrEmpty(personId = ehrHealthEvent.getPersonId())) {
				countMap.add(dataSkipCount);
				continue;
			}
			
			try {
				PersonInfo personInfo = personInfoDao.get(personId); // 人员信息
				if (personInfo == null) {
					countMap.add(dataSkipCount);
					log.error("平台上未注册人，personId=" + personId);
					continue;
				}
				
				hasExam = false;
				hasExamDetails = false;
				examDate = ehrHealthEvent.getClinicDate() == null ? ehrHealthEvent.getCreateDate() : ehrHealthEvent.getClinicDate();
				examYearStr = DateUtil.getDateTime("yyyy", examDate);
                examYear = Integer.parseInt(examYearStr);
				
                PhysicalExamRecord record = physicalExamRecordDao.get(new Criteria("personId", personId));
				/*if (ObjectUtil.isNotEmpty(record)) {
					boolean isSameOrgan = ehrHealthEvent.getCreateOrganCode().equals(record.getInputSuperOrganCode());
					if (!isSameOrgan) {
						log.error("机构Id不相同，跳过personId=" + personId + ",idcard="+personInfo.getIdcard()+",ehrId=" + ehrId + ",eventOrgan=" + ehrHealthEvent.getCreateOrganCode() + ",recordOrgan=" + record.getInputSuperOrganCode());
						notSameOrganSkipCount++;
						continue;
					}
				}*/
				
				//Criteria ca1 = new Criteria("EHR_ID", ehrId).add("PERSON_ID", personId).add("PHYSICAL_EXAM_TYPE", EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
				HealthExamination healthExamination = healthExaminationDao.getHealthExamination(examYearStr, personId, EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
				boolean isHealthExamCreate = ObjectUtil.isNullOrEmpty(healthExamination);
				if (isHealthExamCreate) {
					healthExamination = ReflectionUtils.wrapBean(HealthExamination.class, personInfo);
					healthExamination.setEhrId(ehrId);
					healthExamination.setAge(ehrHealthEvent.getAge());
					healthExamination.setPersonId(personId);
					healthExamination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
					healthExamination.setExaminationDate(examDate);
					healthExamination.setHospitalCode(ehrHealthEvent.getCreateOrganCode());
					healthExamination.setHospitalName(ehrHealthEvent.getCreateOrganName());
					//TODO
					healthExamination.setPhysicalExamCode(ehrId.split("-")[0].replace("tj", ""));
					healthExaminationDao.insert(healthExamination);
				} else {
					// 更新MS_HEALTH_EXAMINATION表
					healthExamination.setEhrId(ehrId);
					//healthExamination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode()); // 老年人体检
					healthExamination.setExaminationDate(examDate); // 体检日期
					healthExamination.setAge(ehrHealthEvent.getAge());
					healthExamination.setHospitalCode(ehrHealthEvent.getCreateOrganCode());
					healthExamination.setHospitalName(ehrHealthEvent.getCreateOrganName());
					//等一下执行更新保持和其他表同步
				}
				
				if (ObjectUtil.isNullOrEmpty(record)) {
					String oCode = ehrHealthEvent.getCreateOrganCode();
					Organization organ = organizationApp.queryOrgan(oCode);
					record = insertPhysicalExamRecord(personInfo, oCode, organ.getGbCode(), healthExamination, ehrHealthEvent, examDate);
				} else {
					record.setExamYear(examDate);
					boolean isSameOrgan = ehrHealthEvent.getCreateOrganCode().equals(record.getInputSuperOrganCode());
					if (!isSameOrgan) {
						String oCode = ehrHealthEvent.getCreateOrganCode();
						record.setInputSuperOrganCode(oCode);
						Organization organ = organizationApp.queryOrgan(oCode);
						record.setGbcode(organ.getGbCode());
						log.error("机构不相同， 更新personId=" + personId + ",idcard="+personInfo.getIdcard()+",ehrId=" + ehrId + ",eventOrgan=" + ehrHealthEvent.getCreateOrganCode() + ",recordOrgan=" + record.getInputSuperOrganCode());
						countMap.add(notSameOrganSkipCount);
					}
				}

//				int examStatus = record.getExamStatus() == null ? 0 : record.getExamStatus();
//				int dataStatus = record.getExamDataStatus() == null ? 0 : record.getExamDataStatus();
//				if (examStatus == 1 && dataStatus == 1) {
//					log.info("已经处理过，跳过personId=" + personId + ",idcard="+personInfo.getIdcard() + ",ehrId=" + ehrId);
//					countMap.add(skipCount);
//					continue;
//				}
				
				//不跳过的情况下执行更新MS_HEALTH_EXAMINATION表
				if (!isHealthExamCreate) {
					healthExaminationDao.update(healthExamination, new String[] {"ehrId", "examinationDate", "age", "hospitalCode", "hospitalName"});
				}
				
				ElderlyPhyExamination elderlyPhyExamination = elderlyPhyExaminationDao.getElderlyPhyExamination(personId, examYear, EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
				boolean isCreate = ObjectUtil.isNullOrEmpty(elderlyPhyExamination);
				if (isCreate) {
					elderlyPhyExamination = ReflectionUtils.wrapBean(ElderlyPhyExamination.class, personInfo, healthExamination); // 人员、体检基本信息赋值
					elderlyPhyExamination.setEhrId(ehrId);
					elderlyPhyExamination.setPersonId(personId);
					elderlyPhyExamination.setAge(ehrHealthEvent.getAge());
					elderlyPhyExamination.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode()); // 体检类型
					elderlyPhyExamination.setExaminationDate(examDate); // 体检日期
					elderlyPhyExamination.setExaminationOrganCode(ehrHealthEvent.getCreateOrganCode());
				} else {
					elderlyPhyExamination.setEhrId(ehrId);
					elderlyPhyExamination.setAge(ehrHealthEvent.getAge());
					elderlyPhyExamination.setExaminationDate(examDate);
					elderlyPhyExamination.setExaminationOrganCode(ehrHealthEvent.getCreateOrganCode());
				}
				
				Criteria ca = new Criteria("EHR_ID", ehrId).add("PERSON_ID", personId);
//				if (examStatus == 0) {
//					List<ObservationInfo> observationInfos = observationInfoDao.getList(ca); // 生命体征，一般项检查
//					if (ObjectUtil.isNotEmpty(observationInfos)) {
//						analyzeVitalSigns(elderlyPhyExamination, observationInfos);
//					}
//					List<StudyEvent> studyEvents = studyEventDao.getList(ca); // 辅助检查
//					if (ObjectUtil.isNotEmpty(studyEvents)) {
//						analyzeAssistantExamination(elderlyPhyExamination, studyEvents);
//					}
//					if (ObjectUtil.isNotEmpty(observationInfos) || ObjectUtil.isNotEmpty(studyEvents)) {
//						record.setExamStatus(1);
//						countMap.add(examDataCount);
//						hasExam = true;
//					}
//				}
//				if (dataStatus == 0) {
//					List<ExamineDetail> examineDetails = examineDetailDao.getList(ca); // 检验
//					if (ObjectUtil.isNotEmpty(examineDetails)) {
//						analyzeLaboratoryExamination(elderlyPhyExamination, examineDetails);
//						record.setExamDataStatus(1);
//						hasExamDetails = true;
//						countMap.add(examineDetailsCount);
//					}
//				}
				if (isCreate) {
					elderlyPhyExaminationDao.insert(elderlyPhyExamination);
				} else {
					elderlyPhyExaminationDao.update(elderlyPhyExamination);
				}
				if (hasExam || hasExamDetails) {
					countMap.add(examCount);
				}
//				//【结论】有值，就把【评估】设置成【已评估】
//				if (StringUtil.isNotEmpty(healthExamination.getExaminationResult())) {
//					record.setEstimateStatus(1);
//				} else {
//					record.setEstimateStatus(0);
//				}
//				//【建议】有值，就把【指导】设置成【已指导】
//				if (StringUtil.isNotEmpty(healthExamination.getSuggestion())) {
//					record.setHealthGuideStatus(1);
//				} else {
//					record.setHealthGuideStatus(0);
//				}
				physicalExamRecordDao.update(record, new String[] {"examNumber", "examYear", "inputSuperOrganCode", "gbcode", "examStatus", "examDataStatus", "healthGuideStatus", "estimateStatus"});
			} catch (Exception e) {
				log.error("错误跳过ersonId=" + personId + ",ehrId=" + ehrId , e);
				countMap.add(errorSkipCount);
			}
		}
	}
	
	private int formatBPValue(ElderlyPhyExamination elderlyPhyExamination, String value) {
		int intVal = 0;
		try {
			if (value != null && value.contains(".")) {
				value = value.substring(0, value.indexOf("."));
			}
			intVal = Integer.valueOf(value);
			if (intVal > 999 || intVal < 0) {
				intVal = 0;
			}
		} catch (Exception e) {
			log.error("无效的整数值：" + value + ",ehrId="
					+ elderlyPhyExamination.getEhrId() + ",personId="
					+ elderlyPhyExamination.getPersonId());
		}
		return intVal;
	}

	/**
	 * 生命体征，一般项检查
	 * 
	 * @param elderlyPhyExamination
	 * @param observationInfos
	 */
	private void analyzeVitalSigns(ElderlyPhyExamination elderlyPhyExamination,
			List<ObservationInfo> observationInfos) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(observationInfos)) {
			return;
		}
		for (ObservationInfo observationInfo : observationInfos) {
			if (observationInfo == null) {
				continue;
			}
			String value = observationInfo.getObservationResult();
			if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010010")) { // 收缩压
				elderlyPhyExamination.setLeftSbp(formatBPValue(elderlyPhyExamination, value));
				if (StringUtils.contains(observationInfo.getConclusion(), "↑")) {
					elderlyPhyExamination.setHypertensionFlag("1"); // 血压异常标志
				}
				elderlyPhyExamination.setHypertensionDesc(observationInfo.getConclusion());
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010015")) { // 舒张压
				elderlyPhyExamination.setLeftDbp(formatBPValue(elderlyPhyExamination, value));
				if (StringUtils.contains(observationInfo.getConclusion(), "↑")) {
					elderlyPhyExamination.setHypertensionFlag("1"); // 血压异常标志
				}
				elderlyPhyExamination.setHypertensionDesc(observationInfo.getConclusion());
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010030")) { // 体温
				elderlyPhyExamination.setTemperature(dealNumberValue(value, "010030"));
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010011")) { // 体重
				elderlyPhyExamination.setBodyWeight(dealFloatValue(value, elderlyPhyExamination, 999));
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010012")) { // 身高
				elderlyPhyExamination.setHeight(dealFloatValue(value, elderlyPhyExamination, 999));
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010024")) { // 腰围
				elderlyPhyExamination.setWaostline(dealFloatValue(value, elderlyPhyExamination, 999));
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010033")) { // 脉率
				elderlyPhyExamination.setPulseRate(dealIntValue(value, elderlyPhyExamination, 999));
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010038")) { // 呼吸频率
				elderlyPhyExamination.setRespiratoryRate(dealIntValue(value, elderlyPhyExamination, 999));
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010039")) { // 肺(老年人)
				processLungsExamination(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010040")) { // 心脏(老年人)
				processHeartExamination(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "010041")) { // 腹部
				processAbdominalExamination(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "020029")) { // 皮肤
				processSkinExamination(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "020023")) { // 现症状
				processSymptom(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "020030")) { // 淋巴结
				processLymphNodeExamination(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "030017")) { // 口腔(老年人)
				processStomatologyExamination(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "030026")) { // 听力(老年人)
				processListeningExamination(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "030027")) { // 咽部(老年人)
				processPharyngealExamination(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "550001")
					|| StringUtils.equalsIgnoreCase(
							observationInfo.getObservationItemCode(), "750010")) { // 老年人生活自理能力
				processLifeAbilitySelf(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "750011")) { // 进餐：使用餐具将饭菜送入口、咀嚼、吞咽等活动
				processEatingAssessment(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "750012")) { // 梳洗：梳头、洗脸、刷牙、剃须洗澡等活动
				processCleaningAssessment(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "750013")) { // 穿衣：穿衣裤、袜子、鞋子等活动
				processClothingAssessment(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "750014")) { // 如厕：小便、大便等活动及自控
				processDefecationAssessment(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "750015")) { // 活动：站立、室内行走、上下楼梯、户外活动
				processExerciseAssessment(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "750016")) { // 症状
				processSymptomFlag(elderlyPhyExamination, value);
			} else if (StringUtils.equalsIgnoreCase(
					observationInfo.getObservationItemCode(), "555005")) { // 体质指数
				if (StringUtils.isNotBlank(value)) {
					elderlyPhyExamination
							.setIndexOfBodyCharacteristics(transExamResult(value));
				}
			} else if (StringUtils.equalsIgnoreCase(observationInfo.getObservationItemCode(), "555003")) { // 既往史
				if (StringUtils.isNotBlank(value)) {
					elderlyPhyExamination.setPastHistory(value);
				}
			}  else if (StringUtils.equalsIgnoreCase(observationInfo.getObservationItemCode(), "010028")) { // 家族史
				if (StringUtils.isNotBlank(value)) {
					elderlyPhyExamination.setFamilyHistory(value);
				}
			}   else if (StringUtils.equalsIgnoreCase(observationInfo.getObservationItemCode(), "550002")) { // 体育锻炼频率
				if (StringUtils.isNotBlank(value)) {
					elderlyPhyExamination.setPhysicalTrainingFreq(value);
				}
			}   else if (StringUtils.equalsIgnoreCase(observationInfo.getObservationItemCode(), "550003")) { // 饮食习惯
				if (StringUtils.isNotBlank(value)) {
					elderlyPhyExamination.setDietaryHabit(value);
				}
			}   else if (StringUtils.equalsIgnoreCase(observationInfo.getObservationItemCode(), "550004")) { // 吸烟情况
				if (StringUtils.isNotBlank(value)) {
					elderlyPhyExamination.setSmokeDesc(value);
				}
			}    else if (StringUtils.equalsIgnoreCase(observationInfo.getObservationItemCode(), "550005")) { // 饮酒情况
				if (StringUtils.isNotBlank(value)) {
					elderlyPhyExamination.setDrinkDesc(value);
				}
			}   else if (StringUtils.equalsIgnoreCase(observationInfo.getObservationItemCode(), "555001")) { // 目前用药情况
				if (StringUtils.isNotBlank(value)) {
					elderlyPhyExamination.setMedicineDesc(value);
				}
			}    else if (StringUtils.equalsIgnoreCase(observationInfo.getObservationItemCode(), "555002")) { // 运动功能
				if (StringUtils.isNotBlank(value)) {
					elderlyPhyExamination.setActiveFunction(value);
				}
			}   
			
		}
	}

	private BigDecimal dealNumberValue(String value, String itemCode) {
		BigDecimal defaultTemp = new BigDecimal("36.5");
		try {
			BigDecimal temp = new BigDecimal(value);
			if (temp.floatValue() > 99.0 || temp.floatValue() < 0.0) {
				temp = defaultTemp;
			}
			return temp;
		} catch (Exception e) {
			if (StringUtils.equalsIgnoreCase(itemCode, "010030")) {
				return defaultTemp;
			}
		}
		return null;
	}
	/*
	private BigDecimal dealFloatValue(String value, ElderlyPhyExamination elderlyPhyExamination) {
		try {
			BigDecimal temp = new BigDecimal(value);
			return temp;
		} catch (Exception e) {
			log.error("无效的数值：" + value + ",ehrId="
					+ elderlyPhyExamination.getEhrId() + ",personId="
					+ elderlyPhyExamination.getPersonId());
		}
		return null;
	}
	*/
	private BigDecimal dealFloatValue(String value, ElderlyPhyExamination elderlyPhyExamination, double maxVal) {
		try {
			BigDecimal temp = new BigDecimal(value);
			double val = temp.doubleValue();
			if (val > maxVal) {
				temp = null;
			}
			return temp;
		} catch (Exception e) {
			log.error("无效的数值：" + value + ",ehrId="
					+ elderlyPhyExamination.getEhrId() + ",personId="
					+ elderlyPhyExamination.getPersonId());
		}
		return null;
	}
	
	private Integer dealIntValue(String value, ElderlyPhyExamination elderlyPhyExamination, double maxVal) {
		BigDecimal temp = dealFloatValue(value, elderlyPhyExamination, maxVal);
		if (temp == null) {
			return null;
		}
		return temp.intValue();
	}

	/**
	 * 处理老年人体检肺部检查结果
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processLungsExamination(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)) {
			return;
		}
		elderlyPhyExamination.setLungsAnomalySound("9");
		elderlyPhyExamination.setLungsAnomalyDesc(examinationValue);
	}

	/**
	 * 心脏检查
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processHeartExamination(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}

		String ret = extractNumber(examinationValue);
		BigDecimal decimal = transExamResult(ret);
		int val = 0;
		if (decimal != null) {
			val = decimal.intValue();
			if (val > 999 || val < 0) {
				val = 0;
			}
		}
		elderlyPhyExamination.setHeartRate(val == 0 ? null : val); // 心率
		elderlyPhyExamination.setHeartMurmurFlag("9");
		elderlyPhyExamination.setHeartMurmurDesc(examinationValue);
	}

	/**
	 * 腹部检查
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processAbdominalExamination(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)) {
			return;
		}

		elderlyPhyExamination.setAbdominalTendernessFlag("9");
		elderlyPhyExamination.setAbdominalTendernessDesc(examinationValue);
	}

	/**
	 * 皮肤检查
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processSkinExamination(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)) {
			return;
		}
		if (validateExaminationResult(examinationValue)) {
			elderlyPhyExamination.setSkinCheckResult("1");
		}  else {
			elderlyPhyExamination.setSkinCheckResult("9");
			elderlyPhyExamination.setSkinCheckDesc(examinationValue);
		}
	}

	/**
	 * 现症状
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processSymptom(ElderlyPhyExamination elderlyPhyExamination,
			String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)) {
			return;
		}
		if (ObjectUtil.isNullOrEmpty(examinationValue)) {
			elderlyPhyExamination.setSymptomFlag("0");
		} else {
			if (StringUtils.contains(examinationValue, "无")) {
				elderlyPhyExamination.setSymptomFlag("0");
			} else {
				elderlyPhyExamination.setSymptomFlag("1");
				elderlyPhyExamination.setSymptomOtherDesc(examinationValue);
			}
		}
	}

	/**
	 * 淋巴结检查
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processLymphNodeExamination(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}
		elderlyPhyExamination.setLymphNodeCheckDesc(examinationValue);
	}

	/**
	 * 口腔检查
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processStomatologyExamination(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)) {
			return;
		}

		elderlyPhyExamination.setDentitionAnomalyFlag("9");
		elderlyPhyExamination.setDentitionDesc(examinationValue);
	}

	/**
	 * 视力检查
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processListeningExamination(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}

		if (StringUtils.contains(examinationValue, "听见")) {
			elderlyPhyExamination.setHearDetectResult("1");
		}
		if (StringUtils.contains(examinationValue, "听力下降")
				|| StringUtils.contains(examinationValue, "无法听见")) {
			elderlyPhyExamination.setHearDetectResult("2");
		}
	}

	/**
	 * 咽部检查
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processPharyngealExamination(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)) {
			return;
		}
		elderlyPhyExamination.setThroatCheckResult("9");
		elderlyPhyExamination.setThroatAnomalyDesc(examinationValue);
	}

	/**
	 * 老年人生活自理能力
	 * 
	 * @param elderlyPhyExamination
	 * @param examinationValue
	 */
	private void processLifeAbilitySelf(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}
		if (StringUtils.isBlank(examinationValue)) {
			elderlyPhyExamination.setLifeAbilitySelfAssessment("0");
		}
		if (StringUtils.contains(examinationValue, "可自理")) {
			elderlyPhyExamination.setLifeAbilitySelfAssessment("1");
		}
		if (StringUtils.contains(examinationValue, "轻度依赖")) {
			elderlyPhyExamination.setLifeAbilitySelfAssessment("2");
		}
		if (StringUtils.contains(examinationValue, "中度依赖")) {
			elderlyPhyExamination.setLifeAbilitySelfAssessment("3");
		}
		if (StringUtils.contains(examinationValue, "不能自理")) {
			elderlyPhyExamination.setLifeAbilitySelfAssessment("4");
		}
	}

	private void processEatingAssessment(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}

		if (StringUtils.contains(examinationValue, "独立完成")) {
			elderlyPhyExamination.setEatingAssessment(0);
		}
		if (StringUtils.contains(examinationValue, "需要协助")) {
			elderlyPhyExamination.setEatingAssessment(3);
		}
		if (StringUtils.contains(examinationValue, "完全需要帮助")) {
			elderlyPhyExamination.setEatingAssessment(5);
		}
	}

	private void processCleaningAssessment(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}

		if (StringUtils.contains(examinationValue, "独立完成")) {
			elderlyPhyExamination.setCleaningAssessment(0);
		}
		if (StringUtils.contains(examinationValue, "洗澡需协助")) {
			elderlyPhyExamination.setCleaningAssessment(1);
		}
		if (StringUtils.contains(examinationValue, "协助下能完成")) {
			elderlyPhyExamination.setCleaningAssessment(3);
		}
		if (StringUtils.contains(examinationValue, "完全需要帮助")) {
			elderlyPhyExamination.setCleaningAssessment(7);
		}
	}

	private void processClothingAssessment(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}

		if (StringUtils.contains(examinationValue, "独立完成")) {
			elderlyPhyExamination.setClothingAssessment(0);
		}
		if (StringUtils.contains(examinationValue, "需要协助")) {
			elderlyPhyExamination.setClothingAssessment(3);
		}
		if (StringUtils.contains(examinationValue, "完全需要帮助")) {
			elderlyPhyExamination.setClothingAssessment(5);
		}
	}

	private void processDefecationAssessment(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}

		if (StringUtils.contains(examinationValue, "不需协助")) {
			elderlyPhyExamination.setDefecationAssessment(0);
		}
		if (StringUtils.contains(examinationValue, "偶尔失禁")) {
			elderlyPhyExamination.setDefecationAssessment(1);
		}
		if (StringUtils.contains(examinationValue, "经常失禁")) {
			elderlyPhyExamination.setDefecationAssessment(5);
		}
		if (StringUtils.contains(examinationValue, "完全失禁")) {
			elderlyPhyExamination.setDefecationAssessment(10);
		}
	}

	private void processExerciseAssessment(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}

		if (StringUtils.contains(examinationValue, "独立完成")) {
			elderlyPhyExamination.setExerciseAssessment(0);
		}
		if (StringUtils.contains(examinationValue, "借助较小外力")) {
			elderlyPhyExamination.setExerciseAssessment(1);
		}
		if (StringUtils.contains(examinationValue, "借助较大外力")) {
			elderlyPhyExamination.setExerciseAssessment(5);
		}
		if (StringUtils.contains(examinationValue, "卧床不起")) {
			elderlyPhyExamination.setExerciseAssessment(10);
		}
	}

	private void processSymptomFlag(
			ElderlyPhyExamination elderlyPhyExamination, String examinationValue) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examinationValue)) {
			return;
		}
		String flag = "0";
		if (StringUtils.contains(examinationValue, "无症状")) {
			elderlyPhyExamination.setSymptomFlag(flag);
		}

		if (StringUtils.contains(examinationValue, "头痛")) {
			elderlyPhyExamination.setSymptomHeadache("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "头晕")) {
			elderlyPhyExamination.setSymptomDizzy("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "心悸")) {
			elderlyPhyExamination.setSymptomPalpitations("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "胸闷")) {
			elderlyPhyExamination.setSymptomChestTightness("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "胸痛")) {
			elderlyPhyExamination.setSymptomChestPain("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "慢性咳嗽")) {
			elderlyPhyExamination.setSymptomChronicCough("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "咳痰")) {
			elderlyPhyExamination.setSymptomCough("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "呼吸困难")) {
			elderlyPhyExamination.setSymptomDyspnea("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "多饮")) {
			elderlyPhyExamination.setSymptomPolydipsia("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "多尿")) {
			elderlyPhyExamination.setSymptomPolyuria("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "体重下降")) {
			elderlyPhyExamination.setSymptomWeightLoss("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "乏力")) {
			elderlyPhyExamination.setSymptomFatigue("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "关节肿痛")) {
			elderlyPhyExamination.setSymptomJointPain("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "视力模糊")) {
			elderlyPhyExamination.setSymptomBlurredVision("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "手脚麻木")) {
			elderlyPhyExamination.setSymptomNumbness("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "尿急")) {
			elderlyPhyExamination.setSymptomUrgency("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "尿痛")) {
			elderlyPhyExamination.setSymptomDysuria("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "便秘")) {
			elderlyPhyExamination.setSymptomConstipation("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "腹泻")) {
			elderlyPhyExamination.setSymptomDiarrhea("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "恶心呕吐")) {
			elderlyPhyExamination.setSymptomNauseaVomiting("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "眼花")) {
			elderlyPhyExamination.setSymptomVertigo("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "耳鸣")) {
			elderlyPhyExamination.setSymptomTinnitus("1");
			flag = "1";
		}
		if (StringUtils.contains(examinationValue, "乳房胀痛")) {
			elderlyPhyExamination.setSymptomBreastTenderness("1");
			flag = "1";
		}
		elderlyPhyExamination.setSymptomFlag(flag);
	}

	/**
	 * 处理辅助检查数据
	 * 
	 * @param elderlyPhyExamination
	 * @param studyEvents
	 */
	private void analyzeAssistantExamination(
			ElderlyPhyExamination elderlyPhyExamination,
			List<StudyEvent> studyEvents) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(studyEvents)) {
			return;
		}
		for (StudyEvent studyEvent : studyEvents) {
			if (ObjectUtil.isNullOrEmpty(studyEvent)) {
				continue;
			}
			
			String ret = studyEvent.getConclusionDesc();
			
			// 肝囊肿异常标志
			if (StringUtils.contains(ret, "肝囊肿")) {
				elderlyPhyExamination.setHepaticCystFlag("1");
			}
			
			// 脂肪肝标志
			if (StringUtils.contains(ret, "脂肪肝")) {
				elderlyPhyExamination.setFattyLiverFlag("1");
			}
			
			// 胆结石标志
			if (StringUtils.contains(ret, "结石")) {
				elderlyPhyExamination.setGallStoneFlag("1");
			}
			
			// 胆囊炎标志
			if (StringUtils.contains(ret, "胆囊炎")) {
				elderlyPhyExamination.setCholecystitisFlag("1");
			}
			
			// 肾结石标志
			if (StringUtils.contains(ret, "结石")) {
				elderlyPhyExamination.setKidneyStoneFlag("1");
			}
			
			// 肾囊肿标志
			if (StringUtils.contains(ret, "肾囊肿")) {
				elderlyPhyExamination.setRenalCystFlag("1");
			}
			
			// 可疑瘤标志
			if (StringUtils.contains(ret, "瘤")) {
				elderlyPhyExamination.setTumorFlag("1");
			}
			
			// 可疑肺结核标志
			if (StringUtils.contains(ret, "肺结核")) {
				elderlyPhyExamination.setTuberculosisFlag("1");
			}
			
			if (StringUtils.equals(studyEvent.getInspectionItemCode(), "050001")) { // B超(肝)
				if (StringUtils.isBlank(ret)) {
					elderlyPhyExamination.setBmodeAnomalyfFlag("0");
				} else if (StringUtils.contains(ret, "未检")) {
					elderlyPhyExamination.setBmodeAnomalyfFlag("2");
				} else {
					elderlyPhyExamination.setBmodeAnomalyfFlag("1");
				}
				
				elderlyPhyExamination.setBmodeAnomalyfDesc(ret);
			}
			if (StringUtils
					.equals(studyEvent.getInspectionItemCode(), "050002")) { // B超(胆)
				if (StringUtils.isBlank(ret)) {
					elderlyPhyExamination.setBmodeAnomalyfFlag("0");
				} else if (StringUtils.contains(ret, "未检")) {
					elderlyPhyExamination.setBmodeAnomalyfFlag("2");
				} else {
					elderlyPhyExamination.setBmodeAnomalyfFlag("1");
				}
				
				elderlyPhyExamination.setBmodeAnomalyfDesc(ret);
			}
			if (StringUtils
					.equals(studyEvent.getInspectionItemCode(), "050005")) { // B超(肾)
				if (StringUtils.isBlank(ret)) {
					elderlyPhyExamination.setBmodeAnomalyfFlag("0");
				} else if (StringUtils.contains(ret, "未检")) {
					elderlyPhyExamination.setBmodeAnomalyfFlag("2");
				} else {
					elderlyPhyExamination.setBmodeAnomalyfFlag("1");
				}
				
				elderlyPhyExamination.setBmodeAnomalyfDesc(ret);
			}
			if (StringUtils
					.equals(studyEvent.getInspectionItemCode(), "070002")) { // 心电图
				if (validateExaminationResult(ret)) {
					elderlyPhyExamination.setEcgAnomalyFlag("0");
				}  else if (StringUtils.contains(ret, "未检")) {
					elderlyPhyExamination.setEcgAnomalyFlag("2");
				} else {
					elderlyPhyExamination.setEcgAnomalyFlag("1");
				}
				elderlyPhyExamination.setEcgAnomalyDesc(ret);
			}
			if (StringUtils
					.equals(studyEvent.getInspectionItemCode(), "180001")) { // X光透视
				if (StringUtils.isBlank(studyEvent.getConclusionDesc())) {
					elderlyPhyExamination.setChestXAnomalyfFlag("0");
				}  else if (StringUtils.contains(ret, "未检")) {
					elderlyPhyExamination.setEcgAnomalyFlag("2");
				} else {
					elderlyPhyExamination.setChestXAnomalyfFlag("1");
				}
				elderlyPhyExamination.setChestXAnomalyfDesc(ret);
			}
		}
	}
	
	private boolean validateExaminationResult(String result) {
		return (StringUtils.isBlank(result) || (StringUtils.contains(result, "正常") && !StringUtils.contains(result, "不正常")));
	}

	/**
	 * 处理检验数据
	 * 
	 * @param elderlyPhyExamination
	 * @param examineDetails
	 */
	private void analyzeLaboratoryExamination(
			ElderlyPhyExamination elderlyPhyExamination,
			List<ExamineDetail> examineDetails) {
		if (ObjectUtil.isNullOrEmpty(elderlyPhyExamination)
				|| ObjectUtil.isNullOrEmpty(examineDetails)) {
			return;
		}
		for (ExamineDetail examineDetail : examineDetails) {
			String examResult = null;
			if (ObjectUtil.isNullOrEmpty(examineDetail)
					|| ObjectUtil.isNullOrEmpty(examResult = examineDetail
							.getInspectionResult())) {
				continue;
			}
			if (StringUtils.equals(examineDetail.getInspectionItemCode(),
					"120002")) { // 白细胞
				elderlyPhyExamination
						.setLeukocyteCount(transExamResult(examResult));
			} else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "120018")) { // 血小板
				if (!StringUtils.isNumeric(examResult)) {
					continue;
				}
				elderlyPhyExamination.setPlateletCount(Integer.valueOf(examResult));
			} else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "120041")) { // 血红蛋白
				if (!StringUtils.isNumeric(examResult)) {
					continue;
				}
				elderlyPhyExamination.setHemoglobinValue(Integer.valueOf(examResult));
			} else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "100018")) { // 丙氨酸氨基转移酶
				if (!StringUtils.equals(examineDetail.getPrompt(), "0")) {
					elderlyPhyExamination.setAbnormalLiverFlag("1"); // 肝功能异常标志
				}
				elderlyPhyExamination.setSerumGptValue(transExamResult(examResult));
			}  else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "150001")) { // 血清谷草转氨酶
				if (NumberUtil.isDecimal(examResult) || NumberUtil.isInteger(examResult)) {
					elderlyPhyExamination.setSerumAstValue(new BigDecimal(examResult));
				}
			}   else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "150002")) { // 血清谷丙转氨酶
				if (NumberUtil.isDecimal(examResult) || NumberUtil.isInteger(examResult)) {
					elderlyPhyExamination.setSerumGptValue(new BigDecimal(examResult));
				}
			}    else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "100026")) { // 总胆红素
				if (NumberUtil.isDecimal(examResult) || NumberUtil.isInteger(examResult)) {
					elderlyPhyExamination.setTotalBilirubin(new BigDecimal(examResult));
				}
			}   else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "100063")) { // 尿素氮
				if (NumberUtil.isDecimal(examResult) || NumberUtil.isInteger(examResult)) {
					elderlyPhyExamination.setBloodUreaNitrogenValue(new BigDecimal(examResult));
				}
			}    else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "100032")) { // 尿素（URIC）
				if (NumberUtil.isDecimal(examResult) || NumberUtil.isInteger(examResult)) {
					elderlyPhyExamination.setUrea(new BigDecimal(examResult));
				}
			}  else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "100030")) { // 肌酐
				if (!StringUtils.equals(examineDetail.getPrompt(), "0")) {
					elderlyPhyExamination.setRenalFunctionFlag("1"); // 肾功能异常标志
				}
				elderlyPhyExamination.setCreatinine(transExamResult(examResult));
			} else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "100035")) { // 总胆固醇
				if (!StringUtils.equals(examineDetail.getPrompt(), "0")) {
					elderlyPhyExamination.setDyslipidemiaFlag("1"); // 血脂异常标志
				}
				elderlyPhyExamination.setTc(transExamResult(examResult));
			} else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "100036")) { // 甘油三脂
				if (!StringUtils.equals(examineDetail.getPrompt(), "0")) {
					elderlyPhyExamination.setDyslipidemiaFlag("1"); // 血脂异常标志
				}
				elderlyPhyExamination.setTriglycerideValue(transExamResult(examResult));
			} else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "100077")) { // 空腹血糖
				elderlyPhyExamination.setFpgMmol(transExamResult(examResult));
				if (!StringUtils.equals(examineDetail.getPrompt(), "0")) {
					elderlyPhyExamination.setBloodGluAssessment("1"); // 血糖异常标志
				}
			} else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "570005")) { // 尿潜血
				elderlyPhyExamination.setEryQuantitativeValue(examResult);
				if (!StringUtils.equals(examineDetail.getPrompt(), "0")) {
					elderlyPhyExamination.setRenalFunctionFlag("1"); // 肾功能异常标志
				}
			} else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "570011")) { // 酮体
				elderlyPhyExamination.setKetQuantitativeValue(examResult);
			} else if (StringUtils.equals(examineDetail.getInspectionItemCode(), "570012")) { // 尿蛋白
				elderlyPhyExamination.setUrineProQuantitativeValue(examResult);
			}
			if (StringUtils.equals(examineDetail.getInspectionItemCode(), "570003")) { // 尿糖
				elderlyPhyExamination.setUrineSugQuantitativeValue(examResult);
			}
		}
	}

	/**
	 * 转换检验结果
	 * 
	 * @param result
	 * @return
	 */
	private BigDecimal transExamResult(String result) {
		if (StringUtils.isBlank(result)) {
			return null;
		}

		try {
			return new BigDecimal(result);
		} catch (Exception e) {
			log.error("无效的数值：" + result);
			return null;
		}
	}

	/**
	 * 匹配数字
	 * 
	 * @param value
	 * @return
	 */
	private static String extractNumber(String value) {
		if (StringUtils.isBlank(value)) {
			return null;
		}
		String regEx = "[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(value);
		String ret = m.replaceAll("").trim();
		return ret;
	}

	@Override
	public void processElderPhysicalExaminationData() throws Exception {
		//List<Map<String, String>> mapList = getIdCardMapList();
		List<Map<String, String>> mapList = getIdCardMapListOfSingleSheet();
		if (ObjectUtil.isNullOrEmpty(mapList)) {
			return;
		}
		int i = 0;
		for (Map<String, String> map : mapList) {
			String idCard = map.keySet().iterator().next();
			if (ObjectUtil.isNullOrEmpty(idCard)) {
				continue;
			}
			String num = map.get(idCard);
			PersonInfo personInfo = personInfoDao.get(new Criteria("IDCARD",
					idCard));
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				log.info("人员未在平台中注册：" + idCard);
				continue;
			}
			Criteria criteria = new Criteria("PERSON_ID", personInfo.getId());
			EHRHealthEvent ehrHealthEvent = ehrHealthEventDao.get(new Criteria(
					"PERSON_ID", personInfo.getId()).add("EHR_TYPE",
					"A00000003"));
			if (ObjectUtil.isNotEmpty(ehrHealthEvent)) {
				criteria.add("EHR_ID", ehrHealthEvent.getEhrId());
			}
			PhysiqueExamination physiqueExamination = physiqueExaminationDao.get(criteria);

			// 保存老年人体检人员信息记录
			savePhysicalExamRecord(personInfo, physiqueExamination, num);
			
			if (ObjectUtil.isNullOrEmpty(physiqueExamination)) {
				continue;
			}
			
			// 创建活动
			Long ehrId = saveHealthEvent(
					EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode(),
					EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getName(),
					personInfo, physiqueExamination.getExaminationDate());
			List<HealthEvaluateAnomaly> anomalies2 = new ArrayList<>();
			if (ObjectUtil.isNotEmpty(ehrHealthEvent.getEhrId())) {
				List<HealthEvaluateAnomaly> anomalies = healthEvaluateAnomalyDao
						.getList(new Criteria("EHR_ID", ehrHealthEvent
								.getEhrId()));
				for (HealthEvaluateAnomaly healthEvaluateAnomaly : anomalies) {
					HealthEvaluateAnomaly anomaly = new HealthEvaluateAnomaly();
					anomaly.setEhrId(String.valueOf(ehrId));
					anomaly.setHealthEvaluateAnomalyDesc(healthEvaluateAnomaly
							.getHealthEvaluateAnomalyDesc());
					anomalies2.add(anomaly);
				}
			}

			// 保存老牛人体检数据
			saveElderPhysicalExamination(personInfo, anomalies2, String.valueOf(ehrId), num, physiqueExamination);

			// 保存体检索引
			saveHealthExamination(physiqueExamination, personInfo, num, String.valueOf(ehrId), anomalies2);
			log.info(++i);

		}
	}
	
	private PhysicalExamRecord insertPhysicalExamRecord(PersonInfo personInfo, String inputSuperOrganCode, String gbCode, HealthExamination healthExamination, EHRHealthEvent ehrHealthEvent, Date examDate) {
		if (personInfo == null) {
			return null;
		}
		// 保存老年人体检人员信息
		PhysicalExamRecord physicalExamRecord = ReflectionUtils.wrapBean(
				PhysicalExamRecord.class, personInfo);
		physicalExamRecord.setInputOrganCode(null);
		physicalExamRecord.setInputSuperOrganCode(inputSuperOrganCode);
		physicalExamRecord.setGbcode(gbCode);
		physicalExamRecord.setExamYear(examDate);
		physicalExamRecord.setPersonId(personInfo.getId());
		physicalExamRecord.setPaymentPatternCode(getPaymentPatternCode(personInfo));
		physicalExamRecord.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION.getCode());
//		physicalExamRecord.setExamNumber(healthExamination.getPhysicalExamCode());
		physicalExamRecord.setConfirm(1); // 已经确认
//		physicalExamRecord.setExamDataStatus(0);
//		physicalExamRecord.setExamStatus(0);
		long id = physicalExamRecordDao.generatedKey(physicalExamRecord, "id", null).longValue();
		physicalExamRecord.setId(id);
		return physicalExamRecord;
	}

	private PhysicalExamRecord savePhysicalExamRecord(PersonInfo personInfo,
			PhysiqueExamination physiqueExamination, String physiqueCode) {
		if (personInfo == null) {
			return null;
		}
		// 保存老年人体检人员信息
		PhysicalExamRecord physicalExamRecord = ReflectionUtils.wrapBean(
				PhysicalExamRecord.class, personInfo);
		physicalExamRecord.setExamYear((physiqueExamination == null || physiqueExamination.getExaminationDate() == null) ? new Date() : physiqueExamination.getExaminationDate());
		physicalExamRecord.setPersonId(personInfo.getId());
		physicalExamRecord
				.setPaymentPatternCode(getPaymentPatternCode(personInfo));
		physicalExamRecord
				.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION
						.getCode());
//		physicalExamRecord.setExamNumber(physiqueCode);
		physicalExamRecord.setConfirm(1); // 已经确认
		physicalExamRecord.setInputSuperOrganCode("32000_");
		physicalExamRecord.setGbcode("320581100000");
//		if (ObjectUtil.isNotEmpty(physiqueExamination)) {
//			physicalExamRecord.setExamDataStatus(1);
//			physicalExamRecord.setExamStatus(1);
//		}
		// 查询当年体检人员名单
		List<Long> ids = new ArrayList<>();
		ids.add(personInfo.getId());
		List<Map<String, Object>> list = physicalExamRecordDao
				.getRecordInCurrentYear(ids, "ID");
		if (ObjectUtil.isNullOrEmpty(list)) {
			physicalExamRecordDao.insert(physicalExamRecord);
		} else {
			Object o = list.get(0).get("ID");
			if (ObjectUtil.isNotEmpty(o)) {
				physicalExamRecord.setId(Long.valueOf(String.valueOf(o)));
				physicalExamRecordDao.update(physicalExamRecord);
			}
		}
		return physicalExamRecord;
	}

	private void saveElderPhysicalExamination(PersonInfo personInfo,
			List<HealthEvaluateAnomaly> anomalies, String ehrId2,
			String physicalCode, PhysiqueExamination physiqueExamination) {
		if (personInfo == null || ObjectUtil.isNullOrEmpty(ehrId2)
				|| ObjectUtil.isNullOrEmpty(physiqueExamination)) {
			return;
		}

		List<HealthEvaluateAnomaly> anomalieList = healthEvaluateAnomalyDao
				.getList(new Criteria("EHR_ID", String.valueOf(ehrId2)));
		if (ObjectUtil.isNotEmpty(anomalieList)) {
			healthEvaluateAnomalyDao.delete(new Criteria("EHR_ID", String
					.valueOf(ehrId2)));
		}
		if (ObjectUtil.isNotEmpty(anomalies)) {
			healthEvaluateAnomalyDao.batchInsert(anomalies);
		}

		ElderlyPhyExamination epe = elderlyPhyExaminationDao.get(new Criteria(
				"PERSON_ID", personInfo.getId()));
		ElderlyPhyExamination elderlyPhyExamination = ReflectionUtils.wrapBean(
				ElderlyPhyExamination.class, physiqueExamination);
		elderlyPhyExamination
				.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION
						.getCode()); // 体检类型
		elderlyPhyExamination.setEhrId(ehrId2);
		elderlyPhyExamination.setPersonId(personInfo.getId());
		elderlyPhyExamination.setPhysicalExamCode(physicalCode);
		elderlyPhyExamination.setHealthEvaluateAnomalyFlag(ObjectUtil
				.isNullOrEmpty(anomalies) ? "0" : "1");
		elderlyPhyExamination.setId(null);
		if (ObjectUtil.isNullOrEmpty(epe)) {
			// 保存到老年人体检表
			elderlyPhyExamination.setId(null);
			elderlyPhyExaminationDao.insert(elderlyPhyExamination);
		} else {
			elderlyPhyExamination.setId(epe.getId());
			elderlyPhyExaminationDao.update(elderlyPhyExamination);
		}
	}

	private void saveHealthExamination(PhysiqueExamination physiqueExamination,
			PersonInfo personInfo, String physicalCode, String ehrId,
			List<HealthEvaluateAnomaly> healthEvaluateAnomalies) {
		if (physiqueExamination == null || personInfo == null
				|| ObjectUtil.isNullOrEmpty(ehrId)) {
			return;
		}
		HealthExamination healthExamination = ReflectionUtils.wrapBean(
				HealthExamination.class, new Object[] { physiqueExamination });
		healthExamination.setPersonId(personInfo.getId());
		healthExamination.setPhysicalExamCode(physicalCode);
		healthExamination
				.setPhysicalExamType(EventType.OLD_PEOPLE_PHYSICAL_EXAMINATION
						.getCode());
		healthExamination.setHospitalCode("32000_");
		healthExamination.setHospitalName("虞山镇社区卫生服务中心");
		healthExamination.setEhrId(ehrId);
		// 设置体检评价
		setHealthExaminationDesc(healthExamination, physiqueExamination,
				healthEvaluateAnomalies);
		HealthExamination he = healthExaminationDao.get(new Criteria(
				"PERSON_ID", personInfo.getId()).add("EHR_ID", ehrId));
		if (ObjectUtil.isNullOrEmpty(he)) {
			healthExamination.setId(null);
			healthExaminationDao.insert(healthExamination);
		} else {
			healthExamination.setId(he.getId());
			healthExaminationDao.update(healthExamination);
		}
	}

	private static List<String> getIdCardList() throws Exception {
		ExcelUtils excelUtils1 = new ExcelUtils("E://老年人体检1.xls");
		List<String> idCardList = new ArrayList<>();
		for (int i = 1; i < 445; i++) {
			Object o = excelUtils1.read(i, 3);
			filterIdCard(String.valueOf(o), idCardList);
		}

		ExcelUtils excelUtils2 = new ExcelUtils("E://老年人体检2.xls");
		for (int i = 1; i < 653; i++) {
			Object o = excelUtils2.read(i, 3);
			filterIdCard(String.valueOf(o), idCardList);
		}

		ExcelUtils excelUtils3 = new ExcelUtils("E://老年人体检3.xls");
		for (int i = 1; i < 50; i++) {
			Object o = excelUtils3.read(i, 3);
			filterIdCard(String.valueOf(o), idCardList);
		}

		ExcelUtils excelUtils4 = new ExcelUtils("E://老年人体检4.xls");
		for (int i = 1; i < 896; i++) {
			Object o = excelUtils4.read(i, 4);
			filterIdCard(String.valueOf(o), idCardList);
		}
		return idCardList;
	}

	private static List<Map<String, String>> getIdCardMapListOfSingleSheet()
			throws Exception {
		ExcelUtils excelUtils1 = new ExcelUtils("E://补录入人员编码.xls");
		List<Map<String, String>> idCardMapList = new ArrayList<>();
		for (int i = 1; i < 22; i++) {
			Object o1 = excelUtils1.read(i, 3);
			String idcard = String.valueOf(o1);
			Object o2 = excelUtils1.read(i, 0);
			Map<String, String> map = new HashMap<>();
			map.put(idcard.replaceAll("'", ""), String.valueOf(o2));
			idCardMapList.add(map);
		}
		return idCardMapList;
	}

	private static List<Map<String, String>> getIdCardMapList()
			throws Exception {
		ExcelUtils excelUtils1 = new ExcelUtils("E://老年人体检1.xls");
		List<Map<String, String>> idCardMapList = new ArrayList<>();
		for (int i = 1; i < 445; i++) {
			Object o1 = excelUtils1.read(i, 3);
			String idcard = String.valueOf(o1);
			Object o2 = excelUtils1.read(i, 1);
			Map<String, String> map = new HashMap<>();
			map.put(idcard.replaceAll("'", ""), String.valueOf(o2));
			idCardMapList.add(map);
		}

		ExcelUtils excelUtils2 = new ExcelUtils("E://老年人体检2.xls");
		for (int i = 1; i < 653; i++) {
			Object o1 = excelUtils2.read(i, 3);
			String idcard = String.valueOf(o1);
			Object o2 = excelUtils2.read(i, 1);
			Map<String, String> map = new HashMap<>();
			map.put(idcard.replaceAll("'", ""), String.valueOf(o2));
			idCardMapList.add(map);
		}

		ExcelUtils excelUtils3 = new ExcelUtils("E://老年人体检3.xls");
		for (int i = 1; i < 50; i++) {
			Object o1 = excelUtils3.read(i, 3);
			String idcard = String.valueOf(o1);
			Object o2 = excelUtils3.read(i, 1);
			Map<String, String> map = new HashMap<>();
			map.put(idcard.replaceAll("'", ""), String.valueOf(o2));
			idCardMapList.add(map);
		}

		ExcelUtils excelUtils4 = new ExcelUtils("E://老年人体检4.xls");
		for (int i = 1; i < 896; i++) {
			Object o1 = excelUtils4.read(i, 4);
			String idcard = String.valueOf(o1);
			Object o2 = excelUtils4.read(i, 1);
			Map<String, String> map = new HashMap<>();
			map.put(idcard.replaceAll("'", ""), String.valueOf(o2));
			idCardMapList.add(map);
		}
		return idCardMapList;
	}

	private Long saveHealthEvent(String ehrType, String ehrName,
			PersonInfo personInfo, Date eventDate) {
		if (ObjectUtil.isNullOrEmpty(ehrType)
				|| ObjectUtil.isNullOrEmpty(ehrName)
				|| ObjectUtil.isNullOrEmpty(personInfo)) {
			return null;
		}
		EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
		ehrHealthEvent.setEhrType(ehrType);
		ehrHealthEvent.setEhrName(ehrName);
		ehrHealthEvent.setPersonId(personInfo.getId());
		ehrHealthEvent.setName(personInfo.getName());
		ehrHealthEvent.setMarriage(personInfo.getMarriage());
		ehrHealthEvent.setAge(DateUtil.getAgeByBirthday(personInfo
				.getBirthday()) + "岁"); // 就诊者年龄
		ehrHealthEvent.setCreateDate(new Date());
		ehrHealthEvent.setClinicOrganCode("32000_"); // 诊疗机构代码
		ehrHealthEvent.setClinicOrganName("虞山镇社区卫生服务中心"); // 诊疗机构名称
		ehrHealthEvent.setCreateOrganCode("32000_"); // 创建机构代码
		ehrHealthEvent.setCreateOrganName("虞山镇社区卫生服务中心"); // 创建机构名称
		ehrHealthEvent.setClinicDate(eventDate);
		// 重复检查条件
		Long oid = ehrHealthEventDao.getHealthEventId(personInfo.getId());
		try {
			if (ObjectUtil.isNullOrEmpty(oid)) {
				Long id = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID",
						null).longValue();
				ehrHealthEventDao.update(new Parameters("EHR_ID", id),
						new Criteria("ID", id));
				oid = id;
			} else {
				ehrHealthEvent.setId(oid);
				ehrHealthEvent.setEhrId(String.valueOf(oid));
				ehrHealthEventDao.update(ehrHealthEvent);
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			e.printStackTrace();
			return null;
		}
		return oid;
	}

	private static void filterIdCard(String idCard, List<String> idCardList) {
		if (ObjectUtil.isNullOrEmpty(idCard)) {
			return;
		}
		idCardList.add(idCard.replaceAll("'", ""));
	}

	private static String getPaymentPatternCode(PersonInfo personInfo) {
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			return null;
		}
		String paymentPatternCode = null;
		if (ObjectUtil.isNotEmpty(personInfo.getPaymentUrbanWorkders())) {
			paymentPatternCode = "01";
		} else if (ObjectUtil.isNotEmpty(personInfo.getPaymentUrbanResident())) {
			paymentPatternCode = "05";
		} else if (ObjectUtil.isNotEmpty(personInfo
				.getPaymentNewRuralCooperation())) {
			paymentPatternCode = "04";
		} else if (ObjectUtil.isNotEmpty(personInfo.getPaymentPovertyRelief())) {
			paymentPatternCode = "99";
		} else if (ObjectUtil.isNotEmpty(personInfo.getPaymentCommercial())) {
			paymentPatternCode = "02";
		} else if (ObjectUtil.isNotEmpty(personInfo.getPaymentBursary())) {
			paymentPatternCode = "06";
		} else if (ObjectUtil.isNotEmpty(personInfo
				.getPaymentPersonalExpenses())) {
			paymentPatternCode = "99";
		} else if (ObjectUtil.isNotEmpty(personInfo.getPaymentOther())) {
			paymentPatternCode = "99";
		}
		return paymentPatternCode;
	}

	@Override
	public void processExaminationDesc() {
		List<PhysicalExamRecord> physicalExamRecords = physicalExamRecordDao
				.getList(new Criteria("INPUT_SUPER_ORGAN_CODE", "32000_").add(
						"EXAM_STATUS", 1));
		if (ObjectUtil.isNullOrEmpty(physicalExamRecords)) {
			return;
		}
		for (PhysicalExamRecord physicalExamRecord : physicalExamRecords) {
			if (ObjectUtil.isNullOrEmpty(physicalExamRecord)
					|| ObjectUtil.isNullOrEmpty(physicalExamRecord
							.getPersonId())) {
				continue;
			}
			Criteria criteria = new Criteria("PERSON_ID",
					physicalExamRecord.getPersonId());
			PhysiqueExamination physiqueExamination = physiqueExaminationDao
					.get(new Criteria("PERSON_ID", physicalExamRecord
							.getPersonId()));
			List<HealthEvaluateAnomaly> healthEvaluateAnomalies = healthEvaluateAnomalyDao
					.getList(new Criteria("EHR_ID", physiqueExamination
							.getEhrId()));
			HealthExamination healthExamination = healthExaminationDao
					.get(criteria);
			updateHealthExamination(healthExamination, physiqueExamination,
					healthEvaluateAnomalies);
		}
	}

	private void updateHealthExamination(HealthExamination healthExamination,
			PhysiqueExamination physiqueExamination,
			List<HealthEvaluateAnomaly> healthEvaluateAnomalies) {
		if (ObjectUtil.isNullOrEmpty(healthExamination)) {
			return;
		}
		StringBuilder descBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(healthEvaluateAnomalies)) {
			for (HealthEvaluateAnomaly healthEvaluateAnomaly : healthEvaluateAnomalies) {
				descBuilder.append(healthEvaluateAnomaly
						.getHealthEvaluateAnomalyDesc());
				descBuilder.append("\r\n");
			}
			healthExamination.setExaminationResult(descBuilder.toString());
		}

		StringBuilder suggestBuilder = new StringBuilder();
		if (StringUtils.equals("1",
				physiqueExamination.getGuideRegularFollowup())) {
			suggestBuilder.append("定期随访");
			suggestBuilder.append("\r\n");
		}
		if (StringUtils.equals("1",
				physiqueExamination.getGuideIntoChronicDisease())) {
			suggestBuilder.append("纳入慢性病患者健康管理");
			suggestBuilder.append("\r\n");
		}
		if (StringUtils.equals("1",
				physiqueExamination.getGuideSuggestionReview())) {
			suggestBuilder.append("建议复查");
			suggestBuilder.append("\r\n");
		}
		if (StringUtils.equals("1",
				physiqueExamination.getGuideSuggestionReferral())) {
			suggestBuilder.append("建议转诊");
		}
		healthExamination.setSuggestion(suggestBuilder.toString());
		healthExaminationDao.update(healthExamination, new String[] {
				"examinationResult", "suggestion" });
	}

	private void setHealthExaminationDesc(HealthExamination healthExamination,
			PhysiqueExamination physiqueExamination,
			List<HealthEvaluateAnomaly> healthEvaluateAnomalies) {
		if (ObjectUtil.isNullOrEmpty(healthExamination)) {
			return;
		}
		StringBuilder descBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(healthEvaluateAnomalies)) {
			for (HealthEvaluateAnomaly healthEvaluateAnomaly : healthEvaluateAnomalies) {
				descBuilder.append(healthEvaluateAnomaly
						.getHealthEvaluateAnomalyDesc());
				descBuilder.append("\r\n");
			}
			healthExamination.setExaminationResult(descBuilder.toString());
		}

		StringBuilder suggestBuilder = new StringBuilder();
		if (StringUtils.equals("1",
				physiqueExamination.getGuideRegularFollowup())) {
			suggestBuilder.append("定期随访");
			suggestBuilder.append("\r\n");
		}
		if (StringUtils.equals("1",
				physiqueExamination.getGuideIntoChronicDisease())) {
			suggestBuilder.append("纳入慢性病患者健康管理");
			suggestBuilder.append("\r\n");
		}
		if (StringUtils.equals("1",
				physiqueExamination.getGuideSuggestionReview())) {
			suggestBuilder.append("建议复查");
			suggestBuilder.append("\r\n");
		}
		if (StringUtils.equals("1",
				physiqueExamination.getGuideSuggestionReferral())) {
			suggestBuilder.append("建议转诊");
		}
		healthExamination.setSuggestion(suggestBuilder.toString());
	}

	@Override
	public void processHealthExaminationType() {
		List<EHRHealthEvent> ehrHealthEvents = ehrHealthEventDao
				.getList(new Criteria("EHR_TYPE", "35"));
		if (ObjectUtil.isNullOrEmpty(ehrHealthEvents)) {
			return;
		}
		int i = 0;
		for (EHRHealthEvent ehrHealthEvent : ehrHealthEvents) {
			System.out.println(++i);
			if (ObjectUtil.isNullOrEmpty(ehrHealthEvent)) {
				continue;
			}
			HealthExamination healthExamination = healthExaminationDao
					.get(new Criteria("EHR_ID", ehrHealthEvent.getEhrId()));
			if (ObjectUtil.isNullOrEmpty(healthExamination)) {
				continue;
			}
			healthExamination
					.setPhysicalExamType(EventType.OCCUPATION_PHYSICAL_EXAMINATION
							.getCode());
			healthExaminationDao.update(healthExamination, "physicalExamType");
		}
	}

	@Override
	public void run(Map<String, Object> data) {
		analyzeExaminationItems(null, null);
	}
}
