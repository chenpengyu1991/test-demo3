package com.founder.rhip.ehr.service.statistics.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.repository.basic.IPersonInfoDao;
import com.founder.rhip.ehr.repository.basic.IPopulaceDao;
import com.founder.rhip.ehr.repository.statistics.IHaStatisticsDao;
import com.founder.rhip.ehr.service.statistics.IOrganRelationManageService;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;

@Service("organRelationManageService")
public class OrganRelationManageServiceImpl implements IOrganRelationManageService{
	@Resource(name = "dictionaryApp")
	private IDictionaryApp dictionaryApp;
	
	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;  
	
	@Resource(name = "populaceDao")
	private IPopulaceDao populaceDao;  
	
	@Resource(name = "personInfoDao")
	private IPersonInfoDao personInfoDao;  
	
	@Resource(name = "haStatisticsDao")
	private IHaStatisticsDao haStatisticsDao;  
	
	@Override
	public void doManage() {
		List<Organization> orgsCenter=organizationApp.queryOrganization(new Criteria("parentCode","0"));
		List<Organization> orgsZhan=organizationApp.queryOrganization(new Criteria("parentCode",OP.NE,"0"));
		for (Organization orgZhan : orgsZhan) {
			//更新Populace
			Parameters p1=new Parameters();
			p1.add("organParentCode", orgZhan.getParentCode());
			p1.add("gBCode", orgZhan.getGbCode());
			populaceDao.update(p1, new Criteria("organCode", orgZhan.getOrganCode()));
			//更新Populace
			Parameters p2=new Parameters();
			p2.add("inputCenterOrganCode", orgZhan.getParentCode());
			p2.add("inputGbcode", orgZhan.getGbCode());
			personInfoDao.update(p2, new Criteria("inputOrganCode", orgZhan.getOrganCode()));
			//更新HaStatistics
			Parameters p3=new Parameters();
			p3.add("gbcode", orgZhan.getGbCode());
			haStatisticsDao.update(p3, new Criteria("orgCode", orgZhan.getOrganCode()));
			
//			System.out.println("====" + orgZhan.getOrganCode());
		}
		
		for (Organization orgCenter : orgsCenter) {
			//更新Populace
			//更新HaStatistics
			Parameters p3 = new Parameters();
			p3.add("gbcode", orgCenter.getGbCode());
			haStatisticsDao.update(p3, new Criteria("orgCode", orgCenter.getOrganCode()));
//			System.out.println("==1==" + orgCenter.getOrganCode());
		}
	}
	
	@Override
	public void doChangeOrg(){
		List<String> orgCodes1 = populaceDao.getOrgCodes();
		List<String> orgCodes2 = personInfoDao.getOrgCodes();
		
		List<Organization> orgsZhan=organizationApp.queryOrganization(new Criteria("parentCode",OP.NE,"0"));
		
		List<String> vorgs1 = getOrgs(orgsZhan,orgCodes1);
		List<String> vorgs2 = getOrgs(orgsZhan,orgCodes2);
		
		Parameters p1=new Parameters();
		p1.add("organCode", 320003222);
		populaceDao.update(p1, new Criteria("organCode",OP.IS, " NULL "));
		
		for(String org:vorgs1){
			populaceDao.update(p1, new Criteria("organCode", org));
			System.out.println(org + "====320003222");
		}
		
		Parameters p2=new Parameters();
		p2.add("inputOrganCode", 320003222);
		personInfoDao.update(p2, new Criteria("inputOrganCode",OP.IS, " NULL "));
		
		for(String org:vorgs2){
			personInfoDao.update(p2, new Criteria("inputOrganCode", org));
			System.out.println(org + "====320003222");
		}
	}
	
	private List<String> getOrgs(List<Organization> orgsZhan,List<String> orgCodes1){
		List<String> orgs = new ArrayList<String>();
		for(String orgString:orgCodes1){
			boolean isIn = false;
			for(Organization org: orgsZhan){
				if(orgString.equals(org.getOrganCode())){
					isIn = true;
					break;
				}
			}
			if(isIn){
				continue;
			}
			orgs.add(orgString);
		}
		return orgs;
	}
}
