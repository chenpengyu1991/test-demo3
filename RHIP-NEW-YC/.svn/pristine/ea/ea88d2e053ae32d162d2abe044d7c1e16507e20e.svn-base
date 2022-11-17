package com.founder.rhip.ism.controller.reportcard;

import java.io.Serializable;
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
public class QueryForm implements Serializable {
	private static final long serialVersionUID = 6628221431801245355L;
	private String name;
	private String idcard;
	private Integer startAge;
	private Integer endAge;
	private String gender;
	private Date reportCreateStartDate;
	private Date reportCreateEndDate;
	private String reportCreateOrganCode;
	private String reportStatus;


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

	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
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
			criteria.add("NAME", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idcard)) {
			criteria.add("IDCARD", idcard);
		}
		if (StringUtil.isNotEmpty(gender)) {
			criteria.add("GENDER", gender);
		}

		if (ObjectUtil.isNotEmpty(startAge) && ObjectUtil.isNullOrEmpty(endAge)) {
			criteria.add("AGE", OP.LE, endAge);
		} else if (ObjectUtil.isNullOrEmpty(startAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("AGE", OP.GE, startAge);
		} else if (ObjectUtil.isNotEmpty(startAge) && ObjectUtil.isNotEmpty(endAge)) {
			criteria.add("AGE", OP.BETWEEN, new Integer[] { startAge, endAge });
		}

		if (null != reportCreateStartDate && null == reportCreateEndDate) {
			criteria.add("CREATE_DATE", OP.GE, DateUtil.makeTimeToZero(reportCreateStartDate));
		} else if (null == reportCreateStartDate && null != reportCreateEndDate) {
			criteria.add("CREATE_DATE", OP.LE, DateUtil.makeTimeToMax(reportCreateEndDate));
		}
		if (null != reportCreateStartDate && null != reportCreateEndDate) {
			criteria.add("CREATE_DATE", OP.BETWEEN, new Date[] { DateUtil.makeTimeToZero(reportCreateStartDate), DateUtil.makeTimeToMax(reportCreateEndDate) });
		}

		if (StringUtil.isNotEmpty(reportCreateOrganCode)) {
			criteria.add("CREATE_ORGAN_CODE", reportCreateOrganCode);
		}
		
		if(StringUtil.isNotEmpty(reportStatus)){
			criteria.add("STATUS", reportStatus);
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
}
