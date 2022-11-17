package com.founder.rhip.hm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.ehr.dto.StudentExamReportDTO;
import com.founder.rhip.ehr.entity.basic.StandParameterCfg;
import com.founder.rhip.ehr.entity.clinic.EHRHealthEvent;
import com.founder.rhip.ehr.entity.clinic.HealthExamination;
import com.founder.rhip.ehr.entity.pbusiness.student.StudentExam;
import com.founder.rhip.ehr.repository.basic.IStandParameterCfgDao;
import com.founder.rhip.ehr.repository.clinic.IEHRHealthEventDao;
import com.founder.rhip.ehr.repository.clinic.IHealthExaminationDao;
import com.founder.rhip.ehr.repository.pbusiness.student.IStudentExamDao;
import com.founder.rhip.ehr.repository.pbusiness.student.IStudentExamQueryDao;
import com.founder.rhip.ehr.service.personal.IPersonalRecordManagmentService;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("studentExamService")
public class StudentExamServiceImpl implements IStudentExamService {

	@Resource(name = "studentExamDao")
	private IStudentExamDao studentExamDao;
	
	@Resource(name = "studentExamQueryDao")
	private IStudentExamQueryDao studentExamQueryDao;

	@Resource(name = "standParameterCfgDao")
	private IStandParameterCfgDao standParameterCfgDao;
	
	@Resource(name = "ehrHealthEventDao")
	private IEHRHealthEventDao ehrHealthEventDao;
	
	@Resource(name = "healthExaminationDao")
	private IHealthExaminationDao healthExaminationDao;
	
	@Resource(name = "personalRecordManagmentService")
	private IPersonalRecordManagmentService ehrService; 

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	/** 疾病预防控制中心机构编码 */
	public static final String JKZX                 = "46714114-9";
	
	@Override
	public PageList<StudentExam> getExamStudentPageList(Page page, Criteria criteria) {
		return studentExamQueryDao.getStudentExams(page, criteria);
	}
	
	public List<Map<String, Object>> exportExamList(Page page, Criteria criteria) {
		List<Map<String, Object>> dataSource = studentExamDao.exportStudentExams(page, criteria);
		return updateOrg(dataSource);
	}
	/**
	 * 统计体检进度
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<Map<String, Object>> getProgressList(Page page, Criteria criteria){
		criteria.add("year",DateUtil.getCurrentYear());
		PageList<Map<String, Object>> dataSource = studentExamQueryDao.getStudentExamProgressList(page, criteria);
		return dataSource;
	}
	
	/**
	 * 如果机构类型为：D400卫生室，则修改为疾控：46714114-9
	 *
	 * @param dataSource
	 * @return
	 * @author Ye jianfei
	 */
	private List<Map<String, Object>> updateOrg(List<Map<String, Object>> dataSource){
		List<Map<String, Object>> newDataSource = new ArrayList<>();
		for (Map<String, Object> data : dataSource) {
			String orgCode = data.get("OPERATE_ORGAN").toString();
			Organization org = organizationApp.queryOrgan(orgCode);
			if(ObjectUtil.isNotEmpty(org)){
				if("D400".equals(org.getGenreCode())){
					data.remove("OPERATE_ORGAN");
					data.put("OPERATE_ORGAN", JKZX);
				}
			}
			newDataSource.add(data);
		}
		return newDataSource;
	}
	
	@Override
	public PageList<StudentExam> getExamPageList(Page page, Criteria criteria) {
		return studentExamDao.getStudentExams(page, criteria);
	}
	
	@Override
	public void savePrintStatus(Long[] examIds) {
		Parameters parameters = new Parameters("printDate", new Date());
		Criteria criteria = new Criteria("studentExamId", OP.IN, examIds);
		studentExamDao.update(parameters, criteria);
	}

	@Override
	public List<StudentExam> getExamList(Criteria criteria) {
		return studentExamDao.getList(criteria, new Order("EXAM_DATE", false).asc("SCHOOL_CODE"));
	}

