package com.founder.rhip.scheduling.repository;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.scheduling.entity.TaskHistory;

/**
 * 任务执行历史实现
 * 
 * @author liuk
 * 
 */
@Repository("TaskHistoryDao")
public class TaskHistoryDaoImpl extends AbstractDao<TaskHistory, Long> implements ITaskHistoryDao {
	@Resource(name = "phbdbJDBCTemplate")
	protected SimpleJdbcTemplate simpleJdbcTemplate;
}
