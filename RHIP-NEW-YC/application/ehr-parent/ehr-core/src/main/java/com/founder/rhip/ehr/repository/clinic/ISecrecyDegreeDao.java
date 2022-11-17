package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.clinic.DrugUsage;
import com.founder.rhip.ehr.entity.clinic.SecrecyDegreeSet;

import java.util.List;

/**
 * DAO interface of InpatientDrugUsage
 */
public interface ISecrecyDegreeDao extends IDao<SecrecyDegreeSet, Long> {

    public PageList<SecrecyDegreeSet> getSecrecyDegreeList(Page page, Criteria criteria);

}