package com.founder.rhip.idm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import org.apache.commons.lang.StringUtils;

/**
 * 筛查登记的查询表单
 * 
 * @author zhangjin
 * 
 */
public class ConfirmedDiagnosisForm {
	private String idcard;
	private String name;
	private String gender;
	private String householdType;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHouseholdType() {
		return householdType;
	}

	public void setHouseholdType(String householdType) {
		this.householdType = householdType;
	}

	public Criteria getCriteria() {
		Criteria criteria = new Criteria();
		// 姓名
		if (StringUtils.isNotBlank(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		// 身份证
		if (StringUtils.isNotBlank(idcard)) {
			criteria.add("idcard", OP.LIKE, idcard);
		}
		// 性别
		if (StringUtils.isNotBlank(gender)) {
			criteria.add("gender", OP.EQ, gender);
		}
		// 户籍类型
		if (StringUtils.isNotBlank(householdType)) {
			criteria.add("householdType", OP.EQ, householdType);
		}
		//状态
		if (StringUtils.isNotBlank(status)){
			criteria.add("status", OP.EQ, status);
		}
		return criteria;
	}
}
