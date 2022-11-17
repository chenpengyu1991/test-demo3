package com.founder.rhip.ehr.service.report;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.ConvertingWrapDynaBean;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpPhysicalExamination;
import com.founder.rhip.ehr.repository.clinic.IHealthExaminationDao;
import com.founder.rhip.ehr.repository.report.IRpPhysicalExaminationDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpPhysicalExaminationService")
@TaskBean(cron = "0 0 4 * * ?", description = "机构体检工作量定时任务")
public class RpPhysicalExaminationServiceImpl extends RpBaseService implements
		IRpPhysicalExaminationService,Task {
	
	@Resource(name = "healthExaminationDao")
	private IHealthExaminationDao healthExaminationDao;
	
	@Resource(name = "rpPhysicalExaminationDao")
	private IRpPhysicalExaminationDao rpPhysicalExaminationDao;

	@Override
	public void savePhysicalExaminationPaStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			Date date = DateUtil.getBeforeDay(new Date(), 1);
			dateStr = DateUtil.convertDateToString(date);
		}
		List<Map<String, Object>> healthExaminationMapList = healthExaminationDao.getHealthExaminationMapList(dateStr);
		if (ObjectUtil.isNotEmpty(healthExaminationMapList)) {
			for (Map<String, Object> map : healthExaminationMapList) {
				Object organCode = null;
				Object rpDate = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("hospital_code"))
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("RPDATE"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
				RpPhysicalExamination rpe = rpPhysicalExaminationDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rpe)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
					RpPhysicalExamination rpPhysicalExamination = new RpPhysicalExamination();
					setRpOrganization(new ConvertingWrapDynaBean(rpPhysicalExamination), organization);
					rpPhysicalExamination.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
					rpPhysicalExamination.setCommercialExamineNum(ObjectUtil.isNullOrEmpty(map.get("commercial_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("commercial_examine_num"))));
					rpPhysicalExamination.setOldExamineNum(ObjectUtil.isNullOrEmpty(map.get("old_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("old_examine_num"))));
					rpPhysicalExamination.setStudentExamineNum(ObjectUtil.isNullOrEmpty(map.get("student_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("student_examine_num"))));
					rpPhysicalExamination.setWomenExamineNum(ObjectUtil.isNullOrEmpty(map.get("women_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("women_examine_num"))));
					rpPhysicalExamination.setStudentExamineNum(ObjectUtil.isNullOrEmpty(map.get("student_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("student_examine_num"))));
					rpPhysicalExamination.setOccupationExamineNum(ObjectUtil.isNullOrEmpty(map.get("occupation_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("occupation_examine_num"))));
					rpPhysicalExamination.setChronicDiseaseExamineNum(ObjectUtil.isNullOrEmpty(map.get("chronic_disease_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("chronic_disease_examine_num"))));
					rpPhysicalExamination.setHealthCertificateExamineNum(ObjectUtil.isNullOrEmpty(map.get("health_certificate_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("health_certificate_examine_num"))));
					rpPhysicalExamination.setChildcareWorkerExamineNum(ObjectUtil.isNullOrEmpty(map.get("childcare_worker_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("childcare_worker_examine_num"))));
					rpPhysicalExamination.setOtherExamineNum(ObjectUtil.isNullOrEmpty(map.get("other_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("other_examine_num"))));
					rpPhysicalExamination.setTotalExamineNum(ObjectUtil.isNullOrEmpty(map.get("total_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("total_examine_num"))));
					rpPhysicalExaminationDao.insert(rpPhysicalExamination);
				} else {
					String[] properties = new String[] {"commercialExamineNum","oldExamineNum","studentExamineNum","womenExamineNum",
							"occupationExamineNum","chronicDiseaseExamineNum","healthCertificateExamineNum","childcareWorkerExamineNum",
							"otherExamineNum","totalExamineNum"};
					rpe.setCommercialExamineNum(ObjectUtil.isNullOrEmpty(map.get("commercial_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("commercial_examine_num"))));
					rpe.setOldExamineNum(ObjectUtil.isNullOrEmpty(map.get("old_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("old_examine_num"))));
					rpe.setStudentExamineNum(ObjectUtil.isNullOrEmpty(map.get("student_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("student_examine_num"))));
					rpe.setWomenExamineNum(ObjectUtil.isNullOrEmpty(map.get("women_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("women_examine_num"))));
					rpe.setStudentExamineNum(ObjectUtil.isNullOrEmpty(map.get("student_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("student_examine_num"))));
					rpe.setOccupationExamineNum(ObjectUtil.isNullOrEmpty(map.get("occupation_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("occupation_examine_num"))));
					rpe.setChronicDiseaseExamineNum(ObjectUtil.isNullOrEmpty(map.get("chronic_disease_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("chronic_disease_examine_num"))));
					rpe.setHealthCertificateExamineNum(ObjectUtil.isNullOrEmpty(map.get("health_certificate_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("health_certificate_examine_num"))));
					rpe.setChildcareWorkerExamineNum(ObjectUtil.isNullOrEmpty(map.get("childcare_worker_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("childcare_worker_examine_num"))));
					rpe.setOtherExamineNum(ObjectUtil.isNullOrEmpty(map.get("other_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("other_examine_num"))));
					rpe.setTotalExamineNum(ObjectUtil.isNullOrEmpty(map.get("total_examine_num")) ? null : Long.valueOf(String.valueOf(map.get("total_examine_num"))));
					rpPhysicalExaminationDao.update(rpe, properties);
				}
			}
		}

	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		savePhysicalExaminationPaStatistics(dateStr);
	}

	@Override
	public List<Map<String, Object>> getPhysicalExaminationMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = rpPhysicalExaminationDao.getPhysicalExaminationMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
		return destMapList;
	}

}
