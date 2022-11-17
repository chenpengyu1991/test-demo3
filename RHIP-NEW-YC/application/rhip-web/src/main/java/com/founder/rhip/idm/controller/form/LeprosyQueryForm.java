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
import com.founder.rhip.idm.common.IdmType;
import org.apache.commons.lang.StringUtils;

import java.util.Date;


/**
 * 结核病查询表单
 * @author Jiang Haiying
 */
public class LeprosyQueryForm {
	
	/*姓名*/
	private String name;
	
	/*性别*/
	private String gender;
	
	/*身份证号*/
	private String idcard;
	
	/*上报开始日期*/
	private String modifySurveyDateBegin;
	
	/*上报结束日期*/
	private String modifySurveyDateEnd;
	
	/*状态*/
	private String status;
    
	/*诊断结果*/
	private String result;
	
	/*注销状态*/
	private String logoff;
	
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getModifySurveyDateBegin() {
		return modifySurveyDateBegin;
	}

	public void setModifySurveyDateBegin(String modifySurveyDateBegin) {
		this.modifySurveyDateBegin = modifySurveyDateBegin;
	}

	public String getModifySurveyDateEnd() {
		return modifySurveyDateEnd;
	}

	public void setModifySurveyDateEnd(String modifySurveyDateEnd) {
		this.modifySurveyDateEnd = modifySurveyDateEnd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Criteria getCriteria(){
		Criteria criteria = new Criteria();
		if (StringUtils.isNotBlank(name)){
			criteria.add("gen.name", OP.LIKE, name);
		}

		if (StringUtils.isNotBlank(gender)){
			criteria.add("gen.gender", gender);
		}
		
		if (StringUtils.isNotBlank(idcard)){
			criteria.add("gen.idcard", OP.LIKE, idcard);
		}

		if (StringUtils.isNotBlank(result)){
			criteria.add("caseInfo.review_result", result);
		}
		if (StringUtils.isNotBlank(this.logoff)){
			criteria.add("status.logoff", logoff);
		}
		/*上报日期*/
		Date modifySurveyDateBegin = DateUtil.parseSimpleDate(this.modifySurveyDateBegin, null);
		Date modifySurveyDateDtEnd = DateUtil.parseSimpleDate(this.modifySurveyDateEnd, null);
		DateUtil.getCriteriaByDateRange(criteria, "caseInfo.MODIFY_SURVEY_DATE", modifySurveyDateBegin,modifySurveyDateDtEnd);
		
		//指定查的是结核病
		criteria.add("IDM_TYPE", IdmType.LEPROSY.getValue());
		return criteria;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getLogoff() {
		return logoff;
	}

	public void setLogoff(String logoff) {
		this.logoff = logoff;
	}
}
