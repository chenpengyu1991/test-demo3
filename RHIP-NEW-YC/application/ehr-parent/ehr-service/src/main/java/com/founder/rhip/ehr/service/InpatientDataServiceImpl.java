/**
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. 
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.rhip.ehr.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.*;
import com.founder.rhip.ehr.entity.clinic.*;
import com.founder.rhip.ehr.repository.clinic.*;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.ClinicalChartBasicInfoDTO;
import com.founder.rhip.ehr.dto.ClinicalChartDataDTO;
import com.founder.rhip.ehr.dto.ClinicalChartParam;
import com.founder.rhip.ehr.dto.InpatientItemDTO;
import com.founder.rhip.ehr.dto.InpatientMedicalRecordDto;
import com.founder.rhip.ehr.dto.InpatientReportDTO;
import com.founder.rhip.ehr.dto.InpatientSummaryDTO;
import com.founder.rhip.ehr.dto.OuthostpitalSummaryDTO;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ehr.entity.summary.DrugAllergyHistory;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.summary.IDrugAllergyHistoryDao;

/**
 * 住院
 * 
 * @author liuk
 * 
 */
@Service("inpatientDataService")
public class InpatientDataServiceImpl extends AbstractService implements IInpatientDataService {

	@Autowired
	private IInpatientInfoDao inpatientInfoDao;
	@Autowired
	private IDrugUsageDao drugUsageDao;
	@Autowired
	private IExamineEventDao examineEventDao;
	@Autowired
	private IStudyEventDao studyEventDao;
	@Autowired
	private IInpatientMedicalRecordDao inpatientMedicalRecordDao;
	@Autowired
	private IOuthospitalSummaryDao outhospitalSummaryDao;
	@Autowired
	private IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;
	@Autowired
	private IEHRHealthEventDao ehrHealthEventDao;
	@Autowired
	private IExpenseInfoDao expenseInfoDao;
	@Autowired
	private IPersonInfoDao personInfoDao;
	@Autowired
	private ISurgeryInfoDao surgeryInfoDao;
	@Autowired
	private IDrugAllergyHistoryDao drugAllergyHistoryDao;

	@Autowired
	private IExpenseDetailDao expenseDetailDao;

	@Override
	public PageList<InpatientItemDTO> getInpatientList(Page page, Criteria criteria) {
		// 通过人员pix查询到相关的住院摘要
		PageList<InpatientInfo> inpatientInfos = inpatientInfoDao.getPageList(page, criteria);
		List<InpatientItemDTO> inpatientItemDTOs = new ArrayList<InpatientItemDTO>();
		if (null != inpatientInfos) {
			for (InpatientInfo item : inpatientInfos.getList()) {
				InpatientItemDTO inpatientItem = new InpatientItemDTO();
				inpatientItemDTOs.add(inpatientItem);
				inpatientItem.setInpatientInfo(item);
				Criteria paramCriteria = new Criteria();
				paramCriteria.add("ehrId", item.getEhrId());
				paramCriteria.add("personId", item.getPersonId());
				// 是否用药
				Integer drugs = drugUsageDao.getCount(paramCriteria, "ehrId", Integer.class);
				inpatientItem.setHasDrug(drugs > 0);
				// 是否检验
				Integer exams = examineEventDao.getCount(paramCriteria, "ehrId", Integer.class);
				inpatientItem.setHasExam(exams > 0);
				// 是否检查
				Integer checks = studyEventDao.getCount(paramCriteria, "ehrId", Integer.class);
				inpatientItem.setHasStudy(checks > 0);
				// 是否有电子病例,病案首页和出院小结有一个即可
				Integer inpatientMeRecords = inpatientMedicalRecordDao.getCount(paramCriteria, "ehrId", Integer.class);
				Integer outhospitalSummarys = outhospitalSummaryDao.getCount(paramCriteria, "ehrId", Integer.class);
				inpatientItem.setHasElecMedicalRecord(inpatientMeRecords > 0 || outhospitalSummarys > 0);
			}
			return new PageList<>(inpatientItemDTOs, inpatientInfos.getPage());
		}
		return new PageList<>(inpatientItemDTOs, null);
	}

