package com.founder.rhip.ehr.repository.basic;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.repository.AbstractDao;
import com.founder.rhip.ehr.entity.basic.Question;

import javax.annotation.Resource;

/**
 * @ClassName: QuestionDaoImpl
 * @Description: 答疑实现类
 * @author LJY
 * @date 2013-8-1 下午3:53:07
 * 
 */
@Repository("questionDao")
public class QuestionDaoImpl extends AbstractDao<Question, Long> implements IQuestionDao {

	@Resource(name = "phbdbJDBCTemplate")
	private SimpleJdbcTemplate simpleJdbcTemplate;

}