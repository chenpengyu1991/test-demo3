package com.founder.rhip.portal.repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.portal.RegisterScheduleTime;
import com.founder.rhip.ehr.repository.portal.IRegisterScheduleTimeDao;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of Schedual
 * 
 */
@Repository("registerScheduleTimeDao")
public class RegisterScheduleTimeDaoImpl extends AbstractDao<RegisterScheduleTime, String> implements IRegisterScheduleTimeDao {

	@Resource(name = "portaldbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;
	
	@Override
	public int updateRegisterScheduleTime(Long id){
		int r=0;
		StringBuilder sb = new StringBuilder("update REGISTER_SCHEDULE_TIME set RESERVE_NUM=RESERVE_NUM+1");
//		sb.append(reserveNum);
		sb.append(" where ID =");
		sb.append(id);
		sb.append(" and RESERVE_NUM < ADMIT_NUM");
		r=execute(sb.toString());
		return r;
	}

}