	@Override
	public ClinicalChartBasicInfoDTO getClinicalChartBasicInfo(Criteria criteria) {
		ClinicalChartBasicInfoDTO clinicalChartBasicInfo = null;
		EHRHealthEvent healthEvent = ehrHealthEventDao.get(criteria,"ehrId","personId");
		if (null == healthEvent) {
			return clinicalChartBasicInfo;
		}
		Criteria paramCriteria = new Criteria("ehrId", healthEvent.getEhrId());
		paramCriteria.add("personId", healthEvent.getPersonId());
		InpatientInfo inpatientInfo = inpatientInfoDao.get(paramCriteria,"name","gender","age","inhosDate","id","outHospitalDate","inhosDays");
		if (null == inpatientInfo) {
			return clinicalChartBasicInfo;
		}
		Date startDate = inpatientInfo.getInhosDate();
		if (null == startDate) {
			return clinicalChartBasicInfo;
		}
		Date endDate = getOutHosDate(inpatientInfo.getOutHospitalDate());
		if (startDate.after(endDate)) {
			return clinicalChartBasicInfo;
		}
		clinicalChartBasicInfo = new ClinicalChartBasicInfoDTO();
		clinicalChartBasicInfo.setInpatientInfo(inpatientInfo);
		//add by yejianfei 20140725
		//入院天数:如果入院天数为空,则用入院日期减去出院日期
		Integer inhosDays = null;//住院天数
		Date inhosDate = inpatientInfo.getInhosDate();//入院日期
		Date outHospitalDate = inpatientInfo.getOutHospitalDate();//出院日期
		if( ObjectUtil.isNotEmpty(inpatientInfo.getInhosDays())){
			inhosDays = inpatientInfo.getInhosDays();
		}else if(ObjectUtil.isNotEmpty(inhosDate)
				&& ObjectUtil.isNotEmpty(outHospitalDate)){
			inhosDays = DateUtil.getBetweenDays(inhosDate,outHospitalDate);
		}
		clinicalChartBasicInfo.setInhosDays(inhosDays);
		//add by yejianfei 20140725
		// 集成数据天数
		//clinicalChartBasicInfo.setInhosDays(inpatientInfo.getInhosDays());

		// 计算实际天数用于显示周计算
		Integer days = DateUtil.getBetweenDays(startDate, endDate);

		Integer weeks = days % 7 == 0 ? days / 7 : days / 7 + 1;
		clinicalChartBasicInfo.setInhosWeeks(weeks);
		// 获取诊断信息
		paramCriteria.add("diagnosisTypeCode", EHRConstants.DIAGNOSIS_TYPE_OUTHOS);
		List<DiseaseDiagnosisInfo> diseaseDiagnosisInfos = diseaseDiagnosisInfoDao.getList(paramCriteria,"diagnosisDesc","id");
		clinicalChartBasicInfo.setDiseaseDiagnosisInfos(diseaseDiagnosisInfos);
		return clinicalChartBasicInfo;
	}

	private Date getOutHosDate(Date outDate) {
		Date currentDate = new Date();
		// 如果无出院日期,或者出院日期大于当前日期,则返回当前日期
		if (null == outDate || outDate.after(currentDate)) {
			return currentDate;
		}
		return outDate;
	}