	@Override
	public StudentExamReportDTO.ReportDataList report(String examYear, String[] schools, String[] grades,boolean mergeFlag) {
		StudentExamReportDTO.ReportDataList dto = new StudentExamReportDTO.ReportDataList();
		List<Map<String, Object>> baseDataList = studentExamDao.reportBaseData(examYear, schools, grades,mergeFlag);
		List<Map<String, Object>> ageAt12DataList = studentExamDao.reportAgeAt12Data(examYear, schools, grades,mergeFlag);
		List<Map<String, Object>> lastYearNormalDataList = studentExamDao.reportLastYearNormalData(examYear, schools, grades,mergeFlag);
		List<Map<String, Object>> newPoorVisionDataList = studentExamDao.reportNewPoorVisionData(examYear, schools, grades,mergeFlag);
		setReportData(dto, baseDataList, ageAt12DataList, lastYearNormalDataList, newPoorVisionDataList);
		return dto;
	}
	
	private void setReportData(StudentExamReportDTO.ReportDataList dto, List<Map<String, Object>> baseDataList
			, List<Map<String, Object>> ageAt12DataList, List<Map<String, Object>> lastYearNormalDataList, List<Map<String, Object>> newPoorVisionDataList) {
		String school = "";
		String grade = "";
		String key = "";
		StudentExamReportDTO.ReportData mReportData = new StudentExamReportDTO.ReportData();
		StudentExamReportDTO.ReportData fReportData = new StudentExamReportDTO.ReportData();
		int genderCount = 0;
		for (Map<String, Object> baseData : baseDataList) {
			school = (String)baseData.get("SCHOOL_CODE");
			grade = (String)baseData.get("GRADE_CODE");
			if (!key.equals(school + "," + grade)) {
				if (genderCount < 11) {
					if (genderCount == 1) {
						fReportData.setGender("2");
						setReportData(fReportData, lastYearNormalDataList, school, grade, "2");
					} else if (genderCount == 10) {
						mReportData.setGender("1");
						setReportData(mReportData, lastYearNormalDataList, school, grade, "1");
					}
				}
				key = school + "," + grade;
				genderCount = 0;
				StudentExamReportDTO.SchoolReport schoolReport = new StudentExamReportDTO.SchoolReport();
				schoolReport.setSchool(school);
				schoolReport.setGrade(grade);
				dto.addReportData(schoolReport);
				
				mReportData = new StudentExamReportDTO.ReportData();
				mReportData.setGender("1");
				schoolReport.addReportData(mReportData);
				fReportData = new StudentExamReportDTO.ReportData();
				fReportData.setGender("2");
				schoolReport.addReportData(fReportData);
			}
			
			String gender = (String)baseData.get("GENDER");
			if ("1".equals(gender)) {
				mReportData.setGender("1");
				setReportData(mReportData, baseData, ageAt12DataList, lastYearNormalDataList, newPoorVisionDataList, school, grade, gender);
				genderCount += 1;
			} else if ("2".equals(gender)) {
				fReportData.setGender("2");
				setReportData(fReportData, baseData, ageAt12DataList, lastYearNormalDataList, newPoorVisionDataList, school, grade, gender);
				genderCount += 10;
			}
		}
		if (genderCount < 11) {
			if (genderCount == 1) {
				fReportData.setGender("2");
				setReportData(fReportData, lastYearNormalDataList, school, grade, "2");
			} else if (genderCount == 10) {
				mReportData.setGender("1");
				setReportData(mReportData, lastYearNormalDataList, school, grade, "1");
			}
		}
	}
	
