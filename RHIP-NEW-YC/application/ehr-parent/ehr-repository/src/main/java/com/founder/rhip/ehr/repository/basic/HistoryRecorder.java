package com.founder.rhip.ehr.repository.basic;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.LinkedHashMap;
import org.springframework.aop.support.AopUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.PropertyMetadata;
import com.founder.fasf.repository.IDao;
import com.founder.fasf.repository.JdbcTemplateCache;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.fasf.util.DateUtil;
import com.founder.fasf.util.StringUtil;

/**
 * 保存表行历史记录
 * 
 * @author liuk
 * @since 2014年1月13日 11:13:55
 */
public class HistoryRecorder {

	/**
	 * 历史记录表后缀
	 */
	public static final String HISTORY_TABLE_SUFFIX = "_RH";

	/**
	 * 记录时间字段名
	 */
	public static final String RECORD_CHANGE_TIME_COLUMN = "RECORD_CHANGE_TIME";
	/**
	 * The constant INSERT_SQL.
	 */
	// @foff
	private static final String INSERT_SQL_TEM =
	"INSERT INTO %1$s ("
			+ " %2$s "
			+ ",%3$s"
			+ ") SELECT "
			+ "	%2$s "
			+ "	,%4$s "
			+ " FROM "
			+ "	%5$s"
			+ " WHERE "
			+ "	%6$s";
	// @fon

	/**
	 * Record void.
	 * 
	 * @param dao
	 *            the dao
	 * @param criteria
	 *            the criteria
	 * @param recordProperties
	 *            the record properties
	 */
	public static void record(IDao dao, Criteria criteria, String[] recordProperties) {
		record(null, dao, criteria, recordProperties);
	}

	/**
	 * Record void.
	 * 
	 * @param clazz
	 *            the clazz
	 * @param dao
	 *            the dao
	 * @param criteria
	 *            the criteria
	 * @param recordProperties
	 *            the record properties
	 */
	public static void record(Class<?> clazz, IDao dao, Criteria criteria, String[] recordProperties) {
		Assert.notNull(dao, "dao  is required");
		Assert.notEmpty(recordProperties, "recordProperties  is required");

		// 当前dao实例有可能为代理,获取真实类
		Class<?> targetClass = getTargetClass(clazz, dao);

		SimpleJdbcTemplate jdbcTemplate = getSimpleJdbcTemplate(dao);
		Assert.notNull(jdbcTemplate, "can not get  simpleJdbcTemplate from the dao");

		ClassMetadata cMetadata = ClassMetadata.getMetadata(targetClass);
		// 更新和查询列
		StringBuilder selectColumns = new StringBuilder(" ");
		buildSelectColumn(recordProperties, selectColumns, cMetadata);
		String where = criteria.toSql(cMetadata, ":");

		String current = "to_date('" + DateUtil.toDateString(new Date(), "yyyy-MM-dd HH:mm:ss") + "','yyyy-mm-dd hh24:mi:ss')";
		String sql = String.format(getSql(), getRecordTableName(targetClass, cMetadata), selectColumns.toString(), RECORD_CHANGE_TIME_COLUMN, current, cMetadata.getTable(), where);

		jdbcTemplate.update(sql, SqlBuilder.getSqlParameterSource(criteria));
	}

	/**
	 * Build select column.
	 * 
	 * @param recordProperties
	 *            the record properties
	 * @param selectColumns
	 *            the select columns
	 * @param cMetadata
	 *            the c metadata
	 */
	private static void buildSelectColumn(String[] recordProperties, StringBuilder selectColumns, ClassMetadata cMetadata) {
		LinkedHashMap<String, PropertyMetadata> pMetadata = cMetadata.getProperty();
		LinkedHashMap<String, String> columns = cMetadata.getColumns();
		int i = 0;
		for (String property : recordProperties) {
			if (StringUtil.isNotEmpty(property)) {
				if (i > 0) {
					selectColumns.append(", ");
				}
				selectColumns.append(pMetadata.containsKey(property) ? pMetadata.get(property).getColumn() : columns.containsKey(property.toUpperCase()) ? pMetadata.get(columns.get(property.toUpperCase())).getColumn() : property);
				i++;
			}
		}
	}

	/**
	 * Gets sql.
	 * 
	 * @return the sql
	 */
	private static String getSql() {
		return INSERT_SQL_TEM;
	}

	/**
	 * Gets target class.
	 * 
	 * @param clazz
	 *            the clazz
	 * @param dao
	 *            the dao
	 * @return the target class
	 */
	private static Class<?> getTargetClass(Class<?> clazz, IDao dao) {
		if (null != clazz) {
			return clazz;
		}
		Class<?> daoClass = AopUtils.getTargetClass(dao);
		// 获取该dao对应的实体类
		return (Class<?>) ((ParameterizedType) daoClass.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Gets record table name.
	 * 
	 * @param targetClass
	 *            the target class
	 * @param cMetadata
	 *            the c metadata
	 * @return the record table name
	 */
	private static String getRecordTableName(Class<?> targetClass, ClassMetadata cMetadata) {
		// TODO 其他方式,实体注解等
		return cMetadata.getTable().concat(HISTORY_TABLE_SUFFIX);
	}

	/**
	 * SimpleJdbcTemplate
	 * 
	 * @param dao
	 *            the dao
	 * @return the SimpleJdbcTemplate
	 */
	private static SimpleJdbcTemplate getSimpleJdbcTemplate(IDao dao) {
		// TODO 目前取自缓存 L3
		Class<?> daoClass = AopUtils.getTargetClass(dao);
		SimpleJdbcTemplate simpleJdbcTemplate = JdbcTemplateCache.get(daoClass.getName());
		// 有可能该dao尚未使用过
		if (null == simpleJdbcTemplate) {
			dao.get(null);
		}
		simpleJdbcTemplate = JdbcTemplateCache.get(daoClass.getName());
		return simpleJdbcTemplate;
	}
}