	@Override
	public ClinicalChartDataDTO getClinicalChart(ClinicalChartParam clinicalChartParam) {
		Long id = clinicalChartParam.getId();
		if (null == id) {
			return null;
		}
		InpatientInfo inpatientInfo = inpatientInfoDao.get(clinicalChartParam.getId());
		if (null == inpatientInfo) {
			return null;
		}
		Date startDate = inpatientInfo.getInhosDate();
		if (null == startDate) {
			return null;
		}
		Date endDate = DateUtil.makeTimeToMax(getOutHosDate(inpatientInfo.getOutHospitalDate()));
		if (startDate.after(endDate)) {
			return null;
		}
		// 默认显示第一周
		Integer currentWeek = null == clinicalChartParam.getCurrentWeek() ? 1 : clinicalChartParam.getCurrentWeek();
		// 计算出日期查询范围
		Date fromDate = null;
		if (1 == currentWeek) {
			fromDate = DateUtil.makeTimeToZero(startDate);
		} else {
			fromDate = DateUtil.makeTimeToZero(DateUtils.addDays(startDate, 7 * (clinicalChartParam.getCurrentWeek() - 1)));
		}
		int days = 7;
		Date toDate = DateUtil.makeTimeToMax(DateUtils.addDays(fromDate, days-1));
		if (toDate.after(DateUtil.makeTimeToMax(endDate))) {
			days = DateUtil.getBetweenDays(fromDate, endDate);
			toDate = endDate;
		}

		ClinicalChartDataDTO clinicalChartDataDTO = new ClinicalChartDataDTO();
		clinicalChartDataDTO.setCurrentWeek(currentWeek);
		clinicalChartDataDTO.setLastDays(days);
		//
		Criterion ehrIdCriterion = new Criterion("ehrId", inpatientInfo.getEhrId());
		Criterion personIdCriterion = new Criterion("personId", inpatientInfo.getPersonId());

		// 用药数据
		Criteria paramCriteria = makeDateRangeCriteria("startDate", fromDate, toDate, personIdCriterion, ehrIdCriterion);
		Map<String, Map<String, DrugUsage>> drugUsagesMap = getDrugUsage(paramCriteria);
		clinicalChartDataDTO.setDrugUsagesMap(drugUsagesMap);
		// 检验
		paramCriteria = makeDateRangeCriteria("checkDate", fromDate, toDate, personIdCriterion, ehrIdCriterion);
		Map<String, List<Map<String, Object>>> examMap = getExam(paramCriteria);
		clinicalChartDataDTO.setExamMap(examMap);
		// 检查
		paramCriteria = makeDateRangeCriteria("checkDate", fromDate, toDate, personIdCriterion, ehrIdCriterion);
		Map<String, List<Map<String, Object>>> studyMap = getStudy(paramCriteria);
		clinicalChartDataDTO.setStudyMap(studyMap);
		// 费用
		paramCriteria = makeDateRangeCriteria("clinicDate", fromDate, toDate, personIdCriterion, ehrIdCriterion);
		Map<String, List<String>> getExpenseMap = getExpenseInfo(paramCriteria);
		clinicalChartDataDTO.setExpenseMap(getExpenseMap);

		// 病例
		paramCriteria = new Criteria();
		paramCriteria.addCriterion(personIdCriterion);
		paramCriteria.addCriterion(ehrIdCriterion);
		// 病案首页
		if (1 == currentWeek) {
			InpatientMedicalRecord inpatientMeRecord = inpatientMedicalRecordDao.get(paramCriteria, "id");
			if (null != inpatientMeRecord) {
				clinicalChartDataDTO.setInpatientMedicalRecord(inpatientMeRecord.getId());
			}
		}
		// 出院小结
		if (toDate.equals(endDate)) {
			OuthospitalSummary outhospitalSummary = outhospitalSummaryDao.get(paramCriteria, "id");
			if (null != outhospitalSummary) {
				clinicalChartDataDTO.setOuthospitalSummary(outhospitalSummary.getId());
			}
		}

		// 一周日期列表
		List<String> weeks = DateUtil.makeDayList(fromDate, days);
		clinicalChartDataDTO.setWeeks(weeks);
		return clinicalChartDataDTO;
	}

	private String getKeyFromDate(Date date) {
		return DateUtil.getDateTime("yyyy-MM-dd", date);
	}

	private Criteria makeDateRangeCriteria(String key, Date fromDate, Date toDate, Criterion... criterions) {
		Criteria paramCriteria = new Criteria();
		for (Criterion criterion : criterions) {
			paramCriteria.addCriterion(criterion);
		}
		paramCriteria.add(key, OP.BETWEEN, new Object[] { fromDate, toDate });
		return paramCriteria;
	}

	private Map<String, Map<String, DrugUsage>> getDrugUsage(Criteria paramCriteria) {
		List<DrugUsage> drugUsages = drugUsageDao.getList(paramCriteria, "id", "drugGenericName", "startDate", "drugGenericName", "drugSpecifications", "quantityUnit", "quantity");
		if (null == drugUsages || drugUsages.size() == 0) {
			return null;
		}
		// 分布到每一天,每天有多个数据
		Map<String, Map<String, DrugUsage>> drugUsagesMap = new HashMap<>();
		for (DrugUsage drugUsage : drugUsages) {
			String keyString = getKeyFromDate(drugUsage.getStartDate());
			Map<String, DrugUsage> usages = drugUsagesMap.get(keyString);
			if (null == usages) {
				usages = new HashMap<>();
				drugUsagesMap.put(keyString, usages);
			}
			StringBuilder builder = new StringBuilder();
			builder.append(drugUsage.getDrugGenericName()).append("|");
			builder.append(drugUsage.getDrugSpecifications()).append("|");
			builder.append(drugUsage.getQuantityUnit());
			// 检查药物使用量
			// 如果为空,认为一次
			BigDecimal count = drugUsage.getQuantity();
			if (null == count) {
				drugUsage.setQuantity(BigDecimal.ONE);
			}
			DrugUsage drug = usages.get(builder.toString());
			if (null == drug) {
				usages.put(builder.toString(), drugUsage);
			} else {
				drug.setQuantity(drug.getQuantity().add(drugUsage.getQuantity()));
			}
		}
		return drugUsagesMap;
	}

