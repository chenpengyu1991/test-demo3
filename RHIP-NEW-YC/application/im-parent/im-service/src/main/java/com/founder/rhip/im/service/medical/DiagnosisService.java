package com.founder.rhip.im.service.medical;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.im.repository.medical.IRdDiagnosisDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("diagnosisService")
public class DiagnosisService implements IDiagnosisService {

	@Resource(name = "rdDiagnosisDao")
	private IRdDiagnosisDao rdDiagnosisDao;


	@Override
	public List<Map<String, Object>> getRankingMapList(Criteria ca) {
		return rdDiagnosisDao.getRankingMapList(ca);
	}
}
