package com.founder.rhip.ehr.service.statistics.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.rhip.ehr.repository.statistics.ICdmsStatisticsDao;
import com.founder.rhip.ehr.service.statistics.IPublicHealthDmStatisticsService;
@Service("publicHealthDmStatisticsService")
public class PublicHealthDmStatisticsServiceImpl implements IPublicHealthDmStatisticsService{
	@Resource
	private ICdmsStatisticsDao cdmsStatisticsDao;

	@Override
	public Map<String, Long> getHBPCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getHBPCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getNewHBPCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getNewHBPCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getCuredHBPCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getCuredHBPCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getDITypeTwoCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getDITypeTwoCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getNewDITypeTwoCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getNewDITypeTwoCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getCuredDITypeTwoCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getCuredDITypeTwoCount(houseHoldType));
	}
	
   private Map<String, Long> createMap(List<Map<String, Object>> list){
	   Map<String, Long> map = new HashMap<>();
		for(Map<String, Object> map1:list){
			map.put(getString(map1,"ORGAN_CODE"), getLong(map1,"COUNT"));
		}
		return map;
   }
   
   private Long getLong(Map<String, Object> map, String key) {
		Object val = map.get(key);
		if (null == val) {
			return 0L;
		}
		return Long.parseLong(val.toString());
	}

	private String getString(Map<String, Object> map, String key) {
		Object val = map.get(key);
		if (null == val) {
			return "";
		}
		return val.toString();
	}

	@Override
	public Map<String, Long> getTownHBPCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getTownHBPCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getTownNewHBPCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getTownNewHBPCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getTownCuredHBPCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getTownCuredHBPCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getTownDITypeTwoCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getTownDITypeTwoCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getTownNewDITypeTwoCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getTownNewDITypeTwoCount(houseHoldType));
	}

	@Override
	public Map<String, Long> getTownCuredDITypeTwoCount(String houseHoldType) {
		return createMap(cdmsStatisticsDao.getTownCuredDITypeTwoCount(houseHoldType));
	}
}
