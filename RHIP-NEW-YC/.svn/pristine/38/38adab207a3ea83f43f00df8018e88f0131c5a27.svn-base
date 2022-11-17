package com.founder.rhip.ehr.service.wsMonitor;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ehr.entity.wsMonitor.WsClientInfo;

import javax.servlet.http.HttpServletRequest;

/**
 * @author yejianfei
 */
public interface IWsClientInfoService {

    public PageList<WsClientInfo> getPageList(Page page, Criteria criteria, Order order, String... properties);

    /**
     * 获取客户端对象
     * @param criteria
     * @return
     */
    public WsClientInfo getWsClientInfo(Criteria criteria);

    /**
     * 修改客户端对象
     * @param wsClientInfo
     * @param properties
     * @return
     */
    public Long editWsClientInfo(WsClientInfo wsClientInfo, String properties);


    /**
     * 客户端访问统计
     * @param beginDate
     * @param endDate
     * @param criteria
     * @return
     */
    public PageList<WsClientInfo> getAccessMap(Page page, String beginDate, String endDate, Criteria criteria);

    /**
     * 修改客户端状态
     * @param orgCode
     * @param isOff
     * @return
     */
    public int changeOff(String orgCode, String isOff);

    /**
     * 保存客户器端对象
     * @param wsClientInfo
     * @return
     */
    public Long saveWsClientInfo(WsClientInfo wsClientInfo, String serviceIds, HttpServletRequest request);

    /**
     * 删除
     * @param id
     */
    public void deleteClient(Long id);
}
