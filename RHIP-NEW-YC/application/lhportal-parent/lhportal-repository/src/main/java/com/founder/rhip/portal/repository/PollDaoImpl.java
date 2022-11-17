package com.founder.rhip.portal.repository;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.portal.Poll;
import com.founder.rhip.ehr.repository.portal.IPollDao;

/**
 * DAO implement of Poll
 * 
 */
@Repository("lhpollDao")
public class PollDaoImpl extends AbstractDao<Poll, Long> implements IPollDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public PageList<Poll> getMyList(Page page, Criteria crita) {
		PageList<Poll> result = null;
    	if(!ObjectUtil.isNullOrEmpty(crita)){
    		StringBuilder sql =new StringBuilder("select distinct(survey_id) ");
    		SqlBuilder.buildWhereStatement(Poll.class, sql, crita);
    		result = this.getPageList(page, sql.toString(), crita);
    	}
    	return result;
	}
}