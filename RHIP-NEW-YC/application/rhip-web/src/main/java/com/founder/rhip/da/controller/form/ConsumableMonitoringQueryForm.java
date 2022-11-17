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
 * 药品监控
 * 
 * @version 1.0, 2013-11-25
 * @author Ye jianfei
 */
public class ConsumableMonitoringQueryForm {
	private String batchNo;//入库单号--
	private String beginDt;//监控开始时间--
	private String endDt;//监控结束时间--
	private String organCode;//所属机构--
	
	private String pinying;//通用名：药品名称全拼
	private String keyword;//关键字：支持药品名、通用名的模糊匹配
	
	private String deliveryTypeCode;//出库方式--
	private String storageTypeCode;//入库方式
	
	private String pharmacyTypeCode;//入库药房类型
	
	private String breakageReason;//报损原因
	private String manageTypeCodeGb;//管理分类
	

    /*
     * 入库监控
     * */
    public Criteria getInCriteria(){
    	Criteria criteria = new Criteria();
		/*入库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*入库日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "STORAGE_DT", beginDt,endDt);

		/*入库方式*/
		if (StringUtils.isNotBlank(storageTypeCode)){
			criteria.add("STORAGE_TYPE_CODE", storageTypeCode);
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}		
		return criteria;
    }

	/*
     * 入库详细列表
     * */
    public Criteria getInDetailCriteria(){
    	Criteria criteria = new Criteria();
		/*出库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*失效日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "EXPIRY_DT", beginDt,endDt);

		/*通用名：拼音*/
		if (StringUtils.isNotBlank(pinying)){
			Criteria ca = new Criteria("PINYING",OP.LIKE,pinying.trim());
			ca.add(LOP.OR,"PINYING_SHORT",OP.LIKE,pinying.trim());
			criteria.add(ca);
		}
		/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		return criteria;
    }
 

    /*
     * 出库监控
     * */
    public Criteria getOutCriteria(){
    	Criteria criteria = new Criteria();
		/*入库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*出库日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "DELIVERY_DT", beginDt,endDt);

		/*出库方式*/
		if (StringUtils.isNotBlank(deliveryTypeCode)){
			criteria.add("DELIVERY_TYPE_CODE", deliveryTypeCode);
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}		
		return criteria;
    }

	/*
     * 出库详细列表
     * */
    public Criteria getOutDetailCriteria(){
    	Criteria criteria = new Criteria();
		/*出库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*失效日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "EXPIRY_DT", beginDt,endDt);

		/*通用名：拼音*/
		if (StringUtils.isNotBlank(pinying)){
			Criteria ca = new Criteria("PINYING",OP.LIKE,pinying.trim());
			ca.add(LOP.OR,"PINYING_SHORT",OP.LIKE,pinying.trim());
			criteria.add(ca);
		}
		/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		return criteria;
    }
 
    /*
     * 库存监控
     * */
    public Criteria getStoreCriteria(){
    	Criteria criteria = new Criteria();
		/*批号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*失效日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "EXPIRY_DT", beginDt,endDt);

		/*通用名：拼音*/
		if (StringUtils.isNotBlank(pinying)){
			Criteria ca = new Criteria("GENERIC_NAME",OP.LIKE,pinying.trim());
			ca.add(LOP.OR,"PINYING_SHORT",OP.LIKE,pinying.trim());
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
		/*报损原因*/
		if (StringUtils.isNotBlank(breakageReason)){
			criteria.add("BREAKAGE_REASON", OP.LIKE, breakageReason);
		}

		/*管理分类*/
		if (StringUtils.isNotBlank(manageTypeCodeGb)){
			criteria.add("MANAGE_TYPE_CODE_GB", OP.LIKE, manageTypeCodeGb);
		}		
		/*报损日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "BREAKAGE_DT", beginDt,endDt);
		
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}
		
		/*耗材名称*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}		
		return criteria;
    }

   
	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
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

	public String getDeliveryTypeCode() {
		return deliveryTypeCode;
	}

	public void setDeliveryTypeCode(String deliveryTypeCode) {
		this.deliveryTypeCode = deliveryTypeCode;
	}

	public String getPharmacyTypeCode() {
		return pharmacyTypeCode;
	}

	public void setPharmacyTypeCode(String pharmacyTypeCode) {
		this.pharmacyTypeCode = pharmacyTypeCode;
	}

	public String getBreakageReason() {
		return breakageReason;
	}

	public void setBreakageReason(String breakageReason) {
		this.breakageReason = breakageReason;
	}

	public String getManageTypeCodeGb() {
		return manageTypeCodeGb;
	}

	public void setManageTypeCodeGb(String manageTypeCodeGb) {
		this.manageTypeCodeGb = manageTypeCodeGb;
	}

	
	public String getStorageTypeCode() {
		return storageTypeCode;
	}

	
	public void setStorageTypeCode(String storageTypeCode) {
		this.storageTypeCode = storageTypeCode;
	}

}
