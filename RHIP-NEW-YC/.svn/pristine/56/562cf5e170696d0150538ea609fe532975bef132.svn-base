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
import org.apache.commons.lang.StringUtils;

/**
 * 精神卫生管理-药品维护
 * 
 * @version 1.0, 2013-9-9
 * @author Ye jianfei
 */
public class MhmDrugQueryForm {
	private String drugName;
	private String drugForm;
	
    /*
     * 药品查询
     * */
    public Criteria getCriteria(){
    	Criteria criteria = new Criteria();
		/*药品名次*/
		if (StringUtils.isNotBlank(drugName)){
			criteria.add("drug.DRUG_NAME", OP.LIKE, drugName);
		}
		/*药品剂型*/
		if (StringUtils.isNotBlank(drugForm)){
			criteria.add("drug.DRUG_FORM",OP.LIKE, drugForm);
		}	
		return criteria;
    }

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getDrugForm() {
		return drugForm;
	}

	public void setDrugForm(String drugForm) {
		this.drugForm = drugForm;
	}
 
}
