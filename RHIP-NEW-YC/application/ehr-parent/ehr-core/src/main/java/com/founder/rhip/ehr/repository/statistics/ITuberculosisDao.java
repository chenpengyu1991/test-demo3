package com.founder.rhip.ehr.repository.statistics;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.dto.Tuberculosis;
import com.founder.rhip.ehr.dto.VaccinationService;
import com.founder.rhip.ehr.entity.basic.Populace;

public interface ITuberculosisDao extends IDao<Tuberculosis, Long>{
	Tuberculosis getTuberculosis(Criteria criteria);

	Tuberculosis getTuberculosisSum(Criteria criteria, List<String> organCodeList);

	Populace getPopulace(Criteria criteria, List<String> organCodeList);
}
