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
import com.founder.rhip.ehr.entity.report.RpExaminationEvent;
import com.founder.rhip.ehr.repository.clinic.IExamineDetailDao;
import com.founder.rhip.ehr.repository.report.IRpExaminationEventDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

@Service("rpExaminationEventService")
@TaskBean(cron = "0 0 4 * * ?", description = "检查相关数据")
public class RpExaminationEventServiceImpl extends AbstractService implements IRpExaminationEventService, Task {
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;
	
	@Resource(name = "rpExaminationEventDao")
	private IRpExaminationEventDao rpExaminationEventDao;
	
	@Resource(name = "examineDetailDao")
	private IExamineDetailDao examineDetailDao;
	
	List<RpExaminationEvent> updateRpExaminationEvents = new ArrayList<RpExaminationEvent>();
	List<RpExaminationEvent> insertRpExaminationEvents = new ArrayList<RpExaminationEvent>();
	private static final String FORMATER = "yyyy/MM/dd";

	@Override
	public void run(Map<String, Object> data) {
		insertExaminationEventStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
	}
	/**
	 * 根据机构code和出院日期检查时更新还是插入
	 * @param orgCode
	 * @param date
	 * @param RpExaminationEvent
	 */
	private void addRpExamination(RpExaminationEvent rpExaminationEvent) {
		Criteria rpCriteria = new Criteria("organCode", rpExaminationEvent.getOrganCode());
		DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(rpExaminationEvent.getRpDate()), DateUtil.makeTimeToZero(rpExaminationEvent.getRpDate()));
		rpCriteria.add("examination_detail_code", rpExaminationEvent.getExaminationDetailCode());
		RpExaminationEvent tempExamination = rpExaminationEventDao.get(rpCriteria);
		if(ObjectUtil.isNullOrEmpty(tempExamination)) {
			insertRpExaminationEvents.add(rpExaminationEvent);
		} else {
			tempExamination.setExaminationNum(rpExaminationEvent.getExaminationNum());
			tempExamination.setResultHigh(rpExaminationEvent.getResultHigh());
			tempExamination.setResultLow(rpExaminationEvent.getResultLow());
			tempExamination.setResultNormal(rpExaminationEvent.getResultNormal());
			updateRpExaminationEvents.add(tempExamination);
		}
	}

	/**
	 * 为RpExaminationEvent对象中和机构相关的属性赋值
	 * @param organization
	 * @param RpExaminationEvent
	 */
	private void setValueForRpExaminationEventAboutOrg(Organization organization, RpExaminationEvent rpExaminationEvent) {
		rpExaminationEvent.setGbCode(organization.getGbCode());
		rpExaminationEvent.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
		rpExaminationEvent.setOrganCode(organization.getOrganCode());
		rpExaminationEvent.setOrganType(organization.getGenreCode());
	}


	@Override
	public void insertExaminationEventStatistics(String dateStr) {
		updateRpExaminationEvents = new ArrayList<RpExaminationEvent>();
		insertRpExaminationEvents = new ArrayList<RpExaminationEvent>();
		
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);;
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, FORMATER);
		} else {
			dateStr = DateUtil.getDateTime(FORMATER, date);
		}
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = examineDetailDao.getExamineDetailStatistics(dateStr);
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpExaminationEvent rpExaminationEvent = new RpExaminationEvent();
			String upHosCode = String.valueOf(temp.get("up_hos_code"));
			String downHosCode = String.valueOf(temp.get("down_hos_code"));
			String nomalHosCode = String.valueOf(temp.get("nomal_hos_code"));
			Date rpDate = null;
			if(ObjectUtil.isNotEmpty(temp.get("up_hos_code"))){
				rpExaminationEvent.setOrganCode(upHosCode);
				rpExaminationEvent.setExaminationDetailCode(String.valueOf(temp.get("up_ins_code")));
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("up_check_date")).replace(".0", ""), FORMATER);
				rpExaminationEvent.setRpDate(rpDate);
			} else if(ObjectUtil.isNotEmpty(temp.get("down_hos_code"))) {
				rpExaminationEvent.setOrganCode(downHosCode);
				rpExaminationEvent.setExaminationDetailCode(String.valueOf(temp.get("down_ins_code")));
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("down_check_date")).replace(".0", ""), FORMATER);
				rpExaminationEvent.setRpDate(rpDate);
			} else if(ObjectUtil.isNotEmpty(temp.get("nomal_hos_code"))) {
				rpExaminationEvent.setOrganCode(nomalHosCode);
				rpExaminationEvent.setExaminationDetailCode(String.valueOf(temp.get("nomal_ins_code")));
				rpDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("nomal_check_date")).replace(".0", ""), FORMATER);
				rpExaminationEvent.setRpDate(rpDate);
			}
			Organization organization = organizationApp.queryOrgan(rpExaminationEvent.getOrganCode());
			this.setValueForRpExaminationEventAboutOrg(organization, rpExaminationEvent);
			rpExaminationEvent.setResultHigh((ObjectUtil.isNullOrEmpty(temp.get("count_up"))) ? 0 : Long.valueOf(String.valueOf(temp.get("count_up"))));
			rpExaminationEvent.setResultLow((ObjectUtil.isNullOrEmpty(temp.get("count_down"))) ? 0 : Long.valueOf(String.valueOf(temp.get("count_down"))));
			rpExaminationEvent.setResultNormal((ObjectUtil.isNullOrEmpty(temp.get("count_nomal"))) ? 0 : Long.valueOf(String.valueOf(temp.get("count_nomal"))));
			rpExaminationEvent.setExaminationNum((ObjectUtil.isNullOrEmpty(temp.get("allc"))) ? 0 : Long.valueOf(String.valueOf(temp.get("allc"))));
			this.addRpExamination(rpExaminationEvent);
		}
		rpExaminationEventDao.batchInsert(insertRpExaminationEvents);
		rpExaminationEventDao.batchUpdate(updateRpExaminationEvents,"resultLow","resultHigh","resultNormal","examinationNum");
	}


	@Override
	public List<Map<String, Object>> getExaminationEventStatistics(Map<String, String> paramMap) {
		return rpExaminationEventDao.getExaminationEventStatistics(paramMap);
	}
	
}
