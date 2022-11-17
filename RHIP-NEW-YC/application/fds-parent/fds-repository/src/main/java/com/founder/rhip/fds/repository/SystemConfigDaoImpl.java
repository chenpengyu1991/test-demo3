package com.founder.rhip.fds.repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.fds.entity.SystemConfig;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of Sign
 * 
 */
@Repository("systemConfigDao")
public class SystemConfigDaoImpl extends AbstractDao<SystemConfig, Long> implements ISystemConfigDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;


}