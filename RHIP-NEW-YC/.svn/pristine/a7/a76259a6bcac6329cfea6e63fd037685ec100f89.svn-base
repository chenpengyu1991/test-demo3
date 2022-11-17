package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.management.InoculationAppointment;

import java.util.List;
import java.util.Map;

public interface IInoculationDao extends IDao<InoculationAppointment, Long> {
	PageList<InoculationAppointment> getPageListBySql(Page page, String sql, Criteria criteria);
	List<Map<String, Object>>  getMapListBySql(String sql, Criteria criteria);
	/**
	 * 23价疫苗预约接种统计报表
	 * @return
	 */
	List<Map<String, Object>> statisticsVaccinationReport(Criteria criteria);
}
