package com.founder.rhip.fds.repository;

import com.founder.rhip.fds.entity.SignServicePackage;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of SignServicePackage
 * 
 */
@Repository("signServicePackageDao")
public class SignServicePackageDaoImpl extends AbstractDao<SignServicePackage, Long> implements ISignServicePackageDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}