package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of VaccinationMgmt
 */
public interface IVaccinationMgmtDao extends IDao<VaccinationMgmt, String> {

    public PageList<VaccinationMgmt> getVaccinationMgmtList(Page page, Criteria criteria);
    public List<Map<String, Object>> exportVaccineList(Page page, Criteria criteria);
}