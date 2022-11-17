
package com.founder.rhip.ncp.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

public class ManageReportForm {

	private String serviceBeginDate;
	private String serviceEndDate;
	private String selectMethod;
	private String manageDoctor;
	private String gbcode;
	private String centerOrgCode;
	private String orgCode;

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(gbcode)) {
			criteria.add("gbcode", gbcode);
		}
		if (StringUtil.isNotEmpty(centerOrgCode)) {
			criteria.add("centerOrgCode", centerOrgCode);
		}
		if (StringUtil.isNotEmpty(orgCode)) {
			criteria.add("orgCode", orgCode);
		}
		if (StringUtil.isNotEmpty(serviceBeginDate)) {
			criteria.add("serviceBeginDate", serviceBeginDate);
		}
		if (StringUtil.isNotEmpty(serviceEndDate)) {
			criteria.add("serviceEndDate", serviceEndDate);
		}
		if (StringUtil.isNotEmpty(manageDoctor)) {
			criteria.add("manageDoctor", manageDoctor);
		}
		if (StringUtil.isNotEmpty(selectMethod)) {
			criteria.add("selectMethod", selectMethod);
		}

		return criteria;
	}

	public String getServiceBeginDate() {
		return serviceBeginDate;
	}

	public void setServiceBeginDate(String serviceBeginDate) {
		this.serviceBeginDate = serviceBeginDate;
	}

	public String getServiceEndDate() {
		return serviceEndDate;
	}

	public void setServiceEndDate(String serviceEndDate) {
		this.serviceEndDate = serviceEndDate;
	}

	public String getManageDoctor() {
		return manageDoctor;
	}

	public void setManageDoctor(String manageDoctor) {
		this.manageDoctor = manageDoctor;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
	}

	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getSelectMethod() {
		return selectMethod;
	}

	public void setSelectMethod(String selectMethod) {
		this.selectMethod = selectMethod;
	}
}
