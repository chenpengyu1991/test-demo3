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
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

public class AnorectaQueryForm {

    private String monthDate;
	private String rangeDate;
	private String fillOrganCode;
	private String centerOrgCode;
	private String orgCode;
	private String rangeType;
	private String weekDate;
	private String weekSelect;
	private String week;
	private String weekXun;
	private String townOrgCode;
	private String centerAndStation;
	
	
	
    
    public String getTownOrgCode() {
		return townOrgCode;
	}

	public void setTownOrgCode(String townOrgCode) {
		this.townOrgCode = townOrgCode;
	}

	public String getCenterAndStation() {
		return centerAndStation;
	}

	public void setCenterAndStation(String centerAndStation) {
		this.centerAndStation = centerAndStation;
	}

	public String getCenterOrgCode() {
		return centerOrgCode;
	}

	public void setCenterOrgCode(String centerOrgCode) {
		this.centerOrgCode = centerOrgCode;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getFillOrganCode() {
		return fillOrganCode;
	}

	public void setFillOrganCode(String fillOrganCode) {
		this.fillOrganCode = fillOrganCode;
	}

	public String getMonthDate() {
		return monthDate;
	}

	public void setMonthDate(String monthDate) {
		this.monthDate = monthDate;
	}

	public String getRangeDate() {
		return rangeDate;
	}

	public void setRangeDate(String rangeDate) {
		this.rangeDate = rangeDate;
	}

    public String getRangeType() {
		return rangeType;
	}

	public void setRangeType(String rangeType) {
		this.rangeType = rangeType;
	}
	
	public String getWeekDate() {
		return weekDate;
	}

	public void setWeekDate(String weekDate) {
		this.weekDate = weekDate;
	}

	public String getWeekSelect() {
		return weekSelect;
	}

	public void setWeekSelect(String weekSelect) {
		this.weekSelect = weekSelect;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getWeekXun() {
		return weekXun;
	}

	public void setWeekXun(String weekXun) {
		this.weekXun = weekXun;
	}

	public Criteria getCriteria() {
		Criteria criteria = new Criteria();
		getDateCriteria(criteria);
    	getSearchOrgan();
        if(ObjectUtil.isNotEmpty(fillOrganCode)){
        	criteria.add("fillOrganCode", fillOrganCode);
        }
        if(ObjectUtil.isNotEmpty(centerAndStation)){
        	criteria.add("centerAndStation", centerAndStation);
        }
		return criteria;
	}
	
	//疾控三级标签
	public void getSearchOrgan(){
		if(StringUtil.isNotEmpty(orgCode)){
			this.fillOrganCode = orgCode;
		}else if(StringUtil.isNotEmpty(centerOrgCode)){
			//中心(医院)及下属站
			this.fillOrganCode = centerOrgCode;
			this.centerAndStation ="1";//查询中心及下属站
		}else if(StringUtil.isNotEmpty(townOrgCode)){
			this.fillOrganCode = townOrgCode;
		}
	}
    public Criteria getDateCriteria(Criteria criteria){
	   	
    	if("1".equals(rangeType)){
    		//旬
    		 if(ObjectUtil.isNotEmpty(monthDate)){
    	        	Date month =  DateUtil.parseSimpleDate(monthDate+"/01", "yyyy/MM/dd");
    	            String xunBeginDate = monthDate;
    	            String xunEndDate = monthDate;
    	            if(ObjectUtil.isNotEmpty(rangeDate)){
    	            	if("1".equals(rangeDate)){
    	            		xunBeginDate +=  "/01" ;
    	            		xunEndDate +="/10";
    	            		weekXun = monthDate +"上旬";
    	            	}else if("2".equals(rangeDate)){
    	            		xunBeginDate +=  "/11" ;
    	            		xunEndDate +="/20";
    	            		weekXun = monthDate +"中旬";
    	            	}else if("3".equals(rangeDate)){
    	            		xunBeginDate +=  "/21" ;
    	            		xunEndDate = DateUtil.convertDateToString(DateUtil.lastDateOfMonth(month));
    	            		weekXun = monthDate +"下旬";
    	            	}
    	            	criteria.add("beginDate", xunBeginDate);
        	            criteria.add("endDate", xunEndDate);
    	            }
    	        }
    	}else if("2".equals(rangeType)){
    		//周
    		 if(ObjectUtil.isNotEmpty(weekDate)){
    			    String year =  weekDate;
    	        	week = weekSelect.substring(1,weekSelect.indexOf("周"));
    	            criteria.add("beginDate", year +"/"+ weekSelect.substring(weekSelect.indexOf(",")+1 ,weekSelect.indexOf("-")));
    	            criteria.add("endDate", year+ "/"+ weekSelect.substring(weekSelect.indexOf("-")+1));
    	            weekXun = year +"年第" + week + "周";
    	        }
    	} 
		return criteria;
	}
}
