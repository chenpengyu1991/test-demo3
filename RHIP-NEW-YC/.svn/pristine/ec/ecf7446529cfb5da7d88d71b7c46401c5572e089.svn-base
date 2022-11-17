package com.founder.rhip.ehr.service.orgotherinfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.rhip.ehr.entity.basic.OrganizationEconomicRelation;
import com.founder.rhip.ehr.repository.basic.IOrganizationEconomicRelationDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;

@Service("orgEconomicRelationService")
public class OrgEconomicRelationServiceImpl implements IOrgEconomicRelationService {

	@Resource(name = "organizationEconomicRelationDao")
	private IOrganizationEconomicRelationDao organizationEconomicRelationDao;

	@Override
	@Transactional
	public void createOrgEconomicRelation(OrganizationEconomicRelation orgEconomicRelation) {
		Criteria criteria = new Criteria("organizationId", orgEconomicRelation.getOrganizationId());
		OrganizationEconomicRelation OrganizationEconomicRe = organizationEconomicRelationDao.get(criteria);
		if(ObjectUtil.isNullOrEmpty(OrganizationEconomicRe)){
			organizationEconomicRelationDao.insert(orgEconomicRelation);
		}else {
			organizationEconomicRelationDao.update(orgEconomicRelation);
		}
	}

	@Override
	@Transactional
	public void deleteOrgEconomicRelation(Integer organizationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateOrgEconomicRelation(
			OrganizationEconomicRelation OrgEconomicRelation) {
		organizationEconomicRelationDao.update(OrgEconomicRelation);
	}

}
