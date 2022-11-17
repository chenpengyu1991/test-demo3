package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.rhip.ehr.repository.ihm.IHospitalizeDao;
import com.founder.rhip.ehr.repository.ihm.ISimpleDiseaseDao;

@Service("simpleDiseaseService")
public class SimpleDiseaseServiceImpl extends IhmService implements ISimpleDiseaseService{
	@Resource(name="simpleDiseaseDao")
	private ISimpleDiseaseDao simpleDiseaseDao;
	
	@Override
	public List<Map<String, Object>> getSimpleDiseases(Map<String, String> paramMap) {
		return simpleDiseaseDao.getSimpleDiseases(paramMap);
	}
}