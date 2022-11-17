package com.founder.rhip.ehr.repository.management.mhm;
import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmInhospital;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of MhmInhospital
 * 
 */
@Repository("mhmInhospitalDao")
public class MhmInhospitalDaoImpl extends AbstractDao<MhmInhospital, Long> implements IMhmInhospitalDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public PageList<MhmInhospital> findList(Criteria criteria,Page page){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT H.EVENT_ID, H.DISCHARGE_DATE ");
        sql.append(" FROM  MHM_INHOSPITAL H, MHM_EVENT_INFO E ");
        sql.append(" WHERE H.EVENT_ID = E.ID AND " );
        sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
        SqlBuilder.buildOrderStatement(sql, " DISCHARGE_DATE ASC");
        return getPageList(page,sql.toString(), criteria);
    }
}