package com.founder.rhip.hsa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.HealthRecordCensus;
import com.founder.rhip.ehr.dto.HealthSuperviseForm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.repository.hsa.IHsaServiceReportDao;
import com.founder.rhip.ehr.statisticsdto.HsaServiceReport;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;

/**
 * 统计查询
 * @author liuk
 *
 */
@Service("hsaServiceReportService")
public class HsaServiceReportServiceImpl extends AbstractService implements IHsaServiceReportService {

	private static final String ORGCODE = "orgCode";
	private static final String CENTERORGCODE = "centerOrgCode";
	private static final String GBCODE = "gbcode";
	
	@Resource(name = "hsaServiceReportDao")
	private IHsaServiceReportDao hsaServiceReportDao;
	
	@Autowired
	private IOrganizationApp organizationApp;
	
	@Autowired
	private IDictionaryApp dictionaryApp;

	@Override
	public Map<String, HsaServiceReport> getReportData(String gbcode, String centerCode, int year, int month) {
		List<HsaServiceReport> totals = hsaServiceReportDao.getReportData(1, gbcode, centerCode, year, month);
		List<HsaServiceReport> counts = hsaServiceReportDao.getReportData(0, gbcode, centerCode, year, month);
		Map<String, HsaServiceReport> map = buildResult(1, totals, counts);
		return map;
	}

	@Override
	public Map<String, HsaServiceReport> getReportData(String gbcode, String centerCode, String yearMonthStart,
			String yearMonthEndDate) {
		List<HsaServiceReport> totals = hsaServiceReportDao.getReportData(1, gbcode, centerCode, yearMonthStart, yearMonthEndDate);
		List<HsaServiceReport> counts = hsaServiceReportDao.getReportData(0, gbcode, centerCode, yearMonthStart, yearMonthEndDate);
		Map<String, HsaServiceReport> map = buildResult(1, totals, counts);
		return map;
	}
	
	@Override
	public Map<String, HsaServiceReport> getInspectionData(String gbcode, String centerCode, String yearMonthStart,String yearMonthEndDate) {
		List<HsaServiceReport> totals = hsaServiceReportDao.getInspectionData(1, gbcode, centerCode, yearMonthStart, yearMonthEndDate);
		List<HsaServiceReport> counts = hsaServiceReportDao.getInspectionData(0, gbcode, centerCode, yearMonthStart, yearMonthEndDate);
		Map<String, HsaServiceReport> map = buildResult(0, totals, counts);
		return map;
	}

	@Override
	public Map<String, HsaServiceReport> getEduData(String gbcode, String centerCode,String yearMonthStart,String yearMonthEndDate) {
		List<HsaServiceReport> totals = hsaServiceReportDao.getEduData(1, gbcode, centerCode, yearMonthStart, yearMonthEndDate);
		List<HsaServiceReport> counts = hsaServiceReportDao.getEduData(0, gbcode, centerCode, yearMonthStart, yearMonthEndDate);
		Map<String, HsaServiceReport> map = buildResult(0, totals, counts);
		return map;
	}

	@Override
	public Map<String, HsaServiceReport> getSodpData(String gbcode, String centerCode, String yearMonthStart,
			String yearMonthEndDate) {
		List<HsaServiceReport> totals = hsaServiceReportDao.getSodpData(1, gbcode, centerCode, yearMonthStart, yearMonthEndDate);
		List<HsaServiceReport> counts = hsaServiceReportDao.getSodpData(0, gbcode, centerCode, yearMonthStart, yearMonthEndDate);
		Map<String, HsaServiceReport> map = buildResult(0, totals, counts);
		return map;
	}

    public 	List<Map<String,Object>> getHealthSupervision(String roleType,HealthSuperviseForm initForm){
		return hsaServiceReportDao.getHealthSupervision(roleType,initForm);
	}

    public List<Map<String,Object>> getHealthSupervisionStation(String code,HealthSuperviseForm initForm){
        return hsaServiceReportDao.getHealthSupervisionStation(code,initForm);
    }

    public List<Map<String,Object>> getHealthSupervisionGB(String gbcode,HealthSuperviseForm initForm){
        return hsaServiceReportDao.getHealthSupervisionGB(gbcode,initForm);
    }

