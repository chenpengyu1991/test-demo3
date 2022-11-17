/*
 * Copyright (c) 2010-2020 Founder International Co., Ltd. All Rights Reserved.
 * 
 * This software is the confidential and proprietary information of Founder. You
 * shall not disclose such Confidential Information and shall use it only in
 * accordance with the terms of the agreements you entered into with Founder.
 */

package com.founder.fasf.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

/**
 * 
 * @author DenggaoLi
 * 
 */
public class Criterion implements Serializable {

	private static final long serialVersionUID = 2658973973160456090L;

	private Map<String, SqlParameter> parameterMap;

	private LOP logicOperation;

	private String name;

	private Criteria criteria;

	private Class<?> dataType;

	private OP operation;

	private Object value;

	public Criterion() {
	}

	public Criterion(Criteria criteria) {
		logicOperation = LOP.AND;
		value = criteria;
	}

	public Criterion(LOP logicOperation, Criteria criteria) {
		this.logicOperation = logicOperation;
		value = criteria;
	}

	public Criterion(LOP LogicOperation, String name, OP operation, Object value) {
		logicOperation = LogicOperation;
		this.name = name;
		this.operation = operation;
		this.value = value;
	}

	public Criterion(String name, Class<?> dayaType, String operation, Object value) {
		logicOperation = LOP.AND;
		this.name = name;
		this.dataType = dayaType;
		this.operation = ObjectUtil.getOP(operation);
		this.value = value;
	}

	public Criterion(String name, Object value) {
		this(LOP.AND, name, OP.EQ, value);
	}

	public Criterion(String name, OP operation, Object value) {
		this(LOP.AND, name, operation, value);
	}

	@SuppressWarnings("rawtypes")
	private void buildInOperation(StringBuilder sql) {
		if(ObjectUtil.isNullOrEmpty(value)) {
			sql.append("''");
		} else if (ObjectUtil.isArray(value) && (((Object[]) value).length > 0)) {
			Object[] objects = (Object[]) value;
			String flag = ObjectUtil.isNumber(objects[0]) ? "" : "'";
			for (int i = 0; i < objects.length; i++) {
				if (i > 0) {
					sql.append(",");
				}
				sql.append(flag).append(objects[i]).append(flag);
			}
		} else if (ObjectUtil.isCollection(value) && (((Collection)value).size()>0)) {
			Collection objects = (Collection) value;
			String flag = ObjectUtil.isNumber(objects.iterator().next()) ? "" : "'";
			int i = 0;
			for (Object obj : objects) {
				if (i > 0) {
					sql.append(",");
				}
				i++;
				sql.append(flag).append(obj).append(flag);
			}
		} else if(ObjectUtil.isString(value)){
			sql.append(value);
		}
	}

	@Override
	public boolean equals(final Object other) {
		if (!(other instanceof Criterion)) {
			return false;
		}
		Criterion castOther = (Criterion) other;
		return new EqualsBuilder().append(name, castOther.name).append(operation, castOther.operation).append(value, castOther.value).isEquals();
	}

	public Criteria getCriteria() {
		return criteria;
	}

	public LOP getLogicOperation() {
		return logicOperation;
	}

	public String getName() {
		return name;
	}

	public OP getOperation() {
		return operation;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(name).append(operation).append(value).toHashCode();
	}