	@Override
	@Transactional
	public int addStudentExam(StudentExam studentExam) {
		String idcard = studentExam.getIdcard();
		double age = studentExam.getAge();
		Criteria criteria = new Criteria("idcard", idcard);
		criteria.add("age", age);
		StudentExam dbStudentExam = studentExamDao.get(criteria);
		
		if (dbStudentExam != null) {
			studentExam.setStudentExamId(dbStudentExam.getStudentExamId());
			studentExam.setEhrId(dbStudentExam.getEhrId());
			updateStudentExam(studentExam);
			return 1;
		}
		
		// 体检事件
		EHRHealthEvent event = insertEhrHealthEvent(EventType.STUDENT_PHYSICAL_EXAMINATION, studentExam);

		String ehrId = event.getEhrId();
		
		//条件数据
		studentExam.setStudentExamId(studentExamDao.getSequenceNextVal("SEQ_STUDENT_EXAM", Long.class));
		studentExam.setEhrId(ehrId);
		setBodyParameters(studentExam);
		studentExamDao.insert(studentExam);
		
		
		// 体检信息
		HealthExamination examination = new HealthExamination();
		copyHealthExamination(studentExam, examination);
		examination.setEhrId(ehrId);
		examination.setPhysicalExamType(EventType.STUDENT_PHYSICAL_EXAMINATION.getCode());
		healthExaminationDao.insert(examination);

		
		
		//更新健康档案星级
		ehrService.updateStudentToThreeStar(studentExam.getIdcard());
		
		return 1;
	}
	private void copyHealthExamination(StudentExam studentExam, HealthExamination examination) {
		examination.setPhysicalExamCode(String.valueOf(studentExam.getStudentExamId()));
		examination.setAge(DateUtil.getAge(studentExam.getBirthday(),studentExam.getExamDate()));
		examination.setBirthday(studentExam.getBirthday());
		examination.setExaminationDate(studentExam.getExamDate());
		examination.setGender(studentExam.getGender());
		examination.setName(studentExam.getName());
		examination.setPersonId(Long.parseLong(studentExam.getPersonInfoId()));
		examination.setManaDoctorName(studentExam.getManaDoctorName());
		examination.setExaminationResult(studentExam.getExaminationResult());
		examination.setSuggestion(studentExam.getHealthGuidance());
		examination.setHospitalCode(studentExam.getOperateOrgan());
		examination.setHospitalName(studentExam.getOrganization());
		examination.setIsDelete(EHRConstants.DELETE_FLG_0);
		examination.setPhysicalExamCode(studentExam.getStudentExamId().toString());
		
	}
	
	private EHRHealthEvent insertEhrHealthEvent(EventType ehrType, StudentExam studentExam) {
		EHRHealthEvent ehrHealthEvent = new EHRHealthEvent();
		ehrHealthEvent.setUpdateDate(new Date());
		String personId = studentExam.getPersonInfoId();
		if (ehrType != null && personId != null) {
			ehrHealthEvent.setEhrType(ehrType.getCode());
			ehrHealthEvent.setEhrName(ehrType.getName());
			ehrHealthEvent.setName(studentExam.getName());
			ehrHealthEvent.setAge(DateUtil.getAgeByBirthday(studentExam.getBirthday(), studentExam.getExamDate()) + "岁");
			ehrHealthEvent.setPersonId(Long.parseLong(personId));
			ehrHealthEvent.setCreateDate(new Date());
			ehrHealthEvent.setClinicDate(studentExam.getExamDate());
			ehrHealthEvent.setClinicOrganCode(studentExam.getOperateOrgan());
			ehrHealthEvent.setClinicOrganName(studentExam.getOrganization());
			ehrHealthEvent.setIsDelete(EHRConstants.DELETE_FLG_0);
			Long healthEventId = ehrHealthEventDao.generatedKey(ehrHealthEvent, "ID", null).longValue();
			ehrHealthEvent.setId(healthEventId);
			ehrHealthEvent.setEhrId(String.valueOf(healthEventId));
			ehrHealthEventDao.update(ehrHealthEvent);
		}
		return ehrHealthEvent;
	}

	@Override
	@Transactional
	public int updateStudentExam(StudentExam studentExam) {
		// 更新体检信息
		Criteria criteria = new Criteria("personId", studentExam.getPersonInfoId());
		if(ObjectUtil.isNotEmpty(studentExam.getEhrId())){
			criteria.add("ehrId", studentExam.getEhrId());
		}
		HealthExamination examination = healthExaminationDao.get(criteria);
		Assert.notNull(examination, "无法获取体检信息");
		copyHealthExamination(studentExam, examination);
		healthExaminationDao.update(examination);
		
		setBodyParameters(studentExam);
		studentExamDao.update(studentExam);
		return 1;
	}
	
