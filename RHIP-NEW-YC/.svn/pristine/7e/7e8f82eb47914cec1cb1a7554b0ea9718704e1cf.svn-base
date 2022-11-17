package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Record;
import com.founder.rhip.mdm.common.OperateType;
import com.founder.rhip.mdm.common.StatusValue;
import com.founder.rhip.mdm.entity.EntityType;
import com.founder.rhip.mdm.entity.Medicine;
import com.founder.rhip.mdm.service.IMedicineService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("medicineApp")
public class MedicineApp extends MDMBaseApp implements IMedicineApp {
	
	@Resource(name="mdmMedicineService")
	private IMedicineService medicineService;
	
	@Resource
	private IDictionaryApp dictionaryApp;

	@Override
	public Medicine queryMedicine(String medicineCode) {
		Criteria criteria = new Criteria(Medicine.MEDICINE_CODE, medicineCode);
		List<Medicine> medicines = queryMedicines(criteria);
		if (medicines == null || medicines.size() == 0) {
			return null;
		}
		return medicines.get(0);
	}
	
	@Override
	public List<Medicine> queryMedicines(Criteria criteria) {
		setStatusToCriteria(criteria);
		List<Medicine> medicines = medicineService.queryMedicinesUseCache(criteria);
		return medicines;
	}

	@Override
	public String registMedicine(Medicine medicine) throws CheckException {
		medicine.setOperateTime(getOperatorTime());
		medicine.setOperateType(OperateType.regist.getName());
		List<String> messageList = new ArrayList<String>();
		checkAll(messageList, new Record(medicine), EntityType.MEDICINE);
		if (messageList.size() > 0) {
			CheckException exception = getCheckException(messageList);
			throw exception;
		}
		String medicineCode = medicine.getMedicineCode();
		Medicine dbMedicine = medicineService.getMedicine(medicineCode);
		if (dbMedicine == null) {
			medicineService.createMedicine(medicine);
		} else {
			medicineService.updateMedicine(medicine);
		}
		return medicineCode;
	}
	
	public Map<String, String> getDictionary(String dictKey) {
		Map<String, String> dictMap = dictionaryApp.queryDicItemMap(dictKey);
		return dictMap;
	}
	
	private Criteria setStatusToCriteria(Criteria criteria) {
		if (criteria == null) {
			return criteria;
		}
		if (!criteria.contains(Medicine.STATUS)) {
			criteria.add(Medicine.STATUS, StatusValue.normalValue.getValue());
		}
		return criteria;
	}

}
