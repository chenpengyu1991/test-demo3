package com.founder.rhip.he.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

/**
 * @author cary
 * 
 */
public class QueryForm {
	private String dateBegin;
	private String dateEnd;
	private String organCode;
	private String type;
	private String status;

	public String getDateBegin() {
		return dateBegin;
	}

	public void setDateBegin(String dateBegin) {
		this.dateBegin = dateBegin;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Criteria getCopyCriteria(){
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(organCode)) {
			criteria.add("PUBLISH_ORGAN", organCode);
		}
		if (StringUtil.isNotEmpty(type)) {
			criteria.add("TYPE", type);
		}
		Date dateBegin = DateUtil.parseSimpleDate(this.dateBegin, "yyyy/MM/dd");
		Date dateEnd = DateUtil.parseSimpleDate(this.dateEnd, "yyyy/MM/dd");
		DateUtil.getCriteriaByDateRange(criteria, "PUBLISH_DATE", dateBegin,dateEnd);
		return criteria;
	}

	public Criteria getNoticeCriteria(){
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(organCode)) {
			criteria.add("CREATE_ORGAN", organCode);
		}
		if (StringUtil.isNotEmpty(status)) {
			criteria.add("STATUS", status);
		}
		Date dateBegin = DateUtil.parseSimpleDate(this.dateBegin, "yyyy/MM/dd");
		Date dateEnd = DateUtil.parseSimpleDate(this.dateEnd, "yyyy/MM/dd");
		DateUtil.getCriteriaByDateRange(criteria, "CREATE_DATE", dateBegin,dateEnd);
		return criteria;
	}

	public Criteria getSurveyCriteria(){
		Criteria criteria = new Criteria();
		Date dateBegin = DateUtil.parseSimpleDate(this.dateBegin, "yyyy/MM/dd");
		Date dateEnd = DateUtil.parseSimpleDate(this.dateEnd, "yyyy/MM/dd");
		DateUtil.getCriteriaByDateRange(criteria, "CREATE_DATE", dateBegin,dateEnd);
		return criteria;
	}

}
