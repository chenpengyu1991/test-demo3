package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;


public interface IVaccinationTargetService{
	public PageList<Map<String, Object>> getSideEffectlist(Page page, Criteria criteria);
	
	public Object getSideEffect(String id);
	
	public PageList<Map<String, Object>> getTaboolist(Page page, Criteria criteria);
	
	public Object getTaboo(String id);
	
	public PageList<VaccinationMgmt> getVaccinationMgmtList(Page page, Criteria criteria);
	
	public List<VaccinationInfo> getVaccinationInfoList(Criteria criteria);
	
	public VaccinationMgmt getVaccinationMgmt(Criteria criteria);

    PageList<VaccinationMgmt> getVaccinationMgmtList2(Page page, Criteria criteria);
}