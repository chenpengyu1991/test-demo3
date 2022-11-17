package com.founder.rhip.ehr.repository.report;

import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.report.RpPaVaccination;

public interface IRpPaVaccinationDao extends IDao<RpPaVaccination, Long> {
	
	PageList<Map<String, Object>> getPaVaccinationPageList(Criteria criteria, Page page);

}
