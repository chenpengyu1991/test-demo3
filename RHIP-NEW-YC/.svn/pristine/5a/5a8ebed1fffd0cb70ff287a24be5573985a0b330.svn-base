package com.founder.rhip.im.service.medical;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.im.repository.medical.IRdRealnameClinicDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 实名制就诊统计
 */
@Service("realNameAnalyseService")
public class RealNameAnalyseService implements IRealNameAnalyseService {

	@Resource(name = "rdRealnameClinicDao")
	private IRdRealnameClinicDao rdRealnameClinicDao;

	@Override
	public Map<String, Object> getMonthTrendMap(Criteria ca) {
		return rdRealnameClinicDao.getMonthTrendMap(ca);
	}

	@Override
	public List<Map<String, Object>> getRankingMapList(Criteria ca) {
		return rdRealnameClinicDao.getRankingMapList(ca);
	}

	@Override
	public Map<String, Object> getComposeMap(Criteria ca) {
		return null;
	}
}
