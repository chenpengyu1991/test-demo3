
package com.founder.rhip.phsr.controller.form;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class HealthEducationQueryForm {
	
	private Integer year;
	private String createBeginTime;
	private String createEndTime;
	private String month;
	private String gbcode;
	private String centerOrgCode;
	private String orgCode;
	private String summaryType;//1 月份  2时间段

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		setYearDate();
		organizeTime();
		if (StringUtil.isNotEmpty(gbcode)) {
			criteria.add("gbcode", gbcode);
		}
		if (StringUtil.isNotEmpty(centerOrgCode)) {
			criteria.add("centerOrgCode", centerOrgCode);
		}
		if (StringUtil.isNotEmpty(orgCode)) {
			criteria.add("orgCode", orgCode);
		}
		if (StringUtil.isNotEmpty(createBeginTime)) {
			criteria.add("createBeginTime", createBeginTime);
		}
		if (StringUtil.isNotEmpty(createEndTime)) {
			criteria.add("createEndTime", createEndTime);
		}
		return criteria;
	}
	
    private void organizeTime(){
        if(StringUtil.isNotEmpty(this.summaryType)){
            switch (this.summaryType){
                case "1"://按月
//                    if(StringUtil.isNullOrEmpty(month)){
//                        this.month = DateUtil.getDateTime("yyyy/MM", new Date());
//                    }
                    if(StringUtil.isNotEmpty(month)){
                    	 Date tempDate = DateUtil.parseSimpleDate(this.month, "yyyy/MM");
                         this.createBeginTime = this.month + "/01";
                         this.createEndTime = DateUtil.getDateTime("yyyy/MM/dd", DateUtil.lastDateOfMonth(tempDate));
                    }
                    break;
            }
        }
    }
    
    public void setYearDate(){
        if(ObjectUtil.isNullOrEmpty(year)){
            this.year = DateUtil.getCurrentYear();
        }
        if(StringUtil.isNullOrEmpty(this.createBeginTime)){
        	this.createBeginTime = year + "/01/01";
        }
        if(StringUtil.isNullOrEmpty(this.createEndTime)){
        	this.createEndTime =  year + "/12/31";
        }
        if(StringUtil.isNotEmpty(month)){
        	this.month = year + "/" + month;
        }
    }

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getCreateBeginTime() {
		return createBeginTime;
	}

	public void setCreateBeginTime(String createBeginTime) {
		this.createBeginTime = createBeginTime;
	}

	public String getCreateEndTime() {
		return createEndTime;
	}

	public void setCreateEndTime(String createEndTime) {
		this.createEndTime = createEndTime;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getGbcode() {
		return gbcode;
	}

	public void setGbcode(String gbcode) {
		this.gbcode = gbcode;
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

	public String getSummaryType() {
		return summaryType;
	}

	public void setSummaryType(String summaryType) {
		this.summaryType = summaryType;
	}
	
}
