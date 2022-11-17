package com.founder.elb.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.founder.elb.entity.CvDictionary;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.StringUtil;

/**
 * DAO implement of User
 * 
 */
@Repository("cvDictionaryDao")
public class CvDictionaryDaoImpl extends AbstractDao<CvDictionary, Long> implements ICvDictionaryDao
{

	@Override
	public PageList<Map<String, Object>> getDictionaries(Page page, String sql,Criteria criteria) {
		
		return getPageMapList(page, sql, criteria);
	}

	@Override
	public List<CvDictionary> getDictionary(String code, String clinicId) {
		StringBuilder sql = new StringBuilder();
		sql.append("select cv_dicmeta_code,code,d_code,name,py_code from CV_DICTIONARY where cv_dicmeta_code='");
		sql.append(code + "' ");
		
		if(StringUtil.isNotEmpty(clinicId)){
			sql.append(" and code in(");
			sql.append("select distinct title_code code from doctor where clinic_id = ");
			sql.append(clinicId);
			sql.append(" ) ");
		}
		return getList(sql.toString());
	}

}