package com.founder.rhip.ehr.repository.ihm;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.ihm.HmSimpleDisease;

import javax.annotation.Resource;

/**
 * DAO implement of HmSimpleDisease
 * 
 */
@Repository("hmSimpleDiseaseDao")
public class HmSimpleDiseaseDaoImpl extends AbstractDao<HmSimpleDisease, Long> implements IHmSimpleDiseaseDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}