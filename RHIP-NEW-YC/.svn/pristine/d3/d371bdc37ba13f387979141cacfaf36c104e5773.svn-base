package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.control.VaccinationInfo;
import com.founder.rhip.ehr.entity.control.VaccinationMgmt;
import com.founder.rhip.ehr.repository.control.IVaccinationInfoDao;
import com.founder.rhip.ehr.repository.control.IVaccinationMgmtDao;
import com.founder.rhip.ehr.repository.ihm.IVaccinationTargetDao;

@Service("vaccinationTargetService")
public class VaccinationTargetServiceImpl implements IVaccinationTargetService{
	@Resource(name = "vaccinationTargetDao")
	private IVaccinationTargetDao vaccinationTargetDao;
	
	@Resource(name = "vaccinationMgmtDao")
	private IVaccinationMgmtDao vaccinationMgmtDao;
	
	@Resource(name = "vaccinationInfoDao")
	private IVaccinationInfoDao vaccinationInfoDao;
	
	public PageList<Map<String, Object>> getSideEffectlist(Page page, Criteria criteria)
	{
		return vaccinationTargetDao.getSideEffectlist(page, criteria);
	}
	
	public Object getSideEffect(String id)
	{
		return vaccinationTargetDao.getSideEffect(id);
	}
	
	public PageList<Map<String, Object>> getTaboolist(Page page, Criteria criteria)
	{
		return vaccinationTargetDao.getTaboolist(page, criteria);
	}
	
	public Object getTaboo(String id)
	{
		return vaccinationTargetDao.getTaboo(id);
	}

	@Override
	public PageList<VaccinationMgmt> getVaccinationMgmtList(Page page, Criteria criteria) {
		Order order = new Order("name");
		return vaccinationMgmtDao.getPageList(page, criteria, order);
	}
	@Override
	public List<VaccinationInfo> getVaccinationInfoList(Criteria criteria) {
		Order order = new Order("vaccine_name").asc("VACCINATION_DATE");
		return vaccinationInfoDao.getList(criteria,order);
	}
	
	public VaccinationMgmt getVaccinationMgmt(Criteria criteria) {
		return vaccinationMgmtDao.get(criteria);
	}

    public PageList<VaccinationMgmt> getVaccinationMgmtList2(Page page, Criteria criteria){
        return vaccinationMgmtDao.getVaccinationMgmtList(page, criteria);
    }
}