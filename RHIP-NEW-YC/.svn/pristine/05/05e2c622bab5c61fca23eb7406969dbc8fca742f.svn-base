package com.founder.rhip.ihm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.founder.rhip.ehr.common.EHRConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.ehr.dto.HbpDiCensus;
import com.founder.rhip.ehr.dto.MedicineCensus;
import com.founder.rhip.ehr.repository.statistics.IMedicineCensusDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;

@Service("medicineCensusService")
public class MedicineCensusServiceImpl extends AbstractService implements ImedicineCensusService {
	private static final String ORGCODE = "orgCode";
	private static final String CENTERORGCODE = "centerOrgCode";
	private static final String GBCODE = "gbcode";
	
	@Resource(name = "medicineCensusDao")
	private IMedicineCensusDao medicineCensusDao;

	@Autowired
	private IOrganizationApp organizationApp;
	
	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Override
	public List<MedicineCensus> MedicineCensusServiceList(Criteria criteria) {
		
		List<MedicineCensus> medicineCensusReports = new ArrayList<>();
		
		// 统计卫生服务站体检进度
		// 统计卫生服务站体检进度
		if (criteria.contains(ORGCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
				}
			if(criteria.contains("month")==false && criteria.contains("year")==true){
				MedicineCensus medicineCensus = null;
				List<MedicineCensus> list = medicineCensusDao.getMedicineCensusList(criteria, null);
				
				if(ObjectUtil.isNotEmpty(list)){
					medicineCensus = list.get(0);
				}
				
				if(ObjectUtil.isNullOrEmpty(medicineCensus)){
					medicineCensus=new MedicineCensus();
				}
				medicineCensus.setOrgCode(criteria.get(ORGCODE).toString());
				medicineCensusReports.add(medicineCensus);
			}else{
				if(criteria.contains("qwgzxCode")) {
					criteria.remove("qwgzxCode");
				}
				if (criteria.contains("gbcode")) {
					String gbCode=(String)criteria.get("gbcode");
					criteria.remove("gbcode");
					criteria.add("gbCode",gbCode);
				}
				
				List<MedicineCensus> list = medicineCensusDao.getMedicineCensusList(criteria, null);
				MedicineCensus medicineCensus = null;
				if(ObjectUtil.isNotEmpty(list)){
					medicineCensus = list.get(0);
				}
				
				if(medicineCensus==null){
					medicineCensus = new MedicineCensus();
				}
				medicineCensus.setOrgCode(criteria.get(ORGCODE).toString());
				medicineCensusReports.add(medicineCensus);
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
            
            List<MedicineCensus> list = medicineCensusDao.getMedicineCensusList(criteria, organCodeList);
            medicineCensusReports.addAll(list);
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
				List<MedicineCensus> list = medicineCensusDao.getMedicineCensusList(criteria, organCodeList);
				medicineCensusReports.addAll(list);
			}else{
				List<String> organCodeList=new ArrayList<>();
				for (Organization organization : centres) {
                	organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
						organCodeList.add(organization1.getOrganCode());
					}
                }
				 
				List<MedicineCensus> list = medicineCensusDao.getMedicineCensusList(criteria, organCodeList);
				Map<String, MedicineCensus> map = new HashMap<String, MedicineCensus>();
				for (MedicineCensus census : list) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					MedicineCensus census = map.get(organization.getOrganCode());
					if(census == null){
						census = new MedicineCensus();
						census.setOrgCode(organization.getOrganCode());
					}
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						if(map.get(organization1.getOrganCode()) != null)
							countCensus(census,map.get(organization1.getOrganCode()));
					}
					medicineCensusReports.add(census);
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
				 
				List<MedicineCensus> list = medicineCensusDao.getMedicineCensusList(criteria, organCodeList);
				Map<String, MedicineCensus> map = new HashMap<String, MedicineCensus>();
				for (MedicineCensus census : list) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					MedicineCensus census = map.get(organization.getOrganCode());
					if(census == null){
						census = new MedicineCensus();
						census.setOrgCode(organization.getOrganCode());
					}
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						if(map.get(organization1.getOrganCode()) != null)
							countCensus(census,map.get(organization1.getOrganCode()));
					}
					medicineCensusReports.add(census);
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
				
	            List<MedicineCensus> list = medicineCensusDao.getMedicineCensusList(criteria, organCodeList);
				Map<String, MedicineCensus> map = new HashMap<String, MedicineCensus>();
	            for(MedicineCensus census :list){
					map.put(census.getOrgCode(), census);
				}
	            
	            for (DicItem dicItem : dicItems) {
	            	criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
					
					for (Organization organization : centres) {
						MedicineCensus census = map.get(organization.getOrganCode());
						if(census == null){
							census = new MedicineCensus();
							census.setOrgCode(organization.getOrganCode());
						}
	                    List<Organization> stations = getStation(organization.getOrganCode());
	                    for (Organization organization1 : stations) {
	                    	if(map.get(organization1.getOrganCode()) != null)
	                    		countCensus(census, map.get(organization1.getOrganCode()));
						}
	                    medicineCensusReports.add(census);
					}
				}
			}
		}
		for(MedicineCensus mc :medicineCensusReports){
			mc.setGbCode(organizationApp.queryOrgan(mc.getOrgCode()).getGbCode());
		}
		return medicineCensusReports;
	}
	
	private void countCensus(MedicineCensus census, MedicineCensus medicineCensus) {
		census.setHouseholdGreatSixfNum(census.getHouseholdGreatSixfNum() + (medicineCensus.getHouseholdGreatSixfNum()==null ? 0 :medicineCensus.getHouseholdGreatSixfNum()));
		census.setMedicineGreatSixfNum(census.getMedicineGreatSixfNum() + (medicineCensus.getMedicineGreatSixfNum()==null?0:medicineCensus.getMedicineGreatSixfNum()));
		census.setDiCount(census.getDiCount() + (medicineCensus.getDiCount()==null?0:medicineCensus.getDiCount()));
		census.setHbpCount(census.getHbpCount() + (medicineCensus.getHbpCount()==null?0:medicineCensus.getHbpCount()));
		census.setDiManageCount(census.getDiManageCount() + (medicineCensus.getDiManageCount()==null ?0:medicineCensus.getDiManageCount()));
		
		census.setHbpServeCount(census.getHbpServeCount() + (medicineCensus.getHbpServeCount()==null?0:medicineCensus.getHbpServeCount()));
		census.setWomenCount(census.getWomenCount() + (medicineCensus.getWomenCount()==null?0:medicineCensus.getWomenCount()));
		census.setWomenServeCount(census.getWomenServeCount() + (medicineCensus.getWomenServeCount()==null?0:medicineCensus.getWomenServeCount()));
		census.setChildCount(census.getChildCount() + (medicineCensus.getChildCount()==null?0:medicineCensus.getChildCount()));
		census.setChildServeCount(census.getChildServeCount() + (medicineCensus.getChildServeCount()==null?0:medicineCensus.getChildServeCount()));
	}

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
	
}
