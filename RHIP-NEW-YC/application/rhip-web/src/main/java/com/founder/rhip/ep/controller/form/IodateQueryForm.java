package com.founder.rhip.ep.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

public class IodateQueryForm {

	private String name;

	private String randomNumber;

	private String gbCode;

	private String villageCode;

	private String gravidaStatus;

	private String surveyType;

	private String function;

	private String saltSamplingNumber;

	private Date beginTime;

	private Date endTime;

	private String createOrgan;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getVillageCode() {
		return villageCode;
	}

	public void setVillageCode(String villageCode) {
		this.villageCode = villageCode;
	}

	public String getGravidaStatus() {
		return gravidaStatus;
	}

	public void setGravidaStatus(String gravidaStatus) {
		this.gravidaStatus = gravidaStatus;
	}

	public String getSurveyType() {
		return surveyType;
	}

	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}

	public String getSaltSamplingNumber() {
		return saltSamplingNumber;
	}

	public void setSaltSamplingNumber(String saltSamplingNumber) {
		this.saltSamplingNumber = saltSamplingNumber;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCreateOrgan() {
		return createOrgan;
	}

	public void setCreateOrgan(String createOrgan) {
		this.createOrgan = createOrgan;
	}

	public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(name)) {
			criteria.add("name", OP.LIKE, name);
		}
		if (StringUtil.isNotEmpty(randomNumber)) {
			criteria.add("randomNumber", randomNumber);
		}
		if (StringUtil.isNotEmpty(gbCode)) {
			criteria.add("gbCode", gbCode);
		}
		if (StringUtil.isNotEmpty(villageCode)) {
			criteria.add("villageCode", villageCode);
		}
		if (StringUtil.isNotEmpty(gravidaStatus)) {
			criteria.add("gravidaStatus", gravidaStatus);
		}
		if (StringUtil.isNotEmpty(surveyType)) {
			criteria.add("surveyType", surveyType);
		}
		if (StringUtil.isNotEmpty(function)) {
			criteria.add("function", function);
		}
		if (StringUtil.isNotEmpty(saltSamplingNumber)) {
			criteria.add("saltSamplingNumber", saltSamplingNumber);
		}
		if (ObjectUtil.isNotEmpty(beginTime)) {
			if (ObjectUtil.isNotEmpty(endTime)) {
				criteria.add("monitorTime", OP.BETWEEN, new Date[]{beginTime, endTime});
			} else {
				criteria.add("monitorTime", OP.GE, beginTime);
			}
		}else if (ObjectUtil.isNotEmpty(endTime)) {
			criteria.add("monitorTime", OP.LE, endTime);
		}
		if (StringUtil.isNotEmpty(createOrgan)) {
			criteria.add("createOrgan", createOrgan);
		}
		return criteria;
	}
}
