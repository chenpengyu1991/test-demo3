/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;

/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 * 
 * <p>
 * Extend this interface if you want typesafe (no casting necessary) DAO's for
 * your domain objects.
 * 
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
public interface IDao<T, PK extends Serializable> {

	int insert(T t, String... properties);

	int insert(Map<String, Object> map, String... properties);
	
	int insertWithSeq( T t,String seqName, String... properties);

	Number generatedKey(T t, String property);

	Number generatedKey(T t, String keyColumnName, String[] properties);

	int batchInsert(List<T> list, String... properties);
	
	int batchInsertWithSeq( List<T> list,String seqName, String... properties);

	int batchMapInsert(List<? extends Map<String, Object>> list, String... properties);

	int delete(@SuppressWarnings("unchecked") PK... pKeys);

	int delete(Criteria criteria);

	int updateWithLog(T t, String... properties);
	
	int update(T t, String... properties);
 
	int updateWithLog(Map<String, Object> map, String... properties);
	
	int update(Map<String, Object> map, String... properties);
	 
	int update(Parameters parameters, Criteria criteria);

	//int batchUpdateWithLog(List<T> list,  String... properties);
	
	int batchUpdate(List<T> list, String... properties);
	
	int batchMapUpdateWithLog(List<? extends Map<String, Object>> list, String... properties);
	
	int batchMapUpdate(List<? extends Map<String, Object>> list, String... properties);

	T get(PK id);

	T get(Criteria criteria, String... properties);

	Map<String, Object> getMap(Criteria criteria, String... properties);

	List<T> getAll();

	List<T> getList(Criteria criteria, String... properties);

	List<T> getList(Criteria criteria, Order order, String... properties);

	List<Map<String, Object>> getMapList(Criteria criteria, Order order, String... properties);

	List<Map<String, Object>> getMapList(Criteria criteria, String... properties);

	PageList<T> getPageList(Page page, Criteria criteria, String... properties);

	PageList<T> getPageList(Page page, Criteria criteria, Order order, String... properties);

	PageList<Map<String, Object>> getPageMapList(Page page, Criteria criteria, String... properties);

	PageList<Map<String, Object>> getPageMapList(Page page, Criteria criteria, Order order, String... properties);

	<N extends Number> N getCount(Criteria criteria, String countPropertyName,Class<N> requiredType);

	<N extends Number> N getSum(Criteria criteria, String sumPropertyName,Class<N> requiredType);

	<N extends Number> N getMin(Criteria criteria, String minPropertyName,Class<N> requiredType);

	<N extends Number> N getMax(Criteria criteria, String maxPropertyName,Class<N> requiredType);
	
	<N extends Number> N getSequenceNextVal(String sequenceName, Class<N> requiredType);


    PageList<T> getPageListForSingleTable(Page page, Criteria criteria, Order order, String... properties);
}