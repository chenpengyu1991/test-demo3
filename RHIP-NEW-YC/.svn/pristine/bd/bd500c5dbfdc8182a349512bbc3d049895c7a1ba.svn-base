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
import com.founder.rhip.ehr.entity.report.RpVaccination;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.report.IRpVaccinationDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import com.founder.rhip.scheduling.core.TaskConstants;

@Service("rpVaccinationService")
@TaskBean(cron = "0 0 4 * * ?", description = "机构接种疫苗工作量定时任务")
public class RpVaccinationServiceImpl extends RpBaseService implements
		IRpVaccinationService,Task {
	

	@Resource(name = "rpVaccinationDao")
	private IRpVaccinationDao rpVaccinationDao;
	
	@Resource(name = "vaccinationInfoDao")
	private IVaccinationInfoDao vaccinationInfoDao;

	@Override
	public void saveOrganizationVaccinationStatistics(String dateStr) {
		if (ObjectUtil.isNullOrEmpty(dateStr)) {
			Date date = DateUtil.getBeforeDay(new Date(), 1);
			dateStr = DateUtil.convertDateToString(date);
		}
		// 获取各机构医务人员数量
		Map<String,Long> staffCountMap = mdmStaffService.getStaffNumByOrg(null);

		List<Map<String, Object>> vaccinationMapList = vaccinationInfoDao.getOrganizationVaccinationMapList(dateStr);
		if (ObjectUtil.isNotEmpty(vaccinationMapList)) {
			for (Map<String, Object> map : vaccinationMapList) {
				Object organCode = null;
				Object rpDate = null;
				Object vaccinationNum = null;
				if (ObjectUtil.isNullOrEmpty(map) || ObjectUtil.isNullOrEmpty(organCode = map.get("vaccination_unit_code"))
						|| ObjectUtil.isNullOrEmpty(rpDate = map.get("rpDate"))
						|| ObjectUtil.isNullOrEmpty(vaccinationNum = map.get("vaccination_num"))) {
					continue;
				}
				Criteria rpCriteria = new Criteria("organCode", organCode);
				DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(DateUtil.parseDateString(String.valueOf(rpDate))), DateUtil.makeTimeToMax(DateUtil.parseDateString(String.valueOf(rpDate))));

				RpVaccination rv = rpVaccinationDao.get(rpCriteria);
				if (ObjectUtil.isNullOrEmpty(rv)) {
					Organization organization = organizationApp.queryOrgan(String.valueOf(organCode));
					RpVaccination rpVaccination = new RpVaccination();
					setRpOrganization(new ConvertingWrapDynaBean(rpVaccination), organization);
					rpVaccination.setDoctorNum(staffCountMap.get(organCode));
					rpVaccination.setVaccinationNum(Long.valueOf(String.valueOf(vaccinationNum)));
					rpVaccination.setRpDate(DateUtil.parseDateString(String.valueOf(rpDate)));
					rpVaccinationDao.insert(rpVaccination);
				} else {
					rpVaccinationDao.update(new Parameters("vaccinationNum", vaccinationNum), new Criteria("id", rv.getId()));
				}
			}
		} 
	}

	@Override
	public void run(Map<String, Object> data) {
		String dateStr = ObjectUtil.isNullOrEmpty(data.get(TaskConstants.TASK_PARAM_KEY)) ? null : String.valueOf(data.get(TaskConstants.TASK_PARAM_KEY));
		saveOrganizationVaccinationStatistics(dateStr);
	}

	@Override
	public List<Map<String, Object>> getOrganizaitonVaccinationMapList(
			Map<String, String> paramMap) {
		List<Map<String, Object>> mapList = rpVaccinationDao.getOrganizationVaccinationMapList(paramMap);
		List<Map<String, Object>> destMapList = matchTowns(mapList, paramMap);
		return destMapList;
	}
}
