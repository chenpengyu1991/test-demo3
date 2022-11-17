package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Medicine;

import java.util.List;

public interface IMedicineDao extends IDao<Medicine,String> {
	
	public PageList<Medicine> getLogList(Page page, String medicineCode, String... properties);
	
	public Medicine getLog(Criteria criteria);
	
	public void insertLog(Criteria criteria);
	
	public void deleteLog(Criteria criteria);
	
	public void publishMedicineVersion();

	public Long getMedicineVersion();
	
	public List<String> getCategoryOneDict(String categoryName);
	
	public List<String> getCategoryTwoDict(String categoryOne, String categoryName);
	
	public List<String> getCategoryThreeDict(String categoryTwo, String categoryName);
	
	public List<String> getDosageDict(String name);

	
}
