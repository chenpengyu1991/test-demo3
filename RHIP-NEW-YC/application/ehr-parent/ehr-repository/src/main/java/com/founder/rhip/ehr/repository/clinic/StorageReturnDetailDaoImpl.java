package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.StorageReturnDetail;

/**
 * DAO implement of StorageReturnDetail
 * 
 */
@Repository("storageReturnDetailDao")
public class StorageReturnDetailDaoImpl extends AbstractDao<StorageReturnDetail, Long> implements IStorageReturnDetailDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}