    @Override
    public List<Map<String, Object>> getHealthSupervisionAll(HealthSuperviseForm initForm) {
        return hsaServiceReportDao.getHealthSupervisionAll(initForm);
    }

    private Map<String, HsaServiceReport> buildResult(int type, List<HsaServiceReport> totals, List<HsaServiceReport> counts) {
		Map<String, HsaServiceReport> map = new HashMap<String, HsaServiceReport>(totals.size());
		for (HsaServiceReport hsaServiceReport : totals) {
			map.put(getKey(type, hsaServiceReport), hsaServiceReport);
		}
		for (HsaServiceReport hsaServiceReport : counts) {
			HsaServiceReport old = map.get(getKey(type, hsaServiceReport));
			if (null != old) {
				old.setTotal(hsaServiceReport);
			}
			// 为空计算方式错误
		}
		return map;
	}

	private String getKey(int type, HsaServiceReport hsaServiceReport) {
		if (type == 1) {
			return hsaServiceReport.makeKey();
		} else {
			return hsaServiceReport.getType();
		}
	}

	@Override
	public List<Map<String, Object>> getHealthSupervisionList(Criteria criteria) {
		List<Map<String, Object>> reports = new ArrayList<>();
		
		// 统计卫生服务站体检进度
		// 统计卫生服务站体检进度
		if (criteria.contains(ORGCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
				}
			if(criteria.contains("month")==false && criteria.contains("year")==true){
				
				List<Map<String, Object>> list = hsaServiceReportDao.getHealthSupervisionList(criteria, null);
				Map<String, Object> census = null;
				
				if(ObjectUtil.isNotEmpty(list)){
					census = list.get(0);
				}
				
				if(ObjectUtil.isNullOrEmpty(census)){
					census=new HashMap<String, Object>();
				}
				census.put("orgCode", criteria.get(ORGCODE).toString());
				reports.add(census);
			}else{
				if(criteria.contains("qwgzxCode")) {
					criteria.remove("qwgzxCode");
				}
				if (criteria.contains("gbcode")) {
					String gbCode=(String)criteria.get("gbcode");
					criteria.remove("gbcode");
					criteria.add("gbCode",gbCode);
				}
				List<Map<String, Object>> list = hsaServiceReportDao.getHealthSupervisionList(criteria, null);
				Map<String, Object> census = null;
				
				if(ObjectUtil.isNotEmpty(list)){
					census = list.get(0);
				}
				
				if(ObjectUtil.isNullOrEmpty(census)){
					census=new HashMap<String, Object>();
				}
				census.put("orgCode", criteria.get(ORGCODE).toString());
				reports.add(census);
			}
		} else if (criteria.contains(CENTERORGCODE) && !criteria.contains(ORGCODE)&& !criteria.contains(GBCODE)) { // 统计卫生服务中心体检进度
			//获取卫生服务中心
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
				}
			String organCode = criteria.get(CENTERORGCODE).toString();
			criteria.add(ORGCODE, organCode);
			
			List<String> organCodeList=new ArrayList<>();
        	organCodeList.add(organCode);
//            List<Organization> stations = getStation(organCode);
//            for (Organization organization1 : stations) {
//				organCodeList.add(organization1.getOrganCode());
//			}
            
            if(criteria.contains("month")==true || criteria.contains("year")==false){
				if (criteria.contains("gbcode")) {
					String gbCode=(String)criteria.get("gbcode");
					criteria.remove("gbcode");
					criteria.add("gbCode",gbCode);
				}
			}
            
            List<Map<String, Object>> censusList = hsaServiceReportDao.getHealthSupervisionList(criteria, organCodeList);
            reports.addAll(censusList);
		} else if (criteria.contains(GBCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
				}
			List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
			if(criteria.contains(CENTERORGCODE)){
				String organCode = criteria.get(CENTERORGCODE).toString();
				criteria.add(ORGCODE, organCode);
				
				if(criteria.contains("month")==true || criteria.contains("year")==false){
					if (criteria.contains("gbcode")) {
						String gbCode=(String)criteria.get("gbcode");
						criteria.remove("gbcode");
						criteria.add("gbCode",gbCode);
					}
				}
				List<String> organCodeList=new ArrayList<>();
				organCodeList.add(organCode);
				//服务站不做业务，不统计站的数据
//				List<Organization> stations = getStation(organCode);
//				for (Organization organization1 : stations) {
//					organCodeList.add(organization1.getOrganCode());
//				}
				List<Map<String, Object>> censusList = hsaServiceReportDao.getHealthSupervisionList(criteria, organCodeList);
				reports.addAll(censusList);
			}else{
				List<String> organCodeList=new ArrayList<>();
				for (Organization organization : centres) {
                	organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
						organCodeList.add(organization1.getOrganCode());
					}
                }
				List<Map<String, Object>> censusList = hsaServiceReportDao.getHealthSupervisionList(criteria, organCodeList);
				Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
				for (Map<String, Object> census : censusList) {
					map.put((String)census.get(ORGCODE), census);
				}

				for (Organization organization : centres) {
					Map<String, Object> census = map.get(organization.getOrganCode());
					if(census == null){
						census = new HashMap<String, Object>();
						census.put(ORGCODE, organization.getOrganCode());
					}
//					List<Organization> stations = getStation(organization.getOrganCode());
//					for (Organization organization1 : stations) {
//						if(map.get(organization1.getOrganCode()) != null)
//							countCensus(census,map.get(organization1.getOrganCode()));
//					}
					reports.add(census);
				}
        	}
		} else {
			if(criteria.contains("qwgzxCode")) {
				criteria.add(GBCODE, criteria.get("qwgzxCode"));
				criteria.remove("qwgzxCode");
				List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
				
				List<String> organCodeList=new ArrayList<>();
				for (Organization organization : centres) {
                	organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
						organCodeList.add(organization1.getOrganCode());
					}
                }
				 
				List<Map<String, Object>> censusList = hsaServiceReportDao.getHealthSupervisionList(criteria, organCodeList);
				Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
				for (Map<String, Object> census : censusList) {
					map.put((String)census.get(ORGCODE), census);
				}

				for (Organization organization : centres) {
					Map<String, Object> census = map.get(organization.getOrganCode());
					if(census == null){
						census = new HashMap<String, Object>();
						census.put(ORGCODE, organization.getOrganCode());
					}
//					List<Organization> stations = getStation(organization.getOrganCode());
//					for (Organization organization1 : stations) {
//						if(map.get(organization1.getOrganCode()) != null)
//							countCensus(census,map.get(organization1.getOrganCode()));
//					}
					reports.add(census);
				}
				criteria.remove(GBCODE);
			}else{
				Criteria ca = new Criteria("dic_code", "FS990001").add("parent_code",  EHRConstants.FS990001_ROOT);
				List<DicItem> dicItems = dictionaryApp.queryDicItem(ca);
				List<String> organCodeList=new ArrayList<>();
				for (DicItem dicItem : dicItems) {
					criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
					
					for (Organization organization : centres) {
	                	organCodeList.add(organization.getOrganCode());
//	                    List<Organization> stations = getStation(organization.getOrganCode());
//	                    for (Organization organization1 : stations) {
//							organCodeList.add(organization1.getOrganCode());
//						}
					}
				}
				List<Map<String, Object>> censusList = hsaServiceReportDao.getHealthSupervisionList(criteria, organCodeList);
				Map<String, Map<String, Object>> map = new HashMap<String, Map<String, Object>>();
				for (Map<String, Object> census : censusList) {
					map.put((String)census.get(ORGCODE), census);
				}
	            
	            for (DicItem dicItem : dicItems) {
	            	criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
					
					for (Organization organization : centres) {
						Map<String, Object> census = map.get(organization.getOrganCode());
						if(census == null){
							census = new HashMap<String, Object>();
							census.put(ORGCODE, organization.getOrganCode());
						}
//	                    List<Organization> stations = getStation(organization.getOrganCode());
//	                    for (Organization organization1 : stations) {
//	                    	if(map.get(organization1.getOrganCode()) != null)
//	                    		countCensus(census, map.get(organization1.getOrganCode()));
//						}
	                    reports.add(census);
					}
				}
			}
		}
		return reports;
	
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
	
	private List<Organization> getStation(String supOrganCode) {
		List<Organization> stations = new ArrayList<Organization>();

		stations.addAll(organizationApp.queryOrganization(new Criteria(Organization.PARENT_CODE, supOrganCode).add("GENRE_CODE", OrgGenreCode.STATION.getValue())));
		return stations;
	}

}
