package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;

import java.util.List;

/**
 *
 */
public interface IMhmStatisticsDao extends IDao<MhmDrug,Long> {

    /**
     *
     * @param criteria
     * @return
     */
    public PageList<MhmDrug> getDrugResult(Criteria criteria, Page page);

    public List<MhmDrug> getDrugList(Criteria criteria);

    /**
     *
     * @param criteria
     * @return
     */
    public PageList<MhmDrug> getPatientResult(Criteria criteria, Page page);

    public List<MhmDrug> getPatientList(Criteria criteria);
}