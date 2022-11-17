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
import com.founder.rhip.ehr.entity.report.RpChildHealthcare;
import com.founder.rhip.ehr.repository.child.IChildHealthExaminationDao;
import com.founder.rhip.ehr.repository.child.INeonatalDiseaseScreenDao;
import com.founder.rhip.ehr.repository.child.INeonatalFamilyVisitDao;
import com.founder.rhip.ehr.repository.report.IRpChildHealthcareDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpChildHealthcareService")
@TaskBean(cron = "0 0 5 * * ?", description = "儿童保健服务报表定时任务")
public class RpChildHealthcareServiceImpl extends RpBaseService implements
		IRpChildHealthcareService,Task {
	
    
    @Resource(name = "neonatalFamilyVisitDao")
    private INeonatalFamilyVisitDao neonatalFamilyVisitDao;
    
    @Resource(name = "neonatalDiseaseScreenDao")
    private INeonatalDiseaseScreenDao neonatalDiseaseScreenDao;
    
    @Resource(name = "childHealthExaminationDao")
    private IChildHealthExaminationDao childHealthExaminationDao;
    
    @Resource(name = "rpChildHealthcareDao")
    private IRpChildHealthcareDao rpChildHealthcareDao;
	
	@Override
	public void saveChildHealthcareStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			Date date = DateUtil.getBeforeDay(new Date(), 1);
			dateStr = DateUtil.convertDateToString(date);
		}
		// 各机构下面医务人员数量
		Map<String,Long> staffCountMap = mdmStaffService.getStaffNumByOrg(null);
		// 新生儿家庭访视
		List<Map<String, Object>> visitMapList = neonatalFamilyVisitDao.getNeonatalFamilyVisitMapList(dateStr);
		if (ObjectUtil.isNotEmpty(visitMapList)) {
			for (Map<String, Object> map : visitMapList) {
				Object organCode = null;
				Object vt = null;
				Object visit_num = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))
						|| ObjectUtil.isNullOrEmpty(vt = map.get("vt"))
						|| ObjectUtil.isNullOrEmpty(visit_num = map.get("visit_num"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(vt))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(vt))));
				RpChildHealthcare rpchc = rpChildHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rpchc)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
					RpChildHealthcare rpChildHealthcare = new RpChildHealthcare();
					setRpOrganization(new ConvertingWrapDynaBean(rpChildHealthcare), organization);
					rpChildHealthcare.setDoctorNum(staffCountMap.get(organCode));
					rpChildHealthcare.setRpDate(DateUtil.parseDateString(String.valueOf(vt)));
					rpChildHealthcare.setNeonatesVisitNum(Long.valueOf(String.valueOf(visit_num)));
					rpChildHealthcare.setHearingScreeningNum(ObjectUtil.isNullOrEmpty(map.get("hs_num")) ? null : Long.valueOf(String.valueOf(map.get("hs_num"))));
					rpChildHealthcareDao.insert(rpChildHealthcare);
				} else {
					Parameters parameters = new Parameters();
					parameters.add("neonatesVisitNum", String.valueOf(visit_num));
					parameters.add("hearingScreeningNum", ObjectUtil.isNullOrEmpty(map.get("hs_num")) ? null : Long.valueOf(String.valueOf(map.get("hs_num"))));
					rpChildHealthcareDao.update(parameters, new Criteria("id", rpchc.getId()));
				}
				
			}
		}
		
		// 疾病筛查
		List<Map<String, Object>> screenMapList = neonatalDiseaseScreenDao.getNeonatalDiseaseScreenMapList(dateStr);
		if (ObjectUtil.isNotEmpty(screenMapList)) {
			for (Map<String, Object> map : screenMapList) {
				Object organCode = null;
				Object dt = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))
						|| ObjectUtil.isNullOrEmpty(dt = map.get("dt"))) {
					continue;
				}
				Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(dt))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(dt))));
				RpChildHealthcare rpchc = rpChildHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rpchc)) {
					RpChildHealthcare rpChildHealthcare = new RpChildHealthcare();
					setRpOrganization(new ConvertingWrapDynaBean(rpChildHealthcare), organization);
					rpChildHealthcare.setRpDate(DateUtil.parseDateString(String.valueOf(dt)));
					rpChildHealthcare.setPkuScreeningNum(ObjectUtil.isNullOrEmpty(map.get("pku_num")) ? null : Long.valueOf(String.valueOf(map.get("pku_num"))));
					rpChildHealthcare.setHypothyroidismScreeningNum(ObjectUtil.isNullOrEmpty(map.get("hy_num")) ? null : Long.valueOf(String.valueOf(map.get("hy_num"))));
					rpChildHealthcare.setDoctorNum(staffCountMap.get(organCode));
					rpChildHealthcareDao.insert(rpChildHealthcare);
				} else {
					Parameters parameters = new Parameters();
					parameters.add("pkuScreeningNum", ObjectUtil.isNullOrEmpty(map.get("pku_num")) ? null : Long.valueOf(String.valueOf(map.get("pku_num"))));
					parameters.add("hypothyroidismScreeningNum", ObjectUtil.isNullOrEmpty(map.get("hy_num")) ? null : Long.valueOf(String.valueOf(map.get("hy_num"))));
					rpChildHealthcareDao.update(parameters, new Criteria("id", rpchc.getId()));
				}

			}
		}
		
		// 儿童体检
		List<Map<String, Object>> childExaminationMapList = childHealthExaminationDao.getChildHealthExaminationMapList(dateStr);
		if (ObjectUtil.isNotEmpty(childExaminationMapList)) {
			for (Map<String, Object> map : childExaminationMapList) {
				Object organCode = null;
				Object dt = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("organCode"))
						|| ObjectUtil.isNullOrEmpty(dt = map.get("rpDate"))) {
					continue;
				}
				Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(dt))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(dt))));
				RpChildHealthcare rpchc = rpChildHealthcareDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rpchc)) {
					RpChildHealthcare rpChildHealthcare = new RpChildHealthcare();
					setRpOrganization(new ConvertingWrapDynaBean(rpChildHealthcare), organization);
					rpChildHealthcare.setRpDate(DateUtil.parseDateString(String.valueOf(dt)));
					rpChildHealthcare.setDoctorNum(staffCountMap.get(organCode));
					rpChildHealthcare.setWeightCheckNum(ObjectUtil.isNullOrEmpty(map.get("weight_num")) ? null : Long.valueOf(String.valueOf(map.get("weight_num"))));
					rpChildHealthcare.setMedianNum(ObjectUtil.isNullOrEmpty(map.get("median_num")) ? null : Long.valueOf(String.valueOf(map.get("median_num"))));
					rpChildHealthcare.setHgbCheckNum(ObjectUtil.isNullOrEmpty(map.get("hgb_check_num")) ? null : Long.valueOf(String.valueOf(map.get("hgb_check_num"))));
					rpChildHealthcare.setSevereAnemiaNum(ObjectUtil.isNullOrEmpty(map.get("severe_anemia_num")) ? null : Long.valueOf(String.valueOf(map.get("severe_anemia_num"))));
					rpChildHealthcareDao.insert(rpChildHealthcare);
				} else {
					String[] properties = new String[] {"weightCheckNum", "medianNum", "hgbCheckNum", "severeAnemiaNum"};
					rpchc.setWeightCheckNum(ObjectUtil.isNullOrEmpty(map.get("weight_num")) ? null : Long.valueOf(String.valueOf(map.get("weight_num"))));
					rpchc.setMedianNum(ObjectUtil.isNullOrEmpty(map.get("median_num")) ? null : Long.valueOf(String.valueOf(map.get("median_num"))));
					rpchc.setHgbCheckNum(ObjectUtil.isNullOrEmpty(map.get("hgb_check_num")) ? null : Long.valueOf(String.valueOf(map.get("hgb_check_num"))));
					rpchc.setSevereAnemiaNum(ObjectUtil.isNullOrEmpty(map.get("severe_anemia_num")) ? null : Long.valueOf(String.valueOf(map.get("severe_anemia_num"))));
					rpChildHealthcareDao.update(rpchc,properties);
				}
			}
		}
		
	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		saveChildHealthcareStatistics(dateStr);
	}

	@Override
	public List<Map<String, Object>> getChildHealthcareStatisticsMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		if (ObjectUtil.isNullOrEmpty(paramMap)) {
			return mapList;
		}
		mapList = rpChildHealthcareDao.getChildHealthcareMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
		return destMapList;
	}

	@Override
	public List<Map<String, Object>> getChildHealthcarePerformanceOrg(Map<String, String> paramMap) {
		return rpChildHealthcareDao.getChildHealthcarePerformanceOrg(paramMap);
	}
}
