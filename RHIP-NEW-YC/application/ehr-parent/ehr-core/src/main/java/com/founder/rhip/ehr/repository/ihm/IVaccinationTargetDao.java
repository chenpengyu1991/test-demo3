package com.founder.rhip.ehr.repository.ihm;

import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;

public interface IVaccinationTargetDao extends IDao<VaccinationMgmt, Long> {
	
	public PageList<Map<String, Object>> getSideEffectlist(Page page, Criteria criteria);
	
	public Object getSideEffect(String id);
	
	public PageList<Map<String, Object>> getTaboolist(Page page, Criteria criteria);
	
	public Object getTaboo(String id);
}