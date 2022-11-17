package com.founder.rhip.ehr.repository.control.idm.special;

import com.founder.fasf.beans.ClassMetadata;
import com.founder.fasf.beans.Criteria;
import com.founder.fasf.beans.Page;
import com.founder.fasf.beans.PageList;
import com.founder.fasf.repository.AbstractDao;
import com.founder.fasf.repository.SqlBuilder;
import com.founder.fasf.util.StringUtil;
import com.founder.rhip.ehr.entity.control.idm.special.ListCc;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO implement of IdmListCc
 * 
 */
@Repository("idmListCcDao")
public class ListCcDaoImpl extends AbstractDao<ListCc, Long> implements IListCcDao {
    @Resource(name = "phbdbJDBCTemplate")
    private SimpleJdbcTemplate simpleJdbcTemplate;

    public PageList<ListCc> getCcListForSt(Page page, Criteria criteria) {
        PageList<ListCc> result = new PageList<ListCc>();
        StringBuilder sql = new StringBuilder();
        String town = (String) criteria.get("town");
        String village = (String) criteria.get("village");
        criteria.remove("town");
        criteria.remove("village");
        
        sql.append("SELECT C.* FROM IDM_LIST_CC C, IDM_STATUS_INFO S, IDM_EVENT_INFO E,MDM_ORGANIZATION ORG ");
        sql.append("WHERE C.IDM_ID = E.ID AND S.ID = E.STATUS_ID AND C.MODIFY_UNIT = ORG.ORGAN_CODE AND ");
        sql.append(criteria.toSql(ClassMetadata.getMetadata(ListCc.class), ":")).toString();
        if(StringUtil.isNotEmpty(town)){
        	sql.append(" and org.gb_code='" + town + "'");
        }
        if(StringUtil.isNotEmpty(village)){
        	sql.append(" and (org.organ_code='" + village + "' or org.PARENT_CODE ='" + village + "' )");
        }
        
        SqlBuilder.buildOrderStatement(sql, " C.PATIENT_NAME ASC, C.CHECK_DT ASC ");
        result = this.getPageList(page, sql.toString(), criteria);
        return result;
    }

    public List<ListCc> getCcListForSt1(Criteria criteria) {
        List<ListCc> result = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT C.* FROM IDM_LIST_CC C, IDM_STATUS_INFO S, IDM_EVENT_INFO E ");
        sql.append("WHERE C.IDM_ID = E.ID AND S.ID = E.STATUS_ID AND ");

        sql.append(criteria.toSql(ClassMetadata.getMetadata(ListCc.class), ":")).toString();

        SqlBuilder.buildOrderStatement(sql, " C.PATIENT_NAME ASC, C.CHECK_DT ASC ");

        result = this.getList(sql.toString(), criteria);

        return result;
    }
    
    /**
     * 麻风密切接触者统计 分页
     * @param page
     * @param criteria
     * @return
     */
    public PageList<ListCc> getCcListForLeprosySt(Page page, Criteria criteria) {
        PageList<ListCc> result = new PageList<ListCc>();
        result = this.getPageList(page, this.getSqlForLeprosySt(criteria), criteria);
        return result;
    }
    
    /**
     * 麻风密切接触者统计 不分页
     * @param page
     * @param criteria
     * @return
     */
    public List<ListCc> getCcListForLeprosySt(Criteria criteria) {
        List<ListCc> result = new ArrayList<ListCc>();
        result = this.getList(this.getSqlForLeprosySt(criteria), criteria);
        return result;
    }
    
    /**
     * 麻风密切接触者统计生成sql
     * @param criteria
     * @return
     */
    private String getSqlForLeprosySt(Criteria criteria) {
    	StringBuilder sql = new StringBuilder();
        sql.append("SELECT C.*, caseInfo.ACCEPT_TOWN FROM IDM_LIST_CC C, IDM_STATUS_INFO S, IDM_EVENT_INFO E , idm_case_information caseInfo");
        sql.append(" WHERE C.IDM_ID = E.ID AND S.ID = E.STATUS_ID ");
        //获取在上报疑似麻风时的上报时间和单位
        sql.append(" and caseInfo.Idm_Id in (select max(t2.id)  from  IDM_EVENT_INFO t2  where S.id=t2.STATUS_ID AND t2.event_id = '6001') and ");
        sql.append(criteria.toSql(ClassMetadata.getMetadata(ListCc.class), ":")).toString();
        SqlBuilder.buildOrderStatement(sql, " C.PATIENT_NAME ASC, C.REGIST_DT DESC ");
        return sql.toString();
    }
}