	private Map<String, List<Map<String, Object>>> getExam(Criteria paramCriteria) {
		List<ExamineEvent> examineEvents = examineEventDao.getList(paramCriteria, "id", "checkListTitle", "checkDate");
		if (null == examineEvents || examineEvents.size() == 0) {
			return null;
		}
		Map<String, List<Map<String, Object>>> examMap = new HashMap<String, List<Map<String, Object>>>();
		for (ExamineEvent examineEvent : examineEvents) {
			String keyString = getKeyFromDate(examineEvent.getCheckDate());
			List<Map<String, Object>> usages = examMap.get(keyString);
			if (null == usages) {
				usages = new ArrayList<Map<String, Object>>();
				examMap.put(keyString, usages);
			}
			Map<String, Object> map = new HashMap<String, Object>(2);
			map.put("id", examineEvent.getId());
			map.put("title", examineEvent.getCheckListTitle());
			usages.add(map);
		}
		return examMap;
	}

	private Map<String, List<Map<String, Object>>> getStudy(Criteria paramCriteria) {
		List<StudyEvent> studyEvents = studyEventDao.getList(paramCriteria, "id", "inspectionTitle", "checkDate");
		if (null == studyEvents || studyEvents.size() == 0) {
			return null;
		}
		Map<String, List<Map<String, Object>>> studyMap = new HashMap<String, List<Map<String, Object>>>();
		for (StudyEvent studyEvent : studyEvents) {
			String keyString = getKeyFromDate(studyEvent.getCheckDate());
			List<Map<String, Object>> studys = studyMap.get(keyString);
			if (null == studys) {
				studys = new ArrayList<Map<String, Object>>();
				studyMap.put(keyString, studys);
			}
			Map<String, Object> map = new HashMap<String, Object>(2);
			map.put("id", studyEvent.getId());
			map.put("title", studyEvent.getInspectionTitle());
			studys.add(map);
		}
		return studyMap;
	}

	private Map<String, List<String>> getExpenseInfo(Criteria paramCriteria) {
		List<ExpenseDetail> expenseDetails = expenseDetailDao.getList(paramCriteria, "clinicDate", "costTypeName", "detailItemAmount");
		if (null == expenseDetails || expenseDetails.size() == 0) {
			return null;
		}
		// 分布到每一天,每天有多个数据
		Map<String, List<String>> expenseInfoMap = new HashMap<String, List<String>>();
		for (ExpenseDetail expenseDetail : expenseDetails) {
			String keyString = getKeyFromDate(expenseDetail.getClinicDate());
			List<String> infos = expenseInfoMap.get(keyString);
			if (null == infos) {
				infos = new ArrayList<String>();
				expenseInfoMap.put(keyString, infos);
			}
			infos.add(expenseDetail.getCostTypeName() + ":" + expenseDetail.getDetailItemAmount());
		}
		return expenseInfoMap;
	}

	@Override
	public InpatientSummaryDTO getInpatientSummary(Criteria paramCriteria) {
		InpatientInfo inpatientInfo = inpatientInfoDao.get(paramCriteria);
		if (null != inpatientInfo) {
			//add by yejianfei 20140725
			//入院天数:如果入院天数为空,则用入院日期减去出院日期
			Integer inhosDays = null;//住院天数
			Date inhosDate = inpatientInfo.getInhosDate();//入院日期
			Date outHospitalDate = inpatientInfo.getOutHospitalDate();//出院日期
			if( ObjectUtil.isNotEmpty(inpatientInfo.getInhosDays())){
				inhosDays = inpatientInfo.getInhosDays();
			}else if(ObjectUtil.isNotEmpty(inhosDate)
					&& ObjectUtil.isNotEmpty(outHospitalDate)){
				inhosDays = DateUtil.getBetweenDays(inhosDate,outHospitalDate);
			}
			inpatientInfo.setInhosDays(inhosDays);
			//add by yejianfei 20140725
			InpatientSummaryDTO inpatientSummaryDTO = new InpatientSummaryDTO();
			inpatientSummaryDTO.setInpatientInfo(inpatientInfo);
			// 医嘱
			Criteria criteria = new Criteria();
			Criterion ehrIdCriterion = new Criterion("ehrId", inpatientInfo.getEhrId());
			Criterion personIdCriterion = new Criterion("personId", inpatientInfo.getPersonId());
			criteria.addCriterion(personIdCriterion);
			criteria.addCriterion(ehrIdCriterion);
			List<DrugUsage> drugUsages =  drugUsageDao.getList(criteria,"quantityUnit", "quantity", "drugTradeName", "drugGenericName", "drugSpecifications","startDate","odrisuDt");
			inpatientSummaryDTO.setDrugUsages(drugUsages);
			// 检查
			List<StudyEvent> studyEvents = studyEventDao.getList(criteria,"id","applyDate","recordNumber","inspectionType","conclusionDesc");
			inpatientSummaryDTO.setStudyEvents(studyEvents);
			// 检验
			// TODO 当前在前台获取

			// 诊断信息]
			//criteria.add("diagnosisTypeCode", EHRConstants.DIAGNOSIS_TYPE_INHOS);
			List<DiseaseDiagnosisInfo> diseaseDiagnosisInfos = diseaseDiagnosisInfoDao.getList(criteria,"id","diagnoseDate","diagnosisDesc");
			inpatientSummaryDTO.setDiseaseDiagnosisInfos(diseaseDiagnosisInfos);
			return inpatientSummaryDTO;
		}
		return null;
	}

