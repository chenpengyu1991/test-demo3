package com.founder.rhip.ehr.repository.statistics;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.VaccinationService;

public interface IHealthVaccinationDao extends IDao<VaccinationService, Long>{

	VaccinationService getVaccinationService(Criteria criteria);

	VaccinationService getVaccinationServiceSum(Criteria criteria, List<String> organCodeList);

	int getAllNum(Criteria criteria);
}
