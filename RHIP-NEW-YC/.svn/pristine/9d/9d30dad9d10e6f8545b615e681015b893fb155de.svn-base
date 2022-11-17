package com.founder.rhip.ncp.service;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.rhip.ncp.dto.FollowDto;
import com.founder.rhip.ncp.entity.NcpMonitor;
import com.founder.rhip.ncp.entity.NcpMonitorPlan;

import java.util.List;
import java.util.Map;

public interface IFollowService {

    public PageList<FollowDto> searchFollowList(Page page, Criteria criteria);

    /**
     * 查询随访计划
     * @param criteria
     * @param  order
     * @return
     */
    List<NcpMonitorPlan> searchFollowupPlanList(Criteria criteria, Order order);

    NcpMonitor findMonitorById(Long id);

    NcpMonitorPlan findMonitorPlanById(Long id);

    boolean saveMonitor(NcpMonitor m);

    boolean saveMonitorPlan(NcpMonitorPlan p);

    Map<String,Object> searchQuickCnt(Criteria ca);

}
