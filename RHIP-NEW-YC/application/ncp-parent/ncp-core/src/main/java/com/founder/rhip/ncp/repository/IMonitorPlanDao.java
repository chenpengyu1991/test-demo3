package com.founder.rhip.ncp.repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.IDao;
import com.founder.rhip.ncp.dto.FollowDto;
import com.founder.rhip.ncp.entity.NcpMonitor;
import com.founder.rhip.ncp.entity.NcpMonitorPlan;

import java.util.List;

public interface IMonitorPlanDao extends IDao<NcpMonitorPlan, String> {

    public List<NcpMonitorPlan> searchFollowupPlanList(Criteria criteria, Order order);

}
