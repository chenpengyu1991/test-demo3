package com.founder.rhip.ep.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.common.EHRConstants;
import com.founder.rhip.ehr.entity.ep.SaltMonitorRecord;
import com.founder.rhip.ehr.entity.ep.SaltSamplingRecord;
import com.founder.rhip.ehr.entity.ep.SaltTestRecord;
import com.founder.rhip.ehr.repository.ep.ISaltMonitorRecordDao;
import com.founder.rhip.ehr.repository.ep.ISaltSamplingRecordDao;
import com.founder.rhip.ehr.repository.ep.ISaltTestRecordDao;
import com.founder.rhip.mdm.app.IDictionaryApp;
import com.founder.rhip.mdm.entity.Organization;
import com.founder.rhip.mdm.service.IMergerOrganizationListener;
import com.founder.rhip.mdm.service.IMergerTownListener;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("iodateService")
public class IodateServiceImpl implements IIodateService, IMergerOrganizationListener, IMergerTownListener {

	@Resource
	private ISaltSamplingRecordDao saltSamplingRecordDao;

	@Resource
	private ISaltMonitorRecordDao saltMonitorRecordDao;

	@Resource
	private ISaltTestRecordDao saltTestRecordDao;

	@Resource
	private IDictionaryApp dictionaryApp;

	@Override
	public PageList<SaltSamplingRecord> getSamplingPageList(Page page, String year) {
		Criteria criteria = new Criteria("deleteFlag", EHRConstants.DELETE_FLG_0);
		if (StringUtil.isNotEmpty(year)) {
			criteria.add("samplingYear", year);
		}
		return saltSamplingRecordDao.getPageList(page, criteria, new Order("SAMPLING_YEAR", false).asc("POSITION").asc("GB_CODE"), "DISTINCT POSITION, GB_CODE, SAMPLING_YEAR");
	}

	@Transactional
	@Override
	public int saveSamplingRecords(List<SaltSamplingRecord> records, String year, String gbCode) throws Exception {
		if (StringUtil.isNullOrEmpty(gbCode)) {
			saltSamplingRecordDao.batchInsertWithSeq(records, "SEQ_SALT_SAMPLING_RECORD");
		} else {
			Criteria criteria = new Criteria("samplingYear", year).add("gbCode", gbCode);
			List<SaltSamplingRecord> oldRecords = saltSamplingRecordDao.getList(criteria, "id");
			try {
				deleteSamplingRecords(oldRecords);
			} catch (Exception e) {
				throw new Exception("此抽样点存在调查明细记录，无法修改");
			}
			return saltSamplingRecordDao.batchInsertWithSeq(records, "SEQ_SALT_SAMPLING_RECORD");
		}
		return 1;
	}

	@Override
	public int deleteSamplingRecords(List<SaltSamplingRecord> records) throws Exception {
		List<Long> monitorIds = new ArrayList<Long>();
		for (SaltSamplingRecord record : records) {
			monitorIds.add(record.getId());
		}
		Criteria criteria = new Criteria("samplingId", OP.IN, monitorIds);
		List<SaltMonitorRecord> monitorList = saltMonitorRecordDao.getList(criteria, "id");
		if (monitorList.size() > 0) {
			throw new Exception("此抽样点存在调查明细记录，无法删除");
		}
		//return saltSamplingRecordDao.batchUpdate(records, ServiceUtil.getDeleteProperties());
		saltSamplingRecordDao.delete(monitorIds.toArray(new Long[]{}));
		return 1;
	}

	@Override
	public SaltSamplingRecord getSamplingRecord(Criteria criteria) {
		return saltSamplingRecordDao.get(criteria);
	}

	@Override
	public List<SaltSamplingRecord> getSamplingRecords(Criteria criteria) {
		return saltSamplingRecordDao.getList(criteria);
	}

	@Override
	public List<String[]> getSamplingVillages(String year, String gbCode) {
		List<SaltSamplingRecord> records = saltSamplingRecordDao.getList(new Criteria("samplingYear", year).add("gbCode", gbCode).add("deleteFlag", EHRConstants.DELETE_FLG_0));
		List<String[]> list = new ArrayList<>();
		for (SaltSamplingRecord record : records) {
			String[] village = new String[2];
			village[0] = record.getVillageName();
			village[1] = record.getVillageCode();
			list.add(village);
		}
		return list;
	}

