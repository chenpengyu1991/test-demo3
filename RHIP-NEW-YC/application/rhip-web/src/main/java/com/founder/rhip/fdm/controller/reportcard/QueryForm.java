package com.founder.rhip.fdm.controller.reportcard;

import java.util.Calendar;
import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

/**
 * @author liuk
 * 
 */
public class QueryForm {
	private String name;
	private String idcard;
	private Integer startAge;
	private Integer endAge;
	private String diseaseType;
	private String diseaseStatus;
	private String gender;
	private String reportStatus;
	private Date reportCreateStartDate;
	private Date reportCreateEndDate;
	private String reportCreateOrganCode;
	private String disType;
	private String reportType;
	private String[] reportStatusArray;

	public String getDiseaseStatus() {
		return diseaseStatus;
	}

	public String getDiseaseType() {
		return diseaseType;
	}

	public Integer getEndAge() {
		return endAge;
	}

	public String getIdcard() {
		return idcard;
	}

	public String getName() {
		return name;
	}

	public Integer getStartAge() {
		return startAge;
	}

	public void setDiseaseStatus(String diseaseStatus) {
		this.diseaseStatus = diseaseStatus;
	}

	public void setDiseaseType(String diseaseType) {
		this.diseaseType = diseaseType;
	}

	public void setEndAge(Integer endAge) {
		this.endAge = endAge;
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

	public void setStartAge(Integer startAge) {
		this.startAge = startAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();

		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("idcard", idcard);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("gender", gender);
		}

		if (ObjectUtil.isNotEmpty(startAge) && ObjectUtil.isNullOrEmpty(endAge)) {
			criteria.add("birthday", OP.LE, getEndBirthdayByAge());
		} else if (ObjectUtil.isNullOrEmpty(startAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("birthday", OP.GE, getStartBirthdayByAge());
		} else if (ObjectUtil.isNotEmpty(startAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("birthday", OP.BETWEEN, new Date[] { getStartBirthdayByAge(), getEndBirthdayByAge() });
		}

		if (StringUtil.isNotEmpty(reportStatus)) {
			if (reportStatus.indexOf(",") != -1) {
				reportStatusArray = reportStatus.split(",");
				criteria.add("status", OP.IN, reportStatusArray);
			} else {
				reportStatusArray = new String[] { reportStatus };
				criteria.add("status", reportStatus);
			}
		}

		if (null != reportCreateStartDate && null == reportCreateEndDate) {
			criteria.add("fillDate", OP.GE, DateUtil.makeTimeToZero(reportCreateStartDate));
		} else if (null == reportCreateStartDate && null != reportCreateEndDate) {
			criteria.add("fillDate", OP.LE, DateUtil.makeTimeToMax(reportCreateEndDate));
		}
		if (null != reportCreateStartDate && null != reportCreateEndDate) {
			criteria.add("fillDate", OP.BETWEEN, new Date[] { DateUtil.makeTimeToZero(reportCreateStartDate), DateUtil.makeTimeToMax(reportCreateEndDate) });
		}

		// if (StringUtil.isNotEmpty(disType)) {
		// String[] types = disType.split(",");
		// if (types.length > 0) {
		// criteria.add("dmReportInfo.DIS_TYPE", OP.IN, types);
		// }
		// }
		if (StringUtil.isNotEmpty(reportCreateOrganCode)) {
			criteria.add("fillOrganCode", reportCreateOrganCode);
		}
		return criteria;
	}

	private Date getStartBirthdayByAge() {
		Calendar beginDate = Calendar.getInstance();
		beginDate.setTime(new Date());
		beginDate.add(Calendar.YEAR, -endAge);
		beginDate.set(Calendar.MONTH, Calendar.JANUARY);
		beginDate.set(Calendar.DAY_OF_MONTH, 1);
		DateUtil.makeTimeToZero(beginDate);
		return beginDate.getTime();
	}

	private Date getEndBirthdayByAge() {
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(new Date());
		endDate.add(Calendar.YEAR, -startAge);
		endDate.set(Calendar.MONTH, Calendar.DECEMBER);
		endDate.set(Calendar.DAY_OF_MONTH, 31);
		DateUtil.makeTimeToMax(endDate);
		return endDate.getTime();
	}

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
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

	public String getReportCreateOrganCode() {
		return reportCreateOrganCode;
	}

	public void setReportCreateOrganCode(String reportCreateOrganCode) {
		this.reportCreateOrganCode = reportCreateOrganCode;
	}

	public String getDisType() {
		return disType;
	}

	public void setDisType(String disType) {
		this.disType = disType;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String[] getReportStatusArray() {
		return reportStatusArray;
	}

}
