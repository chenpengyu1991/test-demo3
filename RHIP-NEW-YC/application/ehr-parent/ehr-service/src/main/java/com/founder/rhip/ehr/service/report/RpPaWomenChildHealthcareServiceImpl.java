package com.founder.rhip.ehr.service.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpPaWomenChildHealthcare;
import com.founder.rhip.ehr.repository.child.IChildHealthExaminationDao;
import com.founder.rhip.ehr.repository.report.IRpPaWomenChildHealthcareDao;
import com.founder.rhip.ehr.repository.women.IMotherhoodPeriodFollowupDao;
import com.founder.rhip.ehr.repository.women.IPremaritalHealthServiceDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpPaWomenChildHealthcareService")
@TaskBean(cron = "0 0 4 * * ?", description = "妇幼保健工作量定时任务")
public class RpPaWomenChildHealthcareServiceImpl extends RpBaseService implements
		IRpPaWomenChildHealthcareService,Task {
	
	@Resource(name = "motherhoodPeriodFollowupDao")
	private IMotherhoodPeriodFollowupDao motherhoodPeriodFollowupDao;
	
	@Resource(name = "premaritalHealthServiceDao")
	private IPremaritalHealthServiceDao premaritalHealthServiceDao;
	
	@Resource(name = "childHealthExaminationDao")
	private IChildHealthExaminationDao childHealthExaminationDao;
	
	@Resource(name = "rpPaWomenChildHealthcareDao")
	private IRpPaWomenChildHealthcareDao rpPaWomenChildHealthcareDao;

	@Override
	public void saveWomenChildHealthcareWorkload(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			Date date = DateUtil.getBeforeDay(new Date(), 1);
			dateStr = DateUtil.convertDateToString(date);
		}
		// 儿童保健工作量统计
		List<Map<String, Object>> mapList = childHealthExaminationDao.getChildCareWorkLoad(dateStr);
		if (ObjectUtil.isNotEmpty(mapList)) {
			for (Map<String, Object> map : mapList) {
				Object organCode = null;
				Object rpDate = null;
				Object doctorCode = null;
				Object doctorIdcard = null;
				Object childNum = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(doctorCode = map.get("doctorCode")) 
						|| ObjectUtil.isNullOrEmpty(doctorIdcard = map.get("doctorIdcard"))
						|| ObjectUtil.isNullOrEmpty(childNum = map.get("childNum"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode).add("doctorIdcard", doctorIdcard);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
				RpPaWomenChildHealthcare pach = rpPaWomenChildHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(pach)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
					RpPaWomenChildHealthcare rpPaWomenChildHealthcare = new RpPaWomenChildHealthcare();
					setRpOrganization(new ConvertingWrapDynaBean(rpPaWomenChildHealthcare), organization);
					rpPaWomenChildHealthcare.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
					rpPaWomenChildHealthcare.setDoctorCode(ObjectUtil.isNullOrEmpty(doctorCode) ? null : String.valueOf(doctorCode));
					rpPaWomenChildHealthcare.setDoctorIdcard(ObjectUtil.isNullOrEmpty(doctorIdcard) ? null : String.valueOf(doctorIdcard));
					rpPaWomenChildHealthcare.setChildNum(ObjectUtil.isNullOrEmpty(childNum) ? null : Long.valueOf(String.valueOf(childNum)));
					rpPaWomenChildHealthcare.setDoctorName(ObjectUtil.isNullOrEmpty(map.get("doctorName")) ? null : String.valueOf(map.get("doctorName")));
					rpPaWomenChildHealthcareDao.insert(rpPaWomenChildHealthcare);
				} else {
					rpPaWomenChildHealthcareDao.update(new Parameters("childNum", childNum), new Criteria("id", pach.getId()));
				}
			}
		}
		// 孕产妇保健数
		List<Map<String, Object>> pregnantWomenMapList = motherhoodPeriodFollowupDao.getMotherhoodPeriodFollowupWorkloadMapList(dateStr);
		if (ObjectUtil.isNotEmpty(pregnantWomenMapList)) {
			for (Map<String, Object> map : pregnantWomenMapList) {
				Object organCode = null;
				Object rpDate = null;
				Object doctorCode = null;
				Object doctorIdcard = null;
				Object pregnantWomenNum = null;
				if (ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(doctorCode = map.get("doctorCode"))
						|| ObjectUtil.isNullOrEmpty(doctorIdcard = map.get("doctorIdcard"))
						|| ObjectUtil.isNullOrEmpty(pregnantWomenNum = map.get("pregnantWomenNum"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode).add("doctorIdcard", doctorIdcard);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
				RpPaWomenChildHealthcare pach = rpPaWomenChildHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(pach)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
					RpPaWomenChildHealthcare rpPaWomenChildHealthcare = new RpPaWomenChildHealthcare();
					setRpOrganization(new ConvertingWrapDynaBean(rpPaWomenChildHealthcare), organization);
					rpPaWomenChildHealthcare.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
					rpPaWomenChildHealthcare.setDoctorCode(ObjectUtil.isNullOrEmpty(doctorCode) ? null : String.valueOf(doctorCode));
					rpPaWomenChildHealthcare.setDoctorIdcard(ObjectUtil.isNullOrEmpty(doctorIdcard) ? null : String.valueOf(doctorIdcard));
					rpPaWomenChildHealthcare.setPregnantWomenNum(ObjectUtil.isNullOrEmpty(pregnantWomenNum) ? null : Long.valueOf(String.valueOf(pregnantWomenNum)));
					rpPaWomenChildHealthcare.setDoctorName(ObjectUtil.isNullOrEmpty(map.get("doctorName")) ? null : String.valueOf(map.get("doctorName")));
					rpPaWomenChildHealthcareDao.insert(rpPaWomenChildHealthcare);
				} else {
					rpPaWomenChildHealthcareDao.update(new Parameters("pregnantWomenNum", pregnantWomenNum), new Criteria("id", pach.getId()));
				}
	
			}
		}
		// 育龄妇女保健数
		List<Map<String, Object>> gestationalWomenMapList = premaritalHealthServiceDao.getPremaritalHealthServiceWorkloadMapList(dateStr);
		if (ObjectUtil.isNotEmpty(gestationalWomenMapList)) {
			for (Map<String, Object> map : gestationalWomenMapList) {
				Object organCode = null;
				Object rpDate = null;
				Object doctorCode = null;
				Object doctorIdcard = null;
				Object gestationalWomenNum = null;
				if (ObjectUtil.isNullOrEmpty(organCode = map.get("create_organ_code"))
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(doctorCode = map.get("check_job_number"))
						|| ObjectUtil.isNullOrEmpty(doctorIdcard = map.get("check_idcard"))
						|| ObjectUtil.isNullOrEmpty(gestationalWomenNum = map.get("gestationalWomenNum"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode).add("doctorIdcard", doctorIdcard);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
				RpPaWomenChildHealthcare pach = rpPaWomenChildHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(pach)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
					RpPaWomenChildHealthcare rpPaWomenChildHealthcare = new RpPaWomenChildHealthcare();
					setRpOrganization(new ConvertingWrapDynaBean(rpPaWomenChildHealthcare), organization);
					rpPaWomenChildHealthcare.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
					rpPaWomenChildHealthcare.setDoctorCode(ObjectUtil.isNullOrEmpty(doctorCode) ? null : String.valueOf(doctorCode));
					rpPaWomenChildHealthcare.setDoctorIdcard(ObjectUtil.isNullOrEmpty(doctorIdcard) ? null : String.valueOf(doctorIdcard));
					rpPaWomenChildHealthcare.setGestationalWomenNum(ObjectUtil.isNullOrEmpty(gestationalWomenNum) ? null : Long.valueOf(String.valueOf(gestationalWomenNum)));
					rpPaWomenChildHealthcare.setDoctorName(ObjectUtil.isNullOrEmpty(map.get("doctorName")) ? null : String.valueOf(map.get("doctorName")));
					rpPaWomenChildHealthcareDao.insert(rpPaWomenChildHealthcare);
				} else {
					rpPaWomenChildHealthcareDao.update(new Parameters("gestationalWomenNum", gestationalWomenNum), new Criteria("id", pach.getId()));
				}
	
			}
		}
		// 男女婚检统计
		List<Map<String, Object>> femaleAndMalePremaritalMapList = premaritalHealthServiceDao.getFemaleAndMalePremaritalWorkloadMapList(dateStr);
		if (ObjectUtil.isNotEmpty(femaleAndMalePremaritalMapList)) {
			for (Map<String, Object> map : femaleAndMalePremaritalMapList) {
				Object organCode = null;
				Object rpDate = null;
				Object doctorCode = null;
				Object doctorIdcard = null;
				if (ObjectUtil.isNullOrEmpty(organCode = map.get("create_organ_code"))
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(doctorCode = map.get("check_job_number"))
						|| ObjectUtil.isNullOrEmpty(doctorIdcard = map.get("check_idcard"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode).add("doctorIdcard", doctorIdcard);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
				RpPaWomenChildHealthcare pach = rpPaWomenChildHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(pach)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
					RpPaWomenChildHealthcare rpPaWomenChildHealthcare = new RpPaWomenChildHealthcare();
					setRpOrganization(new ConvertingWrapDynaBean(rpPaWomenChildHealthcare), organization);
					rpPaWomenChildHealthcare.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
					rpPaWomenChildHealthcare.setDoctorCode(ObjectUtil.isNullOrEmpty(doctorCode) ? null : String.valueOf(doctorCode));
					rpPaWomenChildHealthcare.setDoctorIdcard(ObjectUtil.isNullOrEmpty(doctorIdcard) ? null : String.valueOf(doctorIdcard));
					rpPaWomenChildHealthcare.setMalePremaritalNum(ObjectUtil.isNullOrEmpty(map.get("male_premarital_num")) ? null : Long.valueOf(String.valueOf(map.get("male_premarital_num"))));
					rpPaWomenChildHealthcare.setFemalePremaritalNum(ObjectUtil.isNullOrEmpty(map.get("femalePremaritalNum")) ? null : Long.valueOf(String.valueOf(map.get("femalePremaritalNum"))));
					rpPaWomenChildHealthcare.setPremaritalNum(ObjectUtil.isNullOrEmpty(map.get("premarital_num")) ? null : Long.valueOf(String.valueOf(map.get("premarital_num"))));
					rpPaWomenChildHealthcare.setDoctorName(ObjectUtil.isNullOrEmpty(map.get("doctorName")) ? null : String.valueOf(map.get("doctorName")));
					rpPaWomenChildHealthcareDao.insert(rpPaWomenChildHealthcare);
				} else {
					Parameters parameters = new Parameters("femalePremaritalNum", map.get("femalePremaritalNum")).add("male_premarital_num", map.get("male_premarital_num")).add("premarital_num", map.get("premarital_num"));
					rpPaWomenChildHealthcareDao.update(parameters, new Criteria("id", pach.getId()));
				}
	
			}
		}
	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		saveWomenChildHealthcareWorkload(dateStr);
	}

	@Override
	public PageList<Map<String, Object>> getPaWomenChildHealthcarePageList(
			Map<String, String> paramMap, Page page) {
		if (ObjectUtil.isNullOrEmpty(paramMap) || ObjectUtil.isNullOrEmpty(page)) {
			return null;
		}
		Criteria criteria = organizeCriteria(paramMap);
		return rpPaWomenChildHealthcareDao.getPaWomenChildHealthcarePageList(criteria, page);
	}

}