	@Override
	public Integer getHealthExaminationCount(StudentExam studentExam){
		Integer result = 1;		
		String idcard = studentExam.getIdcard();
		double age = studentExam.getAge();
		Criteria criteria = new Criteria("idcard", idcard);
		criteria.add("age", age);
		StudentExam dbStudentExam = studentExamDao.get(criteria);
		if(ObjectUtil.isNotEmpty(dbStudentExam)){
			Criteria ca = new Criteria("personId", dbStudentExam.getPersonInfoId());
			ca.add("ehrId", dbStudentExam.getEhrId());	
			result = healthExaminationDao.getCount(ca, "id", Integer.class);
		}
		return result;
	}
	
	@Override
	public StudentExam getStudentExam(Criteria criteria) {
		return studentExamDao.get(criteria);
	}

	@Override
	@Transactional
	public int deleteStudentExam(Long studentExamId) {
		Criteria criteria = new Criteria("studentExamId", studentExamId);
		StudentExam exam = getStudentExam(criteria);
		Assert.notNull(exam, "无法获取体检信息");
		
		studentExamDao.delete(criteria);
		
		String ehrId = exam.getEhrId();
		String personId = exam.getPersonInfoId();
		criteria = new Criteria("ehrId", ehrId);
		Parameters parameters = new Parameters("isDelete", EHRConstants.DELETE_FLG_1);
		ehrHealthEventDao.update(parameters, criteria);
		
		criteria.add("personId", personId);
		healthExaminationDao.update(parameters, criteria);
		return 1;
	}

	@Override
	public StudentExam getStudentExamInfo(String examYear, String idcard) {
		return studentExamDao.getStudentExamInfo(examYear, idcard);
	}
	
	@Override
	public String checkHighBlood(double age, String gender, double sbp, double dbp) {
		//sbp = formatValue(sbp);
		//dbp = formatValue(dbp);
		String ageStr = fromatIntAge(age, 6, 18);
		String newGender = getNewGender(gender);
		String paramCode = "mmHg-" + newGender + "-" + ageStr;
		Criteria criteria = new Criteria("standardCode", "HIGH_BLOOD");
		criteria.add("parameterCode", paramCode);
		StandParameterCfg cfg = standParameterCfgDao.get(criteria);
		String paramValue = cfg.getParameterValue();
		String[] values = paramValue.split("-");
		if (sbp >= Double.parseDouble(values[0])
				|| dbp >= Double.parseDouble(values[1])) {
			return "血压异常";
		}
		return null;
	}
	
	private static double formatValue(double value) {
		//四舍六入，五成双
		NumberFormat format = DecimalFormat.getInstance();
		format.setMaximumFractionDigits(1);
		return Double.valueOf(format.format(value).replace(",", ""));
	}
	
	@Override
	public String checkHeightCatagory(double age, String gender, double height) {
		//height = formatValue(height);
		String ageStr = fromatAge(age, 6, 19.5);
		String newGender = getNewGender(gender);
		String paramCode = newGender + "-" + ageStr;
		Criteria criteria = new Criteria("standardCode", "HEIGHT_CATAGORY");
		criteria.add("parameterCode", paramCode);
		StandParameterCfg cfg = standParameterCfgDao.get(criteria);
		String paramValue = cfg.getParameterValue();
		String[] values = paramValue.split("-");
		if (height <= Double.parseDouble(values[0])) {
			return "生长迟缓";
		}
		if (height <= Double.parseDouble(values[1])) {
			return "身材矮小";
		}
		return null;
	}
	
	@Override
	public String checkWeightCatagory(double age, String gender, double height, double weight) {
		String ageStr = fromatAge(age, 6, 19.5);
		double bmi = computerBMI(height, weight);
		String newGender = getNewGender(gender);
		String paramCode = newGender + "-" + ageStr;
		
		Criteria criteria = new Criteria("standardCode", "WEIGHT_CATAGORY");
		criteria.add("parameterCode", paramCode);
		StandParameterCfg cfg = standParameterCfgDao.get(criteria);
		String paramValue = cfg.getParameterValue();
		String[] values = paramValue.split("-");
		if (bmi <= Double.parseDouble(values[0])) {
			return "中重度消瘦";
		}
		if (bmi <= Double.parseDouble(values[1])) {
			return "轻度消瘦";
		}
		
		ageStr = fromatIntAge(age, 7, 18);
		paramCode = newGender + "-" + ageStr;
		criteria = new Criteria("standardCode", "WEIGHT_CATAGORY_H");
		criteria.add("parameterCode", paramCode);
		cfg = standParameterCfgDao.get(criteria);
		paramValue = cfg.getParameterValue();
		values = paramValue.split("-");
		if (bmi >= Double.parseDouble(values[1])) {
			return "肥胖";
		}
		if (bmi >= Double.parseDouble(values[0])) {
			return "超重";
		}
		return null;
	}
	
