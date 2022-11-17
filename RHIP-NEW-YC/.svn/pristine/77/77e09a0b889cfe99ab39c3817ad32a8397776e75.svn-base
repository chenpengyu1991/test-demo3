package com.founder.rhip.he.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.HealthEducationReport;
import com.founder.rhip.ehr.repository.statistics.IHealthEducationActiveStatisticsDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("healthEducationStatisticsService")
public class HealthEducationStatisticsServiceImpl extends AbstractService implements IHealthEducationStatisticsService {
	
	private static final String ORGCODE = "orgCode";
	private static final String CENTERORGCODE = "centerOrgCode";
	private static final String GBCODE = "gbcode";

	@Resource(name = "healthEducationActiveStatisticsDao")
	private IHealthEducationActiveStatisticsDao healthEducationActiveStatisticsDao;
	
	@Autowired
	private IOrganizationApp organizationApp;
	
	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Override
	public List<HealthEducationReport> statisticsHealthEducation(Criteria criteria) {
		List<HealthEducationReport> healthEducationReports = new ArrayList<>();
		// 统计卫生服务站体检进度
		if (criteria.contains(ORGCODE)) {
			HealthEducationReport healthEducationReport = organizeHealthEducationReport(criteria, String.valueOf(criteria.get(ORGCODE)));
			healthEducationReports.add(healthEducationReport);
		} else if (criteria.contains(CENTERORGCODE) && !criteria.contains(ORGCODE)) { // 统计卫生服务中心体检进度
			//获取卫生服务中心
			String organCode = criteria.get(CENTERORGCODE).toString();
			criteria.add(ORGCODE, organCode);
			HealthEducationReport healthEducationReport = organizeHealthEducationReport(criteria, organCode);
			healthEducationReports.add(healthEducationReport);
			criteria.remove(ORGCODE);	
			// 获取卫生服务中心下属服务站
			List<Organization> stations = getStation(organCode);
			for (Organization organization : stations) {
				criteria.add(ORGCODE, organization.getOrganCode());
				healthEducationReport = organizeHealthEducationReport(criteria, organization.getOrganCode());
				healthEducationReports.add(healthEducationReport);
				criteria.remove(ORGCODE);
			}
		} else if (criteria.contains(GBCODE)) {
            if("_999".equals(criteria.get(GBCODE))){//建教所
                HealthEducationReport healthEducationReport = organizeHealthEducationReport(criteria, "_999");
                healthEducationReports.add(healthEducationReport);
            }else{
                // 获取镇下属卫生服务中心
                List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
                for (Organization organization : centres) {
                    // 获取卫生服务中心下属服务站
                    List<Organization> stations = getStation(organization.getOrganCode());
                    String temp = null;

                    //因宣传栏等表中center_org_code字段与ORG_CODE字段值不完全对应，导致查询结果有问题，现改为只根据ORG_CODE值查询
                    //比如ORG_CODE值为'320003138'，根据机构之间的从属关系，其center_org_code值应为'320003180',
                    //但HEALTH_RESOURCE_RECORD表中center_org_code字段有些值为'320003364'
                    if(CollectionUtils.isEmpty(stations))
                    {
                        temp = "'" +  organization.getOrganCode() + "'";
                    }else
                    {
                        temp = this.Convert2String(stations, "organCode") + ",'" +  organization.getOrganCode() + "'";
                    }
                    criteria.add(CENTERORGCODE, temp);
                    HealthEducationReport healthEducationReport = organizeHealthEducationReport(criteria, organization.getOrganCode());
                    healthEducationReports.add(healthEducationReport);
                    criteria.remove(CENTERORGCODE);
                }
            }

		} else {
			//获取所有的镇下的卫生服务中心 modify by yejianfei 20140221
			Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
			List<DicItem> dicItems = dictionaryApp.queryDicItem(ca);
			for (DicItem dicItem : dicItems) {
				criteria.add(GBCODE, dicItem.getItemCode());
				List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
				for (Organization organization : centres) {
					// 获取卫生服务中心下属服务站
					List<Organization> stations = getStation(organization.getOrganCode());
					String temp = null;
					
					//因宣传栏等表中center_org_code字段与ORG_CODE字段值不完全对应，导致查询结果有问题，现改为只根据ORG_CODE值查询
					//比如ORG_CODE值为'320003138'，根据机构之间的从属关系，其center_org_code值应为'320003180',
					//但HEALTH_RESOURCE_RECORD表中center_org_code字段有些值为'320003364'
					if(CollectionUtils.isEmpty(stations))
					{
						temp = "'" +  organization.getOrganCode() + "'";
					}else
					{
						temp = this.Convert2String(stations, "organCode") + ",'" +  organization.getOrganCode() + "'";
					}
					criteria.add(CENTERORGCODE, temp);
					HealthEducationReport healthEducationReport = organizeHealthEducationReport(criteria, organization.getOrganCode());
					healthEducationReports.add(healthEducationReport);
					criteria.remove(CENTERORGCODE);
				}	
				criteria.remove(GBCODE);
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
		//Integer[] otherActiveNums = healthEducationActiveStatisticsDao.getOtherActiveQuantity(criteria);
		//Integer bulletinBoardNum = healthEducationActiveStatisticsDao.getBulletinBoardQuantity(criteria);
		Integer bulletinBoardUseNum = healthEducationActiveStatisticsDao.getBulletinBoardUseQuantity(criteria);
		Map<String, Object> materialQuantityMap = healthEducationActiveStatisticsDao.getMaterialDistributionQuantity(criteria);
		Map<String, Object> prescriptionQuantityMap = healthEducationActiveStatisticsDao.getPrescriptionQuantity(criteria);
		HealthEducationReport healthEducationReport = new HealthEducationReport();
		healthEducationReport.setOrgCode(orgCode);
		healthEducationReport.setSpeciesVideoQuantity(videoNums[1]);
		healthEducationReport.setPlayVideoQuantity(videoNums[0]);
		//healthEducationReport.setPlayVideoPersonQuantity(videoNums[1]);
		healthEducationReport.setHealthConsultQuantity(consultNums[0]);
		healthEducationReport.setHealthConsultPersonQuantity(consultNums[1]);
		//healthEducationReport.setBulletinBoardQuantity(bulletinBoardNum);
		healthEducationReport.setBulletinBoardUseFrequency(bulletinBoardUseNum);
		healthEducationReport.setHealthLectureQuantity(lectureNums[0]);
		healthEducationReport.setHealthLecturePersonQuantity(lectureNums[1]);
		//healthEducationReport.setOtherActiveQuantity(otherActiveNums[0]);
		//healthEducationReport.setOtherActivePersonQuantity(otherActiveNums[1]);
		healthEducationReport.setSpeciesMaterialQuantity(Integer.valueOf(String.valueOf(materialQuantityMap.get("SPECIES_MATERIAL_QUANTITY"))));
		healthEducationReport.setIssueMaterialQuantity(Integer.valueOf(String.valueOf(materialQuantityMap.get("ISSUE_MATERIAL_QUANTITY"))));
		healthEducationReport.setTraditionalChineseQuantity(Integer.valueOf(String.valueOf(prescriptionQuantityMap.get("PRESCRIPTION_QUANTITY"))));
		return healthEducationReport;
	}
	
	/**
	 * 获取卫生服务中心下属卫生服务站
	 * @param supOrganCode 中心机构编码
	 * @return
	 */
	private List<Organization> getStation(String supOrganCode) {
		List<Organization> stations = new ArrayList<Organization>();

		stations.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue())));
		return stations;
	}
	
	/**
	 * 获取镇下面所有服务服务中心
	 * @param gbCode 镇的编码
	 * @return
	 */
	private List<Organization> getCentre(String gbCode) {
		Criteria criteria = new Criteria();
		if(gbCode.equals("_hospital")){
			criteria.add("GENRE_CODE", OrgGenreCode.HOSPITAL.getValue());
		}else if(gbCode.equals("_other")){
			criteria.add("GENRE_CODE", OrgGenreCode.OTHER.getValue());
		} else if(gbCode.equals(EHRConstants._INFIRMARY)) {
			criteria.add("GENRE_CODE", OrgGenreCode.INFIRMARY.getValue());
		} else if(gbCode.equals(EHRConstants._HEALTHOVERSIGHT)) {
			criteria.add("GENRE_CODE", OrgGenreCode.HEALTH_OVERSIGHT.getValue());
		} else{
			criteria = new Criteria("GB_CODE", gbCode);
			criteria.add("GENRE_CODE", OrgGenreCode.CENTRE.getValue());
		}
		
		List<Organization> centres = organizationApp.queryOrganization(criteria);
		return centres;
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

	@Override
	public List<HealthEducationReport> getEduCensusList(Criteria criteria) {
		return healthEducationActiveStatisticsDao.getEduCensusList(criteria);
	}
}
