package com.founder.rhip.ehr.repository.clinic;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.Assert;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;

/**
 * DAO implement of ExamineEvent
 * 
 */
@Repository("examineEventDao")
public class ExamineEventDaoImpl extends AbstractDao<ExamineEvent, Long> implements IExamineEventDao {
	@Resource(name = "msdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

	private static final String SQL_WITHOUT_HIV =
//@foff		
		    "SELECT\n" +
		    "	*\n" +
		    "FROM\n" +
		    "	MS_EXAMINE_EVENT\n" +
		    "WHERE\n" +
		    "	(NVL (\n" +
		    "		MS_EXAMINE_EVENT.CHECK_LIST_TITLE,\n" +
		    "		'A'\n" +
		    "	) NOT LIKE '%艾滋%'\n" +
		    "OR EXISTS (\n" +
		    "	SELECT\n" +
		    "		MS_EXAMINE_DETAIL.\"ID\"\n" +
		    "	FROM\n" +
		    "		MS_EXAMINE_DETAIL\n" +
		    "	WHERE\n" +
		    "		MS_EXAMINE_EVENT.PERSON_ID = MS_EXAMINE_DETAIL.PERSON_ID\n" +
		    "	AND MS_EXAMINE_EVENT.EXAMINATION_NUMBER = MS_EXAMINE_DETAIL.EXAMINATION_NUMBER\n" +
		    "	AND MS_EXAMINE_EVENT.EHR_ID = MS_EXAMINE_DETAIL.EHR_ID\n" +
		    "	AND MS_EXAMINE_EVENT.CHECK_LIST_TITLE LIKE '%艾滋%'\n" +
		    "	AND MS_EXAMINE_DETAIL.INSPECTION_ITEM_NAME LIKE '%抗HIVI/II初筛实验%'\n" +
		    "	AND MS_EXAMINE_DETAIL.INSPECTION_RESULT LIKE '%阴性%'\n" +
		    ")) ";
		    //@fon
	@Override
	public List<ExamineEvent> getListWithoutHiv(Criteria criteria, Order order) {
//		StringBuilder sql = buildSql(criteria, order);
		return getList(criteria);
	}

	@Override
	public PageList<ExamineEvent> getPagedListWithoutHiv(Page page, Criteria criteria, Order order) {
//		StringBuilder sql = buildSql(criteria, order);
		return getPageList(page, criteria);
	}

	private StringBuilder buildSql(Criteria criteria, Order order) {
		StringBuilder sql = new StringBuilder(SQL_WITHOUT_HIV);
		StringBuilder whereBuilder = new StringBuilder();
		SqlBuilder.buildWhereStatement(ExamineEvent.class, whereBuilder, criteria);
		String where = whereBuilder.toString().replaceFirst("WHERE|where", "AND");
		sql.append(where);
		sql.append(" ");
		if (null!=order) {
			sql.append(order.toString());
		}
		return sql;
	}

	@Override
	public List<Map<String, Object>> getExamineEventMapList(String dateStr) {
		Assert.notNull(dateStr);
		StringBuilder sqlBuilder = new StringBuilder("select hospital_code,to_char(check_date, 'yyyy/MM/dd') rpDate,"
				+ "examination_code,count(1) EXAMINATION_NUM from ms_examine_event  where examination_code in('101','102')"
				+ " and to_char(gather_date,'yyyy/MM/dd')='").append(dateStr).append("' group by hospital_code, to_char(check_date, 'yyyy/MM/dd'),EXAMINATION_CODE");
		
		return getMapList(sqlBuilder.toString(), new Criteria());
	}

}