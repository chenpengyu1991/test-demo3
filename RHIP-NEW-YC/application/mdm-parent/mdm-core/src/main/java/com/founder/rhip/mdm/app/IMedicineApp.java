package com.founder.rhip.mdm.app;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.Medicine;

import java.util.List;

public interface IMedicineApp {
	
	/**
	 * 查询药品
	 * @param medicineCode
	 * @return
	 */
	public Medicine queryMedicine(String medicineCode);
	
	/**
	 * 查询药品列表
	 * @param criteria
	 * @return
	 */
	public List<Medicine> queryMedicines(Criteria criteria);
	
	/**
	 * 注册药品
	 * @param medicine
	 * @return
	 */
	public String registMedicine(Medicine medicine) throws CheckException;
	
}
