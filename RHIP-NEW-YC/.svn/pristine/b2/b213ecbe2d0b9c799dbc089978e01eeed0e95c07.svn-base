package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.rhip.mdm.entity.Dictionary;
import com.founder.rhip.mdm.repository.IDictionaryDao;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mdmDictionaryDao")
public class DictionaryDao extends MDMRepository<Dictionary, String> implements IDictionaryDao {

	protected static final String DICTIONARY_LOG = "DICTIONARY_LOG";
	
	protected static final String DICTIONARY = "DICTIONARY";
	
	@Override
	public List<Dictionary> getDicMetaVersions(Criteria criteria) {
		setTableName(DICTIONARY_LOG);
		List<Dictionary> versions = getList(criteria);
		setTableName(DICTIONARY);
		return versions;
	}

	@Override
	public Dictionary getDicMetaByVersion(Criteria criteria) {
		setTableName(DICTIONARY_LOG);
		Dictionary dicMeta = get(criteria);
		setTableName(DICTIONARY);
		return dicMeta;
	}

	@Override
	public void insertVersion(Criteria criteria) {
		insertLogRecord(DICTIONARY_LOG, criteria);
	}

	@Override
	public void deleteVersions(Criteria criteria) {
		setTableName(DICTIONARY_LOG);
		delete(criteria);
		setTableName(DICTIONARY);
	}

}
