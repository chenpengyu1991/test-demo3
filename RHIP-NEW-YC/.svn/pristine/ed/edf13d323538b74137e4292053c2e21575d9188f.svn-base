package com.founder.rhip.portal.repository;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.portal.OutDoctor;
import com.founder.rhip.ehr.entity.portal.SurveyItem;
import com.founder.rhip.ehr.entity.portal.SurveyOption;
import com.founder.rhip.ehr.repository.portal.ISurveyOptionDao;

/**
 * DAO implement of SurveyOption
 * 
 */
@Repository("lhsurveyOptionDao")
public class SurveyOptionDaoImpl extends AbstractDao<SurveyOption, Long> implements ISurveyOptionDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public List<SurveyOption> getSurveyOptionsByItemIdLists(Criteria criteria) {
		StringBuilder sb = new StringBuilder("select * from Survey_Option where item_id in (");
		sb.append(" select id from Survey_Item ");
		SqlBuilder.buildWhereStatement(SurveyItem.class, sb, criteria);
		sb.append(" ) order by item_id, value ");
		List<SurveyOption> getSurveyOptionsByItemIdLists = this.getList(sb.toString(), criteria);
		return getSurveyOptionsByItemIdLists;
	}
}