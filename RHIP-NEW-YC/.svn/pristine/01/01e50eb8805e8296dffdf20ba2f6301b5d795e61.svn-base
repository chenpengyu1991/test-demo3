package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.repository.ihm.IHealthEducationStatisticsDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("healthEducationStatisticsService_")
public class HealthEducationStatisticsServiceImpl extends AbstractService implements IHealthEducationStatisticsService {
	
	@Resource(name = "healthEducationStatisticsDao_")
	private IHealthEducationStatisticsDao healthEducationActiveStatisticsDao;
	
	@Resource(name = "mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Override
	public List<HealthEducationReport> statisticsHealthEducation(Map<String, String> map) {
		String organCode = map.get("organCode");
		String genreCode = map.get("genreCode");
		String superOrganCode = map.get("superOrganCode");
		String gbCode = map.get("gbCode");
		Object[] array = this.getOrganArray(genreCode, organCode, superOrganCode, gbCode);
		
		String beginDate = map.get("beginDate");
	    String endDate = map.get("endDate");
		String filedName = null;
		if("0".equals(genreCode)) //按镇
		{
			filedName = "gbCode";
		}else
		{
			filedName = "orgCode";
		}
		
		List<HealthEducationReport> healthEducationReports = new ArrayList<>();
		if(array != null && array.length > 0)
		{
			for(int i = 0; i < array.length; i++) 
			{
				String strTemp = null;
				if("0".equals(genreCode))//按镇
				{
					Criteria criteriaTemp = new Criteria("gbCode", array[i]).add("organCode", OP.IS, "NOT NULL").add("genreCode", OP.IN, new String[]{"B100","B200"}).add("status", "1");
					List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);

					if (!CollectionUtils.isEmpty(orgs)) {
						strTemp = Convert2String(orgs, "organCode");
					}else
					{
						strTemp = "'" + array[i] + "'";
					}
				}else
				{
					strTemp = String.valueOf(array[i]);
				}
				Criteria criteria = new Criteria(filedName, strTemp).add("beginDate", beginDate).add("endDate", endDate);
				HealthEducationReport healthEducationReport = this.organizeHealthEducationReport(criteria, String.valueOf(array[i]));
				healthEducationReports.add(healthEducationReport);
			}
		}
		
		return healthEducationReports;
	}
	
