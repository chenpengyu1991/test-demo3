package com.founder.rhip.ehr.repository.control.idm.notifiabledisease;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.control.idm.notifiabledisease.IdmReport;

import java.util.List;
import java.util.Map;

/**
 * DAO interface of DcInfectionDiseaseReport
 * 
 */
public interface IIdmReportDao extends IDao<IdmReport,Integer> {
	/**
	 * 获取上报列表
	 * @param       criteria
	 * @return      PageList<IdmReport>
	 */
	PageList<IdmReport> getReportRecord(Page page, Criteria criteria);
	List<IdmReport> getReportRecord(Criteria criteria);

    PageList<IdmReport> getFrList(Page page, Criteria criteria);

    public void updatePaAddress2(String paStreet, String townName, String villageName);

	List<IdmReport> getReportRecordTable(Criteria criteria);

	PageList<IdmReport> getRepeatCases(Page page, Criteria criteria, String conditions);
	
	public PageList<IdmReport> getReportRecordList(Page page, Criteria criteria);

	public List<IdmReport> getReportRecordList(Criteria criteria);
	
	public List<Map<String, Object>> getDiseaseStatistic(Criteria criteria);

	void updateHrAddress2(String paStreet, String townName, String villageName);
}