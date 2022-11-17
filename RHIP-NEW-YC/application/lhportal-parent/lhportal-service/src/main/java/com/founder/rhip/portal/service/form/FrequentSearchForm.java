package com.founder.rhip.portal.service.form;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.util.ObjectUtil;

/**
 * Created by ss on 2015/11/11.
 */
public class FrequentSearchForm {

    private String frequentName;

    public Criteria getCriteria(){
        Criteria criteria = new Criteria();
        if(ObjectUtil.isNotEmpty(frequentName)){
            criteria.add("frequentName", OP.LIKE, frequentName);
        }
        return criteria;
    }

    public String getFrequentName() {
        return frequentName;
    }

    public void setFrequentName(String frequentName) {
        this.frequentName = frequentName;
    }
}
