package com.founder.rhip.ehr.service.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpInhospital;
import com.founder.rhip.ehr.repository.clinic.IClinicalPathwayDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientInfoDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientMedicalRecordDao;
import com.founder.rhip.ehr.repository.clinic.ISickbedUseStateDao;
import com.founder.rhip.ehr.repository.report.IRpInhospitalDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IStaffService;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("rpInhosptialService")
@TaskBean(cron = "0 0 4 * * ?", description = "病案数和住院出院相关数据")
public class RpInhosptialServiceImpl extends AbstractService implements IRpInhospitalService, Task {
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "rpInhospitalDao")
	private IRpInhospitalDao rpInhospitalDao;
	
	
	@Resource(name = "inpatientMedicalRecordDao")
	private IInpatientMedicalRecordDao inpatientMedicalRecordDao;
	
	@Resource(name = "inpatientInfoDao")
	IInpatientInfoDao inpatientInfoDao;
	
	@Resource(name = "mdmStaffService")
	IStaffService mdmStaffService;
	
	@Resource(name = "sickbedUseStateDao")
	ISickbedUseStateDao sickbedUseStateDao;
	
	@Resource(name = "clinicalPathwayDao")
	IClinicalPathwayDao clinicalPathwayDao;
	
	List<RpInhospital> updateRpInhospitals = new ArrayList<RpInhospital>();
	List<RpInhospital> insertRpInhospitals = new ArrayList<RpInhospital>();
	private static final String FORMATER = "yyyy/MM/dd";
	
	@Override
	public void insertInhosMedicalRecordQualityStatistics(String dateStr) {

		updateRpInhospitals = new ArrayList<RpInhospital>();
		insertRpInhospitals = new ArrayList<RpInhospital>();
		
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, FORMATER);
		} else {
			dateStr = DateUtil.getDateTime(FORMATER, date);
		}
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = inpatientMedicalRecordDao.getInhosMedicalRecordQualityStatistics(dateStr);
		
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpInhospital rpInhospital = new RpInhospital();
			Organization organization = organizationApp.queryOrgan(String.valueOf(temp.get("hospital_code")));
			this.setValueForRpInhospitalAboutOrg(organization, rpInhospital);
			Date outHospitalDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("out_hospital_date")).replace(".0", ""), FORMATER);
			rpInhospital.setRpDate(outHospitalDate);
			rpInhospital.setCaseNum((ObjectUtil.isNullOrEmpty(temp.get("allc"))) ? 0 : Long.valueOf(String.valueOf(temp.get("allc"))));
			rpInhospital.setaCaseNum((ObjectUtil.isNullOrEmpty(temp.get("jia"))) ? 0 : Long.valueOf(String.valueOf(temp.get("jia"))));
			rpInhospital.setbCaseNum((ObjectUtil.isNullOrEmpty(temp.get("yi"))) ? 0 : Long.valueOf(String.valueOf(temp.get("yi"))));
			rpInhospital.setcCaseNum((ObjectUtil.isNullOrEmpty(temp.get("bing"))) ? 0 : Long.valueOf(String.valueOf(temp.get("bing"))));
			this.addRpInhosptial(organization.getOrganCode(), outHospitalDate, rpInhospital);
		}
		rpInhospitalDao.batchInsert(insertRpInhospitals);
		rpInhospitalDao.batchUpdate(updateRpInhospitals,"caseNum","aCaseNum","bCaseNum","cCaseNum");
	}

	/**
	 * 获取手术麻醉的数据
	 * @param dateStr
	 */
	@Override
	public void insertAnesthesiaAndSurgeryStatistics(String dateStr) {
		updateRpInhospitals = new ArrayList<RpInhospital>();
		insertRpInhospitals = new ArrayList<RpInhospital>();
		
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, FORMATER);
		} else {
			dateStr = DateUtil.getDateTime(FORMATER, date);
		}
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = inpatientMedicalRecordDao.getAnesthesiaAndSurgeryStatistics(dateStr);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpInhospital rpInhospital = new RpInhospital();
			String anesthesiaCode = String.valueOf(temp.get("anesthesia_code"));
			String surgeryCode = String.valueOf(temp.get("surgery_code"));
			Date rpDate = null;
			if(ObjectUtil.isNotEmpty(temp.get("anesthesia_code"))){
				rpInhospital.setOrganCode(anesthesiaCode);
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("anesthesia_date")).replace(".0", ""), FORMATER);
				rpInhospital.setRpDate(rpDate);
			} else if(ObjectUtil.isNotEmpty(temp.get("surgery_code"))) {
				rpInhospital.setOrganCode(surgeryCode);
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("surgery_date")).replace(".0", ""), FORMATER);
				rpInhospital.setRpDate(rpDate);
			}
			
			Organization organization = organizationApp.queryOrgan(rpInhospital.getOrganCode());
			this.setValueForRpInhospitalAboutOrg(organization, rpInhospital);
			rpInhospital.setAnesthesiaNum((ObjectUtil.isNullOrEmpty(temp.get("countAnesthesia"))) ? 0 : Long.valueOf(String.valueOf(temp.get("countAnesthesia"))));
			rpInhospital.setOperationNum((ObjectUtil.isNullOrEmpty(temp.get("countSurgery"))) ? 0 : Long.valueOf(String.valueOf(temp.get("countSurgery"))));
			this.addRpInhosptial(organization.getOrganCode(), rpDate, rpInhospital);
		}
		rpInhospitalDao.batchInsert(insertRpInhospitals);
		rpInhospitalDao.batchUpdate(updateRpInhospitals,"operationNum","anesthesiaNum");
	}
	
	@Override
	public void run(Map<String, Object> data) {
		insertInhosMedicalRecordQualityStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
		insertInpatientInfoStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
		insertBedStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
		insertAnesthesiaAndSurgeryStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
		insertClinicalPathwayStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
	}

	@Override
	public List<RpInhospital> getInpatientMedicalRecordQuality(Map<String, String> paramMap) {
		return rpInhospitalDao.getInhosMedicalRecordQualityStatistics(paramMap);
	}
	
	@Override
	public void insertInpatientInfoStatistics(String dateStr) {
		updateRpInhospitals = new ArrayList<RpInhospital>();
		insertRpInhospitals = new ArrayList<RpInhospital>();
		
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, "yyyy/MM/dd");
		} else {
			dateStr = DateUtil.getDateTime("yyyy/MM/dd", date);
		}
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = inpatientInfoDao.getInpatientInfoStatistics(dateStr);
		Map<String,Long> staffCountMap = mdmStaffService.getStaffNumByOrg(null);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpInhospital rpInhospital = new RpInhospital();
			String referralHospitalCode = String.valueOf(temp.get("referral_hospital_code"));
			String inHosCode = String.valueOf(temp.get("in_hos_code"));
			Date rpDate = null;
			if(ObjectUtil.isNotEmpty(temp.get("referral_hospital_code"))){
				rpInhospital.setOrganCode(referralHospitalCode);
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("out_hospital_date")).replace(".0", ""), FORMATER);
				rpInhospital.setRpDate(rpDate);
			} else if(ObjectUtil.isNotEmpty(temp.get("in_hos_code"))) {
				rpInhospital.setOrganCode(inHosCode);
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("inhos_date")).replace(".0", ""), FORMATER);
				rpInhospital.setRpDate(rpDate);
			} 
			Organization organization = organizationApp.queryOrgan(rpInhospital.getOrganCode());
			this.setValueForRpInhospitalAboutOrg(organization, rpInhospital);
			rpInhospital.setDoctorNum(staffCountMap.get(rpInhospital.getOrganCode()));
			rpInhospital.setInNum((ObjectUtil.isNullOrEmpty(temp.get("in_num"))) ? 0 : Long.valueOf(String.valueOf(temp.get("in_num"))));
			rpInhospital.setLeaveNum((ObjectUtil.isNullOrEmpty(temp.get("out_num"))) ? 0 : Long.valueOf(String.valueOf(temp.get("out_num"))));
			rpInhospital.setInhospitalDay((ObjectUtil.isNullOrEmpty(temp.get("inhos_days"))) ? 0 : Long.valueOf(String.valueOf(temp.get("inhos_days"))));
			rpInhospital.setPersonalFee((ObjectUtil.isNullOrEmpty(temp.get("personal_expenses"))) ? new BigDecimal("0") : new BigDecimal(String.valueOf(temp.get("personal_expenses"))));
			rpInhospital.setCooperativeMedicalFee((ObjectUtil.isNullOrEmpty(temp.get("medical_insurance_cost_sum"))) ? new BigDecimal("0") : new BigDecimal(String.valueOf(temp.get("medical_insurance_cost_sum"))) );
			rpInhospital.setFeeTotal((ObjectUtil.isNullOrEmpty(temp.get("inhos_cost_sum"))) ? new BigDecimal("0") : new BigDecimal(String.valueOf(temp.get("inhos_cost_sum"))));
			this.addRpInhosptial(organization.getOrganCode(), rpDate, rpInhospital);
		}
		rpInhospitalDao.batchInsert(insertRpInhospitals);
		rpInhospitalDao.batchUpdate(updateRpInhospitals,"inNum","doctorNum","leaveNum","inhospitalDay","personalFee","cooperativeMedicalFee","feeTotal");
	}
	
	/**
     * 统计住院人数（按照现在的床位数）
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
	@Override
	public void insertBedStatistics(String dateStr) {
		updateRpInhospitals = new ArrayList<RpInhospital>();
		insertRpInhospitals = new ArrayList<RpInhospital>();
		
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, "yyyy/MM/dd");
		} else {
			dateStr = DateUtil.getDateTime("yyyy/MM/dd", date);
		}
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = sickbedUseStateDao.getBedStatistics(dateStr);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpInhospital rpInhospital = new RpInhospital();
			String hospitalCode = String.valueOf(temp.get("hospital_code"));
			Date rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("create_date")).replace(".0", ""), FORMATER);
			rpInhospital.setOrganCode(hospitalCode);
			rpInhospital.setRpDate(rpDate);
			rpInhospital.setBeNum((ObjectUtil.isNullOrEmpty(temp.get("bed_num"))) ? 0 : Long.valueOf(String.valueOf(temp.get("bed_num"))));
			Organization organization = organizationApp.queryOrgan(rpInhospital.getOrganCode());
			this.setValueForRpInhospitalAboutOrg(organization, rpInhospital);
			this.addRpInhosptial(organization.getOrganCode(), rpDate, rpInhospital);
		}
		rpInhospitalDao.batchInsert(insertRpInhospitals);
		rpInhospitalDao.batchUpdate(updateRpInhospitals,"beNum");
	}
	/**
	 * 根据机构code和出院日期检查时更新还是插入
	 * @param orgCode
	 * @param date
	 * @param rpInhospital
	 */
	private void addRpInhosptial(String orgCode, Date date, RpInhospital rpInhospital) {
		Criteria rpCriteria = new Criteria("organCode", orgCode);
		DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(date), DateUtil.makeTimeToMax(date));
		RpInhospital tempRpInhospital = rpInhospitalDao.get(rpCriteria);
		if(ObjectUtil.isNullOrEmpty(tempRpInhospital)) {
			insertRpInhospitals.add(rpInhospital);
		} else {
			tempRpInhospital.setInNum(rpInhospital.getInNum());
			tempRpInhospital.setDoctorNum(rpInhospital.getDoctorNum());
			tempRpInhospital.setBeNum(rpInhospital.getBeNum());
			tempRpInhospital.setLeaveNum(rpInhospital.getLeaveNum());
			tempRpInhospital.setInhospitalDay(rpInhospital.getInhospitalDay());
			tempRpInhospital.setPersonalFee(rpInhospital.getPersonalFee());
			tempRpInhospital.setCooperativeMedicalFee(rpInhospital.getCooperativeMedicalFee());
			tempRpInhospital.setFeeTotal(rpInhospital.getFeeTotal());
			
			tempRpInhospital.setaCaseNum(rpInhospital.getaCaseNum());
			tempRpInhospital.setCaseNum(rpInhospital.getCaseNum());
			tempRpInhospital.setbCaseNum(rpInhospital.getbCaseNum());
			tempRpInhospital.setcCaseNum(rpInhospital.getcCaseNum());
			
			tempRpInhospital.setOperationNum(rpInhospital.getOperationNum());
			tempRpInhospital.setAnesthesiaNum(rpInhospital.getAnesthesiaNum());
			
			tempRpInhospital.setClinicalPathwayNum(rpInhospital.getClinicalPathwayNum());
			tempRpInhospital.setOutCpNum(rpInhospital.getOutCpNum());
			tempRpInhospital.setCompleteCpNum(rpInhospital.getCompleteCpNum());
			tempRpInhospital.setCureCpNum(rpInhospital.getCureCpNum());
			tempRpInhospital.setDeathCpNum(rpInhospital.getDeathCpNum());
			
			updateRpInhospitals.add(tempRpInhospital);
		}
	}
	
	/**
     * 插入临床路径的数据
     * @param dateStr 日期格式必须是yyyy/mm/dd
     * @return
     */
    @Override
    public void insertClinicalPathwayStatistics(String dateStr) {
    	updateRpInhospitals = new ArrayList<RpInhospital>();
		insertRpInhospitals = new ArrayList<RpInhospital>();
		
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, "yyyy/MM/dd");
		} else {
			dateStr = DateUtil.getDateTime("yyyy/MM/dd", date);
		}
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = clinicalPathwayDao.getClinicalPathwayStatistics(dateStr);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpInhospital rpInhospital = new RpInhospital();
			String cliCode = String.valueOf(temp.get("cli_code"));
			String outCode = String.valueOf(temp.get("out_code"));
			String comCode = String.valueOf(temp.get("com_code"));
			String cuCode = String.valueOf(temp.get("cu_code"));
			String deathCode = String.valueOf(temp.get("death_code"));
			Date rpDate = null;
			
			if(ObjectUtil.isNotEmpty(temp.get("cli_code"))){
				rpInhospital.setOrganCode(cliCode);
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("cli_date")).replace(".0", ""), FORMATER);
				rpInhospital.setRpDate(rpDate);
			} else if(ObjectUtil.isNotEmpty(temp.get("out_code"))) {
				rpInhospital.setOrganCode(outCode);
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("out_date")).replace(".0", ""), FORMATER);
				rpInhospital.setRpDate(rpDate);
			} else if(ObjectUtil.isNotEmpty(temp.get("com_code"))) {
				rpInhospital.setOrganCode(comCode);
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("com_date")).replace(".0", ""), FORMATER);
				rpInhospital.setRpDate(rpDate);
			} else if(ObjectUtil.isNotEmpty(temp.get("cu_code"))) {
				rpInhospital.setOrganCode(cuCode);
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("cu_date")).replace(".0", ""), FORMATER);
				rpInhospital.setRpDate(rpDate);
			} else if(ObjectUtil.isNotEmpty(temp.get("death_code"))) {
				rpInhospital.setOrganCode(deathCode);
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("death_date")).replace(".0", ""), FORMATER);
				rpInhospital.setRpDate(rpDate);
			} 
			
			Organization organization = organizationApp.queryOrgan(rpInhospital.getOrganCode());
			this.setValueForRpInhospitalAboutOrg(organization, rpInhospital);
			rpInhospital.setClinicalPathwayNum((ObjectUtil.isNullOrEmpty(temp.get("clinicalPathwayNum"))) ? 0 : Long.valueOf(String.valueOf(temp.get("clinicalPathwayNum"))));
			rpInhospital.setOutCpNum((ObjectUtil.isNullOrEmpty(temp.get("outCpNum"))) ? 0 : Long.valueOf(String.valueOf(temp.get("outCpNum"))));
			rpInhospital.setCompleteCpNum((ObjectUtil.isNullOrEmpty(temp.get("completeCpNum"))) ? 0 : Long.valueOf(String.valueOf(temp.get("completeCpNum"))));
			rpInhospital.setCureCpNum((ObjectUtil.isNullOrEmpty(temp.get("cureCpNum"))) ? 0 : Long.valueOf(String.valueOf(temp.get("cureCpNum"))));
			rpInhospital.setDeathCpNum((ObjectUtil.isNullOrEmpty(temp.get("deathCpNum"))) ? 0 : Long.valueOf(String.valueOf(temp.get("deathCpNum"))));
			this.addRpInhosptial(organization.getOrganCode(), rpDate, rpInhospital);
		}
		rpInhospitalDao.batchInsert(insertRpInhospitals);
		rpInhospitalDao.batchUpdate(updateRpInhospitals,"clinicalPathwayNum","outCpNum","completeCpNum","cureCpNum","deathCpNum");
    }
	/**
	 * 为RpInhospital对象中和机构相关的属性赋值
	 * @param organization
	 * @param rpInhospital
	 */
	private void setValueForRpInhospitalAboutOrg(Organization organization, RpInhospital rpInhospital) {
		rpInhospital.setGbCode(organization.getGbCode());
		rpInhospital.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
		rpInhospital.setOrganCode(organization.getOrganCode());
		rpInhospital.setOrganType(organization.getGenreCode());
	}
	
	@Override
	public List<RpInhospital> getInOrOutHospitalStatistics(Map<String, String> paramMap) {
		return rpInhospitalDao.getInOrOutHospitalStatistics(paramMap);
	}
	
	@Override
	public List<RpInhospital> getClinicalPathwayStatistics(Map<String, String> paramMap) {
		return rpInhospitalDao.getClinicalPathwayStatistics(paramMap);
	}
	
	/**
	 * 综合管理首页住院统计(住院)
	 * @param criteria
	 * @return
	 */
	@Override
	public Map<String, Object> statisticsFeeInhospital(String dateStr, String dateFormater){
		return rpInhospitalDao.statisticsFeeInhospital(dateStr, dateFormater);
	}
	
	/**
	 * 住院服务绩效考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<RpInhospital> getRpInhospitalPerformanceOrg(Map<String, String> paramMap) {
		return rpInhospitalDao.getRpInhospitalPerformanceOrg(paramMap);
	}
}
