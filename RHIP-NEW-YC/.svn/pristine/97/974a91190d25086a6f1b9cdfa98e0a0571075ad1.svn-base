package com.founder.rhip.ehr.service.orgotherinfo;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.rhip.ehr.entity.basic.OrganizationOldPeopleHomeRelation;
import com.founder.rhip.ehr.repository.basic.IOrganizationOldPeopleHomedRelationDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;

@Service("orgOldPeopleHomeRelationService")
public class OrgOldPeopleHomeRelationServiceImpl implements IOrgOldPeopleHomeRelationService {

	@Resource(name = "organizationOldPeopleHomedRelationDao")
	private IOrganizationOldPeopleHomedRelationDao organizationOldPeopleHomedRelationDao;

	@Override
	@Transactional
	public void createOrgOldPeopleHomeRelation(
			OrganizationOldPeopleHomeRelation OrgOldPeopleHomeRelation) {
		Criteria criteria = new Criteria("organizationId", OrgOldPeopleHomeRelation.getOrganizationId());
		OrganizationOldPeopleHomeRelation OrgOldPeopleHomeRe = organizationOldPeopleHomedRelationDao.get(criteria);
		if(ObjectUtil.isNullOrEmpty(OrgOldPeopleHomeRe)){
			organizationOldPeopleHomedRelationDao.insert(OrgOldPeopleHomeRelation);
		}else {
			organizationOldPeopleHomedRelationDao.update(OrgOldPeopleHomeRelation);
		}
	}

	@Override
	@Transactional
	public void deleteOrgOldPeopleHomeRelation(Integer organizationId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public void updateOrgOldPeopleHomeRelation(
			OrganizationOldPeopleHomeRelation OrgOldPeopleHomeRelation) {
		organizationOldPeopleHomedRelationDao.update(OrgOldPeopleHomeRelation);
	}


}
