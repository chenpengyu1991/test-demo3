package com.founder.rhip.ehr.repository.control;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.DeathInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of DeathMedicineCertificate
 * 
 */
@Repository("deathInfoDao")
public class DeathInfoDaoImpl extends AbstractDao<DeathInfo, Integer> implements IDeathInfoDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


}