package com.founder.rhip.ehr.repository.basic;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.basic.PersonInfoTemp;

/**
 * DAO implement of PersonInfo
 *
 */
@Repository("personInfoTempDao" )
public class PersonInfoTempDaoImpl extends AbstractDao<PersonInfoTemp, Long> implements IPersonInfoTempDao {
      
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

	public PageList<PersonInfoTemp> getPersonInfoTempPageList(Page page,Criteria criteria) {
		StringBuilder sql = new StringBuilder(" select s.* from BI_PERSON_INFO_TEMP s inner join BI_PERSON_INFO p on s.PERSON_INFO_ID=p.id ");
		
		SqlBuilder.buildWhereStatement(PersonInfoTemp.class, sql, criteria);
		SqlBuilder.buildOrderStatement(sql, "s.id");
		
		return this.getPageList(page, sql.toString(),criteria);
	}
}