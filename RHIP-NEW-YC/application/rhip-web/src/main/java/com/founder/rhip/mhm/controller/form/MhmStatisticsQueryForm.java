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
import com.founder.fasf.util.StringUtil;

import java.util.Date;

/**
 * 精神卫生管理-报表管理(药品费用统计)
 */
public class MhmStatisticsQueryForm {

	private String drugId;
	private String drugId_name;
	private String drugDtFrom;
	private String drugDtTo;
	private String townCode;
	private String centerCode;
	private String stationCode;

    private String name;
    private String idcard;
    private String diagnosisContent;

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugDtFrom() {
        return drugDtFrom;
    }

    public void setDrugDtFrom(String drugDtFrom) {
        this.drugDtFrom = drugDtFrom;
    }

    public String getDrugDtTo() {
        return drugDtTo;
    }

    public void setDrugDtTo(String drugDtTo) {
        this.drugDtTo = drugDtTo;
    }

    public String getTownCode() {
        return townCode;
    }

    public void setTownCode(String townCode) {
        this.townCode = townCode;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
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

    public String getDiagnosisContent() {
        return diagnosisContent;
    }

    public void setDiagnosisContent(String diagnosisContent) {
        this.diagnosisContent = diagnosisContent;
    }

    public String getDrugId_name() {
        return drugId_name;
    }

    public void setDrugId_name(String drugId_name) {
        this.drugId_name = drugId_name;
    }

    public Criteria getCriteria(){
        Criteria criteria = new Criteria();
        if(StringUtil.isNotEmpty(drugId)){
            criteria.add("DRUG_ID", drugId);
        }else if(StringUtil.isNotEmpty(drugId_name)){
            if(needConvert(drugId_name)){
                criteria.add("DRUG_NAME", OP.LIKE, deCodeURLName(drugId_name));
            } else{
                criteria.add("DRUG_NAME", OP.LIKE, drugId_name);
            }
        }
        if(StringUtil.isNotEmpty(drugDtFrom) ||StringUtil.isNotEmpty(drugDtTo)){
            Date drugBeginDate = DateUtil.parseSimpleDate(this.drugDtFrom, null);
            Date drugEndDate = DateUtil.parseSimpleDate(this.drugDtTo, null);
            DateUtil.getCriteriaByDateRange(criteria, "USE_DT", drugBeginDate,drugEndDate);
        }
        if(StringUtil.isNotEmpty(townCode)){
            criteria.add("MODIFY_ORGAN_TOWN", townCode);
        }
        if(StringUtil.isNotEmpty(centerCode)){
            criteria.remove("MODIFY_ORGAN_TOWN");
            criteria.add("MODIFY_ORGAN_CENTER", centerCode);
        }
        if(StringUtil.isNotEmpty(stationCode)){
            criteria.remove("MODIFY_ORGAN_TOWN");
            criteria.remove("MODIFY_ORGAN_CENTER");
            criteria.add("MODIFY_ORGAN_STATION", stationCode);
        }
        return criteria;
    }

    public Criteria getPatientCriteria(){
        Criteria criteriaDrug = getCriteria();
        Criteria criteriaPerson = new Criteria();
        if(StringUtil.isNotEmpty(name)){            criteriaPerson.add("B.NAME", name);
        }
        if(StringUtil.isNotEmpty(idcard)){
            criteriaPerson.add("B.IDCARD", idcard);
        }
        if(StringUtil.isNotEmpty(diagnosisContent)){
            if(needConvert(diagnosisContent)){
                criteriaPerson.add("D.DIAGNOSIS_CONTENT", deCodeURLName(diagnosisContent));
            }else{
                criteriaPerson.add("D.DIAGNOSIS_CONTENT", diagnosisContent);
            }
        }
        Criteria criteria = new Criteria();
        criteria.add("criteriaDrug", criteriaDrug);
        criteria.add("criteriaPerson", criteriaPerson);
        return criteria;
    }

    public static String deCodeURLName(String name) {
        String result = null;
        try {
            result = name != null ? new String(name.getBytes("ISO-8859-1"),"UTF-8") : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Boolean needConvert(String str) {
        if(java.nio.charset.Charset.forName("ISO-8859-1").newEncoder().canEncode(str)){
            return true;
        }
        return false;
    }
}
