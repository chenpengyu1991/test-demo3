package com.founder.rhip.ehr.service.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpPremaritalExamination;
import com.founder.rhip.ehr.repository.report.IRpPremaritalExaminationDao;
import com.founder.rhip.ehr.repository.women.IPremaritalHealthServiceDao;
import com.founder.rhip.ehr.repository.women.IWomanDiseaseCensusDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpPremaritalExaminationService")
@TaskBean(cron = "0 0 5 * * ?", description = "男女婚检统计定时任务")
public class RpPremaritalExaminationServiceImpl extends RpBaseService implements
		IRpPremaritalExaminationService,Task {
	
	@Resource(name = "premaritalHealthServiceDao")
	private IPremaritalHealthServiceDao premaritalHealthServiceDao;
	
	@Resource(name = "womanDiseaseCensusDao")
	private IWomanDiseaseCensusDao womanDiseaseCensusDao;
	
	@Resource(name = "rpPremaritalExaminationDao")
	private IRpPremaritalExaminationDao rpPremaritalExaminationDao;

	@Override
	public void savePremaritalExaminationStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			Date date = DateUtil.getBeforeDay(new Date(), 1);
			dateStr = DateUtil.convertDateToString(date);
		}
		// 各机构下面医务人员数量
		Map<String,Long> staffCountMap = mdmStaffService.getStaffNumByOrg(null);
		// 育龄妇女登记
		List<Map<String, Object>> regMapList = premaritalHealthServiceDao.getPremaritalHealthServiceMapList(dateStr);
		if (ObjectUtil.isNotEmpty(regMapList)) {
			for (Map<String, Object> map : regMapList) {
				Object organCode = null;
				Object rpDate = null;
				Object gestationalWomenNum = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("create_organ_code")) 
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(gestationalWomenNum = map.get("gestational_women_num"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
				RpPremaritalExamination pe = rpPremaritalExaminationDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(pe)) {
					RpPremaritalExamination rpPremaritalExamination = setrpPremaritalExamination(String.valueOf(organCode), String.valueOf(rpDate), staffCountMap);
					if (ObjectUtil.isNotEmpty(rpPremaritalExamination)) {
						rpPremaritalExamination.setGestationalWomenNum(Long.valueOf(String.valueOf(gestationalWomenNum)));
						rpPremaritalExaminationDao.insert(rpPremaritalExamination);
					}
				} else {
					rpPremaritalExaminationDao.update(new Parameters("gestationalWomenNum", gestationalWomenNum), new Criteria("id", pe.getId()));
				}
			}
		}
		// 妇女疾病筛查
		List<Map<String, Object>> diseaseCensusMapList = womanDiseaseCensusDao.getWomanDiseaseCensusMapList(dateStr);
		if (ObjectUtil.isNotEmpty(diseaseCensusMapList)) {
			for (Map<String, Object> map : diseaseCensusMapList) {
				Object organCode = null;
				Object rpDate = null;
				Object screeningWomenNum = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("organCode")) 
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(screeningWomenNum = map.get("SCREENING_WOMEN_NUM"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
				RpPremaritalExamination pe = rpPremaritalExaminationDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(pe)) {
					RpPremaritalExamination rpPremaritalExamination = setrpPremaritalExamination(String.valueOf(organCode), String.valueOf(rpDate), staffCountMap);
					if (ObjectUtil.isNotEmpty(rpPremaritalExamination)) {
						rpPremaritalExamination.setScreeningWomenNum(Long.valueOf(String.valueOf(screeningWomenNum)));
						rpPremaritalExaminationDao.insert(rpPremaritalExamination);
					}
				} else {
					rpPremaritalExaminationDao.update(new Parameters("screeningWomenNum", screeningWomenNum), new Criteria("id", pe.getId()));
				}

			}
		}
		// 男女婚检统计
		List<Map<String, Object>> fmPremaritalMapList = premaritalHealthServiceDao.getFemaleAndMalePremaritalMapList(dateStr);
		if (ObjectUtil.isNotEmpty(fmPremaritalMapList)) {
			for (Map<String, Object> map : fmPremaritalMapList) {
				Object organCode = null;
				Object rpDate = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("create_organ_code")) 
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
				RpPremaritalExamination pe = rpPremaritalExaminationDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(pe)) {
					RpPremaritalExamination rpPremaritalExamination = setrpPremaritalExamination(String.valueOf(organCode), String.valueOf(rpDate), staffCountMap);
					if (ObjectUtil.isNotEmpty(rpPremaritalExamination)) {
						rpPremaritalExamination.setFemalePremaritalNum(ObjectUtil.isNullOrEmpty(map.get("female_premarital_num")) ? null : Long.valueOf(String.valueOf(map.get("female_premarital_num"))));
						rpPremaritalExamination.setMalePremaritalNum(ObjectUtil.isNullOrEmpty(map.get("male_premarital_num")) ? null : Long.valueOf(String.valueOf(map.get("male_premarital_num"))));
						rpPremaritalExamination.setPremaritalNum(ObjectUtil.isNullOrEmpty(map.get("premarital_num")) ? null : Long.valueOf(String.valueOf(map.get("premarital_num"))));
						rpPremaritalExaminationDao.insert(rpPremaritalExamination);
					}
				} else {
					Parameters parameters = new Parameters("femalePremaritalNum", map.get("female_premarital_num"))
										.add("malePremaritalNum", map.get("male_premarital_num"))
										.add("premaritalNum", map.get("premarital_num"));
					rpPremaritalExaminationDao.update(parameters, new Criteria("id", pe.getId()));
				}

			}
		}
	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		savePremaritalExaminationStatistics(dateStr);
		
	}
	
	private RpPremaritalExamination setrpPremaritalExamination(String organCode, String rpDate, Map<String,Long> staffCountMap) {
		if (ObjectUtil.isNullOrEmpty(organCode)) {
			return null;
		}
		RpPremaritalExamination rpPremaritalExamination = new RpPremaritalExamination();
		Organization organization = organizationApp.queryOrgan(organCode);
		setRpOrganization(new ConvertingWrapDynaBean(rpPremaritalExamination), organization);
		rpPremaritalExamination.setDoctorNum(staffCountMap.get(organCode));
		rpPremaritalExamination.setRpDate(DateUtil.parseDateString(rpDate));
		return rpPremaritalExamination;
	}

	@Override
	public List<Map<String, Object>> getPremaritalExaminationMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		mapList = rpPremaritalExaminationDao.getPremaritalExaminationMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
		return destMapList;
	}

	/**
	 * 儿童保健服务绩效考核
	 * @param paramMap
	 * @return
	 */
	@Override
	public List<Map<String, Object>> getPremaritalPerformanceOrg(Map<String, String> paramMap) {
		return rpPremaritalExaminationDao.getPremaritalPerformanceOrg(paramMap);
	}
}
