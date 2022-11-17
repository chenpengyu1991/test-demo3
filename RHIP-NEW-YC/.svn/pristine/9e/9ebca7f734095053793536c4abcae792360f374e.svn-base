package com.founder.rhip.oh.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

public class OccPatientForm {

	private String[] employeeInfoIds;

	// 姓名
	private String name;
	// 性别
	private String gender;

	// 身份证号
	private String idcard;

	// 工种
	private String jobType;

	// 档案类型
	private String docType;

	// 审核状态
	private String verifyState;

	private String beginDate;
	private String endDate;

	private String reportDateFrom;
	private String reportDateTo;

	public String getReportDateFrom() {
		return reportDateFrom;
	}

	public void setReportDateFrom(String reportDateFrom) {
		this.reportDateFrom = reportDateFrom;
	}

	public String getReportDateTo() {
		return reportDateTo;
	}

	public void setReportDateTo(String reportDateTo) {
		this.reportDateTo = reportDateTo;
	}

	public String[] getEmployeeInfoIds() {
		return employeeInfoIds;
	}

	public void setEmployeeInfoIds(String[] employeeInfoIds) {
		this.employeeInfoIds = employeeInfoIds;
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

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getVerifyState() {
		return verifyState;
	}

	public void setVerifyState(String verifyState) {
		this.verifyState = verifyState;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Criteria getCriteria() {
		Criteria criteria = new Criteria();

		/* 时间范围 */
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "create_time", beginDate,
				endDate);
		criteria.add(new Criteria("is_delete", OP.IS, "null").add(LOP.OR, "is_delete",  0));
		Date reportDateFrom = DateUtil.parseSimpleDate(this.reportDateFrom, null);
		Date reportDateTo = DateUtil.parseSimpleDate(this.reportDateTo, null);
		DateUtil.getCriteriaByDateRange(criteria, "fill_time", reportDateFrom,
				reportDateTo);

		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name",OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("gender", gender);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("idcard",OP.LIKE, idcard);
		}
		if (StringUtil.isNotEmpty(jobType)) {
			criteria.add("job_type", jobType);
		}
		
		if (StringUtil.isNotEmpty(docType)) {
			criteria.add("doc_type", docType);
		}
		if (StringUtil.isNotEmpty(verifyState)) {
			criteria.add("verify_state", verifyState);
		}
		// if (StringUtil.isNotEmpty(gBCode)) {
		// criteria.add("gb_code", gBCode);
		// }
		return criteria;
	}
}