	/**
	 * 组织健康教育报表
	 * @param criteria 查询条件
	 * @param orgCode 机构代码
	 * @return
	 */
	private HealthEducationReport organizeHealthEducationReport(Criteria criteria, String orgCode) {
		Integer[] videoNums = healthEducationActiveStatisticsDao.getHealthVideoQuantity(criteria);
		Integer[] consultNums = healthEducationActiveStatisticsDao.getConsultQuantity(criteria);
		Integer[] lectureNums = healthEducationActiveStatisticsDao.getLectureQuantity(criteria);
		Integer[] otherActiveNums = healthEducationActiveStatisticsDao.getOtherActiveQuantity(criteria);
		Integer bulletinBoardNum = healthEducationActiveStatisticsDao.getBulletinBoardQuantity(criteria);
		Integer bulletinBoardUseNum = healthEducationActiveStatisticsDao.getBulletinBoardUseQuantity(criteria);
		Integer materialDistributionNum = healthEducationActiveStatisticsDao.getMaterialDistributionQuantity(criteria);
		HealthEducationReport healthEducationReport = new HealthEducationReport();
		healthEducationReport.setOrgCode(orgCode);
		healthEducationReport.setPlayVideoQuantity(videoNums[0]);
		healthEducationReport.setPlayVideoPersonQuantity(videoNums[1]);
		healthEducationReport.setHealthConsultQuantity(consultNums[0]);
		healthEducationReport.setHealthConsultPersonQuantity(consultNums[1]);
		healthEducationReport.setBulletinBoardQuantity(bulletinBoardNum);
		healthEducationReport.setBulletinBoardUseFrequency(bulletinBoardUseNum);
		healthEducationReport.setHealthLectureQuantity(lectureNums[0]);
		healthEducationReport.setHealthLecturePersonQuantity(lectureNums[1]);
		healthEducationReport.setOtherActiveQuantity(otherActiveNums[0]);
		healthEducationReport.setOtherActivePersonQuantity(otherActiveNums[1]);
		healthEducationReport.setIssueMaterialQuantity(materialDistributionNum);
		return healthEducationReport;
	}
	
	
	/**
	 * 组装查询条件
	 * 
	 * @return
	 */
	private Object[] getOrganArray(String genreCode, String organCode, String superOrganCode, String gbCode) {
		Criteria criteriaTemp = null;
		Object[] array = null;
		
		// 机构
		if("0".equals(genreCode)) // 按镇
		{
			if (StringUtil.isNotEmpty(gbCode)) {
				array = new Object[]{gbCode};
			} else {
				List<DicItem> dicItems = dictionaryApp.queryDicItem(new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT));
				if (!CollectionUtils.isEmpty(dicItems)) {
					array = Convert2Array(dicItems,"itemCode");
				}
			}
		} else if ("A100".equals(genreCode)) // 按市级医院
		{
			criteriaTemp = new Criteria().add("genreCode", "A100");
			if (StringUtil.isNotEmpty(superOrganCode)) {
				criteriaTemp.add("organCode", superOrganCode);
			} else {
				criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
			}
            criteriaTemp.add("SUBSID","0");
		} else if ("B100".equals(genreCode)) // 按卫生院
		{
			
			criteriaTemp = new Criteria().add("genreCode", "B100");
			if(StringUtil.isNotEmpty(gbCode))
			{
				criteriaTemp.add("gbCode", gbCode);
			}
			
			if(StringUtil.isNotEmpty(superOrganCode))
			{
				criteriaTemp.add("organCode", superOrganCode);
			}else
			{
				criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
			}
		} else if ("B200".equals(genreCode)) // 按社区卫服务站
		{
			criteriaTemp = new Criteria().add("genreCode", "B200");
			if(StringUtil.isNotEmpty(gbCode))
			{
				criteriaTemp = criteriaTemp.add("gbCode", gbCode);
			}
			
			if(StringUtil.isNotEmpty(superOrganCode))
			{
				criteriaTemp = criteriaTemp.add("parentCode", superOrganCode);
			}
			
			if(StringUtil.isNotEmpty(organCode))
			{
				criteriaTemp = criteriaTemp.add("organCode", organCode);
			}else
			{
				criteriaTemp = criteriaTemp.add("organCode", OP.IS, "NOT NULL");
			}
		}

		if (null != criteriaTemp) {
			criteriaTemp.add("status", "1");
			List<Organization> orgs = organizationService.getOrganizations(criteriaTemp);

			if (!CollectionUtils.isEmpty(orgs)) {
				array = Convert2Array(orgs, "organCode");
			}
		}

		return array;
	}
	
	private <T> Object[] Convert2Array(List<T> list, String fieldName) {
		Object[] ta = new Object[list.size()];
		if (CollectionUtils.isEmpty(list))
			return ta;
		Method method;
		try {
			method = list.get(0).getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
			for (int i = 0; i < list.size(); i++) {
				ta[i] = method.invoke(list.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ta;
	}
	
	private <T> String Convert2String(List<T> list, String fieldName) {
		StringBuilder strB = new StringBuilder();
		if (!CollectionUtils.isEmpty(list))
		{
			Method method;
			try {
				method = list.get(0).getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
				for (int i = 0; i < list.size(); i++) {
					if(i == 0)
					{
						strB.append("'" + method.invoke(list.get(i)) + "'");
					}else
					{
						strB.append(",").append("'" + method.invoke(list.get(i)) + "'");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strB.toString();
	}
}
