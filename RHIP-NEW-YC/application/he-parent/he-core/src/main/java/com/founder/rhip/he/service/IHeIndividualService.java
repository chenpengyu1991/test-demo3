package com.founder.rhip.he.service;

import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.healtheducation.HeIndividual;

public interface IHeIndividualService {

	PageList<HeIndividual> findHealthEducationActive(Criteria criteria, Page page);

	void createHeIndividual(HeIndividual heIndividual, Map<String, String> fileMap, String name);

	void updateHeIndividual(HeIndividual heIndividual, Map<String, String> fileMap, String name, String[] properties);

	HeIndividual getHeIndividual(Criteria criteria);

	void deleteHeIndividual(Long id);
}
