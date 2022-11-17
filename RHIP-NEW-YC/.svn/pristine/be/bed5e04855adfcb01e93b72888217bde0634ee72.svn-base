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
import org.apache.commons.lang.StringUtils;


public class JcReportForm {
    /*月份*/
    private String month;
    /*村镇*/
    private String patownShip;


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getPatownShip() {
        return patownShip;
    }

    public void setPatownShip(String patownShip) {
        this.patownShip = patownShip;
    }

    public Criteria getJcCriteria(Criteria criteria){
        if (StringUtils.isNotBlank(month)){
            criteria.add("month", month);
        }
        if (StringUtils.isNotBlank(patownShip)){
            criteria.add("patownShip", patownShip);
        }


		return criteria;
	}


}
