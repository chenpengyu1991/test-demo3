package com.founder.rhip.ehr.service.statistics.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.NumberUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.IDataSource;
import com.founder.rhip.ehr.common.PageableDateSource;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.cic.CicTarget;
import com.founder.rhip.ehr.entity.clinic.DiseaseDiagnosisInfo;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.ExamineDetail;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.ObservationInfo;
import com.founder.rhip.ehr.entity.clinic.SurgeryInfo;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.ta.TargetResultValue;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.cic.ICicTargetDao;
import com.founder.rhip.ehr.repository.clinic.IDiseaseDiagnosisInfoDao;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;
import com.founder.rhip.ehr.repository.clinic.IObservationInfoDao;
import com.founder.rhip.ehr.repository.clinic.ISurgeryInfoDao;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.ta.ITargetResultValueDao;
import com.founder.rhip.ehr.service.statistics.ITargetResultAnalyseService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("targetResultAnalyseService")
@TaskBean(cron = "0 0 4 * * ?", description = "指标统计定时任务")
public class TargetResultAnalyseServiceImpl implements ITargetResultAnalyseService, Task  {
	
	private static final Logger log = Logger.getLogger(TargetResultAnalyseServiceImpl.class);
	
	public static final String SBP_CODE = "010010"; // 收缩压编码
	
	public static final String DBP_CODE = "010015"; // 舒张压编码
	
	public static final String FBG_CODE = "100077"; // 空腹血糖编码
	
	public static final String ANALYSIS_STATUS = "analysisStatus"; // 指标分析处理状态
	
	public static final String PERSON_ID = "personId";
	
	public static final String EHR_ID = "ehrId";
	
	public static final String OBSERVATION_ITEM_CODE = "observationItemCode";
	
	public static final String INSPECTION_ITEM_CODE = "inspectionItemCode";
	
	private static final String ID = "id";
	
	private static final String STATUS_FLAG = "0";
	
	private Map<Long, PersonInfo> personMap = new HashMap<>();
	
	private Map<String, EHRHealthEvent> eventMap = new HashMap<>();

	@Resource(name = "observationInfoDao")
	private IObservationInfoDao observationInfoDao;
	
	@Resource(name = "examineEventDao")
	private IExamineEventDao examineEventDao;
	
	@Resource(name = "examineDetailDao")
	private IExamineDetailDao examineDetailDao;
	
	@Resource(name = "targetResultValueDao")
	private ITargetResultValueDao targetResultValueDao;
	
	@Resource(name = "cicTargetDao")
	private ICicTargetDao cicTargetDao;
	
	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;
	
	@Resource(name = "ehrHealthEventDao")
	private IEHRHealthEventDao ehrHealthEventDao;
	
	@Resource(name = "diseaseDiagnosisInfoDao")
	private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;
	
	@Resource(name = "surgeryInfoDao")
	private ISurgeryInfoDao surgeryInfoDao;
	
