package com.founder.rhip.ph.service.dmbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcChildInstMonitor;
import com.founder.rhip.ehr.repository.dmbc.IDmbcChildInstMonitorDao;

@Service("dmbcChildInstMonitorService")
public class ChildInstMonitorService extends AbstractService implements IChildInstMonitorService {
	
	@Resource(name = "dmbcChildInstMonitorDao")
	IDmbcChildInstMonitorDao dao;
	
	@Override
	public PageList<DmbcChildInstMonitor> getList(Criteria criteria, Page page) {
		return dao.getPageList(page, criteria, new Order("MONITOR_DATE", false));
	}
	
	@Override
	public DmbcChildInstMonitor getDetail(Long id) {
		return dao.get(id);
	}

	@Override
	@Transactional
	public void save(DmbcChildInstMonitor childInstMonitor) {
		Long id = childInstMonitor.getId();
		if (ObjectUtil.isNullOrEmpty(id)) {
			dao.generatedKey(childInstMonitor, "id", null);
		} else {
			dao.update(childInstMonitor);
		}
	}
	
	@Override
	@Transactional
	public void delete(Long id) {
		dao.delete(id);
	}

}
