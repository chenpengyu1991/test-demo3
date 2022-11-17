package com.founder.rhip.dmbc.controller.form;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

public class MonitorQueryForm {

	//开始时间
	private String beginDate;
	//结束时间
	private String endDate;
	//监测乡镇
	private String townShip;
	//环境类型
	private String environment;
	//地点
	private String place;
	//单位名称
	private String orgName;
	
	private String orgType;

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
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

	public String getTownShip() {
		return townShip;
	}

	public void setTownShip(String townShip) {
		this.townShip = townShip;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Criteria getCriteria() {
		Criteria criteria = new Criteria();

		/* 时间范围 */
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "monitor_date", beginDate,
				endDate);
		criteria.add("is_delete", 0);
		if (StringUtil.isNotEmpty(townShip)) {
			criteria.add("TOWN_SHIP", townShip);
		}
		if (StringUtil.isNotEmpty(place)) {
			criteria.add("place", OP.LIKE, place);
		}
		if (StringUtil.isNotEmpty(environment)) {
			criteria.add("environment", environment);
		}
		if (StringUtil.isNotEmpty(orgName)) {
			criteria.add("org_name", OP.LIKE, orgName);
		}
		if (StringUtil.isNotEmpty(orgType)) {
			criteria.add("org_type", orgType);
		}
		return criteria;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}
}
