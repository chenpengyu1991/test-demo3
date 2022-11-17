package com.founder.rhip.oh.controller.form;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

public class EnterpriseQueryForm {
	private String fileNo;
	private String beginDate;
	private String endDate;
	private String companyName;
	private String economicType;
	private String industryType;

	private String inputSuperOrganCode;

	private String inputOrganCode;
	
	private String gBCode;
	
	public String getInputSuperOrganCode() {
		return inputSuperOrganCode;
	}

	public void setInputSuperOrganCode(String inputSuperOrganCode) {
		this.inputSuperOrganCode = inputSuperOrganCode;
	}

	public String getInputOrganCode() {
		return inputOrganCode;
	}

	public void setInputOrganCode(String inputOrganCode) {
		this.inputOrganCode = inputOrganCode;
	}

	public String getgBCode() {
		return gBCode;
	}

	public void setgBCode(String gBCode) {
		this.gBCode = gBCode;
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

	public String getFileNo() {
		return fileNo;
	}

	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEconomicType() {
		return economicType;
	}

	public void setEconomicType(String economicType) {
		this.economicType = economicType;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public Criteria getCriteria() {
		Criteria criteria = new Criteria();

		/* 时间范围 */
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "founded_date", beginDate,
				endDate);
		criteria.add("is_delete",0);
		if (StringUtil.isNotEmpty(fileNo)) {
			criteria.add("file_no", fileNo);
		}
		if (StringUtil.isNotEmpty(companyName)) {
			criteria.add("company_name",OP.LIKE,companyName);
		}
		if (StringUtil.isNotEmpty(economicType)) {
			criteria.add("economic_type", economicType);
		}
		if (StringUtil.isNotEmpty(industryType)) {
			criteria.add("industry_type", industryType);
		}
		
//		if (StringUtil.isNotEmpty(gBCode)) {
//			criteria.add("gb_code", gBCode);
//		}
			return criteria;
	}

}
