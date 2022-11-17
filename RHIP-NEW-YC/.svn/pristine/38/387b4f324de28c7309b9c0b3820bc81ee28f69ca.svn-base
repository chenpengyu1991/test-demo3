
package com.founder.rhip.ihm.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.rhip.ehr.repository.ihm.ICompositiveDao;
import com.founder.rhip.ehr.repository.ihm.IOutpatientDao;


@Service("compositiveService")
public class CompositiveServiceImpl extends IhmService implements ICompositiveService{
	
	  @Resource(name="compositiveDao") 
	  private ICompositiveDao compositiveDao;
	
	
	@Override
	public List<Map<String, Object>> getCompositives(Map<String, String> paramMap) {
		return compositiveDao.getCompositives(paramMap);
	}
}
