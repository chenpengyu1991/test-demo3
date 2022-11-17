package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.*;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Medicine;
import com.founder.rhip.mdm.repository.IMedicineDao;
import com.founder.rhip.mdm.service.IMedicineService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("mdmMedicineService")
public class MedicineService extends MDMService implements IMedicineService {

	//@Resource(name="mdmMedicineMapDao")
	//private IMedicineMapDao medicineMapDao;
	
	@Resource(name="mdmMedicineDao")
	private IMedicineDao medicineDao;
	
	/**
	 * 查询标准药品列表
	 */
	@Override
	public PageList<Medicine> getMedicines(Page page, Criteria criteria) {
		PageList<Medicine> medicines = medicineDao.getPageList(page, criteria, getOrder());
		return medicines;
	}
	
	/**
	 * 查询标准药品列表,使用缓存
	 */
	@Override
	public List<Medicine> queryMedicinesUseCache(Criteria criteria) {
		String key = criteriaToKey(criteria);
		@SuppressWarnings("unchecked")
		List<Medicine> retList = (List<Medicine>) getCache(EntityType.MEDICINE, key);
		if (retList == null) {
			retList = queryMedicines(criteria);
			if (retList != null && retList.size() > 0) {
				setCache(EntityType.DICTIONARY, key, retList);
			}
		}
		return retList;
	}
	
	/**
	 * 查询标准药品列表
	 */
	@Override
	public List<Medicine> queryMedicines(Criteria criteria) {
		List<Medicine> medicines = medicineDao.getList(criteria, getOrder());
		return medicines;
	}
	
	private Order getOrder() {
		Order order = new Order("CATEGORY_NAME_ONE");
		order.asc("CATEGORY_NAME_TWO");
		order.asc("CATEGORY_NAME_THREE");
		order.asc("MEDICINE_CODE");
		return order;
	}
	
	/**
	 * 查询标准药品
	 */
	@Override
	public Medicine getMedicine(String medicineCode) {
		Criteria criteria = new Criteria(Medicine.MEDICINE_CODE, medicineCode);
		return getMedicine(criteria);
	}
	
	/**
	 * 查询标准药品
	 */
	@Override
	public Medicine getMedicine(Criteria criteria) {
		Medicine medicine = medicineDao.get(criteria);
		return medicine;
	}
	
	/**
	 * 查询标准药品修改历史
	 */
	@Override
	public PageList<Medicine> getMedicineLogs(Page page, String medicineCode) {
		PageList<Medicine> medicines = medicineDao.getLogList(page, medicineCode);
		return medicines;
	}
	
	/**
	 * 查询标准药品修改历史
	 */
	@Override
	public Medicine getMedicineLog(Criteria criteria) {
		return medicineDao.getLog(criteria);
	}
	
	/**
	 * 查询一级分类目录
	 */
	@Override
	public List<String> getCategoryOneDict(String categoryName) {
		return medicineDao.getCategoryOneDict(categoryName);
	}
	
	/**
	 * 查询二级分类目录
	 * @param categoryOne
	 * @return
	 */
	public List<String> getCategoryTwoDict(String categoryOne, String categoryName) {
		return medicineDao.getCategoryTwoDict(categoryOne, categoryName);
	}
	
	/**
	 * 查询三级分类目录
	 * @param categoryTwo
	 * @return
	 */
	public List<String> getCategoryThreeDict(String categoryTwo, String categoryName) {
		return medicineDao.getCategoryThreeDict(categoryTwo, categoryName);
	}
	
	/**
	 * 查询药物剂型目录
	 * @return
	 */
	public List<String> getDosageDict(String name) {
		return medicineDao.getDosageDict(name);
	}
	