	@Resource(name = "vaccinationInfoDao")
	private IVaccinationInfoDao vaccinationInfoDao;
	
	
	@Override
	public void analyseResultValue() {
		// 收缩压指标分析
		List<ObservationInfo> sbpInfos = observationInfoDao.getList(new Criteria(ANALYSIS_STATUS, STATUS_FLAG).add(OBSERVATION_ITEM_CODE, SBP_CODE));
		analyseSpbInfos(sbpInfos);

		// 舒张压指标分析
		List<ObservationInfo> dbpInfos = observationInfoDao.getList(new Criteria(ANALYSIS_STATUS, STATUS_FLAG).add(OBSERVATION_ITEM_CODE, DBP_CODE));
		analyseDpbInfos(dbpInfos);

		// 空腹血糖指标分析
		List<ExamineDetail> fbgs = examineDetailDao.getList(new Criteria(ANALYSIS_STATUS, STATUS_FLAG).add(INSPECTION_ITEM_CODE, FBG_CODE));
		analyseFbgs(fbgs);

		// 餐后血糖指标分析
		List<ExamineDetail> pbgs = examineDetailDao.getList(new Criteria(ANALYSIS_STATUS, STATUS_FLAG).add("inspectionItemName", OP.LIKE, "餐后"));
		analysePbgs(pbgs);
		
		// 癫痫指标分析
		List<DiseaseDiagnosisInfo> epilepsys = diseaseDiagnosisInfoDao.getList(new Criteria("diagnosisDesc", OP.LIKE, "癫痫").add(ANALYSIS_STATUS, STATUS_FLAG));
		analyseEpilepsy(epilepsys);
		
		// 哮喘指标分析
		List<DiseaseDiagnosisInfo> asthmas = diseaseDiagnosisInfoDao.getList(new Criteria("diagnosisDesc", OP.LIKE, "哮喘").add(ANALYSIS_STATUS, STATUS_FLAG));
		analyseAsthma(asthmas);
		
		// 心脏起搏器
		List<SurgeryInfo> cardiacpacemakers = surgeryInfoDao.getList(new Criteria("opertationName", OP.LIKE, "起搏器").add(ANALYSIS_STATUS, STATUS_FLAG));
		analyseCardiacPacemakers(cardiacpacemakers);
		
		// 心脏疾病分析
		List<DiseaseDiagnosisInfo> heartDiseases = diseaseDiagnosisInfoDao.getList(new Criteria("diagnosisDesc", OP.LIKE, "心脏病").add(ANALYSIS_STATUS, STATUS_FLAG));
		analyseHeartDisease(heartDiseases);
		
		// 心脑血管指标分析
		List<DiseaseDiagnosisInfo> cerebrovascularDiseases = diseaseDiagnosisInfoDao.getList(new Criteria("diagnosisDesc", OP.LIKE, "脑血管").add(ANALYSIS_STATUS, STATUS_FLAG));
		analyseCerebrovascular(cerebrovascularDiseases);
		
		// 青光眼分析
		List<DiseaseDiagnosisInfo> glaucomaDiseases = diseaseDiagnosisInfoDao.getList(new Criteria("diagnosisDesc", OP.LIKE, "青光").add(ANALYSIS_STATUS, STATUS_FLAG));
		analyseGlaucomaDiseases(glaucomaDiseases);
		
		// 精神病分析
		List<DiseaseDiagnosisInfo> mentalDisorderDiseases = diseaseDiagnosisInfoDao.getList(new Criteria("diagnosisDesc", OP.LIKE, "精神").add(ANALYSIS_STATUS, STATUS_FLAG));
		analyseMentalDisorderDisease(mentalDisorderDiseases);
		
		// 糖尿病分析
		List<DiseaseDiagnosisInfo> diabetesMellitusDiseases = diseaseDiagnosisInfoDao.getList(new Criteria("diagnosisDesc", OP.LIKE, "糖尿病").add(ANALYSIS_STATUS, STATUS_FLAG));
		analyseDiabetesMellitusDisease(diabetesMellitusDiseases);
		
		// 计免统计分析
		pageableAnalyseVaccinationInfo(new Criteria(ANALYSIS_STATUS, STATUS_FLAG));
	}
	
