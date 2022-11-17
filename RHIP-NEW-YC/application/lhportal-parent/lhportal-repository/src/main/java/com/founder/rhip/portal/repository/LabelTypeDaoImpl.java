package com.founder.rhip.portal.repository;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.LabelType;
import com.founder.rhip.ehr.repository.portal.ILabelTypeDao;

/**
 * DAO implement of LabelType
 * 
 */
@Repository("lhlabelTypeDao")
public class LabelTypeDaoImpl extends AbstractDao<LabelType, Long> implements ILabelTypeDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}