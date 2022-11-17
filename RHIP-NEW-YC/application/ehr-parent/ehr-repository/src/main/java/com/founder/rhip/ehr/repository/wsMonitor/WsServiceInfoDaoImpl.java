package com.founder.rhip.ehr.repository.wsMonitor;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceInfo;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of WsServiceInfo
 * 
 */
@Repository("wsServiceInfoDao")
public class WsServiceInfoDaoImpl extends AbstractDao<WsServiceInfo, Long> implements IWsServiceInfoDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}