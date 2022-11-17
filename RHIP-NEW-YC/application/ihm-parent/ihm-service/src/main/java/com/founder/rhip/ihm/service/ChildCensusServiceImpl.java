package com.founder.rhip.ihm.service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ehr.common.EHRConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.ChildCensus;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.ehr.repository.statistics.IChildCensusDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;

@Service("childCensusService")
public class ChildCensusServiceImpl extends AbstractService implements IchildCensusService{
	
	private static final String ORGCODE = "orgCode";
	private static final String CENTERORGCODE = "centerOrgCode";
	private static final String GBCODE = "gbcode";
	
	@Resource(name = "childCensusDao")
	private IChildCensusDao childCensusDao;
	
	@Autowired
	private IOrganizationApp organizationApp;

	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Override
	public List<ChildCensus> getChildCensusList(Criteria criteria) {

		
		List<ChildCensus> reports = new ArrayList<>();
		
		// 统计卫生服务站体检进度
		// 统计卫生服务站体检进度
		if (criteria.contains(ORGCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
				}
			if(criteria.contains("month")==false && criteria.contains("year")==true){
				
				List<ChildCensus> list = childCensusDao.getChildCensusList(criteria, null);
				ChildCensus census = null;
				
				if(ObjectUtil.isNotEmpty(list)){
					census = list.get(0);
				}
				
				if(ObjectUtil.isNullOrEmpty(census)){
					census=new ChildCensus();
				}
				census.setOrgCode(criteria.get(ORGCODE).toString());
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
				List<ChildCensus> list = childCensusDao.getChildCensusList(criteria, null);
				ChildCensus census = null;
				
				if(ObjectUtil.isNotEmpty(list)){
					census = list.get(0);
				}
				
				if(census==null){
					census = new ChildCensus();
				}
				census.setOrgCode(criteria.get(ORGCODE).toString());
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
            List<Organization> stations = getStation(organCode);
            for (Organization organization1 : stations) {
				organCodeList.add(organization1.getOrganCode());
			}
            
            if(criteria.contains("month")==true || criteria.contains("year")==false){
				if (criteria.contains("gbcode")) {
					String gbCode=(String)criteria.get("gbcode");
					criteria.remove("gbcode");
					criteria.add("gbCode",gbCode);
				}
			}
            
            List<ChildCensus> list = childCensusDao.getChildCensusList(criteria, organCodeList);
            //信息补全
			Map<String, ChildCensus> map = new HashMap<String, ChildCensus>();
			for (ChildCensus census : list) {
				map.put(census.getOrgCode(), census);
			}
			
			for(String str : organCodeList){
				if(map.get(str) == null){
					ChildCensus census  = new ChildCensus();
					census.setOrgCode(str);
					reports.add(census);
				}else{
					reports.add(map.get(str));
				}
			}
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
				List<Organization> stations = getStation(organCode);
				for (Organization organization1 : stations) {
					organCodeList.add(organization1.getOrganCode());
				}
				List<ChildCensus> list = childCensusDao.getChildCensusList(criteria, organCodeList);
				
				//信息补全
				Map<String, ChildCensus> map = new HashMap<String, ChildCensus>();
				for (ChildCensus census : list) {
					map.put(census.getOrgCode(), census);
				}
				
				for(String str : organCodeList){
					if(map.get(str) == null){
						ChildCensus census  = new ChildCensus();
						census.setOrgCode(str);
						reports.add(census);
					}else{
						reports.add(map.get(str));
					}
				}
			}else{
				List<String> organCodeList=new ArrayList<>();
				for (Organization organization : centres) {
                	organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
						organCodeList.add(organization1.getOrganCode());
					}
                }
				 
				List<ChildCensus> list = childCensusDao.getChildCensusList(criteria, organCodeList);
				Map<String, ChildCensus> map = new HashMap<String, ChildCensus>();
				for (ChildCensus census : list) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					ChildCensus census = map.get(organization.getOrganCode());
					if(census == null){
						census = new ChildCensus();
						census.setOrgCode(organization.getOrganCode());
					}
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						if(map.get(organization1.getOrganCode()) != null)
							countCensus(census,map.get(organization1.getOrganCode()));
					}
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
				 
				List<ChildCensus> list = childCensusDao.getChildCensusList(criteria, organCodeList);
				Map<String, ChildCensus> map = new HashMap<String, ChildCensus>();
				for (ChildCensus census : list) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					ChildCensus census = map.get(organization.getOrganCode());
					if(census == null){
						census = new ChildCensus();
						census.setOrgCode(organization.getOrganCode());
					}
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						if(map.get(organization1.getOrganCode()) != null)
							countCensus(census,map.get(organization1.getOrganCode()));
					}
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
	                    List<Organization> stations = getStation(organization.getOrganCode());
	                    for (Organization organization1 : stations) {
							organCodeList.add(organization1.getOrganCode());
						}
					}
				}
				
	            List<ChildCensus> list = childCensusDao.getChildCensusList(criteria, organCodeList);
				Map<String, ChildCensus> map = new HashMap<String, ChildCensus>();
	            for(ChildCensus census :list){
					map.put(census.getOrgCode(), census);
				}
	            
	            for (DicItem dicItem : dicItems) {
	            	criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
					
					for (Organization organization : centres) {
						ChildCensus census = map.get(organization.getOrganCode());
						if(census == null){
							census = new ChildCensus();
							census.setOrgCode(organization.getOrganCode());
						}
	                    List<Organization> stations = getStation(organization.getOrganCode());
	                    for (Organization organization1 : stations) {
	                    	if(map.get(organization1.getOrganCode()) != null)
	                    		countCensus(census, map.get(organization1.getOrganCode()));
						}
	                    reports.add(census);
					}
				}
			}
		}
		return reports;
	}
	
	private void countCensus(ChildCensus census, ChildCensus childCensus) {
		census.setDeathCount(census.getDeathCount() + childCensus.getDeathCount());
		census.setVisitCount(census.getVisitCount() + childCensus.getVisitCount());
		census.setExamineCount1(census.getExamineCount1() + childCensus.getExamineCount1());
		census.setExamineCount2(census.getExamineCount2() + childCensus.getExamineCount2());
		census.setExamineCount6(census.getExamineCount6() + childCensus.getExamineCount6());
		census.setTcmCount1(census.getTcmCount1() + childCensus.getTcmCount1());
		census.setTcmCount2(census.getTcmCount2() + childCensus.getTcmCount2());
		census.setTcmCount6(census.getTcmCount6() + childCensus.getTcmCount6());
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
		if (!CollectionUtils.isEmpty(list)){
			Method method;
			try {
				method = list.get(0).getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
				for (int i = 0; i < list.size(); i++) {
					if(i == 0){
						strB.append("'" + method.invoke(list.get(i)) + "'");
					}else{
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
