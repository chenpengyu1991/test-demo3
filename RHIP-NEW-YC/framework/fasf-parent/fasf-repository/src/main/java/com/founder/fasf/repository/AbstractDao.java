
package com.founder.fasf.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.Map.Entry;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import com.founder.fasf.annotation.TableLog;
import com.founder.fasf.beans.BeanUtil;
import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.fasf.util.StringUtil;

public class AbstractDao<T, PK extends Serializable> extends internalDao implements IDao<T,PK> {

	private Class<T> tClazz;

	public Criteria nullCriteria = null;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
	    tClazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}


	public AbstractDao(String tableName, String key) {
		this();
		this.tableName = tableName;
		this.key = key;
	}

	public void before(){

	}

	@Override
	public int insert(T t, String... properties) {
        
		return insert(tClazz, t, properties);
	}

	@Override
	public int insertWithSeq(T t,String seqName, String... properties) {
		
		return insertWithKeyValue(tClazz, t,dialect.getSelectSequenceNextValString(seqName), properties);
	}

	@Override
	public int insert(Map<String, Object> map, String... properties) {
        
		return insert(tClazz, map, properties);
	}

	@Override
	public Number generatedKey(T t, String property) {
        
		return generatedKey(tClazz, t, new String[] { property });
	}

	@Override
	public Number generatedKey(T t, String keyColumnName, String[] properties) {
        
		return generatedKey(tClazz, t, keyColumnName, properties);
	}

	@Override
	public int batchInsert(List<T> list, String... properties) {
        
		return batchEntityInsert(tClazz, list, properties);
	}

	@Override
	public int batchInsertWithSeq(List<T> list,String seqName, String... properties) {
        
		return batchEntityInsertWithKeyValue(tClazz, list,dialect.getSelectSequenceNextValString(seqName), properties);
	}

	@Override
	public int batchMapInsert(List<? extends Map<String, Object>> list, String... properties) {
        
		return batchMapInsert(tClazz, list, properties);
	}

	@Override
	public int delete(@SuppressWarnings("unchecked") PK... pKeys) {
        
		return delete(tClazz, pKeys);
	}

	@Override
	public int delete(Criteria criteria) {
        
		return delete(tClazz, criteria);
	}

	// get property change flag with 0 or 1 in string of zero
	private String getPropertiesChangeFlagString(String... properties) {
		ClassMetadata cMetadata = ClassMetadata.getMetadata(tClazz);
		Map<String, Integer> propertiesIndexHashMap = cMetadata.getPropertiesIndexHashMap();
		char[] resultString = cMetadata.getPropertiesIndexTempString().toCharArray();
		for (int i = 0; i < properties.length; i++) {
			int index = propertiesIndexHashMap.get(properties[i]);
			resultString[index] = '1';
		}
		return new String(resultString);
	}

	private static String logInstrStringTempString = "";

	@SuppressWarnings("rawtypes")
	private String getLogInstrStringTemp() {
		if (StringUtil.isNotEmpty(logInstrStringTempString)) {
			return logInstrStringTempString;
		}
		TableLog tableLog = tClazz.getAnnotation(TableLog.class);
		if (tableLog == null) {
			return "";
		}
		StringBuilder colString = new StringBuilder("insert into " + tableLog.logTableName() + "(");
		StringBuilder valueString = new StringBuilder(") select ");
		ClassMetadata cMetadata = ClassMetadata.getMetadata(tClazz);
		String pkColumnNameString = "";
		Iterator<Entry<String, PropertyMetadata>> propertiesMap = cMetadata.getProperty().entrySet().iterator();
		try {
			// get insert column name with loop
			while (propertiesMap.hasNext()) {
				Map.Entry entry = (Map.Entry) propertiesMap.next();
				PropertyMetadata propertyMetadata = (PropertyMetadata) entry.getValue();
				if (!propertyMetadata.isDbField()) {
					continue;
				}
				String columName = propertyMetadata.getColumn();
				if (propertyMetadata.isPrimayKey()) {
					pkColumnNameString = columName;
				}
				colString.append(columName);
				colString.append(",");
				valueString.append(columName);
				valueString.append(",");
			}
			//
			if (StringUtil.isNotEmpty(tableLog.opChangeFlagColumn())) {
				colString.append(tableLog.opChangeFlagColumn());
				valueString.append("{1}");
				valueString.append(" as ");
				valueString.append(tableLog.opChangeFlagColumn());
			}
			valueString.append(" from ");
			valueString.append(cMetadata.getTable());
			valueString.append(" where ");
			valueString.append(pkColumnNameString);
			valueString.append(" in ({2})");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.info("TABLELOG ERROR: " + e.getMessage());
			return "";
		}
		logInstrStringTempString = colString.toString() + valueString.toString();
		return logInstrStringTempString;
	}

	// get log insert string
	@SuppressWarnings("unchecked")
	private String getLogInstrString(String[] properties, String[] pkIds, T... ts) {
		try {
			String inStrTemp = getLogInstrStringTemp();
			String changeFlag = getPropertiesChangeFlagString(properties);
			String primaryKeyValueString = "";
			if (pkIds == null) {
				ClassMetadata cMetadata = ClassMetadata.getMetadata(tClazz);
				for (T t : ts) {
					primaryKeyValueString += "'" + PropertyUtils.getSimpleProperty(t, cMetadata.getPrimaryKey()).toString() + "',";
				}
			} else {
				for (String pkId : pkIds) {
					primaryKeyValueString += "'" + pkId + "',";
				}
			}
			primaryKeyValueString += "'-1'";
			return inStrTemp.replace("{1}", changeFlag).replace("{2}", primaryKeyValueString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	@SuppressWarnings("unchecked")
	@Override
	public int updateWithLog(T t, String... properties) {
        
		String instrString = getLogInstrString(properties, null, t);
		if (StringUtil.isNotEmpty(instrString)) {
			try {
				execute(instrString);
			} catch (Exception e) {
				logger.info("TABLE LOG ERROR:" + e.getMessage() + " -SQL:" + instrString);
			}
		}
		return update(t, properties);
	}

    @SuppressWarnings("unchecked")
	@Override
	public int updateWithLog(Map<String, Object> map, String... properties) {
        
		List<String> pkIdStrings = new ArrayList<String>();
		ClassMetadata cMetadata = ClassMetadata.getMetadata(tClazz);
		String pKey = cMetadata.getPrimaryKey();
		pkIdStrings.add(map.get(pKey).toString());
		String instrString = getLogInstrString(properties, pkIdStrings.toArray(new String[] {}));
		if (StringUtil.isNotEmpty(instrString)) {
			try {
				execute(instrString);
			} catch (Exception e) {
				logger.info("TABLE LOG ERROR:" + e.getMessage() + " -SQL:" + instrString);
			}
		}
		return update(map, properties);
	}
	@Override
	public int update(T t, String... properties) {
        
		return update(tClazz, t, properties);
	}

	@Override
	public int update(Map<String, Object> map, String... properties) {
        
		return update(tClazz, map, properties);
	}

	@Override
	public int update(Parameters parameters, Criteria criteria) {
        
		return update(tClazz, parameters, criteria);
	}

	@Override
	public int batchUpdate(List<T> list, String... properties) {
        
		return batchEntityUpdate(tClazz, list, properties);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int batchMapUpdateWithLog(List<? extends Map<String, Object>> list, String... properties) {
        
		List<String> pkIdStrings = new ArrayList<String>();
		ClassMetadata cMetadata = ClassMetadata.getMetadata(tClazz);
		String pKey = cMetadata.getPrimaryKey();
		for (Map<String, Object> obj : list) {
			pkIdStrings.add(obj.get(pKey).toString());
		}
		String instrString = getLogInstrString(properties, pkIdStrings.toArray(new String[] {}));
		if (StringUtil.isNotEmpty(instrString)) {
			try {
				execute(instrString);
			} catch (Exception e) {
				logger.info("TABLE LOG ERROR:" + e.getMessage() + " -SQL:" + instrString);
			}
		}
		return batchMapUpdate(list, properties);
	}

	@Override
	public int batchMapUpdate(List<? extends Map<String, Object>> list, String... properties) {
        
		return batchMapUpdate(tClazz, list, properties);
	}

	@Override
	public T get(PK id) {
        
		return get(tClazz, id);
	}

	@Override
	public T get(Criteria criteria, String... properties) {
        
		return get(tClazz, criteria, properties);
	}

	public T get(String sql, Criteria criteria) {
		if (StringUtil.isNullOrEmpty(sql)) {
			return null;
		}
        
		SqlBuilder.createSelectString(tClazz, getTableName(), criteria, null);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return get(tClazz, sql, sqlParameterSource);
	}

	@Override
	public Map<String, Object> getMap(Criteria criteria, String... properties) {
        
		return getMap(tClazz, criteria, properties);
	}

	@Override
	public List<T> getAll() {
        
		return getAll(tClazz);
	}

	@Override
	public List<T> getList(Criteria criteria, String... properties) {
        
		return getList(tClazz, criteria, properties);
	}

    @Override
	public List<T> getList(Criteria criteria, Order order, String... properties) {
        
		return getList(tClazz, criteria, order, properties);
	}

	@Override
	public List<Map<String, Object>> getMapList(Criteria criteria, String... properties) {
        
		return getMapList(tClazz, criteria, properties);
	}

	@Override
	public List<Map<String, Object>> getMapList(Criteria criteria, Order order, String... properties) {
        
		return getMapList(tClazz, criteria, order, properties);
	}

	@Override
	public PageList<T> getPageList(Page page, Criteria criteria, String... properties) {
        
		return getPageList(tClazz, page, criteria, properties);
	}

	/*
	 * public <N extends Number> N getSingle(String sql, Class<N>
	 * requiredType){ return getSingle(sql, null, requiredType); }
	 */
	public <N extends Number> N getSingle(String sql, Criteria criteria, Class<N> requiredType) {
        
		if (StringUtil.isNullOrEmpty(sql)) {
			return null;
		}
		SqlBuilder.createSelectString(tClazz, getTableName(), criteria, null);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		try {
			return getSimpleJdbcTemplate().getNamedParameterJdbcOperations().queryForObject(sql.toString(), sqlParameterSource, requiredType);
		} catch (DataAccessException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public <U> U get(Map<String, Object> map, Class<U> clazz) {
        
		return BeanUtil.getWarpBean(clazz, map);
	}

	public Map<String, Object> getMap(String sql, Criteria criteria) {
        
		if (StringUtil.isNullOrEmpty(sql)) {
			return null;
		}
		SqlBuilder.createSelectString(tClazz, getTableName(), criteria, null);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return getMap(sql, sqlParameterSource);
	}

	public List<Map<String, Object>> getMapList(String sql, Criteria criteria) {
        
		if (StringUtil.isNullOrEmpty(sql)) {
			return null;
		}
		SqlBuilder.createSelectString(tClazz, getTableName(), criteria, null);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return getMapList(sql, sqlParameterSource);
	}

	public List<T> getList(String sql) {
		if (StringUtil.isNullOrEmpty(sql)) {
			return null;
		}
        
		SqlParameterSource sqlParameterSource = null;
		return getList(tClazz, sql, sqlParameterSource);
	}

	public  <U> List<U> getList(Class<U> clazz, String sql, Criteria criteria) {
		if (StringUtil.isNullOrEmpty(sql)) {
			return null;
		}
        
		SqlBuilder.createSelectString(clazz, getTableName(), criteria, null);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return getList(clazz, sql, sqlParameterSource);
	}

	public List<T> getList(String sql, Criteria criteria) {
		if (StringUtil.isNullOrEmpty(sql)) {
			return null;
		}
        
		SqlBuilder.createSelectString(tClazz, getTableName(), criteria, null);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return getList(tClazz, sql, sqlParameterSource);
	}

	public PageList<T> getPageList(Page page, String sql, Criteria criteria) {
		if (page == null || StringUtil.isNullOrEmpty(sql)) {
			return null;
        }
        
		SqlBuilder.createSelectString(tClazz, getTableName(), criteria, null);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		StringBuilder cSql = new StringBuilder("SELECT COUNT(*) FROM ( ").append(sql).append(" )");
		int rowCounts = getSimpleJdbcTemplate().queryForInt(cSql.toString(), sqlParameterSource);
		page.setTotalRows(rowCounts);
		String nSql = dialect.getLimitString(sql, page.getStartRow(), page.getPageSize());
		return new PageList<T>(getList(tClazz, nSql, sqlParameterSource), page);
	}

	public PageList<Map<String, Object>> getPageMapList(Page page, String sql, Criteria criteria) {
        
		if (page == null || StringUtil.isNullOrEmpty(sql)) {
			return null;
		}
		SqlBuilder.createSelectString(tClazz, getTableName(), criteria, null);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		StringBuilder cSql = new StringBuilder("SELECT COUNT(*) FROM ( ").append(sql).append(" )");
		int rowCounts = getSimpleJdbcTemplate().queryForInt(cSql.toString(), sqlParameterSource);
		page.setTotalRows(rowCounts);
		String nSql = dialect.getLimitString(sql, page.getStartRow(), page.getPageSize());
		return new PageList<Map<String, Object>>(getMapList(nSql, sqlParameterSource), page);
	}

	@Override
	public PageList<T> getPageList(Page page, Criteria criteria, Order order, String... properties) {
        
		return getPageList(tClazz, page, criteria, order, properties);
	}

    @Override
    public PageList<T> getPageListForSingleTable(Page page, Criteria criteria, Order order, String... properties) {
        
        return getPageListForSingleTable(tClazz, page, criteria, order, properties);
    }

	@Override
	public PageList<Map<String, Object>> getPageMapList(Page page, Criteria criteria, String... properties) {
        
		return getPageMapList(tClazz, page, criteria, properties);
	}

	@Override
	public PageList<Map<String, Object>> getPageMapList(Page page, Criteria criteria, Order order, String... properties) {
        
		return getPageMapList(tClazz, page, criteria, order, properties);
	}

	@Override
	public <N extends Number> N getCount(Criteria criteria, String countPropertyName, Class<N> requiredType) {
        
		return getCount(tClazz, criteria, countPropertyName, requiredType);
	}

	@Override
	public <N extends Number> N getSum(Criteria criteria, String sumPropertyName, Class<N> requiredType) {
        
		return getSum(tClazz, criteria, sumPropertyName, requiredType);
	}

	@Override
	public <N extends Number> N getMin(Criteria criteria, String minPropertyName, Class<N> requiredType) {
        
		return getMin(tClazz, criteria, minPropertyName, requiredType);
	}

	@Override
	public <N extends Number> N getMax(Criteria criteria, String maxPropertyName, Class<N> requiredType) {
        
		return getMax(tClazz, criteria, maxPropertyName, requiredType);
	}

	//add by chenweihua
	public Class<T> getTClass() {
		return tClazz;
	}

	@Override
	protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
		SimpleJdbcTemplate simpleJdbcTemplate = JdbcTemplateCache.get(this.getClass().getName());
		if (simpleJdbcTemplate != null) {
			return simpleJdbcTemplate;
		}
		return super.getSimpleJdbcTemplate();
	}
}
