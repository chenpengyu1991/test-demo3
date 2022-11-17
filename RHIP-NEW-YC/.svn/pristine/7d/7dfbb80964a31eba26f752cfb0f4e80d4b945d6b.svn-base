package com.founder.rhip.portal.repository;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.portal.PollOption;
import com.founder.rhip.ehr.entity.portal.SurveyItem;
import com.founder.rhip.ehr.entity.portal.SurveyOption;
import com.founder.rhip.ehr.repository.portal.IPollOptionDao;

/**
 * DAO implement of PollOption
 * 
 */
@Repository("lhpollOptionDao")
public class PollOptionDaoImpl extends AbstractDao<PollOption, Long> implements IPollOptionDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<PollOption> getPollOptionList(Long itemId) {
		String sql = "SELECT ITEM_ID,VALUE,COUNT(VALUE) AS COUNT FROM POLL_OPTION GROUP BY ITEM_ID, VALUE HAVING ITEM_ID="+itemId+"ORDER BY VALUE";
		return this.getList(sql);
	}

	@Override
	public List<PollOption> getOptionCountLists(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select value,poll_id, item_id,count(poll_id) as select_num ");
		sb.append(" from poll_option where poll_id in ( ");
		sb.append(" select id from Survey_Option where item_id in ( ");
		sb.append(" select id from Survey_Item ");
		SqlBuilder.buildWhereStatement(SurveyItem.class, sb, criteria);
		sb.append(" )) group by value, poll_id, item_id ");
		sb.append(" order by poll_id, item_id ");
		List<PollOption> getOptionCountLists = this.getList(sb.toString(), criteria);
		return getOptionCountLists;
	}

	@Override
	public List<PollOption> optionCountByItemLists(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select item_id, count(item_id) as counts ");
		sb.append(" from poll_option where poll_id in ( ");
		sb.append(" select id from Survey_Option where item_id in ( ");
		sb.append(" select id from Survey_Item ");
		SqlBuilder.buildWhereStatement(SurveyItem.class, sb, criteria);
		sb.append(" )) group by item_id ");
		sb.append(" order by item_id ");
		List<PollOption> optionCountByItemLists = this.getList(sb.toString(), criteria);
		return optionCountByItemLists;
	}
}