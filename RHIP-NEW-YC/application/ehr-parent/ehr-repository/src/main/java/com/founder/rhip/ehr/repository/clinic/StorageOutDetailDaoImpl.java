package com.founder.rhip.ehr.repository.clinic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.clinic.StorageOutDetail;

/**
 * DAO implement of StorageOutDetail
 * 
 */
@Repository("storageOutDetailDao")
public class StorageOutDetailDaoImpl extends AbstractDao<StorageOutDetail, Long> implements IStorageOutDetailDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}