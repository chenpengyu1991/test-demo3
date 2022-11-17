package com.founder.rhip.im.service.publicHealth;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.im.entity.publicHealth.RdTargetPublicHealth;
import com.founder.rhip.im.repository.publicHealth.IRdReportCardDao;
import com.founder.rhip.im.repository.publicHealth.IRdTargetPublicHealthDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("targetPublicHealthService")
public class TargetPublicHealthServiceImpl implements ITargetPublicHealthService{

	@Resource(name = "rdTargetPublicHealthDao")
	private IRdTargetPublicHealthDao rdTargetPublicHealthDao;

	@Resource(name = "rdReportCardDao")
	private IRdReportCardDao rdReportCardDao;

	@Override
	public RdTargetPublicHealth getTarget(Criteria ca) {
		return rdTargetPublicHealthDao.get(ca);
	}

	@Override
	public Map<String, Map<String, Object>> getReportCardTrendMap(Criteria criteria) {
		Map<String,Map<String,Object>> result = new HashMap<>();
		List<Map<String,Object>> mapList = rdReportCardDao.getReportCardTrendList(criteria);
		for(Map<String,Object> map:mapList){
			result.put(map.get("BUSINESS_TYPE").toString(),map);
		}
		return result;
	}
}