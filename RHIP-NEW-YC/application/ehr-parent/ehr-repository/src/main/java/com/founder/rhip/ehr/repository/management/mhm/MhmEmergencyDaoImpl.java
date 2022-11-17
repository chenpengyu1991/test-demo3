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
import com.founder.rhip.ehr.entity.management.mhm.MhmEmergency;
import com.founder.rhip.ehr.entity.management.mhm.MhmFollowup;
import com.founder.rhip.ehr.repository.management.mhm.IMhmEmergencyDao;

/**
 * DAO implement of MhmEmergency
 * 
 */
@Repository("mhmEmergencyDao")
public class MhmEmergencyDaoImpl extends AbstractDao<MhmEmergency, Long> implements IMhmEmergencyDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	/**
     * 查询应急处置列表
     * @param       criteria
     * @return      PageList<MhmEmergency>
     */
	public PageList<MhmEmergency> findList(Criteria criteria,Page page){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  ID,EVENT_ID,MODIFY_ORGAN_CODE,FILL_DATE ");
		sql.append(" FROM MHM_EMERGENCY  WHERE EVENT_ID IN ( ");
		sql.append(" SELECT ID FROM MHM_EVENT_INFO WHERE " );
		sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
		sql.append(" )");
		SqlBuilder.buildOrderStatement(sql, " MODIFY_ORGAN_CODE,FILL_DATE ASC");
		return getPageList(page,sql.toString(), criteria);		
	} 
}