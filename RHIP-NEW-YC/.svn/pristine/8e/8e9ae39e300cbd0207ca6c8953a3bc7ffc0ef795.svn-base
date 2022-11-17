package com.founder.rhip.ehr.service.orgotherinfo;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.rhip.ehr.entity.basic.OrganizationEnvironmentRelation;
import com.founder.rhip.ehr.repository.basic.IOrganizationEnvironmentRelationDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;

@Service("orgEnvironmentRelationService")
public class OrgEnvironmentRelationServiceImpl implements IOrgEnvironmentRelationService {

	@Resource(name="organizationEnvironmentRelationDao")
	private IOrganizationEnvironmentRelationDao organizationEnvironmentRelationDao;
	
	@Override
	@Transactional
	public void createOrgEnvironmentRelation(Integer organizationId,String environmentCodes) {
		Criteria criteria = new Criteria("organizationId", organizationId);
		if(ObjectUtil.isNotEmpty(organizationId) && ObjectUtil.isNotEmpty(environmentCodes)){
			organizationEnvironmentRelationDao.delete(criteria);
			for (String environmentCode : StringUtils.split(environmentCodes, ",")) {
				OrganizationEnvironmentRelation orgEnvironmentRe = new OrganizationEnvironmentRelation();
				orgEnvironmentRe.setOrganizationId(organizationId);
				orgEnvironmentRe.setEnvironmentCode(environmentCode);
				organizationEnvironmentRelationDao.insert(orgEnvironmentRe);
			}
		}else if(!ObjectUtil.isNotEmpty(environmentCodes)){
			organizationEnvironmentRelationDao.delete(criteria);
		}

	}

	@Override
	@Transactional
	public void deleteOrgEnvironmentRelation(Integer organizationId) {
		// TODO Auto-generated method stub

	}

}