	@SuppressWarnings("rawtypes")
	private String operationToString(ClassMetadata classMetadata, String prefixInSql) {
		StringBuilder sql = new StringBuilder();
		String typeName = null;
		int sqlType = Integer.MIN_VALUE;
		Integer scale = null;
		String columnName = null;
		String propertyName = null;		
		if (classMetadata != null && (classMetadata.getProperty().containsKey(name) || classMetadata.getColumns().containsKey(name.toUpperCase()))) {		
			LinkedHashMap<String, PropertyMetadata> pMetadata= classMetadata.getProperty();
			LinkedHashMap<String, String> columns=classMetadata.getColumns(); 
			PropertyMetadata propertyMetada =pMetadata.containsKey(name) ?pMetadata.get(name) :pMetadata.get(columns.get(name.toUpperCase()));
			propertyName = propertyMetada.getName();
			columnName = propertyMetada.getColumn();
			sqlType = ObjectUtil.javaTypeToSqlParameterType(propertyMetada.getPropertyDescriptor().getPropertyType());
			typeName = propertyMetada.getPropertyDescriptor().getName();
			scale = propertyMetada.getScale();
		} else {
			columnName = name;
			if (dataType == null) {
				propertyName = StringUtil.formatKey(name);
				Class pClazz = ObjectUtil.isArray(value) ? value.getClass().getComponentType() : value.getClass();
				typeName = pClazz.getName();
				sqlType = ObjectUtil.javaTypeToSqlParameterType(pClazz);
			} else {
				if ((StringUtils.contains(columnName, "MIN_") || StringUtils.contains(columnName, "MAX_")) && StringUtils.endsWith(columnName, "DATE")) {
					propertyName = columnName;
					if ((StringUtils.contains(columnName, "MIN_")))columnName = StringUtils.replace(columnName, "MIN_", "", 1);
					if ((StringUtils.contains(columnName, "MAX_")))columnName = StringUtils.replace(columnName, "MAX_", "", 1);
					
				} else {
					propertyName = columnName;
				}
				typeName = dataType.getName();
				sqlType = ObjectUtil.javaTypeToSqlParameterType(dataType);
			}
		}
		
		// String parameterName = new
		// StringBuilder(prefixInSql).append(propertyName).toString();
		switch (operation) {
			case EQ:
				sql.append(columnName).append("=").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case NE:
				sql.append(columnName).append("<>").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case GE:
				sql.append(columnName).append(">=").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case LE:
				sql.append(columnName).append("<=").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case GT:
				sql.append(columnName).append(">").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case LT:
				sql.append(columnName).append("<").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case BETWEEN:
				String min = new StringBuilder("min").append(propertyName).toString();
				String max = new StringBuilder("max").append(propertyName).toString();
				sql.append("(").append(columnName).append(">=").append(prefixInSql).append(min);
				sql.append(" AND ");
				sql.append(columnName).append("<=").append(prefixInSql).append(max).append(")");
				Object[] v = ArrayUtil.toObjectArray(value);
				parameterMap.put(min, new SqlParameter(min, v[0], typeName, sqlType, scale));
				parameterMap.put(max, new SqlParameter(max, v[1], typeName, sqlType, scale));
				break;
			case IN:
				sql.append(columnName).append(" IN (");
				//如果数据库是Oralce时，使用时注意In表达式内的变量数在100之内，当变量数大于100时建议客户程序分批处理。
				buildInOperation(sql);//update by LDG，				
				//buildInOperation(prefixInSql, sql, typeName, sqlType, scale, propertyName);
				sql.append(") ");
				break;
			case NOTIN:
				sql.append(columnName).append(" NOT IN (");
				buildInOperation(sql);
				//buildInOperation(prefixInSql, sql, typeName, sqlType, scale, propertyName);
				sql.append(") ");
				break;
			case LIKE:
				sql.append(columnName).append(" LIKE '%'||").append(prefixInSql).append(propertyName).append("||'%'");
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case FLIKE:
				sql.append(columnName).append(" LIKE ").append(prefixInSql).append(propertyName).append("||'%'");
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case ELIKE:
				sql.append(columnName).append(" LIKE '%'||").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case IS:
				sql.append(columnName).append(" IS ").append(value);
				//parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case UEMPTY:
				sql.append(columnName).append(" IS NOT NULL");
				break;
		}
		return sql.toString();
	}
	
