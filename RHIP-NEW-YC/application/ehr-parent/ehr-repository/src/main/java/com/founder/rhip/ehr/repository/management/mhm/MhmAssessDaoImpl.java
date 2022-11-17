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
import com.founder.rhip.ehr.entity.management.mhm.MhmAssess;
import com.founder.rhip.ehr.entity.management.mhm.MhmCase;
import com.founder.rhip.ehr.repository.management.mhm.IMhmAssessDao;

/**
 * DAO implement of MhmAssess
 * 
 */
@Repository("mhmAssessDao")
public class MhmAssessDaoImpl extends AbstractDao<MhmAssess, Long> implements IMhmAssessDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	/**
     * 查询效果评估列表
     * @param       criteria
     * @return      PageList<MhmAssess>
     */
	public PageList<MhmAssess> findList(Criteria criteria,Page page){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ID,EVENT_ID,ASSESS_DT ");
		sql.append(" FROM MHM_ASSESS  WHERE EVENT_ID IN ( ");
		sql.append(" SELECT ID FROM MHM_EVENT_INFO WHERE " );
		sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
		sql.append(" )");
		SqlBuilder.buildOrderStatement(sql, " ASSESS_DT ASC");
		return getPageList(page,sql.toString(), criteria);		
	}    
}