package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.StorageIn;

/**
 * DAO implement of StorageIn
 * 
 */
@Repository("storageInDao")
public class StorageInDaoImpl extends AbstractDao<StorageIn, Long> implements IStorageInDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}