	private void setBodyParameters(StudentExam studentExam) {
		double height = studentExam.getHeight();
		double weight = studentExam.getBodyWeight();
		studentExam.setIndexOfBodyCharacteristics(computerBMI(height, weight));
		double age = DateUtil.getAgeByBirthday(studentExam.getBirthday(), studentExam.getExamDate());
		studentExam.setAge(age);
		String gender = studentExam.getGender();
		studentExam.setHeightCatagory(checkHeightCatagory(age, gender, height));
		studentExam.setWeightCatagory(checkWeightCatagory(age, gender, height, weight));
	}
	
	private String fromatIntAge(double age, double min, double max) {
		double value = age;
		if (age < min) {
			value = min;
		}
		if (age > max) {
			value = max;
		}
		return String.valueOf((int)value);
	}
	
	private String fromatAge(double age, double min, double max) {
		double value = age;
		if (age < min) {
			value = min;
		}
		if (age > max) {
			value = max;
		}
		if (value == (int)value) {
			return String.valueOf((int)value);
		}
		return String.format("%.1f", value);
	}
	
	private double computerBMI(double height, double weight) {
		double value =  (weight * 10000) / (height * height);
		return formatValue(value);
	}
	
	private String getNewGender(String gender) {
		String newGender = "1".equals(gender) ? "M" : "F";
		return newGender;
	}

	private int getIntValue(Map<String, Object> map, String key) {
		Object value = map.get(key);
		if (ObjectUtil.isNullOrEmpty(value)) {
			return 0;
		}
		if (value instanceof BigDecimal) {
			((BigDecimal)value).intValue();
		}
		return Integer.parseInt(value.toString());
	}
	
	private void setReportData(StudentExamReportDTO.ReportData reportData, 
			List<Map<String, Object>> lastYearNormalDataList, String school, String grade, String gender) {
		//去年正常数
		Map<String, Object> lastYearNormalData = findData(lastYearNormalDataList, school, grade, gender);
		if (lastYearNormalData != null) {
			reportData.setNormalVisionLastYearNumber(getIntValue(lastYearNormalData, "NORMAL_VISION_LAST_YEAR_NUMBER"));
		}
	}
	
