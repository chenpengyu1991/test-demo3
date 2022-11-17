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
import com.founder.rhip.ehr.entity.management.mhm.MhmFollowup;
import com.founder.rhip.ehr.repository.management.mhm.IMhmFollowupDao;

/**
 * DAO implement of MhmFollowup
 * 
 */
@Repository("mhmFollowupDao")
public class MhmFollowupDaoImpl extends AbstractDao<MhmFollowup, Long> implements IMhmFollowupDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    
	/**
     * 查询随访列表
     * @param       criteria
     * @return      PageList<MhmFollowup>
     */
	public PageList<MhmFollowup> findList(Criteria criteria,Page page){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ID,EVENT_ID,fill_Organ_Code,FOLLOWUP_DT,FOLLOWUP_STATUS ");
		sql.append(" FROM MHM_FOLLOWUP  WHERE EVENT_ID IN ( ");
		sql.append(" SELECT ID FROM MHM_EVENT_INFO WHERE " );
		sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
		sql.append(" )");
		SqlBuilder.buildOrderStatement(sql, " FOLLOWUP_DT DESC,ID DESC");
		return getPageList(page,sql.toString(), criteria);		
	}

	/**
	 * 查询最近一次随访记录
	 */
	public MhmFollowup getLastFollowup(Criteria criteria){
		StringBuilder sql = new StringBuilder(" SELECT  ID,EVENT_ID,FOLLOWUP_DT,NEXT_FOLLOWUP_DT,FOLLOWUP_STATUS ");
		sql.append(" FROM MHM_FOLLOWUP  WHERE EVENT_ID IN ( ");
		sql.append(" SELECT ID FROM MHM_EVENT_INFO WHERE " );
		sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
		sql.append(" )");
		SqlBuilder.buildOrderStatement(sql, " FOLLOWUP_DT DESC,ID DESC");
		return get(sql.toString(), criteria);
	}
}