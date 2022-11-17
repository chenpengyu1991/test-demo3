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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 精神病人查询表单
 * 
 * @version 1.0, 2013-7-17
 * @author Ye jianfei
 */
public class ManagementQueryForm {

    private String name;
    private String idcard;
    private String managementTown;
    private String patientType;
    private String mgntType;
    private String patientSource;
    private String freeType;
    private String aliveType;
    private String regBeginDate;
    private String regEndDate;
    private String diseaseType;    //疾病类型
    private String searchSource;//1精神卫生随访 2精神卫生体检
    private String followupFlag;

    public String getFollowupFlag() {
        return followupFlag;
    }

    public void setFollowupFlag(String followupFlag) {
        this.followupFlag = followupFlag;
    }

    public String getSearchSource() {
        return searchSource;
    }

    public void setSearchSource(String searchSource) {
        this.searchSource = searchSource;
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

    public String getManagementTown() {
        return managementTown;
    }

    public void setManagementTown(String managementTown) {
        this.managementTown = managementTown;
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

    public String getFreeType() {
        return freeType;
    }

    public void setFreeType(String freeType) {
        this.freeType = freeType;
    }

    public String getAliveType() {
        return aliveType;
    }

    public void setAliveType(String aliveType) {
        this.aliveType = aliveType;
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

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public Criteria getMgntCriteria(){
        Criteria criteria = new Criteria();
		/*姓名*/
        if (StringUtils.isNotBlank(name)){
            criteria.add("B.NAME", OP.LIKE, name);
        }
		/*身份证号码*/
        if (StringUtils.isNotBlank(idcard)){
            criteria.add("B.IDCARD", idcard.toUpperCase());
        }
		/*所属乡镇*/
        if (StringUtils.isNotBlank(managementTown)){
            criteria.add("O.MANAGEMENT_TOWN", managementTown);
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
        /*是否免费服药*/
        if (StringUtils.isNotBlank(freeType)){
            criteria.add("O.FREE_FLAG", freeType);
        }
        /*存活状态*/
        if (StringUtils.isNotBlank(aliveType)){
        	if("1".equals(aliveType)){//死亡
        		criteria.add("S.STATUS", MhmStatus.MANAGEMENT.getValue());
        	}
        	if("2".equals(aliveType)){//未死亡
        		criteria.add("S.STATUS", MhmStatus.DEAD.getValue());
        	}        	
        }else{
            List<Integer> param = new ArrayList<Integer>();
            param.add(MhmStatus.MANAGEMENT.getValue());
            param.add(MhmStatus.DEAD.getValue());
            criteria.add("S.STATUS", OP.IN, param);
        }
        /*疾病类型*/
        if (StringUtils.isNotBlank(diseaseType)){
            criteria.add("D.DIAGNOSIS_CONTENT", diseaseType);
        }

        if (StringUtils.isNotBlank(followupFlag)){
            criteria.add("followupFlag", followupFlag);
        }

		/*登记日期*/
        Date regBeginDate = DateUtil.parseSimpleDate(this.regBeginDate, null);
        Date regEndDate = DateUtil.parseSimpleDate(this.regEndDate, null);
        DateUtil.getCriteriaByDateRange(criteria, "O.FILL_DATE", regBeginDate,regEndDate);

        return criteria;
    }
}
