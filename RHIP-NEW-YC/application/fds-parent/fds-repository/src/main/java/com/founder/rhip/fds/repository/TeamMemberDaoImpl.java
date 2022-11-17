package com.founder.rhip.fds.repository;

import com.founder.rhip.fds.entity.TeamMember;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;

import javax.annotation.Resource;

/**
 * DAO implement of TeamMember
 * 
 */
@Repository("teamMemberDao")
public class TeamMemberDaoImpl extends AbstractDao<TeamMember, Integer> implements ITeamMemberDao {
    @Resource(name = "fdsJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
}