	@Override
	public InpatientMedicalRecordDto getMedicalIndex(Criteria criteria) {
		InpatientMedicalRecord inpatientMedicalRecord = inpatientMedicalRecordDao.get(criteria);
		InpatientMedicalRecordDto inpatientMedicalRecordDto = null;
		if (null != inpatientMedicalRecord) {
			inpatientMedicalRecordDto = new InpatientMedicalRecordDto();
			inpatientMedicalRecordDto.setInpatientMedicalRecord(inpatientMedicalRecord);
			// 实际住院天数 入院和出院加起来只算一天
			if (null != inpatientMedicalRecord.getInhosDate() && null != inpatientMedicalRecord.getOutHospitalDate()) {
				inpatientMedicalRecordDto.setInhosDays(DateUtil.getBetweenDays(inpatientMedicalRecord.getInhosDate(), inpatientMedicalRecord.getOutHospitalDate()) - 1);
			}
			// 基本信息
			PersonInfo personInfo = personInfoDao.get(inpatientMedicalRecord.getPersonId());
			inpatientMedicalRecordDto.setPersonInfo(personInfo);
			//
			Criteria paramCriteria = new Criteria("ehrId", inpatientMedicalRecord.getEhrId());
			paramCriteria.add("personId", inpatientMedicalRecord.getPersonId());

			// 手术
			List<SurgeryInfo> surgeryInfos = surgeryInfoDao.getList(paramCriteria);
			inpatientMedicalRecordDto.setSurgeryInfos(surgeryInfos);

			// 诊断信息
			Map<String, List<DiseaseDiagnosisInfo>> diseaseDiagnosisInfoMap = getDiseaseDiagnosisInfoMap(paramCriteria);
			inpatientMedicalRecordDto.setDiseaseDiagnosisInfoMap(diseaseDiagnosisInfoMap);

			List<DiseaseDiagnosisInfo> mjzInfoList = getMjzInfoList(paramCriteria);
			inpatientMedicalRecordDto.setMjzInfoList(mjzInfoList);
			
			// 药物过敏
			paramCriteria.remove("ehrId");// 查询所有的药物过敏
			List<DrugAllergyHistory> allergyHistories = drugAllergyHistoryDao.getList(paramCriteria.add("allergensFlag", "1"));
			inpatientMedicalRecordDto.setAllergyHistories(allergyHistories);

		}
		return inpatientMedicalRecordDto;
	}
	private List<DiseaseDiagnosisInfo> getMjzInfoList(Criteria criteria) {
		
		criteria.add("DIAGNOSIS_TYPE_CODE","02");
		List<DiseaseDiagnosisInfo> inhosDiseaseDiagnosisInfos = diseaseDiagnosisInfoDao.getList(criteria);
		criteria.remove("DIAGNOSIS_TYPE_CODE");//后面还需要用这变量但不需要此条件
		if (null == inhosDiseaseDiagnosisInfos || inhosDiseaseDiagnosisInfos.size() == 0) {
			return null;
		}
		
		return inhosDiseaseDiagnosisInfos;
	}
	
	
	// 获取诊断信息
	private Map<String, List<DiseaseDiagnosisInfo>> getDiseaseDiagnosisInfoMap(Criteria criteria) {
		String zyzd = "1";//主要诊断
		String qtzd ="2";//其他诊断
		criteria.add("DIAGNOSIS_TYPE_CODE","01");//0177068: 【健康档案浏览器-医疗服务】住院病案首页 主要诊断 查询方式修改
		List<DiseaseDiagnosisInfo> inhosDiseaseDiagnosisInfos = diseaseDiagnosisInfoDao.getList(criteria);
		criteria.remove("DIAGNOSIS_TYPE_CODE");//后面还需要用这变量但不需要此条件
		if (null == inhosDiseaseDiagnosisInfos || inhosDiseaseDiagnosisInfos.size() == 0) {
			return null;
		}
		Map<String, List<DiseaseDiagnosisInfo>> diseaseDiagnosisInfoMap = new HashMap<String, List<DiseaseDiagnosisInfo>>();
		List<DiseaseDiagnosisInfo> dgInfos  = new ArrayList<DiseaseDiagnosisInfo>();
		List<DiseaseDiagnosisInfo> othDgInfos  = new ArrayList<DiseaseDiagnosisInfo>();
		for (DiseaseDiagnosisInfo info : inhosDiseaseDiagnosisInfos) {
			String keyString = info.getPirncipalDiagnosis();
			if(zyzd.equals(keyString))
				dgInfos.add(info);
			else if(qtzd.equals(keyString))
				othDgInfos.add(info);
			
		}
		criteria.add("DIAGNOSIS_TYPE_CODE","09");
		List<DiseaseDiagnosisInfo> pathologyDgInfos = diseaseDiagnosisInfoDao.getList(criteria); // 病理诊断
		criteria.remove("DIAGNOSIS_TYPE_CODE");//后面还需要用这变量但不需要此条件
		diseaseDiagnosisInfoMap.put(zyzd,dgInfos);//主要诊断
		diseaseDiagnosisInfoMap.put(qtzd,othDgInfos);//其他诊断
		diseaseDiagnosisInfoMap.put("9", pathologyDgInfos);// 病理诊断
		return diseaseDiagnosisInfoMap;
	}

