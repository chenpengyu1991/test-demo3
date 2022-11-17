package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.idm.special.EventInfo;
import com.founder.rhip.ehr.entity.management.mhm.MhmPhysicalExamination;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of MhmPhysicalExamination
 * 
 */
@Repository("mhmPhysicalExaminationDao")
public class MhmPhysicalExaminationDaoImpl extends AbstractDao<MhmPhysicalExamination, Long> implements IMhmPhysicalExaminationDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 查询健康体检列表
     * @param       criteria
     * @return      PageList<MhmEmergency>
     */
    public PageList<MhmPhysicalExamination> findList(Criteria criteria,Page page){
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT  * ");
        sql.append(" FROM MHM_PHYSICAL_EXAMINATION  WHERE EVENT_ID IN ( ");
        sql.append(" SELECT ID FROM MHM_EVENT_INFO WHERE " );
        sql.append(criteria.toSql(ClassMetadata.getMetadata(EventInfo.class), ":"));
        sql.append(" )");
        SqlBuilder.buildOrderStatement(sql, "PHYSICAL_DT DESC, EXAMINATION_ORGAN_CODE DESC, ID DESC");
        return getPageList(page,sql.toString(), criteria);
    }
}