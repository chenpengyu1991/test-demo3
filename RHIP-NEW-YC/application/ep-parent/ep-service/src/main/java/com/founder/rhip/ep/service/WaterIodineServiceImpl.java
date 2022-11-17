package com.founder.rhip.ep.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.ep.WaterIodineMonitor;
import com.founder.rhip.ehr.repository.ep.IWaterIodineMonitorDao;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;

@Service("waterIodineService")
public class WaterIodineServiceImpl implements IWaterIodineService, IMergerOrganizationListener {
	
	@Resource
	private IWaterIodineMonitorDao waterIodineMonitorDao;

	@Override
	public PageList<WaterIodineMonitor> getPageList(Page page, Criteria criteria) {
		return waterIodineMonitorDao.getPageList(page, criteria, new Order("INVESTIGATE_TIME", false).asc("MONITOR_ID"));
	}

	@Override
	public WaterIodineMonitor getDetail(Long id) {
		return waterIodineMonitorDao.get(id);
	}

	@Override
	@Transactional
	public void save(WaterIodineMonitor monitor) {
		Long id = monitor.getId();
		if (ObjectUtil.isNullOrEmpty(id)) {
			waterIodineMonitorDao.insertWithSeq(monitor, "SEQ_WATER_IODINE_MONITOR");
		} else {
			waterIodineMonitorDao.update(monitor, ServiceUtil.getUpdateProperties(WaterIodineMonitor.class));
		}
	}

	@Override
	@Transactional
	public void delete(WaterIodineMonitor monitor) {
		waterIodineMonitorDao.update(monitor, ServiceUtil.getDeleteProperties());
	}

	@Override
	public WaterIodineMonitor getDetail(Criteria criteria) {
		WaterIodineMonitor monitor = waterIodineMonitorDao.get(criteria);
		return monitor;
	}
	
	/**
	 * 删除水碘监测记录
	 * @param id
	 */
	@Transactional
	public void delete(Long id) {
		waterIodineMonitorDao.delete(id);
	}
	
	@Override
	public void mergeStation(Organization station,
			List<Organization> stationList) {
		;
	}

	@Override
	@Transactional
	public void mergeCenter(Organization center, List<Organization> centerList) {
		Parameters parameters = new Parameters("createOrgan", center.getOrganCode());
		List<String> codes = new ArrayList<String>();
		for (Organization organ : centerList) {
			codes.add(organ.getOrganCode());
		}
		Criteria criteria = new Criteria("createOrgan", OP.IN, codes);
		waterIodineMonitorDao.update(parameters, criteria);
	}

	@Override
	public void moveStation(Organization center, List<Organization> stationList) {
		;
	}

	@Override
	public void changeRelationOrgVillage(String orgCode,
			String[] newAddVillageCodes) {
		;
	}
}
