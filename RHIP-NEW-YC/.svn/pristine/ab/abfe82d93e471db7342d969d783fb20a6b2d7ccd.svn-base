package com.founder.rhip.portal.repository;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.ServiceInfo;
import com.founder.rhip.ehr.repository.portal.IServiceInfoDao;

/**
 * DAO implement of ServiceInfo
 * 
 */
@Repository("lhserviceInfoDao")
public class ServiceInfoDaoImpl extends AbstractDao<ServiceInfo, Long> implements IServiceInfoDao {
	@Resource(name = "portaldbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}