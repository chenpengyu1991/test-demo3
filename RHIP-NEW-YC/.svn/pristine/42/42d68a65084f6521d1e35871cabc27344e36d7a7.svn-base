/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.idm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.mdm.common.OrgGenreCode;

import java.util.Date;

/**
 * 直报统计查询表单
 * 
 * @version 1.0, 2013-5-27
 * @author Ye jianfei
 */
public class ReportStatisticsQueryForm {
	private String reportBeginMonth;//填报开始月份
	private String reportEndMonth;//填报结束月份
	private String reportBeginDate;//填报开始日期
	private String reportEndDate;//填报结束日期
	private String reportUnitCode;//填报单位
	private String reportMonth;//填报月份
	private String reportYear;//填报年份
	private String reportUnitType;//填报机构类别代码

	/*手足口病采样登记*/
	private String name;
	private String gender;
	
	/*传染病访视月报表*/
	private String fillDate;
	private String fillOrganCode;
	
	/*传染病督导报表*/
	private String summaryType;

	/*犬伤报表统计日期*/
	private String fillBeginDate;
	private String fillEndDate;

	/*23价疫苗查询条件*/
	private String epersonName; // 预约人员姓名
	private String epersonIdcard; // 预约人员身份证号码
	private String eorganCode; // 登记机构编码
	private String isInject; // 是否接种
	private String feeFlag; // 是否收费
	private String age; // 年龄

	/**
	 * 传染病管理及督导-填写，查询
	 * 
	 * @version 1.0, 2013-7-17
	 * @author Ye jianfei
	 */
	public Criteria getSupervisorFillCriteria(){
		Criteria criteria = new Criteria();
		/*填报月份*/
		Date reportBeginMonth = DateUtil.parseSimpleDate(this.reportBeginMonth + "/01", null);
		Date reportEndMonth = DateUtil.parseSimpleDate(this.reportEndMonth + "/01", null);
		DateUtil.getCriteriaByDateRange(criteria, "REPORT_MONTH", reportBeginMonth,reportEndMonth);

		/*填报日期*/
		Date reportBeginDate = DateUtil.parseSimpleDate(this.reportBeginDate, null);
		Date reportEndDate = DateUtil.parseSimpleDate(this.reportEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "REPORT_DATE", reportBeginDate,reportEndDate);
	
		/*填报单位*/
		if (StringUtil.isNotEmpty(reportUnitCode)){
			criteria.add("REPORT_UNIT_CODE",  reportUnitCode);
		}else if(reportUnitType.equals("hospital")){
			criteria.add("GENRE_CODE",  OrgGenreCode.HOSPITAL.getValue());
		}
		else if(reportUnitType.equals("centre")){
			criteria.add("GENRE_CODE",  OrgGenreCode.CENTRE.getValue());
		}		
        return criteria;
	}
	
	/**
	 * 传染病管理及督导-汇总，查询
	 * 
	 * @version 1.0, 2013-6-17
	 * @author Ye jianfei
	 */
	public Criteria getSupervisorCriteria(){
		Criteria criteria = new Criteria();
		/*填报月份*/
		if(StringUtil.isNotEmpty(reportMonth) && summaryType.equals("1")){
			criteria.add("REPORT_MONTH",  reportMonth);
		}
		/*填报年份*/
		if(StringUtil.isNotEmpty(reportYear) && summaryType.equals("2")){
			criteria.add("REPORT_MONTH",  reportYear);
		}		
		/*填报单位*/
		if (StringUtil.isNotEmpty(reportUnitCode)){
			criteria.add("REPORT_UNIT_CODE",  reportUnitCode);
		}else if(reportUnitType.equals("hospital")){
			criteria.add("GENRE_CODE",  OrgGenreCode.HOSPITAL.getValue());
		}
		else if(reportUnitType.equals("centre")){
			criteria.add("GENRE_CODE",  OrgGenreCode.CENTRE.getValue());
		}
        return criteria;
	}
	
	/**
	 * 执行情况自查-填写，查询
	 * 
	 * @version 1.0, 2013-7-17
	 * @author Ye jianfei
	 */
	public Criteria getSelfCheckFillCriteria(){
		Criteria criteria = new Criteria();
		/*填报月份*/
		Date reportBeginMonth = DateUtil.parseSimpleDate(this.reportBeginMonth + "/01", null);
		Date reportEndMonth = DateUtil.parseSimpleDate(this.reportEndMonth + "/01", null);
		DateUtil.getCriteriaByDateRange(criteria, "REPORT_MONTH", reportBeginMonth,reportEndMonth);

		/*填报单位*/
		if (StringUtil.isNotEmpty(reportUnitCode)){
			criteria.add("REPORT_UNIT_CODE",  reportUnitCode);
		}else if(reportUnitType.equals("hospital")){
			criteria.add("GENRE_CODE",  OrgGenreCode.HOSPITAL.getValue());
		}
		else if(reportUnitType.equals("centre")){
			criteria.add("GENRE_CODE",  OrgGenreCode.CENTRE.getValue());
		}
        return criteria;
	}
	
