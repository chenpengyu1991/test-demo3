package com.founder.rhip.fds.repository;
import javax.annotation.Resource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;
import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.fds.entity.ServicePlan;


@Repository("servicePlanDao")
public class ServicePlanDaoImpl extends AbstractDao<ServicePlan, Long> implements IServicePlanDao {
	@Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
	
}
