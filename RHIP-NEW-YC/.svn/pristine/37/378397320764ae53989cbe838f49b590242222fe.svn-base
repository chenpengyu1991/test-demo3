package com.founder.rhip.mdm.repository;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MDMRepository<T, PK extends Serializable> extends AbstractDao<T, PK> {
	
    @Resource(name = "phbdbJDBCTemplate")
    protected SimpleJdbcTemplate simpleJdbcTemplate;
    
	private String getField(String property) {
		ClassMetadata cMetadata = ClassMetadata.getMetadata(getTClass());
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		for (PropertyMetadata pm : pMetadata.values()) {
			if (property.equals(pm.getName())) {
				return pm.getColumn();
			}
		}
		return property;
	}
	
	protected String[] coverPropertiesToFields(String[] properties) {
		if (properties == null || properties.length == 0) {
			return getAllFields();
		}
		
		List<String> fields = new ArrayList<String>();
		for (String property : properties) {
			String field = getField(property);
			fields.add(field);
		}
		return fields.toArray(new String[fields.size()]);
	}
	
	protected String[] getAllFields() {
		List<String> fields = new ArrayList<String>();
		ClassMetadata cMetadata = ClassMetadata.getMetadata(getTClass());
		LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
		for (PropertyMetadata pm : pMetadata.values()) {
			if (pm.isDbField()) {
				fields.add(pm.getColumn());
			}
		}
		return fields.toArray(new String[fields.size()]);
	}
	
	protected String getListParamsSql(String param, int size) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			if (i > 0) {
				sb.append(",");
			}
			sb.append(param);
		}
		return sb.toString();
	}
	
	protected void insertLogRecord(String logTable, Criteria criteria) {
		String[] fields = getAllFields();
		String from = StringUtils.removeEnd(logTable, "_LOG");
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ").append(logTable);
		sql.append(" (").append(StringUtil.join(fields)).append(") ");
		String select = SqlBuilder.createSelectString(getTClass(), from, criteria, null);
		sql.append(select);
		SqlParameterSource source = SqlBuilder.getSqlParameterSource(criteria);
		simpleJdbcTemplate.update(sql.toString(), source);
	}
	
	protected <I> List<I> exeQuery(String sql, RowMapper<I> rm, Object... args) {
		return simpleJdbcTemplate.query(sql, rm, args);
	}
}
