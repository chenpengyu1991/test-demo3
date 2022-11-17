
package com.founder.fasf.repository;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.OP;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.beans.Parameters;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.fasf.repository.dialect.Dialect;
import com.founder.fasf.util.ArrayUtil;
import com.founder.fasf.util.ObjectUtil;
import com.founder.fasf.util.StringUtil;

public class internalDao {

	protected String dataSourceInternal;
	
	//public SimpleJdbcTemplate simpleJdbcTemplate;

	protected Logger logger = Logger.getLogger(internalDao.class);

	protected final static Dialect dialect = Dialect.getDialect();

	protected String tableName;

	protected String key;

	protected String getKey(Class<?> clazz) {
		return ObjectUtil.isNullOrEmpty(key) ? ClassMetadata.getMetadata(clazz).getPrimaryKey() : key;
	}

	protected String getTable(Class<?> clazz) {
		return ObjectUtil.isNullOrEmpty(tableName) ? ClassMetadata.getMetadata(clazz).getTable() : tableName;
	}

	protected String getKey() {
		return this.key;
	}

	protected void setKey(String key) {
		this.key = key;
	}

	protected String getTableName() {
		return tableName;
	}

	protected void setTableName(String tableName) {
		this.tableName = tableName;
	}

	private int simpleBatch(String sql, SqlParameterSource[] sqlParameterSources) {
		int[] cnts = getSimpleJdbcTemplate().batchUpdate(sql, sqlParameterSources);
		int cntTotal = 0;
		for (int cnt : cnts) {
			cntTotal += cnt;
		}
		return cntTotal;
	}

	public internalDao() {
	}

	public internalDao(String tableName, String key) {
		this.tableName = tableName;
		this.key = key;
	}

