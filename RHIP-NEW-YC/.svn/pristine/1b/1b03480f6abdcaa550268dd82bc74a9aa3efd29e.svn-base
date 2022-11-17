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
import org.apache.commons.lang.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日常监控
 * 
 * @version 1.0, 2013-11-25
 * @author Ye jianfei
 */
public class DailyMonitoringQueryForm {
	private String monitorIndex;//监控指标
	private String monitorValue;//监控值
    private String monitorValueMax;//监控值
	private String prescribeDateBegin;//监控开始时间
	private String prescribeDateEnd;//监控结束时间
	private String prescribeDoctorName;//开方医生姓名
	private String prescribeDoctorNo;//开方医生工号
	private String hospitalCode;//所属机构
	
	private String patientType;//费用类型
	private String drugGenericName;//药品通用名
	private String referralHospitalCode;//所属机构	
	private Order unusualOrder;
	
	private String drugCode;//药品编码
	
	private String keyword;//关键字
	private String detailType;//药品详细：1/总费用详细：2
	private String drugCostSum;//药品费用合计
	private String totalCostSum;//总费用
	
	private String expiryBeginDt;//失效开始时间
	private String expiryEndDt;//失效结束日期
	private String batchNo;//批号
	
	private String type;//类型（1药库入库；2药库库存；3药房库存；4科室库存）
	private String medicareCode;//药品编码
	private String genericName;//药品通用名
	private String beginDt;//监控开始时间
	private String endDt;//监控结束时间	

	public Criteria getDistributionDetailCriteria(){
		Criteria criteria = new Criteria();
		if(StringUtil.isNotEmpty(medicareCode)){
			criteria.add("DRUG_MEDICARE_CODE", medicareCode);
		}
		if(StringUtil.isNotEmpty(hospitalCode)){
			criteria.add("ORGAN_CODE", hospitalCode);
		}
		if(StringUtil.isNotEmpty(batchNo)){
			criteria.add("BATCH_NO", batchNo);
		}	
		/*监控日期*/
		Date beginDt = DateUtil.parseSimpleDate(this.expiryBeginDt, null);
		Date endDt = DateUtil.parseSimpleDate(this.expiryEndDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "EXPIRY_DT", beginDt,endDt);		
		return criteria;
	}
	/*
     * 异常处方
     * */
    public Criteria getUnusualCriteria(){
    	Criteria criteria = new Criteria();
		/*监控指标*/
		if (StringUtils.isNotBlank(monitorIndex) && StringUtils.isNotBlank(monitorValue)){
			switch(monitorIndex){
                case "1"://处方金额
                    getCriteriaByRange(criteria, "prescriptionTotalCost", monitorValue, monitorValueMax);
                    setUnusualOrder(new Order("PRESCRIPTION_TOTAL_COST DESC,HOSPITAL_CODE DESC"));
                    break;
                case "2"://用量
                    getCriteriaByRange(criteria, "DRUG_USE_TOTAL_DOSE", monitorValue, monitorValueMax);
                    setUnusualOrder(new Order("HOSPITAL_CODE,DRUG_USE_TOTAL_DOSE DESC"));
                    break;
                case "3"://天数
                    getCriteriaByRange(criteria, "DRUG_USE_DAYS", monitorValue, monitorValueMax);
                    setUnusualOrder(new Order("HOSPITAL_CODE,DRUG_USE_DAYS DESC"));
                    break;
                case "4"://处方品种
                    getCriteriaByRange(criteria, "DRUG.PRESCRIPTION_TOTAL_COUNT", monitorValue, monitorValueMax);
                    setUnusualOrder(new Order("HOSPITAL_CODE,DRUG.PRESCRIPTION_TOTAL_COUNT DESC"));
                    break;
			}
			
		}

		/*监控日期*/
		Date prescribeDateBegin = DateUtil.parseSimpleDate(this.prescribeDateBegin, null);
		Date prescribeDateEnd = DateUtil.parseSimpleDate(this.prescribeDateEnd, null);
		DateUtil.getCriteriaByDateRange(criteria, "PRESCRIBE_DATE", prescribeDateBegin,prescribeDateEnd);

		/*开方医生姓名*/
		if (StringUtils.isNotBlank(prescribeDoctorName)){
			criteria.add("PRESCRIBE_DOCTOR_NAME", OP.LIKE, prescribeDoctorName.trim());
		}
		/*开方医生工号*/
		if (StringUtils.isNotBlank(prescribeDoctorNo)){
			criteria.add("PRESCRIBE_DOCTOR_NO", OP.LIKE, prescribeDoctorNo.trim());
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(hospitalCode)){
			criteria.add("HOSPITAL_CODE", hospitalCode);
		}		
		criteria.add("HOSPITAL_CODE",OP.UEMPTY,"");
		return criteria;
    }

