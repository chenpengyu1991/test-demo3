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
public class DrugMonitoringQueryForm {
	private String batchNo;//入库单号
	private String beginDt;//监控开始时间
	private String endDt;//监控结束时间
	private String storageTypeCode;//入库方式
	private String organCode;//所属机构
	private String invoiceNum;//发票号码
	
	private String pinying;//通用名：药品名称全拼
	private String drugGenericName;// 通用名
	private String keyword;//关键字：支持药品名、通用名的模糊匹配
	private String facName;// 生产厂家
	
	private String deliveryTypeCode;//出库方式
	
	private String pharmacyTypeCode;//入库药房类型
	
	private String pharmacyCode;//药房编码
	
	private String cancelTypeCode;//退药方式
	
	private String targetPharmacyType;//退往药房类型
	
	private String drugTypeCode;//药品分类（药品分类字典）
	private String damageElementCode;//损坏因素
	
	private String medicareCode;//药品编码
	private String firstDt;//监控开始日期
	private String lastDt;//监控结束日期

    /*
     * 药库入库监控
     * */
    public Criteria getStorageInCriteria(){
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
		/*发票号*/
		if (StringUtils.isNotBlank(invoiceNum)){
			criteria.add("INVOICE_NUM", OP.LIKE, invoiceNum.trim());
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}		
		return criteria;
    }

	/*
     * 药库入库详细列表
     * */
    public Criteria getStorageInDetailCriteria(){
    	Criteria criteria = new Criteria();
		/*入库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("DETAIL.BATCH_NO", OP.LIKE, batchNo.trim());
		}
		/*机构编码:日常监控用字典*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE",organCode);
		}
		/*药品编码:日常监控用字典*/
		if (StringUtils.isNotBlank(medicareCode)){
			criteria.add("MEDICARE_CODE", medicareCode);
		}		
		/*失效日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "EXPIRY_DT", beginDt,endDt);

		/*监控日期日期:日常监控用字典*/
		//TODO:待需求确定
		
		/*通用名：拼音*/
		if (StringUtils.isNotBlank(pinying)){
			Criteria ca = new Criteria("PINYING",OP.LIKE,pinying.trim());
			ca.add(LOP.OR,"PINYING_SHORT",OP.LIKE,pinying.trim());
			criteria.add(ca);
		}
		/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"DRUG_TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		return criteria;
    }
 

    /*
     * 药库出库监控
     * */
    public Criteria getStorageOutCriteria(){
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
     * 药库出库详细列表
     * */
    public Criteria getStorageOutDetailCriteria(){
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
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"DRUG_TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		return criteria;
    }
 
    /*
     * 药库库存监控
     * */
    public Criteria getStorageCriteria(){
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
			Criteria ca = new Criteria("PINYING",OP.LIKE,pinying.trim());
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
     * 药库退库监控
     * */
    public Criteria getStorageReturnCriteria(){
    	Criteria criteria = new Criteria();
		/*退库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*退库日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "RETURN_DT", beginDt,endDt);
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}		
		return criteria;
    }

	/*
     * 药库退库详细列表
     * */
    public Criteria getStorageReturnDetailCriteria(){
    	Criteria criteria = new Criteria();
		/*入库单号*/
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
		/*通用名*/
		if (StringUtils.isNotBlank(drugGenericName)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,drugGenericName.trim());
			criteria.add(ca);
		}
		/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"DRUG_TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		return criteria;
    }
 
    /*
     * 药房入库监控
     * */
    public Criteria getPharmacyInCriteria(){
    	Criteria criteria = new Criteria();
		/*入库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*入库日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "PHARMACY_DT", beginDt,endDt);

		/*入库方式*/
		if (StringUtils.isNotBlank(storageTypeCode)){
			criteria.add("STORAGE_TYPE_CODE", storageTypeCode);
		}
		/*入库药房*/
		if (StringUtils.isNotBlank(pharmacyTypeCode)){
			criteria.add("PHARMACY_TYPE_CODE", OP.LIKE, pharmacyTypeCode);
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}		
		return criteria;
    }

	/*
     * 药房入库详细列表
     * */
    public Criteria getPharmacyInDetailCriteria(){
    	Criteria criteria = new Criteria();
		/*入库单号*/
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
		/*通用名*/
		if (StringUtils.isNotBlank(drugGenericName)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,drugGenericName.trim());
			criteria.add(ca);
		}
		/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"DRUG_TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		return criteria;
    }
 
    
    /*
     * 药房出库监控
     * */
    public Criteria getPharmacyOutCriteria(){
    	Criteria criteria = new Criteria();
		/*出库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*出库日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "DELIVERY_DT", beginDt,endDt);

		/*出库类别*/
		if (StringUtils.isNotBlank(deliveryTypeCode)){
			criteria.add("DELIVERY_TYPE_CODE", deliveryTypeCode);
		}
		/*入库药房*/
		if (StringUtils.isNotBlank(pharmacyTypeCode)){
			criteria.add("PHARMACY_TYPE_CODE", OP.LIKE, pharmacyTypeCode);
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}		
		return criteria;
    }

	/*
     * 药房出库详细列表
     * */
    public Criteria getPharmacyOutDetailCriteria(){
    	Criteria criteria = new Criteria();
		/*入库单号*/
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
		/*通用名*/
		if (StringUtils.isNotBlank(drugGenericName)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,drugGenericName.trim());
			criteria.add(ca);
		}

		/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"DRUG_TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		return criteria;
    }
    
