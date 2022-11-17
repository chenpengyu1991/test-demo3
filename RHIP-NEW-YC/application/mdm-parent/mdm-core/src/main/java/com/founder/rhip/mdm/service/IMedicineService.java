package com.founder.rhip.mdm.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Record;
import com.founder.rhip.mdm.entity.Medicine;

import java.util.List;

public interface IMedicineService {
	
	/**
	 * 查询标准药品列表
	 * @param page
	 * @param criteria
	 * @return
	 */
	public PageList<Medicine> getMedicines(Page page, Criteria criteria);
	
	/**
	 * 查询标准药品列表
	 * @param criteria
	 * @return
	 */
	public List<Medicine> queryMedicines(Criteria criteria);
	
	/**
	 * 查询标准药品列表,使用缓存
	 * @param criteria
	 * @return
	 */
	public List<Medicine> queryMedicinesUseCache(Criteria criteria);
	
	/**
	 * 查询标准药品
	 * @param medicineCode
	 * @return
	 */
	public Medicine getMedicine(String medicineCode);
	
	/**
	 * 查询标准药品
	 * @param criteria
	 * @return
	 */
	public Medicine getMedicine(Criteria criteria);
	
	/**
	 * 查询标准药品修改历史
	 * @param medicineCode
	 * @return
	 */
	public PageList<Medicine> getMedicineLogs(Page page, String medicineCode);
	
	/**
	 * 查询药品修改历史记录
	 * @param criteria
	 * @return
	 */
	public Medicine getMedicineLog(Criteria criteria);
	
	/**
	 * 查询一级分类目录
	 * @return
	 */
	public List<String> getCategoryOneDict(String categoryName);
	
	/**
	 * 查询二级分类目录
	 * @param categoryOne
	 * @return
	 */
	public List<String> getCategoryTwoDict(String categoryOne, String categoryName);
	
	/**
	 * 查询三级分类目录
	 * @param categoryTwo
	 * @return
	 */
	public List<String> getCategoryThreeDict(String categoryTwo, String categoryName);
	
	/**
	 * 查询药物剂型目录
	 * @return
	 */
	public List<String> getDosageDict(String name);
	
	/**
	 * 废止/启用 药品
	 * @param medicineCode
	 * @param oldStatus
	 */
	public void changeStatus(Medicine medicine);
	
	/**
	 * 创建标准药品
	 * @param medicine
	 */
	public void createMedicine(Medicine medicine);
	
	/**
	 * 更新标准药品
	 * @param medicine
	 */
	public void updateMedicine(Medicine medicine);
	
	/**
	 * 删除标准药品
	 * @param medicineCode
	 */
	public void deleteMedicine(String medicineCode);
	
	/**
	 * 查询当前版本
	 * @return
	 */
	public Long getCurrentVersion();
	
	/**
	 * 发布标准药品新版本
	 * @return 新版本号
	 */
	public Long publishMedicineVersion();

	/**
	 * 批量导入药物
	 * @param medicineList
	 * @return
	 */
	public int importMedicines(List<Record> medicineList);

	/**
	 * 基药验证
	 * @param medicines
	 * @return
	 */
	public List<String> baseMedValidation(List<String> medicines);
}