	@SuppressWarnings("rawtypes")
	private String operationToString(ClassMetadata classMetadata, String prefixInSql, String alias) {
		StringBuilder sql = new StringBuilder();
		String typeName = null;
		int sqlType = Integer.MIN_VALUE;
		Integer scale = null;
		String columnName = null;
		String propertyName = null;		
		if (classMetadata != null && (classMetadata.getProperty().containsKey(name) || classMetadata.getColumns().containsKey(name.toUpperCase()))) {		
			LinkedHashMap<String, PropertyMetadata> pMetadata= classMetadata.getProperty();
			LinkedHashMap<String, String> columns=classMetadata.getColumns(); 
			PropertyMetadata propertyMetada =pMetadata.containsKey(name) ?pMetadata.get(name) :pMetadata.get(columns.get(name.toUpperCase()));
			propertyName = propertyMetada.getName();
			columnName = alias + "." + propertyMetada.getColumn();
			sqlType = ObjectUtil.javaTypeToSqlParameterType(propertyMetada.getPropertyDescriptor().getPropertyType());
			typeName = propertyMetada.getPropertyDescriptor().getName();
			scale = propertyMetada.getScale();
		} else {
			columnName = name;
			if (dataType == null) {
				propertyName = StringUtil.formatKey(name);
				Class pClazz = ObjectUtil.isArray(value) ? value.getClass().getComponentType() : value.getClass();
				typeName = pClazz.getName();
				sqlType = ObjectUtil.javaTypeToSqlParameterType(pClazz);
			} else {
				if ((StringUtils.contains(columnName, "MIN_") || StringUtils.contains(columnName, "MAX_")) && StringUtils.endsWith(columnName, "DATE")) {
					propertyName = columnName;
					if ((StringUtils.contains(columnName, "MIN_")))columnName = StringUtils.replace(columnName, "MIN_", "", 1);
					if ((StringUtils.contains(columnName, "MAX_")))columnName = StringUtils.replace(columnName, "MAX_", "", 1);
					
				} else {
					propertyName = columnName;
				}
				typeName = dataType.getName();
				sqlType = ObjectUtil.javaTypeToSqlParameterType(dataType);
			}
		}
		
		// String parameterName = new
		// StringBuilder(prefixInSql).append(propertyName).toString();
		switch (operation) {
			case EQ:
				sql.append(columnName).append("=").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case NE:
				sql.append(columnName).append("<>").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case GE:
				sql.append(columnName).append(">=").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case LE:
				sql.append(columnName).append("<=").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case GT:
				sql.append(columnName).append(">").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case LT:
				sql.append(columnName).append("<").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case BETWEEN:
				String min = new StringBuilder("min").append(propertyName).toString();
				String max = new StringBuilder("max").append(propertyName).toString();
				sql.append("(").append(columnName).append(">=").append(prefixInSql).append(min);
				sql.append(" AND ");
				sql.append(columnName).append("<=").append(prefixInSql).append(max).append(")");
				Object[] v = ArrayUtil.toObjectArray(value);
				parameterMap.put(min, new SqlParameter(min, v[0], typeName, sqlType, scale));
				parameterMap.put(max, new SqlParameter(max, v[1], typeName, sqlType, scale));
				break;
			case IN:
				sql.append(columnName).append(" IN (");
				//如果数据库是Oralce时，使用时注意In表达式内的变量数在100之内，当变量数大于100时建议客户程序分批处理。
				buildInOperation(sql);//update by LDG，				
				//buildInOperation(prefixInSql, sql, typeName, sqlType, scale, propertyName);
				sql.append(") ");
				break;
			case NOTIN:
				sql.append(columnName).append(" NOT IN (");
				buildInOperation(sql);
				//buildInOperation(prefixInSql, sql, typeName, sqlType, scale, propertyName);
				sql.append(") ");
				break;
			case LIKE:
				sql.append(columnName).append(" LIKE '%'||").append(prefixInSql).append(propertyName).append("||'%'");
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case FLIKE:
				sql.append(columnName).append(" LIKE ").append(prefixInSql).append(propertyName).append("||'%'");
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case ELIKE:
				sql.append(columnName).append(" LIKE '%'||").append(prefixInSql).append(propertyName);
				parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case IS:
				sql.append(columnName).append(" IS ").append(value);
				//parameterMap.put(propertyName, new SqlParameter(propertyName, value, typeName, sqlType, scale));
				break;
			case UEMPTY:
				sql.append(columnName).append(" IS NOT NULL");
				break;
		}
		return sql.toString();
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public void setLogicOperation(LOP logicOperation) {
		this.logicOperation = logicOperation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOperation(OP operation) {
		this.operation = operation;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String toSql(ClassMetadata classMetadata, String prefixInSql, int index) {
		StringBuilder sql = new StringBuilder();
		if (index > 0) {
			sql.append(logicOperation.equals(LOP.OR) ? " OR " : " AND ");
		}
		if (ObjectUtil.isNullOrEmpty(parameterMap)) {
			parameterMap = new HashMap<String, SqlParameter>();
		}
		if (value instanceof Criteria) {
			sql.append("(");
			sql.append(((Criteria) value).toSql(classMetadata, prefixInSql));
			sql.append(")");
			parameterMap.putAll(((Criteria) value).getParameterMap());
		} else {
			sql.append(operationToString(classMetadata, prefixInSql));
		}
		return sql.toString();
	}
	
	public String toSql(ClassMetadata classMetadata, String prefixInSql, int index, String alias) {
		StringBuilder sql = new StringBuilder();
		if (index > 0) {
			sql.append(logicOperation.equals(LOP.OR) ? " OR " : " AND ");
		}
		if (ObjectUtil.isNullOrEmpty(parameterMap)) {
			parameterMap = new HashMap<String, SqlParameter>();
		}
		if (value instanceof Criteria) {
			sql.append("(");
			sql.append(((Criteria) value).toSql(classMetadata, prefixInSql, alias));
			sql.append(")");
			parameterMap.putAll(((Criteria) value).getParameterMap());
		} else {
			sql.append(operationToString(classMetadata, prefixInSql, alias));
		}
		return sql.toString();
	}
	
	@Override
	public String toString() {
		return new ToStringBuilder(this).append("name", name).append("operation", operation).append("value", value).toString();
	}

	public Map<String, SqlParameter> getParameterMap() {
		return parameterMap;
	}

	public Class<?> getDataType() {
		return dataType;
	}

	public void setDataType(Class<?> dataType) {
		this.dataType = dataType;
	}
}
