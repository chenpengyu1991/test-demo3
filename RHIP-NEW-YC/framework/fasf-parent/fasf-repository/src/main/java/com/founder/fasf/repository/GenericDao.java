package com.founder.fasf.repository;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

@Repository("genericDao")
public class GenericDao extends internalDao implements IGenericDao {

	@Override
	public <T> int insert(T t, String... properties) {
		return insert(t.getClass(), t, properties);
	}

	@Override
	public <T> Number generatedKey(T t, String[] properties) {
		return generatedKey(t.getClass(), t, properties);
	}

	@Override
	public <T> Number generatedKey(T t, String keyColumnName, String[] properties) {
		return generatedKey(t.getClass(), t, keyColumnName, properties);
	}

	@Override
	public <T> int batchInsert(List<T> list, String... properties) {
		if (list == null || list.size() < 1) {return 0;}
		return batchEntityInsert(list.get(0).getClass(), list, properties);
	}
	
	@Override
	public <T> int batchInsertWithSeq(List<T> list,String seqName, String... properties) {
		if (list == null || list.size() < 1) {return 0;}
		return batchEntityInsertWithKeyValue(list.get(0).getClass(), list,dialect.getSelectSequenceNextValString(seqName), properties);
	}

	@Override
	public int batchInsert(Class<?> clazz, List<Map<String, Object>> list, String... properties) {
		return batchMapInsert(clazz, list, properties);
	}

	@Override
	public <T> int update(T t, String... properties) {
		return update(t.getClass(), t, properties);
	}

	@Override
	public <T> int batchUpdate(List<T> list, String... properties) {
		if (list == null || list.size() < 1) {return 0;}
		return batchEntityUpdate(list.get(0).getClass(), list, properties);
	}

	@Override
	public int batchUpdate(Class<?> clazz, List<Map<String, Object>> list, String... properties) {
		return batchMapUpdate(clazz, list, properties);
	}

}
