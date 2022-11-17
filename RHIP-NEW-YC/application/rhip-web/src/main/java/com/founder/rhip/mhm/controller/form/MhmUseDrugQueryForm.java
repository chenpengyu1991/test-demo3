/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.mhm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.rhip.mhm.common.MhmStatus;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

/**
 * 精神卫生管理-发药登记
 * 
 * @version 1.0, 2013-9-11
 * @author Yang Liu
 */
public class MhmUseDrugQueryForm {
    private String name;
    private String idcard;
    private String managementStation;
    private String patientType;
	private String mgntType;
    private String patientSource;
    private String regBeginDate;
    private String regEndDate;
	private String drugName;
	private String fillOrganTown;
	private String fillOrganCenter;
	private String fillOrganStation;
    /**
     * 
     * 发药登记
     * */
    public Criteria getUseDrugCriteria(){
        Criteria criteria = new Criteria();
        criteria.add("S.STATUS", MhmStatus.MANAGEMENT.getValue());
		/*姓名*/
        if (StringUtils.isNotBlank(name)){
            criteria.add("B.NAME", OP.LIKE, name);
        }
		/*身份证号码*/
        if (StringUtils.isNotBlank(idcard)){
            criteria.add("B.IDCARD", idcard.toUpperCase());
        }
		/*所属机构-站*/
        if (StringUtils.isNotBlank(managementStation)){
            criteria.add("O.MANAGEMENT_STATION", managementStation);
        }
		/*病人类型*/
        if (StringUtils.isNotBlank(patientType)){
            criteria.add("O.PATIENT_TYPE", patientType);
        }
        /*管理方式*/
        if (StringUtils.isNotBlank(mgntType)){
            criteria.add("O.BRING_INTO_MODE", mgntType);
        }
        /*病人来源*/
        if (StringUtils.isNotBlank(patientSource)){
            criteria.add("S.PATIENT_RESOURCE", patientSource);
        }
        /*免费服药对象*/
        criteria.add("O.FREE_FLAG", "1");

		/*登记日期*/
        Date regBeginDate = DateUtil.parseSimpleDate(this.regBeginDate, null);
        Date regEndDate = DateUtil.parseSimpleDate(this.regEndDate, null);
        DateUtil.getCriteriaByDateRange(criteria, "O.FILL_DATE", regBeginDate,regEndDate);
        return criteria;
    }

    /**
     * 
     * 发药查询
     * */
    public Criteria getCriteria(){
        Criteria criteria = new Criteria();
		/*姓名*/
        if (StringUtils.isNotBlank(name)){
            criteria.add("basics.NAME", OP.LIKE, name);
        }
		/*身份证号码*/
        if (StringUtils.isNotBlank(idcard)){
            criteria.add("basics.IDCARD", idcard.toUpperCase());
        }
		/*发药机构-镇*/
        if (StringUtils.isNotBlank(fillOrganTown)){
            criteria.add("druguse.FILL_ORGAN_TOWN", fillOrganTown);
        }        
		/*发药机构-中心*/
        if (StringUtils.isNotBlank(fillOrganCenter)){
            criteria.add("org.MANAGEMENT_CENTER", fillOrganCenter);
        }        
		/*发药机构-站*/
        if (StringUtils.isNotBlank(fillOrganStation)){
            criteria.add("org.MANAGEMENT_STATION", fillOrganStation);
        }
        /*药品名称*/
        if (StringUtils.isNotBlank(drugName)){
            criteria.add("drug.DRUG_NAME", drugName);
        }

		/*发药日期*/
        Date regBeginDate = DateUtil.parseSimpleDate(this.regBeginDate, null);
        Date regEndDate = DateUtil.parseSimpleDate(this.regEndDate, null);
        DateUtil.getCriteriaByDateRange(criteria, "druguse.USE_DT", regBeginDate,regEndDate);
        return criteria;
    }
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getIdcard() {
		return idcard;
	}

	
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	
	public String getManagementStation() {
		return managementStation;
	}

	
	public void setManagementStation(String managementStation) {
		this.managementStation = managementStation;
	}

	
	public String getPatientType() {
		return patientType;
	}

	
	public void setPatientType(String patientType) {
		this.patientType = patientType;
	}

	
	public String getMgntType() {
		return mgntType;
	}

	
	public void setMgntType(String mgntType) {
		this.mgntType = mgntType;
	}

	
	public String getPatientSource() {
		return patientSource;
	}

	
	public void setPatientSource(String patientSource) {
		this.patientSource = patientSource;
	}

	
	public String getRegBeginDate() {
		return regBeginDate;
	}

	
	public void setRegBeginDate(String regBeginDate) {
		this.regBeginDate = regBeginDate;
	}

	
	public String getRegEndDate() {
		return regEndDate;
	}

	
	public void setRegEndDate(String regEndDate) {
		this.regEndDate = regEndDate;
	}

	public String getFillOrganTown() {
		return fillOrganTown;
	}

	public void setFillOrganTown(String fillOrganTown) {
		this.fillOrganTown = fillOrganTown;
	}

	public String getFillOrganCenter() {
		return fillOrganCenter;
	}

	public void setFillOrganCenter(String fillOrganCenter) {
		this.fillOrganCenter = fillOrganCenter;
	}

	public String getFillOrganStation() {
		return fillOrganStation;
	}

	public void setFillOrganStation(String fillOrganStation) {
		this.fillOrganStation = fillOrganStation;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}




}
