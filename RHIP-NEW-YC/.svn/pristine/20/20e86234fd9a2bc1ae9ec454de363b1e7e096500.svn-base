package com.founder.rhip.ehr.repository.wsMonitor;

import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceClient;

import java.util.List;

/**
 * DAO interface of WsServiceClient
 * 
 */
public interface IWsServiceClientDao extends IDao<WsServiceClient,Integer> {

    /**
     * 根据来访机器IP和接口名称获取WsServiceClient
     * @param wsServiceName 接口名称
     * @param ip 来访机器IP
     * @return
     */
    public List<WsServiceClient> getWsServiceClientList(String wsServiceName, String ip);
}