	protected <T> int insert(Class<?> clazz, T t, String... properties) {
		if (t == null || clazz == null) {
			return 0;
		}
		String sql = SqlBuilder.createInsertString(clazz, getTable(clazz), properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(t, properties);
       
		return getSimpleJdbcTemplate().update(sql, sqlParameterSource);
	}
	
	protected <T> int insertWithKeyValue(Class<?> clazz, T t, String primayKeyValue,String... properties) {
		if (t == null || clazz == null) {
			return 0;
		}
		String sql = SqlBuilder.createInsertStringWithKeyValue(clazz, getTable(clazz),primayKeyValue, properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(t, properties);
       
		return getSimpleJdbcTemplate().update(sql, sqlParameterSource);
	}
	
	public int insert(Class<?> clazz, Map<String, Object> map, String... properties) {
		if (map == null || map.size() < 1 || clazz == null) {
			return 0;
		}
		String sql = SqlBuilder.createInsertString(clazz, getTable(clazz), properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSourceByMap(map, properties);
       
		return getSimpleJdbcTemplate().update(sql, sqlParameterSource);
	}

	protected <T> Number generatedKey(Class<?> clazz, T t, String[] properties) {
		return generatedKey(clazz, t, null, properties);
	}

	protected <T> Number generatedKey(Class<?> clazz, T t, String keyColumnName, String[] properties) {
		if (clazz == null || t == null || clazz == null) {
			return null;
		}
		String key = StringUtil.isNotEmpty(keyColumnName) ? keyColumnName : getKey(clazz);
		KeyHolder keyholder = new GeneratedKeyHolder();
		String sql = SqlBuilder.createInsertString(clazz, getTable(clazz), properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(t, properties);
		String[] keyColumnNames = StringUtil.isNotEmpty(key) ? new String[] { keyColumnName } : null;
       
		getSimpleJdbcTemplate().getNamedParameterJdbcOperations().update(sql, sqlParameterSource, keyholder, keyColumnNames);
		return keyholder.getKey();
	}

	protected <T> int batchEntityInsert(Class<?> clazz, List<T> list, String... properties) {
		if (list == null || list.size() < 1 || clazz == null) {
			return 0;
		}
		String sql = SqlBuilder.createInsertString(clazz, getTable(clazz), properties);
		SqlParameterSource[] sqlParameterSources = SqlBuilder.getSqlParameterSources(list, properties);
		return simpleBatch(sql, sqlParameterSources);
	}
	
	protected <T> int batchEntityInsertWithKeyValue(Class<?> clazz, List<T> list,String primayKeyValue, String... properties) {
		if (list == null || list.size() < 1 || clazz == null) {
			return 0;
		}
		String sql = SqlBuilder.createInsertStringWithKeyValue(clazz, getTable(clazz),primayKeyValue, properties);
		SqlParameterSource[] sqlParameterSources = SqlBuilder.getSqlParameterSources(list, properties);
		return simpleBatch(sql, sqlParameterSources);
	}

	protected <T> int batchMapInsert(Class<T> clazz, List<? extends Map<String, Object>> list, String... properties) {
		if (list == null || list.size() < 1 || clazz == null) {
			return 0;
		}
		String sql = SqlBuilder.createInsertString(clazz, getTable(clazz), properties);
		SqlParameterSource[] sqlParameterSources = SqlBuilder.getSqlParameterSourcesByMap(list, properties);
		//Random r = new Random(10);		 
		return simpleBatch(sql, sqlParameterSources);
	}

	@SuppressWarnings("unchecked")
	public <PK> int delete(Class<?> clazz, PK... pKeys) {
		if (clazz == null) {
			return 0;
		}
		Criteria criteria = pKeys == null || pKeys.length < 1 ? null : pKeys.length == 1 ? new Criteria(getKey(clazz), pKeys[0]) : new Criteria(getKey(clazz), OP.IN, pKeys);
		Object[] args = pKeys != null && pKeys.length == 1 ? new Object[] { pKeys[0] } : null;
		String sql = SqlBuilder.createDeleteString(clazz, getTable(clazz), criteria);
       
		return this.getSimpleJdbcTemplate().update(sql, args);
	}

	public int delete(Class<?> clazz, Criteria criteria) {
		if (clazz == null) {
			return 0;
		}
		String sql = SqlBuilder.createDeleteString(clazz, getTable(clazz), criteria);
       
		return this.getSimpleJdbcTemplate().update(sql, SqlBuilder.getSqlParameterSource(criteria));
	}

	public <T> int update(Class<?> clazz, T t, String... properties) {
		if (t == null || clazz == null) {
		}
		String sql = SqlBuilder.createUpdateString(clazz, getTable(clazz), getKey(clazz), properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(t, getUpdateProperties(clazz, properties));
       
		return this.getSimpleJdbcTemplate().update(sql, sqlParameterSource);
	}

	public int update(Class<?> clazz, Map<String, Object> map, String... properties) {
		if (map == null || map.size() < 1 || clazz == null) {
		}
		String sql = SqlBuilder.createUpdateString(clazz, getTable(clazz), getKey(clazz), properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSourceByMap(map, getUpdateProperties(clazz, properties));
       
		return this.getSimpleJdbcTemplate().update(sql, sqlParameterSource);
	}

	public int update(Class<?> clazz, Parameters parameters, Criteria criteria) {
		if (clazz == null || parameters == null) {
			return 0;
		}
		String sql = SqlBuilder.createUpdateString(clazz, getTable(clazz), parameters, criteria);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
       
		return this.getSimpleJdbcTemplate().update(sql, sqlParameterSource);
	}

	public <T> int batchEntityUpdate(Class<?> clazz, List<T> list, String... properties) {
		if (list == null || list.size() < 1 || clazz == null) {
			return 0;
		}
		String sql = SqlBuilder.createUpdateString(clazz, getTable(clazz), getKey(clazz), properties);
		SqlParameterSource[] sqlParameterSources = SqlBuilder.getSqlParameterSources(list, getUpdateProperties(clazz, properties));
		return simpleBatch(sql, sqlParameterSources);
	}

	private String[] getUpdateProperties(Class<?> clazz, String... properties) {
		if (ObjectUtil.isNullOrEmpty(properties)) {
			return null;
		}
		ClassMetadata cMetadata = ClassMetadata.getMetadata(clazz);
		LinkedHashMap<String, PropertyMetadata> pMetadata = cMetadata.getProperty();
		LinkedHashMap<String, String> columns = cMetadata.getColumns();
		String cKey = getKey(clazz);
		String pKey = pMetadata.containsKey(cKey) ? pMetadata.get(cKey).getName() : columns.containsKey(cKey.toUpperCase()) ? pMetadata.get(columns.get(cKey.toUpperCase()))
				.getName() : cKey;
		return ArrayUtil.contains(properties, pKey) ? properties : ArrayUtil.add(properties, pKey);
	}

	public int batchMapUpdate(Class<?> clazz, List<? extends Map<String, Object>> list, String... properties) {
		if (list == null || list.size() < 1 || clazz == null) {
			return 0;
		}
		String sql = SqlBuilder.createUpdateString(clazz, getTable(clazz), getKey(clazz), properties);
		SqlParameterSource[] sqlParameterSources = SqlBuilder.getSqlParameterSourcesByMap(list, getUpdateProperties(clazz, properties));
		return simpleBatch(sql, sqlParameterSources);
	}

	public <T, PK> T get(Class<T> clazz, PK id) {
		if (id == null || clazz == null) {
			return null;
		}
		Criteria criteria = new Criteria(getKey(clazz), id);
		String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), criteria, null);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return get(clazz, sql, sqlParameterSource);
	}

	public <T> T get(Class<T> clazz, Criteria criteria, String... properties) {
		if (clazz == null) {
			return null;
		}
		String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), criteria, null, properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return get(clazz, sql, sqlParameterSource);
	}

	public Map<String, Object> getMap(Class<?> clazz, Criteria criteria, String... properties) {
		if (clazz == null) {
			return null;
		}
		String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), criteria, null, properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return getMap(sql, sqlParameterSource);
	}

	// public
	protected int execute(String sql) {
       
		return getSimpleJdbcTemplate().update(sql);
	}

	// public
	protected int delete(String sql) {
       
		return this.getSimpleJdbcTemplate().update(sql);
	}

	// public
	protected <T> int batchInsert(String sql, List<T> list, String... properties) {
		if (list == null || list.size() < 1) {
			return 0;
		}
		SqlParameterSource[] sqlParameterSources = SqlBuilder.getSqlParameterSources(list, properties);
		return simpleBatch(sql, sqlParameterSources);
	}

	// public
	protected <T> T get(Class<T> clazz, String sql, SqlParameterSource sqlParameterSource) {
		try {
           
			List<T> list = getSimpleJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(clazz), sqlParameterSource);
			return list.size() > 0 ? list.get(0) : null;
		} catch (DataAccessException ex) {
			throw ex;
		}
	}

	// public
	protected Map<String, Object> getMap(String sql, SqlParameterSource sqlParameterSource) {
		try {
           
			return getSimpleJdbcTemplate().queryForMap(sql, sqlParameterSource);
		} catch (DataAccessException ex) {
			throw ex;
		}
	}

	// public
	protected <T> List<T> getList(Class<T> clazz, String sql, SqlParameterSource sqlParameterSource) {
		try {
           
			if (sqlParameterSource == null) {
				return getSimpleJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(clazz));
			}
			return getSimpleJdbcTemplate().query(sql, BeanPropertyRowMapper.newInstance(clazz), sqlParameterSource);
		} catch (DataAccessException ex) {
			throw  ex;
		}
	}

