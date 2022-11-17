package com.founder.rhip.ehr.repository.management.mhm;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.management.mhm.MhmDrug;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * 精神卫生报表查询
 * 
 */
@Repository("mhmStatisticsDao")
public class MhmStatisticsDaoImpl extends AbstractDao<MhmDrug, Long> implements IMhmStatisticsDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    @Override
    public PageList<MhmDrug> getDrugResult(Criteria criteria, Page page) {
        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT D.ID, D.DRUG_NAME, D.DRUG_FORM, D.DRUG_SPECIFICATIONS, U.CURRENT_PRICE ");
//        sql.append(" FROM MHM_DRUG D, ");
//        sql.append(" (SELECT DRUG_ID, SUM(CURRENT_PRICE) AS CURRENT_PRICE ");
//        sql.append(" FROM MHM_DRUG_USE ");
//        sql.append(" GROUP BY DRUG_ID) U ");
//        sql.append("   WHERE U.DRUG_ID = D.ID  ");
//        if(criteria.getCriteria()!= null && criteria.getCriteria().size() > 0){
//            sql.append(" AND ");
//            sql.append(criteria.toSql(ClassMetadata.getMetadata(MhmDrug.class), ":")).toString();
//        }
        sql.append("SELECT A.DRUG_NAME, A.DRUG_FORM,A.DRUG_SPECIFICATIONS, SUM(A.CURRENT_PRICE) AS CURRENT_PRICE ");
        sql.append(" FROM( ");
        sql.append(" SELECT D.DRUG_NAME, D.DRUG_FORM, D.DRUG_SPECIFICATIONS, U.* ");
        sql.append(" FROM MHM_DRUG_USE U, MHM_DRUG D WHERE U.DRUG_ID = D.ID ");
        sql.append(" ) A ");
        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, criteria) ;
        sql.append(" GROUP BY A.DRUG_NAME, A.DRUG_FORM,A.DRUG_SPECIFICATIONS,  A.DRUG_SPECIFICATIONS ");
        return this.getPageList(page, sql.toString(), criteria);
    }

    @Override
    public List<MhmDrug> getDrugList(Criteria criteria) {
        StringBuilder sql = new StringBuilder();
//        sql.append("SELECT D.ID, D.DRUG_NAME, D.DRUG_FORM, D.DRUG_SPECIFICATIONS, U.CURRENT_PRICE ");
//        sql.append(" FROM MHM_DRUG D, ");
//        sql.append(" (SELECT DRUG_ID, SUM(CURRENT_PRICE) AS CURRENT_PRICE ");
//        sql.append(" FROM MHM_DRUG_USE ");
////        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, criteria) ;
//        sql.append(" GROUP BY DRUG_ID) U ");
//        sql.append(" WHERE U.DRUG_ID = D.ID  ");
//        if(criteria.getCriteria()!= null && criteria.getCriteria().size() > 0){
//            sql.append(" AND ");
//            sql.append(criteria.toSql(ClassMetadata.getMetadata(MhmDrug.class), ":")).toString();
//        }
        sql.append("SELECT A.DRUG_NAME, A.DRUG_FORM,A.DRUG_SPECIFICATIONS, SUM(A.CURRENT_PRICE) AS CURRENT_PRICE ");
        sql.append(" FROM( ");
        sql.append(" SELECT D.DRUG_NAME, D.DRUG_FORM, D.DRUG_SPECIFICATIONS, U.* ");
        sql.append(" FROM MHM_DRUG_USE U, MHM_DRUG D WHERE U.DRUG_ID = D.ID ");
        sql.append(" ) A ");
        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, criteria) ;
        sql.append(" GROUP BY A.DRUG_NAME, A.DRUG_FORM,A.DRUG_SPECIFICATIONS,  A.DRUG_SPECIFICATIONS ");
        return this.getList(sql.toString(), criteria);
    }

    @Override
    public PageList<MhmDrug> getPatientResult(Criteria criteria, Page page) {
        Criteria criteriaDrug = (Criteria) criteria.get("criteriaDrug");
        Criteria criteriaPerson = (Criteria) criteria.get("criteriaPerson");

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT P.STATUS_ID, P.NAME, P.GENDER, P.AGE, P.IDCARD, P.DIAGNOSIS_CONTENT ,U.CURRENT_PRICE, U.MODIFY_ORGAN_TOWN  AS ORGAN_TOWN ");
        sql.append(" FROM ");
        sql.append(" (SELECT B.NAME, B.GENDER, B.AGE, B.IDCARD, D.DIAGNOSIS_CONTENT, S.ID AS STATUS_ID FROM MHM_EVENT_INFO E, MHM_BASICS_INFO B, MHM_DIAGNOSIS D, MHM_STATUS_INFO S ");
        sql.append(" WHERE B.EVENT_ID = E.ID AND B.EVENT_ID = D.EVENT_ID AND E.STATUS_ID = S.ID AND E.EVENT_TYPE = '2001' ");
        if(criteriaPerson.getCriteria().size()>0){
            sql.append(" AND ");
            sql.append(criteriaPerson.toSql(ClassMetadata.getMetadata(MhmDrug.class), ":")).toString();
        }
//        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, criteria);
        sql.append(" ) P, ");
        sql.append(" (SELECT STATUS_ID, MODIFY_ORGAN_TOWN, SUM(CURRENT_PRICE) AS CURRENT_PRICE FROM MHM_DRUG_USE ");
//        sql.append(criteriaDrug.toSql(ClassMetadata.getMetadata(MhmDrug.class), ":")).toString();
        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, criteriaDrug) ;
        sql.append(" GROUP BY STATUS_ID, MODIFY_ORGAN_TOWN ) U ");
        sql.append(" WHERE U.STATUS_ID = P.STATUS_ID ");
