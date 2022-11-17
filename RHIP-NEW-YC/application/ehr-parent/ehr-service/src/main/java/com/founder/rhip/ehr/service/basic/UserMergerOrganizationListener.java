package com.founder.rhip.ehr.service.basic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.rhip.ehr.repository.basic.IUserDao;
import com.founder.rhip.ehr.repository.basic.IUserRoleDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("userMergerOrganizationListener")
public class UserMergerOrganizationListener implements IMergerOrganizationListener {

	@Resource(name = "ehrUserDao")
	private IUserDao ehrUserDao;

	@Resource(name = "ehrUserRoleDao")
	private IUserRoleDao userRoleDao;

	@Override
	@Transactional
	public void mergeStation(Organization station, List<Organization> stationList) {
		updateUserRole(station, stationList);
	}

	@Override
	@Transactional
	public void mergeCenter(Organization center, List<Organization> centerList) {
		updateUserRole(center, centerList);
	}

	/**
	 * 更新用户角色机构中的机构code
	 * @param center
	 * @param centerList
	 */
	private void updateUserRole(Organization center, List<Organization> centerList) {
		Parameters parameters = new Parameters("ORGAN_CODE", center.getOrganCode());
		List<String> organCodes = new ArrayList<String>();
		for (Organization organ : centerList) {
			organCodes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("ORGAN_CODE", OP.IN, organCodes);
		userRoleDao.update(parameters, criteria);

		criteria = new Criteria("LAST_LOGIN_ORG", OP.IN, organCodes);
		parameters = new Parameters("LAST_LOGIN_ORG", center.getOrganCode());
		ehrUserDao.update(parameters, criteria);
	}

	@Override
	@Transactional
	public void moveStation(Organization center, List<Organization> stationList) {
	}

	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
	}
}
