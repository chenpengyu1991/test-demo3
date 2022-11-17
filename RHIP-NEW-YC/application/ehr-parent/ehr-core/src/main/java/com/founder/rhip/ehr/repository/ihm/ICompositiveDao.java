package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ihm.RdInpatientCompositive;

public interface ICompositiveDao extends IDao<RdInpatientCompositive, Long>{

	public List<Map<String, Object>> getCompositives(Map<String, String> paramMap);

}
