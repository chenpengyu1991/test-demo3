
package com.founder.fasf.repository;

import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;

public interface IGenericDao {

	<T> int insert( T t, String... properties);

	int insert(Class<?> clazz, Map<String, Object> map, String... properties);

	<T> Number generatedKey(T t, String[] properties);

	<T> Number generatedKey(T t, String keyColumnName, String[] properties);

	<T> int batchInsert(List<T> list, String... properties);
	
	<T> int batchInsertWithSeq(List<T> list,String seqName, String... properties);
	
	int batchInsert(Class<?> clazz, List<Map<String, Object>> list, String... properties);

	<PK> int delete(Class<?> clazz, @SuppressWarnings("unchecked") PK... pKeys);

	int delete(Class<?> clazz, Criteria criteria);

	<T> int update(T t, String... properties);

	int update(Class<?> clazz, Map<String, Object> map, String... properties);

	int update(Class<?> clazz, Parameters parameters, Criteria criteria);

	<T> int batchUpdate(List<T> list, String... properties);

	int batchUpdate(Class<?> clazz, List<Map<String, Object>> list, String... properties);

	<T, PK> T get(Class<T> clazz, PK id);

	<T> T get(Class<T> clazz, Criteria criteria, String... properties);

	Map<String, Object> getMap(Class<?> clazz, Criteria criteria, String... properties);

	<T> List<T> getAll(Class<T> clazz);

	<T> List<T> getList(Class<T> clazz, Criteria criteria, String... properties);

	<T> List<T> getList(Class<T> clazz, Criteria criteria, Order order, String... properties);

	List<Map<String, Object>> getMapList(Class<?> clazz, Criteria criteria, Order order, String... properties);

	List<Map<String, Object>> getMapList(Class<?> clazz, Criteria criteria, String... properties);

	<T> PageList<T> getPageList(Class<T> clazz, Page page, Criteria criteria, String... properties);

	<T> PageList<T> getPageList(Class<T> clazz, Page page, Criteria criteria, Order order, String... properties);

	PageList<Map<String, Object>> getPageMapList(Class<?> clazz, Page page, Criteria criteria, String... properties);

	PageList<Map<String, Object>> getPageMapList(Class<?> clazz, Page page, Criteria criteria, Order order, String... properties);

	<T extends Number> T getSequenceNextVal(String sequenceName, Class<T> requiredType);
	
	<T extends Number> T getCount(Class<?> clazz, Criteria criteria, String countPropertyName, Class<T> requiredType);

	<T extends Number> T getSum(Class<?> clazz, Criteria criteria, String sumPropertyName, Class<T> requiredType);

	<T extends Number> T getMin(Class<?> clazz, Criteria criteria, String minPropertyName, Class<T> requiredType);

	<T extends Number> T getMax(Class<?> clazz, Criteria criteria, String maxPropertyName, Class<T> requiredType);
}