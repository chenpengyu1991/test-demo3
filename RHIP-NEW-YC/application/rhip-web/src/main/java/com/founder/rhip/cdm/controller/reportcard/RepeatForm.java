package com.founder.rhip.cdm.controller.reportcard;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.io.Serializable;
import java.util.Date;

/**
 * 报卡查重用
 * 
 */
public class RepeatForm implements Serializable {
	private static final long serialVersionUID = 6628221431801245356L;
	private Date reportCreateStartDate;
	private Date reportCreateEndDate;
	private String repeatConditions;
	private String name;
	private String gender;
	private String idcard;
	private String reportType;

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("DM_PERSON_INFO.NAME", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("DM_PERSON_INFO.IDCARD", idcard);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("DM_PERSON_INFO.GENDER", gender);
		}
		if (null != reportCreateStartDate && null == reportCreateEndDate) {
			criteria.add("DM_REPORT_INFO.CREATE_DATE", OP.GE, DateUtil.makeTimeToZero(reportCreateStartDate));
		} else if (null == reportCreateStartDate && null != reportCreateEndDate) {
			criteria.add("DM_REPORT_INFO.CREATE_DATE", OP.LE, DateUtil.makeTimeToMax(reportCreateEndDate));
		}
		if (null != reportCreateStartDate && null != reportCreateEndDate) {
			criteria.add("DM_REPORT_INFO.CREATE_DATE", OP.BETWEEN, new Date[] { DateUtil.makeTimeToZero(reportCreateStartDate), DateUtil.makeTimeToMax(reportCreateEndDate) });
		}

		if (StringUtil.isNotEmpty(reportType)) {
			String[] types = reportType.split(",");
			criteria.add("DM_REPORT_INFO.DIS_TYPE", OP.IN, types);
		}

		return criteria;
	}

	public Date getReportCreateStartDate() {
		return reportCreateStartDate;
	}

	public void setReportCreateStartDate(Date reportCreateStartDate) {
		this.reportCreateStartDate = reportCreateStartDate;
	}

	public Date getReportCreateEndDate() {
		return reportCreateEndDate;
	}

	public void setReportCreateEndDate(Date reportCreateEndDate) {
		this.reportCreateEndDate = reportCreateEndDate;
	}

	public String getIdcard() {
		return idcard;
	}

	public String getName() {
		return name;
	}

	public void setIdcard(String idcard) {
		if (ObjectUtil.NotEmpty(idcard)) {
			idcard = idcard.toUpperCase();
		}
		this.idcard = idcard;
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

	public String getRepeatConditions() {
		return repeatConditions;
	}

	public void setRepeatConditions(String repeatConditions) {
		this.repeatConditions = repeatConditions;
	}

}
