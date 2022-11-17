package com.founder.rhip.ehr.repository.clinic;

import com.founder.fasf.beans.*;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.ObjectUtil;
import com.founder.rhip.ehr.entity.clinic.ExamineEvent;
import com.founder.rhip.ehr.entity.clinic.StudyEvent;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * DAO implement of ExamineEvent
 * 
 */
@Repository("examineQueryEventDao")
public class ExamineEventQueryDaoImpl extends AbstractDao<ExamineEvent, Long> implements IExamineEventQueryDao {
    @Resource(name = "msdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public PageList<ExamineEvent> getExamEventsWithIdCard(Page page, Criteria criteria, Order order){
        StringBuilder sql = new StringBuilder("SELECT S.EHR_ID, S.ID, S.PERSON_ID, S.NAME, S.CHECK_DATE, S.CHECK_LIST_TITLE, S.HOSPITAL_NAME, S.EXAMINATION_NUMBER, P.IDCARD\n" +
                "  FROM MS_EXAMINE_EVENT     S,\n" +
                "       V_PHB_BI_PERSON_INFO              P\n" +
                " WHERE S.PERSON_ID = P.ID(+)\n");
        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
            sql.append(" AND ");
            sql.append(criteria.toSql(ClassMetadata.getMetadata(ExamineEvent.class), ":"));
        }
        SqlBuilder.buildOrderStatement(sql, " S.ID DESC");
        PageList<ExamineEvent> pList = getPageList(page, sql.toString(), criteria);
        return pList;
    }

    public PageList<ExamineEvent> getIDMExamsResult(Page page, Criteria criteria){
        StringBuilder sql = new StringBuilder(" select distinct hospital_Code , name , gender, age, check_Date, visit_Status, detection_Room_Code, apply_Room_Code, apply_People_Name from "
                + " ( SELECT  e.*, d.DETECTION_ROOM_CODE, d.HBV_DNA_POSI, d.ALANINE_ASPARTATE,  d.SYPHILIS_POSI,  d.SPUTUM_SMEAR_POSI  FROM MS_EXAMINE_EVENT   e left join  MS_EXAMINE_DETAIL d on e.EHR_ID=d.EHR_ID and e.EXAMINATION_NUMBER = d.EXAMINATION_NUMBER ");
        if(ObjectUtil.isNotEmpty(criteria.getCriteria())){
            sql.append(" where ");
            sql.append(criteria.toSql(ClassMetadata.getMetadata(ExamineEvent.class), ":"));
        }
        sql.append(" and e.EXAMINATION_NUMBER is not null and e.EHR_ID is not null  ");
        SqlBuilder.buildOrderStatement(sql, " e.check_Date DESC");
        sql.append(" ) ");
        PageList<ExamineEvent> pList = getPageList(page, sql.toString(), criteria);
        return pList;
    }

}