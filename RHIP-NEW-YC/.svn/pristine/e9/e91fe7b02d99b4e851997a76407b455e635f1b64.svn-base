package com.founder.rhip.hm.controller.form;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class FissureSealantQueryForm {
	private String idcard;
	
	private String name;
	
	private String gender;
	
	private String schoolCode;
	
	private Date beginDate;
	
	private Date endDate;

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

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("idcard", OP.LIKE, idcard);
		}
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("gender", gender);
		}
		if (StringUtil.isNotEmpty(schoolCode)) {
			criteria.add("schoolCode", schoolCode);
		}
		if (ObjectUtil.isNotEmpty(beginDate)) {
			if (ObjectUtil.isNotEmpty(endDate)) {
				criteria.add("closeDate", OP.BETWEEN, new Date[]{beginDate, endDate});
			} else {
				criteria.add("closeDate", OP.GE, beginDate);
			}
		}else if (ObjectUtil.isNotEmpty(endDate)) {
			criteria.add("closeDate", OP.LE, endDate);
		}
		return criteria;
	}
}
