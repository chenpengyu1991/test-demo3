package com.founder.rhip.ihm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.dto.VaccinationService;

import java.util.List;

public interface IhealthVaccinationService {

	List<VaccinationService> VaccinationServiceList(Criteria criteria);

	VaccinationService VaccinationServiceListSum(Criteria criteria);

	int updateVaccination(VaccinationService vaccinationService);

	int addVaccination(VaccinationService vaccinationService);

	//预防接种总人数
	int getAll(Criteria criteria);
}
