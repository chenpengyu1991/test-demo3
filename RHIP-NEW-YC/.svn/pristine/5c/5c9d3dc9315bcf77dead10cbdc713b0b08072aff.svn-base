package com.founder.rhip.mdm.repository;

import java.util.List;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Disease;

public interface IDiseaseDao extends IDao<Disease, Long> {
	
	public PageList<Disease> getLogList(Page page, Long diseaseId, String... properties);
	
	public void insertLog(Criteria criteria);
	
	public void deleteLog(Criteria criteria);
	
	public void publishDiseaseVersion();

	public Long getDiseaseVersion();

	List<Disease> getDiseasesByCategoryRange(String startCategory, String endCategory);
	
}
