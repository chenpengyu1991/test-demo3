package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.rhip.ehr.repository.ihm.IHospitalizeDao;
@Service("hospitalizeService")
public class HospitalizeServiceImpl extends IhmService implements IHospitalizeService{
	@Resource(name="hospitalizeDao")
	private IHospitalizeDao hospitalizeDao;
	
	@Override
	public List<Map<String, Object>> getHospitalizes(Map<String, String> paramMap) {
		return hospitalizeDao.getHospitalizes(paramMap);
	}
}
