package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ihm.HmSimpleDisease;

public interface ISimpleDiseaseDao extends IDao<HmSimpleDisease, Long>{

	public List<Map<String, Object>> getSimpleDiseases(Map<String, String> paramMap);

}
