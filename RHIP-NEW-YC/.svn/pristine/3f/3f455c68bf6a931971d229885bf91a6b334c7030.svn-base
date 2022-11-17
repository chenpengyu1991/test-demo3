package com.founder.rhip.ehr.repository.healtheducation;
import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.healtheducation.HeResourceRecord;
import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * DAO implement of HealthResourceRecord
 * 
 */
@Repository("heResourceRecordDao")
public class HeResourceRecordDaoImpl extends AbstractDao<HeResourceRecord, Long> implements IHeResourceRecordDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public PageList<HeResourceRecord> getHealthPositionPageList(Criteria criteria, Page page) {
		if (criteria == null) {
			return null;
		}
		String countSql = new StringBuilder(createSelectStatement(true)).append(createConditionStatement(criteria)).toString();
		int rowCounts = getSimpleJdbcTemplate().queryForInt(countSql);
		page.setTotalRows(rowCounts);
		String querySql = new StringBuilder(createSelectStatement(false)).append(createConditionStatement(criteria)).toString();
		String nSql = dialect.getLimitString(querySql, page.getStartRow(), page.getPageSize());
		List<HeResourceRecord> healthResourceRecords = getList(nSql, null);
	    return new PageList<HeResourceRecord>(healthResourceRecords, page);
	}
	
	private String createSelectStatement(boolean isCount) {
		StringBuilder sql = new StringBuilder("SELECT ");
		ClassMetadata cMetadata = ClassMetadata.getMetadata(HeResourceRecord.class);
		if (isCount) {
			sql.append(" COUNT(1) ");
		} else {
			int i = 0;
			LinkedHashMap<String, PropertyMetadata> pMetadata= cMetadata.getProperty();
			for (PropertyMetadata propertyMetada :pMetadata.values()) {
				if (!propertyMetada.isDbField()) {continue;}
				if (i > 0) {sql.append(", ");}
				sql.append(propertyMetada.getColumn());
				i++;
			}
			
		}
		sql.append(" FROM ").append(StringUtil.isNullOrEmpty(tableName) ? cMetadata.getTable() : tableName);
		sql.append(" WHERE RESOURCE_TYPE = '1' AND STATUS = '1'");
		return sql.toString();
	}
	
	private String createConditionStatement(Criteria criteria) {
		StringBuilder sb = new StringBuilder();
		if (criteria == null) {
			return sb.toString();
		}
		
		if (criteria.contains("contentType")) {
			String[] positionTypes = StringUtils.split(String.valueOf(criteria.get("contentType")), ",");
			List<String> positionList = Arrays.asList(positionTypes);
			sb.append(" AND (");
			for (Iterator<String> it = positionList.iterator(); it.hasNext();) {
				sb.append("CONTENT_TYPE LIKE '%");
				sb.append(it.next());
				sb.append("%'");
				if (it.hasNext()) {
					sb.append(" OR ");
				}
			}
			sb.append(")");
		}
		if (criteria.contains("positionType")) {
			sb.append(" AND POSITION_TYPE = '");
			sb.append(criteria.get("positionType"));
			sb.append("'");
		}
		if (criteria.contains("gbcode")) {
			sb.append(" AND GBCODE = '");
			sb.append(criteria.get("gbcode"));
			sb.append("'");
		}
		if (criteria.contains("orgCode")) {
			sb.append(" AND ORG_CODE = '");
			sb.append(criteria.get("orgCode"));
			sb.append("'");
		}
		if (criteria.contains("centerOrgCode")) {
			sb.append(" AND CENTER_ORG_CODE = '");
			sb.append(criteria.get("centerOrgCode"));
			sb.append("'");
		}
		sb.append(organizeDateConditionSQL(criteria));
		return sb.toString();
	}
	
	private String organizeDateConditionSQL(Criteria criteria) {
		if (criteria == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		if (criteria.contains("createBeginTime") && criteria.contains("createEndTime")) {
			sb.append(" AND USE_TIME BETWEEN TO_DATE('");
			sb.append(criteria.get("createBeginTime"));
			sb.append("', 'yyyy/MM/dd') AND TO_DATE('");
			sb.append(criteria.get("createEndTime"));
			sb.append("', 'yyyy/MM/dd')");
		} else {
			if (criteria.contains("createBeginTime")) {
				sb.append(" AND USE_TIME >= TO_DATE('");
				sb.append(criteria.get("createBeginTime"));
				sb.append("', 'yyyy/MM/dd')");
			} else if (criteria.contains("createEndTime")) {
				sb.append(" AND USE_TIME <= TO_DATE('");
				sb.append(criteria.get("createEndTime"));
				sb.append("', 'yyyy/MM/dd')");
			}
		}
		return sb.toString();	
	}
}