	public <T> List<T> getAll(Class<T> clazz) {
		if (clazz == null) {
			return null;
		}
		String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), null, null);
		return getList(clazz, sql, null);
	}

	public <T> List<T> getList(Class<T> clazz, Criteria criteria, String... properties) {
		return getList(clazz, criteria, null, properties);
	}

	public <T> List<T> getList(Class<T> clazz, Criteria criteria, Order order, String... properties) {
		if (clazz == null) {
			return null;
		}
		String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), criteria, order, properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return getList(clazz, sql, sqlParameterSource);
	}

	// public
	protected List<Map<String, Object>> getMapList(String sql, SqlParameterSource sqlParameterSource) {
		if (StringUtil.isNullOrEmpty(sql)) {
			return null;
		}
       
		if (sqlParameterSource == null)
			return getSimpleJdbcTemplate().queryForList(sql);
		return getSimpleJdbcTemplate().queryForList(sql, sqlParameterSource);
	}

	public List<Map<String, Object>> getMapList(Class<?> clazz, Criteria criteria, String... properties) {
		return getMapList(clazz, criteria, null, properties);
	}

	public List<Map<String, Object>> getMapList(Class<?> clazz, Criteria criteria, Order order, String... properties) {
		if (clazz == null) {
			return null;
		}
		String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), criteria, order, properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		return getMapList(sql, sqlParameterSource);
	}

	public <T> PageList<T> getPageList(Class<T> clazz, Page page, Criteria criteria, String... properties) {
		return getPageList(clazz, page, criteria, null, properties);
	}

	public <T> PageList<T> getPageList(Class<T> clazz, Page page, Criteria criteria, Order order, String... properties) {
		if (clazz == null || page == null) {
			return null;
		}
		// String nSql=null;
		String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), criteria, order, properties);
		String nSql = dialect.getLimitString(sql, page.getStartRow(), page.getPageSize());
		SqlParameterSource sqlParameterSource = getPageSqlParameterSource(nSql, clazz, page, criteria, order, properties);
		return new PageList<T>(getList(clazz, nSql, sqlParameterSource), page);
	}

    public <T> PageList<T> getPageListForSingleTable(Class<T> clazz, Page page, Criteria criteria, Order order, String... properties) {
        if (clazz == null || page == null) {
            return null;
        }
        // String nSql=null;
        String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), criteria, order, properties);
        String nSql = getLimitStringForSingleTable(sql, page.getStartRow(), page.getPageSize());
        //String nSql = dialect.getLimitString(sql, page.getStartRow(), page.getPageSize());
        SqlParameterSource sqlParameterSource = getPageSqlParameterSource(nSql, clazz, page, criteria, order, properties);
        return new PageList<T>(getList(clazz, nSql, sqlParameterSource), page);
    }

    private String getLimitStringForSingleTable(String sql, int startRow, int pageSize) {
        String preSql = "";
        if(sql.indexOf("WHERE") > -1){
            preSql = sql.substring(0, sql.indexOf("WHERE"));
        }else{
            if(sql.indexOf("ORDER") > -1){
                preSql = sql.substring(0, sql.indexOf("ORDER"));
            }else{
                preSql =sql;
            }
        }

        String endSql = sql.substring(sql.indexOf("FROM"));
        StringBuffer pagingSelect = new StringBuffer();
        pagingSelect.append(preSql+" ");
        pagingSelect.append("WHERE ROWID IN ( SELECT rid FROM ( SELECT ROWNUM r1, rid FROM (SELECT ROWID rid ");
        pagingSelect.append(endSql);
        pagingSelect.append(" ) WHERE ROWNUM <= ");
        pagingSelect.append(startRow+pageSize);
        pagingSelect.append(" ) WHERE r1 >= "+startRow+")");
        return   pagingSelect.toString();
    }

    private <T> SqlParameterSource getPageSqlParameterSource(String nSql, Class<T> clazz, Page page, Criteria criteria, Order order, String... properties) {
		String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), criteria, null, properties);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		StringBuilder cSql = new StringBuilder("SELECT COUNT(*) FROM ( ").append(sql).append(" )");
       
		int rowCounts = getSimpleJdbcTemplate().queryForInt(cSql.toString(), sqlParameterSource);
		page.setTotalRows(rowCounts);
		sql = SqlBuilder.createSelectString(clazz, getTable(clazz),
		criteria,order, properties);
		nSql = dialect.getLimitString(sql, page.getStartRow(),
		page.getPageSize());
		return sqlParameterSource;
	}

	public PageList<Map<String, Object>> getPageMapList(Class<?> clazz, Page page, Criteria criteria, String... properties) {
		return getPageMapList(clazz, page, criteria, null, properties);
	}

	public PageList<Map<String, Object>> getPageMapList(Class<?> clazz, Page page, Criteria criteria, Order order, String... properties) {
		if (clazz == null || page == null) {
			return null;
		}
		// String nSql=null;
		String sql = SqlBuilder.createSelectString(clazz, getTable(clazz), criteria, order, properties);
		String nSql = dialect.getLimitString(sql, page.getStartRow(), page.getPageSize());
		SqlParameterSource sqlParameterSource = getPageSqlParameterSource(nSql, clazz, page, criteria, order, properties);
		return new PageList<Map<String, Object>>(getMapList(nSql, sqlParameterSource), page);
	}

	public <T extends Number> T getCount(Class<?> clazz, Criteria criteria, String countPropertyName, Class<T> requiredType) {
		return getSingle(clazz, criteria, "COUNT", countPropertyName, requiredType);
	}

	public <T extends Number> T getSum(Class<?> clazz, Criteria criteria, String sumPropertyName, Class<T> requiredType) {
		return getSingle(clazz, criteria, "SUM", sumPropertyName, requiredType);
	}

	public <T extends Number> T getMin(Class<?> clazz, Criteria criteria, String minPropertyName, Class<T> requiredType) {
		return getSingle(clazz, criteria, "MIN", minPropertyName, requiredType);
	}

	public <T extends Number> T getMax(Class<?> clazz, Criteria criteria, String maxPropertyName, Class<T> requiredType) {
		return getSingle(clazz, criteria, "MAX", maxPropertyName, requiredType);
	}

	public <N extends Number> N getSequenceNextVal(String sequenceName, Class<N> requiredType) {
		if (StringUtil.isNullOrEmpty(sequenceName) || requiredType == null) {
			return null;
		}
		String sql = dialect.getSequenceNextValString(sequenceName);
		SqlParameterSource sqlParameterSource = null;
		try {
           
			return getSimpleJdbcTemplate().getNamedParameterJdbcOperations().queryForObject(sql.toString(), sqlParameterSource, requiredType);
		} catch (DataAccessException ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
	}

	protected <T extends Number> T getSingle(Class<?> clazz, Criteria criteria, String funName, String pName, Class<T> requiredType) {
		if (clazz == null || StringUtil.isNullOrEmpty(funName) || StringUtil.isNullOrEmpty(pName)) {
			return null;
		}
		StringBuilder sql = new StringBuilder("SELECT ").append(funName).append("(");
		SqlBuilder.buildSingleColumnString(clazz, criteria, getTable(clazz), pName, sql);
		SqlParameterSource sqlParameterSource = SqlBuilder.getSqlParameterSource(criteria);
		try {
            //setSimpleJdbcTemplate();
			return getSimpleJdbcTemplate().getNamedParameterJdbcOperations().queryForObject(sql.toString(), sqlParameterSource, requiredType);
		} catch (DataAccessException ex) {
			logger.error(ex.getMessage(), ex);
			throw ex;
		}
	}

    protected SimpleJdbcTemplate getSimpleJdbcTemplate() {
            return DbContextHolder.getJdbcTmplate();
    }
}