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


public class FilariasisReportForm {
    /*年份*/
    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Criteria getChCriteria(Criteria criteria){
        if (StringUtils.isNotBlank(year)){
            criteria.add("year", year);
        }

		return criteria;
	}


}
