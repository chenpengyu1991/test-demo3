package com.founder.rhip.ihm.service;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.Tuberculosis;

public interface ItuberculosisService {
	List<Tuberculosis> tuberculosisServiceList(Criteria criteria);

	Tuberculosis tuberculosisServiceListSum(Criteria criteria);

	int updateTuberculosis(Tuberculosis tuberculosis);

	int addTuberculosis(Tuberculosis tuberculosis);
}
