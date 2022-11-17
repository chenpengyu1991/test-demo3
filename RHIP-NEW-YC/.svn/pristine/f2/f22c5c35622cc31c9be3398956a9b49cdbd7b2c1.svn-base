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
import com.founder.rhip.ehr.entity.report.RpPaVaccination;
import com.founder.rhip.ehr.entity.report.RpPaWomenChildHealthcare;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.report.IRpPaVaccinationDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpPaVaccinationService")
@TaskBean(cron = "0 0 4 * * ?", description = "接种疫苗工作量定时任务")
public class RpPaVaccinationServiceImpl extends RpBaseService implements
		IRpPaVaccinationService,Task {

	@Resource(name = "rpPaVaccinationDao")
	private IRpPaVaccinationDao rpPaVaccinationDao;
	
	@Resource(name = "vaccinationInfoDao")
	private IVaccinationInfoDao vaccinationInfoDao;
	
	@Override
	public void savePaVaccinationStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			Date date = DateUtil.getBeforeDay(new Date(), 1);
			dateStr = DateUtil.convertDateToString(date);
		}
		List<Map<String, Object>> vaccinationMapList = vaccinationInfoDao.getVaccinationInfoMapList(dateStr);
		if (ObjectUtil.isNotEmpty(vaccinationMapList)) {
			for (Map<String, Object> map : vaccinationMapList) {
				Object organCode = null;
				Object rpDate = null;
				Object doctorCode = null;
				Object doctorIdcard = null;
				Object vaccinationNum = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("vaccination_unit_code"))
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(doctorCode = map.get("vaccination_doctor_code")) 
						|| ObjectUtil.isNullOrEmpty(doctorIdcard = map.get("vaccination_doctor_idcard"))
						|| ObjectUtil.isNullOrEmpty(vaccinationNum = map.get("vaccination_num"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode).add("doctorIdcard", doctorIdcard);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));
				RpPaVaccination rpv = rpPaVaccinationDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rpv)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
					RpPaVaccination rpPaVaccination = new RpPaVaccination();
					setRpOrganization(new ConvertingWrapDynaBean(rpPaVaccination), organization);
					rpPaVaccination.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
					rpPaVaccination.setDoctorCode(String.valueOf(doctorCode));
					rpPaVaccination.setDoctorIdcard(String.valueOf(doctorIdcard));
					rpPaVaccination.setVaccinationNum(Long.valueOf(String.valueOf(vaccinationNum)));
					rpPaVaccinationDao.insert(rpPaVaccination);
				} else {
					rpPaVaccinationDao.update(new Parameters("vaccinationNum", vaccinationNum), new Criteria("id", rpv.getId()));
				}
			
			}
		}

	}

	@Override
	public PageList<Map<String, Object>> getPaVaccinationPageList(
			Map<String, String> paramMap, Page page) {
		if (ObjectUtil.isNullOrEmpty(paramMap) || ObjectUtil.isNullOrEmpty(page)) {
			return null;
		}
		Criteria criteria = organizeCriteria(paramMap);
		return rpPaVaccinationDao.getPaVaccinationPageList(criteria, page);
	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		savePaVaccinationStatistics(dateStr);
	}

}
