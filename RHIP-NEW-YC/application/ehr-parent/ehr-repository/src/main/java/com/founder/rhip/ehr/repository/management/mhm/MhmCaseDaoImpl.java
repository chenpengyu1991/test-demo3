package com.founder.rhip.ehr.repository.management.mhm;
import javax.annotation.Resource;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmCase;

/**
 * DAO implement of MhmCase
 * 
 */
@Repository("mhmCaseDao")
public class MhmCaseDaoImpl extends AbstractDao<MhmCase, Long> implements IMhmCaseDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	/**
     * 查询个案计划列表
     * @param       criteria
     * @return      PageList<MhmCase>
     */
	public PageList<MhmCase> findList(Criteria criteria,Page page){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ID,EVENT_ID,CREATE_DATE ");
		sql.append(" FROM MHM_CASE  WHERE EVENT_ID IN ( ");
		sql.append(" SELECT ID FROM MHM_EVENT_INFO WHERE " );
		sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
		sql.append(" )");
		SqlBuilder.buildOrderStatement(sql, " CREATE_DATE DESC");
		return getPageList(page,sql.toString(), criteria);		
	}    
}