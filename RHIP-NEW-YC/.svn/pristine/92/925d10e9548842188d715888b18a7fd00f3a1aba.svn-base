package com.founder.rhip.ehr.service.report;

import java.util.ArrayList;
import java.util.Calendar;
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
import com.founder.rhip.ehr.entity.report.RpHealthRecord;
import com.founder.rhip.ehr.repository.basic.IModifyTraceDao;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.basic.IPopulaceDao;
import com.founder.rhip.ehr.repository.report.IRpHealthRecordDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IStaffDao;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("rpHealthRecordService")
@TaskBean(description = "星级统计数据")
public class RpHealthRecordServiceImpl extends AbstractService implements IRpHealthRecordService, Task {
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "rpHealthRecordDao")
	private IRpHealthRecordDao rpHealthRecordDao;
	
	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;
	
	@Resource(name = "populaceDao")
	private IPopulaceDao populaceDao;
	
	@Resource(name = "modifyTraceDao")
	private IModifyTraceDao modifyTraceDao;
	
	@Resource(name = "mdmStaffDao")
	private IStaffDao mdmStaffDao;
	
	List<RpHealthRecord> updateRpHealthRecords = new ArrayList<RpHealthRecord>();
	List<RpHealthRecord> insertRpHealthRecords = new ArrayList<RpHealthRecord>();
	private static final String FORMATER = "yyyy/MM/dd";

	@Override
	public void run(Map<String, Object> data) {
		String date = String.valueOf(data.get("jobDataCustomParamKey"));
		insertHealthRecordStatistics(date);
		insertModifyTraceStatistics(date);
		insertStaffStatistics(date);
	}
	
	@Override
	public void insertHealthRecordStatistics(String dateStr) {
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, FORMATER);
		} else {
			dateStr = DateUtil.getDateTime(FORMATER, date);
		}
		
		this.insertPersonInfo(dateStr, date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		this.insertPopulace(String.valueOf(calendar.get(Calendar.YEAR)), date);
	}
	
	@Override
	public void insertModifyTraceStatistics(String dateStr) {
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, FORMATER);
		} else {
			dateStr = DateUtil.getDateTime(FORMATER, date);
		}
		updateRpHealthRecords = new ArrayList<RpHealthRecord>();
		insertRpHealthRecords = new ArrayList<RpHealthRecord>();
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = modifyTraceDao.getModifyTraceStatistics(dateStr);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpHealthRecord rpHealthRecord = new RpHealthRecord();
			rpHealthRecord.setOrganCode(String.valueOf(temp.get("input_org_code")));
			rpHealthRecord.setRpDate(date);
			rpHealthRecord.setRpType("1");
			Organization organization = organizationApp.queryOrgan(rpHealthRecord.getOrganCode());
			if(ObjectUtil.isNullOrEmpty(organization)) {
				continue;
			}
			this.setValueForRpHealthRecordAboutOrg(organization, rpHealthRecord);
			
			rpHealthRecord.setModifyNum(Long.valueOf(String.valueOf(temp.get("modify_num"))));
			this.addRpHealthRecord(rpHealthRecord);
		}
		rpHealthRecordDao.batchInsert(insertRpHealthRecords);
		rpHealthRecordDao.batchUpdate(updateRpHealthRecords,new String ("modifyNum"));
	}

	@Override
	public void insertStaffStatistics(String dateStr) {
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, FORMATER);
		} else {
			dateStr = DateUtil.getDateTime(FORMATER, date);
		}
		updateRpHealthRecords = new ArrayList<RpHealthRecord>();
		insertRpHealthRecords = new ArrayList<RpHealthRecord>();
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = mdmStaffDao.getStaffNumByOrg(null);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpHealthRecord rpHealthRecord = new RpHealthRecord();
			rpHealthRecord.setOrganCode(String.valueOf(temp.get("orgCode")));
			rpHealthRecord.setRpDate(date);
			rpHealthRecord.setRpType("1");
			Organization organization = organizationApp.queryOrgan(rpHealthRecord.getOrganCode());
			if(ObjectUtil.isNullOrEmpty(organization)) {
				continue;
			}
			this.setValueForRpHealthRecordAboutOrg(organization, rpHealthRecord);
			rpHealthRecord.setDoctorNum(Long.valueOf(String.valueOf(temp.get("count"))));
			this.addRpHealthRecord(rpHealthRecord);
		}
		rpHealthRecordDao.batchInsert(insertRpHealthRecords);
		rpHealthRecordDao.batchUpdate(updateRpHealthRecords,new String ("doctorNum"));
	}
	
	/**
	 * 插入健康档案的数据
	 * @param dateStr
	 */
	private void insertPopulace(String dateStr, Date date) {
		updateRpHealthRecords = new ArrayList<RpHealthRecord>();
		insertRpHealthRecords = new ArrayList<RpHealthRecord>();
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = populaceDao.getPopulaceStatistics(dateStr);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpHealthRecord rpHealthRecord = new RpHealthRecord();
			RpHealthRecord rpHealthRecordNot = new RpHealthRecord();
			
			rpHealthRecord.setOrganCode(String.valueOf(temp.get("organ_code")));
			rpHealthRecord.setRpDate(date);
			Organization organization = organizationApp.queryOrgan(rpHealthRecord.getOrganCode());
			if(ObjectUtil.isNullOrEmpty(organization)) {
				continue;
			}
			this.setValueForRpHealthRecordAboutOrg(organization, rpHealthRecord);
			
			rpHealthRecordNot.setOrganCode(String.valueOf(temp.get("organ_code")));
			rpHealthRecordNot.setRpDate(new Date());
			this.setValueForRpHealthRecordAboutOrg(organization, rpHealthRecordNot);
			
			rpHealthRecord.setRpType("1");
			rpHealthRecord.setResidentNum(Long.valueOf(String.valueOf(temp.get("household_num"))));
			rpHealthRecord.setShouldCreateNum(Long.valueOf(String.valueOf(temp.get("household_num"))));
			
			rpHealthRecordNot.setRpType("2");
			rpHealthRecordNot.setResidentNum(Long.valueOf(String.valueOf(temp.get("un_house_hold_num"))));
			rpHealthRecordNot.setShouldCreateNum(Long.valueOf(String.valueOf(temp.get("un_house_hold_num"))));
			
			this.addRpHealthRecord(rpHealthRecord);
			this.addRpHealthRecord(rpHealthRecordNot);
		}
		rpHealthRecordDao.batchInsert(insertRpHealthRecords);
		rpHealthRecordDao.batchUpdate(updateRpHealthRecords,"residentNum","shouldCreateNum");
	}
	
	/**
	 * 插入健康档案的数据
	 * @param dateStr
	 */
	private void insertPersonInfo(String dateStr, Date date) {
		updateRpHealthRecords = new ArrayList<RpHealthRecord>();
		insertRpHealthRecords = new ArrayList<RpHealthRecord>();
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = personInfoDao.getPersonInfoStatistics(dateStr);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpHealthRecord rpHealthRecord = new RpHealthRecord();
			rpHealthRecord.setOrganCode(String.valueOf(temp.get("input_organ_code")));
			rpHealthRecord.setRpDate(date);
			Organization organization = organizationApp.queryOrgan(rpHealthRecord.getOrganCode());
			if(ObjectUtil.isNullOrEmpty(organization)) {
				continue;
			}
			this.setValueForRpHealthRecordAboutOrg(organization, rpHealthRecord);
			
			rpHealthRecord.setCreateNum(Long.valueOf(String.valueOf(temp.get("household"))));
			rpHealthRecord.setOneStarCompleteNum(Long.valueOf(String.valueOf(temp.get("oneStarCompleteNum"))));
			rpHealthRecord.setOneStarNum(Long.valueOf(String.valueOf(temp.get("oneStarNum"))));
			rpHealthRecord.setTwoStarCompleteNum(Long.valueOf(String.valueOf(temp.get("twoStarCompleteNum"))));
			rpHealthRecord.setTwoStarNum(Long.valueOf(String.valueOf(temp.get("twoStarNum"))));
			rpHealthRecord.setThreeStarCompleteNum(Long.valueOf(String.valueOf(temp.get("threeStarCompleteNum"))));
			rpHealthRecord.setThreeStarNum(Long.valueOf(String.valueOf(temp.get("threeStarNum"))));
			rpHealthRecord.setRpType(String.valueOf(temp.get("HOUSEHOLD_TYPE")));
			this.addRpHealthRecord(rpHealthRecord);
		}
		rpHealthRecordDao.batchInsert(insertRpHealthRecords);
		rpHealthRecordDao.batchUpdate(updateRpHealthRecords,"createNum","oneStarCompleteNum","oneStarNum",
				"twoStarCompleteNum","twoStarNum","threeStarCompleteNum","threeStarNum");
	}
	
	/**
	 * 根据机构code和出院日期检查时更新还是插入
	 * @param orgCode
	 * @param date
	 * @param RpHealthRecord
	 */
	private void addRpHealthRecord(RpHealthRecord rpHealthRecord) {
		Criteria rpCriteria = new Criteria("organCode", rpHealthRecord.getOrganCode());
		rpCriteria.add("rpType", rpHealthRecord.getRpType());
		DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(rpHealthRecord.getRpDate()), DateUtil.makeTimeToZero(rpHealthRecord.getRpDate()));
		RpHealthRecord tempExamination = rpHealthRecordDao.get(rpCriteria);
		if(ObjectUtil.isNullOrEmpty(tempExamination)) {
			insertRpHealthRecords.add(rpHealthRecord);
		} else {
			tempExamination.setCreateNum(rpHealthRecord.getCreateNum());
			tempExamination.setOneStarNum(rpHealthRecord.getOneStarNum());
			tempExamination.setOneStarCompleteNum(rpHealthRecord.getOneStarCompleteNum());
			tempExamination.setTwoStarNum(rpHealthRecord.getTwoStarNum());
			tempExamination.setTwoStarCompleteNum(rpHealthRecord.getTwoStarCompleteNum());
			tempExamination.setThreeStarNum(rpHealthRecord.getThreeStarNum());
			tempExamination.setThreeStarCompleteNum(rpHealthRecord.getThreeStarCompleteNum());
			tempExamination.setShouldCreateNum(rpHealthRecord.getShouldCreateNum());
			tempExamination.setResidentNum(rpHealthRecord.getResidentNum());
			tempExamination.setModifyNum(rpHealthRecord.getModifyNum());
			tempExamination.setDoctorNum(rpHealthRecord.getDoctorNum());
			updateRpHealthRecords.add(tempExamination);
		}
	}

	/**
	 * 为RpHealthRecord对象中和机构相关的属性赋值
	 * @param organization
	 * @param RpHealthRecord
	 */
	private void setValueForRpHealthRecordAboutOrg(Organization organization, RpHealthRecord rpHealthRecord) {
		rpHealthRecord.setGbCode(organization.getGbCode());
		rpHealthRecord.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
		rpHealthRecord.setOrganCode(organization.getOrganCode());
		rpHealthRecord.setOrganType(organization.getGenreCode());
	}

	@Override
	public List<Map<String, Object>> getHealthRecordStatistics(Map<String, String> paramMap) {
		return rpHealthRecordDao.getRpHealthRecordStatistics(paramMap);
	}

	@Override
	public List<Map<String, Object>> getModifyTraceStatistics(Map<String, String> paramMap) {
		return rpHealthRecordDao.getModifyTraceStatistics(paramMap);
	}
	
}