    public Map<String, String> getUnusualParamMap(){

        Map<String,String> paramMap = new HashMap<String,String>();
        if(StringUtil.isNotEmpty(prescribeDateBegin)){
            paramMap.put("beginDate",prescribeDateBegin);
        }
        if(StringUtil.isNotEmpty(prescribeDateEnd)){
            paramMap.put("endDate",prescribeDateEnd);
        }
        if(StringUtil.isNotEmpty(hospitalCode)){
            paramMap.put("hospitalCode",hospitalCode);
        }
		/*监控指标*/
		if (StringUtils.isNotBlank(monitorIndex) && StringUtils.isNotBlank(monitorValue)){
			paramMap.put("monitorValue",monitorValue);
		}
        if (StringUtils.isNotBlank(monitorIndex) && StringUtils.isNotBlank(monitorValueMax)){
            paramMap.put("monitorValueMax",monitorValueMax);
        }
        return paramMap;
    }
    
    /*
     * 医师用药
     * */
    public Criteria getPhysicianCriteria(){
       	Criteria criteria = new Criteria();
		/*药品通用名*/
		if (StringUtils.isNotBlank(drugGenericName)){
			criteria.add("DRUG_GENERIC_NAME", OP.LIKE, drugGenericName.trim());
		}

		/*监控日期*/
		Date prescribeDateBegin = DateUtil.parseSimpleDate(this.prescribeDateBegin, null);
		Date prescribeDateEnd = DateUtil.parseSimpleDate(this.prescribeDateEnd, null);
		/*所属机构*/
		if (StringUtils.isNotBlank(hospitalCode)){
			criteria.add("REFERRAL_HOSPITAL_CODE", hospitalCode);
		}	
		if(this.patientType.equals(EventType.OUTPATIENT.getCode())){//门急诊
			criteria.add("CLINIC_MARK",OP.IN,new String[]{"1","2"});	//门诊、急诊
			DateUtil.getCriteriaByDateRange(criteria, "CLINIC_DATE", prescribeDateBegin,prescribeDateEnd);//处方开具时间
		}		
		if(this.patientType.equals(EventType.INPATIENT.getCode())){//住院
			criteria.add("CLINIC_MARK","3");
			DateUtil.getCriteriaByDateRange(criteria, "ODRISU_DT", prescribeDateBegin,prescribeDateEnd);//医嘱下达时间
		}		
		criteria.add("EXPENSE_TYPE","1");//只查询药品
		return criteria;
    }

    /*
     * 用药排名
     * */
    public Criteria getMedicationRankingCriteria(){
       	Criteria criteria = new Criteria();
		/*药品编码*/
		if (StringUtils.isNotBlank(drugCode)){
			criteria.add("DRUG_MEDICARE_CODE", drugCode);
		}
		/*监控日期*/
		Date prescribeDateBegin = DateUtil.parseSimpleDate(this.prescribeDateBegin, null);
		Date prescribeDateEnd = DateUtil.parseSimpleDate(this.prescribeDateEnd, null);
		
		if(this.patientType.equals(EventType.OUTPATIENT.getCode())){
			DateUtil.getCriteriaByDateRange(criteria, "CLINIC_DATE", prescribeDateBegin,prescribeDateEnd);
			criteria.add("CLINIC_MARK",OP.IN,new String[]{"1","2"});	//门诊、急诊
		}
		if(this.patientType.equals(EventType.INPATIENT.getCode())){
			DateUtil.getCriteriaByDateRange(criteria, "ODRISU_DT", prescribeDateBegin,prescribeDateEnd);
			criteria.add("CLINIC_MARK","3");
		}
		/*所属机构*/
		if (StringUtils.isNotBlank(hospitalCode)){
			criteria.add("REFERRAL_HOSPITAL_CODE", hospitalCode);
		}
		criteria.add("EXPENSE_TYPE","1");//只查询药品
		return criteria;
    }

