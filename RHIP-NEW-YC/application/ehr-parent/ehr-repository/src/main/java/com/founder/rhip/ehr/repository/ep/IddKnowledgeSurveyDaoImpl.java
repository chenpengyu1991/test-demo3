package com.founder.rhip.ehr.repository.ep;

import javax.annotation.Resource;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ep.IddKnowledgeSurvey;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * DAO implement of IddKnowledgeSurvey
 * 
 */
@Repository("iddKnowledgeSurveyDao")
public class IddKnowledgeSurveyDaoImpl extends AbstractDao<IddKnowledgeSurvey, Long> implements IIddKnowledgeSurveyDao {

	@Resource(name = "phbdbJDBCTemplate")
	protected SimpleJdbcTemplate simpleJdbcTemplate;
}