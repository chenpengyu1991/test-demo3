package com.founder.rhip.cdm.controller.reportcard;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liuk
 * 
 */
public class QueryForm implements Serializable {
	private static final long serialVersionUID = 6628221431801245355L;
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
	//是否待纳入 此属性仅在菜单报卡纳入状态为防保科已分配
	private String isDNR;

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
			criteria.add("dmPersonInfo.NAME", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("dmPersonInfo.IDCARD", idcard);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("dmPersonInfo.GENDER", gender);
		}

		if (ObjectUtil.isNotEmpty(startAge) && ObjectUtil.isNullOrEmpty(endAge)) {
			criteria.add("dmPersonInfo.BIRTHDAY", OP.LE, getEndBirthdayByAge());
		} else if (ObjectUtil.isNullOrEmpty(startAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("dmPersonInfo.BIRTHDAY", OP.GE, getStartBirthdayByAge());
		} else if (ObjectUtil.isNotEmpty(startAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("dmPersonInfo.BIRTHDAY", OP.BETWEEN, new Date[] { getStartBirthdayByAge(), getEndBirthdayByAge() });
		}

		if (StringUtil.isNotEmpty(reportStatus)) {
			if (reportStatus.indexOf(",") != -1) {
				reportStatusArray = reportStatus.split(",");
				criteria.add("cdmStatusInfo.REPORT_STATUS", OP.IN, reportStatusArray);
			} else {
				reportStatusArray=new String[] {reportStatus};
				criteria.add("cdmStatusInfo.REPORT_STATUS", reportStatus);
			}
		}

		if (null != reportCreateStartDate && null == reportCreateEndDate) {
			criteria.add("dmReportInfo.CREATE_DATE", OP.GE, DateUtil.makeTimeToZero(reportCreateStartDate));
		} else if (null == reportCreateStartDate && null != reportCreateEndDate) {
			criteria.add("dmReportInfo.CREATE_DATE", OP.LE, DateUtil.makeTimeToMax(reportCreateEndDate));
		}
		if (null != reportCreateStartDate && null != reportCreateEndDate) {
			criteria.add("dmReportInfo.CREATE_DATE", OP.BETWEEN, new Date[] { DateUtil.makeTimeToZero(reportCreateStartDate), DateUtil.makeTimeToMax(reportCreateEndDate) });
		}

		if (StringUtil.isNotEmpty(disType)) {
			String[] types = disType.split(",");
			if (types.length > 0) {
				criteria.add("dmReportInfo.DIS_TYPE", OP.IN, types);
			}
		}
		if (StringUtil.isNotEmpty(reportCreateOrganCode)) {
			criteria.add("dmReportInfo.CREATE_ORGAN_CODE", reportCreateOrganCode);
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

	public void setReportStatusArray(String reportStatus){
		if (StringUtil.isNotEmpty(reportStatus)) {
			if (reportStatus.indexOf(",") != -1) {
				this.reportStatusArray = reportStatus.split(",");
			} else {
				this.reportStatusArray=new String[] {reportStatus};
			}
		}
	}

	public String getIsDNR() {
		return isDNR;
	}

	public void setIsDNR(String isDNR) {
		this.isDNR = isDNR;
	}
}
