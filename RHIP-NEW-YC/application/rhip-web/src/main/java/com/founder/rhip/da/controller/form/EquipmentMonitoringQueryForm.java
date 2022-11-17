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
import com.founder.fasf.util.DateUtil;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 设备监控
 * 
 * @version 1.0, 2013-11-25
 * @author Ye jianfei
 */
public class EquipmentMonitoringQueryForm {
	private String propertyNo;//财产编号--
	private String beginDt;//监控开始时间--
	private String endDt;//监控结束时间--
	private String organCode;//所属机构--
	
	private String pinying;//通用名：名称全拼
	private String keyword;//关键字：支持商用名、通用名的模糊匹配

    /*
     * 库存监控
     * */
    public Criteria getStoreCriteria(){
    	Criteria criteria = new Criteria();
		/*财产编号*/
		if (StringUtils.isNotBlank(propertyNo)){
			criteria.add("PROPERTY_NO", OP.LIKE, propertyNo.trim());
		}

		/*采购日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "PURCHASE_DT", beginDt,endDt);

		/*通用名：拼音*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}		
		return criteria;
    }
  
    /*
     * 报损监控
     * */
    public Criteria getBreakageCriteria(){
    	Criteria criteria = new Criteria();
		/*财产编号*/
		if (StringUtils.isNotBlank(propertyNo)){
			criteria.add("PROPERTY_NO", OP.LIKE, propertyNo.trim());
		}

		/*采购日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "PURCHASE_DT", beginDt,endDt);

		/*通用名：拼音*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}		
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

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
    
	public String getPinying() {
		return pinying;
	}

	
	public void setPinying(String pinying) {
		this.pinying = pinying;
	}

	public String getPropertyNo() {
		return propertyNo;
	}

	public void setPropertyNo(String propertyNo) {
		this.propertyNo = propertyNo;
	}
}