    /**
     * 门急诊/住院费用药品比例
     *
     * @return
     * @author Ye jianfei
     */    
    public Criteria getDrugRateCriteria(){
       	Criteria criteria = new Criteria();
    	/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			criteria.add("DETAIL_ITEM_NAME",OP.LIKE, keyword);
		}
		/*监控日期*/
		Date prescribeDateBegin = DateUtil.parseSimpleDate(this.prescribeDateBegin, null);
		Date prescribeDateEnd = DateUtil.parseSimpleDate(this.prescribeDateEnd, null);
		DateUtil.getCriteriaByDateRange(criteria, "SETTLEMENT_DATE", prescribeDateBegin,prescribeDateEnd);

		/*所属机构*/
		if (StringUtils.isNotBlank(hospitalCode)){
			criteria.add("HOSPITAL_CODE", hospitalCode);
		}
		return criteria;
    }
    
    /**
     *  门急诊/住院药品明细
     *
     * @return
     * @author Ye jianfei
     */
    public Criteria getDrugDetailCriteria(){
    	Criteria criteria = new Criteria();
    	/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			criteria.add("DETAIL_ITEM_NAME",OP.LIKE, keyword);
		}
		/*监控日期*/
		Date prescribeDateBegin = DateUtil.parseSimpleDate(this.prescribeDateBegin, null);
		Date prescribeDateEnd = DateUtil.parseSimpleDate(this.prescribeDateEnd, null);
		DateUtil.getCriteriaByDateRange(criteria, "CLINIC_DATE", prescribeDateBegin,prescribeDateEnd);

		/*所属机构*/
		if (StringUtils.isNotBlank(hospitalCode)){
			criteria.add("HOSPITAL_CODE", hospitalCode);
		}		
    	return criteria;
    }


    /**
     * 门诊费用明细
     *
     * @return
     * @author Ye jianfei
     */
    public Criteria getOutpatientItemCriteria(){
    	Criteria criteria = new Criteria();
    	/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			criteria.add("DETAIL_ITEM_NAME",OP.LIKE, keyword);
		}
		/*监控日期*/
		Date prescribeDateBegin = DateUtil.parseSimpleDate(this.prescribeDateBegin, null);
		Date prescribeDateEnd = DateUtil.parseSimpleDate(this.prescribeDateEnd, null);
		DateUtil.getCriteriaByDateRange(criteria, "CLINIC_DATE", prescribeDateBegin,prescribeDateEnd);

		/*所属机构*/
		if (StringUtils.isNotBlank(hospitalCode)){
			criteria.add("HOSPITAL_CODE", hospitalCode);
		}		
    	return criteria;
    }

    /**
     * 住院费用明细
     *
     * @return
     * @author Ye jianfei
     */
    public Criteria getInpatientItemCriteria(){
    	Criteria criteria = new Criteria();
    	/*关键字*/
		if (StringUtils.isNotBlank(keyword)){
			criteria.add("DETAIL_ITEM_NAME",OP.LIKE, keyword);
		}
		/*监控日期*/
		Date prescribeDateBegin = DateUtil.parseSimpleDate(this.prescribeDateBegin, null);
		Date prescribeDateEnd = DateUtil.parseSimpleDate(this.prescribeDateEnd, null);
		DateUtil.getCriteriaByDateRange(criteria, "CLINIC_DATE", prescribeDateBegin,prescribeDateEnd);

		/*所属机构*/
		if (StringUtils.isNotBlank(hospitalCode)){
			criteria.add("HOSPITAL_CODE", hospitalCode);
		}		
    	return criteria;
    }
    
    /**
     * 药品价格监控
     *
     * @return
     * @author Ye jianfei
     */
    public Criteria getDrugPriceCriteria(){
    	Criteria criteria = new Criteria();
    	/*通用名*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE, keyword);
			ca.add(LOP.OR,"DRUG_TRADE_NAME",OP.LIKE,keyword);
			criteria.add(ca);
		}
		/*失效日期*/
		Date prescribeDateBegin = DateUtil.parseSimpleDate(this.expiryBeginDt, null);
		Date prescribeDateEnd = DateUtil.parseSimpleDate(this.expiryEndDt, null);
		DateUtil.getCriteriaByDateRange(criteria, "EXPIRY_DT", prescribeDateBegin,prescribeDateEnd);

		/*所属机构*/
		if (StringUtils.isNotBlank(hospitalCode)){
			criteria.add("ORGAN_CODE", hospitalCode);
		}	
		/*批号*/
		if (StringUtils.isNotBlank(batchNo)){
			criteria.add("BATCH_NO",OP.LIKE,batchNo);
		}		
    	return criteria;
    }
 
    /**
     * 药品分布监控
     *
     * @return
     * @author Ye jianfei
     */
    public Criteria getDrugDistributionCriteria(){
    	Criteria criteria = new Criteria();
    	/*通用名*/
		if (StringUtils.isNotBlank(keyword)){
			Criteria ca = new Criteria("DRUG_GENERIC_NAME",OP.LIKE, keyword);
			ca.add(LOP.OR,"DRUG_TRADE_NAME",OP.LIKE,keyword);
			criteria.add(ca);
		}

		/*所属机构*/
		if (StringUtils.isNotBlank(hospitalCode)){
			criteria.add("ORGAN_CODE", hospitalCode);
		}	
    	return criteria;
    }

    public static void getCriteriaByRange(Criteria criteria, String property, String begin, String end) {

        // 开始时间不为空，结束时间为空
        if (StringUtil.isNotEmpty(begin) && StringUtil.isEmpty(end))
            criteria.add(property, OP.GE, begin);
        if (StringUtil.isNotEmpty(begin) && StringUtil.isNotEmpty(end)) {
            Object[] obj = new Object[2];
            obj[0] = begin;
            obj[1] = end;
            criteria.add(property, OP.BETWEEN, obj);
        }
        if (StringUtil.isEmpty(begin) && StringUtil.isNotEmpty(end))
            criteria.add(property, OP.LE, end);
    }
    
	public String getMonitorIndex() {
		return monitorIndex;
	}

	public void setMonitorIndex(String monitorIndex) {
		this.monitorIndex = monitorIndex;
	}

	public String getMonitorValue() {
		return monitorValue;
	}

	public void setMonitorValue(String monitorValue) {
		this.monitorValue = monitorValue;
	}

	public String getPrescribeDateBegin() {
		return prescribeDateBegin;
	}

	public void setPrescribeDateBegin(String prescribeDateBegin) {
		this.prescribeDateBegin = prescribeDateBegin;
	}

	public String getPrescribeDateEnd() {
		return prescribeDateEnd;
	}

	public void setPrescribeDateEnd(String prescribeDateEnd) {
		this.prescribeDateEnd = prescribeDateEnd;
	}

	public String getPrescribeDoctorName() {
		return prescribeDoctorName;
	}

	public void setPrescribeDoctorName(String prescribeDoctorName) {
		this.prescribeDoctorName = prescribeDoctorName;
	}

	public String getPrescribeDoctorNo() {
		return prescribeDoctorNo;
	}

	public void setPrescribeDoctorNo(String prescribeDoctorNo) {
		this.prescribeDoctorNo = prescribeDoctorNo;
	}

	public String getHospitalCode() {
		return hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	public Order getUnusualOrder() {
		return unusualOrder;
	}

	public void setUnusualOrder(Order unusualOrder) {
		this.unusualOrder = unusualOrder;
	}

	public String getPatientType() {
		return patientType;
	}

	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	public String getDrugGenericName() {
		return drugGenericName;
	}

	public void setDrugGenericName(String drugGenericName) {
		this.drugGenericName = drugGenericName;
	}

	public String getReferralHospitalCode() {
		return referralHospitalCode;
	}

	public void setReferralHospitalCode(String referralHospitalCode) {
		this.referralHospitalCode = referralHospitalCode;
	}

	public String getDrugCode() {
		return drugCode;
	}

	public void setDrugCode(String drugCode) {
		this.drugCode = drugCode;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDetailType() {
		return detailType;
	}

	public void setDetailType(String detailType) {
		this.detailType = detailType;
	}

	public String getDrugCostSum() {
		return drugCostSum;
	}

	public void setDrugCostSum(String drugCostSum) {
		this.drugCostSum = drugCostSum;
	}

	public String getTotalCostSum() {
		return totalCostSum;
	}

	public void setTotalCostSum(String totalCostSum) {
		this.totalCostSum = totalCostSum;
	}

	public String getExpiryBeginDt() {
		return expiryBeginDt;
	}

	public void setExpiryBeginDt(String expiryBeginDt) {
		this.expiryBeginDt = expiryBeginDt;
	}

	public String getExpiryEndDt() {
		return expiryEndDt;
	}

	public void setExpiryEndDt(String expiryEndDt) {
		this.expiryEndDt = expiryEndDt;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedicareCode() {
		return medicareCode;
	}

	public void setMedicareCode(String medicareCode) {
		this.medicareCode = medicareCode;
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

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

    public String getMonitorValueMax() {
        return monitorValueMax;
    }

    public void setMonitorValueMax(String monitorValueMax) {
        this.monitorValueMax = monitorValueMax;
    }
}
