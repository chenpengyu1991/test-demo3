package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

public interface IHospitalizeService {
	
	List<Map<String, Object>> getHospitalizes(Map<String, String> paramMap);

}