	public InpatientReportDTO getInpatientReport(Criteria criteria) {
		InpatientReportDTO result = new InpatientReportDTO();
		return result;
	}

	@Override
	public OuthostpitalSummaryDTO getOuthospitalSummary(Criteria criteria) {
		OuthostpitalSummaryDTO result = null;
		OuthospitalSummary outhospitalSummary = outhospitalSummaryDao.get(criteria);
		if (null == outhospitalSummary) {
			return result;
		}
		result = new OuthostpitalSummaryDTO();
		result.setOuthospitalSummary(outhospitalSummary);
		criteria = new Criteria();
		criteria.add("personId", outhospitalSummary.getPersonId());
		criteria.add("ehrId", outhospitalSummary.getEhrId());

		// 手术
		List<SurgeryInfo> surgeryInfos = surgeryInfoDao.getList(criteria, "opertationName", "opertationDate");
		result.setSurgeryInfos(surgeryInfos);
		// 入院诊断
		criteria.add("diagnosisTypeCode", EHRConstants.DIAGNOSIS_TYPE_INHOS);
		List<DiseaseDiagnosisInfo> inhosDiseaseDiagnosisInfos = diseaseDiagnosisInfoDao.getList(criteria, "diagnosisDesc");
		result.setInHosDiseaseDiagnosisInfos(inhosDiseaseDiagnosisInfos);
		// 出院诊断
		criteria.remove("diagnosisTypeCode");
		criteria.add("diagnosisTypeCode", EHRConstants.DIAGNOSIS_TYPE_OUTHOS);
		List<DiseaseDiagnosisInfo> outHosDiseaseDiagnosisInfos = diseaseDiagnosisInfoDao.getList(criteria, "diagnosisDesc");
		result.setOutHosDiseaseDiagnosisInfos(outHosDiseaseDiagnosisInfos);

		return result;
	}

	public InpatientReportDTO exportInpatientReport(Criteria criteria) {
		InpatientReportDTO result = null;
		return result;
	}

	@Override
    public PageList<InpatientInfo> getInpatientPageList(Page page, Criteria criteria, Order order){
		return inpatientInfoDao.getInpatientPageList(page, criteria, order);
	}
	
	@Override
    public InpatientInfo getInpatientInfo(Criteria criteria){
		return inpatientInfoDao.get(criteria);
	}

	//获取住院信息
	@Override
	public List<InpatientInfo> getinpatientInfoList(Criteria criteria) {
		return inpatientInfoDao.getList(criteria);
	}
}