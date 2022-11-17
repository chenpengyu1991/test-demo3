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
import org.apache.commons.lang.StringUtils;

/**
 * 直报查询表单
 * 
 * @version 1.0, 2013-3-7
 * @author Ye jianfei
 */
public class SetupQueryForm {
    private Integer setYear;
    private String caseOrganCode;
    private String infectiousCode;
    private String itemCode;
    private String icdCode;

    /**
     * @return the setYear
     */
    public Integer getSetYear() {
        return setYear;
    }

    /**
     * @param setYear the setYear to set
     */
    public void setSetYear(Integer setYear) {
        this.setYear = setYear;
    }

    public String getCaseOrganCode() {
        return caseOrganCode;
    }

    public void setCaseOrganCode(String caseOrganCode) {
        this.caseOrganCode = caseOrganCode;
    }

    public String getInfectiousCode() {
        return infectiousCode;
    }

    public void setInfectiousCode(String infectiousCode) {
        this.infectiousCode = infectiousCode;
    }

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public Criteria getCriteria() {
		Criteria criteria = new Criteria();
		getDateCriteria(criteria);
		return criteria;
	}
	
	public Criteria getSetupDiseaseCriteria() {
		Criteria criteria = new Criteria();
	    if (StringUtils.isNotEmpty(itemCode)){
            criteria.add("itemCode", OP.EQ, itemCode);
        }
        if (StringUtils.isNotEmpty(icdCode)){
            criteria.add("icdCode", OP.LIKE, icdCode);
        }
		return criteria;
	}

	private Criteria getDateCriteria(Criteria criteria){
		/*年份*/
		if (setYear != null && setYear>0){
			criteria.add("setYear", OP.EQ, setYear);
		}
        if (StringUtils.isNotEmpty(caseOrganCode)){
            criteria.add("caseOrganCode", OP.EQ, caseOrganCode);
        }
        if (StringUtils.isNotEmpty(infectiousCode)){
            criteria.add("infectiousCode", OP.EQ, infectiousCode);
        }
		return criteria;
	}

}
