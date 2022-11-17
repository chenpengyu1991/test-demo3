package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.dto.DoctorSignCensus;
import com.founder.rhip.ehr.dto.InfectEmergencies;
import com.founder.rhip.ehr.dto.VaccinationService;
import com.founder.rhip.ehr.repository.statistics.IInfectiousEmergenciesDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.common.OrgGenreCode;
import com.founder.rhip.mdm.entity.DicItem;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.repository.IOrganizationDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yuanzg on 2017/5/8.
 */
@Service("infectiousEmergenciesService")
public class InfectiousEmergenciesServiceImpl extends AbstractService implements IInfectiousEmergenciesService {
	private static final String ORGCODE = "orgCode";
	private static final String CENTERORGCODE = "centerOrgCode";
	private static final String GBCODE = "gbcode";
	
    @Resource(name = "infectEmergenciesDao")
    private IInfectiousEmergenciesDao infectiousEmergenciesDao;

    @Resource(name = "mdmOrganizationDao")
    private IOrganizationDao organizationDao;
    
	@Autowired
	private IOrganizationApp organizationApp;
	
	@Autowired
	private IDictionaryApp dictionaryApp;

    @Override
    public InfectEmergencies getInfectEmerGency(Criteria criteria) {
        return infectiousEmergenciesDao.get(criteria);
    }

    @Override
    public List<InfectEmergencies> getInfectEmergencyList(Criteria criteria) {
        return infectiousEmergenciesDao.getList(criteria);
    }

    @Override
    public void save(InfectEmergencies infectEmergencies) {
        infectiousEmergenciesDao.insert(infectEmergencies);
    }

    @Override
    public void update(InfectEmergencies infectEmergencies) {
        infectiousEmergenciesDao.update(infectEmergencies);
    }

    //获取本中心以及下属站的所有数据
    @Override
    public List<InfectEmergencies> getInfectEmerOrgList(String searchOrg, String countType, String parentOrg, int year, int quarter) {
        return infectiousEmergenciesDao.getInfectEmerOrgList(searchOrg, countType, parentOrg, year, quarter);
    }

    @Override
    public Map<String, Object> CountZXTotal(String parentOrg, int year, int quarter) {
        return infectiousEmergenciesDao.getZXTotal(parentOrg, year, quarter);
    }

    @Override
    public Map<String, Object> countAll(int year, int quarter, String genreCode) {
        return infectiousEmergenciesDao.countAll(year, quarter, genreCode);
    }

    @Override
    public Map<String, Object> countYearOrg(String orgCode, int year) {
        return infectiousEmergenciesDao.countYearOrg(orgCode, year);
    }

    //获取卫管中心管辖区域的所有中心
    public List<InfectEmergencies> getWGAllZX(String gbCode, int year, int quarter) {
        List<Organization> organList = organizationDao.getList(new Criteria("gbCode", gbCode).add("genreCode", "B1"));
        List<InfectEmergencies> infectList = new ArrayList<InfectEmergencies>();
        for (Organization organization : organList) {
            /*InfectEmergencies infect = infectiousEmergenciesDao.get(new Criteria("orgCode", organization.getOrganCode()).add("year", year).add("quarter", quarter));
            if (ObjectUtil.isNullOrEmpty(infect)) {
                InfectEmergencies infectNew = new InfectEmergencies();
                infectNew.setOrgName(organization.getOrganName());
                infectNew.setOrgCode(organization.getOrganCode());
                infectList.add(infectNew);
            }else {
                infectList.add(infect);
            }*/
            InfectEmergencies infectEmergencies = new InfectEmergencies();
            Map<String, Object> mapZX =CountZXTotal(organization.getOrganCode(), year, quarter);
            infectEmergencies = setField(mapZX);
            infectEmergencies.setOrgName(organization.getOrganName());
            infectList.add(infectEmergencies);
        }
        return infectList;
    }

    public Map<String,Object> countWGAllZX(int year,int quarter,String genreCode,String gbCode){
        return infectiousEmergenciesDao.countWGAllZX(year,quarter,genreCode,gbCode);
    }

