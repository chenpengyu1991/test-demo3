/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.founder.fasf.util.ObjectUtil;

/**
 * 
 * @author DenggaoLi
 * 
 */
public class Criteria implements Serializable {

	private static final long serialVersionUID = 7534673028743277151L;

	private Map<String, SqlParameter> parameterMap;

	private List<Criterion> criteria;

	public Criteria() {
		criteria = new ArrayList<Criterion>();
	}

	public Criteria(String name, Object value) {
		criteria = new ArrayList<Criterion>();
		addCriterion(new Criterion(name, OP.EQ, value));
	}

	public Criteria(String name, OP operation, Object value) {
		criteria = new ArrayList<Criterion>();
		addCriterion(new Criterion(name, operation, value));
	}

	public void addCriterion(Criterion criterion) {
		criteria.add(criterion);
	}

	public Criteria add(LOP logicOperation, String name, OP operation, Object value) {
		this.addCriterion(new Criterion(logicOperation, name, operation, value));
		return this;
	}

	public Criteria add(LOP logicOperation, String name, Object value) {
		this.addCriterion(new Criterion(logicOperation, name, OP.EQ, value));
		return this;
	}

	public Criteria add(String name, OP operation, Object value) {
		this.addCriterion(new Criterion(name, operation, value));
		return this;
	}

	public Criteria add(String name, Object value) {
		this.addCriterion(new Criterion(name, value));
		return this;
	}

	public Criteria add(Criteria criteria) {
		this.addCriterion(new Criterion(criteria));
		return this;
	}
	
	/**
	 * 
	 * 加同级条件而不是作为子条件
	 */
	public Criteria addAll(Criteria otherCriteria) {
		criteria.addAll(otherCriteria.getCriteria());
		return this;
	}

	public Criteria add(LOP logicOperation, Criteria criteria) {
		this.addCriterion(new Criterion(logicOperation, criteria));
		return this;
	}
	public Boolean contains(String key){
		for(Criterion criterion:criteria){
			if(key.equals(criterion.getName())){
				return true;
			}
		}
		return false;
	}
	public Object get(String Key){
		for(Criterion criterion:criteria){
			if(Key.equals(criterion.getName())){
				return criterion.getValue();
			}
		}
		return null;
	}
	public Boolean remove(String Key){
		for(Criterion criterion:criteria){
			if(Key.equals(criterion.getName())){
				criteria.remove(criterion);
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Criteria)) {
			return false;
		}
		Criteria castOther = (Criteria) other;
		return new EqualsBuilder().append(criteria, castOther.criteria).isEquals();
	}

	public List<Criterion> getCriteria() {
		return criteria;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(criteria).toHashCode();
	}

	public void setCriteria(List<Criterion> criteria) {
		this.criteria = criteria;
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("criteria", criteria).toString();
	}

	public Map<String, SqlParameter> getParameterMap() {
		return parameterMap;
	}

	public String toSql(ClassMetadata classMetadata, String prefixInSql) {
		StringBuilder sql = new StringBuilder();
		if (ObjectUtil.isNullOrEmpty(parameterMap)) {parameterMap = new HashMap<String, SqlParameter>();}
		int i = 0;
		for (Criterion criterion : criteria) {
			sql.append(criterion.toSql(classMetadata, prefixInSql, i));
			if (ObjectUtil.isNotEmpty(criterion.getParameterMap())) {parameterMap.putAll(criterion.getParameterMap());}
			i++;
		}
		return sql.toString();
	}
	
	/**
	 * @param alias 表别名
	 * @return
	 */
	public String toSql(ClassMetadata classMetadata, String prefixInSql, String alias) {
		StringBuilder sql = new StringBuilder();
		if (ObjectUtil.isNullOrEmpty(parameterMap)) {parameterMap = new HashMap<String, SqlParameter>();}
		int i = 0;
		for (Criterion criterion : criteria) {
			sql.append(criterion.toSql(classMetadata, prefixInSql, i, alias));
			if (ObjectUtil.isNotEmpty(criterion.getParameterMap())) {parameterMap.putAll(criterion.getParameterMap());}
			i++;
		}
		return sql.toString();
	}
}
