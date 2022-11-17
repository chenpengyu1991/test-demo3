package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.rhip.ehr.repository.ihm.IOutpatientDao;


@Service("outpatientIhmService")
public class OutpatientIhmServiceImpl extends IhmService implements IOutpatientIhmService{
	
	  @Resource(name="outpatientDao") 
	  private IOutpatientDao outpatientDao;
	
	
	@Override
	public List<Map<String, Object>> getOutpatients(Map<String, String> paramMap) {
		return outpatientDao.getOutpatients(paramMap);
	}
}