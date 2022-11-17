package com.founder.rhip.ehr.repository.lda;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;

import java.util.List;
import java.util.Map;

/**
 * DAO interface
 */
public interface ILdaDao extends IDao<IdmReport, Long> {

    public PageList<Map<String, Object>> getUnusualPrescriptionList(Page page,Criteria criteria,Order order,String monitorIndex,Map<String,String> paramMap);

    public PageList<Map<String, Object>> getAntibacterials(Map<String, String> paramMap, Page page);

    public List<Map<String, Object>> getDoctors(String orgCode, String medicalCode, String beginDateA, String endDateA);

}