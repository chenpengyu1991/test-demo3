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
import com.founder.rhip.ehr.entity.report.RpStudyEvent;
import com.founder.rhip.ehr.repository.clinic.IStudyEventDao;
import com.founder.rhip.ehr.repository.report.IRpStudyEventDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("rpStudyEventService")
@TaskBean(cron = "0 0 4 * * ?", description = "检查相关数据")
public class RpStudyEventServiceImpl extends AbstractService implements IRpStudyEventService, Task {
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "rpStudyEventDao")
	private IRpStudyEventDao rpStudyEventDao;
	
	@Resource(name = "studyEventDao")
	private IStudyEventDao studyEventDao;
	
	List<RpStudyEvent> updateRpStudyEvents = new ArrayList<RpStudyEvent>();
	List<RpStudyEvent> insertRpStudyEvents = new ArrayList<RpStudyEvent>();
	private static final String FORMATER = "yyyy/MM/dd";

	@Override
	public void run(Map<String, Object> data) {
		insertStudyEventStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
	}
	/**
	 * 根据机构code和出院日期检查时更新还是插入
	 * @param orgCode
	 * @param date
	 * @param RpStudyEvent
	 */
	private void addRpStudy(String orgCode, Date date, RpStudyEvent rpStudyEvent) {
		Criteria rpCriteria = new Criteria("organCode", orgCode);
		DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToMax(date), DateUtil.makeTimeToMax(date));
		rpCriteria.add("study_code", rpStudyEvent.getStudyCode());
		RpStudyEvent tempStudy = rpStudyEventDao.get(rpCriteria);
		if(ObjectUtil.isNullOrEmpty(tempStudy)) {
			insertRpStudyEvents.add(rpStudyEvent);
		} else {
			tempStudy.setDoctorNum(rpStudyEvent.getDoctorNum());
			tempStudy.setStudyNum(rpStudyEvent.getStudyNum());
			updateRpStudyEvents.add(tempStudy);
		}
	}

	/**
	 * 为RpStudyEvent对象中和机构相关的属性赋值
	 * @param organization
	 * @param RpStudyEvent
	 */
	private void setValueForRpStudyEventAboutOrg(Organization organization, RpStudyEvent rpStudyEvent) {
		rpStudyEvent.setGbCode(organization.getGbCode());
		rpStudyEvent.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
		rpStudyEvent.setOrganCode(organization.getOrganCode());
		rpStudyEvent.setOrganType(organization.getGenreCode());
	}


	@Override
	public void insertStudyEventStatistics(String dateStr) {
		updateRpStudyEvents = new ArrayList<RpStudyEvent>();
		insertRpStudyEvents = new ArrayList<RpStudyEvent>();
		
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, FORMATER);
		} else {
			dateStr = DateUtil.getDateTime(FORMATER, date);
		}
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = studyEventDao.getStudyInfoStatistics(dateStr);
		
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpStudyEvent rpStudyEvent = new RpStudyEvent();
			Organization organization = organizationApp.queryOrgan(String.valueOf(temp.get("hospital_code")));
			this.setValueForRpStudyEventAboutOrg(organization, rpStudyEvent);
			Date outHospitalDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("audit_date")).replace(".0", ""), FORMATER);
			rpStudyEvent.setRpDate(outHospitalDate);
			rpStudyEvent.setStudyCode(String.valueOf(temp.get("inspection_item_code")));
			rpStudyEvent.setStudyNum((ObjectUtil.isNullOrEmpty(temp.get("study_num"))) ? 0 : Long.valueOf(String.valueOf(temp.get("study_num"))));
			this.addRpStudy(organization.getOrganCode(), outHospitalDate, rpStudyEvent);
		}
		rpStudyEventDao.batchInsert(insertRpStudyEvents);
		rpStudyEventDao.batchUpdate(updateRpStudyEvents,"studyNum");
	}


	@Override
	public List<RpStudyEvent> getStudyEventStatistics(Map<String, String> paramMap) {
		return rpStudyEventDao.getStudyEventStatistics(paramMap);
	}
	
	public static void main(String args[]) {
		String str = "a%%eedfasf%1$s";
		String test = String.format(str, "123");
		System.out.println(test);
	}
	
}
