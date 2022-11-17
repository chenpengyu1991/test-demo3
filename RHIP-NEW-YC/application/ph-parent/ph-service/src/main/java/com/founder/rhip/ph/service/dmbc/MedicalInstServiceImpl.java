package com.founder.rhip.ph.service.dmbc;

import javax.annotation.Resource;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.repository.dmbc.IDmbcInfectDetailDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcInfectMonitorDao;
import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcDisinfectionMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcDisinfectionResult;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcInfectDetail;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcInfectMonitor;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcSewageTreatment;
import com.founder.rhip.ehr.entity.control.dmbc.DmbcTreatmentRecord;
import com.founder.rhip.ehr.repository.dmbc.IDmbcDisinfectionMonitorDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcDisinfectionResultDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcSewageTreatmentDao;
import com.founder.rhip.ehr.repository.dmbc.IDmbcTreatmentRecordDao;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service("dmbcMedicalInstService")
public class MedicalInstServiceImpl extends AbstractService implements
		IMedicalInstService {

	@Resource(name = "dmbcSewageTreatmentDao")
	IDmbcSewageTreatmentDao sewageTreatmentDao;

	@Resource(name = "dmbcTreatmentRecordDao")
	IDmbcTreatmentRecordDao treatmentDao;
	
	@Resource(name = "dmbcDisinfectionMonitorDao")
	IDmbcDisinfectionMonitorDao disinfectionMonitorDao;
	
	@Resource(name="dmbcDisinfectionResultDao")
	IDmbcDisinfectionResultDao disinfectionResultDao;

	@Resource(name = "dmbcInfectMonitorDao")
	IDmbcInfectMonitorDao infectMonitorDao;

	@Resource(name = "dmbcInfectDetailDao")
	IDmbcInfectDetailDao infectDetailDao;
	
	@Override
	public PageList<DmbcSewageTreatment> searchSewageTreatment(Criteria criteria,
			Page page) {
		// TODO Auto-generated method stub
		return sewageTreatmentDao.searchSewageTreatment(criteria, page);
	}

	@Override
	public DmbcSewageTreatment searchSewageTreatment(Long id) {
		// TODO Auto-generated method stub
		return sewageTreatmentDao.get(id);
	}

	@Override
	public Boolean saveSewageTreatment(DmbcSewageTreatment sewageTreatment,
			String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			Number id = sewageTreatmentDao.generatedKey(sewageTreatment, "id", null);
			if (id != null) {
				sewageTreatment.setId(id.longValue());
				return true;
			} else
				return false;
		}
		// 修改
		else if (OHConstants.edit.equals(type)) {
			rs = sewageTreatmentDao.update(sewageTreatment);
		}
		// 删除
		else if (OHConstants.del.equals(type)) {
			sewageTreatment.setIsDelete(OHConstants.delete_1);
			rs = sewageTreatmentDao.update(sewageTreatment, "updateTime", "updateBy",
					"isDelete");
		}

		return rs > 0 ? true : false;
	}

	@Override
	public PageList<DmbcTreatmentRecord> searchTreatmentRecord(Page page,
			Criteria criteria) {
		// TODO Auto-generated method stub
		return treatmentDao.searchTreatmentRecord(page, criteria);
	}

	@Override
	public DmbcTreatmentRecord searchTreatmentRecord(Long id) {
		// TODO Auto-generated method stub
		return treatmentDao.get(id);
	}

	@Override
	public Boolean saveTreatmentRecord(DmbcTreatmentRecord treatmentRecord,
			String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			rs = treatmentDao.insert(treatmentRecord);
		} else if (OHConstants.edit.equals(type)) {
			rs = treatmentDao.update(treatmentRecord);
		} else if (OHConstants.del.equals(type)) {
			treatmentRecord.setIsDelete(OHConstants.delete_1);
			rs = treatmentDao.update(treatmentRecord, "updateTime", "updateBy",
					"isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public PageList<DmbcDisinfectionMonitor> searchDisinfectionMonitor(
			Criteria criteria,Page page) {
		// TODO Auto-generated method stub
		return disinfectionMonitorDao.searchDisinfectionMonitor(criteria, page);
	}

	@Override
	public DmbcDisinfectionMonitor searchDisinfectionMonitor(
			Long id) {
		// TODO Auto-generated method stub
		return disinfectionMonitorDao.get(id);
	}
	
	@Override
	public Boolean saveDisinfectionMonitor(
			DmbcDisinfectionMonitor disinfectionMonitor,String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			Number id = disinfectionMonitorDao.generatedKey(disinfectionMonitor, "id", null);
			if (id != null) {
				disinfectionMonitor.setId(id.longValue());
				return true;
			} else
				return false;
		}
		// 修改
		else if (OHConstants.edit.equals(type)) {
			rs = disinfectionMonitorDao.update(disinfectionMonitor);
		}
		// 删除
		else if (OHConstants.del.equals(type)) {
			disinfectionMonitor.setIsDelete(OHConstants.delete_1);
			rs = disinfectionMonitorDao.update(disinfectionMonitor, "updateTime", "updateBy",
					"isDelete");
		}

		return rs > 0 ? true : false;
	}

	@Override
	public PageList<DmbcDisinfectionResult> searchDisinfectionResult(
			Criteria criteria,Page page) {
		// TODO Auto-generated method stub
		return disinfectionResultDao.searchDisinfectionMonitor(criteria, page);
	}

	@Override
	public DmbcDisinfectionResult searchDisinfectionResult(
			Long id) {
		// TODO Auto-generated method stub
		return disinfectionResultDao.get(id);
	}
	
	@Override
	public Boolean saveDisinfectionResult(
			DmbcDisinfectionResult disinfectionResult,String type) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(type)) {
			rs = disinfectionResultDao.insert(disinfectionResult);
		} else if (OHConstants.edit.equals(type)) {
			rs = disinfectionResultDao.update(disinfectionResult);
		} else if (OHConstants.del.equals(type)) {
			disinfectionResult.setIsDelete(OHConstants.delete_1);
			rs = disinfectionResultDao.update(disinfectionResult, "updateTime", "updateBy",
					"isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public PageList<DmbcInfectMonitor> searchInfectMonitor(Page page, Criteria criteria) {
		return infectMonitorDao.getPageList(page, criteria);
	}

	@Override
	public Boolean saveInfectMonitor(DmbcInfectMonitor monitor) {
		String[] properties = getNotContainsProperties(DmbcInfectMonitor.class, "spotCheckNum", "total");
		int rt;
		monitor.setIsDelete(EHRConstants.DELETE_FLG_0);
		if (monitor.getId() == null) {
			Number id = infectMonitorDao.generatedKey(monitor, "id", null);
			if (id != null) {
				monitor.setId(id.longValue());
				return true;
			} else {
				return false;
			}
		} else {
			rt = infectMonitorDao.update(monitor, properties);
		}
		return rt == 0 ? false : true;
	}

	@Transactional
	@Override
	public Boolean deleteInfectMonitor(DmbcInfectMonitor monitor) {
		monitor.setIsDelete(EHRConstants.DELETE_FLG_1);
		int rt1 = infectMonitorDao.update(monitor, "updateTime", "updateBy", "isDelete");
		Parameters parameters = new Parameters();
		parameters.add("isDelete", EHRConstants.DELETE_FLG_1).add("updateTime", monitor.getUpdateTime()).add("updateBy", monitor.getUpdateBy());
		infectDetailDao.update(parameters, new Criteria("monitorId", monitor.getId()));
		return rt1 != 0 ? true : false;
	}

	@Override
	public DmbcInfectMonitor getInfectMonitor(Criteria criteria) {
		return infectMonitorDao.get(criteria);
	}

	@Override
	public PageList<DmbcInfectDetail> searchInfectDetail(Page page, Criteria criteria) {
		return infectDetailDao.getPageList(page, criteria);
	}

	@Transactional
	@Override
	public Boolean saveInfectDetail(DmbcInfectDetail detail) {
		detail.setIsDelete(EHRConstants.DELETE_FLG_0);
		Long monitorId = detail.getMonitorId();
		int rt;
		if (detail.getId() == null) {
			rt = infectDetailDao.insert(detail);
		} else {
			rt = infectDetailDao.update(detail);
		}
		updateInfectMonitorStatistics(monitorId);
		return rt == 0 ? false : true;
	}

	@Override
	@Transactional
	public Boolean deleteInfectDetail(DmbcInfectDetail detail) {
		detail.setIsDelete(EHRConstants.DELETE_FLG_1);
		int rt = infectDetailDao.update(detail, "updateTime", "updateBy", "isDelete");
		updateInfectMonitorStatistics(detail.getMonitorId());
		return rt == 0 ? false : true;
	}

	@Override
	public DmbcInfectDetail getInfectDetail(Criteria criteria) {
		return infectDetailDao.get(criteria);
	}
	
	private long getLongValue(Map<String, Object> map, String key) {
		long cnt =0;
		if (map != null) {
			Object cntStr = map.get(key);
			if (cntStr != null) {
				cnt=Long.parseLong(cntStr.toString());
			}
		}
		return cnt;
	}

	private void updateInfectMonitorStatistics(Long monitorId) {
		Map<String, Object> map = infectDetailDao.getMap(new Criteria("monitorId", monitorId).add("isDelete", 0), "SUM(SPOT_CHECK_NUM) SPOT_CHECK_NUM, SUM(TOTAL) TOTAL");
		DmbcInfectMonitor monitor = new DmbcInfectMonitor();
		monitor.setId(monitorId);
		monitor.setSpotCheckNum(getLongValue(map, "SPOT_CHECK_NUM"));
		monitor.setTotal(getLongValue(map, "TOTAL"));
		infectMonitorDao.update(monitor, "spotCheckNum", "total");
	}

	public String[] getNotContainsProperties(Class<?> cls, String... notContains) {
		List<String> properties = new ArrayList<>();
		ClassMetadata cMetadata = ClassMetadata.getMetadata(cls);
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		Set<String> keyset = pMetadata.keySet();
		List<String> notContainsList = Arrays.asList(notContains);
		for (String key : keyset) {
			if (!notContainsList.contains(key)) {
				PropertyMetadata metadata = pMetadata.get(key);
				if (metadata.isDbField()) {
					properties.add(key);
				}
			}
		}
		//properties.remove("serialVersionUID");
		return properties.toArray(new String[]{});
	}

}
