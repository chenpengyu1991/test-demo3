package com.founder.rhip.ehr.service.wsMonitor;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.wsMonitor.WsClientInfo;
import com.founder.rhip.ehr.entity.wsMonitor.WsOperationLog;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceClient;
import com.founder.rhip.ehr.entity.wsMonitor.WsServiceInfo;

import java.util.List;

/**
 * @author yejianfei
 */
public interface IWsServiceInfoService {

    public PageList<WsServiceInfo> getPageList(Page page, Criteria criteria, Order order, String... properties);

    public List<WsServiceInfo> getList(Criteria criteria, Order order, String... properties);


    /**
     * 根据来访机器IP和接口名称获取WsServiceClient
     * @param wsServiceName 接口名称
     * @param ip 来访机器IP
     * @return
     */
    public List<WsServiceClient> getWsServiceClientList(String wsServiceName, String ip);

    /**
     * 查询关联表
     * @param criteria
     * @return
     */
    public List<WsServiceClient> getWsServiceClientList(Criteria criteria);

    /**
     * 获取客户端对象
     * @param criteria
     * @return
     */
    public WsClientInfo getWsClientInfo(Criteria criteria);

    /**
     * 保存操作日志
     * @param wsOperationLog
     * @return
     */
    public Long saveWsOperationLog(WsOperationLog wsOperationLog);

    /**
     * 获取服务器端对象
     * @param criteria
     * @return
     */
    public WsServiceInfo getWsServiceInfo(Criteria criteria);

    /**
     * 保存服务器端对象
     * @param wsServiceInfo
     * @return
     */
    public Long saveWsServiceInfo(WsServiceInfo wsServiceInfo);

    /**
     * 修改服务端对象
     * @param wsServiceInfo
     * @param properties
     * @return
     */
    public Long editWsServiceInfo(WsServiceInfo wsServiceInfo, String properties);

    /**
     * 日志查询
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public PageList<WsOperationLog> getLogList(Page page, Criteria criteria, Order order);

    /**
     * 获取日志信息
     * @param criteria
     * @return
     */
    public WsOperationLog getWsOperationLog(Criteria criteria);

    /**
     * 删除
     * @param id
     */
    public void deleteService(Long id);

    /**
     * 获取服务访问数量
     * @param criteria
     * @return
     */
    public Long getServiceAccessCount(Criteria criteria);
}
