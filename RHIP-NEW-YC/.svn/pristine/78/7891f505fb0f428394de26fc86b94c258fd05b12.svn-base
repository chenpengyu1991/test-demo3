/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.da.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.LOP;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EventType;
import com.founder.rhip.mdm.common.OrgGenreCode;

import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 管理配置
 * 
 * @version 1.0, 2014-06-24
 * @author Ye jianfei
 */
public class DaConfigQueryForm {

	private String nationalOrganCode;//全国唯一识别码
	private String gbCode;//镇
	private String parentCode;//中心
	private String organCode;//站
	private String genreCode;//机构类别
	private String beginDt;//开始时间
	private String endDt;//结束时间	

	public Criteria getCriteria(){
		Criteria criteria = new Criteria();
		if(StringUtil.isNotEmpty(nationalOrganCode)){
			criteria.add("nationalOrganCode", nationalOrganCode);
		}
		if(StringUtil.isNotEmpty(gbCode)){
			criteria.add("gbCode", gbCode);
		}
		if(StringUtil.isNotEmpty(parentCode)){
			if(StringUtil.isNullOrEmpty(genreCode)){
				Criteria ca = new Criteria("parentCode",parentCode);
				ca.add(LOP.OR,"organCode", parentCode);
				criteria.addAll(ca);
			}else if(OrgGenreCode.CENTRE.getValue().equals(genreCode)){
				criteria.add("organCode", parentCode);
			}else{
				criteria.add("parentCode", parentCode);
			}
		}
		if(StringUtil.isNotEmpty(organCode)){
			criteria.add("organCode", organCode);
		}	
		
		if(StringUtil.isNotEmpty(genreCode)){
			criteria.add("genreCode", genreCode);
		}
//		/*监控日期*/
//		Date beginDt = DateUtil.parseDateString(this.expiryBeginDt);
//		Date endDt = DateUtil.parseDateString(this.expiryEndDt);
//		DateUtil.getCriteriaByDateRange(criteria, "EXPIRY_DT", beginDt,endDt);		
		return criteria;
	}

	public String getBeginDt() {
		return beginDt;
	}

	public void setBeginDt(String beginDt) {
		this.beginDt = beginDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getNationalOrganCode() {
		return nationalOrganCode;
	}

	public void setNationalOrganCode(String nationalOrganCode) {
		this.nationalOrganCode = nationalOrganCode;
	}

	public String getGbCode() {
		return gbCode;
	}

	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(String genreCode) {
		this.genreCode = genreCode;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}
}