	/**
	 * 分析空腹血糖指标
	 * @param fbgs
	 */
	private void analyseFbgs(List<ExamineDetail> fbgs) {
		if (ObjectUtil.isNullOrEmpty(fbgs)) {
			return;
		}
		for (ExamineDetail examineDetail : fbgs) {
			if (ObjectUtil.isNullOrEmpty(examineDetail) || (!NumberUtil.isInteger(examineDetail.getInspectionResult()) && !NumberUtil.isDecimal(examineDetail.getInspectionResult()))) {
				continue;
			}
			TargetResultValue trv = targetResultValueDao.get(new Criteria(PERSON_ID, examineDetail.getPersonId()).add(EHR_ID, examineDetail.getEhrId()));
			try {
				if (ObjectUtil.isNullOrEmpty(trv)) {
					Date createDate = ObjectUtil.isNullOrEmpty(examineDetail.getCheckDate()) ? queryClinicDate(examineDetail.getEhrId()) : examineDetail.getCheckDate();
					if (ObjectUtil.isNullOrEmpty(createDate)) {
						continue;
					}
					ExamineEvent examineEvent = examineEventDao.get(new Criteria(EHR_ID, examineDetail.getEhrId()));
					TargetResultValue resultValue = new TargetResultValue();
					resultValue.setPersonId(examineDetail.getPersonId());
					resultValue.setEhrId(examineDetail.getEhrId());
					resultValue.setCreateDate(createDate);
					resultValue.setCreateOrganCode(ObjectUtil.isNullOrEmpty(examineEvent) ? null : examineEvent.getCheckOrgCode());
					resultValue.setUpdateOrganCode(ObjectUtil.isNullOrEmpty(examineEvent) ? null : examineEvent.getCheckOrgCode());
					resultValue.setCreateUserCode(ObjectUtil.isNullOrEmpty(examineEvent) ? null : examineEvent.getCheckPeopleCode());
					resultValue.setValueC(convertResult(examineDetail.getInspectionResult()));
					if (StringUtils.equals(examineDetail.getPrompt(), "↑") ) {
						resultValue.setResultC("偏高");
					} else if (StringUtils.equals(examineDetail.getPrompt(), STATUS_FLAG) ) {
						resultValue.setResultC("正常");
					} else if (StringUtils.equals(examineDetail.getPrompt(), " ↓")) {
						resultValue.setResultC("偏低");
					}
				    resultValue.setIsDelete(EHRConstants.DELETE_FLG_0);
				    targetResultValueDao.insert(resultValue);
				} else {
					trv.setValueC(convertResult(examineDetail.getInspectionResult()));
					if (StringUtils.equals(examineDetail.getPrompt(), "↑") ) {
						trv.setResultC("偏高");
					} else if (StringUtils.equals(examineDetail.getPrompt(), STATUS_FLAG) ) {
						trv.setResultC("正常");
					} else if (StringUtils.equals(examineDetail.getPrompt(), " ↓")) {
						trv.setResultC("偏低");
					}
					targetResultValueDao.update(trv);
				}
				
				// 指标分析过后修改标志位
				examineDetailDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, examineDetail.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 分析餐后血糖指标
	 * @param pbgs
	 */
	private void analysePbgs(List<ExamineDetail> pbgs) {
		if (ObjectUtil.isNullOrEmpty(pbgs)) {
			return;
		}
		for (ExamineDetail examineDetail : pbgs) {
			if (ObjectUtil.isNullOrEmpty(examineDetail) || (!NumberUtil.isInteger(examineDetail.getInspectionResult()) && !NumberUtil.isDecimal(examineDetail.getInspectionResult()))) {
				continue;
			}
			TargetResultValue trv = targetResultValueDao.get(new Criteria(PERSON_ID, examineDetail.getPersonId()).add(EHR_ID, examineDetail.getEhrId()));
			try {
				if (ObjectUtil.isNullOrEmpty(trv)) {
					Date createDate = ObjectUtil.isNullOrEmpty(examineDetail.getCheckDate()) ? queryClinicDate(examineDetail.getEhrId()) : examineDetail.getCheckDate();
					if (ObjectUtil.isNullOrEmpty(createDate)) {
						continue;
					}
					ExamineEvent examineEvent = examineEventDao.get(new Criteria(EHR_ID, examineDetail.getEhrId()));
					TargetResultValue resultValue = new TargetResultValue();
					resultValue.setPersonId(examineDetail.getPersonId());
					resultValue.setEhrId(examineDetail.getEhrId());
					resultValue.setCreateDate(createDate);
					resultValue.setCreateOrganCode(ObjectUtil.isNullOrEmpty(examineEvent) ? null : examineEvent.getCheckOrgCode());
					resultValue.setUpdateOrganCode(ObjectUtil.isNullOrEmpty(examineEvent) ? null : examineEvent.getCheckOrgCode());
					resultValue.setCreateUserCode(ObjectUtil.isNullOrEmpty(examineEvent) ? null : examineEvent.getCheckPeopleCode());
					resultValue.setValueD(convertResult(examineDetail.getInspectionResult()));
					if (StringUtils.equals(examineDetail.getPrompt(), "↑") ) {
						resultValue.setResultD("偏高");
					} else if (StringUtils.equals(examineDetail.getPrompt(), STATUS_FLAG) ) {
						resultValue.setResultD("正常");
					} else if (StringUtils.equals(examineDetail.getPrompt(), " ↓")) {
						resultValue.setResultD("偏低");
					}
				    resultValue.setIsDelete(EHRConstants.DELETE_FLG_0);
				    targetResultValueDao.insert(resultValue);
				} else {
					trv.setValueD(convertResult(examineDetail.getInspectionResult()));
					if (StringUtils.equals(examineDetail.getPrompt(), "↑") ) {
						trv.setResultD("偏高");
					} else if (StringUtils.equals(examineDetail.getPrompt(), STATUS_FLAG) ) {
						trv.setResultD("正常");
					} else if (StringUtils.equals(examineDetail.getPrompt(), " ↓")) {
						trv.setResultD("偏低");
					}
					targetResultValueDao.update(trv);
				}
				
				// 指标分析过后修改标志位
				examineDetailDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, examineDetail.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 分析收缩压指标
	 * @param sbpInfos
	 */
	private void analyseSpbInfos(List<ObservationInfo> sbpInfos) {
		if (ObjectUtil.isNullOrEmpty(sbpInfos)) {
			return;
		}
		for (ObservationInfo observationInfo : sbpInfos) {
			if (ObjectUtil.isNullOrEmpty(observationInfo) || (!NumberUtil.isInteger(observationInfo.getObservationResult()) && !NumberUtil.isDecimal(observationInfo.getObservationResult()))) {
				continue;
			}
			TargetResultValue trv = targetResultValueDao.get(new Criteria(PERSON_ID, observationInfo.getPersonId()).add(EHR_ID, observationInfo.getEhrId()));
			try {
				if (ObjectUtil.isNullOrEmpty(trv)) {
					Date createDate = ObjectUtil.isNullOrEmpty(observationInfo.getCheckDate()) ? queryClinicDate(observationInfo.getEhrId()) : observationInfo.getCheckDate();
					if (ObjectUtil.isNullOrEmpty(createDate)) {
						continue;
					}
					TargetResultValue resultValue = new TargetResultValue();
					resultValue.setPersonId(observationInfo.getPersonId());
					resultValue.setEhrId(observationInfo.getEhrId());
					resultValue.setCreateDate(createDate);
					resultValue.setCreateOrganCode(observationInfo.getCheckOrgCode());
					resultValue.setUpdateOrganCode(observationInfo.getCheckOrgCode());
					resultValue.setValueA(convertResult(observationInfo.getObservationResult()));
					resultValue.setResultA(observationInfo.getConclusion());
					resultValue.setCreateUserCode(observationInfo.getCheckPeopleCode());
				    resultValue.setIsDelete(EHRConstants.DELETE_FLG_0);
					targetResultValueDao.insert(resultValue);
				} else {
					trv.setValueA(convertResult(observationInfo.getObservationResult()));
					trv.setResultA(observationInfo.getConclusion());
					targetResultValueDao.update(trv);
				}
				// 指标分析过后修改标志位
				observationInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, observationInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	private void analyseDpbInfos(List<ObservationInfo> dbpInfos) {
		if (ObjectUtil.isNullOrEmpty(dbpInfos)) {
			return;
		}
		for (ObservationInfo observationInfo : dbpInfos) {
			if (ObjectUtil.isNullOrEmpty(observationInfo) || (!NumberUtil.isInteger(observationInfo.getObservationResult()) && !NumberUtil.isDecimal(observationInfo.getObservationResult()))) {
				continue;
			}
			TargetResultValue trv = targetResultValueDao.get(new Criteria(PERSON_ID, observationInfo.getPersonId()).add(EHR_ID, observationInfo.getEhrId()));
			try {
				if (ObjectUtil.isNullOrEmpty(trv)) {
					Date createDate = ObjectUtil.isNullOrEmpty(observationInfo.getCheckDate()) ? queryClinicDate(observationInfo.getEhrId()) : observationInfo.getCheckDate();
					if (ObjectUtil.isNullOrEmpty(createDate)) {
						continue;
					}
					TargetResultValue resultValue = new TargetResultValue();
					resultValue.setPersonId(observationInfo.getPersonId());
					resultValue.setEhrId(observationInfo.getEhrId());
					resultValue.setCreateDate(createDate);
					resultValue.setCreateOrganCode(observationInfo.getCheckOrgCode());
					resultValue.setUpdateOrganCode(observationInfo.getCheckOrgCode());
					resultValue.setValueB(convertResult(observationInfo.getObservationResult()));
					resultValue.setResultB(observationInfo.getConclusion());
					resultValue.setCreateUserCode(observationInfo.getCheckPeopleCode());
				    resultValue.setIsDelete(EHRConstants.DELETE_FLG_0);
				    targetResultValueDao.insert(resultValue);
				} else {
					trv.setValueB(convertResult(observationInfo.getObservationResult()));
					trv.setResultB(observationInfo.getConclusion());
					targetResultValueDao.update(trv);
				}
				
				// 指标分析过后修改标志位
				observationInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, observationInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 分析癫痫指标
	 * @param epilepsys
	 */
	private void analyseEpilepsy(List<DiseaseDiagnosisInfo> epilepsys) {
		if (ObjectUtil.isNullOrEmpty(epilepsys)) {
			return;
		}
		
		for (DiseaseDiagnosisInfo diseaseDiagnosisInfo : epilepsys) {
			if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo) || ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo.getPersonId())) {
				continue;
			}
			PersonInfo personInfo = queryPersonInfo(diseaseDiagnosisInfo.getPersonId());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				continue;
			}
			CicTarget cict = cicTargetDao.get(new Criteria(PERSON_ID, personInfo.getId()));
			try {
				if (ObjectUtil.isNullOrEmpty(cict)) {
					CicTarget cicTarget = new CicTarget();
					cicTarget.setPersonId(String.valueOf(personInfo.getId()));
					cicTarget.setIdcard(personInfo.getIdcard());
					cicTarget.setEpilepsyFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.insert(cicTarget);
				} else {
					cict.setIdcard(personInfo.getIdcard());
					cict.setEpilepsyFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.update(cict);
				}
				
				// 指标分析完成，更新标志位
				diseaseDiagnosisInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, diseaseDiagnosisInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 分析哮喘指标
	 */
	private void analyseAsthma(List<DiseaseDiagnosisInfo> asthmas) {
		if (ObjectUtil.isNullOrEmpty(asthmas)) {
			return;
		}
		
		for (DiseaseDiagnosisInfo diseaseDiagnosisInfo : asthmas) {
			if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo) || ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo.getPersonId())) {
				continue;
			}
			PersonInfo personInfo = queryPersonInfo(diseaseDiagnosisInfo.getPersonId());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				continue;
			}
			CicTarget cict = cicTargetDao.get(new Criteria(PERSON_ID, personInfo.getId()));
			try {
				if (ObjectUtil.isNullOrEmpty(cict)) {
					CicTarget cicTarget = new CicTarget();
					cicTarget.setPersonId(String.valueOf(personInfo.getId()));
					cicTarget.setIdcard(personInfo.getIdcard());
					cicTarget.setAsthmaFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.insert(cicTarget);
				} else {
					cict.setIdcard(personInfo.getIdcard());
					cict.setAsthmaFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.update(cict);
				}
				
				// 指标分析完成，更新标志位
				diseaseDiagnosisInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, diseaseDiagnosisInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 分析安装心脏起搏器
	 * @param cardiacpacemakers
	 */
	private void analyseCardiacPacemakers(List<SurgeryInfo> cardiacpacemakers) {
		if (ObjectUtil.isNullOrEmpty(cardiacpacemakers)) {
			return;
		}
		for (SurgeryInfo surgeryInfo : cardiacpacemakers) {
			if (ObjectUtil.isNullOrEmpty(surgeryInfo) || ObjectUtil.isNullOrEmpty(surgeryInfo.getPersonId())) {
				continue;
			}
			PersonInfo personInfo = queryPersonInfo(surgeryInfo.getPersonId());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				continue;
			}
			CicTarget cict = cicTargetDao.get(new Criteria(PERSON_ID, personInfo.getId()));
			try {
				if (ObjectUtil.isNullOrEmpty(cict)) {
					CicTarget cicTarget = new CicTarget();
					cicTarget.setPersonId(String.valueOf(personInfo.getId()));
					cicTarget.setIdcard(personInfo.getIdcard());
					cicTarget.setHeartPacemakerFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.insert(cicTarget);
				} else {
					cict.setIdcard(personInfo.getIdcard());
					cict.setHeartPacemakerFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.update(cict);
				}
				
				// 指标分析完成，更新标志位
				surgeryInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, surgeryInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	private void analyseHeartDisease(List<DiseaseDiagnosisInfo> heartDiseases) {
		if (ObjectUtil.isNullOrEmpty(heartDiseases)) {
			return;
		}
		for (DiseaseDiagnosisInfo diseaseDiagnosisInfo : heartDiseases) {
			if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo) || ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo.getPersonId())) {
				continue;
			}
			PersonInfo personInfo = queryPersonInfo(diseaseDiagnosisInfo.getPersonId());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				continue;
			}
			CicTarget cict = cicTargetDao.get(new Criteria(PERSON_ID, personInfo.getId()));
			try {
				if (ObjectUtil.isNullOrEmpty(cict)) {
					CicTarget cicTarget = new CicTarget();
					cicTarget.setPersonId(String.valueOf(personInfo.getId()));
					cicTarget.setIdcard(personInfo.getIdcard());
					cicTarget.setHeartDiseaseFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.insert(cicTarget);
				} else {
					cict.setIdcard(personInfo.getIdcard());
					cict.setHeartDiseaseFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.update(cict);
				}
				
				// 指标分析完成，更新标志位
				diseaseDiagnosisInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, diseaseDiagnosisInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 青光眼分析
	 * @param glaucomaDiseases
	 */
	private void analyseGlaucomaDiseases(List<DiseaseDiagnosisInfo> glaucomaDiseases) {
		if (ObjectUtil.isNullOrEmpty(glaucomaDiseases)) {
			return;
		}
		for (DiseaseDiagnosisInfo diseaseDiagnosisInfo : glaucomaDiseases) {
			if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo) || ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo.getPersonId())) {
				continue;
			}
			PersonInfo personInfo = queryPersonInfo(diseaseDiagnosisInfo.getPersonId());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				continue;
			}
			CicTarget cict = cicTargetDao.get(new Criteria(PERSON_ID, personInfo.getId()));
			if (ObjectUtil.isNullOrEmpty(cict)) {
				CicTarget cicTarget = new CicTarget();
				cicTarget.setPersonId(String.valueOf(personInfo.getId()));
				cicTarget.setIdcard(personInfo.getIdcard());
				cicTarget.setGlaucomaFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
				cicTargetDao.insert(cicTarget);
			} else {
				cict.setIdcard(personInfo.getIdcard());
				cict.setGlaucomaFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
				cicTargetDao.update(cict);
			}
			
			// 指标分析完成，更新标志位
			diseaseDiagnosisInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, diseaseDiagnosisInfo.getId()));
		}
	}
	
	private void analyseCerebrovascular(List<DiseaseDiagnosisInfo> cerebrovasculars) {
		if (ObjectUtil.isNullOrEmpty(cerebrovasculars)) {
			return;
		}
		for (DiseaseDiagnosisInfo diseaseDiagnosisInfo : cerebrovasculars) {
			if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo) || ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo.getPersonId())) {
				continue;
			}
			PersonInfo personInfo = queryPersonInfo(diseaseDiagnosisInfo.getPersonId());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				continue;
			}
			CicTarget cict = cicTargetDao.get(new Criteria(PERSON_ID, personInfo.getId()));
			try {
				if (ObjectUtil.isNullOrEmpty(cict)) {
					CicTarget cicTarget = new CicTarget();
					cicTarget.setPersonId(String.valueOf(personInfo.getId()));
					cicTarget.setIdcard(personInfo.getIdcard());
					cicTarget.setCardiovascularFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.insert(cicTarget);
				} else {
					cict.setIdcard(personInfo.getIdcard());
					cict.setCardiovascularFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.update(cict);
				}
				
				// 指标分析完成，更新标志位
				diseaseDiagnosisInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, diseaseDiagnosisInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 分析精神病指标
	 * @param diagnosisInfos
	 */
	private void analyseMentalDisorderDisease(List<DiseaseDiagnosisInfo> diagnosisInfos) {
		if (ObjectUtil.isNullOrEmpty(diagnosisInfos)) {
			return;
		}
		for (DiseaseDiagnosisInfo diseaseDiagnosisInfo : diagnosisInfos) {
			if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo) || ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo.getPersonId())) {
				continue;
			}
			PersonInfo personInfo = queryPersonInfo(diseaseDiagnosisInfo.getPersonId());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				continue;
			}
			CicTarget cict = cicTargetDao.get(new Criteria(PERSON_ID, personInfo.getId()));
			try {
				if (ObjectUtil.isNullOrEmpty(cict)) {
					CicTarget cicTarget = new CicTarget();
					cicTarget.setPersonId(String.valueOf(personInfo.getId()));
					cicTarget.setIdcard(personInfo.getIdcard());
					cicTarget.setMentalFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.insert(cicTarget);
				} else {
					cict.setIdcard(personInfo.getIdcard());
					cict.setMentalFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.update(cict);
				}
				
				// 指标分析完成，更新标志位
				diseaseDiagnosisInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, diseaseDiagnosisInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 分析精神病指标
	 * @param diagnosisInfos
	 */
	private void analyseDiabetesMellitusDisease(List<DiseaseDiagnosisInfo> diagnosisInfos) {
		if (ObjectUtil.isNullOrEmpty(diagnosisInfos)) {
			return;
		}
		for (DiseaseDiagnosisInfo diseaseDiagnosisInfo : diagnosisInfos) {
			if (ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo) || ObjectUtil.isNullOrEmpty(diseaseDiagnosisInfo.getPersonId())) {
				continue;
			}
			PersonInfo personInfo = queryPersonInfo(diseaseDiagnosisInfo.getPersonId());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				continue;
			}
			CicTarget cict = cicTargetDao.get(new Criteria(PERSON_ID, personInfo.getId()));
			try {
				if (ObjectUtil.isNullOrEmpty(cict)) {
					CicTarget cicTarget = new CicTarget();
					cicTarget.setPersonId(String.valueOf(personInfo.getId()));
					cicTarget.setIdcard(personInfo.getIdcard());
					cicTarget.setDiabetesFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.insert(cicTarget);
				} else {
					cict.setIdcard(personInfo.getIdcard());
					cict.setDiabetesFlag(EHRConstants.CIC_TARGET_FLAG_TRUE);
					cicTargetDao.update(cict);
				}
				// 指标分析完成，更新标志位
				diseaseDiagnosisInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, diseaseDiagnosisInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 分页处理接种信息
	 * @param criteria
	 */
	private void pageableAnalyseVaccinationInfo(final Criteria criteria) {
		PageableDateSource.execFirst(new IDataSource<VaccinationInfo>() {

			@Override
			public PageList<VaccinationInfo> get(Page page) {
				return vaccinationInfoDao.getPageList(page, criteria);
			}

			@Override
			public void run(List<VaccinationInfo> list) {
				analyseVaccinationInfo(list);
				
			}
		});
	}
	
	/**
	 * 接种信息分析
	 * @param vaccinationInfos
	 */
	private void analyseVaccinationInfo(List<VaccinationInfo> vaccinationInfos) {
		if (ObjectUtil.isNullOrEmpty(vaccinationInfos)) {
			return;
		}
		for (VaccinationInfo vaccinationInfo : vaccinationInfos) {
			if (ObjectUtil.isNullOrEmpty(vaccinationInfo) || ObjectUtil.isNullOrEmpty(vaccinationInfo.getPersonId())) {
				continue;
			}
			PersonInfo personInfo = queryPersonInfo(vaccinationInfo.getPersonId());
			if (ObjectUtil.isNullOrEmpty(personInfo)) {
				continue;
			}
			CicTarget cict = cicTargetDao.get(new Criteria(PERSON_ID, personInfo.getId()));
			try {
				if (ObjectUtil.isNullOrEmpty(cict)) {
					CicTarget cicTarget = new CicTarget();
					cicTarget.setPersonId(String.valueOf(personInfo.getId()));
					cicTarget.setIdcard(personInfo.getIdcard());
					cicTarget.setImmunization(convertImmuizationStr(vaccinationInfo));
					cicTargetDao.insert(cicTarget);
				} else {
					cict.setIdcard(personInfo.getIdcard());
					StringBuilder stringBuilder = new StringBuilder();
					if (ObjectUtil.isNullOrEmpty(cict.getImmunization())) {
						stringBuilder.append(convertImmuizationStr(vaccinationInfo));
					} else {
						stringBuilder.append(cict.getImmunization()).append(convertImmuizationStr(vaccinationInfo));
					}
					cict.setImmunization(stringBuilder.toString());
					cicTargetDao.update(cict);
				}
				
				// 指标分析完成，更新标志位
				vaccinationInfoDao.update(new Parameters(ANALYSIS_STATUS, "1"), new Criteria(ID, vaccinationInfo.getId()));
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * 转换计免接种信息格式
	 * @param vaccinationInfo
	 * @return
	 */
	private String convertImmuizationStr(VaccinationInfo vaccinationInfo) {
		if (ObjectUtil.isNullOrEmpty(vaccinationInfo)) {
			return "";
		}
		StringBuilder strBuilder = new StringBuilder();
		if (ObjectUtil.isNotEmpty(vaccinationInfo.getVaccinationDate()) && ObjectUtil.isNotEmpty(vaccinationInfo.getVaccineName())) {
			String dateStr = DateUtil.getDateTime("yyyyMMdd", vaccinationInfo.getVaccinationDate());
			strBuilder.append(vaccinationInfo.getVaccineName()).append(":").append(dateStr).append(";");
		}
		return strBuilder.toString();
	}
	
	/**
	 * 查询人员
	 * @param personId
	 * @return
	 */
	private PersonInfo queryPersonInfo(Long personId) {
		if (ObjectUtil.isNullOrEmpty(personId)) {
			return null;
		}
		PersonInfo personInfo = personMap.get(personId);
		if (ObjectUtil.isNullOrEmpty(personInfo)) {
			personInfo = personInfoDao.get(personId);
			if (ObjectUtil.isNotEmpty(personInfo)) {
				personMap.put(personId, personInfo);
			}
		}
		return personInfo;
	}
	
	private Date queryClinicDate(String ehrId) {
		if (ObjectUtil.isNullOrEmpty(ehrId)) {
			return null;
		}
		EHRHealthEvent ehrHealthEvent = eventMap.get(ehrId);
		if (ObjectUtil.isNullOrEmpty(ehrHealthEvent)) {
			ehrHealthEvent = ehrHealthEventDao.get(new Criteria(EHR_ID, ehrId));
			if (ObjectUtil.isNotEmpty(ehrHealthEvent)) {
				eventMap.put(ehrId, ehrHealthEvent);
			}
		}
		if (ObjectUtil.isNotEmpty(ehrHealthEvent)) {
			return ehrHealthEvent.getClinicDate();
		}
		return null;
	}

	@Override
	public void run(Map<String, Object> data) {
		analyseResultValue();
	}
	
	private BigDecimal convertResult(String result) {
		if (ObjectUtil.isNullOrEmpty(result)) {
			return null;
		}
		if ((NumberUtil.isInteger(result) || NumberUtil.isDecimal(result)) && StringUtils.length(result) < 6) {
			return new BigDecimal(result);
		}
		return null;
	}
}
