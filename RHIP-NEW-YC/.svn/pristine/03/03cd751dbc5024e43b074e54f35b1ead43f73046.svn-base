package com.founder.rhip.portal.repository;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.SurveyItem;
import com.founder.rhip.ehr.repository.portal.ISurveyItemDao;

/**
 * DAO implement of SurveyItem
 * 
 */
@Repository("lhsurveyItemDao")
public class SurveyItemDaoImpl extends AbstractDao<SurveyItem, Long> implements ISurveyItemDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}