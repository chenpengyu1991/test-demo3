package com.founder.rhip.mdm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.entity.ExplorerSet;
import com.founder.rhip.mdm.repository.IExplorerSetDao;

@Service("explorerSetService")
public class ExplorerSetServiceImpl extends AbstractService implements IExplorerSetService {

	@Resource(name = "explorerSetDao")
	private IExplorerSetDao explorerSetDao;
	
	@Override
	public Boolean saveSetResult(String setRet) {
		if (ObjectUtil.isNullOrEmpty(setRet)) {
			return false;
		}
		String[] destDoctorSetRets = StringUtils.split(setRet, "~");
		try {
			for (String doctorSetRet : destDoctorSetRets) {
				String doctorType = null;
				String setTypeStrs = null;
				if (ObjectUtil.isNullOrEmpty(doctorSetRet) || !StringUtils.contains(doctorSetRet, ":")
						|| ObjectUtil.isNullOrEmpty(doctorType = StringUtils.substringBefore(doctorSetRet, ":"))
						|| ObjectUtil.isNullOrEmpty(setTypeStrs = StringUtils.substringAfter(doctorSetRet, ":"))) {
					continue;
				}
				String[] setTypes = StringUtils.split(setTypeStrs, ",");
				if (ObjectUtil.isNotEmpty(setTypes)) {
					// 先删除表里面保存的设置
					explorerSetDao.delete(new Criteria("doctorType", doctorType));
					List<ExplorerSet> list = new ArrayList<ExplorerSet>();
					for (String setType : setTypes) {
						ExplorerSet explorerSet = new ExplorerSet();
						explorerSet.setDoctorType(doctorType);
						explorerSet.setSetType(setType);
						list.add(explorerSet);
					}
					explorerSetDao.batchInsert(list);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return false;
		}
		return true;
	}

	@Override
	public Map<String,List<String>> getExplorerSetMap(Criteria criteria) {
		List<Map<String, Object>> mapList = explorerSetDao.getMapList(criteria);
		Map<String, List<String>> destMap = new HashMap<String, List<String>>();
		if (ObjectUtil.isNotEmpty(mapList)) {
			for (Map<String, Object> map : mapList) {
				Object key = null;
				Object value = null;
				if (ObjectUtil.isNullOrEmpty(key = map.get("DOCTOR_TYPE"))
						|| ObjectUtil.isNullOrEmpty(value = map.get("SET_TYPE"))) {
					continue;
				}
				if (ObjectUtil.isNullOrEmpty(destMap.get(key))) {
					List<String> list = new ArrayList<String>();
					list.add(String.valueOf(value));
					destMap.put(String.valueOf(key), list);
				} else {
					destMap.get(key).add(String.valueOf(value));
				}
			}
		}
		return destMap;
	}

}