	/**
	 * 执行情况自查-汇总，查询
	 * 
	 * @version 1.0, 2013-6-17
	 * @author Ye jianfei
	 */
	public Criteria getSelfCheckCriteria(){
		Criteria criteria = new Criteria();

		/*填报单位*/
		if (StringUtil.isNotEmpty(reportUnitCode)){
			criteria.add("REPORT_UNIT_CODE",  reportUnitCode);
		}else if(reportUnitType.equals("hospital")){
			criteria.add("GENRE_CODE",  OrgGenreCode.HOSPITAL.getValue());
		}
		else if(reportUnitType.equals("centre")){
			criteria.add("GENRE_CODE",  OrgGenreCode.CENTRE.getValue());
		}
		if(StringUtil.isNullOrEmpty(reportMonth)){

			reportMonth = DateUtil.toDateString(new Date(), "yyyy/MM") + "/01";
		}else{
			reportMonth = this.reportMonth + "/01";
		}
		criteria.add("REPORT_MONTH",reportMonth);
				
        return criteria;
	}

	/**
	 * 手足口病采样登记统计查询
	 * 
	 * @version 1.0, 2013-6-17
	 * @author Ye jianfei
	 */
	public Criteria gettakeSampleCriteria(){
		Criteria criteria = new Criteria();
		/*采样日期*/
		Date reportBeginMonth = DateUtil.parseSimpleDate(this.reportBeginMonth, null);
		Date reportEndMonth = DateUtil.parseSimpleDate(this.reportEndMonth, null);
		DateUtil.getCriteriaByDateRange(criteria, "SAMPLE_DT", reportBeginMonth,reportEndMonth);
		/*患者姓名*/
		if (StringUtil.isNotEmpty(name)){
			criteria.add("NAME", OP.LIKE, name);
		}
		/*性别*/
		if (StringUtil.isNotEmpty(gender)){
			criteria.add("GENDER",  gender);
		}		
		/*采样单位*/
		if (StringUtil.isNotEmpty(reportUnitCode)){
			criteria.add("MODIFY_UNIT",  reportUnitCode);
		}else if(reportUnitType.equals("hospital")){
			criteria.add("GENRE_CODE",  OrgGenreCode.HOSPITAL.getValue());
		}
		else if(reportUnitType.equals("centre")){
			criteria.add("GENRE_CODE",  OrgGenreCode.CENTRE.getValue());
		}
		/*只查询手足口病*/
		criteria.add("DISEASE_CODE",  "311");
        return criteria;
	}

	/**
	 * 传染病访视月报表，查询
	 * 
	 * @version 1.0, 2013-6-17
	 * @author Ye jianfei
	 */
	public Criteria getInterviewCriteria(){
		Criteria criteria = new Criteria();

		/*填报月份*/
		if (StringUtil.isNotEmpty(fillDate)){
			criteria.add("FILL_DATE",  fillDate);
		}else{
			criteria.add("FILL_DATE",  DateUtil.toDateString(new Date(), "yyyy/MM"));
		}
		/*填报单位*/
		if (StringUtil.isNotEmpty(fillOrganCode)){
			criteria.add("FILL_ORGAN_CODE",  fillOrganCode);
		}else if(reportUnitType.equals("hospital")){
			criteria.add("GENRE_CODE",  OrgGenreCode.HOSPITAL.getValue());
		}
		else if(reportUnitType.equals("centre")){
			criteria.add("GENRE_CODE",  OrgGenreCode.CENTRE.getValue());
		}
        return criteria;
	}
	
