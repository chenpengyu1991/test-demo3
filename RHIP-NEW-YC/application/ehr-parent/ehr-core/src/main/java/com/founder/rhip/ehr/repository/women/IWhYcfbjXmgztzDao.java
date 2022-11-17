package com.founder.rhip.ehr.repository.women;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.women.WhYcfbjXmgztz;

import java.math.BigDecimal;
import java.util.List;

/**
 * DAO interface of WhYcfbjXmgztz
 */
public interface IWhYcfbjXmgztzDao extends IDao<WhYcfbjXmgztz, Long> {

    public List<WhYcfbjXmgztz> getAccountList(Criteria ca);


    public BigDecimal getMaxRate(Criteria ca);
}