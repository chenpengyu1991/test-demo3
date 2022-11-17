package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.mdm.entity.Dictionary;

import java.util.List;

/**
 * DAO interface of CvDicmeta
 * 
 */
public interface IDictionaryDao extends IDao<Dictionary,String> {
	
	public List<Dictionary> getDicMetaVersions(Criteria criteria);
	
	public Dictionary getDicMetaByVersion(Criteria criteria);
	
	public void insertVersion(Criteria criteria);
	
	public void deleteVersions(Criteria criteria);
	
}