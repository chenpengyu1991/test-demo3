package com.founder.rhip.ihm.service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.repository.ihm.IDiStatisticsDao;
import com.founder.rhip.ehr.repository.ihm.IHbpStatisticsDao;

/**
 * @author liuk
 * @since 2014/5/21 16:11
 */
@Service("dmStatisticsService")
public class DmStatisticsServiceImpl implements IDmStatisticsService {
	@Resource(name = "hbpStatisticsDao")
	private IHbpStatisticsDao hbpStatisticsDao;

	@Resource(name = "diStatisticsDao")
	private IDiStatisticsDao diStatisticsDao;

	@Override
	public List<Map<String, Object>> getCdmStatisticsData(String orgType, String townCode, String centreCode, String stationCode, Date inputBeginDate, Date inputEndDate) {
		List<Map<String, Object>> hbps = hbpStatisticsDao.getStatisticsData(orgType, townCode, centreCode, stationCode, inputBeginDate, inputEndDate);
		List<Map<String, Object>> dis = diStatisticsDao.getStatisticsData(orgType, townCode, centreCode, stationCode, inputBeginDate, inputEndDate);

		boolean isHbpNotEmpty = ObjectUtil.isNotEmpty(hbps);
		boolean isDiNotEmpty = ObjectUtil.isNotEmpty(dis);

		if (!isHbpNotEmpty && !isDiNotEmpty) {
			return Collections.emptyList();
		}

		if (isHbpNotEmpty && !isDiNotEmpty) {
			return hbps;
		}

		if (!isHbpNotEmpty && isDiNotEmpty) {
			return dis;
		}

        //合并高血压和糖尿病数据
		Map<Object, Map<String, Object>> diMap = new HashMap<>(dis.size());
		for (Map<String, Object> map : dis) {
			diMap.put(map.get("targetCode"), map);
		}

		for (Map<String, Object> hbp : hbps) {
			Object key = hbp.get("targetCode");
			Map<String, Object> di = diMap.get(key);
			if (null != di) {
				hbp.putAll(di);
			}
		}
		return hbps;
	}
}
