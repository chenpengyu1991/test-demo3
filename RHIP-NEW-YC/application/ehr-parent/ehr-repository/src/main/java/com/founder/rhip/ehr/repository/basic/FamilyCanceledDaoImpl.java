package com.founder.rhip.ehr.repository.basic;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.rhip.ehr.entity.basic.FamilyCanceledInfo;
import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of PersonInfo
 * 
 */
@Repository("familyCanceledDao")
public class FamilyCanceledDaoImpl extends AbstractDao<FamilyCanceledInfo, Long> implements IFamilyCanceledDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}