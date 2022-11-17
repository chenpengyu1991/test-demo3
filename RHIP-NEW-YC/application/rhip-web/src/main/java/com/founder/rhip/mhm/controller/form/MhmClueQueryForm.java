/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.mhm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.mhm.common.MhmEvents;
import com.founder.rhip.mhm.common.MhmStatus;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 精神病人-线索登记查询表单
 * 
 * @version 1.0, 2013-8-14
 * @author Ye jianfei
 */
public class MhmClueQueryForm {
	private String name;
	private String idcard;
	private String fillBeginDate;
	private String fillEndDate;
	private String reportStatus;
	private String belongTownship;
	private String belongCenter;
	private String fillOrganCode;
	
	private String birthdateBegin;
	private String birthdateEnd;
	private String patientSource;
	private String bringIntoFlag;
    private String mgntStatus;
	
    /*
     * 线索登记
     * */
    public Criteria getClueCriteria(){
    	Criteria criteria = new Criteria();
		/*姓名*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("basics.NAME", OP.LIKE, name);
		}
		/*身份证号码*/
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("basics.IDCARD", idcard.toUpperCase());
		}	
		/*所属乡镇*/
		if (StringUtils.isNotBlank(belongTownship)){
        	criteria.add("other.BELONG_TOWNSHIP", belongTownship);
		}
		/*所属中心*/
		if (StringUtils.isNotBlank(belongCenter)){
        	criteria.add("other.BELONG_CENTER", belongCenter);
		}
		/*所属社区服务站*/
		if (StringUtils.isNotBlank(fillOrganCode)){
        	criteria.add("other.FILL_ORGAN_CODE", fillOrganCode);
		}		
		/*状态*/
		if (StringUtils.isNotBlank(reportStatus)){
        	criteria.add("status.STATUS", reportStatus);
		}else{
			
		}
		/*登记日期*/
		Date fillBeginDate = DateUtil.parseSimpleDate(this.fillBeginDate, null);
		Date fillEndDate = DateUtil.parseSimpleDate(this.fillEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "other.FILL_DATE", fillBeginDate,fillEndDate);
 
        /*事件：线索登记*/
        List<Integer> events = new ArrayList<Integer>();
        events.add(MhmEvents.M_CLUE.getValue());
        criteria.add("EVENT_TYPE", OP.IN, events);
        criteria.add("status.PATIENT_RESOURCE", "3");
		return criteria;
    }
    
    /*
     * 纳入管理
     * */
    public Criteria getPatientIntoCriteria(){
    	Criteria criteria = new Criteria();
//    	criteria.add("status.STATUS", MhmStatus.VERIFY_CHECK.getValue());//只查询状态为：复核确诊
		/*姓名*/
		if (StringUtils.isNotBlank(name)){
			criteria.add("basics.NAME", OP.LIKE, name);
		}
		/*身份证号码*/
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("basics.IDCARD", idcard.toUpperCase());
		}	
		/*所属乡镇*/
		if (StringUtils.isNotBlank(belongTownship)){
        	criteria.add("other.BELONG_TOWNSHIP", belongTownship);
		}
		/*所属中心*/
		if (StringUtils.isNotBlank(belongCenter)){
        	criteria.add("other.BELONG_CENTER", belongCenter);
		}
		/*所属社区服务站*/
		if (StringUtils.isNotBlank(fillOrganCode)){
        	criteria.add("other.FILL_ORGAN_CODE", fillOrganCode);
		}	
		/*管理状态*/
		if (StringUtils.isNotBlank(mgntStatus)){
//        	criteria.add("other.BRING_INTO_FLAG", bringIntoFlag);
            if("1".equals(mgntStatus)){
                List params = new ArrayList();
                params.add(MhmStatus.VERIFY_CHECK.getValue());
                params.add(MhmStatus.NO_MANAGEMENT.getValue());
                criteria.add("status.STATUS", OP.IN, params.toArray());
            }else if("2".equals(mgntStatus)){
                criteria.add("status.STATUS", MhmStatus.MANAGEMENT.getValue());
            }

		}		
		/*患者来源*/
		if (StringUtils.isNotBlank(patientSource)){
        	criteria.add("status.PATIENT_RESOURCE", patientSource);
		}
		
		/*登记日期*/
		Date fillBeginDate = DateUtil.parseSimpleDate(this.fillBeginDate, null);
		Date fillEndDate = DateUtil.parseSimpleDate(this.fillEndDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "other.FILL_DATE", fillBeginDate,fillEndDate);

		/*出生日期*/
		Date birthdateBegin	 = DateUtil.parseSimpleDate(this.birthdateBegin, null);
		Date birthdateEnd = DateUtil.parseSimpleDate(this.birthdateEnd, null);
		DateUtil.getCriteriaByDateRange(criteria, "basics.BIRTHDATE", birthdateBegin,birthdateEnd);
		
        /*事件：线索登记*/
        List<Integer> events = new ArrayList<Integer>();
        events.add(MhmEvents.M_CLUE.getValue());
        events.add(MhmEvents.M_ARCHIVES.getValue());
        events.add(MhmEvents.I_DISCHARGED.getValue());
        events.add(MhmEvents.I_OUTPATIENT.getValue());
        criteria.add("EVENT_TYPE", OP.IN, events);
		return criteria;
    }    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getIdcard() {
		return idcard;
	}
	
	public void setIdcard(String idcard) {
		this.idcard = idcard;
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
	
	public String getReportStatus() {
		return reportStatus;
	}
	
	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}
	public String getBelongTownship() {
		return belongTownship;
	}
	public void setBelongTownship(String belongTownship) {
		this.belongTownship = belongTownship;
	}
	public String getBelongCenter() {
		return belongCenter;
	}
	public void setBelongCenter(String belongCenter) {
		this.belongCenter = belongCenter;
	}
	public String getFillOrganCode() {
		return fillOrganCode;
	}
	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}
	public String getBirthdateBegin() {
		return birthdateBegin;
	}
	public void setBirthdateBegin(String birthdateBegin) {
		this.birthdateBegin = birthdateBegin;
	}
	public String getBirthdateEnd() {
		return birthdateEnd;
	}
	public void setBirthdateEnd(String birthdateEnd) {
		this.birthdateEnd = birthdateEnd;
	}
	public String getPatientSource() {
		return patientSource;
	}
	public void setPatientSource(String patientSource) {
		this.patientSource = patientSource;
	}

	public String getBringIntoFlag() {
		return bringIntoFlag;
	}

	public void setBringIntoFlag(String bringIntoFlag) {
		this.bringIntoFlag = bringIntoFlag;
	}

    public String getMgntStatus() {
        return mgntStatus;
    }

    public void setMgntStatus(String mgntStatus) {
        this.mgntStatus = mgntStatus;
    }
}
