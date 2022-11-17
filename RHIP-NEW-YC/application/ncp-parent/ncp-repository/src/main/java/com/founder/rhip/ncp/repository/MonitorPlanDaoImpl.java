package com.founder.rhip.ncp.repository;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Order;
import com.founder.fasf.beans.Page;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.basic.PersonInfo;
import com.founder.rhip.ncp.entity.NcpMonitorPlan;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("ncpMonitorPlanDao")
public class MonitorPlanDaoImpl extends AbstractDao<NcpMonitorPlan,String> implements IMonitorPlanDao {

    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public List<NcpMonitorPlan> searchFollowupPlanList(Criteria criteria, Order order) {
        StringBuilder sql = new StringBuilder("select p.id,plan_date,plan_type,m.MONITOR_DATE,m.id monitor_id from ncp_monitor_plan p left join ncp_monitor m on p.id=m.plan_id ");
        ClassMetadata cMetadata = ClassMetadata.getMetadata(NcpMonitorPlan.class);
        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
            sql.append(" WHERE  ").append(criteria.toSql(cMetadata, ":", "p"));
        }
        /*sql.append(sql1);
        if(ObjectUtil.isNotEmpty(ylTypes)){
            sql.append(" and b.id in (SELECT T .person_id FROM sy_ehr_health_event T WHERE T .ehr_type = '"+ylTypes+"'"+")");
        }
        sql.append(resultSqlArray[0]);*/
        sql.append(order.toString());
        return this.getList(sql.toString(),criteria);
//        return this.getPageList(page, sql.toString(), criteria);
    }
}
