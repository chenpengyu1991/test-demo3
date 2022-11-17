package com.founder.rhip.portal.repository;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.portal.PollText;
import com.founder.rhip.ehr.entity.portal.SurveyItem;
import com.founder.rhip.ehr.entity.portal.SurveyOption;
import com.founder.rhip.ehr.repository.portal.IPollTextDao;

/**
 * DAO implement of PollText
 * 
 */
@Repository("lhpollTextDao")
public class PollTextDaoImpl extends AbstractDao<PollText, Long> implements IPollTextDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<PollText> getPollTextLists(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select * from poll_text where item_id in (");
		sb.append(" select id from Survey_Item ");
		SqlBuilder.buildWhereStatement(SurveyItem.class, sb, criteria);
		sb.append(" ) order by item_id, value ");
		List<PollText> getPollTextLists = this.getList(sb.toString(), criteria);
		return getPollTextLists;
	}
}