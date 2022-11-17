package com.founder.rhip.ehr.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.FamilyInfo;
import com.founder.rhip.ehr.repository.basic.HistoryRecorder;
import com.founder.rhip.ehr.repository.basic.IFamilyInfoDao;
import com.founder.rhip.mdm.app.IOrganizationApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import com.founder.rhip.mdm.service.IMergerTownListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 家庭机构合并
 * 
 * @author liuk
 * 
 */
@Service("familyOrganizationMergeListener")
public class FamilyOrganizationMergeListener implements IMergerOrganizationListener, IMergerTownListener {

	@Resource(name = "familyInfoDao")
	private IFamilyInfoDao familyInfoDao;

	@Resource(name = "organizationApp")
	private IOrganizationApp organizationApp;

	private void checkNewOrganization(Organization organization) {
		Assert.notNull(organization, "目标机构为空");
		Assert.hasText(organization.getOrganCode(), "目标机构编码为空");
	}

	@Override
	@Transactional
	public void mergeStation(Organization newOrganization, List<Organization> stationList) {
		if (ObjectUtil.isNotEmpty(stationList)) {
			checkNewOrganization(newOrganization);
			// 需要变更的机构
			Set<String> oldOrganCodes = new HashSet<>(stationList.size());
			for (Organization organization : stationList) {
				if (null != organization.getOrganCode()) {
					oldOrganCodes.add(organization.getOrganCode());
				}
			}
			Criteria criteria = new Criteria("inputOrganCode", OP.IN, oldOrganCodes);
			Parameters parameters = new Parameters("inputOrganCode", newOrganization.getOrganCode());
			parameters.add("inputOrganName", newOrganization.getOrganName());
			parameters.add("gBCode", newOrganization.getGbCode());
			HistoryRecorder.record(FamilyInfo.class, familyInfoDao, criteria, new String[] { "id", "inputOrganCode", "gBCode" });
			familyInfoDao.update(parameters, criteria);
			criteria = new Criteria("updateOrgancode", OP.IN, oldOrganCodes);
			parameters = new Parameters("updateOrgancode", newOrganization.getOrganCode());
			parameters.add("updateOrganname", newOrganization.getOrganName());
			familyInfoDao.update(parameters, criteria);
		}
	}

	@Override
	public void moveStation(Organization center, List<Organization> stationList) {
		if (ObjectUtil.isNotEmpty(stationList)) {
			checkNewOrganization(center);
			// 需要变更的机构
			Set<String> oldOrganCodes = new HashSet<>(stationList.size());
			for (Organization organization : stationList) {
				if (null != organization.getOrganCode()) {
					oldOrganCodes.add(organization.getOrganCode());
				}
			}
			Criteria criteria = new Criteria("inputOrganCode", OP.IN, oldOrganCodes);
			Parameters parameters = new Parameters("gBCode", center.getGbCode());
			HistoryRecorder.record(FamilyInfo.class, familyInfoDao, criteria, new String[] { "id", "gBCode" });
			familyInfoDao.update(parameters, criteria);
		}
	}

	@Override
	public void mergeCenter(Organization center, List<Organization> centerList) {
		if (ObjectUtil.isNotEmpty(centerList)) {
			checkNewOrganization(center);
			// 需要变更的机构
			Set<String> oldOrganCodes = new HashSet<>(centerList.size());
			for (Organization organization : centerList) {
				if (null != organization.getOrganCode()) {
					oldOrganCodes.add(organization.getOrganCode());
				}
			}
			Criteria criteria = new Criteria("inputOrganCode", OP.IN, oldOrganCodes);
			Parameters parameters = new Parameters("inputOrganCode", center.getOrganCode());
			parameters.add("inputOrganName", center.getOrganName());
			parameters.add("gBCode", center.getGbCode());
			HistoryRecorder.record(FamilyInfo.class, familyInfoDao, criteria, new String[] { "id", "inputOrganCode", "gBCode" });
			familyInfoDao.update(parameters, criteria);
			criteria = new Criteria("updateOrgancode", OP.IN, oldOrganCodes);
			parameters = new Parameters("updateOrgancode", center.getOrganCode());
			parameters.add("updateOrganname", center.getOrganName());
			familyInfoDao.update(parameters, criteria);
		}
	}

	@Override
	public void mergeTown(String newTownCode, String[] oldTownCode) {
		Assert.hasText(newTownCode, "合并后的镇编码为空");
		Assert.notEmpty(oldTownCode, "需要和并的镇编码为空");

		Criteria criteria = new Criteria("patownShip", OP.IN, oldTownCode);//镇 合并后修改镇的机构编码
		Parameters parameters = new Parameters("patownShip", newTownCode);
//		HistoryRecorder.record(FamilyInfo.class, familyInfoDao, criteria, new String[] { "id", "pacounty"});
		familyInfoDao.update(parameters, criteria);
	}

	@Override
	public void sendTownVillageRelation(String newTownCode, String[] newAddVillageCodes) {
		Assert.hasText(newTownCode, "需要迁移到的镇编码为空");
		Assert.notEmpty(newAddVillageCodes, "需要迁移的社区编码为空");
		// 更新现住址镇
		Criteria criteria = new Criteria("patownShip", OP.IN, newAddVillageCodes);
		Parameters parameters = new Parameters("patownShip", newTownCode);
		HistoryRecorder.record(FamilyInfo.class, familyInfoDao, criteria, new String[] { "id", "patownShip"});
		familyInfoDao.update(parameters, criteria);
	}

	@Override
	public void changeRelationOrgVillage(String orgCode, String[] newAddVillageCodes) {
		Assert.notNull(orgCode, "目标机构编码为空");
		Organization organization = organizationApp.queryOrgan(orgCode);
		Assert.notNull(organization, "目标机构在系统中不存在");
		Assert.notEmpty(newAddVillageCodes, "需要迁移的村编码为空");
		// 更新创建机构
		// 更新现住址镇
		Parameters param = new Parameters("inputOrganCode", orgCode);
		param.add("gBCode", organization.getGbCode());
		param.add("patownShip", organization.getGbCode()); // 现住址 镇
		Criteria criteria = new Criteria("pastreet", OP.IN, newAddVillageCodes);
		HistoryRecorder.record(FamilyInfo.class, familyInfoDao, criteria, new String[] { "id", "inputOrganCode", "gBCode"});
		familyInfoDao.update(param, criteria);
	}
}