    //计算中心及下属站的总和
    private InfectEmergencies setField(Map<String, Object> map) {
        InfectEmergencies infectEmergencies = new InfectEmergencies();
        if (ObjectUtil.isNotEmpty(map.get("AllOcInfect"))) {
            infectEmergencies.setOccurInfectiousNum(Integer.parseInt(map.get("AllOcInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllReInfect"))) {
            infectEmergencies.setReportInfectiousNum(Integer.parseInt(map.get("AllReInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllTimInfect"))) {
            infectEmergencies.setTimelyInfectiousNum(Integer.parseInt(map.get("AllTimInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllOcEmer"))) {
            infectEmergencies.setOccurEmergenciesNum(Integer.parseInt(map.get("AllOcEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllReEmer"))) {
            infectEmergencies.setReportEmergenciesNum(Integer.parseInt(map.get("AllReEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllTimEmer"))) {
            infectEmergencies.setTimelyEmergenciesNum(Integer.parseInt(map.get("AllTimEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllNetRep"))) {
            infectEmergencies.setNetReportDeathnum(Integer.parseInt(map.get("AllNetRep").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearOcInfect"))) {
            infectEmergencies.setYearOccurInfectiousNum(Integer.parseInt(map.get("AllYearOcInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearReInfect"))) {
            infectEmergencies.setYearReportInfectiousNum(Integer.parseInt(map.get("AllYearReInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearTimInfect"))) {
            infectEmergencies.setYearTimelyInfectiousNum(Integer.parseInt(map.get("AllYearTimInfect").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearOcEmer"))) {
            infectEmergencies.setYearOccurEmergenciesNum(Integer.parseInt(map.get("AllYearOcEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearReEmer"))) {
            infectEmergencies.setYearReportEmergenciesNum(Integer.parseInt(map.get("AllYearReEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearTimEmer"))) {
            infectEmergencies.setYearTimelyEmergenciesNum(Integer.parseInt(map.get("AllYearTimEmer").toString()));
        }
        if (ObjectUtil.isNotEmpty(map.get("AllYearNetRep"))) {
            infectEmergencies.setYearNetReportDeathnum(Integer.parseInt(map.get("AllYearNetRep").toString()));
        }
        infectEmergencies.setOrgName("合计");
        return infectEmergencies;
    }

	@Override
	public List<InfectEmergencies> getInfectEmergenciesList(Criteria criteria) {
		List<InfectEmergencies> reports = new ArrayList<>();
		// 统计卫生服务站体检进度
		// 统计卫生服务站体检进度
		if (criteria.contains(ORGCODE)) {
			if(criteria.contains("qwgzxCode")) {
				criteria.remove("qwgzxCode");
				}
			if(criteria.contains("month")==false && criteria.contains("year")==true){
				
				List<InfectEmergencies> list = infectiousEmergenciesDao.getInfectEmergenciesList(criteria, null);
				InfectEmergencies census = null;
				
				if(ObjectUtil.isNotEmpty(list)){
					census = list.get(0);
				}
				
				if(ObjectUtil.isNullOrEmpty(census)){
					census=new InfectEmergencies();
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
				List<InfectEmergencies> list = infectiousEmergenciesDao.getInfectEmergenciesList(criteria, null);
				InfectEmergencies census = null;
				
				if(ObjectUtil.isNotEmpty(list)){
					census = list.get(0);
				}
				
				if(census==null){
					census = new InfectEmergencies();
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
            
            List<InfectEmergencies> list = infectiousEmergenciesDao.getInfectEmergenciesList(criteria, organCodeList);
            //信息补全
			Map<String, InfectEmergencies> map = new HashMap<String, InfectEmergencies>();
			for (InfectEmergencies census : list) {
				map.put(census.getOrgCode(), census);
			}
			
			for(String str : organCodeList){
				if(map.get(str) == null){
					InfectEmergencies census  = new InfectEmergencies();
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
				List<InfectEmergencies> list = infectiousEmergenciesDao.getInfectEmergenciesList(criteria, organCodeList);
				
				//信息补全
				Map<String, InfectEmergencies> map = new HashMap<String, InfectEmergencies>();
				for (InfectEmergencies census : list) {
					map.put(census.getOrgCode(), census);
				}
				
				for(String str : organCodeList){
					if(map.get(str) == null){
						InfectEmergencies census  = new InfectEmergencies();
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
				 
				List<InfectEmergencies> list = infectiousEmergenciesDao.getInfectEmergenciesList(criteria, organCodeList);
				Map<String, InfectEmergencies> map = new HashMap<String, InfectEmergencies>();
				for (InfectEmergencies census : list) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					InfectEmergencies census = map.get(organization.getOrganCode());
					if(census == null){
						census = new InfectEmergencies();
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
				 
				List<InfectEmergencies> list = infectiousEmergenciesDao.getInfectEmergenciesList(criteria, organCodeList);
				Map<String, InfectEmergencies> map = new HashMap<String, InfectEmergencies>();
				for (InfectEmergencies census : list) {
					map.put(census.getOrgCode(), census);
				}

				for (Organization organization : centres) {
					InfectEmergencies census = map.get(organization.getOrganCode());
					if(census == null){
						census = new InfectEmergencies();
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
				
	            List<InfectEmergencies> list = infectiousEmergenciesDao.getInfectEmergenciesList(criteria, organCodeList);
				Map<String, InfectEmergencies> map = new HashMap<String, InfectEmergencies>();
	            for(InfectEmergencies census :list){
					map.put(census.getOrgCode(), census);
				}
	            
	            for (DicItem dicItem : dicItems) {
	            	criteria.remove(GBCODE);
					criteria.add(GBCODE, dicItem.getItemCode());
					List<Organization> centres = getCentre(String.valueOf(criteria.get(GBCODE)));
					
					for (Organization organization : centres) {
						InfectEmergencies census = map.get(organization.getOrganCode());
						if(census == null){
							census = new InfectEmergencies();
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
		for(InfectEmergencies ie :reports){
			ie.setGbCode(organizationApp.queryOrgan(ie.getOrgCode()).getGbCode());
		}	
		return reports;
	}


	private void countCensus(InfectEmergencies census,InfectEmergencies infectEmergencies) {
		census.setOccurInfectiousNum(census.getOccurInfectiousNum() + infectEmergencies.getOccurInfectiousNum());		
		census.setReportInfectiousNum(census.getReportInfectiousNum() + infectEmergencies.getReportInfectiousNum());		
		census.setTimelyInfectiousNum(census.getTimelyInfectiousNum() + infectEmergencies.getTimelyInfectiousNum());		
		census.setOccurEmergenciesNum(census.getOccurEmergenciesNum() + infectEmergencies.getOccurEmergenciesNum());		
		census.setReportEmergenciesNum(census.getReportEmergenciesNum() + infectEmergencies.getReportEmergenciesNum());		
	
		census.setTimelyEmergenciesNum(census.getTimelyEmergenciesNum() + infectEmergencies.getTimelyEmergenciesNum());		
		census.setNetReportDeathnum(census.getNetReportDeathnum() + infectEmergencies.getNetReportDeathnum());		
		census.setRegisterInfectiousNum(census.getRegisterInfectiousNum() + infectEmergencies.getRegisterInfectiousNum());		
		census.setNetworkInfectiousNum(census.getNetworkInfectiousNum() + infectEmergencies.getNetworkInfectiousNum());		
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
