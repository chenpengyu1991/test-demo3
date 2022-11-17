package com.founder.rhip.ehr.repository.ce;

import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.ce.ContinueEducation;

/**
 * Created by chen_wenbo on 2014/04/02.
 */
@Repository("continueEducationDao")
public class ContinueEducationDaoImpl extends AbstractDao<ContinueEducation, Long> implements IContinueEducationDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    private static final String SQL = "select STAFF_CODE from CONTINUE_EDUCATION %1$s group by STAFF_CODE ";
    
    public void save(ContinueEducation continueEducation){
    }
    
    public PageList<ContinueEducation> getPageStaffCodeList(Page page, Criteria criteria)
    {
    	StringBuilder sql = new StringBuilder(SQL);
    	StringBuilder whereBaseSQL = new StringBuilder();
    	SqlBuilder.buildWhereStatement(ContinueEducation.class, whereBaseSQL, criteria);
    	
    	sql.append(" order by STAFF_CODE desc");
    	
    	String lastSql = String.format(sql.toString(), whereBaseSQL);
    	
    	return this.getPageList(page, lastSql, criteria);
    }
}