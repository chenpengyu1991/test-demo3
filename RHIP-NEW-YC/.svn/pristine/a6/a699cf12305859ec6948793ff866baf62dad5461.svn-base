package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import com.founder.rhip.ehr.entity.control.VaccinationEvent;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * DAO implement of StudyEvent
 * 
 */
@Repository("studyExamDao")
public class StudyExamDaoImpl extends AbstractDao<StudyEvent, Long> implements IStudyExamDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    /**
     * 综合管理 检查查询页面用(没有身份证)
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public PageList<StudyEvent> getStudyEvents1(Page page, Criteria criteria, Order order){
        StringBuilder sql = new StringBuilder("select S.ID, S.PERSON_ID, S.NAME, S.CHECK_DATE, S.INSPECTION_ITEM_NAME, S.HOSPITAL_NAME \n" +
                "  FROM MS_STUDY_EVENT S \n" );
//                " WHERE \n" +
//                "   S.EHR_ID = O.EHR_ID(+)");
//        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
//            sql.append(" AND ");
//            sql.append(criteria.toSql(ClassMetadata.getMetadata(StudyEvent.class), ":"));
//        }
        SqlBuilder.buildWhereStatement(StudyEvent.class, sql, criteria);
        SqlBuilder.buildOrderStatement(sql, " S.ID DESC");
        PageList<StudyEvent> pList = getPageList(page, sql.toString(), criteria);
        return pList;
    }

    /**
     * 综合管理 检查查询页面用(有身份证)
     * @param page
     * @param criteria
     * @param order
     * @return
     */
    public PageList<StudyEvent> getStudyEvents2(Page page, Criteria criteria, Order order){
        StringBuilder sql = new StringBuilder("SELECT S.ID, S.PERSON_ID, S.NAME, S.CHECK_DATE, S.INSPECTION_ITEM_NAME, S.HOSPITAL_NAME, P.IDCARD\n" +
                "  FROM MS_STUDY_EVENT     S,\n" +
                "       V_PHB_BI_PERSON_INFO              P\n" +
                " WHERE S.PERSON_ID = P.ID(+)\n");
        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
            sql.append(" AND ");
            sql.append(criteria.toSql(ClassMetadata.getMetadata(StudyEvent.class), ":"));
        }
        SqlBuilder.buildOrderStatement(sql, " S.ID DESC");
        PageList<StudyEvent> pList = getPageList(page, sql.toString(), criteria);
        return pList;
    }
}