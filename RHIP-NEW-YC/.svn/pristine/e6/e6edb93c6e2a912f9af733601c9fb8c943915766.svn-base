package com.founder.rhip.ph.service.oh;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.service.AbstractService;
import com.founder.rhip.ehr.common.OHConstants;
import com.founder.rhip.ehr.entity.control.oh.OhChemicalsUsed;
import com.founder.rhip.ehr.entity.control.oh.OhCondition;
import com.founder.rhip.ehr.entity.control.oh.OhContactSituation;
import com.founder.rhip.ehr.entity.control.oh.OhEnterpriseInfo;
import com.founder.rhip.ehr.entity.control.oh.OhEquipment;
import com.founder.rhip.ehr.entity.control.oh.OhTestItems;
import com.founder.rhip.ehr.repository.oh.IOhChemicalsUsedDao;
import com.founder.rhip.ehr.repository.oh.IOhConditionDao;
import com.founder.rhip.ehr.repository.oh.IOhContactSituationDao;
import com.founder.rhip.ehr.repository.oh.IOhEnterpriseInfoDao;
import com.founder.rhip.ehr.repository.oh.IOhEquipmentDao;
import com.founder.rhip.ehr.repository.oh.IOhTestItemsDao;

@Service("ohEnterpriseDocService")
public class EnterpriseDocServiceImpl extends AbstractService implements
		IEnterpriseDocService {

	@Resource(name = "ohEnterpriseInfoDao")
	IOhEnterpriseInfoDao enterpriseDao;

	@Resource(name = "ohConditionDao")
	IOhConditionDao conditionDao;

	@Resource(name = "ohChemicalsUsedDao")
	IOhChemicalsUsedDao chemicalsUsedDao;

	@Resource(name = "ohContactSituationDao")
	IOhContactSituationDao contactSituationDao;

	@Resource(name = "ohEquipmentDao")
	IOhEquipmentDao equipmentDao;

	@Resource(name = "ohTestItemsDao")
	IOhTestItemsDao testItemsDao;

	@Override
	public PageList<OhEnterpriseInfo> searchEnterpriseInfoList(
			Criteria criteria, Page page) {
		return enterpriseDao.searchEnterpriseInfoList(page, criteria);
	}

	@Override
	public Boolean saveEnterpriseInfo(OhEnterpriseInfo enterpriseInfo,
			String opType) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(opType)) {
			Long id = enterpriseDao.saveEnterpriseInfo(enterpriseInfo);
			if (id != null) {
				enterpriseInfo.setId(id);
				return true;
			} else
				return false;
		} 
		//修改
		else if (OHConstants.edit.equals(opType)) {
			rs = enterpriseDao.update(enterpriseInfo);
		} 
		//删除
		else if (OHConstants.del.equals(opType)) {
			rs = enterpriseDao.update(enterpriseInfo, "updateTime", "updateBy",
					"isDelete");
		}

		return rs > 0 ? true : false;
	}

	@Override
	public OhEnterpriseInfo searchEnterpriseInfo(Criteria criteria) {
		return enterpriseDao.searchEnterpriseInfo(criteria);
	}

	@Override
	public PageList<OhCondition> searchConditionList(Criteria criteria,
			Page page) {
		return conditionDao.searchConditionList(page, criteria);
	}

	@Override
	public Boolean saveCondition(OhCondition condition, String opType) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(opType)) {
			rs = conditionDao.insert(condition);
		} else if (OHConstants.edit.equals(opType)) {
			rs = conditionDao.update(condition);
		} else if (OHConstants.del.equals(opType)) {
			rs = conditionDao.update(condition, "updateTime", "updateBy",
					"isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public OhCondition searchCondition(Criteria criteria) {
		return conditionDao.get(criteria);
	}

	@Override
	public PageList<OhChemicalsUsed> searchChemicalsUsedList(Criteria criteria,
			Page page) {
		// TODO Auto-generated method stub
		return chemicalsUsedDao.searchChemicalsUsedList(page, criteria);
	}

	@Override
	public OhChemicalsUsed searchChemicalsUsed(Criteria criteria) {
		return chemicalsUsedDao.get(criteria);
	}

	public Boolean saveChemicalsUsed(OhChemicalsUsed chemicalsUsed,
			String opType) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(opType)) {
			rs = chemicalsUsedDao.insert(chemicalsUsed);
		} else if (OHConstants.edit.equals(opType)) {
			rs = chemicalsUsedDao.update(chemicalsUsed);
		} else if (OHConstants.del.equals(opType)) {
			rs = chemicalsUsedDao.update(chemicalsUsed, "updateTime",
					"updateBy", "isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public PageList<OhContactSituation> searchContactSituationList(
			Criteria criteria, Page page) {
		return contactSituationDao.searchContactSituationList(page, criteria);
	}

	@Override
	public OhContactSituation searchContactSituation(Criteria criteria) {
		return contactSituationDao.get(criteria);
	}

	@Override
	public Boolean saveContactSituation(OhContactSituation contactSituation,
			String opType) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(opType)) {
			rs = contactSituationDao.insert(contactSituation);
		} else if (OHConstants.edit.equals(opType)) {
			rs = contactSituationDao.update(contactSituation);
		} else if (OHConstants.del.equals(opType)) {
			rs = contactSituationDao.update(contactSituation, "updateTime",
					"updateBy", "isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public PageList<OhEquipment> searchEquipmentList(Criteria criteria,
			Page page) {
		// TODO Auto-generated method stub
		return equipmentDao.searchEquipmentList(page, criteria);
	}

	@Override
	public OhEquipment searchEquipment(Criteria criteria) {
		return equipmentDao.get(criteria);
	}

	@Override
	public Boolean saveEquipment(OhEquipment equipment, String opType) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(opType)) {
			rs = equipmentDao.insert(equipment);
		} else if (OHConstants.edit.equals(opType)) {
			rs = equipmentDao.update(equipment);
		} else if (OHConstants.del.equals(opType)) {
			rs = equipmentDao.update(equipment, "updateTime", "updateBy",
					"isDelete");
		}
		return rs > 0 ? true : false;
	}

	@Override
	public PageList<OhTestItems> searchTestItemsList(Criteria criteria,
			Page page) {
		return testItemsDao.searchTestItemsList(page, criteria);
	}

	@Override
	public OhTestItems searchTestItem(Criteria criteria) {
		return testItemsDao.get(criteria);
	}

	@Override
	public Boolean saveTestItem(OhTestItems testItem, String opType) {
		int rs = 0;
		// 保存
		if (OHConstants.add.equals(opType)) {
			rs = testItemsDao.insert(testItem);
		} else if (OHConstants.edit.equals(opType)) {
			rs = testItemsDao.update(testItem);
		} else if (OHConstants.del.equals(opType)) {
			rs = testItemsDao.update(testItem, "updateTime", "updateBy",
					"isDelete");
		}
		return rs > 0 ? true : false;
	}

}
