package com.founder.rhip.ehr.service.orgotherinfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.rhip.ehr.entity.basic.OrganizationSchoolRelation;
import com.founder.rhip.ehr.repository.basic.IOrganizationSchoolRelationDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;

@Service("orgSchoolRelationService")
public class OrgSchoolRelationServiceImpl implements IOrgSchoolRelationService {

	@Resource(name = "organizationSchoolRelationDao")
	private IOrganizationSchoolRelationDao organizationSchoolRelationDao;

	@Override
	@Transactional
	public void createOrgSchoolRelation(OrganizationSchoolRelation orgSchoolRelation) {
		Criteria criteria = new Criteria("organizationId", orgSchoolRelation.getOrganizationId()); 
		OrganizationSchoolRelation orgSchoolRe = organizationSchoolRelationDao.get(criteria);
		if(ObjectUtil.isNullOrEmpty(orgSchoolRe)){
			organizationSchoolRelationDao.insert(orgSchoolRelation);
		}else {
			organizationSchoolRelationDao.update(orgSchoolRelation);
		}
	}

	@Override
	@Transactional
	public void deleteOrgSchoolcRelation(Integer organizationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateOrgSchoolcRelation(
			OrganizationSchoolRelation orgSchoolRelation) {
		organizationSchoolRelationDao.update(orgSchoolRelation);
	}

}
