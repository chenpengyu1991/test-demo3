package com.founder.rhip.ehr.service.basic;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.rhip.ehr.entity.basic.OrganizationItemRelation;
import com.founder.rhip.ehr.repository.basic.IOrganizationItemRelationDao;
import com.founder.rhip.ehr.service.basic.IOrganizationItemRelationService;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;

@Service("organizationItemRelationService")
public class OrganizationItemRelationServiceImpl extends AbstractService implements IOrganizationItemRelationService {

	@Resource(name = "organizationItemRelationDao")
	private IOrganizationItemRelationDao organizationItemRelationDao;
	
	@Override
	public List<OrganizationItemRelation> getOrganizationItemRelation(
			Criteria criteria) {
		List<OrganizationItemRelation> orgItems = new ArrayList<OrganizationItemRelation>();
		orgItems = organizationItemRelationDao.getList(criteria);
		return orgItems;
	}

	@Override
	@Transactional
	public int delete(Criteria criteria) {
		return organizationItemRelationDao.delete(criteria);
	}

	@Override
	@Transactional
	public int save(List<OrganizationItemRelation> orgItems) {
		
		return organizationItemRelationDao.batchInsert(orgItems);
	}

}
