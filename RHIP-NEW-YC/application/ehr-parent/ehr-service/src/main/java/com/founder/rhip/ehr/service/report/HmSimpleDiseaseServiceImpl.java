package com.founder.rhip.ehr.service.report;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.ihm.HmSimpleDisease;
import com.founder.rhip.ehr.repository.clinic.IInpatientInfoDao;
import com.founder.rhip.ehr.repository.ihm.IHmSimpleDiseaseDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.scheduling.core.Task;
import com.founder.rhip.scheduling.core.TaskBean;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("hmSimpleDiseaseService")
@TaskBean(cron = "0 0 4 * * ?", description = "治疗结果分析报表定时任务")
public class HmSimpleDiseaseServiceImpl extends AbstractService implements IHmSimpleDiseaseService, Task {
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	@Resource(name = "hmSimpleDiseaseDao")
	private IHmSimpleDiseaseDao hmSimpleDiseaseDao;

	@Resource(name = "inpatientInfoDao")
	private IInpatientInfoDao inpatientInfoDao;

	List<HmSimpleDisease> updateList = new ArrayList<>();
	List<HmSimpleDisease> insertList = new ArrayList<>();
	
	private static final String FORMATER = "yyyy/MM/dd";
	
	@Override
	public void run(Map<String, Object> data) {
		this.insertHmSimpleDiseaseStatistics(String.valueOf(data.get("jobDataCustomParamKey")));
	}
	
	@Override
	public void insertHmSimpleDiseaseStatistics(String dateStr) {
		/*若参数为空则默认同步前一天的数据*/
		Date date = new Date(System.currentTimeMillis());
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		if(ObjectUtil.isNotEmpty(dateStr)){
			//按天
			if(DateUtil.isValidDate(dateStr, DAY_FORMAT)){
				cal.setTime(DateUtil.convert(DAY_FORMAT,dateStr));
				insertHmSimpleDiseaseData(new SimpleDateFormat(DAY_FORMAT).format(cal.getTime()));
			}
			//按月
			else if(DateUtil.isValidDate(dateStr,MONTH_FORMAT)){
				cal.setTime( DateUtil.convert(MONTH_FORMAT,dateStr));
				int lastDay = cal.getActualMaximum(Calendar.DATE);
				for(int i = 1;i<=lastDay;i++){
					cal.set(Calendar.DAY_OF_MONTH,i);
					insertHmSimpleDiseaseData(new SimpleDateFormat(DAY_FORMAT).format(cal.getTime()));
				}
			}
			//按年
			else if(DateUtil.isValidDate(dateStr,YEAR_FORMAT)){
				for(int i = 1;i<13;i++) {
					cal.setTime(DateUtil.convert(MONTH_FORMAT, dateStr + "/"+ String.format("%02d",i)));
					int lastDay = cal.getActualMaximum(Calendar.DATE);
					for (int j = 1; j <= lastDay; j++) {
						cal.set(Calendar.DAY_OF_MONTH, j);
						insertHmSimpleDiseaseData(new SimpleDateFormat(DAY_FORMAT).format(cal.getTime()));
					}
				}
			}
		} else {
			//取前一天数据
			insertHmSimpleDiseaseData(new SimpleDateFormat(DAY_FORMAT).format(cal.getTime()));
		}
	}


	/**
	 * 治愈人数 好转人数 死亡人数
	 * @param dateStr
	 */
	private void insertHmSimpleDiseaseData(String dateStr) {
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		result = inpatientInfoDao.getInpatientInfoDataSum(dateStr);

		updateList = new ArrayList<>();
		insertList = new ArrayList<>();

		for(Map<String, Object> temp : result) {
			if(ObjectUtil.isNullOrEmpty(temp)) {
				continue;
			}
			HmSimpleDisease hmSimpleDisease = new HmSimpleDisease();
			Organization organization = organizationApp.queryOrgan(String.valueOf(temp.get("REFERRAL_HOSPITAL_CODE")));
			hmSimpleDisease.setOrganCode(organization.getOrganCode());
			String hz_date = String.valueOf(temp.get("HZ_DATE")).replace(".0", "");
			Date outHospitalDate = DateUtil.parseSimpleDate(hz_date,"yyyy-MM-dd");
			hmSimpleDisease.setCreateDate(outHospitalDate);
			//治愈人数
			hmSimpleDisease.setCureNum(Long.valueOf(String.valueOf(temp.get("ZYRS"))));
			//好转人数
			hmSimpleDisease.setImproveNum(Long.valueOf(String.valueOf(temp.get("HZRS"))));
			//死亡人数
			hmSimpleDisease.setDeathNum(Long.valueOf(String.valueOf(temp.get("SWRS"))));
			this.insertOrUpdateHmSimpleDisease(organization.getOrganCode(), outHospitalDate, hmSimpleDisease);
		}
		hmSimpleDiseaseDao.batchInsert(insertList);
		hmSimpleDiseaseDao.batchUpdate(updateList,"cureNum","improveNum","deathNum");
	}
	
	/**
	 * 根据机构code和出院日期检查时更新还是插入
	 */
	private void insertOrUpdateHmSimpleDisease(String orgCode, Date date, HmSimpleDisease hm) {
		Criteria criteria = new Criteria("organCode", orgCode);
		DateUtil.getCriteriaByDateRange(criteria, "createDate", DateUtil.makeTimeToMax(date), DateUtil.makeTimeToMax(date));
		HmSimpleDisease hmSimpleDisease = hmSimpleDiseaseDao.get(criteria);
		if(ObjectUtil.isNullOrEmpty(hmSimpleDisease)) {//新增记录
			insertList.add(hm);
		} else {//更新记录
			//治愈人数
			hmSimpleDisease.setCureNum(hm.getCureNum());
			//好转人数
			hmSimpleDisease.setImproveNum(hm.getImproveNum());
			//死亡人数
			hmSimpleDisease.setDeathNum(hm.getDeathNum());
			updateList.add(hmSimpleDisease);
		}
	}

}
