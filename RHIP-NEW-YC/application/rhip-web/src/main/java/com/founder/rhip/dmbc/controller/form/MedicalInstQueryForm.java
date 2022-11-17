package com.founder.rhip.dmbc.controller.form;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

public class MedicalInstQueryForm {

	// 开始时间
	private String beginDate;
	// 结束时间
	private String endDate;

	// 机构名称
	private String avgDailyOutput;

	// 污水日均产量
	private String orgName;

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

	public String getAvgDailyOutput() {
		return avgDailyOutput;
	}

	public void setAvgDailyOutput(String avgDailyOutput) {
		this.avgDailyOutput = avgDailyOutput;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public Criteria getCriteria() {
		Criteria criteria = new Criteria();

		/* 时间范围 */
		Date beginDate = DateUtil.parseSimpleDate(this.beginDate, null);
		Date endDate = DateUtil.parseSimpleDate(this.endDate, null);
		DateUtil.getCriteriaByDateRange(criteria, "monitor_date", beginDate,
				endDate);
		criteria.add("is_delete", 0);
		// if (StringUtil.isNotEmpty(townShip)) {
		// criteria.add("TOWN_SHIP", townShip);
		// }
		// if (StringUtil.isNotEmpty(place)) {
		// criteria.add("place", OP.LIKE, place);
		// }
		if (StringUtil.isNotEmpty(avgDailyOutput)) {
			criteria.add("avgDailyOutput", avgDailyOutput);
		}
		if (StringUtil.isNotEmpty(orgName)) {
			criteria.add("org_name", OP.LIKE, orgName);
		}
		return criteria;
	}
}
