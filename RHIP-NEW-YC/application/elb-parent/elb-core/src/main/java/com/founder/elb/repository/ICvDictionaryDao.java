package com.founder.elb.repository;

import java.util.List;
import java.util.Map;

import com.founder.elb.entity.CvDictionary;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of CvDictionary
 * 
 */
public interface ICvDictionaryDao extends IDao<CvDictionary,Long> {

	PageList<Map<String, Object>> getDictionaries(Page page,String sql, Criteria criteria);
	List<CvDictionary> getDictionary(String code,String clinicId);

}