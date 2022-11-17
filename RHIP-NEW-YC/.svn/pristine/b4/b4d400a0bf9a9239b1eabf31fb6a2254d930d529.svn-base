/*
 * Copyright (c) 2010-2020 Founder Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of
 * Founder. You shall not disclose such Confidential Information
 * and shall use it only in accordance with the terms of the agreements
 * you entered into with Founder.
 */

package com.founder.rhip.mdm.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

import java.util.Date;

/**
 * 直报查询表单
 * 
 * @version 1.0, 2013-3-7
 * @author Ye jianfei
 */
public class ReportRecordQueryForm {
    private String idcard;
    private String name;
    private Integer type;
	private Integer idmStatus;
	private Integer dmdStatus;
	private String createDateBegin;
	private String createDateEnd;
    private String createOrganCode;
    private String reportDoctorName;
    private String deleteFlag;//是否删除

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIdmStatus() {
        return idmStatus;
    }

    public void setIdmStatus(Integer idmStatus) {
        this.idmStatus = idmStatus;
    }

    public Integer getDmdStatus() {
        return dmdStatus;
    }

    public void setDmdStatus(Integer dmdStatus) {
        this.dmdStatus = dmdStatus;
    }

    public String getCreateDateBegin() {
        return createDateBegin;
    }

    public void setCreateDateBegin(String createDateBegin) {
        this.createDateBegin = createDateBegin;
    }

    public String getCreateDateEnd() {
        return createDateEnd;
    }

    public void setCreateDateEnd(String createDateEnd) {
        this.createDateEnd = createDateEnd;
    }

    public Criteria getCriteria() {
		Criteria criteria = new Criteria();
		getDateCriteria(criteria);
		return criteria;
	}

    public String getCreateOrganCode() {
        return createOrganCode;
    }

    public void setCreateOrganCode(String createOrganCode) {
        this.createOrganCode = createOrganCode;
    }

    public String getReportDoctorName() {
        return reportDoctorName;
    }

    public void setReportDoctorName(String reportDoctorName) {
        this.reportDoctorName = reportDoctorName;
    }

    private Criteria getDateCriteria(Criteria criteria){
        if (null != idcard && idcard != ""){
            criteria.add("idcard", OP.LIKE, idcard);
        }
        if (null !=name && name != ""){
            criteria.add("name", OP.LIKE, name);
        }
        if (null != createOrganCode && createOrganCode != ""){
            criteria.add("createOrganCode", OP.EQ, createOrganCode);
        }

        if (null != reportDoctorName && reportDoctorName != ""){
            criteria.add("reportDoctorName", OP.LIKE, reportDoctorName);
        }
        if(StringUtil.isNotEmpty(deleteFlag)){
        	criteria.add("IS_DELETE", deleteFlag.equals("2")?"0":"-1");
        }

		/*报卡日期*/
		Date createDateBegin = DateUtil.parseSimpleDate(this.createDateBegin, null);
		Date createDateEnd = DateUtil.parseSimpleDate(this.createDateEnd, null);
		DateUtil.getCriteriaByDateRange(criteria, "createDate", createDateBegin,createDateEnd);
		return criteria;
	}

	public String getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}
