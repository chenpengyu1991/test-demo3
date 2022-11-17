package com.founder.rhip.ehr.service.report;

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
import com.founder.rhip.ehr.entity.report.RpTreatmentQuality;
import com.founder.rhip.ehr.repository.basic.IPersonDeathRecordDao;
import com.founder.rhip.ehr.repository.clinic.IInpatientMedicalRecordDao;
import com.founder.rhip.ehr.repository.clinic.ISurgeryInfoDao;
import com.founder.rhip.ehr.repository.report.IRpTreatmentQualityDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("rpTreatmentQualityService")
@TaskBean(cron = "0 0 4 * * ?", description = "治疗质量相关数据")
public class RpTreatmentQualityServiceImpl extends AbstractService implements IRpTreatmentQualityService, Task {
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "personDeathRecordDao")
	private IPersonDeathRecordDao personDeathRecordDao;
	
	@Resource(name = "inpatientMedicalRecordDao")
	private IInpatientMedicalRecordDao inpatientMedicalRecordDao;
	
	@Resource(name = "surgeryInfoDao")
	ISurgeryInfoDao surgeryInfoDao;
	
	@Resource(name = "rpTreatmentQualityDao")
	IRpTreatmentQualityDao rpTreatmentQualityDao;
		
	List<RpTreatmentQuality> updateRpTreatmentQualitys = new ArrayList<RpTreatmentQuality>();
	List<RpTreatmentQuality> insertRpTreatmentQualitys = new ArrayList<RpTreatmentQuality>();
	
	private static final String FORMATER = "yyyy/MM/dd";
	
	@Override
	public void run(Map<String, Object> data) {
		this.insertTreatmentQualityStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
	}
	
	@Override
	public void insertTreatmentQualityStatistics(String dateStr) {
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, FORMATER);
		} else {
			dateStr = DateUtil.getDateTime(FORMATER, date);
		}
		this.insertInpatientMedicalRecord(dateStr);
		this.insertInhospitalSurgeryData(dateStr);
		this.insertOperativeDeathData(dateStr);
	}
	
	/**
	 * 插入住院死亡数、自动出院数、危重抢救数、危重死亡数、新生儿死亡率
	 * @param dateStr
	 */
	private void insertInpatientMedicalRecord(String dateStr) {
		updateRpTreatmentQualitys = new ArrayList<RpTreatmentQuality>();
		insertRpTreatmentQualitys = new ArrayList<RpTreatmentQuality>();
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = inpatientMedicalRecordDao.getCureResultRecordStatistics(dateStr);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpTreatmentQuality rpTreatmentQuality = new RpTreatmentQuality();
			Organization organization = organizationApp.queryOrgan(String.valueOf(temp.get("hospital_code")));
			this.setValueForRpTreatmentQualityAboutOrg(organization, rpTreatmentQuality);
			Date outHospitalDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("out_hospital_date")).replace(".0", ""), FORMATER);
			rpTreatmentQuality.setRpDate(outHospitalDate);
			/*住院死亡数*/
			rpTreatmentQuality.setInhospitalDeathNum(Long.valueOf(String.valueOf(temp.get("die_count"))));
			/*自动出院数*/
			rpTreatmentQuality.setAutoLeaveNum(Long.valueOf(String.valueOf(temp.get("atuo_count"))));
			/*危重抢救数*/
			rpTreatmentQuality.setCriticalRescueNum(Long.valueOf(String.valueOf(temp.get("rescue_count"))));
			/*危重死亡数*/
			rpTreatmentQuality.setCriticalDeathNum(Long.valueOf(String.valueOf(temp.get("wei_count"))));
			/*新生儿死亡数*/
			rpTreatmentQuality.setNeonatalDeathNum(Long.valueOf(String.valueOf(temp.get("age_die_count"))));
			/*新生儿数*/
			rpTreatmentQuality.setNewbornNum(Long.valueOf(String.valueOf(temp.get("age_count"))));
			
			this.addRpInhosptial(organization.getOrganCode(), outHospitalDate, rpTreatmentQuality);
		}
		rpTreatmentQualityDao.batchInsert(insertRpTreatmentQualitys);
		rpTreatmentQualityDao.batchUpdate(updateRpTreatmentQualitys,"inhospitalDeathNum","autoLeaveNum","criticalRescueNum","criticalDeathNum","neonatalDeathNum","newbornNum");
	}
	/**
	 * 住院手术数
	 * @param dateStr
	 */
	private void insertInhospitalSurgeryData(String dateStr) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = surgeryInfoDao.getCureResultHosOperationStatistics(dateStr);
		
		updateRpTreatmentQualitys = new ArrayList<RpTreatmentQuality>();
		insertRpTreatmentQualitys = new ArrayList<RpTreatmentQuality>();
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpTreatmentQuality rpTreatmentQuality = new RpTreatmentQuality();
			Organization organization = organizationApp.queryOrgan(String.valueOf(temp.get("hospital_code")));
			this.setValueForRpTreatmentQualityAboutOrg(organization, rpTreatmentQuality);
			Date outHospitalDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("opertation_date")).replace(".0", ""), FORMATER);
			rpTreatmentQuality.setRpDate(outHospitalDate);
			/*住院手术数*/
			rpTreatmentQuality.setInhospitalSurgeryNum(Long.valueOf(String.valueOf(temp.get("hos_op_count"))));
			this.addRpInhosptial(organization.getOrganCode(), outHospitalDate, rpTreatmentQuality);
		}
		rpTreatmentQualityDao.batchInsert(insertRpTreatmentQualitys);
		rpTreatmentQualityDao.batchUpdate(updateRpTreatmentQualitys,"inhospitalSurgeryNum");
	}
	
	/**
	 * 手术死亡数
	 * @param dateStr
	 */
	private void insertOperativeDeathData(String dateStr) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = personDeathRecordDao.getCureResultHosOperationStatistics(dateStr);
		
		updateRpTreatmentQualitys = new ArrayList<RpTreatmentQuality>();
		insertRpTreatmentQualitys = new ArrayList<RpTreatmentQuality>();
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpTreatmentQuality rpTreatmentQuality = new RpTreatmentQuality();
			Organization organization = organizationApp.queryOrgan(String.valueOf(temp.get("input_organcode")));
			this.setValueForRpTreatmentQualityAboutOrg(organization, rpTreatmentQuality);
			Date outHospitalDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("death_date")).replace(".0", ""), FORMATER);
			rpTreatmentQuality.setRpDate(outHospitalDate);
			/*手术死亡数*/
			rpTreatmentQuality.setOperativeDeathNum(Long.valueOf(String.valueOf(temp.get("death_count"))));
			this.addRpInhosptial(organization.getOrganCode(), outHospitalDate, rpTreatmentQuality);
		}
		rpTreatmentQualityDao.batchInsert(insertRpTreatmentQualitys);
		rpTreatmentQualityDao.batchUpdate(updateRpTreatmentQualitys,"operativeDeathNum");
	}
	
	@Override
	public List<RpTreatmentQuality> getTreatmentQuality(Map<String, String> paramMap) {
		return rpTreatmentQualityDao.getRpTreatmentQualityStatistics(paramMap);
	}
	
	/**
	 * 根据机构code和出院日期检查时更新还是插入
	 * @param orgCode
	 * @param date
	 * @param RpTreatmentQuality
	 */
	private void addRpInhosptial(String orgCode, Date date, RpTreatmentQuality rpTreatmentQuality) {
		Criteria rpCriteria = new Criteria("organCode", orgCode);
		DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToMax(date), DateUtil.makeTimeToMax(date));
		RpTreatmentQuality tempRpTreatmentQuality = rpTreatmentQualityDao.get(rpCriteria);
		if(ObjectUtil.isNullOrEmpty(tempRpTreatmentQuality)) {
			insertRpTreatmentQualitys.add(rpTreatmentQuality);
		} else {
			tempRpTreatmentQuality.setInhospitalDeathNum(rpTreatmentQuality.getInhospitalDeathNum());
			tempRpTreatmentQuality.setAutoLeaveNum(rpTreatmentQuality.getAutoLeaveNum());
			tempRpTreatmentQuality.setInhospitalSurgeryNum(rpTreatmentQuality.getInhospitalSurgeryNum());
			tempRpTreatmentQuality.setCriticalRescueNum(rpTreatmentQuality.getCriticalRescueNum());
			tempRpTreatmentQuality.setOperativeDeathNum(rpTreatmentQuality.getOperativeDeathNum());
			tempRpTreatmentQuality.setCriticalDeathNum(rpTreatmentQuality.getCriticalDeathNum());
			tempRpTreatmentQuality.setNeonatalDeathNum(rpTreatmentQuality.getNeonatalDeathNum());
			tempRpTreatmentQuality.setNewbornNum(rpTreatmentQuality.getNewbornNum());
			
			updateRpTreatmentQualitys.add(tempRpTreatmentQuality);
		}
	}
	
	/**
	 * 为RpTreatmentQuality对象中和机构相关的属性赋值
	 * @param organization
	 * @param RpTreatmentQuality
	 */
	private void setValueForRpTreatmentQualityAboutOrg(Organization organization, RpTreatmentQuality rpTreatmentQuality) {
		rpTreatmentQuality.setGbCode(organization.getGbCode());
		rpTreatmentQuality.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
		rpTreatmentQuality.setOrganCode(organization.getOrganCode());
		rpTreatmentQuality.setOrganType(organization.getGenreCode());
	}
}
