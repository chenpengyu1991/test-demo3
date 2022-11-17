package com.founder.elb.repository;

import com.founder.elb.entity.CvDicmeta;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;

/**
 * DAO interface of CvDicmeta
 * 
 */
public interface ICvDicmetaDao extends IDao<CvDicmeta,Long> {
	
	 PageList<CvDicmeta> getList(Page page, Integer[] clinicId, Criteria criteria);

}