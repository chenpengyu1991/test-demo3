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
import com.founder.rhip.ehr.dto.ChildCensus;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.ehr.dto.HbpDiCensus;
import com.founder.rhip.ehr.repository.statistics.IDoctorSignCensusDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;

@Service("doctorSignCensusService")
public class DoctorSignCensusServiceImpl extends AbstractService implements IDoctorSignCensusService {
	private static final String ORGCODE = "orgCode";
	private static final String CENTERORGCODE = "centerOrgCode";
	private static final String GBCODE = "gbcode";
	
	@Resource(name = "doctorSignCensusDao")
	private IDoctorSignCensusDao doctorSignCensusDao;

	@Autowired
	private IOrganizationApp organizationApp;
	
	@Autowired
	private IDictionaryApp dictionaryApp;
	
	@Override
	public List<DoctorSignCensus> getDoctorSignCensusList(Criteria criteria) {
		
		List<DoctorSignCensus> dsCensusReports = new ArrayList<>();
		
		// 统计卫生服务站体检进度
		// 统计卫生服务站体检进度
		if (criteria.contains(ORGCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
				}
			if(criteria.contains("month")==false && criteria.contains("year")==true){
				
				List<DoctorSignCensus> list = doctorSignCensusDao.getDoctorSignCensusList(criteria, null);
				DoctorSignCensus dsCensus = null;
				
				if(ObjectUtil.isNotEmpty(list)){
					dsCensus = list.get(0);
				}
				
				if(ObjectUtil.isNullOrEmpty(dsCensus)){
					dsCensus=new DoctorSignCensus();
				}
				dsCensus.setOrgCode(criteria.get(ORGCODE).toString());
				dsCensusReports.add(dsCensus);
			}else{
				if(criteria.contains("qwgzxCode")) {
					criteria.remove("qwgzxCode");
				}
				if (criteria.contains("gbcode")) {
					String gbCode=(String)criteria.get("gbcode");
					criteria.remove("gbcode");
					criteria.add("gbCode",gbCode);
				}
				List<DoctorSignCensus> list = doctorSignCensusDao.getDoctorSignCensusList(criteria, null);
				DoctorSignCensus dsCensus = null;
				
				if(ObjectUtil.isNotEmpty(list)){
					dsCensus = list.get(0);
				}
				
				if(dsCensus==null){
					dsCensus = new DoctorSignCensus();
				}
				dsCensus.setOrgCode(criteria.get(ORGCODE).toString());
				dsCensusReports.add(dsCensus);
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
            
            List<DoctorSignCensus> dsCensusList = doctorSignCensusDao.getDoctorSignCensusList(criteria, organCodeList);
            dsCensusReports.addAll(dsCensusList);
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
				List<DoctorSignCensus> dsCensusList = doctorSignCensusDao.getDoctorSignCensusList(criteria, organCodeList);
				dsCensusReports.addAll(dsCensusList);
			}else{
				List<String> organCodeList=new ArrayList<>();
				for (Organization organization : centres) {
                	organCodeList.add(organization.getOrganCode());
                    List<Organization> stations = getStation(organization.getOrganCode());
                    for (Organization organization1 : stations) {
						organCodeList.add(organization1.getOrganCode());
					}
                }
				 
				List<DoctorSignCensus> dsCensusList = doctorSignCensusDao.getDoctorSignCensusList(criteria, organCodeList);
				Map<String, DoctorSignCensus> map = new HashMap<String, DoctorSignCensus>();
				for (DoctorSignCensus census : dsCensusList) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					DoctorSignCensus census = map.get(organization.getOrganCode());
					if(census == null){
						census = new DoctorSignCensus();
						census.setOrgCode(organization.getOrganCode());
					}
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						if(map.get(organization1.getOrganCode()) != null)
							countCensus(census,map.get(organization1.getOrganCode()));
					}
					dsCensusReports.add(census);
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
				 
				List<DoctorSignCensus> dsCensusList = doctorSignCensusDao.getDoctorSignCensusList(criteria, organCodeList);
				Map<String, DoctorSignCensus> map = new HashMap<String, DoctorSignCensus>();
				for (DoctorSignCensus census : dsCensusList) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					DoctorSignCensus census = map.get(organization.getOrganCode());
					if(census == null){
						census = new DoctorSignCensus();
						census.setOrgCode(organization.getOrganCode());
					}
					List<Organization> stations = getStation(organization.getOrganCode());
					for (Organization organization1 : stations) {
						if(map.get(organization1.getOrganCode()) != null)
							countCensus(census,map.get(organization1.getOrganCode()));
					}
					dsCensusReports.add(census);
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
				
	            List<DoctorSignCensus> dsCensusList = doctorSignCensusDao.getDoctorSignCensusList(criteria, organCodeList);
				Map<String, DoctorSignCensus> map = new HashMap<String, DoctorSignCensus>();
	            for(DoctorSignCensus census :dsCensusList){
					map.put(census.getOrgCode(), census);
				}
	            
	            for (DicItem dicItem : dicItems) {
	            	criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
					
					for (Organization organization : centres) {
						DoctorSignCensus census = map.get(organization.getOrganCode());
						if(census == null){
							census = new DoctorSignCensus();
							census.setOrgCode(organization.getOrganCode());
						}
	                    List<Organization> stations = getStation(organization.getOrganCode());
	                    for (Organization organization1 : stations) {
	                    	if(map.get(organization1.getOrganCode()) != null)
	                    		countCensus(census, map.get(organization1.getOrganCode()));
						}
	                    dsCensusReports.add(census);
					}
				}
			}
		}
		return dsCensusReports;
	}
	
	private void countCensus(DoctorSignCensus census, DoctorSignCensus doctorSignCensus) {
		census.setChildNum(census.getChildNum() + doctorSignCensus.getChildNum());
		census.setChildSignNum(census.getChildSignNum() + doctorSignCensus.getChildSignNum());
		census.setDiHasNum(census.getDiHasNum() + doctorSignCensus.getDiHasNum());
		census.setDiNum(census.getDiNum() + doctorSignCensus.getDiNum());
		census.setDiSignNum(census.getDiSignNum() + doctorSignCensus.getDiSignNum());
		
		census.setDoctorTeamNum(census.getDoctorTeamNum() + doctorSignCensus.getDoctorTeamNum());
		census.setFamilyVisitNum(census.getFamilyVisitNum() + doctorSignCensus.getFamilyVisitNum());
		census.setFocusGroupsNum(census.getFocusGroupsNum() + doctorSignCensus.getFocusGroupsNum());
		census.setFocusGroupsSignNum(census.getFocusGroupsSignNum() + doctorSignCensus.getFocusGroupsSignNum());
		census.setGreatSixfHasNum(census.getGreatSixfHasNum() + doctorSignCensus.getGreatSixfHasNum());
		
		census.setGreatSixfSignNum(census.getGreatSixfSignNum() + doctorSignCensus.getGreatSixfSignNum());
		census.setHbpHasNum(census.getHbpHasNum() + doctorSignCensus.getHbpHasNum());
		census.setHbpNum(census.getHbpNum() + doctorSignCensus.getHbpNum());
		census.setHbpSignNum(census.getHbpSignNum() + doctorSignCensus.getHbpSignNum());
		census.setHouseholdGreatSixfNum(census.getHouseholdGreatSixfNum() + doctorSignCensus.getHouseholdGreatSixfNum());
		
		census.setHouseholdNum(census.getHouseholdNum() + doctorSignCensus.getHouseholdNum());
		census.setPermanentNum(census.getPermanentNum() + doctorSignCensus.getPermanentNum());
		census.setPermanentSignNum(census.getPermanentSignNum() + doctorSignCensus.getPermanentSignNum());
		census.setWomenNum(census.getWomenNum() + doctorSignCensus.getWomenNum());
		census.setWomenSignNum(census.getWomenSignNum() + doctorSignCensus.getWomenSignNum());
		
		census.setTubercManageNum(census.getTubercManageNum() +  doctorSignCensus.getTubercManageNum());
		census.setTubercSignNum(census.getTubercSignNum() + doctorSignCensus.getTubercSignNum());
		census.setMentalManageNum(census.getMentalManageNum() + doctorSignCensus.getMentalManageNum());
		census.setMentalSignNum(census.getMentalSignNum() + doctorSignCensus.getMentalSignNum());
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
