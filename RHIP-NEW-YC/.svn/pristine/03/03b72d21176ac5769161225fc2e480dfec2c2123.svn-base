package com.founder.rhip.fds.repository;

import com.founder.rhip.fds.entity.Team;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of Team
 * 
 */
@Repository("teamDao")
public class TeamDaoImpl extends AbstractDao<Team, Integer> implements ITeamDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}