	@Override
	public List<String[]> getSamplingTowns(String year) {
		Criteria criteria = new Criteria("deleteFlag", EHRConstants.DELETE_FLG_0);
		if (StringUtil.isNotEmpty(year)) {
			criteria.add("samplingYear", year);
		}
		List<SaltSamplingRecord> records = saltSamplingRecordDao.getList(criteria, new Order("GB_CODE"), "DISTINCT GB_CODE");
		Map<String, String> dicMap = dictionaryApp.queryDicItemMap(new Criteria("dic_code", "FS990001").add("parent_code", EHRConstants.FS990001_ROOT));
		List<String[]> list = new ArrayList<>();
		for (SaltSamplingRecord record : records) {
			String[] town = new String[2];
			town[0] = record.getGbCode();
			town[1] = dicMap.get(town[0]);
			list.add(town);
		}
		return list;
	}

	@Override
	public PageList<SaltMonitorRecord> getMonitorPageList(Page page, Criteria criteria) {
		return saltMonitorRecordDao.getPageList(page, criteria.add("deleteFlag", EHRConstants.DELETE_FLG_0), new Order("MONITOR_TIME", false));
	}

	@Override
	public SaltMonitorRecord getMonitorRecord(Criteria criteria) {
		return saltMonitorRecordDao.get(criteria);
	}

	@Transactional
	@Override
	public int saveMonitorRecord(SaltMonitorRecord record, List<SaltTestRecord> testList) {
		int rt1, rt2;
		int rt3 = 99;
		Long id = record.getId();
		if (id == null) {
			//新建
			id = saltMonitorRecordDao.getSequenceNextVal("SEQ_SALT_MONITOR_RECORD", Long.class);
			record.setId(id);
			for (SaltTestRecord test : testList) {
				test.setMonitorId(id);
			}
			rt1 = saltMonitorRecordDao.insert(record);
			rt2 = saltTestRecordDao.batchInsert(testList);
		} else {
			//更新
			for (SaltTestRecord test : testList) {
				test.setMonitorId(id);
			}
			rt1 = saltMonitorRecordDao.update(record, ServiceUtil.getUpdateProperties(SaltMonitorRecord.class));
			rt3 = saltTestRecordDao.delete(new Criteria("monitorId", id));
			rt2 = saltTestRecordDao.batchInsert(testList);
		}
		if (rt1 != 0 && rt2 != 0 && (rt3 == 99 || rt3 != 0)) {
			return 1;
		} else {
			return 0;
		}
	}

	@Transactional
	@Override
	public int deleteMonitorRecord(SaltMonitorRecord record) {
		int rt1 = saltMonitorRecordDao.update(record, ServiceUtil.getDeleteProperties());
		Parameters parameters = new Parameters("deleteFlag", 1);
		int rt2 = saltTestRecordDao.update(parameters, new Criteria("monitorId", record.getId()));
		if (rt1 != 0 && rt2 != 0) {
			return 1;
		}else {
			return 0;
		}
	}

	@Override
	public List<SaltTestRecord> getTestRecords(Criteria criteria) {
		return saltTestRecordDao.getList(criteria);
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
		saltSamplingRecordDao.update(parameters, criteria);
		saltMonitorRecordDao.update(parameters, criteria);
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

	@Override
	public void mergeTown(String newTownCode, String[] oldTownCode) {
		Parameters parameters = new Parameters("gbCode", newTownCode);
		Criteria criteria = new Criteria("gbCode", OP.IN, oldTownCode);
		saltSamplingRecordDao.update(parameters, criteria);
	}

	@Override
	public void sendTownVillageRelation(String townCode,
			String[] newAddVillageCodes) {
		Parameters parameters = new Parameters("gbCode", townCode);
		Criteria criteria = new Criteria("villageCode", OP.IN, newAddVillageCodes);
		saltSamplingRecordDao.update(parameters, criteria);
	}
}
