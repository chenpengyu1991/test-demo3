package com.founder.rhip.ehr.repository.wsMonitor;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ehr.entity.wsMonitor.WsClientInfo;

/**
 * DAO interface of WsClientInfo
 * 
 */
public interface IWsClientInfoDao extends IDao<WsClientInfo,Long> {

    /**
     * 统计客户访问次数
     * @param page
     * @param beginDate
     * @param endDate
     * @param criteria
     * @return
     */
    public PageList<WsClientInfo> getAccessMap(Page page, String beginDate, String endDate, Criteria criteria);
}