	private void setReportData(StudentExamReportDTO.ReportData reportData, Map<String, Object> baseData
			, List<Map<String, Object>> ageAt12DataList, List<Map<String, Object>> lastYearNormalDataList
			, List<Map<String, Object>> newPoorVisionDataList, String school, String grade, String gender) {
		//体检人数
		reportData.setExamNumber(getIntValue(baseData, "EXAM_NUMBER"));
		//正常人数
		reportData.setNormalNumber(getIntValue(baseData, "NORMAL_NUMBER"));
		//超重人数
		reportData.setOverweightNumber(getIntValue(baseData, "OVERWEIGHT_NUMBER"));
		//肥胖人数
		reportData.setObesityNumber(getIntValue(baseData, "OBESITY_NUMBER"));
		//生长迟缓人数
		reportData.setSlowGrowthNumber(getIntValue(baseData, "SLOW_GROWTH_NUMBER"));
		//身材矮小人数
		reportData.setSmallNumber(getIntValue(baseData, "SMALL_NUMBER"));
		//中重度消瘦人数
		reportData.setModerateThinNumber(getIntValue(baseData, "MODERATE_THIN_NUMBER"));
		//轻度消瘦人数
		reportData.setMildThinNumber(getIntValue(baseData, "MILD_THIN_NUMBER"));
		//轻度视力不良
		reportData.setMildPoorVisionNumber(getIntValue(baseData, "MILD_POOR_VISION_NUMBER"));
		//中度视力不良
		reportData.setModeratePoorVisionNumber(getIntValue(baseData, "MODERATE_POOR_VISION_NUMBER"));
		//重度视力不良
		reportData.setSeverePoorVisionNumber(getIntValue(baseData, "SEVERE_POOR_VISION_NUMBER"));
		//去年正常数
		Map<String, Object> lastYearNormalData = findData(lastYearNormalDataList, school, grade, gender);
		if (lastYearNormalData != null) {
			reportData.setNormalVisionLastYearNumber(getIntValue(lastYearNormalData, "NORMAL_VISION_LAST_YEAR_NUMBER"));
		}
		//新发数
		Map<String, Object> newPoorVisionData = findData(newPoorVisionDataList, school, grade, gender);
		if (newPoorVisionData != null) {
			reportData.setNewPoorVisionNumber(getIntValue(newPoorVisionData, "NEW_POOR_VISION_NUMBER"));
		}
		//沙眼
		reportData.setTrachomaEyeNumber(getIntValue(baseData, "TRACHOMA_EYE_NUMBER"));
		//乳牙龋患人数
		reportData.setBabyEurodonticusNumber(getIntValue(baseData, "BABY_EURODONTICUS_NUMBER"));
		//乳牙龋齿数
		reportData.setBabyDentalCariesNumber(getIntValue(baseData, "BABY_DENTAL_CARIES_NUMBER"));
		//乳牙龋补数
		reportData.setBabyCariesFillingNumber(getIntValue(baseData, "BABY_CARIES_FILLING_NUMBER"));
		//恒牙龋患人数
		reportData.setPermanentEurodonticusNumber(getIntValue(baseData, "PER_EURODONTICUS_NUMBER"));
		//恒牙龋齿数
		reportData.setPermanentDentalCariesNumber(getIntValue(baseData, "PER_DENTAL_CARIES_NUMBER"));
		//恒牙龋补数
		reportData.setPermanentCariesFillingNumber(getIntValue(baseData, "PER_CARIES_FILLING_NUMBER"));
		//(12周岁)
		Map<String, Object> ageAt12Data = findData(ageAt12DataList, school, grade, gender);
		if (ageAt12Data != null) {
			//恒牙龋患人数(12周岁)
			reportData.setEurodonticusNumber(getIntValue(ageAt12Data, "EURODONTICUS_NUMBER"));
			//恒牙龋齿数(12周岁)
			reportData.setDentalCariesNumber(getIntValue(ageAt12Data, "DENTAL_CARIES_NUMBER"));
			//恒牙龋补数(12周岁)
			reportData.setCariesFillingNumber(getIntValue(ageAt12Data, "CARIES_FILLING_NUMBER"));
		}
		//牙周病
		reportData.setPeriodontalDiseaseNumber(getIntValue(baseData, "PERIODONTAL_DISEASE_NUMBER"));
		//杂音/早搏
		reportData.setHeartDiseaseNumber(getIntValue(baseData, "HEART_DISEASE_NUMBER"));
		//哮鸣音
		reportData.setLungDiseaseNumber(getIntValue(baseData, "LUNG_DISEASE_NUMBER"));
		//肝脾肿大
		reportData.setSpleenDiseaseNumber(getIntValue(baseData, "SPLEEN_DISEASE_NUMBER"));
		//甲状腺肿大
		reportData.setNeckDiseaseNumber(getIntValue(baseData, "NECK_DISEASE_NUMBER"));
		//淋巴结肿大
		reportData.setLimbsDiseaseNumber(getIntValue(baseData, "LIMBS_DISEASE_NUMBER"));
		//脊柱弯曲
		reportData.setSpineDiseaseNumber(getIntValue(baseData, "SPINE_DISEASE_NUMBER"));
		//皮肤病
		reportData.setSkinDiseaseNumber(getIntValue(baseData, "SKIN_DISEASE_NUMBER"));
	}
	
	private Map<String, Object> findData(List<Map<String, Object>>dataList, String school, String grade, String gender) {
		String key = school + "," + grade + "," +  gender;
		for (Map<String, Object> data : dataList) {
			String dataKey = "" + data.get("SCHOOL_CODE") + "," + data.get("GRADE_CODE") + "," +  data.get("GENDER");
			if (key.equals(dataKey)) {
				return data;
			}
		}
		return null;
	}
}