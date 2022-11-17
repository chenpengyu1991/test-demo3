package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Record;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.Department;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IDepartmentService;
import com.founder.rhip.mdm.service.IOrganizationService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("organizationApp")
public class OrganizationApp extends MDMBaseApp implements IOrganizationApp {
	
	@Resource(name="mdmOrganizationService")
	private IOrganizationService organizationService;
	
	@Resource(name="mdmDepartmentService")
	private IDepartmentService departmentService;
	
	@Resource
	private IDictionaryApp dictionaryApp;

	@Override
	public String registOrganization(Organization organization)
			throws CheckException {
		organization.setOperateTime(getOperatorTime());
		organization.setOperateType(OperateType.regist.getName());
		List<String> messageList = new ArrayList<String>();
		checkAll(messageList, new Record(organization), EntityType.ORGANIZATION);
		String parentCode = organization.getParentCode();
		if (StringUtil.isNotEmpty(parentCode)) {
			Criteria criteria = new Criteria(Organization.ORGAN_CODE, parentCode);
			Organization parent =organizationService.getOrganization(criteria);
			if (parent == null) {
				messageList.add("上级机构编码不存在");
			}
		}
		if (messageList.size() > 0) {
			CheckException exception = getCheckException(messageList);
			throw exception;
		}
		String organizationCode = organization.getOrganCode();
		Criteria criteria = new Criteria(Organization.ORGAN_CODE, organizationCode);
		Organization dbOrganization = organizationService.getOrganization(criteria);
		if (dbOrganization == null) {
			organizationService.createOrganization(organization, null);
		} else {
			organization.setOrganId(dbOrganization.getOrganId());
			organizationService.updateOrganization(organization, null);
		}
		return organizationCode;
	}
	
	@Override
	public List<Organization> queryAllOrganization() {
		return queryOrganization(null);
	}
	
	public Map<String, String> queryAllOrganizationMap() {
		Criteria criteria = new Criteria(Organization.STATUS, StatusValue.normalValue.getValue());
		Map<String, String> map = organizationService.getOrganizationsMapUseCache(criteria);
		return map;
	}

	@Override
	public List<Organization> queryOrganization(Criteria criteria) {
		if (criteria == null) {
			criteria = new Criteria(Organization.STATUS, StatusValue.normalValue.getValue());
		} else if (!criteria.contains(Organization.STATUS)) {
			criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		}
		List<Organization> organizations = organizationService.getOrganizationsUseCache(criteria);
		return organizations;
	}
	
	@Override
	public Organization queryOrgan(String orgCode) {
		Criteria criteria = new Criteria(Organization.ORGAN_CODE, orgCode);
		List<Organization> organs = queryOrganization(criteria);
		if (organs == null || organs.size() == 0) {
			return null;
		}
		return organs.get(0);
	}
	
	@Override
	public String queryOrganName(String orgCode) {
		Organization organization = queryOrgan(orgCode);
		return (organization == null) ? "" : organization.getOrganName();
	}

	@Override
	public String registDepartment(Department department) throws CheckException {
		department.setOperateTime(getOperatorTime());
		department.setOperateType(OperateType.regist.getName());
		List<String> messageList = new ArrayList<String>();
		checkAll(messageList, new Record(department), EntityType.DEPARTMENT);
		String parentCode = department.getParentCode();
		if (StringUtil.isNotEmpty(parentCode)) {
			Criteria criteria = new Criteria(Department.DEPT_CODE, parentCode);
			Department parent =departmentService.getDepartment(criteria);
			if (parent == null) {
				messageList.add("上级科室编码不存在");
			}
		}
		String organCode = department.getOrganCode();
		if (StringUtil.isNotEmpty(organCode)) {
			Criteria criteria = new Criteria(Organization.ORGAN_CODE, organCode);
			Organization dbOrganization = organizationService.getOrganization(criteria);
			if (dbOrganization == null) {
				messageList.add("所属机构编码不存在");
			}
		}
		if (messageList.size() > 0) {
			CheckException exception = getCheckException(messageList);
			throw exception;
		}
		String organizationCode = department.getOrganCode();
		String departmentCode = department.getDeptCode();
		Criteria criteria = new Criteria(Organization.ORGAN_CODE, organizationCode).add(Department.DEPT_CODE, departmentCode);
		Department dbDepartment = departmentService.getDepartment(criteria);
		if (dbDepartment == null) {
			departmentService.createDepartment(department);
		} else {
			department.setDeptId(dbDepartment.getDeptId());
			departmentService.updateDepartment(department);
		}
		return departmentCode;
	}

	@Override
	public List<Department> queryDepartment(Criteria criteria) {
		List<Department> departments = departmentService.getDepartments(criteria);
		return departments;
	}
	
	public Map<String, String> getDictionary(String dictKey) {
		Map<String, String> dictMap = dictionaryApp.queryDicItemMap(dictKey);
		return dictMap;
	}

	public Organization queryOrganization(long organizationId) {
		return organizationService.getOrganization(organizationId);
	}

	@Override
	public Organization queryOrganByVillage(String villageCode) {
		if (StringUtil.isNullOrEmpty(villageCode)) {
			return null;
		}
		return organizationService.queryOrganByVillage(villageCode);
	}

	@Override
	public List<Organization> queryOrganization(Criteria criteria, Order order) {
		if (criteria == null) {
			criteria = new Criteria(Organization.STATUS, StatusValue.normalValue.getValue());
		} else if (!criteria.contains(Organization.STATUS)) {
			criteria.add(Organization.STATUS, StatusValue.normalValue.getValue());
		}
		List<Organization> organizations = organizationService.getOrganizationsUseCache(criteria, order);
		return organizations;
	}
}
