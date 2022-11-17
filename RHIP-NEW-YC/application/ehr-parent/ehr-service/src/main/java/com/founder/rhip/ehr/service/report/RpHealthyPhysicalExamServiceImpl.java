package com.founder.rhip.ehr.service.report;

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
import com.founder.rhip.ehr.entity.report.RpHealthyPhysicalExam;
import com.founder.rhip.ehr.repository.clinic.IExamineEventDao;
import com.founder.rhip.ehr.repository.clinic.IStudyEventDao;
import com.founder.rhip.ehr.repository.report.IRpHealthyPhysicalExamDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpHealthyPhysicalExamService")
@TaskBean(cron = "0 0 5 * * ?", description = "居民健康体检绩效考核指标")
public class RpHealthyPhysicalExamServiceImpl extends RpBaseService implements
		IRpHealthyPhysicalExamService,Task {
	
	@Resource(name = "studyEventDao")
	private IStudyEventDao studyEventDao;
	
	@Resource(name = "examineEventDao")
	private IExamineEventDao examineEventDao;
	
	@Resource(name = "rpHealthyPhysicalExamDao")
	private IRpHealthyPhysicalExamDao rpHealthyPhysicalExamDao;

	@Override
	public void saveHealhyPhysicalExamPaStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			Date date = DateUtil.getBeforeDay(new Date(), 1);
			dateStr = DateUtil.convertDateToString(date);
		}

		// B超、心电图
		List<Map<String, Object>> studyEventPaMapList = studyEventDao.getStudyEventMapList(dateStr);
		saveExaminationItemStatistics(studyEventPaMapList);
		
		
		// 尿常规、血常规
		List<Map<String, Object>> examinePaMapList = examineEventDao.getExamineEventMapList(dateStr);
		saveExaminationItemStatistics(examinePaMapList);
	}
	
	/**
	 * 保存体检项目统计结果
	 * @param mapList
	 */
	private void saveExaminationItemStatistics(List<Map<String, Object>> mapList) {
		if (ObjectUtil.isNullOrEmpty(mapList)) {
			return;
		}

		for (Map<String, Object> map : mapList) {
			Object organCode = null;
			Object rpDate = null;
			Object examinationCode = null;
			Object examinationNum = null;
			if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("hospital_code"))
					|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
					|| ObjectUtil.isNullOrEmpty(examinationCode = map.get("examination_code"))
					|| ObjectUtil.isNullOrEmpty(examinationNum = map.get("examination_num"))) {
				continue;
			}
			Criteria rpCriteria = new Criteria("organCode", organCode).add("examinationCode", examinationCode);
			DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
			RpHealthyPhysicalExam rpe = rpHealthyPhysicalExamDao.get(rpCriteria);
			if (ObjectUtil.isNullOrEmpty(rpe)) {
				Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
				RpHealthyPhysicalExam rpHealthyPhysicalExam = new RpHealthyPhysicalExam();
				setRpOrganization(new ConvertingWrapDynaBean(rpHealthyPhysicalExam), organization);
				rpHealthyPhysicalExam.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
				rpHealthyPhysicalExam.setExaminationCode(String.valueOf(examinationCode));
				rpHealthyPhysicalExam.setExaminationNum(Long.valueOf(String.valueOf(examinationNum)));
				rpHealthyPhysicalExamDao.insert(rpHealthyPhysicalExam);
			} else {
				rpHealthyPhysicalExamDao.update(new Parameters("examinationNum", examinationNum), new Criteria("id", rpe.getId()));
			}
		}
	
	}

	@Override
	public List<Map<String, Object>> getHealthyPhysicalExamMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = rpHealthyPhysicalExamDao.getHealthyPhysicalExamMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
		return destMapList;
	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		saveHealhyPhysicalExamPaStatistics(dateStr);
	}

}