	/**
	 * 传染病访视月报表，查询
	 * 
	 * @version 1.0, 2013-7-9
	 * @author Ye jianfei
	 */
	public Criteria getAcuteCriteria(){
		Criteria criteria = new Criteria();

		/*填报月份*/
		if (StringUtil.isNotEmpty(fillDate)){
			criteria.add("FILL_DATE",  fillDate);
		}else{
			criteria.add("FILL_DATE",  DateUtil.toDateString(new Date(), "yyyy/MM"));
		}
		/*填报单位*/
		if (StringUtil.isNotEmpty(fillOrganCode)){
			criteria.add("FILL_ORGAN_CODE",  fillOrganCode);
		}else if(reportUnitType.equals("hospital")){
			criteria.add("GENRE_CODE",  OrgGenreCode.HOSPITAL.getValue());
		}
		else if(reportUnitType.equals("centre")){
			criteria.add("GENRE_CODE",  OrgGenreCode.CENTRE.getValue());
		}
        return criteria;
	}	
	/**
	 * @return the reportBeginMonth
	 */
	public String getReportBeginMonth() {
		return reportBeginMonth;
	}

	/**
	 * @param reportBeginMonth the reportBeginMonth to set
	 */
	public void setReportBeginMonth(String reportBeginMonth) {
		this.reportBeginMonth = reportBeginMonth;
	}
	
	/**
	 * @return the reportEndMonth
	 */
	public String getReportEndMonth() {
		return reportEndMonth;
	}
	
	/**
	 * @param reportEndMonth the reportEndMonth to set
	 */
	public void setReportEndMonth(String reportEndMonth) {
		this.reportEndMonth = reportEndMonth;
	}
	
	/**
	 * @return the reportBeginDate
	 */
	public String getReportBeginDate() {
		return reportBeginDate;
	}
	
	/**
	 * @param reportBeginDate the reportBeginDate to set
	 */
	public void setReportBeginDate(String reportBeginDate) {
		this.reportBeginDate = reportBeginDate;
	}

	/**
	 * @return the reportEndDate
	 */
	public String getReportEndDate() {
		return reportEndDate;
	}
	
	/**
	 * @param reportEndDate the reportEndDate to set
	 */
	public void setReportEndDate(String reportEndDate) {
		this.reportEndDate = reportEndDate;
	}
	
	/**
	 * @return the reportUnitCode
	 */
	public String getReportUnitCode() {
		return reportUnitCode;
	}
	
	/**
	 * @param reportUnitCode the reportUnitCode to set
	 */
	public void setReportUnitCode(String reportUnitCode) {
		this.reportUnitCode = reportUnitCode;
	}

	/**
	 * @return the reportMonth
	 */
	public String getReportMonth() {
		return reportMonth;
	}

	/**
	 * @param reportMonth the reportMonth to set
	 */
	public void setReportMonth(String reportMonth) {
		this.reportMonth = reportMonth;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	
	/**
	 * @return the fillDate
	 */
	public String getFillDate() {
		return fillDate;
	}

	
	/**
	 * @param fillDate the fillDate to set
	 */
	public void setFillDate(String fillDate) {
		this.fillDate = fillDate;
	}

	
	/**
	 * @return the fillOrganCode
	 */
	public String getFillOrganCode() {
		return fillOrganCode;
	}

	
	/**
	 * @param fillOrganCode the fillOrganCode to set
	 */
	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getReportYear() {
		return reportYear;
	}

	public void setReportYear(String reportYear) {
		this.reportYear = reportYear;
	}

	public String getSummaryType() {
		return summaryType;
	}

	public void setSummaryType(String summaryType) {
		this.summaryType = summaryType;
	}

	
	public String getReportUnitType() {
		return reportUnitType;
	}

	
	public void setReportUnitType(String reportUnitType) {
		this.reportUnitType = reportUnitType;
	}

	public String getFillBeginDate() {
		return fillBeginDate;
	}

	public void setFillBeginDate(String fillBeginDate) {
		this.fillBeginDate = fillBeginDate;
	}

	public String getFillEndDate() {
		return fillEndDate;
	}

	public void setFillEndDate(String fillEndDate) {
		this.fillEndDate = fillEndDate;
	}

	public String getEpersonName() {
		return epersonName;
	}

	public void setEpersonName(String epersonName) {
		this.epersonName = epersonName;
	}

	public String getEpersonIdcard() {
		return epersonIdcard;
	}

	public void setEpersonIdcard(String epersonIdcard) {
		this.epersonIdcard = epersonIdcard;
	}

	public String getEorganCode() {
		return eorganCode;
	}

	public void setEorganCode(String eorganCode) {
		this.eorganCode = eorganCode;
	}

	public String getIsInject() {
		return isInject;
	}

	public void setIsInject(String isInject) {
		this.isInject = isInject;
	}

	public String getFeeFlag() {
		return feeFlag;
	}

	public void setFeeFlag(String feeFlag) {
		this.feeFlag = feeFlag;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
