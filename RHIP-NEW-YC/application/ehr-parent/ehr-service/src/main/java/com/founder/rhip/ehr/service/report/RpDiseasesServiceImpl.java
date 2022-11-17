package com.founder.rhip.ehr.service.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.report.RpDiseases;
import com.founder.rhip.ehr.entity.report.RpInhospital;
import com.founder.rhip.ehr.repository.clinic.*;
import com.founder.rhip.ehr.repository.report.IRpDiseasesDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("rpDiseasesService")
@TaskBean(cron = "0 0 4 * * ?", description = "诊断表项目统计数据")
public class RpDiseasesServiceImpl extends AbstractService implements IRpDiseasesService, Task {

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Resource(name = "diseaseDiagnosisInfoDao")
	IDiseaseDiagnosisInfoDao diseaseDiagnosisInfoDao;

	@Resource(name = "rpDiseasesDao")
	IRpDiseasesDao rpDiseasesDao;

	List<RpDiseases> insertRpDiseasess = new ArrayList<RpDiseases>();
	List<RpDiseases> updateRpDiseasess = new ArrayList<RpDiseases>();
	private static final String FORMATER = "yyyy/MM/dd";
	
	@Override
	public void insertDiseasesStatistics(String dateStr) {

		updateRpDiseasess = new ArrayList<RpDiseases>();
		insertRpDiseasess = new ArrayList<RpDiseases>();
		
		/*若参数为空则默认同步前一天的数据*/
		Date date = DateUtil.getBeforeDay(new Date(), 1);
		if(StringUtils.isNotEmpty(dateStr)) {
			date = DateUtil.parseSimpleDate(dateStr, FORMATER);
		} else {
			dateStr = DateUtil.getDateTime(FORMATER, date);
		}
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = diseaseDiagnosisInfoDao.getDiseasesStatistics(dateStr);
		
		
		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			RpDiseases rpDiseases = new RpDiseases();
			Organization organization = organizationApp.queryOrgan(String.valueOf(temp.get("hospital_code")));
			this.setValueForRpDiseasesAboutOrg(organization, rpDiseases);
			Date diseaseDate = DateUtil.parseSimpleDate(String.valueOf(temp.get("DIAGNOSE_DATE")).replace(".0", ""), FORMATER);
			rpDiseases.setRpDate(diseaseDate);
			rpDiseases.setaNum((ObjectUtil.isNullOrEmpty(temp.get("a_num"))) ? 0 : Long.valueOf(String.valueOf(temp.get("a_num"))));
			rpDiseases.setbNum((ObjectUtil.isNullOrEmpty(temp.get("b_num"))) ? 0 : Long.valueOf(String.valueOf(temp.get("b_num"))));
			this.addRpDiseases(organization.getOrganCode(), diseaseDate, rpDiseases);
		}
		rpDiseasesDao.batchInsert(insertRpDiseasess);
		rpDiseasesDao.batchUpdate(updateRpDiseasess,"aNum","bNum");
	}

	@Override
	public List<RpDiseases> getDiseases(Map<String, String> paramMap) {
		return rpDiseasesDao.getDiseases(paramMap);
	}

	/**
	 * 1年内按月统计A、B类型传染病
	 * @param paramMap
	 * @return
	 */
	public List<Map<String, Object>> getDiseaseMonth(Map<String, String> paramMap){
		return rpDiseasesDao.getDiseaseMonth(paramMap);
	}


	/**
	 * 根据机构code和出院日期检查时更新还是插入
	 * @param orgCode
	 * @param date
	 * @param rpDiseases
	 */
	private void addRpDiseases(String orgCode, Date date, RpDiseases rpDiseases) {
		Criteria rpCriteria = new Criteria("organCode", orgCode);
		DateUtil.getCriteriaByDateRange(rpCriteria, "rpDate", DateUtil.makeTimeToZero(date), DateUtil.makeTimeToMax(date));
		RpDiseases tempRpDiseases = rpDiseasesDao.get(rpCriteria);
		if(ObjectUtil.isNullOrEmpty(tempRpDiseases)) {
			insertRpDiseasess.add(rpDiseases);
		} else {
			tempRpDiseases.setaNum(rpDiseases.getaNum());
			tempRpDiseases.setbNum(rpDiseases.getbNum());
			updateRpDiseasess.add(tempRpDiseases);
		}
	}

	/**
	 * 为RpInhospital对象中和机构相关的属性赋值
	 * @param organization
	 * @param rpDiseases
	 */
	private void setValueForRpDiseasesAboutOrg(Organization organization, RpDiseases rpDiseases) {
		rpDiseases.setGbCode(organization.getGbCode());
		rpDiseases.setCenterCode((organization.getParentCode() == null || organization.getParentCode().equals("0")) ? organization.getOrganCode() : organization.getParentCode());
		rpDiseases.setOrganCode(organization.getOrganCode());
		rpDiseases.setOrganType(organization.getGenreCode());
	}

	@Override
	public void run(Map<String, Object> data) {
		insertDiseasesStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
	}

	/*2014-01-05 00:00:00*/
	public static void main(String []rr) {
		System.out.println(DateUtil.parseSimpleDate("2014/01/05 00:00:00", FORMATER));
	}

	@Override
	public List<Map<String, Object>> getDiseaseMapList(
			Map<String, String> paramMap) {
		return diseaseDiagnosisInfoDao.getDiseaseMapList(paramMap);
	}


}
