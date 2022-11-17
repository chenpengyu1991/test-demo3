package com.founder.rhip.ehr.repository.ihm;

import java.util.List;
import java.util.Map;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.ihm.HmHospitalize;

public interface IHospitalizeDao extends IDao<HmHospitalize, Long>{

	List<Map<String, Object>> getHospitalizes(Map<String, String> paramMap);

	
}
