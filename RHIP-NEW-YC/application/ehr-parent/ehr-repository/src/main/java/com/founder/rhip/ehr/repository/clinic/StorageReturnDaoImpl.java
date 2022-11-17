package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.StorageReturn;

/**
 * DAO implement of StorageReturn
 * 
 */
@Repository("storageReturnDao")
public class StorageReturnDaoImpl extends AbstractDao<StorageReturn, Long> implements IStorageReturnDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}