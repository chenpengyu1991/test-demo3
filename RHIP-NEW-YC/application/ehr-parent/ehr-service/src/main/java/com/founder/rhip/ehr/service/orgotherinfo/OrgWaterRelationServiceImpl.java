package com.founder.rhip.ehr.service.orgotherinfo;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.rhip.ehr.entity.basic.OrganizationWaterRelation;
import com.founder.rhip.ehr.repository.basic.IOrganizationWaterRelationDao;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.ObjectUtil;

@Service("orgWaterRelationService")
public class OrgWaterRelationServiceImpl implements IOrgWaterRelationService {

	@Resource(name = "organizationWaterRelationDao")
	private IOrganizationWaterRelationDao organizationWaterRelationDao;

	@Override
	@Transactional
	public void createOrgWaterRelation(Integer organizationId,String WaterCodes) {
		Criteria criteria = new Criteria("organizationId", organizationId);
		if(ObjectUtil.isNotEmpty(organizationId) && ObjectUtil.isNotEmpty(WaterCodes)){
			organizationWaterRelationDao.delete(criteria);
			for (String waterCode : StringUtils.split(WaterCodes, ",")) {
				OrganizationWaterRelation orgWaterRe = new OrganizationWaterRelation();
				orgWaterRe.setOrganizationId(organizationId);
				orgWaterRe.setWaterCode(waterCode);
				organizationWaterRelationDao.insert(orgWaterRe);
			}
		}else if(!ObjectUtil.isNotEmpty(WaterCodes)){
			organizationWaterRelationDao.delete(criteria);
		}
	}

	@Override
	@Transactional
	public void deleteOrgWaterRelation(Integer organizationId) {
		Criteria criteria = new Criteria("organizationId", organizationId);
		organizationWaterRelationDao.delete(criteria);
	}
}
