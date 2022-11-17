package com.founder.rhip.ehr.repository.wsMonitor;

import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceClient;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of WsServiceClient
 * 
 */
@Repository("wsServiceClientDao")
public class WsServiceClientDaoImpl extends AbstractDao<WsServiceClient, Integer> implements IWsServiceClientDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<WsServiceClient> getWsServiceClientList(String wsServiceName, String ip) {

        String sql = "select * from ws_service_client where %1$s" +
                " client_id in (select id from ws_client_info where user_ip = '%2$s' and is_off='1')";

        String serviceWhere  = "";
        if(StringUtil.isNotEmpty(wsServiceName)) {
            serviceWhere = " service_id in (select id from ws_service_info where web_service_name = '" + wsServiceName + "') and ";
        }
        return this.getList(String.format(sql, serviceWhere, ip));
    }
}