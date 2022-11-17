package com.founder.rhip.ep.controller.form;

import java.util.Date;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class IodineNutritionQueryForm {
	
	private Date beginDate;
	
	private Date endDate;
	
	private String samplingId;
	
	private String crowd;
	
	private String name;
	
	private String idCard;
	
	private String surveyNo;

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSamplingId() {
		return samplingId;
	}

	public void setSamplingId(String samplingId) {
		this.samplingId = samplingId;
	}

	public String getCrowd() {
		return crowd;
	}

	public void setCrowd(String crowd) {
		this.crowd = crowd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(idCard)) {
			criteria.add("idCard", OP.LIKE, idCard);
		}
		if (StringUtil.isNotEmpty(crowd)) {
			criteria.add("crowd", crowd);
		}
		if (StringUtil.isNotEmpty(samplingId)) {
			criteria.add("samplingId", samplingId);
		}
		if (StringUtil.isNotEmpty(surveyNo)) {
			criteria.add("surveyNo", OP.LIKE, surveyNo);
		}
		if (ObjectUtil.isNotEmpty(beginDate)) {
			if (ObjectUtil.isNotEmpty(endDate)) {
				criteria.add("investigateTime", OP.BETWEEN, new Date[]{beginDate, endDate});
			} else {
				criteria.add("investigateTime", OP.GE, beginDate);
			}
		}else if (ObjectUtil.isNotEmpty(endDate)) {
			criteria.add("investigateTime", OP.LE, endDate);
		}
		return criteria;
	}

	public String getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}
	
}
