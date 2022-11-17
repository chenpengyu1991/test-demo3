package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.control.idm.special.ListRr;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of IdmListRr
 * 
 */
@Repository("idmListRrDao")
public class ListRrDaoImpl extends AbstractDao<ListRr, Long> implements IListRrDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
	/**
     * 查看治疗记录列表
     * @param       criteria
     * @return      PageList<ListRr>
     */
	public PageList<ListRr> findAcographyList(Page page, Criteria criteria){
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT  listRr.ID,IDM_ID,TREATMENT_DOCTOR,TREATMENT_DT ");
		sql.append(" FROM IDM_LIST_RR listRr ");
		sql.append(" LEFT JOIN IDM_EVENT_INFO event ON event.ID = listRr.IDM_ID" );
		SqlBuilder.buildWhereStatement(EventInfo.class, sql, criteria) ;
		SqlBuilder.buildOrderStatement(sql, " TREATMENT_DT ASC");
		return getPageList(page,sql.toString(), criteria);
	}
}