package com.founder.rhip.cdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.management.DmPopulaceInfo;
import com.founder.rhip.ehr.repository.management.IDmPopulaceInfoDao;
import com.founder.rhip.mdm.entity.DicItem;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PopulaceInfoServiceImpl extends AbstractService implements IPopulaceInfoService {

	@Resource
	private IDmPopulaceInfoDao dmPopulaceInfoDao;

	@Override
	public List<DmPopulaceInfo> searchPopulaceInfo() {
		Criteria criteria = new Criteria();
		List<DmPopulaceInfo> populaceInfoList = dmPopulaceInfoDao.getList(criteria);
		return populaceInfoList;
	}

	@Override
	public List<DmPopulaceInfo> buildPopulaceInfo(Integer countYear, List<DicItem> items) {
		Criteria ca = new Criteria("countYear", countYear);
		List<DmPopulaceInfo> populaceInfoList = dmPopulaceInfoDao.getList(ca);
		if (ObjectUtil.isNotEmpty(populaceInfoList)) {
			return populaceInfoList;
		}
		List<DmPopulaceInfo> populaceInfo = new ArrayList<DmPopulaceInfo>();
		for (int i = 0; i < items.size(); i++) {
			DmPopulaceInfo dmPopulaceInfo = new DmPopulaceInfo();
			dmPopulaceInfo.setManNum(0);
			dmPopulaceInfo.setWomanNum(0);
			dmPopulaceInfo.setTotalNum(0);
			dmPopulaceInfo.setOrganCode(items.get(i).getItemCode());
			dmPopulaceInfo.setOrganName(items.get(i).getItemName());
			dmPopulaceInfo.setCountYear(countYear);
			populaceInfo.add(dmPopulaceInfo);
		}
		dmPopulaceInfoDao.batchInsert(populaceInfo);
		List<DmPopulaceInfo> dpiList = dmPopulaceInfoDao.getList(ca);
		return dpiList;
	}

	@Override
	public boolean saveOrUpdatePopulaceInfo(List<DmPopulaceInfo> dmPopulaceInfo) {
		if (dmPopulaceInfo != null && dmPopulaceInfo.size() > 0) {
			dmPopulaceInfoDao.batchUpdate(dmPopulaceInfo);
			return true;
		}
		return false;
	}

	@Override
	public DmPopulaceInfo getTotalCountByYear(String year) {
		Criteria criteria = new Criteria("countYear", year);
		DmPopulaceInfo dmPopulaceInfo = dmPopulaceInfoDao.getTotalCount(criteria);
		if (ObjectUtil.isNullOrEmpty(dmPopulaceInfo)) {
			dmPopulaceInfo = new DmPopulaceInfo();
		}
		return dmPopulaceInfo;

	}
}
