package com.founder.rhip.im.service.whch;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.ehr.repository.child.IBirthCertificateDao;
import com.founder.rhip.ehr.repository.women.IBirthDefectMonitorDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("neonateAnalyseService")
public class NeonateAnalyseService implements INeonateAnalyseService {

	@Resource(name = "birthCertificateDao")
	private IBirthCertificateDao birthCertificateDao;

	@Resource(name = "birthDefectMonitorDao")
	private IBirthDefectMonitorDao birthDefectMonitorDao;

	@Override
	public Map<String, Object> getBirthTrendMap(Criteria ca) {
		return birthCertificateDao.getTrendMap(ca);
	}

	@Override
	public Map<String, Object> getDefectTrendMap(Criteria ca) {
		return birthDefectMonitorDao.getTrendMap(ca);
	}

	@Override
	public Map<String, Object> getGenderComposeMap(Criteria ca) {
		return birthCertificateDao.getGenderComposeMap(ca);
	}

	@Override
	public List<Map<String, Object>> getDefectTypeMap(Criteria ca) {
		return birthDefectMonitorDao.getDefectTypeMap(ca);
	}
}
