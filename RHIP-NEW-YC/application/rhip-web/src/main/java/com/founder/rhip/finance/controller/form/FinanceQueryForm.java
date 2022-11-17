package com.founder.rhip.finance.controller.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.util.StringUtil;

public class FinanceQueryForm {

	private String yearMonth;

    public String getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(String yearMonth) {
        this.yearMonth = yearMonth;
    }

    public Criteria toCriteria() {
		Criteria criteria = new Criteria();
		if (StringUtil.isNotEmpty(yearMonth)) {
			criteria.add("month", yearMonth.replace("/",""));
		}
		return criteria;
	}
    
    public Criteria toLastCriteria() {
        Criteria criteria = new Criteria();
        if (StringUtil.isNotEmpty(yearMonth)) {
            String year = yearMonth.substring(0,4);
            String month = yearMonth.substring(5,7);
            String lastYear = String.valueOf(Integer.valueOf(year) - 1);
            criteria.add("month", lastYear + month);
        }
        return criteria;
    }
}
