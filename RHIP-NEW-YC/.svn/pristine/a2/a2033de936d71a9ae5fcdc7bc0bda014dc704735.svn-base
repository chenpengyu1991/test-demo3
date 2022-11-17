package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.rhip.ehr.entity.control.idm.special.ListCc;
import com.founder.rhip.ehr.entity.control.idm.special.ListFr;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO implement of IdmListFr
 * 
 */
@Repository("idmListFrDao")
public class ListFrDaoImpl extends AbstractDao<ListFr, Long> implements IListFrDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;
    
    /**
     * 麻风随访统计 分页
     * @param page
     * @param criteria
     * @return
     */
    public PageList<ListFr> getFrListForLeprosySt(Page page, Criteria criteria){
    	PageList<ListFr> result = new PageList<ListFr>();
        result = this.getPageList(page, this.getSqlForLeprosySt(criteria), criteria);
        return result;
    }
    
    /**
     * 麻风随访统计 不分页
     * @param page
     * @param criteria
     * @return
     */
    public List<ListFr> getFrListForLeprosySt(Criteria criteria) {
    	List<ListFr> result = new ArrayList<ListFr>();
        result = this.getList(this.getSqlForLeprosySt(criteria), criteria);
        return result;
    }
    
    /**
     * 麻风随访统计所需sql
     * @param criteria
     * @return
     */
    private String getSqlForLeprosySt(Criteria criteria){
    	 StringBuilder sql = new StringBuilder();
         sql.append("SELECT fr.Id,fr.idm_id,fr.visit_dt,fr.check_user,fr.ulcer_hand,fr.ulcer_leg,fr.ulcer_ankle," +
         		"fr.ulcer_foot,fr.ulcer_toe,fr.ulcer_other,fr.leprosy,fr.leprosy_type,con.name name, " +
         		"con.age, con.gender, con.PA_ADDRESS, caseInfo.ACCEPT_TOWN FROM IDM_LIST_Fr fr, IDM_STATUS_INFO S, " +
         		"IDM_EVENT_INFO E , idm_case_information caseInfo, idm_general_condition con ");
         sql.append(" WHERE fr.IDM_ID = E.ID AND S.ID = E.STATUS_ID ");
         //获取在上报疑似麻风时的上报时间和单位
         sql.append("and caseInfo.Idm_Id in (select max(t2.id)  from  IDM_EVENT_INFO t2  where S.id=t2.STATUS_ID AND t2.event_id = '6001')");
         sql.append("and con.Idm_Id in (select max(t2.id)  from  IDM_EVENT_INFO t2  where S.id=t2.STATUS_ID AND t2.event_id = '6001') and ");
         sql.append(criteria.toSql(ClassMetadata.getMetadata(ListCc.class), ":")).toString();
         SqlBuilder.buildOrderStatement(sql, " con.name ASC, fr.visit_Dt DESC ");
         
         return sql.toString();
    }

    public void updatePaAddress2(String paStreet, String townName, String villageName){
        StringBuilder sql =  new StringBuilder();
        sql.append("UPDATE IDM_LIST_FR SET PA_ADDRESS = '"+townName+villageName+"'||PAHOUSE_NUMBER");
//        sql.append("UPDATE IDM_GENERAL_CONDITION SET PA_ADDRESS = REPLACE(PA_ADDRESS,'"+oldTown+"'"+" ,'"+newTown+"') ");
        sql.append(" WHERE PASTREET = " + "'" + paStreet + "'");
        this.execute(sql.toString());
    }
}