	/**
	 * 废止/启用 药品
	 */
	@Transactional
	@Override
	public void changeStatus(Medicine medicine) {
		String medicineCode = medicine.getMedicineCode();
		Medicine dbMedicine = medicineDao.get(medicineCode);
		dbMedicine.setStatus(medicine.getStatus());
		dbMedicine.setOperator(medicine.getOperator());
		dbMedicine.setOperateTime(medicine.getOperateTime());
		dbMedicine.setOperateType(medicine.getOperateType());
		
		Criteria criteria = new Criteria(Medicine.MEDICINE_CODE, medicineCode);
		medicineDao.insertLog(criteria);
		medicineDao.update(dbMedicine);
		
		removeCache(EntityType.MEDICINE, medicineCode);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int importMedicines(List<Record> medicineList) {
		List<Record> insertMedicineList = new ArrayList<Record>();
		List<Record> updateMedicineList = new ArrayList<Record>();
		List<String> updateMedicineCodes = new ArrayList<String>();
		Long version = medicineDao.getMedicineVersion();
		for (Record record : medicineList) {
			record.set(Medicine.VERSION, version);
			String medicineCode = record.getAsString(Medicine.MEDICINE_CODE);
			Medicine medicine = medicineDao.get(medicineCode);
			if (medicine == null) {
				insertMedicineList.add(record);
			} else {
				updateMedicineCodes.add(medicineCode);
				updateMedicineList.add(record);
			}
		}
		
		List<List> logList = getInsertLogs(updateMedicineCodes);
		for (List ids : logList) {
			Criteria criteria = new Criteria(Medicine.MEDICINE_CODE, OP.IN, ids);
			medicineDao.insertLog(criteria);
			ids.clear();
			ids = null;
		}
		logList.clear();
		logList = null;
		updateMedicineCodes.clear();
		updateMedicineCodes = null;
		
		String[] properties = medicineList.get(0).keySet().toArray(new String[]{});
		medicineDao.batchMapInsert(insertMedicineList, properties);
		medicineDao.batchMapUpdate(updateMedicineList, properties);
		insertMedicineList.clear();
		insertMedicineList = null;
		updateMedicineList.clear();
		updateMedicineList = null;
		removeCache(EntityType.MEDICINE);
		return medicineList.size();
	}

	@Override
	public List<String> baseMedValidation(List<String> medicines) {
		Criteria criteria = new Criteria("medicineCode", OP.IN, medicines);
		List<Medicine> meds = medicineDao.getList(criteria);
		if (ObjectUtil.isNotEmpty(meds)) {
			for (Medicine med : meds) {
				String code = med.getMedicineCode();
				if (medicines.contains(code)) {
					medicines.remove(code);
				}
			}
		}
		return medicines;
	}

	/**
	 * 创建标准药品
	 */
	@Transactional
	@Override
	public void createMedicine(Medicine medicine) {
		Long version = medicineDao.getMedicineVersion();
		medicine.setVersion(version);
		medicineDao.insert(medicine);
		removeCache(EntityType.MEDICINE);
	}

	/**
	 * 更新标准药品
	 */
	@Transactional
	@Override
	public void updateMedicine(Medicine medicine) {
		Criteria criteria = new Criteria(Medicine.MEDICINE_CODE, medicine.getMedicineCode());
		medicineDao.insertLog(criteria);
		Long version = medicineDao.getMedicineVersion();
		medicine.setVersion(version);
		medicineDao.update(medicine);
		removeCache(EntityType.MEDICINE);
	}

	/**
	 * 删除标准药品
	 */
	@Transactional
	@Override
	public void deleteMedicine(String medicineCode) {
		Criteria criteria = new Criteria(Medicine.MEDICINE_CODE, medicineCode);
		medicineDao.deleteLog(criteria);
		medicineDao.delete(medicineCode);
		removeCache(EntityType.MEDICINE);
	}
	
	/**
	 * 查询当前版本
	 */
	@Override
	public Long getCurrentVersion() {
		return medicineDao.getMedicineVersion();
	}
	
	/**
	 * 发布标准药品新版本
	 */
	@Transactional
	@Override
	public Long publishMedicineVersion() {
		medicineDao.publishMedicineVersion();
		return medicineDao.getMedicineVersion();
	}

}