//        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, criteria) ;
        Criteria ca = new Criteria();
        ca.addAll(criteriaDrug);
        ca.addAll(criteriaPerson);
        return this.getPageList(page, sql.toString(), ca);
    }

    @Override
    public List<MhmDrug> getPatientList(Criteria criteria) {
        Criteria criteriaDrug = (Criteria) criteria.get("criteriaDrug");
        Criteria criteriaPerson = (Criteria) criteria.get("criteriaPerson");

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT P.STATUS_ID, P.NAME, P.GENDER, P.AGE, P.IDCARD, P.DIAGNOSIS_CONTENT ,U.CURRENT_PRICE, U.MODIFY_ORGAN_TOWN  AS ORGAN_TOWN ");
        sql.append(" FROM ");
        sql.append(" (SELECT B.NAME, B.GENDER, B.AGE, B.IDCARD, D.DIAGNOSIS_CONTENT, S.ID AS STATUS_ID FROM MHM_EVENT_INFO E, MHM_BASICS_INFO B, MHM_DIAGNOSIS D, MHM_STATUS_INFO S ");
        sql.append(" WHERE B.EVENT_ID = E.ID AND B.EVENT_ID = D.EVENT_ID AND E.STATUS_ID = S.ID AND E.EVENT_TYPE = '2001' ");
        if(criteriaPerson.getCriteria().size()>0){
            sql.append(" AND ");
            sql.append(criteriaPerson.toSql(ClassMetadata.getMetadata(MhmDrug.class), ":")).toString();
        }
//        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, criteria);
        sql.append(" ) P, ");
        sql.append(" (SELECT STATUS_ID, MODIFY_ORGAN_TOWN, SUM(CURRENT_PRICE) AS CURRENT_PRICE FROM MHM_DRUG_USE ");
//        sql.append(criteriaDrug.toSql(ClassMetadata.getMetadata(MhmDrug.class), ":")).toString();
        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, criteriaDrug) ;
        sql.append(" GROUP BY STATUS_ID, MODIFY_ORGAN_TOWN ) U ");
        sql.append(" WHERE U.STATUS_ID = P.STATUS_ID ");
//        SqlBuilder.buildWhereStatement(MhmDrug.class, sql, criteria) ;
        Criteria ca = new Criteria();
        ca.addAll(criteriaDrug);
        ca.addAll(criteriaPerson);
        return this.getList(sql.toString(), ca);
    }
}