package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.StorageOut;

/**
 * DAO implement of StorageOut
 * 
 */
@Repository("storageOutDao")
public class StorageOutDaoImpl extends AbstractDao<StorageOut, Long> implements IStorageOutDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}