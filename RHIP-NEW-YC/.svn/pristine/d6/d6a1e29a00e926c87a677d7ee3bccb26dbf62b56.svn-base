package com.founder.rhip.ehr.service.orgotherinfo;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.rhip.ehr.entity.basic.OrganizationGarbageRelation;
import com.founder.rhip.ehr.repository.basic.IOrganizationGarbageRelationDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;

@Service("orgGarbageRelationService")
public class OrgGarbageRelationServiceImpl implements IOrgGarbageRelationService {

	@Resource(name = "organizationGarbageRelationDao")
	private IOrganizationGarbageRelationDao organizationGarbageRelationDao;
	
	@Override
	@Transactional
	public void createOrgGarbageRelation(Integer organizationId, String garbageCodes) {
		Criteria criteria = new Criteria("organizationId", organizationId);
		if(ObjectUtil.isNotEmpty(organizationId) && ObjectUtil.isNotEmpty(garbageCodes)){
			organizationGarbageRelationDao.delete(criteria);
			for (String garbageDisposalCode : StringUtils.split(garbageCodes, ",")) {
				OrganizationGarbageRelation orgGarbageRe = new OrganizationGarbageRelation();
				orgGarbageRe.setOrganizationId(organizationId);
				orgGarbageRe.setGarbageDisposalCode(garbageDisposalCode);
				organizationGarbageRelationDao.insert(orgGarbageRe);
			}
		}else if(!ObjectUtil.isNotEmpty(garbageCodes)){
			organizationGarbageRelationDao.delete(criteria);
		}
	}

	@Override
	@Transactional
	public void deleteOrgGarbageRelation(Integer organizationId) {
		// TODO Auto-generated method stub
		
	}
	
}
