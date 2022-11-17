package com.founder.rhip.portal.repository;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.portal.Interaction;
import com.founder.rhip.ehr.repository.portal.IInteractionDao;

/**
 * DAO implement of Interaction
 * 
 */
@Repository("lhinteractionDao")
public class InteractionDaoImpl extends AbstractDao<Interaction, Long> implements IInteractionDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}