    /*
     * 药房库存监控
     * */
    public Criteria getPharmacyCriteria(){
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
			Criteria ca = new Criteria("PINYING",OP.LIKE,pinying.trim());
			ca.add(LOP.OR,"PINYING_SHORT",OP.LIKE,pinying.trim());
			criteria.add(ca);
		}

		/*通用名*/
		if (StringUtils.isNotBlank(drugGenericName)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,drugGenericName.trim());
			criteria.add(ca);
		}

		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}
		/*所属药房*/
		if (StringUtils.isNotBlank(pharmacyCode)){
			criteria.add("PHARMACY_CODE", pharmacyCode);
		}		
		return criteria;
    }  
    
    /*
     * 药房退库监控
     * */
    public Criteria getPharmacyReturnCriteria(){
    	Criteria criteria = new Criteria();
		/*退库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*退库日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "RETURN_DT", beginDt,endDt);
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}
		/*所属药房*/
		if (StringUtils.isNotBlank(pharmacyTypeCode)){
			criteria.add("PHARMACY_TYPE_COE", pharmacyTypeCode);
		}	  
		
		return criteria;
    }

	/*
     * 药房退库详细列表
     * */
    public Criteria getPharmacyReturnDetailCriteria(){
    	Criteria criteria = new Criteria();
		/*入库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("batchNo", OP.LIKE, batchNo.trim());
		}
		
		/*生产厂家*/
		if (StringUtils.isNotBlank(facName)){
			criteria.add("facName", OP.LIKE, facName.trim());
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
		
		/*通用名*/
		if (StringUtils.isNotBlank(drugGenericName)){
			Criteria ca = new Criteria("drugGenericName",OP.LIKE,drugGenericName.trim());
			criteria.add(ca);
		}
		
		/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"DRUG_TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		return criteria;
    }

    /*
     * 药房退药监控
     * */
    public Criteria getPharmacyCancelCriteria(){
    	Criteria criteria = new Criteria();
		/*退药日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "CANCEL_DT", beginDt,endDt);
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
		}
		/*退往药房类型*/
		if (StringUtils.isNotBlank(targetPharmacyType)){
			criteria.add("TARGET_PHARMACY_TYPE", targetPharmacyType);
		}			
		/*退药方式*/
		if (StringUtils.isNotBlank(cancelTypeCode)){
			criteria.add("CANCEL_TYPE_CODE", cancelTypeCode);
		}
		
		return criteria;
    }

	/*
     * 药房退药详细列表
     * */
    public Criteria getPharmacyCancelDetailCriteria(){
    	Criteria criteria = new Criteria();
		/*入库单号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO", OP.LIKE, batchNo.trim());
		}

		/*失效日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "EXPIRY_DT", beginDt,endDt);

		/*通用名：拼音*/
		if (StringUtils.isNotBlank(drugGenericName)){
			Criteria ca = new Criteria("drugGenericName",OP.LIKE,drugGenericName.trim());
			criteria.add(ca);
		}
		/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE,keyword.trim());
			ca.add(LOP.OR,"DRUG_TRADE_NAME",OP.LIKE,keyword.trim());
			criteria.add(ca);
		}
		/*生产企业*/
		if (StringUtils.isNotBlank(facName)){
			Criteria ca = new Criteria("facName",OP.LIKE,facName.trim());
			criteria.add(ca);
		}
		
		return criteria;
    }

    /*
     * 药品养护监控
     * */
    public Criteria getUpkeepCriteria(){
    	Criteria criteria = new Criteria();
		/*损坏因素*/
		if (StringUtils.isNotBlank(damageElementCode)){
			criteria.add("DAMAGE_ELEMENT_CODE", damageElementCode);
		}
		/*药品类别*/
		if (StringUtils.isNotBlank(drugTypeCode)){
			criteria.add("DRUG_TYPE_CODE", drugTypeCode);
		}
		/*养护日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.beginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.endDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "UPKEEP_DT", beginDt,endDt);

		/*通用名：拼音*/
		if (StringUtils.isNotBlank(pinying)){
			criteria.add("DRUG_GENERIC_NAME", OP.LIKE, pinying.trim());
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(organCode)){
			criteria.add("ORGAN_CODE", organCode);
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

	public String getStorageTypeCode() {
		return storageTypeCode;
	}

	public void setStorageTypeCode(String storageTypeCode) {
		this.storageTypeCode = storageTypeCode;
	}

	public String getOrganCode() {
		return organCode;
	}

	public void setOrganCode(String organCode) {
		this.organCode = organCode;
	}

	public String getInvoiceNum() {
		return invoiceNum;
	}

	public void setInvoiceNum(String invoiceNum) {
		this.invoiceNum = invoiceNum;
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

	public String getPharmacyCode() {
		return pharmacyCode;
	}

	public void setPharmacyCode(String pharmacyCode) {
		this.pharmacyCode = pharmacyCode;
	}

	public String getDrugTypeCode() {
		return drugTypeCode;
	}

	public void setDrugTypeCode(String drugTypeCode) {
		this.drugTypeCode = drugTypeCode;
	}

	public String getDamageElementCode() {
		return damageElementCode;
	}

	public void setDamageElementCode(String damageElementCode) {
		this.damageElementCode = damageElementCode;
	}

	public String getMedicareCode() {
		return medicareCode;
	}

	public void setMedicareCode(String medicareCode) {
		this.medicareCode = medicareCode;
	}

	public String getFirstDt() {
		return firstDt;
	}

	public void setFirstDt(String firstDt) {
		this.firstDt = firstDt;
	}

	public String getLastDt() {
		return lastDt;
	}

	public void setLastDt(String lastDt) {
		this.lastDt = lastDt;
	}

	public String getDrugGenericName() {
		return drugGenericName;
	}

	public void setDrugGenericName(String drugGenericName) {
		this.drugGenericName = drugGenericName;
	}

	public String getFacName() {
		return facName;
	}

	public void setFacName(String facName) {
		this.facName = facName;
	}

	public String getTargetPharmacyType() {
		return targetPharmacyType;
	}

	public void setTargetPharmacyType(String targetPharmacyType) {
		this.targetPharmacyType = targetPharmacyType;
	}

	public String getCancelTypeCode() {
		return cancelTypeCode;
	}

	public void setCancelTypeCode(String cancelTypeCode) {
		this.cancelTypeCode = cancelTypeCode;
	}	
	
	
}
