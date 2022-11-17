package com.founder.rhip.ehr.service.basic;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.entity.basic.IntegrationLog;
import com.founder.rhip.ehr.repository.basic.IIntegrationLogDao;

@Service("integrationLogService")
public class IIntegrationLogServiceImpl extends AbstractService implements IIntegrationLogService {

	@Resource(name = "integrationLogDao")
	private IIntegrationLogDao integrationLogDao;
	
	@Override
	public void saveIntegrationLog(IntegrationLog integrationLog) {
		if (integrationLog == null) {
			return;
		}
		try {
			integrationLogDao.insert(integrationLog);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage(), e);
		}
	}
}
