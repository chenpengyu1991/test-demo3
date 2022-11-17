package com.founder.rhip.ph.service.dmbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcFlyCaught;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcFlyMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMosquitoesCaught;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMosquitoesMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMouseCaught;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcMouseMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcRoachCaught;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcRoachMonitor;
import com.founder.rhip.ehr.repository.dmbc.IDmbcFlyCaughtDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcFlyMonitorDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcMosquitoesCaughtDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcMosquitoesMonitorDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcMouseCaughtDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcMouseMonitorDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcRoachCaughtDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcRoachMonitorDao;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("dmbcVertorService")
public class VertorServiceImpl extends AbstractService implements
		IVertorService {

	@Resource(name = "dmbcMouseMonitorDao")
	IDmbcMouseMonitorDao mouseMonitorDao;

	@Resource(name = "dmbcMouseCaughtDao")
	IDmbcMouseCaughtDao mouseCaughtDao;

	@Resource(name = "dmbcMosquitoesMonitorDao")
	IDmbcMosquitoesMonitorDao mosquitoesMonitorDao;

	@Resource(name = "dmbcMosquitoesCaughtDao")
	IDmbcMosquitoesCaughtDao mosquitoesCaught;

	@Resource(name = "dmbcFlyMonitorDao")
	IDmbcFlyMonitorDao flyMonitorDao;

	@Resource(name = "dmbcFlyCaughtDao")
	IDmbcFlyCaughtDao flyCaughtDao;

	@Resource(name = "dmbcRoachMonitorDao")
	IDmbcRoachMonitorDao roachMonitorDao;

	@Resource(name = "dmbcRoachCaughtDao")
	IDmbcRoachCaughtDao roachCaughtDao;
	@Override
	public PageList<DmbcMouseMonitor> searchMouseMonitor(Criteria criteria,
			Page page) {
		return mouseMonitorDao.searchMouseMonitorList(page, criteria);
	}

	@Override
	public Boolean saveMouseMonitor(DmbcMouseMonitor mouseMonitor, String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			Number id = mouseMonitorDao.generatedKey(mouseMonitor, "id", null);
			if (id != null) {
				mouseMonitor.setId(id.longValue());
				return true;
			} else
				return false;
		}
		// 修改
		else if (OHConstants.edit.equals(type)) {
			rs = mouseMonitorDao.update(mouseMonitor);
		}
		// 删除
		else if (OHConstants.del.equals(type)) {
			mouseMonitor.setIsDelete(OHConstants.delete_1);
			rs = mouseMonitorDao.update(mouseMonitor, "updateTime", "updateBy",
					"isDelete");
		}

		return rs > 0 ? true : false;
	}

	@Override
	public DmbcMouseMonitor searchMouseMonitor(Long id) {
		return mouseMonitorDao.get(id);
	}

	@Override
	public PageList<DmbcMouseCaught> searchMouse(Page page, Criteria criteria) {
		// TODO Auto-generated method stub
		return mouseCaughtDao.searchMouseList(page, criteria);
	}

	/**
	 * 查询被捕老鼠
	 * 
	 * @param id
	 * @return DmbcMouseCaught
	 */
	public DmbcMouseCaught searchMouse(Long id) {
		return mouseCaughtDao.get(id);
	}

	@Override
	public Boolean saveMouse(DmbcMouseCaught mouse, String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			rs = mouseCaughtDao.insert(mouse);
		} else if (OHConstants.edit.equals(type)) {
			rs = mouseCaughtDao.update(mouse);
		} else if (OHConstants.del.equals(type)) {
			mouse.setIsDelete(OHConstants.delete_1);
			rs = mouseCaughtDao.update(mouse, "updateTime", "updateBy",
					"isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public PageList<DmbcMosquitoesMonitor> searchMosquitoesMonitor(
			Criteria criteria, Page page) {
		// TODO Auto-generated method stub
		return mosquitoesMonitorDao.searchMosquitoesMonitorList(page, criteria);
	}

	@Override
	public Boolean saveMosquitoesMonitor(
			DmbcMosquitoesMonitor mosquitoesMonitor, String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			Number id = mosquitoesMonitorDao.generatedKey(mosquitoesMonitor,
					"id", null);
			if (id != null) {
				mosquitoesMonitor.setId(id.longValue());
				return true;
			} else
				return false;
		}
		// 修改
		else if (OHConstants.edit.equals(type)) {
			rs = mosquitoesMonitorDao.update(mosquitoesMonitor);
		}
		// 删除
		else if (OHConstants.del.equals(type)) {
			mosquitoesMonitor.setIsDelete(OHConstants.delete_1);
			rs = mosquitoesMonitorDao.update(mosquitoesMonitor, "updateTime",
					"updateBy", "isDelete");
		}

		return rs > 0 ? true : false;
	}

	@Override
	public DmbcMosquitoesMonitor searchMosquitoesMonitor(Long id) {
		return mosquitoesMonitorDao.get(id);
	}

	@Override
	public PageList<DmbcMosquitoesCaught> searchMosquitoes(Page page,
			Criteria criteria) {
		return mosquitoesCaught.searchMosquitoesList(page, criteria);
	}

	/**
	 * 查询被捕蚊子
	 * 
	 * @param id
	 * @return DmbcMosquitoesCaught
	 */
	public DmbcMosquitoesCaught searchMosquitoes(Long id) {
		return mosquitoesCaught.get(id);
	}

	@Override
	public Boolean saveMosquitoes(DmbcMosquitoesCaught mosquitoes, String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			rs = mosquitoesCaught.insert(mosquitoes);
		} else if (OHConstants.edit.equals(type)) {
			rs = mosquitoesCaught.update(mosquitoes);
		} else if (OHConstants.del.equals(type)) {
			mosquitoes.setIsDelete(OHConstants.delete_1);
			rs = mosquitoesCaught.update(mosquitoes, "updateTime", "updateBy",
					"isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public PageList<DmbcFlyMonitor> searchFlyMonitor(Criteria criteria,
			Page page) {
		return flyMonitorDao.searchFlyMonitorList(page, criteria);
	}

	/**
	 * 苍蝇监测查询
	 * 
	 * @param id
	 * @return DmbcFlyMonitor
	 */
	public DmbcFlyMonitor searchFlyMonitor(Long id) {
		return flyMonitorDao.get(id);
	}

	@Override
	public Boolean saveFlyMonitor(DmbcFlyMonitor flyMonitor, String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			Number id = flyMonitorDao.generatedKey(flyMonitor, "id", null);
			if (id != null) {
				flyMonitor.setId(id.longValue());
				return true;
			} else
				return false;
		}
		// 修改
		else if (OHConstants.edit.equals(type)) {
			rs = flyMonitorDao.update(flyMonitor);
		}
		// 删除
		else if (OHConstants.del.equals(type)) {
			flyMonitor.setIsDelete(OHConstants.delete_1);
			rs = flyMonitorDao.update(flyMonitor, "updateTime", "updateBy",
					"isDelete");
		}

		return rs > 0 ? true : false;
	}

	@Override
	public PageList<DmbcFlyCaught> searchFly(Page page, Criteria criteria) {
		// TODO Auto-generated method stub
		return flyCaughtDao.searchFlyCaughtList(page, criteria);
	}

	@Override
	public DmbcFlyCaught searchFly(Long id) {
		return flyCaughtDao.get(id);
	}

	@Override
	public Boolean saveFly(DmbcFlyCaught fly, String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			rs = flyCaughtDao.insert(fly);
		} else if (OHConstants.edit.equals(type)) {
			rs = flyCaughtDao.update(fly);
		} else if (OHConstants.del.equals(type)) {
			fly.setIsDelete(OHConstants.delete_1);
			rs = flyCaughtDao.update(fly, "updateTime", "updateBy", "isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public PageList<DmbcRoachMonitor> searchRoachMonitor(Criteria criteria,
			Page page) {
		return roachMonitorDao.searchRoachMonitorList(page, criteria);
	}

	@Override
	public DmbcRoachMonitor searchRoachMonitor(Long id) {
		// TODO Auto-generated method stub
		return roachMonitorDao.get(id);
	}

	@Override
	public Boolean saveRoachMonitor(DmbcRoachMonitor roachMonitor, String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			Number id = roachMonitorDao.generatedKey(roachMonitor, "id", null);
			if (id != null) {
				roachMonitor.setId(id.longValue());
				return true;
			} else
				return false;
		}
		// 修改
		else if (OHConstants.edit.equals(type)) {
			rs = roachMonitorDao.update(roachMonitor);
		}
		// 删除
		else if (OHConstants.del.equals(type)) {
			roachMonitor.setIsDelete(OHConstants.delete_1);
			rs = roachMonitorDao.update(roachMonitor, "updateTime", "updateBy",
					"isDelete");
		}

		return rs > 0 ? true : false;
	}

	@Override
	public PageList<DmbcRoachCaught> searchRoach(Page page, Criteria criteria) {
		// TODO Auto-generated method stub
		return roachCaughtDao.searchRoachList(page, criteria);
	}

	@Override
	public DmbcRoachCaught searchRoach(Long id) {
		// TODO Auto-generated method stub
		return roachCaughtDao.get(id);
	}
	
	@Override
	public Boolean saveRoach(DmbcRoachCaught roach, String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			rs = roachCaughtDao.insert(roach);
		} else if (OHConstants.edit.equals(type)) {
			rs = roachCaughtDao.update(roach);
		} else if (OHConstants.del.equals(type)) {
			roach.setIsDelete(OHConstants.delete_1);
			rs = roachCaughtDao.update(roach, "updateTime", "updateBy", "isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public List<Map<String, Object>> mouseReport(String beginDate, String endDate, String townShip) {
		return mouseMonitorDao.report(beginDate, endDate, townShip);
	}

	@Override
	public List<Map<String, Object>> mosquitoesReport(String beginDate, String endDate, String townShip) {
		return mosquitoesCaught.report(beginDate, endDate, townShip);
	}

	@Override
	public List<Map<String, Object>> flyReport(String beginDate, String endDate, String townShip) {
		return flyCaughtDao.report(beginDate, endDate, townShip);
	}

	@Override
	public List<Map<String, Object>> roachReport(String beginDate, String endDate, String townShip) {
		return roachMonitorDao.report(beginDate, endDate, townShip);
	}

}
