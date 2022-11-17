package com.founder.rhip.ehr.repository.women;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.women.ReserveMaternal;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of ReserveMaternal
 * 
 */
@Repository("reserveMaternalDao")
public class ReserveMaternalDaoImpl extends AbstractDao<ReserveMaternal, Long> implements IReserveMaternalDao {

    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

}