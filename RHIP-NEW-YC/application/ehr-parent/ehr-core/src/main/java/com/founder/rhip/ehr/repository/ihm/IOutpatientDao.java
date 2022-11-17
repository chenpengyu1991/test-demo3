package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ihm.HmOutpatient;

public interface IOutpatientDao extends IDao<HmOutpatient, Long>{

	public List<Map<String, Object>> getOutpatients(Map<String, String> paramMap);

}
