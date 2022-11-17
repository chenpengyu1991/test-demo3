package com.founder.rhip.ehr.repository.basic;
import com.founder.rhip.ehr.entity.basic.PersonMerge;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;
import java.util.List;


/**
 * DAO implement of PersonMerge
 * 
 */
@Repository("personMergeDao")
public class PersonMergeDaoImpl extends AbstractDao<PersonMerge, Long> implements IPersonMergeDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}